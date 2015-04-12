package ast;

public class NodoFor extends NodoBase {

	private NodoBase inicializacion;
	private NodoBase condicion;
	private NodoBase incremento;
	private NodoBase sentencia;

	
	public NodoFor(NodoBase inicializacion, NodoBase condicion, NodoBase incremento, NodoBase sentencia) {
		super();
		this.inicializacion = inicializacion;
		this.condicion = condicion;
		this.incremento = incremento;
		this.sentencia = sentencia;
	}
	
	public NodoFor() {
		super();
		this.inicializacion = null;
		this.condicion = null;
		this.incremento = null;
		this.sentencia = null;
	}

	public NodoBase getInicializacion() {
		return inicializacion;
	}

	public void setInicializacion(NodoBase inicializacion) {
		this.inicializacion = inicializacion;
	}

	public NodoBase getCondicion() {
		return condicion;
	}

	public void setCondicion(NodoBase condicion) {
		this.condicion = condicion;
	}

	public NodoBase getIncremento() {
		return incremento;
	}

	public void setIncremento(NodoBase incremento) {
		this.incremento = incremento;
	}
	
	public NodoBase getSentencia() {
		return sentencia;
	}

	public void setSentencia(NodoBase sentencia) {
		this.sentencia = sentencia;
	}
	
}
