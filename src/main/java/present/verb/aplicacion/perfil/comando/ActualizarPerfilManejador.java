package present.verb.aplicacion.perfil.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.dominio.perfil.servicio.ActualizarPerfilServicio;

@Component
public class ActualizarPerfilManejador {
	
	@Autowired
	private ActualizarPerfilServicio actualizarPerfilServicio;
	
	public void ejecutar(PerfilComando perfilComando) {
		actualizarPerfilServicio.ejecutar(perfilComando);
	}

}
