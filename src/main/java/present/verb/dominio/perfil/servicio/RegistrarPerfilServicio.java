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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrarPerfilServicio {

    @Autowired
    private ObtenerTemasV1Servicio obtenerTemasServicio;

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    @Autowired
    private TemasRepositorio temasRepositorio;

    @Autowired
    private ObtenerTemasEsPreguntaRespuestaDao obtenerTemasPreguntaRespuesta;

    public void ejecutar(Perfil perfil) {

        perfilRepositorio.save(perfil);

		List<Temas> temas = obtenerTemasServicio.ejecutar().stream().map(temaDto -> {
            Temas tema = new Temas();
			tema.setNombre(temaDto.getTema());
			tema.setPerfil(perfil);
			tema.setEsPreguntaRespuesta(this.obtenerTemasPreguntaRespuesta.ejecutar(tema.getNombre()));
			tema.setIndiceExcel(temaDto.getIndiceExcel());
			temasRepositorio.save(tema);
            return tema;
        }).collect(Collectors.toList());

        perfil.setTemas(temas);
        perfilRepositorio.save(perfil);

    }

}
