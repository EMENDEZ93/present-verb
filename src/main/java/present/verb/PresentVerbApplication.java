package present.verb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import present.verb.dominio.palabras.puerto.dao.ObtenerTemasEsPreguntaRespuestaDao;
import present.verb.dominio.temas.servicio.ObtenerTemasV1Servicio;
import present.verb.dominio.perfil.modelo.Temas;
import present.verb.dominio.perfil.puerto.repositorio.PerfilRepositorio;
import present.verb.dominio.perfil.puerto.repositorio.TemasRepositorio;

@SpringBootApplication
public class PresentVerbApplication implements CommandLineRunner {

	@Autowired
	private ObtenerTemasV1Servicio obtenerTemasServicio;

	@Autowired
	private PerfilRepositorio perfilRepositorio;

	@Autowired
	private TemasRepositorio temasRepositorio;
	
	@Autowired
	private ObtenerTemasEsPreguntaRespuestaDao obtenerTemasPreguntaRespuesta;
	

	public static void main(String[] args) {
		SpringApplication.run(PresentVerbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Temas> temas = new ArrayList<>();
		List<String> nombreTemas = new ArrayList<>();

		obtenerTemasServicio.ejecutar().forEach(tema -> {
			Temas t = new Temas();
			t.setNombre(tema.getTema());
			temas.add(t);
			nombreTemas.add(tema.getTema());
		});

		perfilRepositorio.findAll().forEach(perfil -> {

			if (perfil.getTemas().isEmpty()) {
				temas.forEach(tema -> {
					tema.setPerfil(perfil);
					tema.setEsPreguntaRespuesta(this.obtenerTemasPreguntaRespuesta.ejecutar(tema.getNombre()));
					temasRepositorio.save(tema); 
					//System.out.println("->" + tema.getNombre());
				});
 
				perfil.setTemas(temas);
				perfilRepositorio.save(perfil);

			} else {
				 
				List<String> nombreTemasActuales = new ArrayList<>();
				temasRepositorio.findByPerfil(perfil).forEach(tema -> {
					nombreTemasActuales.add(tema.getNombre());
				});

				
				nombreTemas.forEach(nombreTema -> {
					if(!nombreTemasActuales.contains(nombreTema)) {
						Temas t = new Temas();
						t.setNombre(nombreTema);
						t.setPerfil(perfil); 
						t.setEsPreguntaRespuesta(this.obtenerTemasPreguntaRespuesta.ejecutar(nombreTema));
						temasRepositorio.save(t);
					}
				});
				  
			}

		});

	}

}
