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
import present.verb.dominio.excel.puerto.ExcelRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class ExcelRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ExcelRepository excelRepository;

    @Test
    public void methodTest(){

        // Arrange
        Excel excel = new Excel();
        excel.setArchivo("Archivo.xls");
        excel.setNombre("Archivo");

        // Act
        Excel excelResultado = excelRepository.save(excel);


        // Assert
        //Assert.assertEquals(5, excelResultado.getHojasPorRutina().size());

    }

    @Test
    public void methodTest2(){

        // Arrange
        String correo = "testing11@em.com.co";
        String excel = "excelnoesfisico.xlsx";


        // Act
       // Excel excelResultado = excelRepository.findByNombreJoinCorreo(excel, correo);


        // Assert
       // Assert.assertEquals(5, 0);

    }


}


