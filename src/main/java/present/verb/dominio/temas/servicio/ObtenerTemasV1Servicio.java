package present.verb.dominio.temas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;
import present.verb.dominio.temas.puerto.dao.ObtenerTemasV1Dao;

@Service
public class ObtenerTemasV1Servicio {

	@Autowired
	private ObtenerTemasV1Dao obtenerTemasDao;

	public List<TemaDto> ejecutar(String correo) {
		return obtenerTemasDao.ejecutar(correo);
	}

	public List<TemaDto> ejecutar() {
		return obtenerTemasDao.ejecutar();
	}

}
