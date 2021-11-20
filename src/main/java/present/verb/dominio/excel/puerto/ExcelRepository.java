package present.verb.dominio.excel.puerto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import present.verb.dominio.excel.modelo.Excel;

@Repository
public interface ExcelRepository extends JpaRepository<Excel, Long> {

    Excel findByNombre(String excelNombre);

}
