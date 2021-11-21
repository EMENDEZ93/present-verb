package present.verb.dominio.temas.puerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.hoja.model.HojaDto;

import java.util.List;

@Repository
public interface GetHojasByExcelAndCorreoRepository extends JpaRepository<Hoja, Long> {

    @Transactional(readOnly = true)
    @Query("                SELECT\n" +
            "                h.nombre as nombre,\n" +
            "                h.ultimoIndiceAprendido as ultimoIndiceAprendido,\n" +
            "                h.repeticionesAltaComoAprendido as repeticionesAltaComoAprendido,\n" +
            "                h.ultimaFechaAprendio as ultimaFechaAprendio,\n" +
            "                h.ultimaFechaRutina as ultimaFechaRutina,\n" +
            "                h.esPreguntaRespuesta as esPreguntaRespuesta,\n" +
            "                h.numeroVerbosPorAprenderDiario as numeroVerbosPorAprenderDiario,\n" +
            "                h.indiceExcel as indiceExcel,\n" +
            "                h.filas as filas\n" +
            "                FROM Usuario u\n" +
            "                INNER JOIN Excel e on (u.id = e.usuario)\n" +
            "                INNER JOIN Hoja h on (e.id = h.excel)\n" +
            "                where e.nombre = ?1 and u.correo = ?2")
    List<HojaDto> execute(String excel, String correo);

}
