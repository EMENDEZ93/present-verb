package present.verb.dominio.fila.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.fila.modelo.Fila;
import present.verb.infraestructura.fila.dao.GetFilasAprenderExcelScanner;

@Service
public class GetFilasAprenderService {

    @Autowired
    private GetFilasAprenderExcelScanner getFilasAprenderExcelScanner;

    public Fila executer(int idHoja) {
        return getFilasAprenderExcelScanner.executer(idHoja);
    }

}
