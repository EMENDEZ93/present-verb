package present.verb.palabras.dominio.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;

@Repository
public interface ObtenerTemasDao {

	List<TemaDto> ejecutar(String correo);
	List<TemaDto> ejecutar();

}
