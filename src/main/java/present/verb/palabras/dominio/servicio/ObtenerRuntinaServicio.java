package present.verb.palabras.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.palabras.dominio.dao.ObtenerRutinaDao;

@Service
public class ObtenerRuntinaServicio {

	@Autowired
	private ObtenerRutinaDao obtenerRutinaDao;
	
	public List<String> ejecutar(int numeroVerbosPorRutina, int hojaTemaExcel) {
		return obtenerRutinaDao.listaVerbos(numeroVerbosPorRutina, hojaTemaExcel);
	}

}
