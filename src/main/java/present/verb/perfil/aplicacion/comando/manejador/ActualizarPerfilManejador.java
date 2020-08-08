package present.verb.perfil.aplicacion.comando.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.perfil.aplicacion.comando.model.PerfilComando;
import present.verb.perfil.dominio.servicio.ActualizarPerfilServicio;

@Component
public class ActualizarPerfilManejador {
	
	@Autowired
	private ActualizarPerfilServicio actualizarPerfilServicio;
	
	public void ejecutar(PerfilComando perfilComando) {
		actualizarPerfilServicio.ejecutar(perfilComando);
	}

}
