package present.verb.aplicacion.conversacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.conversacion.service.GetConversacionService;
import present.verb.dominio.fila.modelo.Oracion;

import java.util.List;

@Component
public class GetConversacionHandler {

    @Autowired
    private GetConversacionService getConversacionService;

    public List<Oracion> executer(int idHoja) {
        return getConversacionService.executer(idHoja);
    }

}
