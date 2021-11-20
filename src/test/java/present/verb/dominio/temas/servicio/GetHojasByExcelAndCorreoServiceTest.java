package present.verb.dominio.temas.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.dominio.hoja.model.Hoja;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class GetHojasByExcelAndCorreoServiceTest {

    @Autowired
    private GetHojasByExcelAndCorreoService getHojasByExcelAndCorreoService;

    @Test
    public void existeRegistros(){

        // Arrange
        String correo = "testing01@em.com.co";
        String excel = "excel.lxs";

        // Act
        List<Hoja> hojas = getHojasByExcelAndCorreoService.excecute(excel, correo);

        // Assert
        Assert.assertFalse(hojas.isEmpty());

    }


    @Test
    public void noExisteRegistrosLeerArchivo(){

        // Arrange
        String correo = "testing03@em.com.co";
        String excel = "ejemplo1.xlsx";

        // Act
        List<Hoja> hojas = getHojasByExcelAndCorreoService.excecute(excel, correo);

        // Assert
        Assert.assertFalse(hojas.isEmpty());

    }



}
