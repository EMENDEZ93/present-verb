package present.verb.aplicacion.palabras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.dominio.palabras.modelo.PalabraDto;
import present.verb.dominio.palabras.servicio.ObtenerVerboPorAprenderServicio;

@Component
public class ObtenerVerborPorAprenderManejador {
	
	@Autowired
	private ObtenerVerboPorAprenderServicio obtenerVerboPorAprenderServicio;

	public PalabraDto ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel) {
		return obtenerVerboPorAprenderServicio.ejecutar(ultimoIndiceVerboAprendido,numeroVerbosPorAprenderDiario, hojaTemaExcel);
	}

}
