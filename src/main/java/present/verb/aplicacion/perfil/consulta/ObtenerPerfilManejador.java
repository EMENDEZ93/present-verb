package present.verb.aplicacion.perfil.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import present.verb.dominio.perfil.modelo.Perfil;
import present.verb.dominio.perfil.puerto.repositorio.PerfilRepositorio;

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
