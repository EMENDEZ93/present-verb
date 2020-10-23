package present.verb.palabras.dominio.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.palabras.dominio.dao.ObtenerRutinaDao;
import present.verb.palabras.dominio.dto.PalabraDto;

@Service
public class ObtenerRuntinaServicio {

	@Autowired
	private ObtenerRutinaDao obtenerRutinaDao;
	
	public PalabraDto ejecutar(int numeroVerbosPorRutina, int hojaTemaExcel) {
		return obtenerRutinaDao.listaVerbos(numeroVerbosPorRutina, hojaTemaExcel);
	}

}
