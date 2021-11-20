package present.verb.infraestructura.excel.rest;


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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class GetAllExcelRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void existTemaAndUsuario() throws Exception {

        // Arrange

        // Act
        ResultActions resultActions = this.mockMvc.perform(get("/excels"));

        // Assert
        resultActions.andExpect(jsonPath("$.[0].nombre").value("ejemplo1"));
        resultActions.andExpect(jsonPath("$.[1].nombre").value("ejemplo2"));
        resultActions.andExpect(jsonPath("$.[2].nombre").value("ejemplo3"));

    }

}
