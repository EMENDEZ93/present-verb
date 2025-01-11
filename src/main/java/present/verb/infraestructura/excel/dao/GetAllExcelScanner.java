package present.verb.infraestructura.excel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
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

        Map<String, Resource> espaciosMap = stream(espacios).collect(
                toMap(Resource::getFilename,
                Function.identity())
        );

        Resource excelsEspacioTrabajo = espaciosMap.get(espacioTrabajo);

         return stream(excelsEspacioTrabajo.getFile().list()).map(
                nombreExcel -> {
                    Excel excel = new Excel();
                    excel.setNombre(getNombreSinExtension(nombreExcel));
                    excel.setArchivo(getNombreConExtension(nombreExcel));
                    return excel;
                }
        ).collect(Collectors.toList());
    }

    private String getNombreSinExtension(String informe) {
        return informe.replaceAll("\\.[^.]*$", "");
    }

    private String getNombreConExtension(String informe) {
        return informe.replaceAll("\\.[^.]$", "");
    }

}
