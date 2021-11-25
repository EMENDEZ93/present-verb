package present.verb.dominio.temas.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.aplicacion.temas.TemaComando;
import present.verb.dominio.perfil.modelo.Temas;
import present.verb.dominio.perfil.puerto.repositorio.TemasRepositorio;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class ActualizarTemaServicioTest {

    @Autowired
    private ActualizarTemaServicio actualizarTemaServicio;

    @Autowired
    private TemasRepositorio temasRepositorio;

    @Test
    public void methodTest(){

        // Arrange
        TemaComando temaComando = new TemaComando();
        temaComando.setNombre("tema1");
        temaComando.setCorreo("perfil01@em.com.co");
        temaComando.setUltimoIndiceAprendido(10);
        temaComando.setUltimaFechaAprendio(LocalDate.now());

        Temas temasactual = temasRepositorio
                .findByNombreAndPerfilCorreo(temaComando.getNombre(), temaComando.getCorreo());

        Assert.assertEquals(LocalDate.of(2021, 06,21), temasactual.getUltimaFechaRutina());
        Assert.assertEquals(5, temasactual.getUltimoIndiceAprendido());

        // Act
        actualizarTemaServicio.ejecutar(temaComando);
        Temas temasRespuesta = temasRepositorio
                .findByNombreAndPerfilCorreo(temaComando.getNombre(), temaComando.getCorreo());


        // Assert
        Assert.assertEquals(LocalDate.now(), temasRespuesta.getUltimaFechaAprendio());
        Assert.assertEquals(10, temasRespuesta.getUltimoIndiceAprendido());

    }

}
