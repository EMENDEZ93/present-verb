package present.verb.aplicacion.perfil.comando;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import present.verb.ApplicationMock;
import present.verb.dominio.perfil.modelo.Perfil;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ApplicationMock.class} )
public class PerfilFabricaTest {

    @Autowired
    private PerfilFabrica perfilFabrica;

    @Test
    public void methodTest() {

        // Arrange
        PerfilComando comando = new PerfilComando();
        comando.setCorreo("Correo");
        comando.setNombre("Nombre");
        comando.setId("ID");
        comando.setUltimoIndiceAprendido(0);

        // Act
        Perfil perfil = perfilFabrica.crear(comando);

        // Assert
        Assert.assertEquals(comando.getId(), perfil.getIdFirebase());
        Assert.assertEquals(comando.getCorreo(), perfil.getCorreo());
        Assert.assertEquals(comando.getUltimoIndiceAprendido(), perfil.getUltimoIndiceAprendido());

    }

}
