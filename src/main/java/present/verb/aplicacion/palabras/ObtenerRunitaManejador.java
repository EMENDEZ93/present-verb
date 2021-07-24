package present.verb.aplicacion.palabras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.dominio.palabras.modelo.PalabraDto;
import present.verb.dominio.palabras.servicio.ObtenerRuntinaServicio;

@Component
public class ObtenerRunitaManejador {
	
	@Autowired
	private ObtenerRuntinaServicio obtenerRuntinaServicio;

	public PalabraDto ejecutar(int numeroVerbosPorRutina, int hojaTemaExcel) {
		return obtenerRuntinaServicio.ejecutar(numeroVerbosPorRutina, hojaTemaExcel);
	}


	
}
