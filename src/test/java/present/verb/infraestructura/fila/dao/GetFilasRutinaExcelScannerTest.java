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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class GetFilasRutinaExcelScannerTest {

    @Autowired
    private GetFilasRutinaExcelScanner getFilasRutinaExcelScanner;

    @Test
    public void methodTestError(){

        // Arrange
        int idHoja = 1;

        // Act
        Fila fila = getFilasRutinaExcelScanner.executer(idHoja);

        // Assert
        Assert.assertEquals(5, fila.getEnglish().size());
        Assert.assertEquals(5, fila.getSpanish().size());

    }

    @Test
    public void methodTest() {

        List<String> a = Arrays.asList("a", "b", "c");
        Collections.nCopies(5, a).forEach(strings ->
                a.addAll(strings)
        );
        Assert.assertEquals(0, a.size());
    }


    @Test
    public void methodDosTest() {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");


        List<String> b = getRepeticiones(a);

        System.out.println(b);
    }

    private static List<String> getRepeticiones(List<String> a) {
        IntStream intStream = IntStream.iterate(0, x -> x + 1);
        List<String> b = new ArrayList<>();
        intStream.limit(30).forEach(value ->
            b.addAll(a)
        );
        return b;
    }

}
