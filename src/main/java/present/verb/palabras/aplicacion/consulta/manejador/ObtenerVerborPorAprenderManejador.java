package present.verb.palabras.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.palabras.dominio.dto.PalabraDto;
import present.verb.palabras.dominio.servicio.ObtenerVerboPorAprenderServicio;

@Component
public class ObtenerVerborPorAprenderManejador {
	
	@Autowired
	private ObtenerVerboPorAprenderServicio obtenerVerboPorAprenderServicio;

	public PalabraDto ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel) {
		return obtenerVerboPorAprenderServicio.ejecutar(ultimoIndiceVerboAprendido,numeroVerbosPorAprenderDiario, hojaTemaExcel);
	}

}
