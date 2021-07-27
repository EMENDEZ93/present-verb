package present.verb.infraestructura.temas.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import present.verb.ApplicationMock;
import present.verb.aplicacion.palabras.TemaDto;
import present.verb.dominio.perfil.puerto.repositorio.PerfilRepositorio;
import present.verb.dominio.temas.servicio.ObtenerTemasV1Servicio;

import java.util.List;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ApplicationMock.class, ObtenerTemasV1Servicio.class} )
@DataJpaTest
public class ObtenerTemasExcelDaoTest {

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    @Autowired
    private ObtenerTemasExcelDao dao;

    @Test
    public void ejecutarCorreo() {

        // Arrange
        String correo = "testing01@em.com.co";

        // Act
        List<TemaDto> temaDtos = dao.ejecutar(correo);

        // Assert
        Assert.assertEquals(14, temaDtos.size());

    }

    @Test
    public void noExisteUsuario() {

        // Arrange
        String correo = "noExiste@em.com.co";

        try {
            // Act
            List<TemaDto> temaDtos = dao.ejecutar(correo);
            fail("Debe generar excepcion");
        } catch (Exception e) {

            // Assert
            Assert.assertEquals("No existe un perfil con ese correo", e.getMessage());
        }

    }



    @Test
    public void ejecutarSinCorreo() {

        // Arrange
        String correo = "testing01@em.com.co";

        // Act
        List<TemaDto> temaDtos = dao.ejecutar();

        // Assert
        Assert.assertEquals(14, temaDtos.size());

    }

}
