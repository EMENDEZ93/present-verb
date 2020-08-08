package present.verb.palabras.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.palabras.dominio.servicio.ObtenerRuntinaServicio;
import present.verb.palabras.dominio.servicio.ObtenerRutinaPreguntasServicio;

@Component
public class ObtenerRutinaPreguntas {

	@Autowired
	private ObtenerRutinaPreguntasServicio obtenerRutinaPreguntasServicio;
	
	public List<String> ejecutar(int numeroVerbosPorRutina, int hojaTemaExcel) {
		return obtenerRutinaPreguntasServicio.ejecutar(numeroVerbosPorRutina, hojaTemaExcel);
	}
	
}
