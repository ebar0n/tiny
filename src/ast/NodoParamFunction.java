package ast;

public class NodoParamFunction extends NodoBase{

	private NodoBase expresion;
	private NodoBase siguiente;

        public NodoParamFunction(NodoBase expresion) {
            super();
            this.expresion = expresion;
        }
        
        public NodoParamFunction(NodoBase expresion, NodoBase siguiente) {
            super();
            this.expresion = expresion;
            this.siguiente = siguiente;
        }

        public void setSiguiente(NodoBase siguiente) {
            this.siguiente = siguiente;
        }

        public NodoBase getSiguiente() {
            return siguiente;
        }

        public void setExpresion(NodoBase expresion) {
            this.expresion = expresion;
        }

        public NodoBase getExpresion() {
            return expresion;
        }	
}
