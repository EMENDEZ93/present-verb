package present.verb.infraestructura.fila.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import present.verb.aplicacion.filas.GetFilasHandler;
import present.verb.dominio.fila.modelo.Fila;

@RestController
@CrossOrigin(origins = "*")
public class GetFilasRestController {

    @Autowired
    private GetFilasHandler getFilasHandler;

    @GetMapping("/filas/aprender/{idHoja}")
    public Fila executer(
            @PathVariable(value = "idHoja") int idHoja
    ) {
        return getFilasHandler.executer(idHoja);
    }

}
