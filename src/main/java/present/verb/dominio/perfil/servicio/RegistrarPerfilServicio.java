package present.verb.dominio.perfil.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.aplicacion.perfil.comando.PerfilComando;
import present.verb.dominio.palabras.puerto.dao.ObtenerTemasEsPreguntaRespuestaDao;
import present.verb.dominio.perfil.modelo.Perfil;
import present.verb.dominio.perfil.modelo.Temas;
import present.verb.dominio.perfil.puerto.repositorio.PerfilRepositorio;
import present.verb.dominio.perfil.puerto.repositorio.TemasRepositorio;
import present.verb.dominio.temas.servicio.ObtenerTemasV1Servicio;
import present.verb.dominio.usuario.modelo.Usuario;
import present.verb.dominio.usuario.puerto.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrarPerfilServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void ejecutar(Perfil perfil) {
        Usuario usuario = new Usuario();
        usuario.setIdFirebase(perfil.getIdFirebase());
        usuario.setCorreo(perfil.getCorreo());

        usuarioRepository.save(usuario);
    }

}
