package present.verb.dominio.hoja.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import present.verb.dominio.hoja.model.Hoja;

@Repository
public interface HojaRepository extends JpaRepository<Hoja, Long> {

}
