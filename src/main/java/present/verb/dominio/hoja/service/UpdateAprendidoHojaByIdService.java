package present.verb.dominio.hoja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.port.HojaRepository;

@Service
public class UpdateAprendidoHojaByIdService {

    @Autowired
    private HojaRepository hojaRepository;

    public Hoja executer(int idHoja) {
        return hojaRepository.updateUlfimaFechaAndUltimoIndice(idHoja);
    }

}
