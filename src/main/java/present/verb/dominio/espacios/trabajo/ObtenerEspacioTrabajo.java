package present.verb.dominio.espacios.trabajo;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
public class ObtenerEspacioTrabajo {

    private String resourcePath = "src/main/resources";


    public List<String> obtenerEspacios() {
        try {

            // obtener folder del resource
            Path path = Paths.get(resourcePath);
            return Files.walk(path, 1)
                    .filter(Files::isDirectory)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            List<String> espacios = asList("excel", "excel_0");
            return espacios;
        }
    }

}
