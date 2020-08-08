package present.verb.perfil.infraestructura.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import present.verb.perfil.aplicacion.comando.manejador.ActualizarPerfilManejador;
import present.verb.perfil.aplicacion.comando.model.PerfilComando;

@RestController
@RequestMapping("/perfil")
@CrossOrigin(origins = "*")
public class ActualizarPerfilRestController {

	@Autowired
	private ActualizarPerfilManejador actualizarPerfilManejador;
	
	@PostMapping
	public void actualizar(@Valid @RequestBody PerfilComando perfilComando) {
		actualizarPerfilManejador.ejecutar(perfilComando);
	}
	
}
