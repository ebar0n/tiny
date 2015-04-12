package ast;

public class NodoArray extends NodoBase {
	private String nombre;
	private Integer tam;
	private tipoDato tipo;
	private NodoBase pos;
	private NodoBase nodo;
	
	public NodoArray(String nombre, Integer tam, tipoDato tipo) {
		super();
		this.nombre = nombre;
		this.tam = tam;
		this.tipo = tipo;
	}

	public NodoArray(String nombre, Integer tam, NodoBase nodo) {
		super();
		this.nombre = nombre;
		this.tam = tam;
		this.nodo = nodo;
	}

	public NodoArray(String nombre, NodoBase pos) {
		super();
		this.nombre = nombre;
		this.pos = pos;
	}

	public NodoArray(String nombre, Integer tam) {
		super();
		this.nombre = nombre;
		this.tam = tam;
	}

	public NodoArray() {
		super();
	}

	public String getNombre(){
		return this.nombre;
	}

	public Integer getPos(){
		//En construccion, se debe verificar que tipo de nodo es y obtener el valor.
		return 0;
	}

}
