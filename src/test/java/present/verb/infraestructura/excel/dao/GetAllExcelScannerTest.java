package present.verb.infraestructura.excel.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.dominio.excel.modelo.Excel;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class GetAllExcelScannerTest {

    @Autowired
    private GetAllExcelScanner getAllExcelScanner;

    @Test
    public void methodTest(){

        // Arrange

        // Act
        List<Excel> excels = getAllExcelScanner.executer();

        // Assert
        Assert.assertEquals(5, excels.size());

    }

}
