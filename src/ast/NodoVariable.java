package ast;

public class NodoVariable extends NodoBase{
	
	private NodoIdentificador id;
	private NodoBase nodo;
	private tipoDato tipo;
	
	public NodoVariable(NodoIdentificador id,NodoBase nodo) {
		super();
		this.id = id;
		this.nodo = nodo;
		this.tipo= null;
	}
	public NodoVariable(NodoBase nodo,tipoDato tipo) {
		super();
		this.id = null;
		this.nodo = nodo;
		this.tipo = tipo;
	}	
	
	public NodoVariable(NodoIdentificador id) {
		super();
		this.id = id;
		this.nodo = null;
		this.tipo = null;
	}
	
	public NodoVariable() {
		super();
		this.id = null;
		this.nodo = null;
		this.tipo = null;
	}
	
	public NodoIdentificador getId() {
		return id;
	}
	
	public tipoDato getTipo() {
		return tipo;
	}

	public NodoBase getNodo() {
		return nodo;
	}
	
	public void setId(NodoIdentificador id) {
		this.id = id;
	}
	
	public void setTipo(tipoDato tipo) {
		this.tipo = tipo;
	}

	public void setnodo(NodoBase nodo) {
		this.nodo = nodo;
	}	
}