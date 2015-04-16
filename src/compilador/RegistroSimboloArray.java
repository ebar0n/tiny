package compilador;
import ast.*;
import java.util.*;

public class RegistroSimboloArray extends RegistroSimbolo {

	private int NumElementos;
	private int LimInferior;
	private int LimSuperior;

        public RegistroSimboloArray(int NumElementos, int LimInferior, int LimSuperior, String identificador, tipoDato tipo, int numLinea, int direccionMemoria) {
            super(identificador, tipo, numLinea, direccionMemoria);
            this.NumElementos = NumElementos;
            this.LimInferior = LimInferior;
            this.LimSuperior = LimSuperior;
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