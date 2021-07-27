package present.verb.aplicacion.perfil.comando;

import org.springframework.stereotype.Component;
import present.verb.dominio.perfil.modelo.Perfil;

@Component
public class PerfilFabrica {

    public Perfil crear(PerfilComando perfilComando) {
        Perfil perfil = new Perfil();
        perfil.setIdFirebase(perfilComando.getId());
        perfil.setCorreo(perfilComando.getCorreo());
        perfil.setUltimoIndiceAprendido(perfilComando.getUltimoIndiceAprendido());
        return perfil;
    }

}
