package present.verb.infraestructura.fila.dao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;
import present.verb.dominio.fila.modelo.Fila;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class GetFilasExcelScanner {

    public Fila executer(String archivo, int indiceHoja, int ultimaFila, int filasPorAprender) {

        try {
            InputStream in = getClass().getResourceAsStream("/excel/".concat(archivo));
            XSSFWorkbook excel = new XSSFWorkbook(in);
            XSSFSheet sheet = excel.getSheetAt(indiceHoja);
            Iterator<Row> rowIterator = sheet.iterator();

            Row row;
            List<String> allEnglishVerb = new ArrayList<>();
            List<String> allSpanishVerb = new ArrayList<>();

            int verbos = 0;

            while (rowIterator.hasNext()) {


                row = rowIterator.next();
                if (verbos >= ultimaFila) {

                    if (row.getCell(0).toString() == "") break;
                    String a = row.getCell(0).toString();

                    allEnglishVerb.add(row.getCell(0).toString());
                    allSpanishVerb.add(row.getCell(1).toString());
                }

                verbos++;

                if (verbos >= (filasPorAprender + ultimaFila))
                    break;

            }

            Fila fila = new Fila();
            fila.setEnglish(allEnglishVerb);
            fila.setSpanish(allSpanishVerb);

            return fila;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
