package present.verb.infraestructura.excel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.puerto.ExcelRepository;
import present.verb.dominio.excel.puerto.GetAllExcelDao;
import present.verb.dominio.usuario.modelo.Usuario;
import present.verb.dominio.usuario.puerto.UsuarioRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GetAllExcelScanner implements GetAllExcelDao {

    @Value("classpath:excel/*")
    private Resource[] resources;

    @Value("classpath:excel_0/*")
    private Resource[] resourcesExcel0;

    @Autowired
    private ExcelRepository excelRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

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


            for(Excel excel : excelsScanner) {
                boolean resultado = excels.
                        stream().
                        anyMatch(excel1 -> excel.getNombre().equalsIgnoreCase(excel1.getNombre()));
                if(!resultado) {
                    excels.add(excel);
                }
            }

            return excels;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Excel> scannerExcelFolder(String espacioTrabajo) {

        if ("excel_0".equalsIgnoreCase(espacioTrabajo)) {
            return Arrays.stream(resourcesExcel0)
                    .map(resource -> {
                        Excel excel = new Excel();
                        excel.setNombre(getNombreSinExtension(resource.getFilename()));
                        excel.setArchivo(getNombreConExtension(resource.getFilename()));
                        return excel;
                    }).collect(Collectors.toList());

        }

        if ("excel".equalsIgnoreCase(espacioTrabajo)) {
            return Arrays.stream(resources)
                    .map(resource -> {
                        Excel excel = new Excel();
                        excel.setNombre(getNombreSinExtension(resource.getFilename()));
                        excel.setArchivo(getNombreConExtension(resource.getFilename()));
                        return excel;
                    }).collect(Collectors.toList());

        }

        return Arrays.asList();
    }

    private String getNombreSinExtension(String informe) {
        return informe.replaceAll("\\.[^.]*$", "");
    }

    private String getNombreConExtension(String informe) {
        return informe.replaceAll("\\.[^.]$", "");
    }

}
