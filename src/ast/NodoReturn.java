package ast;

public class NodoReturn extends NodoBase {
	private NodoBase factor;

	public NodoReturn(NodoBase factor) {
		super();
		this.factor = factor;
	}

	public NodoReturn() {
		super();
		this.factor = null;
	}
	
	public NodoBase getFactor() {
		return factor;
	}

}
