package present.verb.infraestructura.fila.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import present.verb.aplicacion.filas.GetFilasAprenderHandler;
import present.verb.aplicacion.filas.GetFilasRutinaHandler;
import present.verb.dominio.fila.modelo.Fila;

@RestController
@CrossOrigin(origins = "*")
public class GetFilasRutinaRestController {

    @Autowired
    private GetFilasRutinaHandler getFilasRutinaHandler;

    @GetMapping("/filas/rutina/{idHoja}")
    public Fila executer(
            @PathVariable(value = "idHoja") int idHoja
    ) {
        return getFilasRutinaHandler.executer(idHoja);
    }

}
