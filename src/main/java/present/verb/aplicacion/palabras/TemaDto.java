package present.verb.aplicacion.palabras;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TemaDto {

	private String tema;
	private boolean realizadoHoy;
	private int indiceExcel;
	private int filas;

	public TemaDto() {
	}

	public TemaDto(String tema, boolean realizadoHoy) {
		setTema(tema);
		setRealizadoHoy(realizadoHoy);
	}

	public TemaDto(String tema, boolean realizadoHoy, int indiceExcel) {
		setTema(tema);
		setRealizadoHoy(realizadoHoy);
		setIndiceExcel(indiceExcel);
	}


	public TemaDto(String tema, boolean realizadoHoy, int indiceExcel, int filas) {
		setTema(tema);
		setRealizadoHoy(realizadoHoy);
		setIndiceExcel(indiceExcel);
		setFilas(filas);
	}

}
