package engine.perfil.infraestructura.rest.dao.temas;

import org.junit.Assert;
import org.junit.Test;
import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;
import present.verb.temas.infraestructura.dao.ObtenerTemasEscanerCarpeta;

import java.util.List;

public class ObtenerTemasEscanerCarpetaTest {

    @Test
    public void ejecutar() {

        // Arrange
        ObtenerTemasEscanerCarpeta obtenerTemasEscanerCarpeta = new ObtenerTemasEscanerCarpeta();

        // Act
        List<TemaDto> resultado =  obtenerTemasEscanerCarpeta.ejecutar();

        // Assert
        Assert.assertEquals(3, resultado.size());
        Assert.assertEquals("A", resultado.get(1).getTema());
        Assert.assertEquals("B", resultado.get(0).getTema());
        Assert.assertEquals("C", resultado.get(2).getTema());

    }

}
