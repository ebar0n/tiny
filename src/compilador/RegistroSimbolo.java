package compilador;
import ast.*;
import java.util.*;

public class RegistroSimbolo {
	private String identificador;
	private tipoDato tipo;
	private List<Integer> NumLinea = new ArrayList<Integer>();
	private int DireccionMemoria;
	private String Ambito;

	//Constructor para una variable
	public RegistroSimbolo(String identificador,tipoDato tipo, int numLinea, String ambito) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.NumLinea.add(numLinea);
		this.Ambito = ambito;
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
