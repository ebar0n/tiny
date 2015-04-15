package ast;

public class NodoLeer extends NodoBase {
	private String id;
        private NodoArray array;

	public NodoLeer(String identificador) {
		super();
		this.id = identificador;
	}
        
        public NodoLeer(NodoBase array){
                super();
                this.array = (NodoArray) array;
        }

        public void setArray(NodoArray array) {
                this.array = array;
        }

        public NodoArray getArray() {
                return array;
        }
 
	public NodoLeer() {
		super();
		id="";
	}

	public String getIdentificador() {
		return id;
	}

	public void setExpresion(String identificador) {
		this.id = identificador;
	}

}
