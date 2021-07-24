package present.verb.dominio.palabras.puerto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ObtenerPreguntasDao {

	List<String> ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel);

}
