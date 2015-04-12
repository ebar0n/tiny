package ast;

public class NodoVariable extends NodoBase{
	
	static enum Tipo{ INT, BOOLEAN };
	private String id;
	private NodoBase partev;
	private Tipo tipo;

	public NodoVariable(String id,Tipo tipo) {
		super();
		this.id = id;
		this.partev = null;
		this.tipo= tipo;
	}
	public NodoVariable(NodoBase partev,Tipo tipo) {
		super();
		this.id = null;
		this.partev = partev;
		this.tipo = tipo;
	}

	public NodoVariable(String id, NodoBase partev,Tipo tipo) {
		super();
		this.id = id;
		this.partev = partev;
		this.tipo = tipo;
	}
	
	public NodoVariable() {
		super();
		this.id = null;
		this.partev = null;
		this.tipo = null;
	}
	
	public String getId() {
		return id;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public NodoBase getPartev() {
		return partev;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void setPartev(NodoBase partev) {
		this.partev = partev;
	}	
}