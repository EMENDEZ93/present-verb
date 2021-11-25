package present.verb.dominio.fila.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.fila.modelo.Fila;
import present.verb.infraestructura.fila.dao.GetFilasAprenderExcelScanner;
import present.verb.infraestructura.fila.dao.GetFilasRutinaExcelScanner;

@Service
public class GetFilasRutinaService {

    @Autowired
    private GetFilasRutinaExcelScanner getFilasRutinaExcelScanner;

    public Fila executer(int idHoja) {
        return getFilasRutinaExcelScanner.executer(idHoja);
    }

}
