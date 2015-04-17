package compilador;
import ast.*;
import java.util.*;

public class RegistroSimbolo {
	private String identificador;
	private tipoDato tipo;
	private List<Integer> NumLinea = new ArrayList<Integer>();
	private int DireccionMemoria;
	private String ambito;
	private int nivel;

	//Constructor para una variable
	public RegistroSimbolo(String identificador,tipoDato tipo, int numLinea, String ambito,int nivel) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.NumLinea.add(numLinea);
		this.ambito = ambito;
		this.nivel = nivel;
	}

	public RegistroSimbolo(String identificador,int numLinea, String ambito,int nivel) {
		super();
		this.identificador = identificador;
		this.NumLinea.add(numLinea);
		this.ambito = ambito;
		this.nivel = nivel;
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public String getAmbito() {
		return this.ambito;
	}

	public List<Integer> getNumLinea() {
		return NumLinea;
	}

	public int getDireccionMemoria() {
		return DireccionMemoria;
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
