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

	public Integer getValorReal() {
		if ( this.getTipoDato() == tipoDato.BOOLEAN ){
			if( this.getValorBoolean() == true )
				return 1;//Representa un verdadero 
			else
				return 0;//representa un falso
		}
		else
			return this.valor;
	}

	public String getValorRealStr() {
		if ( this.getTipoDato() == tipoDato.BOOLEAN )
			return ""+this.getValorBoolean();
		else
			return ""+this.valor;
	}

	public Boolean getValorBoolean() {
		return this.valorb;
	}

	public tipoDato getTipoDato() {
		return this.tipo;
	}



}
