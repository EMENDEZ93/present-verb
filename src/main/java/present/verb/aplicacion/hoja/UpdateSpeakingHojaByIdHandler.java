package present.verb.aplicacion.hoja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.service.UpdateSpeakingHojaByIdService;

@Component
public class UpdateSpeakingHojaByIdHandler {

    @Autowired
    private UpdateSpeakingHojaByIdService service;

    public Hoja executer(int idHoja) {
        return service.executer(idHoja);
    }
}
