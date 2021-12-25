package present.verb.dominio.conversacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.fila.modelo.Oracion;
import present.verb.infraestructura.conversacion.dao.GetConversacionExcelScanner;

import java.util.List;

@Service
public class GetConversacionService {

    @Autowired
    private GetConversacionExcelScanner getConversacionExcelScanner;

    public List<Oracion> executer(int idHoja) {
        return getConversacionExcelScanner.executer(idHoja);
    }

}
