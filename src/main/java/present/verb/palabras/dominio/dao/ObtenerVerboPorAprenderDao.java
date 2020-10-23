package present.verb.palabras.dominio.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import present.verb.palabras.dominio.dto.PalabraDto;

@Repository
public interface ObtenerVerboPorAprenderDao {

	PalabraDto ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel);

}
