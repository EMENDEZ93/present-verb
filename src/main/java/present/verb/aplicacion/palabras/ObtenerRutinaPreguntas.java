package present.verb.aplicacion.palabras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.dominio.palabras.servicio.ObtenerRutinaPreguntasServicio;

@Component
public class ObtenerRutinaPreguntas {

	@Autowired
	private ObtenerRutinaPreguntasServicio obtenerRutinaPreguntasServicio;
	
	public List<String> ejecutar(int numeroVerbosPorRutina, int hojaTemaExcel) {
		return obtenerRutinaPreguntasServicio.ejecutar(numeroVerbosPorRutina, hojaTemaExcel);
	}
	
}
