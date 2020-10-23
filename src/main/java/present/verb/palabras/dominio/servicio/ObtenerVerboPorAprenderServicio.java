package present.verb.palabras.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.palabras.dominio.dao.ObtenerVerboPorAprenderDao;
import present.verb.palabras.dominio.dto.PalabraDto;

@Service
public class ObtenerVerboPorAprenderServicio {

	@Autowired
	private ObtenerVerboPorAprenderDao obtenerVerboPorAprenderDao;
	
	public PalabraDto ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel) {
		return obtenerVerboPorAprenderDao.ejecutar(ultimoIndiceVerboAprendido,numeroVerbosPorAprenderDiario, hojaTemaExcel);
	}
	
}
