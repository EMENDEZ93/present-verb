package present.verb.dominio.temas.puerto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import present.verb.aplicacion.palabras.TemaDto;

@Repository
public interface ObtenerTemasV1Dao {

	List<TemaDto> ejecutar(String correo);
	List<TemaDto> ejecutar();

}
