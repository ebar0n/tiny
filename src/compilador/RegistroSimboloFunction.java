package compilador;
import ast.*;
import java.util.*;
public class RegistroSimboloFunction extends RegistroSimbolo {
	//Funcion
	private int NumParametros;
	private List<tipoDato> TipoParametros = new ArrayList<tipoDato>();
	private List<String> IdParametros = new ArrayList<String>(); 


        public RegistroSimboloFunction(int numParametros, tipoDato tipoParametros,String idParametros, String identificador, tipoDato tipo, int numLinea, String ambito, int nivel) {
            super(identificador, tipo, numLinea,ambito,nivel);
            this.NumParametros= NumParametros;
            this.TipoParametros.add(tipoParametros);
            this.IdParametros.add(idParametros);
        }
		
		public RegistroSimboloFunction(String identificador, tipoDato tipo, int numLinea, String ambito, int nivel){
			super(identificador, tipo, numLinea, ambito,nivel);
		}

        public List<tipoDato> getTipoParametros() {
            return TipoParametros;
        }

        public int getNumParametros() {
			return NumParametros;
		}

        public void setTipoParametros(tipoDato tipoParametros) {
            this.TipoParametros.add(tipoParametros);
        }

        public void setIdParametros(String idParametros) {
            this.IdParametros.add(idParametros);
        }
   
		public void setNumParametros(int numParametros) {
			this.NumParametros = numParametros;
		}
}