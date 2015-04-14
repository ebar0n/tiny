package ast;

public class NodoCallFunction extends NodoBase{
	
	private String identificador;
	private NodoBase variables;
	
	public NodoCallFunction(String identificador,NodoBase variables) {
		this.identificador = identificador;
		this.variables = variables;
	}

	public NodoCallFunction(String identificador) {
		this.identificador = identificador;
		this.variables = null;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public void setVariables(NodoBase variables) {
		this.variables = variables;
	}
	
	public NodoBase getVariables() {
		return variables;
	}

}
