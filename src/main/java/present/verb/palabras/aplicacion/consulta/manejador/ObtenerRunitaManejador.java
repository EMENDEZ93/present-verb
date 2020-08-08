package present.verb.palabras.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.palabras.dominio.servicio.ObtenerRuntinaServicio;

@Component
public class ObtenerRunitaManejador {
	
	@Autowired
	private ObtenerRuntinaServicio obtenerRuntinaServicio;

	public List<String> ejecutar(int numeroVerbosPorRutina, int hojaTemaExcel) {
		return obtenerRuntinaServicio.ejecutar(numeroVerbosPorRutina, hojaTemaExcel);
	}


	
}
