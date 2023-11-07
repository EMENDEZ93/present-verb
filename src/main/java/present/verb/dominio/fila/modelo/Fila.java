package present.verb.dominio.fila.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Fila {
    private List<String> english;
    private List<String> spanish;
    private List<String> allSpeakFast;
    private List<String> fonetica;
    private boolean orden;
}
