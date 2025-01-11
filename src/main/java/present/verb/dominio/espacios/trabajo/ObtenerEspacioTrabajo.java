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
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class ObtenerEspacioTrabajo {

    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    public Set<String> obtenerEspacios() {
        Set<String> folders = new HashSet<>();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources;
        try {
            resolver.getClassLoader().getParent();
            resources = resolver.getResources("classpath:espacios/**");
            for (Resource resource : resources) {
                String[] path = resource.getURL().getPath().split("/");
                String folder = path[path.length - 1];
                if (!folder.contains(".")) {
                    folders.add(folder);
                }
            }

        }   catch (Exception e) {
            e.printStackTrace();
        }

        return folders.stream().filter(xx -> !xx.equals("espacios")).collect(Collectors.toSet());
    }

}
