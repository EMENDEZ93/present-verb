package present.verb.dominio.palabras.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.dominio.palabras.puerto.dao.ObtenerRutinaPreguntasDao;

@Service
public class ObtenerRutinaPreguntasServicio {

	@Autowired
	private ObtenerRutinaPreguntasDao obtenerRutinaPreguntasDao;
	
	public List<String> ejecutar(int numeroVerbosPorRutina, int hojaTemaExcel) {
		return obtenerRutinaPreguntasDao.ejecutar(numeroVerbosPorRutina, hojaTemaExcel);
	}	
	
}
