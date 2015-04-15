package ast;

public class NodoParamFunction extends NodoBase{

	private NodoBase expresion;
	private NodoBase base;

        public NodoParamFunction(NodoBase expresion) {
            super();
            this.expresion = expresion;
        }
        
        public NodoParamFunction(NodoBase expresion, NodoBase base) {
            super();
            this.expresion = expresion;
            this.base = base;
        }

        public void setBase(NodoBase base) {
            this.base = base;
        }

        public NodoBase getBase() {
            return base;
        }

        public void setExpresion(NodoBase expresion) {
            this.expresion = expresion;
        }

        public NodoBase getExpresion() {
            return expresion;
        }	
}
