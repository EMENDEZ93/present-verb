package present.verb.palabras.aplicacion.consulta.manejador.temas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;
import present.verb.palabras.dominio.servicio.ObtenerTemasV1Servicio;

@Component
public class ObtenerTemasV1Manejador {

	@Autowired
	private ObtenerTemasV1Servicio obtenerTemasServicio;

	public List<TemaDto> ejecutar(String correo) {
		return obtenerTemasServicio.ejecutar(correo);
	}

}
