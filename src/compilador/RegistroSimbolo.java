package compilador;
import ast.*;
import java.util.*;

public class RegistroSimbolo {
	private String identificador;
	private tipoDato tipo;
	private Integer NumLinea;
	private int DireccionMemoria;
	private String ambito;
	private String ambito_padre;
	private int nivel;
	private RegistroSimbolo hermano;
	private tipoSymbol tipeS;
	//Constructor para una variable
	public RegistroSimbolo(String identificador,tipoDato tipo, int numLinea, String ambito,String ambito_padre,int nivel, tipoSymbol tipeS) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.NumLinea = numLinea;
		this.ambito = ambito;
		this.ambito_padre = ambito_padre;
		this.nivel = nivel;
		this.hermano = null;
		this.tipeS = tipeS;
	}

	public RegistroSimbolo(String identificador,int numLinea, String ambito,String ambito_padre,int nivel, tipoSymbol tipeS) {
		super();
		this.identificador = identificador;
		this.NumLinea = numLinea;
		this.ambito = ambito;
		this.ambito_padre = ambito_padre;
		this.nivel = nivel;
		this.hermano = null;
		this.tipeS = tipeS;
	}

	
	public RegistroSimbolo(int numElementos, String identificador, tipoDato tipo, int numLinea, String ambito,String ambito_padre, int nivel, tipoSymbol tipeS) {
            this(identificador, tipo, numLinea,ambito,ambito_padre,nivel, tipeS);
            this.NumElementos = numElementos;
            this.LimInferior = 0;
            this.LimSuperior = numElementos - 1;
            //array
        }

	public String getKey() {
		return this.identificador +"/"+ this.getAmbito();
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public String getAmbito() {
		return this.ambito;
	}

	public String getAmbitoPadre() {
		return this.ambito_padre;
	}

	public Integer getNumLinea() {
		return NumLinea;
	}

	public int getDireccionMemoria() {
		return DireccionMemoria;
	}

	public RegistroSimbolo getHermano() {
		return this.hermano;
	}

	public void setHermano(RegistroSimbolo hermano){
		this.hermano = hermano;
	}

	public int getNivel() {
		return nivel;
	}

	public tipoDato getTipo() {
		return this.tipo;
	}

	public void setDireccionMemoria(int direccionMemoria) {
		DireccionMemoria = direccionMemoria;
	}


	private int NumElementos;
	private int LimInferior;
	private int LimSuperior;

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


	private int NumParametros;
	private List<tipoDato> TipoParametros = new ArrayList<tipoDato>();
	private List<String> IdParametros = new ArrayList<String>(); 

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


	public tipoSymbol getTipeSymbol(){
		return this.tipeS;
	};

}
