package present.verb.temas.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;
import present.verb.temas.dominio.servicio.ObtenerTemasServicio;

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
