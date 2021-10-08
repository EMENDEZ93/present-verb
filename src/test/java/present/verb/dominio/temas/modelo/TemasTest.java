package present.verb.dominio.temas.modelo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import present.verb.ApplicationMock;
import present.verb.dominio.perfil.modelo.Temas;
import present.verb.dominio.perfil.puerto.repositorio.TemasRepositorio;
import present.verb.dominio.temas.servicio.ObtenerTemasV1Servicio;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ApplicationMock.class, ObtenerTemasV1Servicio.class} )
@DataJpaTest
public class TemasTest {

    @Autowired
    private TemasRepositorio temasRepositorio;

    @Test
    public void realizoAntesFechaHoy() {

        // Arrange
        Temas temas = temasRepositorio.getOne(1L);

        // Act
        boolean respuesta = temas.getRealizadoAprenderHoy();

        // Assert
        Assert.assertFalse(respuesta);

    }


    @Test
    public void realizoFechaHoy() {

        // Arrange
        Temas temas = temasRepositorio.getOne(2L);
        temas.setUltimaFechaAprendio(LocalDate.now());

        // Act
        boolean respuesta = temas.getRealizadoAprenderHoy();

        // Assert
        Assert.assertTrue(respuesta);

    }

}
