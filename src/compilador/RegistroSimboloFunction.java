package compilador;
import ast.*;
import java.util.*;
public class RegistroSimboloFunction extends RegistroSimbolo {
	//Funcion
	private int NumParametros;
	private List<String> TipoParametros;
	
	public RegistroSimboloFunction(int numParametros,String tipoParametros) {
		super();
		this.numParametros = numParametros;
	}

	public int getNumParametros() {
		return numParametros;
	}

	public void setNumParametros(int numParametros) {
		this.numParametros = numParametros;
	}
}