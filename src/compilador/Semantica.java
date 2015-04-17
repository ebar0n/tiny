package compilador;

import ast.*;


public class Semantica {

	TablaSimbolos ts;
	
	public Semantica(){
		ts = new TablaSimbolos();
	}

	public void RecorrerArbol(NodoBase raiz){
		while (raiz != null) {
		
			if (raiz instanceof NodoBloque){
		    	//BLOQUE UNICO
		    	NodoBloque nodo = (NodoBloque)raiz;
		    }
		    else if (raiz instanceof NodoFunction){	
		    	//FUNCIONES
		    	NodoFunction nodo = (NodoFunction)raiz;
		    	System.out.println("Funcion "+nodo.getTipo());
		    	RecorrerArbol(nodo.getDeclaracion());
		    	RecorrerArbol(nodo.getExpression());
		    }
		    else if (raiz instanceof NodoVariable || raiz instanceof NodoArray ){
		    	NodoVariable nodov = null;
		    	NodoArray nodoa = null;
		    	
		    	if (raiz instanceof NodoVariable){
		    		nodov = (NodoVariable)raiz;
		    	}
		    	else if (raiz instanceof NodoArray){
		    		nodoa = (NodoArray)raiz;
		    	}

		    	if (nodov != null)
		    		if(nodov.getTipo()!=null)
		    			System.out.println("Declarar variable de tipo "+nodov.getTipo());
		    		else
		    			System.out.println("Uso variable");	
		    	else
		    		if(nodoa.getTipo()!=null)
		    			System.out.println("Declarar variable de tipo "+nodoa.getTipo());
		    		else
		    			System.out.println("Uso variable");	
		    	
		    	NodoBase nodo = null;

		    	while (nodov!=null || nodoa!=null) {
		    		
		    		if (nodov != null){
		    			nodo = nodov.getNodo();
		    		}
		    		else if (nodoa != null){
		    			String verbose = "";
		    			if(nodoa.getTam() != null){
		    				verbose = "Tam: "+nodoa.getTam();
		    			}
		    			else{
		    				verbose = "Buscando posicion: ?";
		    			}
		    			if(nodoa.getPos() != null){
		    				System.out.println("**Buscando(");
		    				RecorrerArbol(nodoa.getPos());
		    			}
		    			nodo = nodoa.getNodo();
		    		}
		    		nodov = null;
		    		nodoa = null;
		    		
		    		if (nodo instanceof NodoVariable){
		    			nodov = (NodoVariable)nodo;
		    		}
		    		else if (nodo instanceof NodoArray){
		    			nodoa = (NodoArray)nodo;
		    		}

		    	}
		    	
		    }else if(raiz instanceof NodoArgList){
		    	//ARGUMENTOS FUNCIONES
		    	NodoArgList nodoA = (NodoArgList)raiz;

		    	if (nodoA != null){
		    		if(nodoA.getArgumento()!=null)
		    			RecorrerArbol(nodoA.getArgumento());
		    	}
		    	
		    }
			    else if (raiz instanceof  NodoIf){
		    	//PRUEBA IF
		    	RecorrerArbol(((NodoIf)raiz).getPrueba());
		    	//THEN IF
		    	System.out.println("**Then IF**");
		    	RecorrerArbol(((NodoIf)raiz).getParteThen());
		    	if(((NodoIf)raiz).getParteElse()!=null){
		    		//PARTE ELSE
		    		RecorrerArbol(((NodoIf)raiz).getParteElse());
		    	}
		    }
		    else if (raiz instanceof  NodoRepeat){
		    	//CUERPO REPEAT
		    	RecorrerArbol(((NodoRepeat)raiz).getCuerpo());
		    	//PRUEBA REPEAT
		    	RecorrerArbol(((NodoRepeat)raiz).getPrueba());
		    }
		    else if (raiz instanceof  NodoAsignacion){
		    	//ASIGNACION PARTE IZQUIERDA
		    	RecorrerArbol(((NodoAsignacion)raiz).getId());
		    	//ASIGNACION PARTE DERECHA
		    	RecorrerArbol(((NodoAsignacion)raiz).getExpresion());
		    }
		    else if (raiz instanceof  NodoLeer){
		    	//LECTURA
		    	RecorrerArbol(((NodoLeer)raiz).getIdentificador());
		    }
		    else if (raiz instanceof  NodoEscribir){
		    	//ESCRITURA
		    	RecorrerArbol(((NodoEscribir)raiz).getExpresion());
		    }
		    else if (raiz instanceof NodoValor){
		    	//VALOR
		    }
		    else if (raiz instanceof NodoIdentificador ){
		    	//VARIABLE
		    }
		    else if (raiz instanceof NodoOperacion){
		    	//EXPRESION PARTE IZQUIERDA
		    	RecorrerArbol(((NodoOperacion)raiz).getOpIzquierdo());
		    	//EXPRESION PARTE DERECHA	    	
		    	RecorrerArbol(((NodoOperacion)raiz).getOpDerecho());
		    }
		    else if (raiz instanceof NodoLogico){
		    	//OPERACIONES
		    	NodoLogico logico = (NodoLogico)raiz;
		    	NodoBase nodo = logico.getExp();
		    	if (nodo != null){
			    	//OPERACION QUE RETORNA UN FACTOR
		    		RecorrerArbol(nodo);
		    	}
		    	else{
		    		System.out.println("Operacion logica: "+logico.getOperacion());
			    	//EXP IZQUIERDA OPERACION
			    	RecorrerArbol(logico.getOpIzquierdo());
			    	printSpaces();
			    	//EXP DERECHA OPERACION
			    	RecorrerArbol(logico.getOpDerecho());
			    }
		    }
		    else if (raiz instanceof NodoCallFunction){
		    	//LLMAR A FUNCION
		    	if (((NodoCallFunction)raiz).getVariables()!=null){
		    		System.out.println(" Con parametos ->");
		    		NodoParamFunction var = (NodoParamFunction)((NodoCallFunction)raiz).getVariables(); 
		    		while(var!=null){
		    			RecorrerArbol(var.getExpresion());
		    			var = (NodoParamFunction)var.getSiguiente();
		    		}
		    	}
		    	else{
		    		System.out.println(" Sin parametos");
		    	}
		    }
		    else if (raiz instanceof NodoReturn ){
		    	System.out.println("Return");	
		    	RecorrerArbol(((NodoReturn)raiz).getExpresion());
		    }
		    else if (raiz instanceof NodoFor ){
		    	//INICIALIZACION CICLO FOR
		    	RecorrerArbol(((NodoFor)raiz).getInicializacion());
		    	//CONDICION LOGICA EXPRESION
		    	RecorrerArbol(((NodoFor)raiz).getCondicion());
		    	//INCREMENTO ASIGNACION
		    	RecorrerArbol(((NodoFor)raiz).getIncremento());
		    	//CUERPO FOR
		    	RecorrerArbol(((NodoFor)raiz).getSentencia());
		    }
		    else System.out.println("Tipo de nodo desconocido " + raiz);
		    
		    raiz = raiz.getHermanoDerecha();
		}	
		}
	}
}