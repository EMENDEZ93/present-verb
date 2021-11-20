package present.verb.infraestructura.hojas.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.usuario.modelo.Usuario;
import present.verb.dominio.usuario.puerto.UsuarioRepository;
import present.verb.infraestructura.excel.dao.GetExcelScanner;
import present.verb.infraestructura.hoja.dao.SaveHojasByExcelAndCorreoPG;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class SaveHojasByExcelAndCorreoPGTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SaveHojasByExcelAndCorreoPG saveHojasByExcelAndCorreoPG;

    @Autowired
    private GetExcelScanner getExcelScanner;

    @Test
    public void methodTest(){

        // Arrange
        String correo = "testing03@em.com.co";
        String nombreExcel = "ejemplo1.xlsx";

        Usuario usuario = usuarioRepository.findByCorreo(correo);
        Assert.assertEquals(0, usuario.getExcels().size());

        // Act
        List<Hoja> hojas = saveHojasByExcelAndCorreoPG.executer(nombreExcel, correo);

        // Assert
        Assert.assertEquals(3, hojas.size());

        Usuario usuarioPost = usuarioRepository.findByCorreo(correo);
        Assert.assertEquals(1, usuarioPost.getExcels().size());
        Assert.assertEquals(3, usuarioPost.getExcels().get(0).getHojas().size());


    }


}
