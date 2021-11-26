package present.verb.aplicacion.hoja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.service.UpdateAprendidoHojaByIdService;
import present.verb.dominio.hoja.service.UpdateRutinaHojaByIdService;

@Component
public class UpdateRutinaHojaByIdHandler {

    @Autowired
    private UpdateRutinaHojaByIdService updateRutinaHojaByIdService;

    public Hoja executer(int idHoja) {
        return updateRutinaHojaByIdService.executer(idHoja);
    }

}
