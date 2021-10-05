package present.verb.infraestructura.perfil.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import present.verb.aplicacion.perfil.consulta.PerfilDto;
import present.verb.dominio.perfil.modelo.Perfil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {
})
//@ActiveProfiles("testing")
@AutoConfigureMockMvc
public class ObtenerPerfilRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void ejecutar() throws Exception {

        // Arrange
        String correo = "testing@gmail.com";

        // Act
        ResultActions resultActions = this.mockMvc.perform(get("/perfil/" + correo + "/Guessing"));

        // Assert
        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();

        Perfil resultado = objectMapper.readValue(contentAsString, Perfil.class);

        Assert.assertEquals("", resultado.getId());


    }

}
