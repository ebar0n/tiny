package compilador;

import ast.*;


public class Semantica {

	TablaSimbolos ts;
	
	public Semantica(TablaSimbolos ts){
		this.ts = ts;
	}
	int error_count = 1;
	boolean declare_var = false;
	String ambito = "MAIN";
	
	public void UpAmbito(){
		ambito = ((RegistroSimbolo) ts.BuscarSimbolo(ambito)).getAmbito();
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
		    	declare_var = true;
		    	ambito = nodo.getAmbito();
		    	RecorrerArbol(nodo.getDeclaracion());
		    	UpAmbito();
		    	ambito = nodo.getAmbito();
		    	RecorrerArbol(nodo.getExpression());
		    	declare_var = false;
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
		    	RecorrerArbol(variable.getIdentificador());
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
                        SemanticaValidarUntil(((NodoRepeat)raiz).getPrueba());
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
		    	if(declare_var)
		    		SemanticaValidarDeclaracion((NodoIdentificador)raiz);
		    	else
		    		SemanticaValidarUsoVariable((NodoIdentificador)raiz);
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

		//Regla 1, validar decaraciones repetidas
		public void SemanticaValidarDeclaracion(NodoIdentificador identificador){
			if( identificador != null ){
				RegistroSimbolo simbolo = ts.BuscarSimbolo(identificador.getNombre(), identificador.getAmbito());
				if( simbolo.getNumLinea() + simbolo.getNumColumn() != identificador.getNumLinea() + identificador.getNumColumn()){
					System.out.println("#"+error_count+" -> linea: "+identificador.getNumLinea()+  " -> Variable {"+simbolo.getIdentificador()+"} ya declarada, en la linea: "+simbolo.getNumLinea() + " columna: "+simbolo.getNumColumn());
					error_count++;
				}
				///System.out.println("**Linea: "+simbolo.getNumLinea()+"-> column: "+simbolo.getNumColumn()+"-> symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador());
                //System.out.println("Var: " + identificador.getNombre() + " amb: " + ambito + " line: " + identificador.getNumLinea() + " col: "+identificador.getNumColumn());
			}
		}

		//regla 2, Validar que las variables existen
		public void SemanticaValidarUsoVariable(NodoIdentificador identificador){
			if( identificador != null ){
				//System.out.println("\n\n");
				//System.out.println("Var: " + identificador.getNombre() + " amb: " + ambito + " line: " + identificador.getNumLinea() + " col: "+identificador.getNumColumn());
				
				RegistroSimbolo simbolo = ts.BuscarSimbolo(identificador.getNombre(), ambito);
				if(simbolo == null){
					System.out.println("#"+error_count+" -> linea: "+identificador.getNumLinea()+  " -> Variable {"+identificador.getNombre()+"} no ha sido declarada");
					error_count++;
				}
				else
				if( simbolo.getNumLinea() > identificador.getNumLinea() || (simbolo.getNumLinea() == identificador.getNumLinea()) && ( simbolo.getNumColumn() > identificador.getNumColumn() ))
				{
					System.out.println("#"+error_count+" -> linea: "+identificador.getNumLinea()+" -> Variable {"+identificador.getNombre()+"} debe ser declarada antes de ser usada, si existe pero mas adelante en: linea: "+ simbolo.getNumLinea()+" columna: "+simbolo.getNumColumn());
					error_count++;
				}
			}
		}
                
                public void SemanticaValidarUntil(NodoBase nodo){
                    //generado por cristopher  
                    
                    do{
                        
                        if(nodo instanceof NodoLogico){
                            NodoLogico nodo_logico =(NodoLogico) nodo;
                            //System.out.println("NODOLOGICO");
                            
                            if(nodo_logico.getExp()!=null){
                            nodo = (NodoBase) nodo_logico.getExp();
                            }
                            else if(nodo_logico.getOpIzquierdo()!=null){
                                System.out.println("NODOIZQUIERDO");
                                nodo = (NodoBase) nodo_logico.getOpIzquierdo();
                            }
                            else if(nodo_logico.getOpDerecho()!=null){
                                System.out.println("NODODERECHO");
                                nodo = (NodoBase) nodo_logico.getOpDerecho();
                            }           
                        }
                        
                        if(nodo instanceof NodoOperacion){
                                System.out.println("NODOOPERACION");
                                NodoOperacion nodo_operacion = (NodoOperacion) nodo;
                               
                        }
                        
                        if(nodo instanceof NodoIdentificador){
                            //System.out.println("NODOIDENTIFICADOR");
                            NodoIdentificador nodo_identificador = (NodoIdentificador) nodo;
                            RegistroSimbolo simbolo = ts.BuscarSimbolo(nodo_identificador.getNombre());
                            if(simbolo.getTipo().compareTo(tipoDato.BOOLEAN)!=0){
                             System.out.println("#"+error_count+" -> linea: "+nodo_identificador.getNumLinea()+  " -> Variable {"+nodo_identificador.getNombre()+"} no es parte de un expression valida para el ciclo repeat");   
                             error_count++;
                             nodo=null;
                            }    
                        }
                        
                        if(nodo instanceof NodoValor){
                            //System.out.println("NODOVALOR");
                            NodoValor nodo_valor = (NodoValor) nodo;
                            if(nodo_valor.getValorBoolean()==null){
                             System.out.println("#"+error_count+" -> linea: "+nodo_valor.getNumLinea()+  " -> constante no es parte de un expression valida para el ciclo repeat");   
                             error_count++;
                             nodo=null;
                            }     
                        }
                        
                        if(nodo instanceof NodoCallFunction){
                            System.out.println("NODOFUNCION");
                            NodoCallFunction nodo_funcion = (NodoCallFunction) nodo;
                            RegistroSimbolo simbolo = ts.BuscarSimbolo(nodo_funcion.getIdentificador().getNombre());
                            if(simbolo.getTipo().compareTo(tipoDato.BOOLEAN)!=0){
                             System.out.println("#"+error_count+" -> linea: "+nodo_funcion.getNumLinea()+  " -> Variable {"+nodo_funcion.getIdentificador().getNombre()+"} no es parte de un expression valida para el ciclo repeat");   
                             error_count++;
                             nodo=null;
                            }  
                        }
                        
                    }while(nodo!=null);
                }

	}