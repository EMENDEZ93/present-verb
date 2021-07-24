package present.verb.dominio.palabras.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.dominio.palabras.puerto.dao.ObtenerRutinaDao;
import present.verb.dominio.palabras.modelo.PalabraDto;

@Service
public class ObtenerRuntinaServicio {

	@Autowired
	private ObtenerRutinaDao obtenerRutinaDao;
	
	public PalabraDto ejecutar(int numeroVerbosPorRutina, int hojaTemaExcel) {
		return obtenerRutinaDao.listaVerbos(numeroVerbosPorRutina, hojaTemaExcel);
	}

}
