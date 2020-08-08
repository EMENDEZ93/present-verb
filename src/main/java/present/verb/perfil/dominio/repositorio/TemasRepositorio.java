package present.verb.perfil.dominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import present.verb.perfil.dominio.entidad.Perfil;
import present.verb.perfil.dominio.entidad.Temas;

@Repository
public interface TemasRepositorio extends JpaRepository<Temas, Long>{
	
	List<Temas> findByPerfil (Perfil perfil);

}
