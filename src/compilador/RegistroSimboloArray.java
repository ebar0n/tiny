package compilador;
import ast.*;
import java.util.*;

public class RegistroSimboloArray extends RegistroSimbolo {

	private int NumElementos;
	private int LimInferior;
	private int LimSuperior;

    public RegistroSimboloArray(int numElementos, int limInferior, int limSuperior, String identificador, tipoDato tipo, int numLinea, int direccionMemoria, String ambito) {
        super(identificador, tipo, numLinea, direccionMemoria,ambito);
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
	public void setNumElementos(int numElementos) {
		this.NumElementos = numElementos;
	}
	public void setLimInferior(int limInferior){
		this.LimInferior = limInferior;
	}
	public void setLimSuperior(int limSuperior){
		this.LimSuperior = limSuperior;
	}
}