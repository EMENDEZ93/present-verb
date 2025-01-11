package present.verb.dominio.espacios.trabajo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class ObtenerEspacioTrabajo {

    @Value("classpath:espacios/*")
    private Resource[] resources;

    public List<String> obtenerEspacios() {
        return stream(resources)
                .map(Resource::getFilename)
                .collect(Collectors.toList());
    }

}
