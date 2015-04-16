package compilador;

import java.util.*;


import ast.*;


public class TablaSimbolos {
	private HashMap<String, RegistroSimbolo> tabla;
	private int direccion;  //Contador de las localidades de memoria asignadas a la tabla
	
	public TablaSimbolos() {
		super();
		tabla = new HashMap<String, RegistroSimbolo>();
		direccion=0;
	}

	public void cargarTabla(NodoBase raiz){
		while (raiz != null) {
	    /* Hago el recorrido recursivo */
		    System.out.println(raiz);
		    if (raiz instanceof NodoFunction){
		    	InsertarSimbolo(((NodoFunction)raiz).getIdentificador(),((NodoFunction)raiz).getTipo(),1);
		    	if(((NodoFunction)raiz).getDeclaracion()!=null){
		    		cargarTabla(((NodoFunction)raiz).getDeclaracion());
		    	}
		    	cargarTabla(((NodoFunction)raiz).getExpression());
		    }

		    //ARGUMENTOS DE LAS FUNCIONES
		    if (raiz instanceof NodoArgList){
		     	InsertarSimbolo(((NodoArgList)raiz).getIdentificador().getNombre(),((NodoArgList)raiz).getTipo(),2);
		     	if(((NodoArgList)raiz).getArgumento()!=null){
		    		cargarTabla(((NodoArgList)raiz).getArgumento());
		    	}
		    }

		    if (raiz instanceof NodoBloque){
		    	cargarTabla(((NodoBloque)raiz).getExpression());
		    }

		    //if (raiz instanceof NodoIdentificador){
		    	//InsertarSimbolo(((NodoIdentificador)raiz).getNombre(),-1);
		    	//TODO: A�adir el numero de linea y localidad de memoria correcta
		   	// }

		    if (raiz instanceof NodoVariable){
		    	if(((NodoVariable)raiz).getId()!=null){
		    		InsertarSimbolo(((NodoVariable)raiz).getId().getNombre(),((NodoVariable)raiz).getTipo(),-1);
		    	}
		    	cargarTabla(((NodoVariable)raiz).getNodo());
		    }

		    if (raiz instanceof NodoArray){
		    	if(((NodoArray)raiz).getId()!=null){
		    		InsertarSimbolo(((NodoArray)raiz).getIdentificador().getNombre(),((NodoArray)raiz).getTipo(),-1);
		    	}
		    	cargarTabla(((NodoArray)raiz).getNodo());
		    }

		    if (raiz instanceof NodoLogico){
		    	cargarTabla(((NodoLogico)raiz).getOpIzquierdo());
		    	cargarTabla(((NodoLogico)raiz).getOpDerecho());
		    }

		    if (raiz instanceof  NodoIf){
		    	cargarTabla(((NodoIf)raiz).getPrueba());
		    	cargarTabla(((NodoIf)raiz).getParteThen());
		    	if(((NodoIf)raiz).getParteElse()!=null){
		    		cargarTabla(((NodoIf)raiz).getParteElse());
		    	}
		    }
		    else if (raiz instanceof  NodoRepeat){
		    	cargarTabla(((NodoRepeat)raiz).getCuerpo());
		    	cargarTabla(((NodoRepeat)raiz).getPrueba());
		    }
		    else if (raiz instanceof  NodoAsignacion)
		    	cargarTabla(((NodoAsignacion)raiz).getExpresion());
		    else if (raiz instanceof  NodoEscribir)
		    	cargarTabla(((NodoEscribir)raiz).getExpresion());
		    else if (raiz instanceof NodoOperacion){
		    	cargarTabla(((NodoOperacion)raiz).getOpIzquierdo());
		    	cargarTabla(((NodoOperacion)raiz).getOpDerecho());
		    }
	    	raiz = raiz.getHermanoDerecha();
	  }
	}
	
	//true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar 
	public boolean InsertarSimbolo(String identificador,tipoDato tipo, int numLinea){
		RegistroSimbolo simbolo;
		if(tabla.containsKey(identificador)){
			return false;
		}else{
			simbolo= new RegistroSimbolo(identificador,tipo,numLinea,direccion++);
			tabla.put(identificador,simbolo);
			return true;			
		}
	}
	
	public RegistroSimbolo BuscarSimbolo(String identificador){
		RegistroSimbolo simbolo=(RegistroSimbolo)tabla.get(identificador);
		return simbolo;
	}
	
	public void ImprimirClaves(){
		System.out.println("*** Tabla de Simbolos ***");
		for( Iterator <String>it = tabla.keySet().iterator(); it.hasNext();) { 
            String s = (String)it.next();
	    System.out.println("Consegui Key: "+s+" con direccion: " + BuscarSimbolo(s).getDireccionMemoria() + " Numero de linea: "+ String.valueOf(BuscarSimbolo(s).getNumLinea()) + "Tipo: " + BuscarSimbolo(s).getTipo());
		}
	}

	public int getDireccion(String Clave){
		return BuscarSimbolo(Clave).getDireccionMemoria();
	}
	
	/*
	 * TODO:
	 * 1. Crear lista con las lineas de codigo donde la variable es usada.
	 * */
}
