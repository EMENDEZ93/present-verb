package present.verb.aplicacion.perfil.comando;

import java.time.LocalDate;

public class ActualizarUltimaFecharRutinaComando {

	private String correo;

	private String nombre;

	private LocalDate ultimaFechaRutina = LocalDate.now();

	public LocalDate getUltimaFechaRutina() {
		return ultimaFechaRutina;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
