package present.verb.dominio.palabras.puerto.dao;

import org.springframework.stereotype.Repository;
import present.verb.dominio.palabras.modelo.PalabraDto;

@Repository
public interface ObtenerVerboPorAprenderDao {

	PalabraDto ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel);

}
