package present.verb.aplicacion.perfil.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.dominio.perfil.modelo.Perfil;
import present.verb.dominio.perfil.servicio.RegistrarPerfilServicio;

@Component
public class RegistrarPerfilManejador {

	@Autowired
	private PerfilFabrica perfilFabrica;

	@Autowired
	private RegistrarPerfilServicio registrarPerfilServicio;
	
	public void ejecutar(PerfilComando perfilComando) {
		Perfil perfil = perfilFabrica.crear(perfilComando);
		registrarPerfilServicio.ejecutar(perfil);
	}

}
