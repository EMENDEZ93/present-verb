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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class GetFilasAprenderExcelScanner {

    @Autowired
    private HojaRepository hojaRepository;

    public Fila executer(int idHoja) {
        Optional<Hoja> hoja = hojaRepository.findById(idHoja);
        try {
            if(hoja.isPresent()) {
                InputStream in = getClass().getResourceAsStream("/excel/".concat(hoja.get().getExcel().getNombre()));
                XSSFWorkbook excel = new XSSFWorkbook(in);
                XSSFSheet sheet = excel.getSheetAt(hoja.get().getIndiceExcel());
                Iterator<Row> rowIterator = sheet.iterator();

                Row row;
                boolean orden = false;
                List<String> allEnglishVerb = new ArrayList<>();
                List<String> allSpanishVerb = new ArrayList<>();

                int verbos = 0;
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();

                    orden = requiereOrden(row, orden);

                    if (verbos >= hoja.get().getUltimoIndiceAprendido()) {
                        if ("".equals(row.getCell(0).toString())) break;
                        allEnglishVerb.add(row.getCell(0).toString());
                        allSpanishVerb.add(row.getCell(1).toString());
                    }
                    verbos++;
                    if (verbos >= (hoja.get().getUltimoIndiceAprendido() +
                                   hoja.get(). getNumeroVerbosPorAprenderDiario()))
                        break;
                }

                Fila fila = new Fila();
                fila.setEnglish(allEnglishVerb);
                fila.setSpanish(allSpanishVerb);
                return fila;
            } else {
                throw new RuntimeException("No Existe un Hoja con el id = " + idHoja);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
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

}
