package present.verb.dominio.temas.puerto.dao;

import org.springframework.stereotype.Repository;
import present.verb.aplicacion.palabras.TemaDto;

import java.util.List;

@Repository
public interface ObtenerTemasDao {

	List<TemaDto> ejecutar();

	List<TemaDto> ejecutar(String correo);
}
