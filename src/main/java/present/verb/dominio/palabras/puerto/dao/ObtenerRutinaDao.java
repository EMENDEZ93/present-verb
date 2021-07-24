package present.verb.dominio.palabras.puerto.dao;

import org.springframework.stereotype.Repository;
import present.verb.dominio.palabras.modelo.PalabraDto;

@Repository
public interface ObtenerRutinaDao {

	PalabraDto listaVerbos(int cantidad, int hojaTemaExcel);
	
}
