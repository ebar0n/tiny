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
		    		System.out.println("Declarar variable de tipo "+nodov.getTipo());
		    	else
		    		System.out.println("Declarar variable de tipo "+nodoa.getTipo());
		    	
		    	NodoBase nodo = null;

		    	while (nodov!=null || nodoa!=null) {
		    		
		    		if (nodov != null){
		    			imprimirNodo(nodov.getId());
		    			nodo = nodov.getNodo();
		    		}
		    		else if (nodoa != null){
		    			imprimirNodo(nodoa.getId(), "Tam: "+nodoa.getTam() + " <- Vector");
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
		    	
		    }
		    else if (raiz instanceof  NodoIf)
		    	System.out.println("If");
		    else if (raiz instanceof  NodoRepeat)
		    	System.out.println("Repeat");
		    
		    else if (raiz instanceof  NodoAsignacion)
		    	System.out.println("Asignacion a: "+((NodoAsignacion)raiz).getIdentificador().getNombre());

		    else if (raiz instanceof  NodoLeer)  
		    	System.out.println("Lectura: "+((NodoLeer)raiz).getIdentificador());

		    else if (raiz instanceof  NodoEscribir)
		    	System.out.println("Escribir");
		    
		    else if (raiz instanceof NodoOperacion
		    		|| raiz instanceof NodoValor
		    		|| raiz instanceof NodoIdentificador )
		    	imprimirNodo(raiz);
		    else System.out.println("Tipo de nodo desconocido");;
		    
		    /* Hago el recorrido recursivo */
		    if (raiz instanceof  NodoIf){
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
		    	printSpaces();
		    	System.out.println("**Cuerpo REPEAT**");
		    	imprimirAST(((NodoRepeat)raiz).getCuerpo());
		    	printSpaces();
		    	System.out.println("**Prueba REPEAT**");
		    	imprimirAST(((NodoRepeat)raiz).getPrueba());
		    }
		    else if (raiz instanceof  NodoAsignacion)
		    	imprimirAST(((NodoAsignacion)raiz).getExpresion());
		    else if (raiz instanceof  NodoEscribir)
		    	imprimirAST(((NodoEscribir)raiz).getExpresion());
		    else if (raiz instanceof NodoOperacion){
		    	printSpaces();
		    	System.out.println("**Expr Izquierda Operacion**");
		    	imprimirAST(((NodoOperacion)raiz).getOpIzquierdo());
		    	printSpaces();
		    	System.out.println("**Expr Derecha Operacion**");		    	
		    	imprimirAST(((NodoOperacion)raiz).getOpDerecho());
		    }
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
			if(sel==tipoOp.igual)
				System.out.println("=");
			if(sel==tipoOp.mas)
				System.out.println("+");
			if(sel==tipoOp.menos)
				System.out.println("-");
			if(sel==tipoOp.por)
				System.out.println("*");
			if(sel==tipoOp.entre)
				System.out.println("/");
		}

		if(	raiz instanceof NodoValor ){
			System.out.println("NUM, val= "+ ((NodoValor)raiz).getValor());
		}

		if(	raiz instanceof NodoIdentificador ){
			String extra = "";
			for(String value:extras){
            	extra += value;
        	}
			System.out.println("ID, nombre= "+ ((NodoIdentificador)raiz).getNombre() + " " + extra);
		}
	}
}
