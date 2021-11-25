package present.verb.infraestructura.temas.rest;


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
import org.springframework.test.web.servlet.ResultActions;
import present.verb.aplicacion.temas.TemaComando;
import present.verb.dominio.perfil.modelo.Temas;
import present.verb.dominio.perfil.puerto.repositorio.TemasRepositorio;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
@ActiveProfiles("testing-h2")
@AutoConfigureMockMvc
public class ActualizarTemaRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TemasRepositorio temasRepositorio;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void actualizar() throws Exception {

        // Arrange
        TemaComando temaComando = new TemaComando("tema3", "perfil02@em.com.co", 10);

        // Act
        Temas before = temasRepositorio.findByNombreAndPerfilCorreo(temaComando.getNombre(), temaComando.getCorreo());


        ResultActions resultActions = this.mockMvc.perform(post("/tema")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(temaComando)))
                .andExpect(status().isOk());


        // Assert
        Temas b = temasRepositorio.findByNombreAndPerfilCorreo(temaComando.getNombre(), temaComando.getCorreo());

        Assert.assertEquals(LocalDate.now(), b.getUltimaFechaAprendio());
        Assert.assertNotEquals(before.getUltimoIndiceAprendido(), b.getUltimoIndiceAprendido());
    }


}
