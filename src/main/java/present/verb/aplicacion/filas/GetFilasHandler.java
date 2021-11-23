package present.verb.aplicacion.filas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import present.verb.dominio.fila.modelo.Fila;
import present.verb.dominio.fila.service.GetFilasService;

@Component
public class GetFilasHandler {

    @Autowired
    private GetFilasService getFilasService;

    public Fila executer(String archivo, int indiceHoja, int ultimoFila, int filasPorAprender) {
        return getFilasService.executer(archivo, indiceHoja, ultimoFila, filasPorAprender);
    }

}
