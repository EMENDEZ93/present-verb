package engine.perfil.infraestructura.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import present.verb.PresentVerbApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PresentVerbApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ObtenerPerfilRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ejecutar() throws Exception {

        this.mockMvc.perform(get("/perfil/edwin@em.com.co/Can")).andExpect(status().isOk());
    }

}
