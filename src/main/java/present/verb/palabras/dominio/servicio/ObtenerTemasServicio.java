package present.verb.palabras.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.palabras.dominio.dao.ObtenerTemasDao;

@Service
public class ObtenerTemasServicio {

	@Autowired
	private ObtenerTemasDao obtenerTemasDao;

	public List<String> ejecutar() {
		return obtenerTemasDao.ejecutar();
	}

}
