package present.verb.dominio.espacios.trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class ObtenerEspacioTrabajo {

    @Value("classpath:*")
    private Resource[] resources_;

    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    public List<String> obtenerEspacios() {
        List<String> folders = new ArrayList<>();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources;
        try {
            resolver.getClassLoader().getParent();
            resources = resolver.getResources("classpath:**");
            for (Resource resource : resources) {

                // eliminar el nombre del archivo && obtener la ultima carpeta
                String[] path = resource.getURL().getPath().split("/");
                String folder = path[path.length - 1];
                if (!folder.contains(".")) {
                    folders.add(folder);
                }
            }

        }   catch (Exception e) {
            e.printStackTrace();
        }

        return folders;
    }

}
