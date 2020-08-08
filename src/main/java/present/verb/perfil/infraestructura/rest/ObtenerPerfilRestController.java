package present.verb.perfil.infraestructura.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import present.verb.perfil.aplicacion.consulta.manejador.ObtenerPerfilManejador;
import present.verb.perfil.aplicacion.consulta.model.PerfilDto;

@RestController
@RequestMapping("/perfil")
@CrossOrigin(origins = "*")
public class ObtenerPerfilRestController {

	@Autowired
	private ObtenerPerfilManejador obtenerPerfilManejador;
	
	@GetMapping("/{correo}/{hojaTemaExcel}")
	public PerfilDto perfil(@PathVariable("correo") String correo, @PathVariable("hojaTemaExcel") String hojaTemaExcel) {
		System.out.println();
		return obtenerPerfilManejador.ejecutar(correo, hojaTemaExcel);
	}

}
