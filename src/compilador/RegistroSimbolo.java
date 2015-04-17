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
	//Constructor para una variable
	public RegistroSimbolo(String identificador,tipoDato tipo, int numLinea, String ambito,String ambito_padre,int nivel) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.NumLinea = numLinea;
		this.ambito = ambito;
		this.ambito_padre = ambito_padre;
		this.nivel = nivel;
		this.hermano = null;
	}

	public RegistroSimbolo(String identificador,int numLinea, String ambito,String ambito_padre,int nivel) {
		super();
		this.identificador = identificador;
		this.NumLinea = numLinea;
		this.ambito = ambito;
		this.ambito_padre = ambito_padre;
		this.nivel = nivel;
		this.hermano = null;
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

}
