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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class GetExcelScannerTest {

    @Autowired
    private GetExcelScanner getExcelScanner;

    @Test
    public void getExcel1(){

        // Arrange
        String nombreExcel = "ejemplo1.xlsx";

        // Act
        Excel excel = getExcelScanner.executer(nombreExcel);

        // Assert
        Assert.assertEquals(nombreExcel, excel.getNombre());
        Assert.assertEquals(3, excel.getHojas().size());

        Assert.assertEquals("hojaejemplo1", excel.getHojas().get(0).getNombre());
        Assert.assertEquals(4, excel.getHojas().get(0).getFilas());
        Assert.assertEquals(0, excel.getHojas().get(0).getIndiceExcel());

        Assert.assertEquals("hojaejemplo2", excel.getHojas().get(1).getNombre());
        Assert.assertEquals(5, excel.getHojas().get(1).getFilas());
        Assert.assertEquals(1, excel.getHojas().get(1).getIndiceExcel());

        Assert.assertEquals("hojaejemplo3", excel.getHojas().get(2).getNombre());
        Assert.assertEquals(2, excel.getHojas().get(2).getFilas());
        Assert.assertEquals(2, excel.getHojas().get(2).getIndiceExcel());

    }


    @Test
    public void getExcel2(){

        // Arrange
        String nombreExcel = "ejemplo2.xlsx";

        // Act
        Excel excel = getExcelScanner.executer(nombreExcel);

        // Assert
        Assert.assertEquals(nombreExcel, excel.getNombre());
        Assert.assertEquals(3, excel.getHojas().size());

        Assert.assertEquals("hojaejemplo2.1", excel.getHojas().get(0).getNombre());
        Assert.assertEquals(4, excel.getHojas().get(0).getFilas());
        Assert.assertEquals(0, excel.getHojas().get(0).getIndiceExcel());

        Assert.assertEquals("hojaejemplo2.2", excel.getHojas().get(1).getNombre());
        Assert.assertEquals(5, excel.getHojas().get(1).getFilas());
        Assert.assertEquals(1, excel.getHojas().get(1).getIndiceExcel());

        Assert.assertEquals("hojaejemplo2.3", excel.getHojas().get(2).getNombre());
        Assert.assertEquals(2, excel.getHojas().get(2).getFilas());
        Assert.assertEquals(2, excel.getHojas().get(2).getIndiceExcel());

    }


    @Test
    public void getExcel3(){

        // Arrange
        String nombreExcel = "ejemplo3.xlsx";

        // Act
        Excel excel = getExcelScanner.executer(nombreExcel);

        // Assert
        Assert.assertEquals(nombreExcel, excel.getNombre());
        Assert.assertEquals(3, excel.getHojas().size());

        Assert.assertEquals("hojaejemplo3.1", excel.getHojas().get(0).getNombre());
        Assert.assertEquals(4, excel.getHojas().get(0).getFilas());
        Assert.assertEquals(0, excel.getHojas().get(0).getIndiceExcel());

        Assert.assertEquals("hojaejemplo3.2", excel.getHojas().get(1).getNombre());
        Assert.assertEquals(5, excel.getHojas().get(1).getFilas());
        Assert.assertEquals(1, excel.getHojas().get(1).getIndiceExcel());

        Assert.assertEquals("hojaejemplo3.3", excel.getHojas().get(2).getNombre());
        Assert.assertEquals(2, excel.getHojas().get(2).getFilas());
        Assert.assertEquals(2, excel.getHojas().get(2).getIndiceExcel());

    }

}
