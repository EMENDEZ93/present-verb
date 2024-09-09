package present.verb.dominio.fila.modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder(toBuilder = true)
public class FilaDto {
    private String english;
    private String spanish;
    private String speakFast;
    private String fonetica;
}
