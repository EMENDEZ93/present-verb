package present.verb.infraestructura.fila.dao;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.dominio.fila.modelo.Oracion;
import present.verb.infraestructura.conversacion.dao.GetConversacionExcelScanner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class GetConversacionExcelScannerTest {

    @Autowired
    private GetConversacionExcelScanner getConversacionExcelScanner;

    @Test
    public void methodTest(){

        // Arrange
        int idHoja = 8;

        // Act
        List<Oracion> conversacion = getConversacionExcelScanner.executer(idHoja);

        // Assert
        Assert.assertEquals(4, conversacion.size());

    }

}
