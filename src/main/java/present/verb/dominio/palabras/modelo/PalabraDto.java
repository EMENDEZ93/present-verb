package present.verb.dominio.palabras.modelo;

import java.util.List;

public class PalabraDto {

    List<String> english;
    List<String> spanish;

    public List<String> getEnglish() {
        return english;
    }

    public void setEnglish(List<String> english) {
        this.english = english;
    }

    public List<String> getSpanish() {
        return spanish;
    }

    public void setSpanish(List<String> spanish) {
        this.spanish = spanish;
    }
}
