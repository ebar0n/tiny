package ast;

public class Util {
	
	static int sangria = 0;
	//Imprimo en modo texto con sangrias el AST
	public static void imprimirAST(NodoBase raiz){
		sangria+=2;
		while (raiz != null) {
		    printSpaces();

		    if (raiz instanceof NodoBloque){
		    	NodoBloque nodo = (NodoBloque)raiz;
		    	System.out.println("Bloque Unico ");
		    	imprimirAST(nodo.getExpression());
		    }
		    else if (raiz instanceof NodoFunction){	
		    	NodoFunction nodo = (NodoFunction)raiz;
		    	System.out.println("Funcion "+nodo.getTipo());
		    	imprimirAST(nodo.getDeclaracion());
		    	imprimirAST(nodo.getExpression());
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
		    			imprimirNodo(nodov.getIdentificador());
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
		    			imprimirNodo(nodoa.getIdentificador(), verbose  + " <- Vector");
		    			if(nodoa.getPos() != null){
		    				printSpaces();
		    				System.out.println("**Buscando(");
		    				imprimirAST(nodoa.getPos());
		    				printSpaces();
		    				System.out.println(")**");
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

		    	NodoArgList nodoA = (NodoArgList)raiz;

		    	if (nodoA != null){
		    		System.out.println("Argumento tipo: "+nodoA.getTipo());
		    		printSpaces();
		    		imprimirNodo(nodoA.getIdentificador());
		    		if(nodoA.getArgumento()!=null)
		    			imprimirAST(nodoA.getArgumento());
		    	}
		    	
		    }
			    else if (raiz instanceof  NodoIf){
		    	System.out.println("If");
		    	printSpaces();
		    	System.out.println("**Prueba IF**");
		    	imprimirAST(((NodoIf)raiz).getPrueba());
		    	printSpaces();
		    	System.out.println("**Then IF**");
		    	imprimirAST(((NodoIf)raiz).getParteThen());
		    	if(((NodoIf)raiz).getParteElse()!=null){
		    		printSpaces();
		    		System.out.println("**Else IF**");
		    		imprimirAST(((NodoIf)raiz).getParteElse());
		    	}
		    }
		    else if (raiz instanceof  NodoRepeat){
		    	System.out.println("Repeat");
		    	printSpaces();
		    	System.out.println("**Cuerpo REPEAT**");
		    	imprimirAST(((NodoRepeat)raiz).getCuerpo());
		    	printSpaces();
		    	System.out.println("**Prueba REPEAT**");
		    	imprimirAST(((NodoRepeat)raiz).getPrueba());
		    }
		    else if (raiz instanceof  NodoAsignacion){
		    	System.out.println("Asignacion:");
		    	sangria+=2;
		    	printSpaces();
		    	System.out.println("Parte izquierda:");
		    	imprimirAST(((NodoAsignacion)raiz).getId());
		    	printSpaces();
		    	System.out.println("Parte Derecha:");
		    	imprimirAST(((NodoAsignacion)raiz).getExpresion());
		    	sangria-=2;
		    }
		    else if (raiz instanceof  NodoLeer){
		    	System.out.println("Lectura: ");
		    	imprimirAST(((NodoLeer)raiz).getIdentificador());
		    }
		    else if (raiz instanceof  NodoEscribir){
		    	System.out.println("Escribir");
		    	imprimirAST(((NodoEscribir)raiz).getExpresion());
		    }
		    else if (raiz instanceof NodoValor){
		    	System.out.println("Valor");	
		    	printSpaces();
		    	imprimirNodo(raiz);
		    }
		    else if (raiz instanceof NodoIdentificador ){
		    	System.out.println("Uso variable");	
		    	printSpaces();
		    	imprimirNodo(raiz);
		    }
		    else if (raiz instanceof NodoOperacion){
		    	imprimirNodo(raiz);
		    	printSpaces();
		    	System.out.println("**Expr Izquierda Operacion**");
		    	imprimirAST(((NodoOperacion)raiz).getOpIzquierdo());
		    	printSpaces();
		    	System.out.println("**Expr Derecha Operacion**");		    	
		    	imprimirAST(((NodoOperacion)raiz).getOpDerecho());
		    }
		    else if (raiz instanceof NodoLogico){
		    	System.out.println("Operacion: ");
		    	NodoLogico logico = (NodoLogico)raiz;
		    	NodoBase nodo = null;
		    	sangria+=2;
		    	if (nodo != null){
		    		printSpaces();
			    	System.out.println("Operacion que retorna un factor");
		    		imprimirAST(nodo);
		    	}
		    	else{
		    		printSpaces();
		    		System.out.println("Operacion logica");
			    	sangria+=2;
		    		printSpaces();
		    		System.out.println("**Expr Izquierda Operacion**");
			    	imprimirAST(logico.getOpIzquierdo());
			    	printSpaces();
			    	System.out.println("**Expr Derecha Operacion**");	
			    	imprimirAST(logico.getOpDerecho());
			    	sangria-=2;
			    }
		    	sangria-=2;
		    }
		    else if (raiz instanceof NodoCallFunction){
		    	System.out.println("Llamada a funcion: ");
		    	imprimirNodo(((NodoCallFunction)raiz).getIdentificador());
		    	printSpaces();
		    	if (((NodoCallFunction)raiz).getVariables()!=null){
		    		System.out.println(" Con parametos ->");
		    		NodoParamFunction var = (NodoParamFunction)((NodoCallFunction)raiz).getVariables(); 
		    		while(var!=null){
		    			imprimirAST(var.getExpresion());
		    			var = (NodoParamFunction)var.getSiguiente();
		    		}
		    	}
		    	else{
		    		System.out.println(" Sin parametos");
		    	}
		    }
		    else if (raiz instanceof NodoReturn ){
		    	System.out.println("Return");	
		    	imprimirAST(((NodoReturn)raiz).getExpresion());
		    }
		    else if (raiz instanceof NodoFor ){
		    	System.out.println("Instruccion for");	
		    	sangria+=2;
		    	printSpaces();
		    	System.out.println("Inicializacion (asignacion)");
		    	imprimirAST(((NodoFor)raiz).getInicializacion());
		    	printSpaces();
		    	System.out.println("Condicion (logica esprexion)");
		    	imprimirAST(((NodoFor)raiz).getCondicion());
		    	printSpaces();
		    	System.out.println("Incremento (asignacion)");
		    	imprimirAST(((NodoFor)raiz).getIncremento());
		    	printSpaces();
		    	System.out.println("Cuerpo");
		    	imprimirAST(((NodoFor)raiz).getSentencia());
		    	sangria-=2;
		    }
		    else System.out.println("Tipo de nodo desconocido " + raiz);
		    
		    raiz = raiz.getHermanoDerecha();
		}
		sangria-=2;
	}

	/* Imprime espacios con sangria */
	static void printSpaces()
	{ 
		int i;
	  	for (i=0;i<sangria;i++)
		  	System.out.print(" ");
	}

	/* Imprime informacion de los nodos */
	static void imprimirNodo( NodoBase raiz , String ... extras)
	{
		if(	raiz instanceof NodoRepeat
			||	raiz instanceof NodoLeer
			||	raiz instanceof NodoEscribir  ){
			System.out.println("palabra reservada: "+ raiz.getClass().getName());
		}
		
		if(	raiz instanceof NodoAsignacion )
			System.out.println(":=");
		
		if(	raiz instanceof NodoOperacion ){
			tipoOp sel=((NodoOperacion) raiz).getOperacion();

			if(sel==tipoOp.menor)
				System.out.println("<"); 
			else if(sel==tipoOp.igual)
				System.out.println("=");
			else if(sel==tipoOp.mas)
				System.out.println("+");
			else if(sel==tipoOp.menos)
				System.out.println("-");
			else if(sel==tipoOp.por)
				System.out.println("*");
			else if(sel==tipoOp.entre)
				System.out.println("/");
			else if(sel==tipoOp.and)
				System.out.println("and");
			else if(sel==tipoOp.or)
				System.out.println("or");
			else if(sel==tipoOp.mayori)
				System.out.println(">=");
			else if(sel==tipoOp.menori)
				System.out.println("<=");
			else if(sel==tipoOp.mayor)
				System.out.println(">");
			else if(sel==tipoOp.diferente)
				System.out.println("!=");
		}

		if(	raiz instanceof NodoValor ){
			if (((NodoValor)raiz).getValor()!=null)
				System.out.println("NUM, val= "+ ((NodoValor)raiz).getValor());
			else
				System.out.println("NUM, val= "+ ((NodoValor)raiz).getValorBoolean());
		}

		if(	raiz instanceof NodoIdentificador ){
			sangria+=2;
			printSpaces();
			sangria-=2;
			String extra = "";
			for(String value:extras){
            	extra += value;
        	}
			System.out.println("ID, nombre= "+ ((NodoIdentificador)raiz).getNombre() + " " + extra);
		}
	}
}
