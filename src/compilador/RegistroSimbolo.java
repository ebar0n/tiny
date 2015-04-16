package compilador;
import ast.*;
public class RegistroSimbolo {
	private String identificador;
	private tipoDato tipo;
	private int NumLinea;
	private int DireccionMemoria;

	//Array
	private int NumElementos;
	private int LimInferior;
	private int LimSuperior;

	//Funcion
	private int NumParametros;
	private String[] TipoParametros;
	
	//Constructor para una variable
	public RegistroSimbolo(String identificador,tipoDato tipo, int numLinea, int direccionMemoria) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.NumLinea = numLinea;
		this.DireccionMemoria = direccionMemoria;
	}

	public String getIdentificador() {
		return identificador;
	}

	public int getNumLinea() {
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
