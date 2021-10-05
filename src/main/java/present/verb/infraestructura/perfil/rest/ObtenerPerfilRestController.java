package present.verb.infraestructura.perfil.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import present.verb.aplicacion.perfil.consulta.ObtenerPerfilManejador;
import present.verb.aplicacion.perfil.consulta.PerfilDto;

@RestController
@RequestMapping("/perfil")
@CrossOrigin(origins = "*")
public class ObtenerPerfilRestController {

	@Autowired
	private ObtenerPerfilManejador obtenerPerfilManejador;
	
	@GetMapping("/{correo}/{hojaTemaExcel}")
	public PerfilDto perfil(@PathVariable("correo") String correo, @PathVariable("hojaTemaExcel") String hojaTemaExcel) {
		return obtenerPerfilManejador.ejecutar(correo, hojaTemaExcel);
	}

}
