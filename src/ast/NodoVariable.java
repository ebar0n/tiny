package ast;

public class NodoVariable extends NodoBase{
	
	private NodoIdentificador identificador;
	private NodoBase nodo;
	private tipoDato tipo;
	
	public NodoVariable(NodoIdentificador id,NodoBase nodo) {
		super();
		this.identificador = id;
		this.nodo = nodo;
		this.tipo= null;
	}
	public NodoVariable(NodoBase nodo,tipoDato tipo) {
		super();
		this.identificador = null;
		this.nodo = nodo;
		this.tipo = tipo;
	}	
	
	public NodoVariable(NodoIdentificador id) {
		super();
		this.identificador = id;
		this.nodo = null;
		this.tipo = null;
	}
	
	public NodoVariable() {
		super();
		this.identificador = null;
		this.nodo = null;
		this.tipo = null;
	}
	
	public NodoIdentificador getIdentificador() {
		return this.identificador;
	}
	
	public tipoDato getTipo() {
		return tipo;
	}

	public NodoBase getNodo() {
		return nodo;
	}
	
	public void setIdentificador(NodoIdentificador id) {
		this.identificador = id;
	}
	
	public void setTipo(tipoDato tipo) {
		this.tipo = tipo;
	}

	public void setnodo(NodoBase nodo) {
		this.nodo = nodo;
	}	
}