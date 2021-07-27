package present.verb.infraestructura.perfil.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import present.verb.aplicacion.perfil.comando.PerfilComando;
import present.verb.dominio.perfil.modelo.Perfil;
import present.verb.dominio.perfil.puerto.repositorio.PerfilRepositorio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {
})
@ActiveProfiles("testing")
@AutoConfigureMockMvc
public class RegistrarPerfilRestControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private PerfilRepositorio perfilRepositorio;


    @Test
    public void crear() throws Exception{

        // arrange
        PerfilComando comando = new PerfilComando();
        comando.setId("idFirebase");
        comando.setCorreo("TestingCorreo@em.com.co");
        comando.setUltimoIndiceAprendido(0);

        // act - assert
        mocMvc.perform(post("/perfil")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comando)))
                .andExpect(status().isOk());


        Perfil resultado = perfilRepositorio.findByCorreo(comando.getCorreo());

        Assert.assertEquals(14, resultado.getTemas().size());

    }


}
