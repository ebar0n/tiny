package ast;

public class NodoParamFunction extends NodoBase{

	private String identificador;
	private NodoBase base;
	private int numero;
	private boolean condicion;
	
	public NodoParamFunction(String identificador) {
		// TODO Auto-generated constructor stub
		super();
		this.identificador = identificador;
	}
	
	public NodoParamFunction(NodoBase base) {
		// TODO Auto-generated constructor stub
		super();
		this.base = base;
	}
	
	public NodoParamFunction(int numero) {
		// TODO Auto-generated constructor stub
		super();
		this.numero = numero;
	}
	
	public NodoParamFunction(boolean condicion) {
		// TODO Auto-generated constructor stub
		super();
		this.condicion = condicion;
	}
	
	public void setCondicion(boolean condicion) {
		this.condicion = condicion;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public boolean isCondicion() {
		return condicion;
	}
	
	public void setBase(NodoBase base) {
		this.base = base;
	}
	
	public NodoBase getBase() {
		return base;
	}
	
}
