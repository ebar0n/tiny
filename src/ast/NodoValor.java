package ast;

public class NodoValor extends NodoBase {
	private Integer valor;
	private Boolean valorb;

	public NodoValor(Integer valor) {
		super();
		this.valor = valor;
	}

	public NodoValor(Boolean valor) {
		super();
		this.valorb = valor;
	}

	public NodoValor() {
		super();
	}
	
	public Integer getValorInteger() {
		return valor;
	}

	public Boolean getValorBoolean() {
		return valorb;
	}

}
