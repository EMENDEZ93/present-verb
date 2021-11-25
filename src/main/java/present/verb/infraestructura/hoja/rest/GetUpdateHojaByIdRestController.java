package present.verb.infraestructura.hoja.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import present.verb.aplicacion.hoja.GetUpdateHojaByIdHandler;
import present.verb.dominio.hoja.model.Hoja;

@RestController
@CrossOrigin(origins = "*")
public class GetUpdateHojaByIdRestController {

    @Autowired
    private GetUpdateHojaByIdHandler getUpdateHojaByIdHandler;

    @GetMapping("/hoja/{idHoja}")
    public Hoja executer(@PathVariable int idHoja) {
        return getUpdateHojaByIdHandler.executer(idHoja);
    }

}
