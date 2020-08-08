package present.verb.palabras.dominio.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ObtenerRutinaDao {

	List<String> listaVerbos(int cantidad, int hojaTemaExcel);
	
}
