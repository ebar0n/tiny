package ast;

public class NodoArray extends NodoBase {
	private NodoIdentificador id;
	private Integer tam;
	private tipoDato tipo;
	private NodoBase pos;
	private NodoBase nodo;
	
	public NodoArray(NodoIdentificador id, Integer tam, tipoDato tipo) {
		super();
		this.id = id;
		this.tam = tam;
		this.tipo = tipo;
	}

	public NodoArray(NodoIdentificador id, Integer tam, NodoBase nodo) {
		super();
		this.id = id;
		this.tam = tam;
		this.nodo = nodo;
	}

	public NodoArray(NodoIdentificador id, NodoBase pos) {
		super();
		this.id = id;
		this.pos = pos;
	}

	public NodoArray(NodoIdentificador id, Integer tam) {
		super();
		this.id = id;
		this.tam = tam;
		this.nodo = null;
	}

	public NodoArray() {
		super();
	}

	public NodoIdentificador getIdentificador(){
		return this.id;
	}

	public Integer getPos(){
		//En construccion, se debe verificar que tipo de nodo es y obtener el valor.
		return 0;
	}

	public NodoBase getId() {
		return id;
	}

	public Integer getTam() {
		return tam;
	}
	
	public tipoDato getTipo() {
		return tipo;
	}

	public NodoBase getNodo() {
		return nodo;
	}

}
