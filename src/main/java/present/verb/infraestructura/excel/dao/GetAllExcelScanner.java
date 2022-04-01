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

    @Autowired
    private ExcelRepository excelRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Excel> executer() {
        try {
            return scannerExcelFolder();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Set<Excel> executerByCorreo(String correo) {
        try {
            Usuario usuario = usuarioRepository.findByCorreo(correo);

            List<Excel> excelsCiclo =usuario.getExcels().stream()
                    .filter(excel -> "CICLO".equalsIgnoreCase(excel.getIncluir()))
                    .collect(Collectors.toList());

            List<Excel> faltantes = excelsCiclo.stream()
                    .filter(excel -> "TERMINADO".equalsIgnoreCase(excel.getEstado()))
                    .collect(Collectors.toList());

            int totalExcelsCiclo = excelsCiclo.size();
            int terminados = faltantes.size();

            if(terminados == totalExcelsCiclo) {
                for(Excel excel: excelsCiclo) {
                    excel.setEstado("ACTUALIZAR");
                    excelRepository.save(excel);
                }
            }


            List<Excel> excelsScanner = scannerExcelFolder();
            Set<Excel> excels = excelRepository.findAllByUsuario(usuario);
            excels.addAll(excelsScanner);
            excels.forEach(excel -> {
                excel.setUsuario(null);
                excel.setHojas(null);
            });
            return excels;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Excel> scannerExcelFolder() {
        return Arrays.stream(resources)
                .map(resource -> {
                    Excel excel = new Excel();
                    excel.setNombre(getNombreSinExtension(resource.getFilename()));
                    excel.setArchivo(getNombreConExtension(resource.getFilename()));
                    return excel;
                }).collect(Collectors.toList());

    }

    private String getNombreSinExtension(String informe) {
        return informe.replaceAll("\\.[^.]*$", "");
    }

    private String getNombreConExtension(String informe) {
        return informe.replaceAll("\\.[^.]$", "");
    }

}
