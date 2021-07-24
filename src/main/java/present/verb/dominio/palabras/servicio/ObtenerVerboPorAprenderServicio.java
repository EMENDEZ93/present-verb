package present.verb.dominio.palabras.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.dominio.palabras.puerto.dao.ObtenerVerboPorAprenderDao;
import present.verb.dominio.palabras.modelo.PalabraDto;

@Service
public class ObtenerVerboPorAprenderServicio {

	@Autowired
	private ObtenerVerboPorAprenderDao obtenerVerboPorAprenderDao;
	
	public PalabraDto ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel) {
		return obtenerVerboPorAprenderDao.ejecutar(ultimoIndiceVerboAprendido,numeroVerbosPorAprenderDiario, hojaTemaExcel);
	}
	
}
