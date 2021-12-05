package present.verb.aplicacion.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.usuario.service.UpUltimaConexionByCorreoService;

@Component
public class UpUltimaConexionByCorreoHandler {

    @Autowired
    private UpUltimaConexionByCorreoService upUltimaConexionByCorreoService;

    public void executer(String correo) {
        upUltimaConexionByCorreoService.executer(correo);
    }

}
