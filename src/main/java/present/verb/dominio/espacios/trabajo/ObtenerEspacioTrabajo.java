package present.verb.dominio.espacios.trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
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

        Resource[] resources_ = null;
        try {
            resources_ = resourcePatternResolver.getResources("classpath*:espacios/*");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return stream(resources)
                .map(Resource::getFilename)
                .collect(Collectors.toList());
    }

}
