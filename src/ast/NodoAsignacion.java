package ast;

public class NodoAsignacion extends NodoBase {
	private NodoIdentificador identificador;
	private NodoBase vector;
	private NodoBase expresion;
	
	public NodoAsignacion(NodoIdentificador identificador) {
		super();
		this.identificador = identificador;
		this.expresion = null;
	}
	
	public NodoAsignacion(NodoIdentificador identificador, NodoBase expresion) {
		super();
		this.identificador = identificador;
		this.expresion = expresion;
	}

	public NodoAsignacion(NodoBase vector) {
		super();
		this.vector = vector;
		this.expresion = null;
	}
	
	public NodoAsignacion(NodoBase vector, NodoBase expresion) {
		super();
		this.vector = vector;
		this.expresion = expresion;
	}

	public NodoIdentificador getIdentificador() {
		return identificador;
	}

	public void setIdentificador(NodoIdentificador identificador) {
		this.identificador = identificador;
	}

	public NodoBase getExpresion() {
		return expresion;
	}

	public void setExpresion(NodoBase expresion) {
		this.expresion = expresion;
	}
	
	
	
}
