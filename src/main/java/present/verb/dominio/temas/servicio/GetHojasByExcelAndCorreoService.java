package present.verb.dominio.temas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.puerto.ExcelRepository;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.model.HojaDto;
import present.verb.dominio.hoja.port.GetHojaByExcelAndCorreoRepository;
import present.verb.dominio.hoja.port.HojaRepository;
import present.verb.dominio.temas.puerto.dao.GetHojasByExcelAndCorreoDao;
import present.verb.dominio.temas.puerto.dao.SaveHojasByExcelAndCorreoDao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public List<HojaDto> excecutev2(String excel, String correo) {
        Excel excel1 = getHojaByExcelAndCorreoRepository.executer(excel, correo);

        System.out.println("*****************************************************");
        System.out.println(excel1.getActualizacionIndiceRepaso());

        if(excel1.getActualizacionIndiceRepaso().isBefore(now())) {
            List<HojaDto> hojas = excecute(excel, correo);
            List<HojaDto> hojasAprendidas =  hojas.stream()
                    .filter(hojaDto -> hojaDto.getUltimoIndiceAprendido() > 0 )
                    .collect(Collectors.toList());
            int ultimoIndiceRepaso = excel1.getUltimoIndiceRepaso();


            int restantes = ultimoIndiceRepaso;

            if(restantes == 0) {
                restantes = excel1.getCantidadhojasPorRutina();
            } else {
                restantes = (hojasAprendidas.size() - 1 - ultimoIndiceRepaso);
            }

            for (int indice = 0; indice < restantes; indice++) {
                ultimoIndiceRepaso++;
                for (Hoja hoja : excel1.getHojas()) {
                    if(hoja.getId() == hojasAprendidas.get(ultimoIndiceRepaso).getId()) {
                        hoja.setPorRutina(true);
                    }
                }
            }

            int reinicio = 0;
            if(restantes == 0) {
                reinicio = (excel1.getCantidadhojasPorRutina() - (hojasAprendidas.size() -1 - ultimoIndiceRepaso));
            } else {
                reinicio = (excel1.getCantidadhojasPorRutina() - (hojasAprendidas.size() - ultimoIndiceRepaso));
            }
            for (int indice = 0; indice < reinicio; indice++) {
                for (Hoja hoja : excel1.getHojas()) {
                    if(hoja.getId() == hojasAprendidas.get(indice).getId()) {
                        ultimoIndiceRepaso = indice;
                        hoja.setPorRutina(true);
                    }
                }
            }

            excel1.setUltimoIndiceRepaso(ultimoIndiceRepaso);
            excel1.setActualizacionIndiceRepaso(now());
            excelRepository.save(excel1);
        }
        return getHojasByExcelAndCorreoDao.executer(excel, correo);
    }
}
