package present.verb.aplicacion.temas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.temas.servicio.ActualizarTemaServicio;

@Component
public class ActualizarTemaManejador {

    @Autowired
    private ActualizarTemaServicio actualizarTemaServicio;

    public TemaComando ejecutar(TemaComando temaComando) {
        return actualizarTemaServicio.ejecutar(temaComando);
    }

}
