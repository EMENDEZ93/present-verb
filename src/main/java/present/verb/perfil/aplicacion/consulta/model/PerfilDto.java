package present.verb.perfil.aplicacion.consulta.model;

import java.time.LocalDate;

public interface PerfilDto {

	public Long getId();

	public int getUltimoIndiceAprendido();

	public int getRepeticionesAltaComoAprendido();

	public int getNumeroVerbosPorAprenderDiario();

	public LocalDate getUltimaFechaAprendio();

	public boolean getEsPreguntaRespuesta();
	
}
