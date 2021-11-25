package present.verb.infraestructura.temas.dao;

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
import present.verb.aplicacion.palabras.TemaDto;
import present.verb.dominio.perfil.puerto.repositorio.PerfilRepositorio;
import present.verb.dominio.temas.servicio.ObtenerTemasV1Servicio;

import java.util.List;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class ObtenerTemasExcelDaoTest {

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    @Autowired
    private ObtenerTemasExcelDao dao;

    @Test
    public void ejecutarCorreo() {

        // Arrange
        String correo = "perfil01@em.com.co";

        // Act
        List<TemaDto> temaDtos = dao.ejecutar(correo);

        // Assert
        Assert.assertEquals(2, temaDtos.size());

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
        Assert.assertEquals(51, temaDtos.size());

    }

}
