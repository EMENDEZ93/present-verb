package present.verb.dominio.temas.puerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.usuario.modelo.Usuario;

import java.util.List;

@Repository
public interface GetHojasByExcelAndCorreoRepository extends JpaRepository<Hoja, Long> {

    @Transactional(readOnly = true)
    @Query(name = "getHojasByExcelAndCorreo")
    List<Hoja> execute(String excel, String correo);

}
