package present.verb.infraestructura.conversacion.dao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import present.verb.dominio.fila.modelo.Oracion;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.port.HojaRepository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Repository
public class GetConversacionExcelScanner {

    public static final int SENCENCE = 4;
    public static final int ORACION = 5;
    public static final int USUARIO = 6;

    @Autowired
    private HojaRepository hojaRepository;

    public List<Oracion> executer(int idHoja) {
        Optional<Hoja> hoja = hojaRepository.findById(idHoja);

        try {
            if(hoja.isPresent()) {
                InputStream in = getClass().getResourceAsStream("/excel_backup/".concat(hoja.get().getExcel().getNombre()));
                XSSFWorkbook excel = new XSSFWorkbook(in);
                XSSFSheet sheet = excel.getSheetAt(hoja.get().getIndiceExcel());
                Iterator<Row> rowIterator = sheet.iterator();

                Row row;
                List<Oracion> oracions = new ArrayList<>();
                int orden = 0;
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();

                        boolean a = isNull(row.getCell(SENCENCE));

                        if ( a || "".equals(row.getCell(SENCENCE).toString())) break;
                        Oracion oracion = new Oracion();
                        oracion.setEnglish(row.getCell(SENCENCE).toString());
                        oracion.setSpanish(row.getCell(ORACION).toString());
                        oracion.setUsuario(row.getCell(USUARIO).toString());
                        oracion.setOrden(orden);
                        oracions.add(oracion);
                        orden++;
                }
                return oracions;
            } else {
                throw new RuntimeException("No Existe un Hoja con el id = " + idHoja);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
