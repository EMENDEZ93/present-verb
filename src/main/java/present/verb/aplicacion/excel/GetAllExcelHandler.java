package present.verb.aplicacion.excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.servicio.GetAllExcelService;

import java.util.List;
import java.util.Set;

@Component
public class GetAllExcelHandler {

    @Autowired
    private GetAllExcelService getAllExcelService;

    public List<Excel> executer() {
        return getAllExcelService.executer();
    }


    public Set<Excel> executerByCorreo(String correo) {
        return getAllExcelService.executerByCorreo(correo);
    }

}
