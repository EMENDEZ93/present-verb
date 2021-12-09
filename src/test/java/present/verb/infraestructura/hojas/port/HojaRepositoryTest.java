package present.verb.infraestructura.hojas.port;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.port.HojaRepository;

import static java.time.LocalDate.now;
import static java.time.LocalDate.of;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class HojaRepositoryTest {

    @Autowired
    private HojaRepository hojaRepository;

    @Test
    public void methodTest(){

        // Arrange
        int idHoja = 2;

        hojaRepository.findById(idHoja)
                .ifPresent(
                        hoja -> {
                            Assert.assertEquals(of(2021,8,21), hoja.getUltimaFechaAprendio());
                            Assert.assertEquals(10, hoja.getUltimoIndiceAprendido());
                        }
                );

        // Act
        Hoja hoja = hojaRepository.updateUlfimaFechaAndUltimoIndice(idHoja);

        // Assert
        Assert.assertEquals(now(), hoja.getUltimaFechaAprendio());
        Assert.assertEquals(15, hoja.getUltimoIndiceAprendido());

    }


    @Test
    public void methodTest1(){
        // Arrange
        int idHoja = 200;

        // Act
        try {
            hojaRepository.updateUlfimaFechaAndUltimoIndice(idHoja);
            fail("Debe generar error ya que no existe dicha hoja.....");
        } catch (Exception e) {
            // Assert
            Assert.assertEquals("No Existe un Hoja con el id = 200", e.getMessage());
        }

    }


    @Test
    public void actualizarUltimaFechaRutina(){

        // Arrange
        int idHoja = 2;

        hojaRepository.findById(idHoja)
                .ifPresent(
                        hoja -> {
                            Assert.assertEquals(of(2021,5,21), hoja.getUltimaFechaRutina());
                        }
                );

        // Act
        Hoja hoja = hojaRepository.updateUlfimaFechaRutina(idHoja);

        // Assert
        Assert.assertEquals(now(), hoja.getUltimaFechaRutina());

    }


    @Test
    public void actualizarDiaRutina(){

        // Arrange
        int idHoja = 2;
        int diaRutina = 1;

        hojaRepository.findById(idHoja)
                .ifPresent(
                        hoja -> {
                            Assert.assertFalse(hoja.getPorRutina());
                        }
                );

        // Act
        Hoja hoja = hojaRepository.updatePorRutina(idHoja);

        // Assert
        Assert.assertTrue(hoja.getPorRutina());

    }

}
