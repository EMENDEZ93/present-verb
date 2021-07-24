package present.verb.infraestructura.palabras.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import present.verb.dominio.palabras.puerto.dao.ObtenerRutinaDao;
import present.verb.dominio.palabras.modelo.PalabraDto;

@Repository
public class ObtenerRutinaExcelDao implements ObtenerRutinaDao {

    public static final String VERB_FILE = "/src/main/resources/present/verb/present_verb.xlsx";
    public static final int VERB_SHEET = 1;

    @Override
    public PalabraDto listaVerbos(int cantidad, int hojaTemaExcel) {
        return ejecutar(cantidad, hojaTemaExcel);
    }

    public PalabraDto ejecutar(int id, int hojaTemaExcel) {

        try {
            InputStream in = getClass().getResourceAsStream("/present_verb.xlsx");
            XSSFWorkbook excel = new XSSFWorkbook (in);
            XSSFSheet sheet = obtenerHojaExcel(excel, hojaTemaExcel);

            Iterator<Row> rowIterator = sheet.iterator();

            Row row;
            List<String> allEnglishVerb = new ArrayList<>();
            List<String> allSpanishVerb = new ArrayList<>();

            int verbos = 0;

            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                if (row.getCell(0).toString() == "") break;

                allEnglishVerb.add(row.getCell(0).toString());
                allSpanishVerb.add(row.getCell(1).toString());

                verbos++;

                if (id == verbos)
                    break;

            }

            PalabraDto palabra = new PalabraDto();
            palabra.setEnglish(allEnglishVerb);
            palabra.setSpanish(allSpanishVerb);

            return palabra;

        } catch (Exception e) {
            throw new RuntimeException("Error al trata de leer el xlxs : " + e.getMessage());
        }

    }

    private XSSFSheet obtenerHojaExcel(XSSFWorkbook excel, int hojaTemaExcel) {
        //return excel.getSheetAt(VERB_SHEET);
        return excel.getSheetAt(hojaTemaExcel);
    }

    private XSSFWorkbook creacionWorkBook(OPCPackage file) {
        try {
            return new XSSFWorkbook(file);
        } catch (IOException e1) {
        }
        return null;
    }

    private OPCPackage obtenerArchivo() {
        try {
            return OPCPackage.open(new File(Paths.get("").toAbsolutePath().toString() + VERB_FILE));
        } catch (InvalidFormatException e1) {
        }
        return null;
    }

}
