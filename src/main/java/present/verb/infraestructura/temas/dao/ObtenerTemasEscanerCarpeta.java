package present.verb.infraestructura.temas.dao;

import org.springframework.stereotype.Repository;
import present.verb.aplicacion.palabras.TemaDto;
import present.verb.dominio.temas.puerto.dao.ObtenerTemasDao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ObtenerTemasEscanerCarpeta implements ObtenerTemasDao {

    @Override
    public List<TemaDto> ejecutar() {
        try {
            return escanearTemas();
        } catch (IOException | URISyntaxException e) {
            return null;
        }

    }

    @Override
    public List<TemaDto> ejecutar(String correo) {
        List<TemaDto> temaDtos = ejecutar();
        return null;

    }

    private List<TemaDto> escanearTemas() throws URISyntaxException, IOException {
        Path pathCarpetaTemas = getPathCarpetaTemas();

        return Files.walk(pathCarpetaTemas)
                .filter(Files::isRegularFile)
                .map(informe -> {
                    TemaDto temaDto = new TemaDto();
                    temaDto.setTema(getNombreSinExtension(informe));
                    return temaDto;
                }).collect(Collectors.toList());
    }

    private Path getPathCarpetaTemas() throws URISyntaxException {
        URI folder = getClass().getClassLoader().getResource("temas").toURI();
        return Paths.get(folder);
    }

    private String getNombreSinExtension(Path informe) {
        return informe.toFile().getName().replaceAll("\\.[^.]*$", "");
    }

}
