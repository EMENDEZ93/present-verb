package present.verb.infraestructura.fila.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import present.verb.dominio.fila.modelo.FilaDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
public class Head {
    private List<FilaDto> example = new ArrayList<>();
    private List<String> english;
}
