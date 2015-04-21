package compilador;

import ast.*;


public class Semantica {

	TablaSimbolos ts;
    tipoDato funcion_actual;//guarda el tipo de dato de la funcion que esta recorriendo
    int Existe_return; //verifica si hay al menos un return en la funcion que esta siendo recorrida
	
	public Semantica(TablaSimbolos ts){
		this.ts = ts;
	}
	int error_count = 1, warning_count = 1;
	boolean declare_var = false;

	//Verificacion de tipo
	tipoDato tipo = null;
	boolean tipoBandera = true;
	
	//Variables de Ciclo FOR
	String Parte_for = null, variable_for = null;
	int num_uso = 0,num_uso_inc = 0, ciclo_for = 0 , linea_for = 0;

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
		    	
                //Tipo de funcion
                funcion_actual = nodo.getTipo();

		    	declare_var = true;
		    	ambito = nodo.getAmbito();      
		    	RecorrerArbol(nodo.getDeclaracion());
		    	UpAmbito();

		    	ambito = nodo.getAmbito();
                        
                Existe_return = 0;
                RecorrerArbol(nodo.getExpression());
		    	//Verifico si despues del recorrido encontro almenos un return
                if(Existe_return < 1 && funcion_actual.compareTo(tipoDato.VOID)!=0){
                	SemanticaReturnFuncionNoExist(nodo);//hay error, no consiguio almenos un return
                }
                        
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
		    	
		    	this.is_array = true;
		    	RecorrerArbol(variable.getIdentificador());
		    	this.is_array = false;
		    	
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
                //SemanticaValidarUntil(((NodoRepeat)raiz).getPrueba());
		    	RecorrerArbol(((NodoRepeat)raiz).getPrueba());
                        
