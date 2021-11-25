package present.verb.aplicacion.hoja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.service.GetUpdateHojaByIdService;

@Component
public class GetUpdateHojaByIdHandler {

    @Autowired
    private GetUpdateHojaByIdService getUpdateHojaByIdService;

    public Hoja executer(int idHoja) {
        return getUpdateHojaByIdService.executer(idHoja);
    }

}
