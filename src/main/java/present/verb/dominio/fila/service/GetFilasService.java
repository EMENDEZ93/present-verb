package present.verb.dominio.fila.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.fila.modelo.Fila;
import present.verb.infraestructura.fila.dao.GetFilasExcelScanner;

@Service
public class GetFilasService {

    @Autowired
    private GetFilasExcelScanner getFilasExcelScanner;

    public Fila executer(int idHoja) {
        return getFilasExcelScanner.executer(idHoja);
    }

}
