package ast;

public class NodoVariable extends NodoBase{
	
	static enum Tipo{ INT, BOOLEAN };
	private String id;
	private NodoBase nodo;
	private tipoDato tipo;

	public NodoVariable(String id,tipoDato tipo) {
		super();
		this.id = id;
		this.nodo = null;
		this.tipo= tipo;
	}
	public NodoVariable(NodoBase nodo,tipoDato tipo) {
		super();
		this.id = null;
		this.nodo = nodo;
		this.tipo = tipo;
	}

	public NodoVariable(String id, NodoBase nodo,tipoDato tipo) {
		super();
		this.id = id;
		this.nodo = nodo;
		this.tipo = tipo;
	}
	
	public NodoVariable() {
		super();
		this.id = null;
		this.nodo = null;
		this.tipo = null;
	}
	
	public String getId() {
		return id;
	}
	
	public tipoDato getTipo() {
		return tipo;
	}

	public NodoBase getnodo() {
		return nodo;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setTipo(tipoDato tipo) {
		this.tipo = tipo;
	}

	public void setnodo(NodoBase nodo) {
		this.nodo = nodo;
	}	
}