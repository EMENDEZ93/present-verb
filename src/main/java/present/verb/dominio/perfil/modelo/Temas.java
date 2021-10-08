package present.verb.dominio.perfil.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "temas")
@Setter
@Getter
public class Temas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private int ultimoIndiceAprendido;
	private int repeticionesAltaComoAprendido;
	private int numeroVerbosPorAprenderDiario;
	private LocalDate ultimaFechaAprendio = LocalDate.of(2020, Month.JANUARY, 1);
	private LocalDate ultimaFechaRutina = LocalDate.of(2020, Month.JANUARY, 1);
	private boolean esPreguntaRespuesta;
	private int indiceExcel;
	private int filas;

	@ManyToOne
	@JoinColumn
	private Perfil perfil;

	@PrePersist
	public void prePersist() {
		ultimoIndiceAprendido = 0;
		repeticionesAltaComoAprendido = 3;
		numeroVerbosPorAprenderDiario = 5;
		ultimaFechaAprendio = LocalDate.of(2020, Month.JANUARY, 1);
		ultimaFechaRutina = LocalDate.of(2020, Month.JANUARY, 1);
	}

	public boolean getRealizadoAprenderHoy() {
		LocalDate ultimaFechaAprendio = getUltimaFechaAprendio();
		return ultimaFechaAprendio.isAfter(LocalDate.now()) || ultimaFechaAprendio.isEqual(LocalDate.now());
	}

	public boolean getRealizadoRutinasHoy() {
		LocalDate ultimaFechaAprendio = getUltimaFechaRutina();
		return ultimaFechaAprendio.isAfter(LocalDate.now()) || ultimaFechaAprendio.isEqual(LocalDate.now());
	}

}
