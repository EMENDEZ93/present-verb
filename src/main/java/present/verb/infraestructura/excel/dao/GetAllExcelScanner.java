package present.verb.infraestructura.excel.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.puerto.GetAllExcelDao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllExcelScanner implements GetAllExcelDao {

    @Value("classpath:excel/*")
    private Resource[] resources;

    @Override
    public List<Excel> executer() {
        try {
            return scannerExcelFolder();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private List<Excel> scannerExcelFolder() {
        return Arrays.stream(resources)
                .map(resource -> {
                    Excel excel = new Excel();
                    excel.setNombre(getNombreSinExtension(resource.getFilename()));
                    excel.setArchivo(getNombreConExtension(resource.getFilename()));
                    return excel;
                }).collect(Collectors.toList());

    }

    private String getNombreSinExtension(String informe) {
        return informe.replaceAll("\\.[^.]*$", "");
    }

    private String getNombreConExtension(String informe) {
        return informe.replaceAll("\\.[^.]$", "");
    }

}
