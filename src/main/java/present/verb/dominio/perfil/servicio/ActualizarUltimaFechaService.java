package present.verb.dominio.perfil.servicio;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import present.verb.aplicacion.perfil.comando.ActualizarUltimaFecharRutinaComando;
import present.verb.dominio.perfil.modelo.Perfil;
import present.verb.dominio.perfil.puerto.repositorio.PerfilRepositorio;

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
