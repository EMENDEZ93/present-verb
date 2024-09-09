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
    private List<String> tipo;
    private List<List<FilaDto>> example = new ArrayList<>();
    private boolean orden;
}
