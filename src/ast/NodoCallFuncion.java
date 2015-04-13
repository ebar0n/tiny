package ast;

public class NodoCallFuncion extends NodoBase{
	
	private String identificador;
	private NodoBase variables;
	
	public NodoCallFuncion(String identificador,NodoBase variables) {
		this.identificador = identificador;
		this.variables = variables;
	}

	public NodoCallFuncion(String identificador) {
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
