package present.verb.infraestructura.fila.dao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import present.verb.dominio.fila.modelo.Fila;
import present.verb.dominio.fila.modelo.FilaDto;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.port.HojaRepository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;

@Repository
public class GetFilasAprenderExcelScanner {

    @Autowired
    private HojaRepository hojaRepository;

    public Fila executer(int idHoja) {
        return of(idHoja)
                .map(this::obtenerFilas)
                .map(filas -> {

                    int indiceLista = 0;

                    for (String valor : filas.getTipo()) {
                        FilaDto filaDto;
                        if (valor.equals("EXAMPLE")) {
                            filaDto = FilaDto.builder()
                                    .english(filas.getEnglish().remove(indiceLista))
                                    .spanish(filas.getSpanish().remove(indiceLista))
                                    .speakFast(filas.getAllSpeakFast().remove(indiceLista))
                                    .fonetica(filas.getFonetica().remove(indiceLista))
                                    .build();
                            indiceLista--;
                            filas.getExample().get(indiceLista).add(filaDto);
                        }else {
                            List<FilaDto> filaDtos = new ArrayList<>();
                            filas.getExample().add(filaDtos);
                        }

                        indiceLista++;
                    }

                    return filas;
                })
                .orElseThrow(() -> new RuntimeException("No Existe un Hoja con el id = " + idHoja));
        //return obtenerFilas(idHoja);
    }

    private Fila obtenerFilas(int idHoja) {
        Optional<Hoja> hoja = hojaRepository.findById(idHoja);
        try {
            if(hoja.isPresent()) {
                InputStream in = getClass().getResourceAsStream("/excel/".concat(hoja.get().getExcel().getArchivo()));
                XSSFWorkbook excel = new XSSFWorkbook(in);
                XSSFSheet sheet = excel.getSheetAt(hoja.get().getIndiceExcel());
                Iterator<Row> rowIterator = sheet.iterator();

                Row row;
                boolean orden = false;
                List<String> allEnglishVerb = new ArrayList<>();
                List<String> allSpanishVerb = new ArrayList<>();
                List<String> allSpeakFast = new ArrayList<>();
                List<String> fonetica = new ArrayList<>();
                List<String> example = new ArrayList<>();

                int verbos = 0;
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();

                    orden = requiereOrden(row, orden);

                    if (verbos >= hoja.get().getFilas()) {
                        if ("".equals(row.getCell(0).toString())) break;
                    }
                    verbos++;

                    allEnglishVerb.add(obtenerValorCelda(row, 0));
                    allSpanishVerb.add(obtenerValorCelda(row, 1));
                    allSpeakFast.add(obtenerValorCelda(row, 2));
                    fonetica.add(obtenerValorCelda(row, 3));
                    example.add(obtenerValorCelda(row, 5));
                }

                Fila fila = new Fila();
                fila.setEnglish(allEnglishVerb);
                fila.setSpanish(allSpanishVerb);
                fila.setAllSpeakFast(allSpeakFast);
                fila.setFonetica(fonetica);
                fila.setTipo(example);
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

}
