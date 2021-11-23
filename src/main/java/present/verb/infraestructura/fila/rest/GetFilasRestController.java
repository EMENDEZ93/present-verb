package present.verb.infraestructura.fila.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import present.verb.aplicacion.filas.GetFilasHandler;
import present.verb.dominio.fila.modelo.Fila;

@RestController
@CrossOrigin(origins = "*")
public class GetFilasRestController {

    @Autowired
    private GetFilasHandler getFilasHandler;

    @GetMapping("/filas/{archivo}/{indiceHoja}/{ultimoFila}/{filasPorAprender}")
    public Fila executer(
            @PathVariable(value = "archivo") String archivo,
            @PathVariable(value = "indiceHoja") int indiceHoja,
            @PathVariable(value = "ultimoFila") int ultimoFila,
            @PathVariable(value = "filasPorAprender") int filasPorAprender
    ) {
        return getFilasHandler.executer( archivo, indiceHoja, ultimoFila, filasPorAprender);
    }

}
