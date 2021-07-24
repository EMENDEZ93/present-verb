package present.verb.aplicacion.palabras;

public class TemaDto {

	private String tema;
	private Boolean realizadoHoy;

//	private int indiceHoja;
//
//	public TemaDto(String tema, int indiceHoja) {
//		this.tema = tema;
//		this.indiceHoja = indiceHoja;
//	}
//
//	public String getTema() {
//		return tema;
//	}
//
//	public int getIndiceHoja() {
//		return indiceHoja;
//	}


	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Boolean getRealizadoHoy() {
		return realizadoHoy;
	}

	public void setRealizadoHoy(Boolean realizadoHoy) {
		this.realizadoHoy = realizadoHoy;
	}
}
