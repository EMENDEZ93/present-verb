package present.verb.temas.infraestructura.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;
import present.verb.temas.aplicacion.ObtenerTemasManejador;

@RestController
@CrossOrigin(origins = "*")
public class ObtenerTemasRestController {

	@Autowired
	private ObtenerTemasManejador obtenerTemasV1Manejador;

	@GetMapping("/v2/temas")
	public List<TemaDto> ejecutar(){
		return obtenerTemasV1Manejador.ejecutar();
	}

}
