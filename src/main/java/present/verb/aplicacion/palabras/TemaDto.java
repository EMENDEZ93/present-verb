package present.verb.aplicacion.palabras;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TemaDto {

	private String tema;
	private boolean realizadoHoy;

	public TemaDto() {
	}

	public TemaDto(String tema, boolean realizadoHoy) {
		setTema(tema);
		setRealizadoHoy(realizadoHoy);
	}

}
