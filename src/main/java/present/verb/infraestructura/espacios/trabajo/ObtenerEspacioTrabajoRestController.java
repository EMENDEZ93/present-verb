package present.verb.infraestructura.espacios.trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import present.verb.dominio.espacios.trabajo.ObtenerEspacioTrabajo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class ObtenerEspacioTrabajoRestController {

    @Autowired
    private ObtenerEspacioTrabajo obtenerEspacioTrabajo;

    @GetMapping("/espacios/trabajo")
    public Set<String> obtenerEspacios() {
        List<String> strings = obtenerEspacioTrabajo.obtenerEspacios();
        Set<String> conjunto = new HashSet<>(strings);
        return conjunto;
    }
}
