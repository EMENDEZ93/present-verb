package present.verb.dominio.perfil.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "perfil", uniqueConstraints = { @UniqueConstraint(columnNames = { "correo" }) })
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String idFirebase;

	private String correo;

	private int ultimoIndiceAprendido;

	private int repeticionesAltaComoAprendido;

	private int numeroVerbosPorAprenderDiario;

	private LocalDate ultimaFechaAprendio;

	private LocalDate ultimaFechaRutina;

	@OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Temas> temas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Temas> getTemas() {
		return temas;
	}

	public void setTemas(List<Temas> temas) {
		this.temas = temas;
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

	public String getIdFirebase() {
		return idFirebase;
	}

	public void setIdFirebase(String idFirebase) {
		this.idFirebase = idFirebase;
	}
}
