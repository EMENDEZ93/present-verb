package present.verb.dominio.perfil.puerto.repositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import present.verb.ApplicationMock;
import present.verb.dominio.perfil.modelo.Perfil;
import present.verb.dominio.temas.servicio.ObtenerTemasV1Servicio;

import static org.junit.Assert.fail;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class PerfilRepositorioTest {

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    @Test
    public void methodTest() {

        // Arrange
        String correo = "perfil01@em.com.co";

        // Act
        Perfil resultado = perfilRepositorio.getByCorreo(correo);

        // Assert
        Assert.assertNotNull(resultado);
        Assert.assertEquals(correo, resultado.getCorreo());

    }


    @Test
    public void noExiste() {

        // Arrange
        String correo = "noExiste@em.com.co";

        try {
            // Act
            Perfil resultado = perfilRepositorio.getByCorreo(correo);
            fail("Debe generar excepcion");
        } catch (Exception e) {
            // Assert
            Assert.assertEquals("No existe un perfil con ese correo", e.getMessage());
        }

    }


    @Test
    public void correoVacio() {

        // Arrange
        String correo = "";

        try {
            // Act
            Perfil resultado = perfilRepositorio.getByCorreo(correo);
            fail("Debe generar excepcion");
        } catch (Exception e) {
            // Assert
            Assert.assertEquals("No existe un perfil con ese correo", e.getMessage());
        }

    }


}
