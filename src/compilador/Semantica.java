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
                //SemanticaValidarUntil(((NodoRepeat)raiz).getPrueba());
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
                ciclo_for = 1;
		    	ambito = ((NodoFor)raiz).getAmbito();
		    	Parte_for = "INICIALIZACION";
		    	RecorrerArbol(((NodoFor)raiz).getInicializacion());
                //CONDICION LOGICA EXPRESION
                Parte_for = "CONDICION";
		    	RecorrerArbol(((NodoFor)raiz).getCondicion());
		    	//INCREMENTO ASIGNACION
		    	
		    	Parte_for = "INCREMENTO";
		    	RecorrerArbol(((NodoFor)raiz).getIncremento());
		    	//CUERPO FOR
		    	SemanticaCicloForValidar();
		    	Parte_for = "SENTENCIA";
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
   
   	/*
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
                    //System.out.println("NODOIZQUIERDO");
                    nodo = (NodoBase) nodo_logico.getOpIzquierdo();
                }
                else if(nodo_logico.getOpDerecho()!=null){
                    //System.out.println("NODODERECHO");
                    nodo = (NodoBase) nodo_logico.getOpDerecho();
                }           
            }
            
            if(nodo instanceof NodoOperacion){
                    //System.out.println("NODOOPERACION");
                    NodoOperacion nodo_operacion = (NodoOperacion) nodo;
                   
            }
            
            if(nodo instanceof NodoIdentificador){
                //System.out.println("NODOIDENTIFICADOR");
                NodoIdentificador nodo_identificador = (NodoIdentificador) nodo;
                RegistroSimbolo simbolo = ts.BuscarSimbolo(nodo_identificador.getNombre());
                if(simbolo.getTipo().compareTo(tipoDato.BOOLEAN)!=0){
                 System.out.println("N°"+error_count+" -> linea: "+nodo_identificador.getNumLinea()+  " -> Variable {"+nodo_identificador.getNombre()+"} no es parte de un expression valida para el ciclo repeat");   
                 error_count++;
                } 
                nodo=null;
            }
            
            if(nodo instanceof NodoValor){
                //System.out.println("NODOVALOR");
                NodoValor nodo_valor = (NodoValor) nodo;
                if(nodo_valor.getValorBoolean()==null){
                 System.out.println("N°"+error_count+" -> linea: "+nodo_valor.getNumLinea()+  " -> constante no es parte de un expression valida para el ciclo repeat");   
                 error_count++;
                }
                nodo=null;
            }
            
            if(nodo instanceof NodoCallFunction){
                //System.out.println("NODOFUNCION");
                NodoCallFunction nodo_funcion = (NodoCallFunction) nodo;
                RegistroSimbolo simbolo = ts.BuscarSimbolo(nodo_funcion.getIdentificador().getNombre());
                if(simbolo.getTipo().compareTo(tipoDato.BOOLEAN)!=0){
                 System.out.println("N°"+error_count+" -> linea: "+nodo_funcion.getNumLinea()+  " -> Variable {"+nodo_funcion.getIdentificador().getNombre()+"} no es parte de un expression valida para el ciclo repeat");   
                 error_count++;
                }
                nodo=null;
            }
            
        }while(nodo!=null);
    }*/
    
    //Regla 5.1, validacion de return 
    public void SemanticaReturnFuncionNoExist(NodoFunction funcion){
            
        System.out.println("N°"+error_count+" (Regla#5.1)-> linea: "+funcion.getNumLinea()+  " -> funcion {"+funcion.getIdentificador().getNombre()+"} no ha encontrado un return");   
        error_count++;
        
    }
    //Regla 5.2, validacion de return 
    public void SemanticaReturnFuncionInvalid(NodoReturn nodo, boolean retornar_valor){
            
        System.out.print("N°"+error_count+" (Regla#5.2)-> linea: "+nodo.getNumLinea()+  " -> return invalido para la funcion, ");   
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
					System.out.println("La variable del for es: " + identificador.getNombre() + " ambito: " +ambito + "-" + identificador.getAmbito() +  " linea: " +identificador.getNumLinea());
            		//System.out.println(simbolo);
            		variable_for = simbolo.getIdentificador();
            		linea_for = identificador.getNumLinea();
            	}

            	if(parte_for == "CONDICION" && variable_for == simbolo.getIdentificador())
            		num_uso++;
            	//System.out.println("CONDICION for es: " + identificador.getNombre() + "num usu" + num_uso);
            	if(parte_for == "INCREMENTO" && variable_for == simbolo.getIdentificador())
            		num_uso_inc++;
            	//System.out.println("INCREMENTO for es: " + identificador.getNombre() + " num incre "+num_uso_inc);
            	if(parte_for == "SENTENCIA"){
            		ciclo_for = 0;
            	}
        	}
        }
	}

	//Regla 4, Validacion del Ciclo FOR
	public void SemanticaCicloForValidar(){ 
    	if(num_uso_inc < 2 || num_uso < 1){
    		//System.out.println("validacion " + "nun uso  "+num_uso + " incre " + num_uso_inc);
    		System.out.println("N°"+warning_count+" (Regla#4)-> linea: "+linea_for+" -> Variable {"+variable_for+"} Warning revisar parametros del for");
    		warning_count++;	
    	}
    	num_uso_inc = 0;
    	num_uso = 0;
    	variable_for = null;
    }
}