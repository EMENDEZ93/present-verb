package present.verb.dominio.temas.puerto.dao;

import org.springframework.stereotype.Repository;
import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;

import java.util.List;

@Repository
public interface ObtenerTemasDao {

	List<TemaDto> ejecutar();

	List<TemaDto> ejecutar(String correo);
}
