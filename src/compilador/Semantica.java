package compilador;

import ast.*;


public class Semantica {

	TablaSimbolos ts;
	
	public Semantica(TablaSimbolos ts){
		this.ts = ts;
	}
	int error_count = 1;
	boolean declare_var = false;
	String ambito = TablaSimbolos.conts_ambito_global;
	boolean is_array = false;
	
	public void UpAmbito(){
		if( ambito == TablaSimbolos.conts_ambito_global ){
			ambito = ((RegistroSimbolo) ts.BuscarSimbolo(ambito)).getAmbito();
		}
	}	


	public void RecorrerArbol(NodoBase raiz){
		while (raiz != null) {
		
			if (raiz instanceof NodoBloque){
		    	//BLOQUE UNICO
		    	NodoBloque nodo = (NodoBloque)raiz;
		    	
		    	ambito = nodo.getAmbito();
		    	RecorrerArbol(nodo.getExpression());
		    	UpAmbito();
		    }
		    else if (raiz instanceof NodoFunction){	
		    	//FUNCIONES
		    	NodoFunction nodo = (NodoFunction)raiz;
		    	SemanticaValidarDeclaracionTipoFuntions(nodo.getIdentificador());
		    	
		    	declare_var = true;
		    	ambito = nodo.getAmbito();
		    	RecorrerArbol(nodo.getDeclaracion());
		    	UpAmbito();
		    	ambito = nodo.getAmbito();
		    	declare_var = false;
		    	
		    	RecorrerArbol(nodo.getExpression());

		    	UpAmbito();
		    }
		    else if (raiz instanceof NodoVariable){
		    	NodoVariable variable = (NodoVariable)raiz;
		    	declare_var = true;
		    	RecorrerArbol(variable.getIdentificador());
		    	RecorrerArbol(variable.getNodo());
		    	declare_var = false;
		    }
		    else if (raiz instanceof NodoArray ){
		    	NodoArray variable = (NodoArray)raiz;
		    	
		    	is_array = true;
		    	RecorrerArbol(variable.getIdentificador());
		    	is_array = false;
		    	
		    	RecorrerArbol(variable.getNodo());

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
		    	ambito = ((NodoIf)raiz).getAmbito();
		    	RecorrerArbol(((NodoIf)raiz).getPrueba());
		    	//THEN IF
		    	RecorrerArbol(((NodoIf)raiz).getParteThen());
		    	if(((NodoIf)raiz).getParteElse()!=null){
		    		//PARTE ELSE
		    		ambito = ((NodoIf)raiz).getAmbito();
		    	
		    		RecorrerArbol(((NodoIf)raiz).getParteElse());
		    	}
		    	UpAmbito();
		    }
		    else if (raiz instanceof  NodoRepeat){
		    	//CUERPO REPEAT
		    	ambito = ((NodoRepeat)raiz).getAmbito();
		    	RecorrerArbol(((NodoRepeat)raiz).getCuerpo());
		    	//PRUEBA REPEAT
		    	RecorrerArbol(((NodoRepeat)raiz).getPrueba());
		    	UpAmbito();
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
		    	if(declare_var == true){
		    		if( raiz.getAmbito() == null ){
		    			raiz.setAmbito(ambito);
		    		}
		    		SemanticaValidarDeclaracionTipoVariable((NodoIdentificador)raiz);
		    	}
		    	else{
		    		raiz.setAmbito(ambito);
		    		SemanticaValidarUsoDeVariables((NodoIdentificador)raiz);
		    	}
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
		    		//EXP IZQUIERDA OPERACION
			    	RecorrerArbol(logico.getOpIzquierdo());
			    	//EXP DERECHA OPERACION
			    	RecorrerArbol(logico.getOpDerecho());
			    }
		    }
		    else if (raiz instanceof NodoCallFunction){
		    	//LLMAR A FUNCION
		    	if (((NodoCallFunction)raiz).getVariables()!=null){
		    		//System.out.println(" Con parametos ->");
		    		NodoParamFunction var = (NodoParamFunction)((NodoCallFunction)raiz).getVariables(); 
		    		while(var!=null){
		    			RecorrerArbol(var.getExpresion());
		    			var = (NodoParamFunction)var.getSiguiente();
		    		}
		    	}
		    	else{
		    		//System.out.println(" Sin parametos");
		    	}
		    }
		    else if (raiz instanceof NodoReturn ){
		    	//System.out.println("Return");	

		    	RecorrerArbol(((NodoReturn)raiz).getExpresion());
		    }
		    else if (raiz instanceof NodoFor ){
		    	//INICIALIZACION CICLO FOR
		    	ambito = ((NodoFor)raiz).getAmbito();
		    	RecorrerArbol(((NodoFor)raiz).getInicializacion());
		    	//CONDICION LOGICA EXPRESION
		    	RecorrerArbol(((NodoFor)raiz).getCondicion());
		    	//INCREMENTO ASIGNACION
		    	RecorrerArbol(((NodoFor)raiz).getIncremento());
		    	//CUERPO FOR
		    	RecorrerArbol(((NodoFor)raiz).getSentencia());
		    	UpAmbito();
		    }
		    else{ 
		    	//System.out.println("Tipo de nodo desconocido " + raiz);
		    }
		    raiz = raiz.getHermanoDerecha();
			}	
		}

		//Regla 1, validar decaraciones repetidas de variables
		public void SemanticaValidarDeclaracionTipoVariable(NodoIdentificador identificador){
			if( identificador != null ){
				//System.out.println("Var: " + identificador.getNombre() + " amb: " + ambito + " line: " + identificador.getNumLinea() + " col: "+identificador.getNumColumn());
				RegistroSimbolo simbolo = ts.BuscarSimbolo(identificador.getNombre(), identificador.getAmbito());
				if (simbolo.getTipeSymbol() != tipoSymbol.FUNCTION){
					if( simbolo.getNumLinea() + simbolo.getNumColumn() != identificador.getNumLinea() + identificador.getNumColumn()){
						
						if(TablaSimbolos.conts_ambito_global == simbolo.getAmbito() && simbolo.getAmbito()==ts.BuscarSimbolo(identificador.getAmbito()).getAmbito()){
							//Falsa alarma, el simbolo existe pero en el main, y esta declarado otra vez en una funcion
						}
						else{
							System.out.println("N°"+error_count+" (Regla#1.1)-> linea: "+identificador.getNumLinea()+  " -> Variable {"+simbolo.getIdentificador()+"} ya declarada, en la linea: "+simbolo.getNumLinea() + " columna: "+simbolo.getNumColumn());
							error_count++
						;}
					}
					//System.out.println("**Linea: "+simbolo.getNumLinea()+"-> column: "+simbolo.getNumColumn()+"-> symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador());
            	}
        	}
		}

		//Regla 1, validar decaraciones repetidas de funciones
		public void SemanticaValidarDeclaracionTipoFuntions(NodoIdentificador identificador){
			if( identificador != null ){
				//System.out.println("Var: " + identificador.getNombre() + " amb: " + ambito + " line: " + identificador.getNumLinea() + " col: "+identificador.getNumColumn());
				RegistroSimbolo simbolo = ts.BuscarSimboloIsFunction(identificador.getNombre());
					if( simbolo.getNumLinea() + simbolo.getNumColumn() != identificador.getNumLinea() + identificador.getNumColumn()){
						System.out.println("N°"+error_count+" (Regla#1.2)-> linea: "+identificador.getNumLinea()+  " -> Funcion {"+simbolo.getIdentificador()+"} ya declarada, en la linea: "+simbolo.getNumLinea() + " columna: "+simbolo.getNumColumn());
						error_count++;
					}
				//System.out.println("**Linea: "+simbolo.getNumLinea()+"-> column: "+simbolo.getNumColumn()+"-> symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador());
            }
		}

		//regla 2, Validar que las variables existen
		public void SemanticaValidarUsoDeVariables(NodoIdentificador identificador){
			if( identificador != null ){
				//System.out.println("\n\n");
				//System.out.println("Validando => Var: " + identificador.getNombre() + " amb: " + ambito + " line: " + identificador.getNumLinea() + " col: "+identificador.getNumColumn());
				//System.out.println("Validando => Var: " + identificador.getNombre() + " amb: " + identificador.getAmbito() + " line: " + identificador.getNumLinea() + " col: "+identificador.getNumColumn());
				RegistroSimbolo simbolo = ts.BuscarSimbolo(identificador.getNombre(), identificador.getAmbito());
				if(simbolo == null){
					System.out.println("N°"+error_count+" (Regla#2)-> linea: "+identificador.getNumLinea()+  " -> Variable {"+identificador.getNombre()+"} no ha sido declarada");
					error_count++;
				}
				else
				if( simbolo.getNumLinea() > identificador.getNumLinea() || (simbolo.getNumLinea() == identificador.getNumLinea()) && ( simbolo.getNumColumn() > identificador.getNumColumn() ))
				{	
					if( simbolo.getAmbito() == TablaSimbolos.conts_ambito_global && ts.EstoyDentroDeUnaFuncion(ts.BuscarSimbolo(identificador.getAmbito()))){
						//falsa alarma, tengo la variable declarada en el main, y la uso en una funcion
						//verificar tipo de variable, normal o array
						verificarUsoTipoVar(identificador, simbolo);
					}
					else{
						System.out.println("N°"+error_count+" (Regla#2)-> linea: "+identificador.getNumLinea()+" -> Variable {"+identificador.getNombre()+"} debe ser declarada antes de ser usada, si existe pero mas adelante en: linea: "+ simbolo.getNumLinea()+" columna: "+simbolo.getNumColumn());
						error_count++;
					}
				}
				else{
					verificarUsoTipoVar(identificador, simbolo);
					//verificar tipo de variable, normal o array
				}
			}
		}
		
		//Regla 3
		public void verificarUsoTipoVar(NodoIdentificador identificador, RegistroSimbolo simbolo){
			if( simbolo.getTipeSymbol() == tipoSymbol.ARRAY ){
				if (this.is_array == false){
					System.out.println("N°"+error_count+" (Regla#3)-> linea: "+identificador.getNumLinea()+" -> Variable {"+identificador.getNombre()+"} se usa de forma indebida, fue declarada como array");
					error_count++;
				}
			}
			else{
				if( simbolo.getTipeSymbol() == tipoSymbol.VAR ){
					if (this.is_array == true){
						System.out.println("N°"+error_count+" (Regla#3)-> linea: "+identificador.getNumLinea()+" -> Variable {"+identificador.getNombre()+"} se usa de forma indebida, fue declarada como variable");
						error_count++;
					}
				}
				else{
					//este error no deberia darse
					System.out.println("N°"+error_count+" (Regla#3)-> linea: "+identificador.getNumLinea()+" -> identificador {"+identificador.getNombre()+"} no se reconoce como variable o array");
					error_count++;
				}
			}
		}

	}