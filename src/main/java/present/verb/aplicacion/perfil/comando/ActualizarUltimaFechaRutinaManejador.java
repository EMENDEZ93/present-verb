package present.verb.aplicacion.perfil.comando;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.aplicacion.comun.manejador.RespuestaManejador;
import present.verb.aplicacion.comun.model.RespuestaComando;
import present.verb.dominio.perfil.servicio.ActualizarUltimaFechaService;

@Component
public class ActualizarUltimaFechaRutinaManejador implements RespuestaManejador<ActualizarUltimaFecharRutinaComando, RespuestaComando<LocalDate>>{

	@Autowired
	private ActualizarUltimaFechaService actualizarUltimaFechaService;
	
	@Override
	public RespuestaComando<LocalDate> ejecutar(ActualizarUltimaFecharRutinaComando comando) throws Exception {
		return new RespuestaComando<>(actualizarUltimaFechaService.ejecutar(comando));
	}

}
