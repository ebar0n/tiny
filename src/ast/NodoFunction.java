package ast;

public class NodoFunction extends NodoBase{

	private Object tipo;
	private String identificador;
	private NodoBase declaracion;
	private NodoBase expression;
	
	public NodoFunction(Object tipo,String identificador,NodoBase declaracion,NodoBase expression) {
		super();
		this.tipo = tipo;
		this.identificador = identificador;
		this.declaracion = declaracion;
		this.expression = expression;
	}

	public NodoFunction(Object tipo,String identificador,NodoBase expression) {
		super();
		this.tipo = tipo;
		this.identificador = identificador;
		this.expression = expression;
	}
	
	public void setDeclaracion(NodoBase declaracion) {
		this.declaracion = declaracion;
	}
	
	public NodoBase getDeclaracion() {
		return declaracion;
	}
	
	public void setExpression(NodoBase expression) {
		this.expression = expression;
	}
	
	public NodoBase getExpression() {
		return expression;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setTipo(Object tipo) {
		this.tipo = tipo;
	}
	
	public Object getTipo() {
		return tipo;
	}
	
}