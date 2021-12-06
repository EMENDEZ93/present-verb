package present.verb.dominio.excel.model;

import org.junit.Assert;
import org.junit.Test;
import present.verb.dominio.excel.modelo.Excel;

import java.time.ZonedDateTime;

public class ExcelTest {

    @Test
    public void debeRealizarRepeticion(){

        // Arrange
        Excel excel = new Excel();
        excel.setHoraActualizacionIndiceRepaso(1);
        excel.setRepeticionPorHoras(8);
        int horaActual = 9;

        // Act
        boolean resultado = excel.debeRealizarRepeticion(horaActual);

        // Assert
        Assert.assertTrue(resultado);

    }


    @Test
    public void debeRealizarRepeticionCaso2(){

        // Arrange
        Excel excel = new Excel();
        excel.setHoraActualizacionIndiceRepaso(1);
        excel.setRepeticionPorHoras(8);
        int horaActual = 10;

        // Act
        boolean resultado = excel.debeRealizarRepeticion(horaActual);

        // Assert
        Assert.assertTrue(resultado);

    }


    @Test
    public void debeRealizarRepeticionCaso3(){

        // Arrange
        Excel excel = new Excel();
        excel.setHoraActualizacionIndiceRepaso(1);
        excel.setRepeticionPorHoras(8);
        int horaActual = 8;

        // Act
        boolean resultado = excel.debeRealizarRepeticion(horaActual);

        // Assert
        Assert.assertFalse(resultado);

    }

    @Test
    public void debeRealizarRepeticionCaso4(){

        // Arrange
        Excel excel = new Excel();
        excel.setHoraActualizacionIndiceRepaso(17);
        excel.setRepeticionPorHoras(8);
        int horaActual = 0;

        // Act
        boolean resultado = excel.debeRealizarRepeticion(horaActual);

        // Assert
        Assert.assertTrue(resultado);

    }

    @Test
    public void methodTest(){

        // Arrange
        Excel excel = new Excel();

        // Act
        boolean resultado = excel.debeRealizarRepeticion(ZonedDateTime.now().getHour());

        // Assert
        Assert.assertFalse(resultado);

    }


}
