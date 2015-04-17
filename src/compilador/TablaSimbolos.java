package compilador;

import java.util.*;


import ast.*;


public class TablaSimbolos {
	private HashMap<String, RegistroSimbolo> tabla;
	private int direccion;  //Contador de las localidades de memoria asignadas a la tabla
	private String ambito;
	private String ambito_padre;
	private int nivel;
	private tipoDato tipo;

	/*Contadores*/
	private int if_ambito_cont = 1;
	private int for_ambito_cont = 1;
	private int repeat_ambito_cont = 1;

	
	public TablaSimbolos() {
		super();
		tabla = new HashMap<String, RegistroSimbolo>();
		direccion=0;
	}

	public void cargarTabla(NodoBase raiz){
		while (raiz != null) {
	    /* Hago el recorrido recursivo */

		    if (raiz instanceof NodoFunction){
		    	ambito = "MAIN";
		    	ambito_padre = "";
		    	nivel = 1;
		    	NodoFunction nodof = (NodoFunction)raiz;
		    	RegistroSimboloFunction simboloFunction = new RegistroSimboloFunction(
										nodof.getIdentificador(),
		    							nodof.getTipo(),
                                        1,
                                        ambito,
                                        ambito_padre,
                                        nivel
                                        );
		    	Integer num_arg = 0;
		    	ambito_padre = ambito;
		    	ambito = nodof.getIdentificador();
		    	if(nodof.getDeclaracion()!=null){
		    		NodoArgList nodoA = (NodoArgList)nodof.getDeclaracion();	    	
		    		while(nodoA !=null ){
		    			InsertarSimbolo(new RegistroSimbolo(nodoA.getIdentificador().getNombre(), nodoA.getTipo(), 1,  ambito,ambito_padre, nivel));
		    			simboloFunction.setTipoParametros(nodoA.getTipo());
		    			simboloFunction.setIdParametros(nodoA.getIdentificador().getNombre());
		    			nodoA = (NodoArgList)nodoA.getArgumento();
		    			num_arg++;
		    		}
		    	}
		    	simboloFunction.setNumParametros(num_arg);
		    	InsertarSimbolo((RegistroSimbolo)simboloFunction);
		    	cargarTabla(((NodoFunction)raiz).getExpression());
		    	ambito = "MAIN";
		    	ambito_padre = "";		    
		    }

		    if (raiz instanceof NodoBloque){
		    	if (ambito == "MAIN"){
		    		InsertarSimbolo(new RegistroSimbolo("MAIN", 1,  "","", nivel));
		    	}
		    	nivel++;
		    	cargarTabla(((NodoBloque)raiz).getExpression());
		    }

		    if (raiz instanceof NodoVariable){
		    	NodoVariable nodo = (NodoVariable)raiz;
		    	if(nodo.getTipo()!=null){
		    		tipo = nodo.getTipo();
		    	}
		    	if(nodo.getId()!=null){
		    		InsertarSimbolo(new RegistroSimbolo(nodo.getId().getNombre(), tipo, 1,  ambito,ambito_padre, nivel));
		    	}
		    	
		    	cargarTabla(nodo.getNodo());
		    }

		    if (raiz instanceof NodoArray){
		    	NodoArray nodoA = (NodoArray)raiz;
		    	if(nodoA.getId()!=null){
		    		InsertarSimbolo(new RegistroSimboloArray(nodoA.getTam(),nodoA.getIdentificador().getNombre(), tipo, 1,  ambito,ambito_padre, nivel));
		    	}
		    	cargarTabla(((NodoArray)raiz).getNodo());
		    }

		    if (raiz instanceof NodoLogico){
		    	cargarTabla(((NodoLogico)raiz).getOpIzquierdo());
		    	cargarTabla(((NodoLogico)raiz).getOpDerecho());
		    }

		    if (raiz instanceof  NodoIf){
		    	String ambito_aux = "IF_"+String.valueOf(nivel)+"_"+String.valueOf(if_ambito_cont);
		    	InsertarSimbolo(new RegistroSimbolo(ambito_aux, 1,  ambito,ambito_padre, nivel));
		    	ambito_padre = ambito;
		    	ambito = ambito_aux;
		    	nivel++;
		    	if_ambito_cont++;
		 
		    	cargarTabla(((NodoIf)raiz).getPrueba());
		    	cargarTabla(((NodoIf)raiz).getParteThen());
		    	if(((NodoIf)raiz).getParteElse()!=null){
		    		cargarTabla(((NodoIf)raiz).getParteElse());
		    	}

		    	ambito = ambito_padre;
		    }
		    else if (raiz instanceof  NodoRepeat){
		    	String ambito_aux = "REPEAT_"+String.valueOf(nivel)+"_"+String.valueOf(repeat_ambito_cont);
		    	InsertarSimbolo(new RegistroSimbolo(ambito_aux, 1,  ambito,ambito_padre, nivel));
		    	ambito_padre = ambito;
		    	ambito = ambito_aux;
		    	nivel++;
		    	repeat_ambito_cont++;

		    	cargarTabla(((NodoRepeat)raiz).getCuerpo());
		    	cargarTabla(((NodoRepeat)raiz).getPrueba());

		    	ambito = ambito_padre;
		    }
		    else if (raiz instanceof  NodoAsignacion)
		    	cargarTabla(((NodoAsignacion)raiz).getExpresion());
		    else if (raiz instanceof  NodoEscribir)
		    	cargarTabla(((NodoEscribir)raiz).getExpresion());
		    else if (raiz instanceof NodoOperacion){
		    	cargarTabla(((NodoOperacion)raiz).getOpIzquierdo());
		    	cargarTabla(((NodoOperacion)raiz).getOpDerecho());
		    }
		    else if (raiz instanceof NodoFor){
		    	String ambito_aux = "FOR_"+String.valueOf(nivel)+"_"+String.valueOf(for_ambito_cont);
		    	InsertarSimbolo(new RegistroSimbolo(ambito_aux, 1,  ambito, ambito_padre, nivel));
		    	ambito_padre = ambito;
		    	ambito = ambito_aux;
		    	nivel++;
		    	for_ambito_cont++;

		    	cargarTabla(((NodoFor)raiz).getInicializacion());
		    	cargarTabla(((NodoFor)raiz).getCondicion());
		    	cargarTabla(((NodoFor)raiz).getIncremento());
		    	cargarTabla(((NodoFor)raiz).getSentencia());

		    	ambito = ambito_padre;
		    }
	    	raiz = raiz.getHermanoDerecha();
	  }
	}
	
	//true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar 
	public boolean InsertarSimbolo(RegistroSimbolo simbolo){
		if(tabla.containsKey(simbolo.getIdentificador())){
			RegistroSimbolo simbolo_tabla = BuscarSimbolo(simbolo.getIdentificador());
			if (simbolo_tabla.getAmbito().equals(simbolo.getAmbito())){
				System.out.println("Iguales");
				System.out.println(simbolo.getIdentificador());
				return false;
			}
			else{
				tabla.put(simbolo.getIdentificador(),simbolo);
				return true;
			}
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
	    	System.out.println("Consegui Key: "+s+  " tipo: " + BuscarSimbolo(s).getTipo() + " ambito: " + BuscarSimbolo(s).getAmbito()+ " ambito padre: " + BuscarSimbolo(s).getAmbitoPadre()+ " nivel: " + String.valueOf(BuscarSimbolo(s).getNivel()));
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
