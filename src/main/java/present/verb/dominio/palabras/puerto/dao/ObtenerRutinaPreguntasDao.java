package present.verb.dominio.palabras.puerto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ObtenerRutinaPreguntasDao {

	List<String> ejecutar(int numeroVerbosPorRutina, int hojaTemaExcel);

}
