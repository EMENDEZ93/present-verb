package present.verb.perfil.dominio.entidad;

import java.time.LocalDate;

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
public class Temas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private int ultimoIndiceAprendido;

	private int repeticionesAltaComoAprendido;

	private int numeroVerbosPorAprenderDiario;

	private LocalDate ultimaFechaAprendio;

	private LocalDate ultimaFechaRutina;

	private boolean esPreguntaRespuesta;
	
	@ManyToOne
	@JoinColumn
	private Perfil perfil;

	@PrePersist
	public void prePersist() {
		ultimoIndiceAprendido = 0;
		repeticionesAltaComoAprendido = 3;
		numeroVerbosPorAprenderDiario = 5;
		ultimaFechaAprendio = LocalDate.now().minusDays(1);
		ultimaFechaRutina = LocalDate.now().minusDays(1);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUltimoIndiceAprendido() {
		return ultimoIndiceAprendido;
	}

	public void setUltimoIndiceAprendido(int ultimoIndiceAprendido) {
		this.ultimoIndiceAprendido = ultimoIndiceAprendido;
	}

	public int getRepeticionesAltaComoAprendido() {
		return repeticionesAltaComoAprendido;
	}

	public void setRepeticionesAltaComoAprendido(int repeticionesAltaComoAprendido) {
		this.repeticionesAltaComoAprendido = repeticionesAltaComoAprendido;
	}

	public int getNumeroVerbosPorAprenderDiario() {
		return numeroVerbosPorAprenderDiario;
	}

	public void setNumeroVerbosPorAprenderDiario(int numeroVerbosPorAprenderDiario) {
		this.numeroVerbosPorAprenderDiario = numeroVerbosPorAprenderDiario;
	}

	public LocalDate getUltimaFechaAprendio() {
		return ultimaFechaAprendio;
	}

	public void setUltimaFechaAprendio(LocalDate ultimaFechaAprendio) {
		this.ultimaFechaAprendio = ultimaFechaAprendio;
	}

	public LocalDate getUltimaFechaRutina() {
		return ultimaFechaRutina;
	}

	public void setUltimaFechaRutina(LocalDate ultimaFechaRutina) {
		this.ultimaFechaRutina = ultimaFechaRutina;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public boolean isEsPreguntaRespuesta() {
		return esPreguntaRespuesta;
	}

	public void setEsPreguntaRespuesta(boolean esPreguntaRespuesta) {
		this.esPreguntaRespuesta = esPreguntaRespuesta;
	}

}
