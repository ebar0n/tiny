package compilador;
import ast.*;
import java.util.*;

public class RegistroSimboloArray extends RegistroSimbolo {

	private int NumElementos;
	private int LimInferior;
	private int LimSuperior;
	
	public RegistroSimboloArray(int numElementos,String limInferior, int limSuperior) {
		super();
		this.NumElementos = numElementos;
		this.LimInferior = limInferior;
		this.LimSuperior = limSuperior;
	}

	public int getNumElementos() {
		return this.NumElementos;
	}

	public int getLimInferior() {
		return this.LimInferior;
	}

	public int getLimSuperior() {
		return this.LimSuperior;
	}
}