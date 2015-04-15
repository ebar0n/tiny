package ast;

public class NodoBloque extends NodoBase{

	private NodoBase expression;
	
	public NodoBloque(NodoBase expression) {
		super();
		this.expression = expression;
	}
	
	public NodoBloque() {
		super();
		this.expression = null;
	}
	
	public NodoBase getExpression() {
		return expression;
	}
	
	public void setExpression(NodoBase expression) {
		this.expression = expression;
	}
	
}
