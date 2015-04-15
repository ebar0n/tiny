package ast;

public class NodoCallFunction extends NodoBase{
	
	private NodoIdentificador identificador;
	private NodoBase variables;
	
	public NodoCallFunction(NodoIdentificador identificador,NodoBase variables) {
		this.identificador = identificador;
		this.variables = variables;
	}

	public NodoCallFunction(NodoIdentificador identificador) {
		this.identificador = identificador;
		this.variables = null;
	}
	
	public NodoIdentificador getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(NodoIdentificador identificador) {
		this.identificador = identificador;
	}
	
	public void setVariables(NodoBase variables) {
		this.variables = variables;
	}
	
	public NodoBase getVariables() {
		return variables;
	}

}
