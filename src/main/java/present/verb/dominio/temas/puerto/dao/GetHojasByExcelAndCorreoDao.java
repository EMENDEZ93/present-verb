package present.verb.dominio.temas.puerto.dao;

import org.springframework.stereotype.Repository;
import present.verb.dominio.hoja.model.Hoja;

import java.util.List;

@Repository
public interface GetHojasByExcelAndCorreoDao {

    List<Hoja> executer(String excel, String correo);

}
