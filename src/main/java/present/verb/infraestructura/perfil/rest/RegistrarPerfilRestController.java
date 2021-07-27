package present.verb.infraestructura.perfil.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import present.verb.aplicacion.perfil.comando.RegistrarPerfilManejador;
import present.verb.aplicacion.perfil.comando.PerfilComando;

@RestController
@RequestMapping("/perfil")
@CrossOrigin(origins = "*")
public class RegistrarPerfilRestController {

	@Autowired
	private RegistrarPerfilManejador registrarPerfilManejador;


	@PostMapping
	public void actualizar(@Valid @RequestBody PerfilComando perfilComando) {
		registrarPerfilManejador.ejecutar(perfilComando);
	}
	
}
