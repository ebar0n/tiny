package ast;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
public class NodoBase {
	/*Esta clase fue creada para tener un origen comun de todas las clases...
	 * 
	 * ESTE MODELO DE AST PUEDE SER MEJORADO DE MUCHAS FORMAS, POR SIMPLIFICACION Y
	 * DIDACTICA EN CLASE, SE LLEVARA A CABO DE FORMA MUY SIMPLE Y POCO FLEXIBLE
	 * */
	private NodoBase HermanoDerecha;
	private String ambito = null;
	private ComplexSymbol symbol = null;

	public NodoBase(NodoBase hermanoDerecha) {
		super();
		HermanoDerecha = hermanoDerecha;
	}

	public NodoBase() {
		super();
		HermanoDerecha=null;
	}

	public void setSymbol(ComplexSymbol symbol){
		this.symbol = symbol;
	}

	public ComplexSymbol getSymbol()
	{
		return this.symbol;
	}

	public int getNumLinea(){
		if (this.symbol != null)
			return this.symbol.xleft.getLine();
		else
			return -1;
	}

	public int getNumColumn(){
		if (this.symbol != null)
			return this.symbol.xleft.getColumn();
		else
			return -1;
	}

	public NodoBase getHermanoDerecha() {
		return HermanoDerecha;
	}

	public void setHermanoDerecha(NodoBase hermanoDerecha) {
		HermanoDerecha = hermanoDerecha;
	}
		
	public boolean TieneHermano() {
		return (HermanoDerecha!=null);
	}
	
	public void setAmbito(String ambito){
		this.ambito = ambito;
	}

	public String getAmbito(){
		return this.ambito;
	}
}
