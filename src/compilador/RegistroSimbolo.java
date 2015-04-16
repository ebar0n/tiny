package compilador;
import ast.*;
import java.util.*;

public class RegistroSimbolo {
	private String identificador;
	private tipoDato tipo;
	private List<Integer> NumLinea;
	private int DireccionMemoria;

	//Constructor para una variable
	public RegistroSimbolo(String identificador,tipoDato tipo, int numLinea, int direccionMemoria) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		//this.NumLinea = numLinea;
		this.DireccionMemoria = direccionMemoria;
	}

	public String getIdentificador() {
		return identificador;
	}

	public List<Integer> getNumLinea() {
		return NumLinea;
	}

	public int getDireccionMemoria() {
		return DireccionMemoria;
	}

	public tipoDato getTipo() {
		return tipo;
	}

	public void setDireccionMemoria(int direccionMemoria) {
		DireccionMemoria = direccionMemoria;
	}
}
