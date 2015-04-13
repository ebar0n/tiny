package ast;

public class NodoAsignacion extends NodoBase {
	private String identificador;
	private NodoBase vector;
	private NodoBase expresion;
	
	public NodoAsignacion(String identificador) {
		super();
		this.identificador = identificador;
		this.expresion = null;
	}
	
	public NodoAsignacion(String identificador, NodoBase expresion) {
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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public NodoBase getExpresion() {
		return expresion;
	}

	public void setExpresion(NodoBase expresion) {
		this.expresion = expresion;
	}
	
	
	
}
