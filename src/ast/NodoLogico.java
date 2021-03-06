package ast;

public class NodoLogico extends NodoBase{
	private NodoBase opIzquierdo;
	private NodoBase opDerecho;
	private tipoOp operacion;
	private tipoDato tipo;
	
	public NodoLogico(NodoBase opIzquierdo, tipoOp tipoOperacion, NodoBase opDerecho) {
		super();
		this.opIzquierdo = opIzquierdo;
		this.opDerecho = opDerecho;
		this.operacion = tipoOperacion;
	}

	public NodoLogico(NodoBase exp) {
		super();
		this.opIzquierdo = exp;
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

	public void setTipoDato(tipoDato tipo) {
		this.tipo = tipo;
	}

	public tipoDato getTipoDato() {
		return this.tipo;
	}

}
