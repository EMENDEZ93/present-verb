package present.verb.aplicacion.temas;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class TemaComando {

	private String nombre;
	private String correo;
	private int ultimoIndiceAprendido;
	private LocalDate ultimaFechaAprendio;

	public TemaComando() {
	}

	public TemaComando(String tema, String correo, int ultimoIndiceAprendido) {
		setNombre(tema);
		setCorreo(correo);
		setUltimoIndiceAprendido(ultimoIndiceAprendido);
	}

}
