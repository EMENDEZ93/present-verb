package present.verb.infraestructura.fila.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.dominio.fila.modelo.Fila;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class GetFilasAprenderExcelScannerTest {

    @Autowired
    private GetFilasAprenderExcelScanner getFilasAprenderExcelScanner;

    @Test
    public void methodTest3(){

        // Arrange
        int idHoja = 8;

        // Act
        Fila fila = getFilasAprenderExcelScanner.executer(idHoja);

        // Assert
        Assert.assertEquals(1, fila.getEnglish().size());
        Assert.assertEquals(1, fila.getSpanish().size());

    }

    @Test
    public void methodTest4(){

        // Arrange
        int idHoja = 8;

        // Act
        Fila fila = getFilasAprenderExcelScanner.executer(idHoja);

        // Assert
        Assert.assertEquals(1, fila.getEnglish().size());
        Assert.assertEquals(1, fila.getSpanish().size());

    }

    @Test
    public void methodTestError(){

        // Arrange
        int idHoja = 7;

        // Act
        Fila fila = getFilasAprenderExcelScanner.executer(idHoja);

        // Assert
        Assert.assertEquals(4, fila.getEnglish().size());
        Assert.assertEquals(4, fila.getSpanish().size());

    }


    @Test
    public void methodTest6(){

        // Arrange
        int idHoja = 6;

        // Act
        Fila fila = getFilasAprenderExcelScanner.executer(idHoja);

        // Assert
        Assert.assertEquals(5, fila.getEnglish().size());
        Assert.assertEquals(5, fila.getSpanish().size());

    }
}
