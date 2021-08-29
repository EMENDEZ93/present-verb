package present.verb.dominio.temas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.verb.aplicacion.temas.TemaComando;
import present.verb.dominio.perfil.modelo.Perfil;
import present.verb.dominio.perfil.puerto.repositorio.PerfilRepositorio;

import java.time.LocalDate;

@Service
public class ActualizarTemaServicio {

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    public TemaComando ejecutar(TemaComando temaComando) {
        Perfil perfil = perfilRepositorio.getByCorreo(temaComando.getCorreo());

        temaComando.setUltimaFechaAprendio(LocalDate.now());

        perfilRepositorio
                .actualizar(
                        perfil,
                        temaComando.getNombre(),
                        temaComando.getUltimoIndiceAprendido(),
                        //LocalDate.now().minusDays(1L));
                        temaComando.getUltimaFechaAprendio());

        return temaComando;

    }

}
