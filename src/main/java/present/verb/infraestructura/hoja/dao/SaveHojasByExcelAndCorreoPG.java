package present.verb.infraestructura.hoja.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.puerto.ExcelRepository;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.temas.puerto.dao.SaveHojasByExcelAndCorreoDao;
import present.verb.dominio.usuario.modelo.Usuario;
import present.verb.dominio.usuario.puerto.UsuarioRepository;
import present.verb.infraestructura.excel.dao.GetExcelScanner;

import java.util.List;

@Repository
public class SaveHojasByExcelAndCorreoPG implements SaveHojasByExcelAndCorreoDao {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ExcelRepository excelRepository;

    @Autowired
    private GetExcelScanner getExcelScanner;

    @Override
    public List<Hoja> executer(String nombreExcel, String correo) {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        Excel excel = getExcelScanner.executer(nombreExcel);
        excel.setUsuario(usuario);
        excelRepository.save(excel);
        return excel.getHojas();
    }

}
