package present.verb.dominio.palabras.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.dominio.palabras.puerto.dao.ObtenerPreguntasDao;

@Service
public class ObtenerPreguntasServicio {

	@Autowired
	private ObtenerPreguntasDao obtenerPreguntasExcelDao;
	
	public List<String> ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel) {
		return obtenerPreguntasExcelDao.ejecutar(ultimoIndiceVerboAprendido,numeroVerbosPorAprenderDiario, hojaTemaExcel);
	}	
	
}
