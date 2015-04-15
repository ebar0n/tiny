package ast;

public class NodoLogico extends NodoBase{
	private NodoBase opIzquierdo;
	private NodoBase opDerecho;
	private NodoBase exp;
	private tipoOp operacion;
	
	public NodoLogico(NodoBase opIzquierdo, tipoOp tipoOperacion, NodoBase opDerecho) {
		super();
		this.opIzquierdo = opIzquierdo;
		this.opDerecho = opDerecho;
		this.operacion = tipoOperacion;
		this.exp = null;
	}

	public NodoLogico(NodoBase exp) {
		super();
		this.exp = exp;
		this.opIzquierdo = null;
		this.opDerecho = null;
	}

	public NodoBase getOpIzquierdo() {
		return opIzquierdo;
	}

	public void setOpIzquierdo(NodoBase opIzquierdo) {
		this.opIzquierdo = opIzquierdo;
	}

	public NodoBase getOpDerecho() {
		return opDerecho;
	}

	public void setOpDerecho(NodoBase opDerecho) {
		this.opDerecho = opDerecho;
	}

	public tipoOp getOperacion() {
		return operacion;
	}

	public NodoBase getExp(){
		return this.exp;
	}

}
