package present.verb.palabras.infraestructura.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import present.verb.palabras.dominio.dao.ObtenerTemasEsPreguntaRespuestaDao;

@Repository
public class ObtenerTemasPreguntaRespuestaExcelDao implements ObtenerTemasEsPreguntaRespuestaDao {

    public static final String VERB_FILE = "/src/main/resources/present/verb/present_verb.xlsx";
    public static final int VERB_SHEET = 0;

    @Override
    public boolean ejecutar(String nombreHojaTemaExcel) {
        return obtener(nombreHojaTemaExcel);
    }

    public boolean obtener(String nombreHojaTemaExcel) {

        try {

            Map<String, String> temas = new HashMap();

            InputStream in = getClass().getResourceAsStream("/present_verb.xlsx");
            XSSFWorkbook excel = new XSSFWorkbook (in);

            Boolean a1 = (null == excel);

            System.out.println("");

            //String a = excel.getSheet(nombreHojaTemaExcel).getRow(0).getCell(CellReference.convertColStringToIndex("I")).toString();

//		return excel.getSheet(nombreHojaTemaExcel).getRow(0).getCell(CellReference.convertColStringToIndex("I")).toString().equals("TRUE()");
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error al trata de leer el xlxs : " + e.getMessage());
        }


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
