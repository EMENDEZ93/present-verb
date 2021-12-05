package present.verb.dominio.excel.port;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.hoja.port.GetHojaByExcelAndCorreoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class GetHojaByExcelAndCorreoRepositoryTest {

    @Autowired
    private GetHojaByExcelAndCorreoRepository getHojaByExcelAndCorreoRepository;

    @Test
    public void methodTest(){

        // Arrange
        String correo = "testing11@em.com.co";
        String excel = "excelnoesfisico.xlsx";

        // Act
        Excel resultado = getHojaByExcelAndCorreoRepository.executer(excel, correo);

        // Assert
        Assert.assertEquals("excelnoesfisico.xlsx", resultado.getNombre());
        Assert.assertEquals(11, resultado.getId());
        Assert.assertEquals(5, resultado.getCantidadhojasPorRutina());

    }

}
