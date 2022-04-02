package present.verb.dominio.hoja.port;

import org.springframework.stereotype.Component;
import present.verb.dominio.excel.modelo.Excel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
public class GetHojaByExcelAndCorreoRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public Excel executer(String excel, String correo) {
        try {
            TypedQuery<Excel> getHojaByExcelAndCorreoSql = entityManager.createQuery(
                    "SELECT e FROM Excel e " +
                            "INNER JOIN Usuario u on (u.id = e.usuario) WHERE e.archivo = ?1 and u.correo = ?2", Excel.class);
            return getHojaByExcelAndCorreoSql
                    .setParameter(1, excel)
                    .setParameter(2, correo)
                    .getSingleResult();
        } catch (Exception e) {
            return new Excel();
        }
    }

}
