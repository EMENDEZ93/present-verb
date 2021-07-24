package present.verb.aplicacion.temas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.aplicacion.palabras.TemaDto;
import present.verb.dominio.temas.servicio.ObtenerTemasV1Servicio;

@Component
public class ObtenerTemasV1Manejador {

	@Autowired
	private ObtenerTemasV1Servicio obtenerTemasServicio;

	public List<TemaDto> ejecutar(String correo) {
		return obtenerTemasServicio.ejecutar(correo);
	}

}
