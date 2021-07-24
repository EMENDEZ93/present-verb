package present.verb.aplicacion.manejador.temas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;
import present.verb.dominio.temas.servicio.ObtenerTemasServicio;

import java.util.List;

@Component
public class ObtenerTemasManejador {

	@Autowired
	private ObtenerTemasServicio obtenerTemasServicio;
	
	public List<TemaDto> ejecutar() {
		return obtenerTemasServicio.ejecutar();
	}

	public List<TemaDto> ejecutar(String correo) {
		return obtenerTemasServicio.ejecutar(correo);
	}
}
