package present.verb.dominio.excel.puerto;

import org.springframework.stereotype.Repository;
import present.verb.dominio.excel.modelo.Excel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@Repository
public interface GetAllExcelDao {

    List<Excel> executer();
    Set<Excel> executerByCorreo(String correo);

}
