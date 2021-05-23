package present.verb.palabras.infraestructura.dao;

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

import present.verb.palabras.dominio.dao.ObtenerVerboPorAprenderDao;
import present.verb.palabras.dominio.dto.PalabraDto;

@Repository
public class ObtenerVerbosPorAprenderExcelDao implements ObtenerVerboPorAprenderDao {

    public static final String VERB_FILE = "/src/main/resources/present/verb/present_verb.xlsx";
    public static final int VERB_SHEET = 0;

    @Override
    public PalabraDto ejecutar(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel) {
        return obtener(ultimoIndiceVerboAprendido, numeroVerbosPorAprenderDiario, hojaTemaExcel);
    }

    public PalabraDto obtener(int ultimoIndiceVerboAprendido, int numeroVerbosPorAprenderDiario, int hojaTemaExcel) {
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
                if (verbos >= ultimoIndiceVerboAprendido) {

                    if (row.getCell(0).toString() == "") break;
                    String a = row.getCell(0).toString();

                    allEnglishVerb.add(row.getCell(0).toString());
                    allSpanishVerb.add(row.getCell(1).toString());
                }

                verbos++;

                if (verbos >= (numeroVerbosPorAprenderDiario + ultimoIndiceVerboAprendido))
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
