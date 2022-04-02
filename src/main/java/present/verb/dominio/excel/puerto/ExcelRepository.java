package present.verb.dominio.excel.puerto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.usuario.modelo.Usuario;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ExcelRepository extends JpaRepository<Excel, Integer> {

    Excel findByNombre(String excelNombre);
    Set<Excel> findAllByUsuario(Usuario usuario);

    default Excel updateIncluirByIdExcel(int idExcel) {
        Optional<Excel> excel = findById(idExcel);
        if(excel.isPresent()) {
            if(!"CICLO".equalsIgnoreCase(excel.get().getIncluir())) {
                excel.get().setIncluir("CICLO");
            } else {
                excel.get().setIncluir("NO_CICLO");
            }
            Excel resultado = save(excel.get());
            resultado.setHojas(null);
            resultado.setUsuario(null);
            return resultado;
        } else {
            throw new RuntimeException("No Existe un Excel con el id = " + idExcel);
        }
    }

}
