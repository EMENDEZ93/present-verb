package present.verb.dominio.espacios.trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class ObtenerEspacioTrabajo {

    @Value("classpath:espacios/*")
    private Resource[] resources;

    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    public List<String> obtenerEspacios() {

        Resource[] resources_ = null;
        try {
            resources_ = resourcePatternResolver.getResources("classpath*:espacios/*");
        } catch (Exception e) {

            Resource resource = new Resource() {
                @Override
                public boolean exists() {
                    return false;
                }

                @Override
                public boolean isReadable() {
                    return false;
                }

                @Override
                public boolean isOpen() {
                    return false;
                }

                @Override
                public URL getURL() {
                    return null;
                }

                @Override
                public URI getURI() throws IOException {
                    return null;
                }

                @Override
                public File getFile() throws IOException {
                    return null;
                }

                @Override
                public long contentLength() throws IOException {
                    return 0;
                }

                @Override
                public long lastModified() throws IOException {
                    return 0;
                }

                @Override
                public Resource createRelative(String s) throws IOException {
                    return null;
                }

                @Override
                public InputStream getInputStream() {
                    return null;
                }

                @Override
                public String getFilename() {
                    return e.getMessage();
                }

                @Override
                public String getDescription() {
                    return null;
                }
            };

            // agrrar el recurso que se genero
            resources_ = new Resource[]{resource};
        }

        return stream(resources_)
                .map(Resource::getFilename)
                .collect(Collectors.toList());
    }

}
