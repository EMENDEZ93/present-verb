package present.verb.infraestructura.comun.dao.exception;

public class DaoException extends RuntimeException {
    public DaoException(String mensaje) {
        super(mensaje);
    }
}
