package present.verb.aplicacion.comun.model;

public class RespuestaComando<T> {

	private T valor;

	public RespuestaComando(T valor) {
		this.valor = valor;
	}

	public T getValor() {
		return valor;
	}
}
