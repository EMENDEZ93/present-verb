package present.verb.infraestructura.excel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.puerto.ExcelRepository;
import present.verb.dominio.excel.puerto.GetAllExcelDao;
import present.verb.dominio.usuario.modelo.Usuario;
import present.verb.dominio.usuario.puerto.UsuarioRepository;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

@Component
public class GetAllExcelScanner implements GetAllExcelDao {

    @Value("classpath:espacios/*")
    private Resource[] espacios;

    @Autowired
    private ExcelRepository excelRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    @Override
    public List<Excel> executer() {
        try {
            //return scannerExcelFolder();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Set<Excel> executerByCorreo(String espacioTrabajo, String correo) {
        try {
            Usuario usuario = usuarioRepository.findByCorreo(correo);

            List<Excel> excelsScanner = scannerExcelFolder(espacioTrabajo);
            Set<Excel> excels = excelRepository.findAllByUsuario(usuario);

            excels.forEach(excel -> {
                excel.setUsuario(null);
                excel.setHojas(null);
            });

            Set<Excel> excelsFinal = new HashSet<>(excelsScanner);
            return excelsFinal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Excel> scannerExcelFolder(String espacioTrabajo) throws IOException {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources;

        resources = resolver.getResources("classpath:espacios/" + espacioTrabajo + "/**");
        List<Excel> excels = new ArrayList<>();

        for (Resource resource : resources) {
            if (resource.getFilename().contains(".xlsx")) {
                if (!resource.getFilename().contains("PENDIENTE")) {
                    Excel excel = new Excel();
                    excel.setNombre(getNombreSinExtension(resource.getFilename()));
                    excel.setArchivo(getNombreConExtension(resource.getFilename()));
                    excels.add(excel);
                }
            }

        }

        return excels;
    }

    private String getNombreSinExtension(String informe) {
        return informe.replaceAll("\\.[^.]*$", "");
    }

    private String getNombreConExtension(String informe) {
        return informe.replaceAll("\\.[^.]$", "");
    }

}
