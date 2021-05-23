package present.verb.temas.infraestructura.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;
import present.verb.temas.aplicacion.ObtenerTemasManejador;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v2/temas")
public class ObtenerTemasRestController {

	@Autowired
	private ObtenerTemasManejador obtenerTemasV1Manejador;

	@GetMapping
	public List<TemaDto> ejecutar(){
		return obtenerTemasV1Manejador.ejecutar();
	}

	@GetMapping("/{correo}")
	public List<TemaDto> ejecutarPorUsuario(@PathVariable String correo){
		return obtenerTemasV1Manejador.ejecutar(correo);
	}

}
