package present.verb.dominio.perfil.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.aplicacion.perfil.comando.PerfilComando;
import present.verb.dominio.perfil.modelo.Perfil;
import present.verb.dominio.perfil.puerto.repositorio.PerfilRepositorio;

@Service
public class ActualizarPerfilServicio {

	@Autowired
	private PerfilRepositorio perfilRepositorio;

	public void ejecutar(PerfilComando perfilComando) {

		Perfil perfil = new Perfil();
		perfil.setIdFirebase(perfilComando.getId());
		perfil.setCorreo(perfilComando.getCorreo());
		perfil.setUltimoIndiceAprendido(perfilComando.getUltimoIndiceAprendido());

		perfilRepositorio.save(perfil);

		//Perfil id = perfilRepositorio.findByCorreo(perfilComando.getCorreo());
		//perfilRepositorio.actualizar(id, perfilComando.getNombre(), perfilComando.getUltimoIndiceAprendido(), LocalDate.now());
	}

}
