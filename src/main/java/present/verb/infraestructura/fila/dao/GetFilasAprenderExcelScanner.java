package present.verb.infraestructura.fila.dao;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import present.verb.dominio.fila.modelo.Fila;
import present.verb.dominio.fila.modelo.FilaDto;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.port.HojaRepository;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

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
                            filas.getImages().remove(indiceLista);
                            indiceLista--;
                            filas.getExample().get(indiceLista).add(filaDto);
                        } else {
                            List<FilaDto> filaDtos = new ArrayList<>();
                            filas.getExample().add(filaDtos);
                        }

                        indiceLista++;
                    }



                    indiceLista = 0;
                    for (List<FilaDto> ejemplos : filas.getExample()) {
                        FilaDto filaDto = FilaDto.builder()
                                .english(ejemplos.stream().map(FilaDto::getEnglish)
                                        .map(String::toString)
                                        .collect(Collectors.joining("\n"))
                                )
                                .spanish(ejemplos.stream().map(FilaDto::getSpanish)
                                        .map(String::toString)
                                        .collect(Collectors.joining("\n"))
                                )
                                .speakFast(
                                        "NO_APLICA"
                                        //ejemplos.stream().map(FilaDto::getSpeakFast).map(String::toString).collect(Collectors.joining("\n"))
                                )
                                .fonetica(ejemplos.stream().map(FilaDto::getFonetica)
                                        .map(String::toString)
                                        .collect(Collectors.joining("\n"))
                                )
                                .build();

                        List<FilaDto> filaDtos_ = new ArrayList<>();
                        filaDtos_.add(filaDto);
                        filas.getExample().set(indiceLista, filaDtos_);
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
            if (hoja.isPresent()) {

                String espaciotrabajo = hoja.get().getExcel().getEspaciotrabajo();

                String path = "/espacios/" + espaciotrabajo + "/".concat(hoja.get().getExcel().getArchivo());

                InputStream in = getClass().getResourceAsStream(path);
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

                List<String> images = new ArrayList<>();
                for (int i = 0; i < fila.getEnglish().size(); i++) {
                    images.add("NO_APLICA");
                }

                for (POIXMLDocumentPart dr : sheet.getRelations()) {
                    if (dr instanceof XSSFDrawing) {
                        XSSFDrawing drawing = (XSSFDrawing) dr;
                        for (XSSFShape shape : drawing.getShapes()) {
                            if (shape instanceof XSSFPicture) {
                                XSSFPicture picture = (XSSFPicture) shape;
                                XSSFPictureData pictureData = picture.getPictureData();
                                XSSFClientAnchor anchor = picture.getPreferredSize();

                                // Obtener desplazamientos
                                int dx1 = anchor.getDx1();
                                int dy1 = anchor.getDy1();
                                int dx2 = anchor.getDx2();
                                int dy2 = anchor.getDy2();

                                System.out.println("Desplazamiento desde la esquina superior izquierda: dx1=" + dx1 + ", dy1=" + dy1);
                                System.out.println("Desplazamiento hasta la esquina inferior derecha: dx2=" + dx2 + ", dy2=" + dy2);

                                // Usar el desplazamiento para calcular márgenes si es necesario
                                byte[] data = pictureData.getData();
                                String base64Image = Base64.encodeBase64String(data);
                                images.set(anchor.getRow1(), base64Image);
                            }
                        }
                    }
                }

                fila.setImages(images);
                return fila;
            } else {
                throw new RuntimeException("No Existe un Hoja con el id = " + idHoja);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Fila obtenerFilasX(String path) {
        return ofNullable(path)
                .map(path_ -> {
                    try {
                        InputStream in = getClass().getResourceAsStream("/excel/".concat(path));
                        XSSFWorkbook excel = new XSSFWorkbook(in);
                        XSSFSheet sheet = excel.getSheetAt(0);
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

                            if (verbos >= 10) {
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
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(fila -> {
                    try {

                        List<String> images = new ArrayList<>();
                        for (int i = 0; i < fila.getEnglish().size(); i++) {
                            images.add("NO_APLICA");
                        }

                        InputStream in = getClass().getResourceAsStream("/excel/".concat(path));
                        XSSFWorkbook excel = new XSSFWorkbook(in);
                        XSSFSheet sheet = excel.getSheetAt(0);

                        for (POIXMLDocumentPart dr : sheet.getRelations()) {
                            if (dr instanceof XSSFDrawing) {
                                XSSFDrawing drawing = (XSSFDrawing) dr;
                                for (XSSFShape shape : drawing.getShapes()) {
                                    if (shape instanceof XSSFPicture) {
                                        XSSFPicture picture = (XSSFPicture) shape;
                                        XSSFPictureData pictureData = picture.getPictureData();
                                        XSSFClientAnchor anchor = picture.getPreferredSize();
                                        String cellRef = anchor.getRow1() + "-" + anchor.getCol1();
                                        byte[] data = pictureData.getData();
                                        String base64Image = Base64.encodeBase64String(data);
                                        images.set(anchor.getRow1(), base64Image);
                                    }
                                }
                            }
                        }

                        fila.setImages(images);
                        return fila;
                    }   catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .get();

    }


    private static String obtenerValorCelda(Row row, int columna) {
        return ofNullable(row)
                .map(r -> r.getCell(columna))
                .map(Object::toString)
                .filter(string -> !string.isEmpty())
                .orElse("NO_APLICA");
    }

    private boolean requiereOrden(Row row, boolean orden) {
        if (!orden) {
            try {
                if (String.valueOf(row.getCell(9)) == "TRUE") {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return orden;
    }

}
