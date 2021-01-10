package present.verb.palabras.infraestructura.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import present.verb.palabras.aplicacion.consulta.manejador.temas.ObtenerTemasManejador;
import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;

@RestController
@CrossOrigin(origins = "*")
public class ObtenerTemasRestController {

	@Autowired
	private ObtenerTemasManejador obtenerTemasManejador;
	
	@GetMapping("/temas/{correo}")
	public List<TemaDto> obtenerTemas(@PathVariable(value="correo") String correo){
		return obtenerTemasManejador.ejecutar(correo);
	}

	@GetMapping("/v2/temas")
	public List<TemaDto> ejecutar(@PathVariable(value="correo") String correo){
		return obtenerTemasManejador.ejecutar(correo);
	}

}
