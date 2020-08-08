package present.verb.palabras.aplicacion.consulta.manejador;

public class TemaDto {

	private String tema;
	private int indiceHoja;

	public TemaDto(String tema, int indiceHoja) {
		this.tema = tema;
		this.indiceHoja = indiceHoja;
	}

	public String getTema() {
		return tema;
	}

	public int getIndiceHoja() {
		return indiceHoja;
	}

}
