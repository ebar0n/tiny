package ast;

public class NodoValor extends NodoBase {
	private Integer valor;
	private boolean valorb;

	public NodoValor(Integer valor) {
		super();
		this.valor = valor;
		this.valorb = null;
	}

	public NodoValor(boolean valor) {
		super();
		this.valor = null;
		this.valorb = valor;
	}

	public NodoValor() {
		super();
	}
	
	public Integer getValor() {
		return valor;
	}

	public boolean getValorBoolean() {
		return valorb;
	}

}
