package ast;

public class NodoValor extends NodoBase {
	private Integer valor;
	private Boolean valorb;
	private tipoDato tipo;

	public NodoValor(Integer valor) {
		super();
		this.valor = valor;
		this.tipo = tipoDato.INT;
	}

	public NodoValor(Boolean valor) {
		super();
		this.valorb = valor;
		this.tipo = tipoDato.BOOLEAN;
	}

	public NodoValor() {
		super();
	}
	
	public Integer getValor() {
		return this.valor;
	}

	public Boolean getValorBoolean() {
		return this.valorb;
	}

	public tipoDato getTipoDato() {
		return this.tipo;
	}



}
