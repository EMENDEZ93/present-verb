package present.verb.infraestructura.hoja.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import present.verb.aplicacion.temas.GetHojasByExcelAndCorreoCorreHandler;
import present.verb.dominio.hoja.model.HojaDto;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GetHojasByExcelAndCorreoRestController {

    @Autowired
    private GetHojasByExcelAndCorreoCorreHandler getHojasByExcelAndCorreoCorreHandler;

    @GetMapping("/hojas/{excel}/{correo}")
    public List<HojaDto> execute(@PathVariable String excel, @PathVariable String correo) {
        return getHojasByExcelAndCorreoCorreHandler.execute(excel, correo);
    }

}
