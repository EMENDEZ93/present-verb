package present.verb.infraestructura.excel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import present.verb.aplicacion.excel.GetAllExcelHandler;
import present.verb.dominio.excel.modelo.Excel;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GetAllExcelRestController {

    @Autowired
    private GetAllExcelHandler getAllExcelHandler;

    @GetMapping("/excels")
    public List<Excel> execute() {
        return getAllExcelHandler.executer();
    }

}
