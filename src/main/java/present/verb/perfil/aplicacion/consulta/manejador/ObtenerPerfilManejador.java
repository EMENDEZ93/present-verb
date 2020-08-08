package present.verb.perfil.aplicacion.consulta.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.perfil.aplicacion.consulta.model.PerfilDto;
import present.verb.perfil.dominio.entidad.Perfil;
import present.verb.perfil.dominio.repositorio.PerfilRepositorio;

@Component
public class ObtenerPerfilManejador {

	@Autowired
	private PerfilRepositorio perfilRepositorio;
	
	public PerfilDto ejecutar(String correo, String hojaTemaExcel) {
		Perfil id = perfilRepositorio.findByCorreo(correo);
		
		System.out.println(id.getCorreo());
		System.out.println(hojaTemaExcel);
		return perfilRepositorio.obtenerPerfil(id, hojaTemaExcel);
	}
	
}
