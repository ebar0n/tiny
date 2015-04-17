package ast;

public class NodoFunction extends NodoBase{

	private tipoDato tipo;
	private NodoIdentificador identificador;
	private NodoBase declaracion;
	private NodoBase expression;
	
	public NodoFunction(tipoDato tipo,NodoIdentificador identificador,NodoBase declaracion,NodoBase expression) {
		super();
		this.tipo = tipo;
		this.identificador = identificador;
		this.declaracion = declaracion;
		this.expression = expression;
	}

	public NodoFunction(tipoDato tipo,NodoIdentificador identificador,NodoBase expression) {
		super();
		this.tipo = tipo;
		this.identificador = identificador;
		this.expression = expression;
	}
	
	public void setDeclaracion(NodoBase declaracion) {
		this.declaracion = declaracion;
	}
	
	public NodoBase getDeclaracion() {
		return declaracion;
	}
	
	public void setExpression(NodoBase expression) {
		this.expression = expression;
	}
	
	public NodoBase getExpression() {
		return expression;
	}
	
	public void setIdentificador(NodoIdentificador identificador) {
		this.identificador = identificador;
	}
	
	public NodoIdentificador getIdentificador() {
		return identificador;
	}
	
	public void setTipo(tipoDato tipo) {
		this.tipo = tipo;
	}
	
	public tipoDato getTipo() {
		return tipo;
	}
	
}
