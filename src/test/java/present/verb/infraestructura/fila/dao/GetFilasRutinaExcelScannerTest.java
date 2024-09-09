package present.verb.infraestructura.fila.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import present.verb.dominio.fila.modelo.Fila;
import present.verb.dominio.hoja.port.HojaRepository;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static present.verb.common.infrastructura.InfraestructuraBuilder.crearHoja;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetFilasRutinaExcelScannerTest {

    @InjectMocks
    private GetFilasRutinaExcelScanner getFilasRutinaExcelScanner;

    @Mock
    private HojaRepository hojaRepository;

    @Before
    public void setUp() {
        when(hojaRepository.findById(anyInt())).thenReturn(crearHoja());
    }

    @Test
    public void methodTest() {
        int idHoja = 1;

        Fila resultado = getFilasRutinaExcelScanner.executer(idHoja);


    }


}