package present.verb.aplicacion.temas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.temas.servicio.GetHojasByExcelAndCorreoService;

import java.util.List;

@Component
public class GetHojasByExcelAndCorreoCorreHandler {

    @Autowired
    private GetHojasByExcelAndCorreoService getHojasByExcelAndCorreoService;

    public List<Hoja> execute(String excel, String correo) {
        return getHojasByExcelAndCorreoService.excecute(excel, correo);
    }

}