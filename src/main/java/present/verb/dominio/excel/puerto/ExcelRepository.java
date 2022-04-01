package present.verb.dominio.excel.puerto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.usuario.modelo.Usuario;

import java.util.Set;

@Repository
public interface ExcelRepository extends JpaRepository<Excel, Long> {

    Excel findByNombre(String excelNombre);
    Set<Excel> findAllByUsuario(Usuario usuario);

}
