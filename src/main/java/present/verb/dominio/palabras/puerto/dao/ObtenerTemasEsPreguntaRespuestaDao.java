package present.verb.dominio.palabras.puerto.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ObtenerTemasEsPreguntaRespuestaDao {

	boolean ejecutar(String nombreHojaTemaExcel);	
	
}
