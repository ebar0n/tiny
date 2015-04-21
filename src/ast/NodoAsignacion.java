package ast;

public class NodoAsignacion extends NodoBase {
	private NodoIdentificador identificador;
	private NodoArray vector;
	private NodoBase expresion;
		
	public NodoAsignacion(NodoIdentificador identificador, NodoBase expresion) {
		super();
		this.identificador = identificador;
		this.expresion = expresion;
		this.vector = null;
	}

	public NodoAsignacion(NodoArray vector, NodoBase expresion) {
		super();
		this.vector = vector;
		this.expresion = expresion;
		this.identificador = null;
	}

	public NodoIdentificador getIdentificador() {
		if (this.identificador!=null)
			return this.identificador;
		else
			return this.vector.getIdentificador();
	}

	public NodoBase getIdentificadorOrArray(){
		if (this.identificador!=null)
			return this.identificador;
		else
			return this.vector;
	}

	public NodoBase getExpresion() {
		return expresion;
	}

	public void setExpresion(NodoBase expresion) {
		this.expresion = expresion;
	}
	
}
