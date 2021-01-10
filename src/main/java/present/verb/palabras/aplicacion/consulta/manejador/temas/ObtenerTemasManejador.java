package present.verb.palabras.aplicacion.consulta.manejador.temas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;
import present.verb.palabras.dominio.servicio.ObtenerTemasServicio;

@Component
public class ObtenerTemasManejador {

	@Autowired
	private ObtenerTemasServicio obtenerTemasServicio;
	
	public List<TemaDto> ejecutar(String correo) {
		return obtenerTemasServicio.ejecutar(correo);
	}

	public List<TemaDto> ejecutar() {
		return obtenerTemasServicio.ejecutar();
	}

}
