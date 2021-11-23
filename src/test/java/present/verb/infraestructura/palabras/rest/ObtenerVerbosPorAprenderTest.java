package present.verb.infraestructura.palabras.rest;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class ObtenerVerbosPorAprenderTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void methodTest() throws Exception {

        // Arrange
        int ultimoIndiceVerboAprendido = 0;
        int numeroVerbosPorAprenderDiario = 5;
        int hojaTemaExcel = 5;

        // Act
        ResultActions resultActions = this.mockMvc.perform(
                get("/verbosporaprender/" +
                        ultimoIndiceVerboAprendido + "/" +
                        numeroVerbosPorAprenderDiario + "/" +
                        hojaTemaExcel)
        );


        // Act

        // Assert

    }

}
