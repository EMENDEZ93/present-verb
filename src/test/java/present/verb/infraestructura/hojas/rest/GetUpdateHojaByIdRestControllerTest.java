package present.verb.infraestructura.hojas.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class GetUpdateHojaByIdRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void methodTest() throws Exception {

        // Arrange
        int idHoja = 3;

        // Act
        ResultActions resultActions = this.mockMvc.perform(get("/hoja/" + idHoja ));

        // Assert
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$.nombre").value("hojaC.lxs"));
        resultActions.andExpect(jsonPath("$.ultimoIndiceAprendido").value("25"));
        resultActions.andExpect(jsonPath("$.ultimaFechaAprendio").value(LocalDate.now().toString()));

    }


}
