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

		    if (raiz instanceof NodoFunction){
		    	NodoFunction nodof = (NodoFunction)raiz;
		    	RegistroSimboloFunction simboloFunction = new RegistroSimboloFunction(
										nodof.getIdentificador(),
		    							nodof.getTipo(),
                                        1,
                                        "main"
                                        );
		    	Integer num_arg = 0;
		    	if(nodof.getDeclaracion()!=null){
		    		NodoArgList nodoA = (NodoArgList)nodof.getDeclaracion();		    	
		    		while(nodoA !=null ){
		    			InsertarSimbolo(new RegistroSimbolo(nodoA.getIdentificador().getNombre(), nodoA.getTipo(), 1,  nodoA.getIdentificador().getNombre()));
		    			nodoA = (NodoArgList)nodoA.getArgumento();
		    			num_arg++;
		    		}
		    	}
		    	simboloFunction.setNumParametros(num_arg);
		    	InsertarSimbolo((RegistroSimbolo)simboloFunction);
		    	
		    	cargarTabla(((NodoFunction)raiz).getExpression());
		    }

		    //ARGUMENTOS DE LAS FUNCIONES
		    if (raiz instanceof NodoArgList){
		     	//InsertarSimbolo(((NodoArgList)raiz).getIdentificador().getNombre(),((NodoArgList)raiz).getTipo(),2);
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
		    		//InsertarSimbolo(((NodoVariable)raiz).getId().getNombre(),((NodoVariable)raiz).getTipo(),-1);
		    	}
		    	cargarTabla(((NodoVariable)raiz).getNodo());
		    }

		    if (raiz instanceof NodoArray){
		    	if(((NodoArray)raiz).getId()!=null){
		    		//InsertarSimbolo(((NodoArray)raiz).getIdentificador().getNombre(),((NodoArray)raiz).getTipo(),-1);
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
	public boolean InsertarSimbolo(RegistroSimbolo simbolo){
		if(tabla.containsKey(simbolo.getIdentificador())){
			return false;
		}else{
			tabla.put(simbolo.getIdentificador(),simbolo);
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
