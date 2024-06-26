package present.verb.palabras.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.palabras.dominio.servicio.ObtenerPreguntasServicio;

@Component
public class ObtenerPreguntasManejador {

	@Autowired
	private ObtenerPreguntasServicio obtenerPreguntasServicio;

	public List<String> ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel) {
		return obtenerPreguntasServicio.ejecutar(ultimoIndiceVerboAprendido,numeroVerbosPorAprenderDiario, hojaTemaExcel);
	}	
	
}
