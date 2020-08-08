package present.verb.perfil.dominio.servicio;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.perfil.aplicacion.comando.model.ActualizarUltimaFecharRutinaComando;
import present.verb.perfil.dominio.entidad.Perfil;
import present.verb.perfil.dominio.repositorio.PerfilRepositorio;

@Service
public class ActualizarUltimaFechaService {

	@Autowired
	private PerfilRepositorio perfilRepositorio;
	
	public LocalDate ejecutar(ActualizarUltimaFecharRutinaComando comando) {
		Perfil perfil = perfilRepositorio.findByCorreo(comando.getCorreo());
		perfilRepositorio.actualizarUltimaFechaRutina(perfil, comando.getNombre() ,comando.getUltimaFechaRutina());		
		return comando.getUltimaFechaRutina();
	}
	
}
