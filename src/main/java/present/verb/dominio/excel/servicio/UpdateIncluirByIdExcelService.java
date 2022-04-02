package present.verb.dominio.excel.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.puerto.ExcelRepository;

@Service
public class UpdateIncluirByIdExcelService {

    @Autowired
    private ExcelRepository excelRepository;

    public Excel update(int idExcel) {
        return excelRepository.updateIncluirByIdExcel(idExcel);
    }

}
