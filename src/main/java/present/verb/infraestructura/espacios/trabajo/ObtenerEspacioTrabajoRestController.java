package present.verb.infraestructura.espacios.trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import present.verb.dominio.espacios.trabajo.ObtenerEspacioTrabajo;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ObtenerEspacioTrabajoRestController {

    @Autowired
    private ObtenerEspacioTrabajo obtenerEspacioTrabajo;

    @GetMapping("/espacios/trabajo")
    public List<String> obtenerEspacios() {
        return obtenerEspacioTrabajo.obtenerEspacios();
    }
}
