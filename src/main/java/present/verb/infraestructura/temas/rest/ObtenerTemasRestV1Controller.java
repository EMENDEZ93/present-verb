package present.verb.infraestructura.temas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import present.verb.aplicacion.palabras.TemaDto;
import present.verb.aplicacion.temas.ObtenerTemasV1Manejador;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ObtenerTemasRestV1Controller {

	@Autowired
	private ObtenerTemasV1Manejador obtenerTemasV1Manejador;
	
	@GetMapping("/temas/{correo}")
	public List<TemaDto> obtenerTemas(@PathVariable(value="correo") String correo){
		return obtenerTemasV1Manejador.ejecutar(correo);
	}

}
