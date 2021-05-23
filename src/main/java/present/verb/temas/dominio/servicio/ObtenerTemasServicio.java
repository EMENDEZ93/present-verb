package present.verb.temas.dominio.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;
import present.verb.palabras.dominio.dao.temas.ObtenerTemasV1Dao;
import present.verb.temas.dominio.dao.ObtenerTemasDao;

import java.util.List;

@Service
public class ObtenerTemasServicio {

	@Autowired
	private ObtenerTemasDao obtenerTemasDao;

	public List<TemaDto> ejecutar() {
		return obtenerTemasDao.ejecutar();
	}

	public List<TemaDto> ejecutar(String correo) {
		return obtenerTemasDao.ejecutar(correo);
	}
}
