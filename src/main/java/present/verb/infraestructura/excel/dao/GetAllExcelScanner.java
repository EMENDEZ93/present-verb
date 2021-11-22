package present.verb.infraestructura.excel.dao;

import org.springframework.stereotype.Component;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.puerto.GetAllExcelDao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllExcelScanner implements GetAllExcelDao {

    @Override
    public List<Excel> executer() {
        try {
            return scannerExcelFolder();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private List<Excel> scannerExcelFolder() throws URISyntaxException, IOException {
        Path pathCarpetaTemas = getPathCarpetaExcel();
        return Files.walk(pathCarpetaTemas)
                .filter(Files::isRegularFile)
                .map(informe -> {
                    Excel excel = new Excel();
                    excel.setNombre(getNombreSinExtension(informe));
                    excel.setArchivo(getNombreConExtension(informe));
                    return excel;
                }).collect(Collectors.toList());
    }

    private Path getPathCarpetaExcel() throws URISyntaxException {
        URI folder = getClass().getClassLoader().getResource("excel").toURI();
        return Paths.get(folder);
    }

    private String getNombreSinExtension(Path informe) {
        return informe.toFile().getName().replaceAll("\\.[^.]*$", "");
    }

    private String getNombreConExtension(Path informe) {
        return informe.toFile().getName().replaceAll("\\.[^.]$", "");
    }

}
