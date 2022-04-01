package present.verb.dominio.hoja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.puerto.ExcelRepository;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.port.HojaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpdateSpeakingHojaByIdService {

    @Autowired
    private HojaRepository repository;

    @Autowired
    private ExcelRepository excelRepository;

    public Hoja executer(int idHoja) {

        Hoja hoja = repository.updateSpeakingById(idHoja);
        Excel excel = hoja.getExcel();
        int totalHojas = excel.getHojas().size();
        List<Hoja> hojasfinalizadas = excel
                .getHojas().stream().filter(hoja1 -> !hoja1.getPorRutina() && !hoja1.getSpeaking() )
                .collect(Collectors.toList());
        if(hojasfinalizadas.size() == totalHojas) {
            excel.setEstado("TERMINADO");
            excelRepository.save(excel);
        }
        hoja.setExcel(null);
        return hoja;

    }

}
