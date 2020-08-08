package present.verb.perfil.aplicacion.comando.manejador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.comun.comando.manejador.RespuestaManejador;
import present.verb.comun.comando.model.RespuestaComando;
import present.verb.perfil.aplicacion.comando.model.ActualizarUltimaFecharRutinaComando;
import present.verb.perfil.dominio.servicio.ActualizarUltimaFechaService;

@Component
public class ActualizarUltimaFechaRutinaManejador implements RespuestaManejador<ActualizarUltimaFecharRutinaComando, RespuestaComando<LocalDate>>{

	@Autowired
	private ActualizarUltimaFechaService actualizarUltimaFechaService;
	
	@Override
	public RespuestaComando<LocalDate> ejecutar(ActualizarUltimaFecharRutinaComando comando) throws Exception {
		return new RespuestaComando<>(actualizarUltimaFechaService.ejecutar(comando));
	}

}
