package ast;

public class NodoArray extends NodoBase {
	private NodoIdentificador identificador;
	private Integer tam;
	private tipoDato tipo;
	private NodoBase pos;
	private NodoBase nodo;
	
	public NodoArray(NodoIdentificador id, Integer tam, tipoDato tipo) {
		super();
		this.identificador = id;
		this.tam = tam;
		this.tipo = tipo;
	}

	public NodoArray(NodoIdentificador id, Integer tam, NodoBase nodo) {
		super();
		this.identificador = id;
		this.tam = tam;
		this.nodo = nodo;
	}

	public NodoArray(NodoIdentificador id, NodoBase pos) {
		super();
		this.identificador = id;
		this.pos = pos;
	}

	public NodoArray(NodoIdentificador id, Integer tam) {
		super();
		this.identificador = id;
		this.tam = tam;
		this.nodo = null;
	}

	public NodoArray() {
		super();
	}

	public NodoIdentificador getIdentificador(){
		return this.identificador;
	}

	public NodoBase getPos(){
		//En construccion, se debe verificar que tipo de nodo es y obtener el valor.
		return pos;
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
