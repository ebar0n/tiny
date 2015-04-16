package compilador;
import ast.*;
import java.util.*;
public class RegistroSimboloFunction extends RegistroSimbolo {
	//Funcion
	private int NumParametros;
	private List<String> TipoParametros;

        public RegistroSimboloFunction(int NumParametros, List<String> TipoParametros, String identificador, tipoDato tipo, int numLinea, int direccionMemoria) {
            super(identificador, tipo, numLinea, direccionMemoria);
            this.NumParametros = NumParametros;
            this.TipoParametros = TipoParametros;
        }
	
        public List<String> getTipoParametros() {
            return TipoParametros;
        }

        public void setTipoParametros(List<String> TipoParametros) {
            this.TipoParametros = TipoParametros;
        }
   
	public int getNumParametros() {
		return NumParametros;
	}

	public void setNumParametros(int numParametros) {
		this.NumParametros = numParametros;
	}
}