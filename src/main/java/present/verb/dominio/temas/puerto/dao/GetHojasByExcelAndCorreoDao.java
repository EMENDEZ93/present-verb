package present.verb.dominio.temas.puerto.dao;

import org.springframework.stereotype.Repository;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.model.HojaDto;

import java.util.List;

@Repository
public interface GetHojasByExcelAndCorreoDao {

    List<HojaDto> executer(String excel, String correo);

}
