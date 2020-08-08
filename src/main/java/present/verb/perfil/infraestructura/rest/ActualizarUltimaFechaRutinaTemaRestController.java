package present.verb.perfil.infraestructura.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import present.verb.perfil.aplicacion.comando.manejador.ActualizarUltimaFechaRutinaManejador;
import present.verb.perfil.aplicacion.comando.model.ActualizarUltimaFecharRutinaComando;

@RestController
@RequestMapping("/fecha")
@CrossOrigin(origins = "*")
public class ActualizarUltimaFechaRutinaTemaRestController {

	@Autowired
	private ActualizarUltimaFechaRutinaManejador actualizarUltimaFechaRutinaManejador;	
	
	@PostMapping
	public void actualizar(@Valid @RequestBody ActualizarUltimaFecharRutinaComando comando) throws Exception {
		//actualizarUltimaFechaRutinaManejador.ejecutar(comando);
		
		System.out.println("___________________________________________________>");
		System.out.println("***************************************************");
		System.out.println("___________________________________________________>");

	}	
	
}
