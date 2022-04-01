package present.verb.dominio.excel.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.puerto.GetAllExcelDao;

import java.util.List;
import java.util.Set;

@Service
public class GetAllExcelService {

    @Autowired
    private GetAllExcelDao getAllExcelDao;

    public List<Excel> executer() {
        return getAllExcelDao.executer();
    }

    public Set<Excel> executerByCorreo(String correo) {
        return getAllExcelDao.executerByCorreo(correo);
    }

}
