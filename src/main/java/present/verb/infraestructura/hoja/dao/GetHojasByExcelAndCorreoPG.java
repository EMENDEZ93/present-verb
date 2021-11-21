package present.verb.infraestructura.hoja.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import present.verb.dominio.hoja.model.HojaDto;
import present.verb.dominio.temas.puerto.dao.GetHojasByExcelAndCorreoDao;
import present.verb.dominio.temas.puerto.repository.GetHojasByExcelAndCorreoRepository;

import java.util.List;

@Repository
public class GetHojasByExcelAndCorreoPG implements GetHojasByExcelAndCorreoDao {

    @Autowired
    private GetHojasByExcelAndCorreoRepository temasByExcelAndCorreoRepository;

    @Override
    public List<HojaDto> executer(String excel, String correo) {
        return temasByExcelAndCorreoRepository.execute(excel, correo);
    }

}
