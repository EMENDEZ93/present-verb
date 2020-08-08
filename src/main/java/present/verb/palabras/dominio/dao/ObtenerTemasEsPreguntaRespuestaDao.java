package present.verb.palabras.dominio.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ObtenerTemasEsPreguntaRespuestaDao {

	boolean ejecutar(String nombreHojaTemaExcel);	
	
}
