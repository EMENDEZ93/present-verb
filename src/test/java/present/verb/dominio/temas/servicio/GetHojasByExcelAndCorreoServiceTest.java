//package present.verb.dominio.temas.servicio;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import present.verb.dominio.excel.modelo.Excel;
//import present.verb.dominio.hoja.model.Hoja;
//import present.verb.dominio.hoja.model.HojaDto;
//import present.verb.dominio.hoja.port.GetHojaByExcelAndCorreoRepository;
//import present.verb.dominio.hoja.port.HojaRepository;
//import present.verb.dominio.hoja.service.GetHojasByExcelAndCorreoService;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static java.time.LocalDate.now;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = { })
//@ActiveProfiles("testing-h2")
//@AutoConfigureMockMvc
//public class GetHojasByExcelAndCorreoServiceTest {
//
//    @Autowired
//    private GetHojasByExcelAndCorreoService getHojasByExcelAndCorreoService;
//
//    @Autowired
//    private GetHojaByExcelAndCorreoRepository getHojaByExcelAndCorreoRepository;
//
//    @Autowired
//    private HojaRepository hojaRepository;
//
//    /*@Test
//    public void existeRegistros(){
//
//        // Arrange
//        String correo = "testing01@em.com.co";
//        String excel = "excel.lxs";
//
//        // Act
//        List<HojaDto> hojas = getHojasByExcelAndCorreoService.excecute(excel, correo);
//
//        // Assert
//        Assert.assertFalse(hojas.isEmpty());
//
//    }*/
//
//
//    @Test
//    public void noExisteRegistrosLeerArchivo(){
//
//        // Arrange
//        String correo = "testing03@em.com.co";
//        String excel = "ejemplo1.xlsx";
//
//        // Act
//        List<HojaDto> hojas = getHojasByExcelAndCorreoService.excecute(excel, correo);
//
//        // Assert
//        Assert.assertFalse(hojas.isEmpty());
//
//    }
//
//
//    /*@Test
//    public void ex(){
//
//        // Arrange
//        String correo = "testing10@em.com.co";
//        String excel = "excelnoesfisico.xlsx";
//        int horaActual = 5;
//
//        Excel excelPrevio = getHojaByExcelAndCorreoRepository.executer(excel, correo);
//        Assert.assertEquals("2021-06-21", excelPrevio.getActualizacionIndiceRepaso().toString());
//        Assert.assertEquals(null, excelPrevio.getUltimoIndiceRepaso());
//        Assert.assertEquals(5, excelPrevio.getCantidadhojasPorRutina().intValue());
//
//
//        // Act
//        List<Hoja> hoj = hojaRepository.findAll();
//        System.out.println("Tamaño actal -> " +  hoj.size());
//
//
//        List<HojaDto> hojas = getHojasByExcelAndCorreoService.excecutev2(excel, correo, horaActual);
//
//        // Assert
//        Assert.assertFalse(hojas.isEmpty());
//        Excel excelResultado = getHojaByExcelAndCorreoRepository.executer(excel, correo);
//
//        // Asser excel1
//        Assert.assertEquals(now(), excelResultado.getActualizacionIndiceRepaso());
//        Assert.assertEquals(4, excelResultado.getUltimoIndiceRepaso().intValue());
//
//        List<Hoja> hojasAprendidas =  excelResultado.getHojas().stream()
//                .filter(hojaDto -> hojaDto.getUltimoIndiceAprendido() > 0 && hojaDto.getPorRutina())
//                .collect(Collectors.toList());
//
//        Assert.assertEquals(5, hojasAprendidas.size());
//
//    }*/
//
//
//    /*@Test
//    public void ex1(){
//
//        // Arrange
//        String correo = "testing11@em.com.co";
//        String excel = "excelnoesfisico.xlsx";
//        int horaActual = 5;
//
//        Excel excelPrevio = getHojaByExcelAndCorreoRepository.executer(excel, correo);
//        Assert.assertEquals("2021-06-21", excelPrevio.getActualizacionIndiceRepaso().toString());
//        Assert.assertEquals(13, excelPrevio.getUltimoIndiceRepaso().intValue());
//        Assert.assertEquals(5, excelPrevio.getCantidadhojasPorRutina().intValue());
//
//
//        // Act
//        List<HojaDto> hojas = getHojasByExcelAndCorreoService.excecutev2(excel, correo, horaActual);
//
//        // Assert
//        Assert.assertFalse(hojas.isEmpty());
//        Excel excelResultado = getHojaByExcelAndCorreoRepository.executer(excel, correo);
//
//        // Asser excel1
//        Assert.assertEquals(now(), excelResultado.getActualizacionIndiceRepaso());
//        Assert.assertEquals(3, excelResultado.getUltimoIndiceRepaso().intValue());
//
//        List<Hoja> hojasAprendidas =  excelResultado.getHojas().stream()
//                .filter(hojaDto -> hojaDto.getUltimoIndiceAprendido() > 0 && hojaDto.getPorRutina())
//                .collect(Collectors.toList());
//
//        Assert.assertEquals(5, hojasAprendidas.size());
//
//    }*/
//
//    @Test
//    public void ex2(){
//
//        // Arrange
//        String correo = "testing12@em.com.co";
//        String excel = "excelnoesfisico.xlsx";
//        int horaActual = 5;
//
//        Excel excelPrevio = getHojaByExcelAndCorreoRepository.executer(excel, correo);
//        Assert.assertEquals("2021-06-21", excelPrevio.getActualizacionIndiceRepaso().toString());
//        Assert.assertEquals(14, excelPrevio.getUltimoIndiceRepaso().intValue());
//        Assert.assertEquals(5, excelPrevio.getCantidadhojasPorRutina().intValue());
//
//
//        // Act
//        List<HojaDto> hojas = getHojasByExcelAndCorreoService.excecutev2(excel, correo, horaActual);
//
//        // Assert
//        Assert.assertFalse(hojas.isEmpty());
//        Excel excelResultado = getHojaByExcelAndCorreoRepository.executer(excel, correo);
//
//        // Asser excel1
//        Assert.assertEquals(now(), excelResultado.getActualizacionIndiceRepaso());
//        Assert.assertEquals(4, excelResultado.getUltimoIndiceRepaso().intValue());
//
//        List<Hoja> hojasAprendidas =  excelResultado.getHojas().stream()
//                .filter(hojaDto -> hojaDto.getUltimoIndiceAprendido() > 0 && hojaDto.getPorRutina())
//                .collect(Collectors.toList());
//
//        Assert.assertEquals(5, hojasAprendidas.size());
//
//    }
//
//    @Test
//    public void ex3(){
//
//        // Arrange
//        String correo = "testing13@em.com.co";
//        String excel = "excelnoesfisico.xlsx";
//        int horaActual = 5;
//
//        Excel excelPrevio = getHojaByExcelAndCorreoRepository.executer(excel, correo);
//        excelPrevio.setActualizacionIndiceRepaso(LocalDate.now().minusDays(1L));
//        Assert.assertEquals(LocalDate.now().minusDays(1L), excelPrevio.getActualizacionIndiceRepaso());
//        Assert.assertEquals(5, excelPrevio.getUltimoIndiceRepaso().intValue());
//        Assert.assertEquals(5, excelPrevio.getCantidadhojasPorRutina().intValue());
//
//
//        // Act
//        List<HojaDto> hojas = getHojasByExcelAndCorreoService.excecutev2(excel, correo, horaActual);
//
//        // Assert
//        Assert.assertFalse(hojas.isEmpty());
//        Excel excelResultado = getHojaByExcelAndCorreoRepository.executer(excel, correo);
//
//        // Asser excel1
//        Assert.assertEquals(now(), excelResultado.getActualizacionIndiceRepaso());
//        Assert.assertEquals(10, excelResultado.getUltimoIndiceRepaso().intValue());
//
//        List<Hoja> hojasAprendidas =  excelResultado.getHojas().stream()
//                .filter(hojaDto -> hojaDto.getUltimoIndiceAprendido() > 0 && hojaDto.getPorRutina())
//                .collect(Collectors.toList());
//
//        Assert.assertEquals(5, hojasAprendidas.size());
//
//    }
//
//
//    @Test
//    public void ex4(){
//
//        // Arrange
//        String correo = "testing13@em.com.co";
//        String excel = "phrasal verbs part 1.xlsx";
//        int horaActual = 5;
//
//        // Act
//        List<HojaDto> hojas = getHojasByExcelAndCorreoService.excecutev2(excel, correo, horaActual);
//
//        // Assert
//        Assert.assertFalse(hojas.isEmpty());
//        Assert.assertEquals(44, hojas.size());
//
//    }
//
//    /*@Test
//    public void methodTest(){
//
//        // Arrange
//        String correo = "testing13@em.com.co";
//        String excel = "excelnoesfisico.xlsx";
//        int horaActual = 5;
//
//        // Act
//        List<HojaDto> hojas = getHojasByExcelAndCorreoService.excecutev2(excel, correo, horaActual);
//
//        // Assert
//        Assert.assertFalse(hojas.isEmpty());
//        Assert.assertEquals(44, hojas.size());
//
//    }*/
//
//}
