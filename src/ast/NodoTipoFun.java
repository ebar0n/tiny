package ast;

public class NodoTipoFun extends NodoBase{

	private NodoBase tipo;
	
	public NodoTipoFun(NodoBase tipo) {
		// TODO Auto-generated constructor stub
		super();
		this.tipo = tipo;
	}
	
	public void setTipo(NodoBase tipo) {
		this.tipo = tipo;
	}
	
	public NodoBase getTipo() {
		return tipo;
	}
}
