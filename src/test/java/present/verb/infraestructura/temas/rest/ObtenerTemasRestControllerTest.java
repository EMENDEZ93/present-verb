package present.verb.infraestructura.temas.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {})
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class ObtenerTemasRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ejecutar() throws Exception {

        // Arrange
        String correo = "edwin@em.com";

        // Act
        ResultActions resultActions = this.mockMvc.perform(get("/temas/perfil01@em.com.co"));

        // Assert
        resultActions.andExpect(jsonPath("$.[0].tema").value("tema1"));

    }


    @Test
    public void temas() throws Exception {

        // Arrange

        // Act
        ResultActions resultActions = this.mockMvc.perform(get("/v2/temas"));

        // Assert
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$.[0].tema").value("A"));
        resultActions.andExpect(jsonPath("$.[1].tema").value("B"));
        resultActions.andExpect(jsonPath("$.[2].tema").value("C"));

    }


    @Test
    public void obtenerTemasRealizadoHoy() throws Exception {

        // Arrange
        String correo = "edwin.mendez@em.com.co";

        // Act
        ResultActions resultActions = this.mockMvc.perform(get("/v2/temas/".concat(correo)));

        // Assert
        resultActions.andExpect(status().isOk());

    }


}
