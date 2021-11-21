package present.verb.infraestructura.palabras.dao;

import org.springframework.stereotype.Repository;

import present.verb.dominio.palabras.puerto.dao.ObtenerTemasEsPreguntaRespuestaDao;

@Repository
public class ObtenerTemasPreguntaRespuestaExcelDao implements ObtenerTemasEsPreguntaRespuestaDao {

    public static final String VERB_FILE = "/src/main/resources/present/verb/present_verb.xlsx";
    public static final int VERB_SHEET = 0;

    @Override
    public boolean ejecutar(String nombreHojaTemaExcel) {
        return obtener(nombreHojaTemaExcel);
    }

    public boolean obtener(String nombreHojaTemaExcel) {
        return false;
    }

}
