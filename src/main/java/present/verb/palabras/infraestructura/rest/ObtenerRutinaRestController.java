package present.verb.palabras.infraestructura.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import present.verb.palabras.aplicacion.consulta.manejador.ObtenerRunitaManejador;
import present.verb.palabras.aplicacion.consulta.manejador.ObtenerRutinaPreguntas;
import present.verb.palabras.dominio.dto.PalabraDto;

@RestController
@CrossOrigin(origins = "*")
public class ObtenerRutinaRestController {

	@Autowired
	private ObtenerRunitaManejador obtenerRunitaManejador;

	@Autowired
	private ObtenerRutinaPreguntas obtenerRutinaPreguntas;	
	
	@GetMapping("/{numeroVerbosPorRutina}/{hojaTemaExcel}")
	public PalabraDto obtenerRutina(@PathVariable(value="numeroVerbosPorRutina")int numeroVerbosPorRutina, @PathVariable(value="hojaTemaExcel")int  hojaTemaExcel){
		return obtenerRunitaManejador.ejecutar(numeroVerbosPorRutina, hojaTemaExcel);
	}

	@GetMapping("/preguntas/{numeroVerbosPorRutina}/{hojaTemaExcel}")
	public List<String> obtenerRutinaPreguntas(@PathVariable(value="numeroVerbosPorRutina")int numeroVerbosPorRutina, @PathVariable(value="hojaTemaExcel")int  hojaTemaExcel){
		return obtenerRutinaPreguntas.ejecutar(numeroVerbosPorRutina, hojaTemaExcel);
	}
		
}
