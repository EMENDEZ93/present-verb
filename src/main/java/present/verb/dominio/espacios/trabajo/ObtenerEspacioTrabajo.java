package present.verb.dominio.espacios.trabajo;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObtenerEspacioTrabajo {

    private String resourcePath = "src/main/resources";


    public List<String> obtenerEspacios() {
        try {
            return Files.list(Paths.get(resourcePath))
                    .filter(Files::isDirectory)
                    .filter(p -> p.getFileName().toString().equals("excel") ||
                            p.getFileName().toString().equals("excel_0")
                    )
                    .map(Path::getFileName)
                    .map(String::valueOf)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }

}
