package present.verb.dominio.usuario.puerto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import present.verb.dominio.usuario.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCorreo(String correo);

}
