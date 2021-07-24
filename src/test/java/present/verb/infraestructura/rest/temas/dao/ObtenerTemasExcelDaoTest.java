package present.verb.infraestructura.rest.temas.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.infraestructura.temas.dao.ObtenerTemasExcelDao;
import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {
})
@ActiveProfiles("testing")
@AutoConfigureMockMvc
public class ObtenerTemasExcelDaoTest {

    @Test
    public void ejecutar() {

        // Arrange
        String correo = "edwin.mendez@em.com.co";
        ObtenerTemasExcelDao dao = new ObtenerTemasExcelDao();

        // Act
        List<TemaDto> temaDtos =  dao.obtener(correo);

        // Assert
        Assert.assertEquals("", 2);

    }

}
