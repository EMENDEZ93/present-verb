package present.verb.dominio.hoja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.puerto.ExcelRepository;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.model.HojaDto;
import present.verb.dominio.hoja.port.GetHojaByExcelAndCorreoRepository;
import present.verb.dominio.temas.puerto.dao.GetHojasByExcelAndCorreoDao;
import present.verb.dominio.temas.puerto.dao.SaveHojasByExcelAndCorreoDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;
import static java.util.Objects.isNull;

@Service
public class GetHojasByExcelAndCorreoService {

    @Autowired
    private GetHojasByExcelAndCorreoDao getHojasByExcelAndCorreoDao;

    @Autowired
    private ExcelRepository excelRepository;

    @Autowired
    private SaveHojasByExcelAndCorreoDao saveHojasByExcelAndCorreoDao;

    @Autowired
    private GetHojaByExcelAndCorreoRepository getHojaByExcelAndCorreoRepository;

    public List<HojaDto> excecute(String excel, String correo) {
        List<HojaDto> hojas = getHojasByExcelAndCorreoDao.executer(excel, correo);
        if(hojas.isEmpty()) {
            saveHojasByExcelAndCorreoDao.executer(excel, correo);
            return getHojasByExcelAndCorreoDao.executer(excel, correo);
        }
        return hojas;
    }

    public List<HojaDto> excecutev2(String nombreExcel, String correo, int horaActual) {
        List<HojaDto> hojas = excecute(nombreExcel, correo);
        List<HojaDto> hojasAprendidas =  hojas.stream()
                .filter(hojaDto -> hojaDto.getUltimoIndiceAprendido() > 0 )
                .collect(Collectors.toList());
        Excel excel = getHojaByExcelAndCorreoRepository.executer(nombreExcel, correo);

        if("ACTUALIZAR".equalsIgnoreCase(excel.getEstado())) {
            extracted(horaActual, hojasAprendidas, excel);
        }

        return getHojasByExcelAndCorreoDao.executer(nombreExcel, correo);
    }

    private void extracted(int horaActual, List<HojaDto> hojasAprendidas, Excel excel) {
        if(
           (hojasAprendidas.size() > excel.getCantidadhojasPorRutina()
                   || excel.getCantidadhojasPorRutina() > excel.getHojas().size()
                   || excel.getCantidadhojasPorRutina() == excel.getHojas().size()
           )
           && excel.getActualizacionIndiceRepaso().isBefore(now())
        ) {
            List<Integer> idsPorRutina = new ArrayList<>();
            if(isNull(excel.getUltimoIndiceRepaso())) {
                int pivote = 0;
                while (idsPorRutina.size() < excel.getCantidadhojasPorRutina()) {
                    idsPorRutina.add(hojasAprendidas.get(pivote).getId());
                    pivote++;
                }
                excel.setUltimoIndiceRepaso(idsPorRutina.size() - 1);
            } else {
                int candidadIndicesReales = hojasAprendidas.size() - 1;
                int ultimoIndiceRepaso = excel.getUltimoIndiceRepaso();
                int ultimoId = ultimoIndiceRepaso + excel.getCantidadhojasPorRutina();
                int newultimoindiceCaso1 = excel.getUltimoIndiceRepaso() + excel.getCantidadhojasPorRutina() ;
                if(newultimoindiceCaso1 < candidadIndicesReales) {
                    while (ultimoIndiceRepaso < ultimoId) {
                        ultimoIndiceRepaso ++;
                        excel.setUltimoIndiceRepaso(ultimoIndiceRepaso);
                        idsPorRutina.add(hojasAprendidas.get(ultimoIndiceRepaso).getId());
                    }
                } else {
                    ultimoId = candidadIndicesReales - ultimoIndiceRepaso;
                    while (ultimoId != 0) {
                        ultimoIndiceRepaso ++;
                        excel.setUltimoIndiceRepaso(ultimoIndiceRepaso);
                        idsPorRutina.add(hojasAprendidas.get(ultimoIndiceRepaso).getId());
                        ultimoId = candidadIndicesReales - ultimoIndiceRepaso;
                    }
                }
                int newultimoindice = excel.getUltimoIndiceRepaso() + (excel.getCantidadhojasPorRutina() - 1) ;
                int faltandesTotales = candidadIndicesReales - newultimoindice;
                if(faltandesTotales <= 0) {
                    int pivoteF = 0;
                    while (idsPorRutina.size() < excel.getCantidadhojasPorRutina()) {
                        excel.setUltimoIndiceRepaso(pivoteF);
                        idsPorRutina.add(hojasAprendidas.get(pivoteF).getId());
                        pivoteF++;
                    }
                }
            }
            for (Integer integer : idsPorRutina) {
                for (Hoja hoja : excel.getHojas()) {
                    if (hoja.getId() == integer) {
                        hoja.setPorRutina(true);
                        hoja.setSpeaking(true);
                    }
                }
            }
            excel.setHoraActualizacionIndiceRepaso(horaActual);
            excel.setActualizacionIndiceRepaso(now());
            excel.setEstado("ACTUALIZADO");
            excelRepository.save(excel);
        }
    }
}
