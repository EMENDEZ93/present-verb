package present.verb.dominio.temas.puerto.repositorio;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.temas.puerto.repository.GetHojasByExcelAndCorreoRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {} )
@ActiveProfiles("testing-h2")
@DataJpaTest
public class GetHojasByExcelAndCorreoRepositoryTest {

    @Autowired
    private GetHojasByExcelAndCorreoRepository repository;

    @Test
    public void excelExiste(){

        // Arrange
        String correo = "testing01@em.com.co";
        String excel = "excel.lxs";

        // Act
        List<Hoja> hojas = repository.execute(excel, correo);

        Assert.assertEquals(2, hojas.size());

        // Assert hoja A
        Assert.assertEquals("hojaA.lxs", hojas.get(0).getNombre());
        Assert.assertEquals(5, hojas.get(0).getUltimoIndiceAprendido());
        Assert.assertEquals(3, hojas.get(0).getRepeticionesAltaComoAprendido());
        Assert.assertEquals(10, hojas.get(0).getNumeroVerbosPorAprenderDiario());
        Assert.assertEquals(java.sql.Date.valueOf("2021-07-21").toLocalDate(), hojas.get(0).getUltimaFechaAprendio());
        Assert.assertEquals(java.sql.Date.valueOf("2021-06-21").toLocalDate(), hojas.get(0).getUltimaFechaRutina());
        Assert.assertFalse(hojas.get(0).isEsPreguntaRespuesta());
        Assert.assertEquals(11, hojas.get(0).getIndiceExcel());
        Assert.assertEquals(88, hojas.get(0).getFilas());

        // Assert hoja B
        Assert.assertEquals("hojaB.lxs", hojas.get(1).getNombre());


    }



    @Test
    public void excelNoExiste(){

        // Arrange
        String correo = "testing01@em.com.co";
        String excel = "excelNoExiste.lxs";

        // Act
        List<Hoja> hojas = repository.execute(correo, excel);


        // Assert
        Assert.assertTrue(hojas.isEmpty());


    }


}
