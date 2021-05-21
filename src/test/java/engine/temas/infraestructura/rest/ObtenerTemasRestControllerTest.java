package engine.temas.infraestructura.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import present.verb.PresentVerbApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PresentVerbApplication.class)
@ActiveProfiles("testing")
@AutoConfigureMockMvc
public class ObtenerTemasRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ejecutar() throws Exception {

        // Arrange
        String correo = "edwin@em.com";

        // Act
        ResultActions resultActions = this.mockMvc.perform(get("/temas/edwin.mendez@em.com.co"));

        // Assert
        resultActions.andExpect(jsonPath("$.[0].tema").value("Adjectives"));

    }


}
