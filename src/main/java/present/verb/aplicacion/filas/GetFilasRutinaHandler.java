package present.verb.aplicacion.filas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.fila.modelo.Fila;
import present.verb.dominio.fila.service.GetFilasAprenderService;
import present.verb.dominio.fila.service.GetFilasRutinaService;

@Component
public class GetFilasRutinaHandler {

    @Autowired
    private GetFilasRutinaService getFilasRutinaService;

    public Fila executer(int idHoja) {
        return getFilasRutinaService.executer(idHoja);
    }

}
