package compilador;
import ast.*;
import java.util.*;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public class RegistroSimbolo {
	private String identificador;
	private tipoDato tipo;
	private ComplexSymbol symbolDeclare;
    private ComplexSymbol symbolInitialize;
	private int DireccionMemoria;
	private String ambito;
	private String ambito_padre;
	private int nivel;
	private RegistroSimbolo hermano;
	private tipoSymbol tipeS;
	//Constructor para una variable
	public RegistroSimbolo(String identificador,tipoDato tipo, ComplexSymbol symbol, String ambito,String ambito_padre,int nivel, tipoSymbol tipeS) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.symbolDeclare = symbol;
		this.ambito = ambito;
		this.ambito_padre = ambito_padre;
		this.nivel = nivel;
		this.hermano = null;
		this.tipeS = tipeS;
		this.symbolInitialize = null;
	}

	public RegistroSimbolo(String identificador,ComplexSymbol symbol, String ambito,String ambito_padre,int nivel, tipoSymbol tipeS) {
		super();
		this.identificador = identificador;
		this.symbolDeclare = symbol;
		this.ambito = ambito;
		this.ambito_padre = ambito_padre;
		this.nivel = nivel;
		this.hermano = null;
		this.tipeS = tipeS;
	}

	
	public RegistroSimbolo(int numElementos, String identificador, tipoDato tipo, ComplexSymbol symbol, String ambito,String ambito_padre, int nivel, tipoSymbol tipeS) {
        this(identificador, tipo, symbol,ambito,ambito_padre,nivel, tipeS);
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

	public int getNumLineaDeclare(){
		if (this.symbolDeclare != null)
			return this.symbolDeclare.xleft.getLine();
		else
			return -1;
	}

	public int getNumColumnDeclare(){
		if (this.symbolDeclare != null)
			return this.symbolDeclare.xleft.getColumn();
		else
			return -1;
	}

	public void setSymbolInitialize(ComplexSymbol symbol){
		this.symbolInitialize = symbol;
	}

	public boolean getExistInitialize(){
		return this.symbolDeclare != null;
	}

	public int getNumLineaInitialize(){
		if (this.symbolDeclare != null)
			return this.symbolDeclare.xleft.getLine();
		else
			return -1;
	}

	public int getNumColumnInitialize(){
		if (this.symbolDeclare != null)
			return this.symbolDeclare.xleft.getColumn();
		else
			return -1;
	}

}
