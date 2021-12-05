package present.verb.infraestructura.usuario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import present.verb.aplicacion.usuario.UpUltimaConexionByCorreoHandler;

@RestController
@CrossOrigin(origins = "*")
public class UpUltimaConexionByCorreoRest {

    @Autowired
    private UpUltimaConexionByCorreoHandler upUltimaConexionByCorreoHandler;

    @GetMapping("/usuario/ultima/conexion/{correo}")
    public void executer(@PathVariable String correo) {
        upUltimaConexionByCorreoHandler.executer(correo);
    }

}
