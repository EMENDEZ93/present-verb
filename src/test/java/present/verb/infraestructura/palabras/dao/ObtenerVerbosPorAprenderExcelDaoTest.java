package present.verb.infraestructura.palabras.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.dominio.palabras.modelo.PalabraDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class ObtenerVerbosPorAprenderExcelDaoTest {

    @Autowired
    private ObtenerVerbosPorAprenderExcelDao obtenerVerbosPorAprenderExcelDao;

    @Test
    public void methodTest(){

        // Arrange
        int ultimoIndiceVerboAprendido = 0;
        int numeroVerbosPorAprenderDiario = 5;
        int hojaTemaExcel = 0;

        // Act
        PalabraDto palabraDto = obtenerVerbosPorAprenderExcelDao
                .ejecutar(ultimoIndiceVerboAprendido, numeroVerbosPorAprenderDiario, hojaTemaExcel);

        // Assert
        Assert.assertEquals(5, palabraDto.getEnglish().size());
        Assert.assertEquals(5, palabraDto.getSpanish().size());

    }


}
