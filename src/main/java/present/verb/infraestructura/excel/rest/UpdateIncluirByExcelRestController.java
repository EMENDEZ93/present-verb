package present.verb.infraestructura.excel.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import present.verb.aplicacion.excel.UpdateIncluirByIdExcelHandler;
import present.verb.dominio.excel.modelo.Excel;

@RestController
@CrossOrigin(origins = "*")
public class UpdateIncluirByExcelRestController {

    @Autowired
    private UpdateIncluirByIdExcelHandler updateIncluirByIdExcelHandler;

    @GetMapping("/excels/incluir/{idExcel}")
    public Excel update(@PathVariable int idExcel) {
        return updateIncluirByIdExcelHandler.update(idExcel);
    }

}
