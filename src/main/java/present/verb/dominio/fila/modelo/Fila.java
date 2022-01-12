package present.verb.dominio.fila.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Fila {

    private List<String> english;
    private List<String> spanish;
    private boolean orden;

}