		    	UpAmbito();
		    }
		    else if (raiz instanceof  NodoAsignacion){
		    	tipoDato tipoI;
				tipoDato tipoD;
		    	//ASIGNACION PARTE IZQUIERDA
		    	RecorrerArbol(((NodoAsignacion)raiz).getIdentificadorOrArray());
		    	//ASIGNACION PARTE DERECHA
		    	RecorrerArbol(((NodoAsignacion)raiz).getExpresion());
		    	//VALIDACION QUE LA ASIGNACION CORRESPONDA CON EL TIPO DE DATO
		    	SemanticaValidarAsignacion(((NodoAsignacion)raiz).getIdentificadorOrArray(),((NodoAsignacion)raiz).getExpresion());
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

		    	if(ciclo_for == 1)
                    SemanticaCicloFor((NodoIdentificador)raiz,Parte_for);

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
		    	NodoReturn nodo = (NodoReturn)raiz;
		    	if( funcion_actual != null ){
	                if(funcion_actual.compareTo(tipoDato.VOID)!=0){
	                    Existe_return++;
	              		if( nodo.getExpresion() == null){
	              			SemanticaReturnFuncionInvalid(nodo,true);
	              		}      
	                }
	                else{
	                	if( nodo.getExpresion() != null){
	              			SemanticaReturnFuncionInvalid(nodo,false);
	              		}  
	                }
	            }
                  
		    	RecorrerArbol(nodo.getExpresion());
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
		    else{ 
		    	//System.out.println("Tipo de nodo desconocido " + raiz);
		    }
		    raiz = raiz.getHermanoDerecha();
		}	
	}

	//Regla 1, validar decaraciones repetidas de variables
	public void SemanticaValidarDeclaracionTipoVariable(NodoIdentificador identificador){
		if( identificador != null ){
			//System.out.println("Var: " + identificador.getNombre() + " amb: " + ambito + " line: " + identificador.getNumLineaDeclare() + " col: "+identificador.getNumColumnDeclare());
			RegistroSimbolo simbolo = ts.BuscarSimbolo(identificador.getNombre(), identificador.getAmbito());
			if (simbolo.getTipeSymbol() != tipoSymbol.FUNCTION){
				if( simbolo.getNumLineaDeclare() + simbolo.getNumColumnDeclare() != identificador.getNumLinea() + identificador.getNumColumn()){
					
					if(TablaSimbolos.conts_ambito_global == simbolo.getAmbito() && simbolo.getAmbito()==ts.BuscarSimbolo(identificador.getAmbito()).getAmbito()){
						//Falsa alarma, el simbolo existe pero en el main, y esta declarado otra vez en una funcion
					}
					else{
						System.out.println("#Error (Regla#1.1)-> linea: "+identificador.getNumLinea()+  " -> Variable {"+simbolo.getIdentificador()+"} ya declarada, en la linea: "+simbolo.getNumLineaDeclare() + " columna: "+simbolo.getNumColumnDeclare());
						error_count++
					;}
				}
				//System.out.println("**Linea: "+simbolo.getNumLineaDeclare()+"-> column: "+simbolo.getNumColumnDeclare()+"-> symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador());
        	}
    	}
	}

	//Regla 1, validar decaraciones repetidas de funciones
	public void SemanticaValidarDeclaracionTipoFuntions(NodoIdentificador identificador){
		if( identificador != null ){
			//System.out.println("Var: " + identificador.getNombre() + " amb: " + ambito + " line: " + identificador.getNumLineaDeclare() + " col: "+identificador.getNumColumnDeclare());
			RegistroSimbolo simbolo = ts.BuscarSimboloIsFunction(identificador.getNombre());
				if( simbolo.getNumLineaDeclare() + simbolo.getNumColumnDeclare() != identificador.getNumLinea() + identificador.getNumColumn()){
					System.out.println("#Error (Regla#1.2)-> linea: "+identificador.getNumLinea()+  " -> Funcion {"+simbolo.getIdentificador()+"} ya declarada, en la linea: "+simbolo.getNumLineaDeclare() + " columna: "+simbolo.getNumColumnDeclare());
					error_count++;
				}
			//System.out.println("**Linea: "+simbolo.getNumLineaDeclare()+"-> column: "+simbolo.getNumColumnDeclare()+"-> symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador());
        }
	}

	//regla 2, Validar que las variables existen
	public void SemanticaValidarUsoDeVariables(NodoIdentificador identificador){
		if( identificador != null ){
			//System.out.println("\n\n");
			//System.out.println("Validando => Var: " + identificador.getNombre() + " amb: " + ambito + " line: " + identificador.getNumLineaDeclare() + " col: "+identificador.getNumColumnDeclare());
			//System.out.println("Validando => Var: " + identificador.getNombre() + " amb: " + identificador.getAmbito() + " line: " + identificador.getNumLineaDeclare() + " col: "+identificador.getNumColumnDeclare());
			RegistroSimbolo simbolo = ts.BuscarSimbolo(identificador.getNombre(), identificador.getAmbito());
			if(simbolo == null){
				System.out.println("#Error (Regla#2)-> linea: "+identificador.getNumLinea()+  " -> Variable {"+identificador.getNombre()+"} no ha sido declarada");
				error_count++;
			}
			else
			if( simbolo.getNumLineaDeclare() > identificador.getNumLinea() || (simbolo.getNumLineaDeclare() == identificador.getNumLinea() && simbolo.getNumColumnDeclare() > identificador.getNumColumn() ))
			{	
				if( simbolo.getAmbito() == TablaSimbolos.conts_ambito_global && ts.EstoyDentroDeUnaFuncion(ts.BuscarSimbolo(identificador.getAmbito()))){
					//falsa alarma, tengo la variable declarada en el main, y la uso en una funcion
					//verificar tipo de variable, normal o array
					verificarUsoTipoVar(identificador, simbolo);
				}
				else{
					System.out.println("#Error (Regla#2)-> linea: "+identificador.getNumLinea()+" -> Variable {"+identificador.getNombre()+"} debe ser declarada antes de ser usada, si existe pero mas adelante en: linea: "+ simbolo.getNumLineaDeclare()+" columna: "+simbolo.getNumColumnDeclare());
					error_count++;
				}
			}
			else{
				verificarUsoTipoVar(identificador, simbolo);
				//verificar tipo de variable, normal o array
			}
		}
	}
	
	//Regla 3.1
	public void verificarUsoTipoVar(NodoIdentificador identificador, RegistroSimbolo simbolo){
		if( simbolo.getTipeSymbol() == tipoSymbol.ARRAY ){
			if (this.is_array == false){
				System.out.println(identificador.getAmbito() + " - " + simbolo.getAmbito() + " " + this.is_array);
				System.out.println("#Error (Regla#3.1)-> linea: "+identificador.getNumLinea()+" -> Variable {"+identificador.getNombre()+"} se usa de forma indebida, fue declarada como array");
				error_count++;
			}
			else
				verificarInicializacionVar(identificador, simbolo);
		}
		else{
			if( simbolo.getTipeSymbol() == tipoSymbol.VAR ){
				if (this.is_array == true){
					System.out.println("#Error (Regla#3.1)-> linea: "+identificador.getNumLinea()+" -> Variable {"+identificador.getNombre()+"} se usa de forma indebida, fue declarada como variable");
					error_count++;
				}
				else
					verificarInicializacionVar(identificador, simbolo);
			}
			else{
				//este error no deberia darse
				System.out.println("#Error (Regla#3.1)-> linea: "+identificador.getNumLinea()+" -> identificador {"+identificador.getNombre()+"} no se reconoce como variable o array");
				error_count++;
			}
		}
	}

	//Regla 3.2
	public void verificarInicializacionVar(NodoIdentificador identificador, RegistroSimbolo simbolo){
		
		if( ts.ResolverPadresMinimo(simbolo, ts.BuscarSimbolo(identificador.getAmbito()) ) ){
			if( simbolo.getNumLineaInitialize() > identificador.getNumLinea() || (simbolo.getNumLineaInitialize() == identificador.getNumLinea() && simbolo.getNumColumnInitialize() > identificador.getNumColumn() ))
			{	
				System.out.println("#Warning (Regla#3.2)-> linea: "+identificador.getNumLinea()+  " -> Variable {"+simbolo.getIdentificador()+"} debe ser inicializada antes de su uso");
				warning_count++;
			}
		}
	}
 
    //Regla 5.1, validacion de return 
    public void SemanticaReturnFuncionNoExist(NodoFunction funcion){
            
        System.out.println("#Error (Regla#5.1)-> linea: "+funcion.getNumLinea()+  " -> funcion {"+funcion.getIdentificador().getNombre()+"} no ha encontrado un return");   
        error_count++;
        
    }
    //Regla 5.2, validacion de return 
    public void SemanticaReturnFuncionInvalid(NodoReturn nodo, boolean retornar_valor){
            
        System.out.print("# (Regla#5.2)-> linea: "+nodo.getNumLinea()+  " -> return invalido para la funcion, ");   
        if( retornar_valor==true )
        	System.out.println(" **debe retornar un valor**");
       	else
       		System.out.println(" **debe ser vacia**");
       		
        error_count++;
        
    }
		
	//Regla 4, Ciclo FOR
    public void SemanticaCicloFor(NodoIdentificador identificador,String parte_for){
        if(identificador != null){
            RegistroSimbolo simbolo = ts.BuscarSimbolo(identificador.getNombre(), ambito);
            if( simbolo != null ){
                if(num_uso == 0 && parte_for == "INICIALIZACION"){

            		//System.out.println("La variable del for es: " + identificador.getNombre() + " ambito: " +ambito + "-" + identificador.getAmbito() +  " linea: " +identificador.getNumLineaDeclare());
            		//System.out.println(simbolo);
            		variable_for = simbolo.getIdentificador();
            		linea_for = identificador.getNumLinea();
            	}
            	if(parte_for == "CONDICION" && variable_for == simbolo.getIdentificador())
            		num_uso++;
            	if(parte_for == "INCREMENTO" && variable_for == simbolo.getIdentificador())
            		num_uso_inc++;
        	}
        }
	}

	//Regla 4, Validacion del Ciclo FOR
	public void SemanticaCicloForValidar(){ 
    	if(num_uso_inc < 2 || num_uso < 1){
    		System.out.println("#Warning (Regla#4)-> linea: "+linea_for+" -> Variable {"+variable_for+"} revisar parametros del for");
    		warning_count++;	
    	}
    	num_uso_inc = 0;
    	num_uso = 0;
    	variable_for = null;
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
	}

    public void SemanticaValidarAsignacion(NodoBase identificador,NodoBase expresion){
		tipoDato tipoI = null;
		tipoDato tipoD;
		if (identificador instanceof NodoIdentificador){
			RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoIdentificador)identificador).getNombre(), ambito);
			tipoI =  simbolo.getTipo();
		}else if (identificador instanceof NodoArray){
			RegistroSimbolo simbolo = ts.BuscarSimbolo(((NodoArray)identificador).getIdentificador().getNombre(), ambito);
			tipoI =  simbolo.getTipo();
		}	
		tipoD = ((NodoLogico)expresion).getTipoDato();

		if (tipoI != tipoD){
			System.out.println("ERROR DE ASIGNACION, LA EXPRESION NO CORRESPONDE CON LA ASIGNACION");
		}
	}

}
