package present.verb.palabras.infraestructura.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import present.verb.palabras.aplicacion.consulta.manejador.ObtenerTemasManejador;

@RestController
@CrossOrigin(origins = "*")
public class ObtenerTemasRestController {

	@Autowired
	private ObtenerTemasManejador obtenerTemasManejador;
	
	@GetMapping("/temas")
	public List<String> obtenerTemas(){
		return obtenerTemasManejador.ejecutar();
	}
	
}
