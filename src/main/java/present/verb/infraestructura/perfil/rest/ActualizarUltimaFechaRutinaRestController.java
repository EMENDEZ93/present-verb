package present.verb.infraestructura.perfil.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import present.verb.aplicacion.perfil.comando.ActualizarUltimaFechaRutinaManejador;
import present.verb.aplicacion.perfil.comando.ActualizarUltimaFecharRutinaComando;

@RestController
@RequestMapping("/ultimafecharutina")
@CrossOrigin(origins = "*")
public class ActualizarUltimaFechaRutinaRestController {

	@Autowired
	private ActualizarUltimaFechaRutinaManejador actualizarUltimaFechaRutinaManejador;
	
	@PostMapping
	public void actualizar(@Valid @RequestBody ActualizarUltimaFecharRutinaComando comando) throws Exception {
		actualizarUltimaFechaRutinaManejador.ejecutar(comando);
	}

	@GetMapping("/{correo}/{hojaTemaExcel}")
	public void actualizar(@PathVariable("correo") String correo, @PathVariable("hojaTemaExcel") String hojaTemaExcel) throws Exception {
		ActualizarUltimaFecharRutinaComando comando = new ActualizarUltimaFecharRutinaComando();
		comando.setCorreo(correo);
		comando.setNombre(hojaTemaExcel);
		actualizarUltimaFechaRutinaManejador.ejecutar(comando);
	}	
	
}
