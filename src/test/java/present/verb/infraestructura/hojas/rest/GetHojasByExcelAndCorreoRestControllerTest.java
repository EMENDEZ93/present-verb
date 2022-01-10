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


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class GetHojasByExcelAndCorreoRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void existTemaAndUsuario() throws Exception {

        // Arrange
        String correo = "testing01@em.com.co";
        String excel = "Intellij.xlsx";

        // Act
        ResultActions resultActions = this.mockMvc.perform(get("/hojas/" + excel + "/" + correo));


        // Assert
        resultActions.andExpect(jsonPath("$.[0].nombre").value("hojaA.lxs"));
        resultActions.andExpect(jsonPath("$.[1].nombre").value("hojaB.lxs"));

    }


//    @Test
//    public void noExistExcelAndUsuario() throws Exception {
//
//        // Arrange
//        String correo = "testing12@em.com.co";
//        String excel = "ejemplo1.xlsx";
//
//        // Act
//        ResultActions resultActions = this.mockMvc.perform(get("/hojas/" + excel + "/" + correo));
//
//
//        // Assert
//        resultActions.andExpect(jsonPath("$.[0].nombre").value("hojaejemplo11"));
//        resultActions.andExpect(jsonPath("$.[1].nombre").value("hojaejemplo33"));
//
//    }


}
