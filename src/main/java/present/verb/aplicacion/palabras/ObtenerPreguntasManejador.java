package present.verb.aplicacion.palabras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.dominio.palabras.servicio.ObtenerPreguntasServicio;

@Component
public class ObtenerPreguntasManejador {

	@Autowired
	private ObtenerPreguntasServicio obtenerPreguntasServicio;

	public List<String> ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel) {
		return obtenerPreguntasServicio.ejecutar(ultimoIndiceVerboAprendido,numeroVerbosPorAprenderDiario, hojaTemaExcel);
	}	
	
}
