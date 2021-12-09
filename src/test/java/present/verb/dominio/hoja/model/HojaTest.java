package present.verb.dominio.hoja.model;

import org.junit.Assert;
import org.junit.Test;

public class HojaTest {

    @Test
    public void methodTest(){

        // Arrange
        Hoja hoja = new Hoja();
        hoja.setFilas(12);
        hoja.setUltimoIndiceAprendido(10);
        hoja.setNumeroVerbosPorAprenderDiario(5);

        // Act
        hoja.updateUltimaFechAprendido();

        // Assert
        Assert.assertEquals(12, hoja.getUltimoIndiceAprendido());

    }

}
