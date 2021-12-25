package present.verb.infraestructura.conversacion.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import present.verb.aplicacion.conversacion.GetConversacionHandler;
import present.verb.dominio.fila.modelo.Oracion;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GetConversacionRestController {

    @Autowired
    private GetConversacionHandler getConversacionHandler;

    @GetMapping("/conversacion/{idHoja}")
    public List<Oracion> executer(@PathVariable(value = "idHoja") int idHoja) {
        return getConversacionHandler.executer(idHoja);
    }

}
