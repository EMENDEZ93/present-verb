package present.verb.aplicacion.excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.servicio.UpdateIncluirByIdExcelService;

@Component
public class UpdateIncluirByIdExcelHandler {

    @Autowired
    private UpdateIncluirByIdExcelService updateIncluirByIdExcelService;

    public Excel update(int idExcel) {
        return updateIncluirByIdExcelService.update(idExcel);
    }

}
