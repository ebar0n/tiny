package ast;

public class NodoReturn extends NodoBase {
	private NodoBase exprecion;

	public NodoReturn(NodoBase exprecion) {
		super();
		this.exprecion = exprecion;
	}

	public NodoReturn() {
		super();
		this.exprecion = null;
	}
	
	public NodoBase getExpresion() {
		return exprecion;
	}

}
