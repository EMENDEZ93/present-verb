package present.verb.dominio.temas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.temas.puerto.dao.GetHojasByExcelAndCorreoDao;
import present.verb.dominio.temas.puerto.dao.SaveHojasByExcelAndCorreoDao;

import java.util.List;

@Service
public class GetHojasByExcelAndCorreoService {

    @Autowired
    private GetHojasByExcelAndCorreoDao getHojasByExcelAndCorreoDao;

    @Autowired
    private ObtenerTemasServicio obtenerTemasServicio;

    @Autowired
    private SaveHojasByExcelAndCorreoDao saveHojasByExcelAndCorreoDao;

    public List<Hoja> excecute(String excel, String correo) {
        List<Hoja> hojas = getHojasByExcelAndCorreoDao.executer(excel, correo);
        if(hojas.isEmpty()) {
            saveHojasByExcelAndCorreoDao.executer(excel, correo);
            return getHojasByExcelAndCorreoDao.executer(excel, correo);
        }
        return hojas;
    }

}
