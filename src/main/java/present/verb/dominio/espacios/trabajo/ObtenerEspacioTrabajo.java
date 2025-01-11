package present.verb.dominio.espacios.trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class ObtenerEspacioTrabajo {

    @Value("classpath:**")
    private Resource[] resources;

    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    public List<String> obtenerEspacios() {

        List<String> folders = new ArrayList<>();

        for (Resource resource : resources) {
            try {
                File file = resource.getFile();
                if (file.isDirectory()) {
                    folders.add(file.getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return folders;
    }

}
