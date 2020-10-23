package present.verb.palabras.dominio.dao;

import org.springframework.stereotype.Repository;
import present.verb.palabras.dominio.dto.PalabraDto;

@Repository
public interface ObtenerRutinaDao {

	PalabraDto listaVerbos(int cantidad, int hojaTemaExcel);
	
}
