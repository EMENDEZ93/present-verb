package present.verb.comun.comando.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface RespuestaManejador<C, R> {

	@Transactional
	R ejecutar(C comando) throws Exception;
	
}