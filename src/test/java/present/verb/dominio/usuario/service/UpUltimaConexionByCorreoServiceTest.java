package present.verb.dominio.usuario.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.dominio.usuario.modelo.Usuario;
import present.verb.dominio.usuario.puerto.UsuarioRepository;

import static java.time.LocalDate.now;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class UpUltimaConexionByCorreoServiceTest {

    @Autowired
    private UpUltimaConexionByCorreoService upUltimaConexionByCorreoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void methodTest(){

        // Arrange
        String corre = "testing01@em.com.co";

        // Act
        upUltimaConexionByCorreoService.executer(corre);
        Usuario resultado = usuarioRepository.findByCorreo(corre);

        // Assert
        Assert.assertEquals(now(), resultado.getUltimaConexion());

    }

}
