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
public class GetFilasExcelScannerTest {

    @Autowired
    private GetFilasExcelScanner getFilasExcelScanner;

    @Test
    public void methodTest1(){

        // Arrange
        String archivo = "ejemplo1.xlsx";
        int indiceHoja = 0;
        int ultimoFila = 0;
        int filasPorAprender = 5;

        // Act
        Fila fila = getFilasExcelScanner.executer(archivo, indiceHoja, ultimoFila, filasPorAprender);

        // Assert
        Assert.assertEquals(4, fila.getEnglish().size());
        Assert.assertEquals(4, fila.getSpanish().size());

    }

    @Test
    public void methodTest2(){

        // Arrange
        String archivo = "ejemplo1.xlsx";
        int indiceHoja = 1;
        int ultimoFila = 0;
        int filasPorAprender = 5;

        // Act
        Fila fila = getFilasExcelScanner.executer(archivo, indiceHoja, ultimoFila, filasPorAprender);

        // Assert
        Assert.assertEquals(5, fila.getEnglish().size());
        Assert.assertEquals(5, fila.getSpanish().size());

    }

    @Test
    public void methodTest3(){

        // Arrange
        String archivo = "ejemplo1.xlsx";
        int indiceHoja = 2;
        int ultimoFila = 0;
        int filasPorAprender = 5;

        // Act
        Fila fila = getFilasExcelScanner.executer(archivo, indiceHoja, ultimoFila, filasPorAprender);

        // Assert
        Assert.assertEquals(2, fila.getEnglish().size());
        Assert.assertEquals(2, fila.getSpanish().size());

    }

    @Test
    public void methodTest4(){

        // Arrange
        String archivo = "ejemplo1.xlsx";
        int indiceHoja = 1;
        int ultimaFila = 4;
        int filasPorAprender = 5;

        // Act
        Fila fila = getFilasExcelScanner.executer(archivo, indiceHoja, ultimaFila, filasPorAprender);

        // Assert
        Assert.assertEquals(1, fila.getEnglish().size());
        Assert.assertEquals(1, fila.getSpanish().size());


    }

}
