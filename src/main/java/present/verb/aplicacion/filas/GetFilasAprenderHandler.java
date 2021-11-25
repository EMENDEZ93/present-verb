package present.verb.aplicacion.filas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.fila.modelo.Fila;
import present.verb.dominio.fila.service.GetFilasAprenderService;

@Component
public class GetFilasAprenderHandler {

    @Autowired
    private GetFilasAprenderService getFilasAprenderService;

    public Fila executer(int idHoja) {
        return getFilasAprenderService.executer(idHoja);
    }

}
