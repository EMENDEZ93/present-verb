package present.verb.infraestructura.palabras.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import present.verb.aplicacion.palabras.ObtenerPreguntasManejador;
import present.verb.aplicacion.palabras.ObtenerVerborPorAprenderManejador;
import present.verb.dominio.palabras.modelo.PalabraDto;

@RestController
@CrossOrigin(origins = "*")
public class ObtenerVerbosPorAprender {

	@Autowired
	private ObtenerVerborPorAprenderManejador obtenerVerborPorAprenderManejador;

	@Autowired
	private ObtenerPreguntasManejador obtenerPreguntasManejador;	
	
	@GetMapping("/verbosporaprender/{ultimoIndiceVerboAprendido}/{numeroVerbosPorAprenderDiario}/{hojaTemaExcel}")
	public PalabraDto obtener(@PathVariable(value = "ultimoIndiceVerboAprendido") int ultimoIndiceVerboAprendido,
									@PathVariable(value = "numeroVerbosPorAprenderDiario") int numeroVerbosPorAprenderDiario,
									@PathVariable(value = "hojaTemaExcel") int hojaTemaExcel) {
		return obtenerVerborPorAprenderManejador.ejecutar(ultimoIndiceVerboAprendido, numeroVerbosPorAprenderDiario, hojaTemaExcel);
	}

	@GetMapping("/preguntas/{ultimoIndiceVerboAprendido}/{numeroVerbosPorAprenderDiario}/{hojaTemaExcel}")
	public List<String> obtenerPreguntas(@PathVariable(value = "ultimoIndiceVerboAprendido") int ultimoIndiceVerboAprendido,
			@PathVariable(value = "numeroVerbosPorAprenderDiario") int numeroVerbosPorAprenderDiario,
			@PathVariable(value = "hojaTemaExcel") int hojaTemaExcel) {
		return obtenerPreguntasManejador.ejecutar(ultimoIndiceVerboAprendido, numeroVerbosPorAprenderDiario, hojaTemaExcel);
	}	
	
}
