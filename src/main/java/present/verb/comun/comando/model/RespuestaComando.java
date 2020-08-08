package present.verb.comun.comando.model;

public class RespuestaComando<T> {

	private T valor;

	public RespuestaComando(T valor) {
		this.valor = valor;
	}

	public T getValor() {
		return valor;
	}
}
