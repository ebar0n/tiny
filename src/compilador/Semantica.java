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
	
	//Verificacion de tipo
	tipoDato tipo = null;
	boolean tipoBandera = true;
	
	String Parte_for = null, variable_for = null;
	int num_uso = 0,num_uso_inc = 0, ciclo_for = 0 , linea_for = 0; //<- for

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
                //if(ciclo_for == 1)
                    //SemanticaCicloFor((NodoIdentificador)raiz,Parte_for);
		    }
		    else if (raiz instanceof NodoOperacion){
		    	//EXPRESION PARTE IZQUIERDA
		    	RecorrerArbol(((NodoOperacion)raiz).getOpIzquierdo());
		    	//EXPRESION PARTE DERECHA	    	
		    	RecorrerArbol(((NodoOperacion)raiz).getOpDerecho());
		    }
		    else if (raiz instanceof NodoLogico){
		    	//OPERACIONES
		    	tipoDato tipoI;
				tipoDato tipoD;
		    	NodoLogico logico = (NodoLogico)raiz;
		    	//EXP IZQUIERDA OPERACION
			    RecorrerArbol(logico.getOpIzquierdo());
			    SemanticaValidarTipo(logico.getOpIzquierdo());
			    if (logico.getOpIzquierdo() != null){
				    if (logico.getOpIzquierdo() instanceof NodoOperacion){
						tipoI =  ((NodoOperacion)logico.getOpIzquierdo()).getTipoDato();
					}else{
						tipoI = tipo;
					}
				}else{
					tipoI = null;
				}
			    //EXP DERECHA OPERACION
			    RecorrerArbol(logico.getOpDerecho());
			    SemanticaValidarTipo(logico.getOpDerecho());
			    if (logico.getOpDerecho() != null){
				    if (logico.getOpDerecho() instanceof NodoOperacion){
						tipoD =  ((NodoOperacion)logico.getOpDerecho()).getTipoDato();
					}else{
						tipoD = tipo;
					}
				}else {
					tipoD = null;
				}
			    
			    if (tipoD != null && tipoI != null){
			    	if (tipoI == tipoD) {
			    		if (tipoI == tipoDato.INT){
			    			System.out.println("ERROR DE TIPOS, Verifique la operacion de la linea tal");
			    		}else{
			    			logico.setTipoDato(tipoI);
			    			//System.out.println(tipoI);
			    		}
			    	}else{
			    		System.out.println("ERROR DE TIPOS, Verifique la operacion de la linea tal");
			    	}
			    }else if (tipoD == null){
			    	logico.setTipoDato(tipoI);
			    	//System.out.println(tipoI);
			    }else if (tipoI == null){
			    	logico.setTipoDato(tipoD);
			    	//System.out.println(tipoD);
			    }



			    System.out.println("FIN LOGICO");
			    

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
                //ciclo_for = 1;
		    	ambito = ((NodoFor)raiz).getAmbito();
		    	//Parte_for = "INICIALIZACION";
		    	RecorrerArbol(((NodoFor)raiz).getInicializacion());
                //CONDICION LOGICA EXPRESION
                //Parte_for = "CONDICION";
		    	RecorrerArbol(((NodoFor)raiz).getCondicion());
		    	//INCREMENTO ASIGNACION
		    	
		    	//Parte_for = "INCREMENTO";
		    	RecorrerArbol(((NodoFor)raiz).getIncremento());
		    	//CUERPO FOR
		    	//ciclo_for = 0;
		    	//Parte_for = null;
		    	RecorrerArbol(((NodoFor)raiz).getSentencia());
		    	//SemanticaCicloForValidar();
		    	UpAmbito();
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

		//Regla 3, Verificacion de tipos de datos
		public void SemanticaValidarTipo(NodoBase nodo){
			//System.out.println(nodo);
			if (nodo instanceof NodoOperacion){
				tipoDato tipoI;
				tipoDato tipoD;
				//System.out.println(((NodoOperacion)nodo).getOperacion());
				SemanticaValidarTipo(((NodoOperacion)nodo).getOpIzquierdo());
				if (((NodoOperacion)nodo).getOpIzquierdo() instanceof NodoOperacion){
					tipoI =  ((NodoOperacion)((NodoOperacion)nodo).getOpIzquierdo()).getTipoDato();
				}else{
					tipoI = tipo;
				}
				SemanticaValidarTipo(((NodoOperacion)nodo).getOpDerecho());
				if (((NodoOperacion)nodo).getOpDerecho() instanceof NodoOperacion){
					tipoD =  ((NodoOperacion)((NodoOperacion)nodo).getOpDerecho()).getTipoDato();
				}else{
					tipoD = tipo;
				}
				

				if (tipoI == tipoD){
					tipoOp operacion = ((NodoOperacion)nodo).getOperacion();
					if (tipoI ==  tipoDato.BOOLEAN){
						if (operacion != tipoOp.igual && operacion != tipoOp.diferente){
							System.out.println("ERROR DE TIPOS, Verifique la operacion de la linea tal");
						}

					}else if  (tipoI == tipoDato.INT){
						if (operacion == tipoOp.menor
						 || operacion == tipoOp.mayor
						 || operacion == tipoOp.mayori
						 || operacion == tipoOp.menori
						 || operacion == tipoOp.diferente
						 || operacion == tipoOp.igual){
							tipoI = tipoDato.BOOLEAN;
						}
					}
					((NodoOperacion)nodo).setTipoDato(tipoI);
					//System.out.println(tipoI);
				}else{
					System.out.println("ERROR DE TIPOS, Verifique la operacion de la linea tal");
				}
			}else if (nodo instanceof NodoValor){
				tipo = ((NodoValor)nodo).getTipoDato();
			}else if (nodo instanceof NodoIdentificador){
				RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoIdentificador)nodo).getNombre(), ambito);
			    tipo = simbolo.getTipo();
			}else if (nodo instanceof NodoArray){
				RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoArray)nodo).getIdentificador().getNombre(), ambito);
			    tipo = simbolo.getTipo();
			}else if (nodo instanceof NodoCallFunction){
				RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoCallFunction)nodo).getIdentificador().getNombre(), ambito);
			    tipo = simbolo.getTipo();
			}



				//System.out.println(((NodoOperacion)nodo).getOperacion());
				/*
				if (((NodoOperacion)nodo).getOpDerecho() != null){
					//System.out.println("Derecho");
			    	if (((NodoOperacion)nodo).getOpDerecho() instanceof NodoValor){
						tipo = ((NodoValor)((NodoOperacion)nodo).getOpDerecho()).getTipoDato();
			    	}else if (((NodoOperacion)nodo).getOpDerecho() instanceof NodoIdentificador){
						RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoIdentificador)((NodoOperacion)nodo).getOpDerecho()).getNombre(), ambito);
			    		tipo = simbolo.getTipo();
			    	}else if (((NodoOperacion)nodo).getOpDerecho() instanceof NodoArray){
						RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoArray)((NodoOperacion)nodo).getOpDerecho()).getIdentificador().getNombre(), ambito);
			    		tipo = simbolo.getTipo();
			    	}else if (((NodoOperacion)nodo).getOpDerecho() instanceof NodoCallFunction){
						//RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoCallFunction)((NodoOperacion)nodo).getOpDerecho()).getIdentificador().getNombre(), ambito);
			    		//tipo = simbolo.getTipo();
			    	}
			    	else {
			    		//System.out.println("Derecho1");
			    		SemanticaValidarTipo(((NodoOperacion)nodo).getOpDerecho());
			    	}

		    	}
		    	
		    	VerificarTipo(tipo);

				if (((NodoOperacion)nodo).getOpIzquierdo() != null){
					System.out.println("Izquierdo");
			    	if (((NodoOperacion)nodo).getOpIzquierdo() instanceof NodoValor){
						tipo = ((NodoValor)((NodoOperacion)nodo).getOpIzquierdo()).getTipoDato();
			    	}else if (((NodoOperacion)nodo).getOpIzquierdo() instanceof NodoIdentificador){
						RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoIdentificador)((NodoOperacion)nodo).getOpIzquierdo()).getNombre(), ambito);
			    		tipo = simbolo.getTipo();
			    	}else if (((NodoOperacion)nodo).getOpIzquierdo() instanceof NodoArray){
						RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoArray)((NodoOperacion)nodo).getOpIzquierdo()).getIdentificador().getNombre(), ambito);
			    		tipo = simbolo.getTipo();
			    	}else if (((NodoOperacion)nodo).getOpIzquierdo() instanceof NodoCallFunction){
						//RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoCallFunction)((NodoOperacion)nodo).getOpIzquierdo()).getIdentificador().getNombre(), ambito);
			    		//tipo = simbolo.getTipo();
			    	}
			    	else {
			    		System.out.println("Izquierdo1");
			    		SemanticaValidarTipo(((NodoOperacion)nodo).getOpIzquierdo());
			    	}
		    	}
		    	VerificarTipo(tipo);

		    	if (tipoBandera){
		    		((NodoOperacion)nodo).setTipoDato(tipoPadre);
		    		//System.out.println(tipoPadre);
		    	}else {
		    		System.out.println("Error en los tipos no coinciden");
		    	}
				*/
			
			
		}
		/*
		public void VerificarTipo(tipoDato tipo){
			if (tipo != null){
				if (tipoPadre == null){
					tipoPadre = tipo;
				} else if (tipoPadre != tipo){
					tipoBandera = false;
				} else{
				}
			}
		}*/
		




                
        //Regla 3, Ciclo FOR
        public void SemanticaCicloFor(NodoIdentificador identificador,String parte_for){
            if(identificador != null){
                RegistroSimbolo simbolo = ts.BuscarSimbolo(identificador.getNombre(), ambito);
                if(num_uso == 0 && parte_for == "INICIALIZACION"){
            		variable_for = simbolo.getIdentificador();
            		linea_for = identificador.getNumLinea();
            		System.out.println("La variable del for es: " + variable_for);
            	}if(parte_for == "CONDICION" && variable_for == simbolo.getIdentificador())
            		num_uso++;
            	if(parte_for == "INCREMENTO" && variable_for == simbolo.getIdentificador())
            		num_uso_inc++;
            }
		}
		//Regla 3, Validacion del Ciclo FOR
		public void SemanticaCicloForValidar(){ 
        	if(num_uso_inc < 2 || num_uso < 1){
        		error_count++;	
        		System.out.println("#"+error_count+" -> linea: "+linea_for+" -> Variable {"+variable_for+"} revisar parametros del for");
        	}
        	num_uso_inc = 0;
        	num_uso = 0;
        	variable_for = null;
        }
	}