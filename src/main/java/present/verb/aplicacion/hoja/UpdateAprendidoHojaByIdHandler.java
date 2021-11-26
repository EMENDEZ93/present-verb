package present.verb.aplicacion.hoja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.service.UpdateAprendidoHojaByIdService;

@Component
public class UpdateAprendidoHojaByIdHandler {

    @Autowired
    private UpdateAprendidoHojaByIdService updateAprendidoHojaByIdService;

    public Hoja executer(int idHoja) {
        return updateAprendidoHojaByIdService.executer(idHoja);
    }

}
