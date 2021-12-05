package present.verb.dominio.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.usuario.modelo.Usuario;
import present.verb.dominio.usuario.puerto.UsuarioRepository;

import static java.time.LocalDate.now;
import static java.util.Objects.isNull;

@Service
public class UpUltimaConexionByCorreoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void executer(String correo) {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if(
            isNull(usuario.getUltimaConexion()) || usuario.getUltimaConexion().isBefore(now())) {
            usuario.setUltimaConexion(now());
            usuarioRepository.save(usuario);
        }

    }

}
