package ast;

public class NodoBloque extends NodoBase{

	private NodoBase base;
	
	public NodoBloque(NodoBase expresion) {
		super();
		this.base = expresion;
	}
	
	public NodoBloque() {
		super();
		this.base = null;
	}
	
	public NodoBase getBase() {
		return base;
	}
	
	public void setBase(NodoBase base) {
		this.base = base;
	}
	
}
