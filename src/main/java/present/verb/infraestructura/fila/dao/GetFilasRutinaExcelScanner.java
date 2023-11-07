package present.verb.infraestructura.fila.dao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import present.verb.dominio.fila.modelo.Fila;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.port.HojaRepository;

import java.io.InputStream;
import java.util.*;
import java.util.stream.IntStream;

@Repository
public class GetFilasRutinaExcelScanner {

    @Autowired
    private HojaRepository hojaRepository;

    public Fila executer(int idHoja) {
        Optional<Hoja> hoja = hojaRepository.findById(idHoja);
        System.out.println();
        try {
            if(hoja.isPresent()) {
                InputStream in = getClass().getResourceAsStream("/excel/".concat(hoja.get().getExcel().getArchivo()));
                XSSFWorkbook excel = new XSSFWorkbook(in);
                XSSFSheet sheet = excel.getSheetAt(hoja.get().getIndiceExcel());
                Iterator<Row> rowIterator = sheet.iterator();

                Row row;
                List<String> allEnglishVerb = new ArrayList<>();
                List<String> allSpanishVerb = new ArrayList<>();
                List<String> allSpeakFast = new ArrayList<>();
                List<String> fonetica = new ArrayList<>();

                int verbos = 0;
                boolean orden = false;
                if(hoja.get().getUltimoIndiceAprendido() > 0) {
                    while (rowIterator.hasNext()) {
                        row = rowIterator.next();

                        orden = requiereOrden(row, orden);

                        if (row.getCell(0).toString().equals("")) break;
                        allEnglishVerb.add(obtenerValorCelda(row, 0));
                        allSpanishVerb.add(obtenerValorCelda(row, 1));
                        allSpeakFast.add(obtenerValorCelda(row, 2));
                        fonetica.add(obtenerValorCelda(row, 3));
                        verbos++;
                        if (hoja.get().getUltimoIndiceAprendido() == verbos)
                            break;
                    }
                }

                Fila fila = new Fila();

                fila.setEnglish(getRepeticiones(allEnglishVerb));
                fila.setSpanish(getRepeticiones(allSpanishVerb));
                fila.setAllSpeakFast(getRepeticiones(allSpeakFast));
                fila.setFonetica(getRepeticiones(fonetica));
                fila.setOrden(orden);
                return fila;
            } else {
                throw new RuntimeException("No Existe un Hoja con el id = " + idHoja);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String obtenerValorCelda(Row row, int columna) {
        try {
            return row.getCell(columna).toString();
        } catch (Exception e) {
            return "NO_APLICA";
        }
    }

    private boolean requiereOrden(Row row, boolean orden) {
        if(!orden) {
            try {
                if(String.valueOf(row.getCell(9)) ==  "TRUE") {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return orden;
    }

    private static List<String> getRepeticiones(List<String> a) {
        IntStream intStream = IntStream.iterate(0, x -> x + 1);
        List<String> b = new ArrayList<>();
        intStream.limit(5).forEach(value ->
                b.addAll(a)
        );
        return b;
    }

}
