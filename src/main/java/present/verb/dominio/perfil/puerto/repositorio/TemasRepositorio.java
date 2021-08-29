package present.verb.dominio.perfil.puerto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import present.verb.dominio.perfil.modelo.Perfil;
import present.verb.dominio.perfil.modelo.Temas;

@Repository
public interface TemasRepositorio extends JpaRepository<Temas, Long>{
	
	List<Temas> findByPerfil (Perfil perfil);

	Temas findByNombre (String nombre);

	Temas findByNombreAndPerfilCorreo (String nombre, String correo);

}
