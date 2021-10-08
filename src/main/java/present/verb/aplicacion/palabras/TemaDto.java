package present.verb.aplicacion.palabras;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TemaDto {

	private String tema;
	private boolean realizadoHoy;
	private boolean realizadoRutinaHoy;
	private int indiceExcel;
	private int filas;
	private int ultimoIndiceAprendido;

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


	public TemaDto(String tema, boolean realizadoHoy, boolean realizadoRutinaHoy, int indiceExcel, int filas, int ultimoIndiceAprendido) {
		setTema(tema);
		setRealizadoHoy(realizadoHoy);
		setIndiceExcel(indiceExcel);
		setFilas(filas);
		setUltimoIndiceAprendido(ultimoIndiceAprendido);
		setRealizadoRutinaHoy(realizadoRutinaHoy);
	}

}
