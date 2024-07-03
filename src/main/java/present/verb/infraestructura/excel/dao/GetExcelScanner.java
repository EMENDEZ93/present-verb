package present.verb.infraestructura.excel.dao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.hoja.model.Hoja;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

@Component
public class GetExcelScanner {

    public Excel executer(String nombreExcel) {
        try {
            return obtener(nombreExcel);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Excel obtener(String nombreExcel) {
        try {
            InputStream in = getClass().getResourceAsStream("/excel_backup/".concat(nombreExcel));
            XSSFWorkbook excel = new XSSFWorkbook(in);

            Excel excelResultado = new Excel();
            excelResultado.setNombre(getNombreSinExtension(nombreExcel));
            excelResultado.setArchivo(getNombreConExtension(nombreExcel));
            excelResultado.setHojas(new ArrayList<>());

            for (int indiceHojaExcel = 0; indiceHojaExcel < excel.getNumberOfSheets(); indiceHojaExcel++) {

                Iterator<Row> rowIterator = excel.getSheetAt(indiceHojaExcel).rowIterator();
                int filasByHojas = 0;
                while (rowIterator.hasNext()) { rowIterator.next(); filasByHojas++; }

                Hoja hoja = new Hoja();
                hoja.setNombre(excel.getSheetName(indiceHojaExcel));
                hoja.setFilas(filasByHojas);
                hoja.setIndiceExcel(indiceHojaExcel);
                hoja.setExcel(excelResultado);
                hoja.setPorRutina(false);

                excelResultado.getHojas().add(hoja);
            }

            return excelResultado;

        } catch (Exception e) {
            throw new RuntimeException("Error al trata de leer el xlxs : " + e.getMessage() );
        }
    }

    private String getNombreSinExtension(String informe) {
        return informe.replaceAll("\\.[^.]*$", "");
    }

    private String getNombreConExtension(String informe) {
        return informe.replaceAll("\\.[^.]$", "");
    }

}
