package present.verb.perfil.dominio.servicio;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.perfil.aplicacion.comando.model.PerfilComando;
import present.verb.perfil.dominio.entidad.Perfil;
import present.verb.perfil.dominio.repositorio.PerfilRepositorio;

@Service
public class ActualizarPerfilServicio {

	@Autowired
	private PerfilRepositorio perfilRepositorio;

	public void ejecutar(PerfilComando perfilComando) {
		Perfil id = perfilRepositorio.findByCorreo(perfilComando.getCorreo());
		perfilRepositorio.actualizar(id, perfilComando.getNombre(), perfilComando.getUltimoIndiceAprendido(), LocalDate.now());
	}

}
