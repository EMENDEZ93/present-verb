package present.verb.dominio.hoja.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import present.verb.dominio.hoja.model.Hoja;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface HojaRepository extends JpaRepository<Hoja, Integer> {

    default Hoja updateUlfimaFechaAndUltimoIndice(int idHoja) {
        Optional<Hoja> hoja = findById(idHoja);
        if(hoja.isPresent()) {
            hoja.get().setUltimaFechaAprendio(LocalDate.now());
            hoja.get().setUltimoIndiceAprendido(
                    hoja.get().getUltimoIndiceAprendido() +
                    hoja.get().getNumeroVerbosPorAprenderDiario()
            );
            save(hoja.get());
            hoja.get().setExcel(null);
            return hoja.get();
        } else {
            throw new RuntimeException("No Existe un Hoja con el id = " + idHoja);
        }

    }

}
