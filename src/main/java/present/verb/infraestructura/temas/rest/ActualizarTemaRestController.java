package present.verb.infraestructura.temas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import present.verb.aplicacion.perfil.comando.PerfilComando;
import present.verb.aplicacion.temas.ActualizarTemaManejador;
import present.verb.aplicacion.temas.TemaComando;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
public class ActualizarTemaRestController {

    @Autowired
    private ActualizarTemaManejador actualizarTemaManejador;

    @PostMapping("/tema")
    public TemaComando obtenerTemas(@Valid @RequestBody TemaComando temaComando){
        return actualizarTemaManejador.ejecutar(temaComando);
    }

}
