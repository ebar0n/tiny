package ast;

public class NodoLeer extends NodoBase {
	private NodoBase identificador;
        
    public NodoLeer(NodoBase identificador){
    	super();
    	this.identificador = identificador;
    }

    public NodoBase getIdentificador() {
            return this.identificador;
    }

    public void setIdentificador(NodoBase identificador) {
            this.identificador = identificador;
    }
}
