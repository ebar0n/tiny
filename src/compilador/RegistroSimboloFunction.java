package compilador;
import ast.*;
import java.util.*;
public class RegistroSimboloFunction extends RegistroSimbolo {
	//Funcion
	private int NumParametros;
	private List<String> TipoParametros;
	private List<String> IdParametros;


        public RegistroSimboloFunction(int numParametros, String tipoParametros,String idParametros, String identificador, tipoDato tipo, int numLinea, String ambito) {
            super(identificador, tipo, numLinea,ambito);
            this.NumParametros= NumParametros;
            this.TipoParametros.add(tipoParametros);
            this.IdParametros.add(idParametros);
        }
		
		public RegistroSimboloFunction(String identificador, tipoDato tipo, int numLinea, String ambito){
			super(identificador, tipo, numLinea, ambito);
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