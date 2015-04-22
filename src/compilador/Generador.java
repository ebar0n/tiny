package compilador;

import ast.*;

public class Generador {
	/* Ilustracion de la disposicion de la memoria en
	 * este ambiente de ejecucion para el lenguaje Tiny
	 *
	 * |t1	|<- mp (Maxima posicion de memoria de la TM
	 * |t1	|<- desplazamientoTmp (tope actual)
	 * |free|
	 * |free|
	 * |...	|
	 * |x	|
	 * |y	|<- gp
	 * 
	 * */
	
	
	
	/* desplazamientoTmp es una variable inicializada en 0
	 * y empleada como el desplazamiento de la siguiente localidad
	 * temporal disponible desde la parte superior o tope de la memoria
	 * (la que apunta el registro MP).
	 * 
	 * - Se decrementa (desplazamientoTmp--) despues de cada almacenamiento y
	 * 
	 * - Se incrementa (desplazamientoTmp++) despues de cada eliminacion/carga en 
	 *   otra variable de un valor de la pila.
	 * 
	 * Pudiendose ver como el apuntador hacia el tope de la pila temporal
	 * y las llamadas a la funcion emitirRM corresponden a una inserccion 
	 * y extraccion de esta pila
	 */
	private static int desplazamientoTmp = 0;
	private static TablaSimbolos tablaSimbolos = null;
	private static boolean debug=false;
    private static int registroBloque;

	public static void setTablaSimbolos(TablaSimbolos tabla){
		tablaSimbolos = tabla;
	}
	
	public static void generarCodigoObjeto(NodoBase raiz, boolean debug){
		Generador.debug = debug;
		if(debug) {
			System.out.println("*");
			System.out.println("*");
			System.out.println("* ------ CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------");
			System.out.println("*");
			System.out.println("*");
		}
		generarPreludioEstandar();
		generar(raiz);
		/*Genero el codigo de finalizacion de ejecucion del codigo*/   
		UtGen.emitirComentario("Fin de la ejecucion.");
		UtGen.emitirRO("HALT", 0, 0, 0, "");
		if(debug) {
			System.out.println("*");
			System.out.println("*");
			System.out.println("* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------");
		}

	}
	
	//Funcion principal de generacion de codigo
	//prerequisito: Fijar la tabla de simbolos antes de generar el codigo objeto 
	private static void generar(NodoBase nodo){
	if(tablaSimbolos!=null && nodo!= null){
		if (nodo instanceof NodoBloque) {
			generarBloque(nodo);
		}else if (nodo instanceof NodoFunction) {
			generarFuncion(nodo);
		}else if (nodo instanceof  NodoIf){
			generarIf(nodo);
		}else if (nodo instanceof  NodoRepeat){
			generarRepeat(nodo);
		}else if (nodo instanceof  NodoAsignacion){
			generarAsignacion(nodo);
		}else if (nodo instanceof  NodoVariable){
			generarVariable(nodo);
		}else if (nodo instanceof  NodoLogico){
			generarLogico(nodo);
		}else if (nodo instanceof  NodoEscribir){
			generarEscribir(nodo);
		}else if (nodo instanceof NodoValor){
			generarValor(nodo);
		}else if (nodo instanceof NodoFor){
			generarFor(nodo);	
		}else if (nodo instanceof NodoArgList){
			generarArgList(nodo);	
		}else if (nodo instanceof NodoIdentificador){
			generarIdentificador(nodo);
		}else if (nodo instanceof NodoArray){
			generarArray(nodo);
		}else if (nodo instanceof NodoCallFunction){
			generarCallFunction(nodo);			
		}else if (nodo instanceof NodoParamFunction){
			generarParamFunctionelse(nodo);			
		}else if (nodo instanceof NodoOperacion){
			generarOperacion(nodo);
        }else if (nodo instanceof NodoBloque){
            generarBloque(nodo);
        }else if (nodo instanceof NodoReturn){
            generarReturn(nodo);
		}else{
			System.out.println("BUG: Tipo de nodo a generar desconocido" + nodo);
		}
		/*Si el hijo de extrema izquierda tiene hermano a la derecha lo genero tambien*/
		if(nodo.TieneHermano())
			generar(nodo.getHermanoDerecha());
	}
}

	private static void generarBloque(NodoBase nodo) {
		NodoBloque nodob = (NodoBloque) nodo;
		if( nodob.getAmbito().equals(TablaSimbolos.conts_ambito_global) ){
			//restauramos
			UtGen.emitirComentario("Bloque principal");
			int localidadActual = UtGen.emitirSalto(0);
			UtGen.cargarRespaldo(registroBloque);
			UtGen.emitirRM_Abs("LDA", UtGen.PC, localidadActual, "bloque unico: jmp a bloque principal");
			UtGen.restaurarRespaldo();	
		} else {
			UtGen.emitirComentario("bloque normal");			
		}
		generar(nodob.getExpression());
		
        
	}

	private static void generarFuncion(NodoBase nodo) {
		NodoFunction nodof = (NodoFunction) nodo;
		RegistroSimbolo simbolo = tablaSimbolos.BuscarSimboloIsFunction(nodof.getIdentificador().getNombre());
		         
                if( simbolo != null ){
                    
			int localidadActual = UtGen.emitirSalto(0);
                        //System.out.println("direccion actual: "+localidadActual);
			simbolo.setDireccionCodigo( localidadActual );
                        //System.out.println("------>> direccion de la funcion: "+simbolo.getDireccionCodigo());
			generar(nodof.getDeclaracion());
			generar(nodof.getExpression());   
		}             
	}

	private static void generarVariable(NodoBase nodo) {
		NodoVariable nodov = (NodoVariable) nodo;
	}	

	private static void generarArgList(NodoBase nodo) {
		NodoArgList nodov = (NodoArgList) nodo;
        int direccion;

        if(nodov.getArgumento()!=null)
            generarArgList(nodov.getArgumento());
        
        direccion = tablaSimbolos.getDireccion(nodov.getIdentificador().getNombre(),nodov.getAmbito());
        pilaPop();
        //UtGen.emitirRM("LD", UtGen.AC,desplazamientoTmp--, UtGen.MP, "cargo el registro AC con el valor de la pila");
        UtGen.emitirRM("ST", UtGen.L1, direccion, UtGen.GP, "Guardo en la direccion "+direccion+" "+nodov.getIdentificador().getNombre());
                
	}	

	private static void generarLogico(NodoBase nodo) {
		NodoLogico nodol = (NodoLogico) nodo;
		if(nodol != null) {
			if(nodol.getOpIzquierdo() != null)
				generar(nodol.getOpIzquierdo());
			if(nodol.getOpDerecho() != null) 
				generar(nodol.getOpDerecho());
		}
	}

	private static void generarFor(NodoBase nodo) {
		NodoFor nodof = (NodoFor) nodo;
		int localidadSaltoInicio, localidadActual, localidadBeginCondicion;
		if(UtGen.debug) UtGen.emitirComentario("-> for");
		generar(nodof.getInicializacion());

		localidadSaltoInicio = UtGen.emitirSalto(0);
		UtGen.emitirComentario("for condicion: el salto hacia la condicion del for debe estar aqui");

		generar(nodof.getIncremento());
		generar(nodof.getSentencia());

		// localidadActual = UtGen.emitirSalto(0);
		// UtGen.cargarRespaldo(localidadSaltoInicio);
		// UtGen.emitirRM("LDA", UtGen.PC, localidadActual, 0, "jmp a inicio del for");
		// UtGen.restaurarRespaldo();

		generar(nodof.getCondicion());
		UtGen.emitirRM_Abs("JNE", UtGen.AC, localidadSaltoInicio, "for: jmp hacia el inicio del cuerpo");
		
		if (UtGen.debug)
			UtGen.emitirComentario("<- for");		
	}	

	private static void generarCallFunction(NodoBase nodo) {
		NodoCallFunction nodocf = (NodoCallFunction) nodo;
		
		//UtGen.emitirRM("LDA", UtGen.L1, 0 , UtGen.PC, "carga la linea donde me encuentro, llamada a funcion");
		//pilaPush();
		
		//Cargar variables en la pila
		generar(nodocf.getVariables());
		
		//Actualizando linea de salto de retorno en la pila, necesito la tercera
		int localidadSaltoInicio = UtGen.emitirSalto(0)+3;
		//haciendo respaldo de direccion
		//UtGen.emitirRM("LDA", UtGen.L3, 0 , UtGen.MP, "cargando ubicacion de la pila, para la llamada del retunn");
		
		UtGen.emitirRM("LDC", UtGen.L1, localidadSaltoInicio, 0, "Cargando verdareda linea de retorno");
		UtGen.emitirRM("ST", UtGen.L1, 0 , UtGen.L3, "Paso ubicacion a la pila");

		//Aqui falta validar para cuando aun no se ha declarado la funcion
		RegistroSimbolo simbolo =  tablaSimbolos.BuscarSimboloIsFunction(nodocf.getIdentificador().getNombre());
		UtGen.emitirRM("LDC", UtGen.PC, simbolo.getDireccionCodigo(), 0, "carga salto  "+simbolo.getDireccionCodigo());
		
	}

	private static void generarParamFunctionelse(NodoBase nodo){
		generar( ((NodoParamFunction)nodo).getExpresion() );
		UtGen.emitirRM("LDA", UtGen.L1, UtGen.AC, 0, " carga parametro en llamada a funcion");
		pilaPush();
		generar( ((NodoParamFunction)nodo).getSiguiente() );

	}
        
    private static void generarReturn(NodoBase nodo){
        NodoReturn nodo_return = (NodoReturn) nodo;
        
        if(nodo_return.getExpresion()!=null){
            generar(nodo_return.getExpresion());
 
 			//pilaPop();
            //UtGen.emitirRM("LDA", UtGen.L1, desplazamientoTmp--, UtGen.MP, "Saco el salto de la linea");
            //UtGen.emitirRO("SUB", UtGen.MP, UtGen.MP, UtGen.L2, "op: subir pila");	
            UtGen.emitirRM("ST", UtGen.L1, 0, UtGen.AC, "Cargo variable que genero el return en temporales");
            pilaPush();
            UtGen.emitirRM("LDA", UtGen.PC, 0, UtGen.L3, "Regreso a donde fui llamado");
        }
        else{
        	//pilaPop();
            //UtGen.emitirRM("LDA", UtGen.L1, desplazamientoTmp--, UtGen.MP, "Saco el salto de la linea");
            UtGen.emitirRM("LDA", UtGen.PC, 0, UtGen.L3, "Regreso a donde fui llamado");
        }
    }

	private static void generarIf(NodoBase nodo){
    	NodoIf n = (NodoIf)nodo;
		int localidadSaltoElse,localidadSaltoEnd,localidadActual;
		if(UtGen.debug)	UtGen.emitirComentario("-> if");
		/*Genero el codigo para la parte de prueba del IF*/
		generar(n.getPrueba());
		localidadSaltoElse = UtGen.emitirSalto(1);
		UtGen.emitirComentario("If: el salto hacia el else debe estar aqui");
		/*Genero la parte THEN*/
		generar(n.getParteThen());
		localidadSaltoEnd = UtGen.emitirSalto(1);
		UtGen.emitirComentario("If: el salto hacia el final debe estar aqui");
		localidadActual = UtGen.emitirSalto(0);
		UtGen.cargarRespaldo(localidadSaltoElse);
		UtGen.emitirRM_Abs("JEQ", UtGen.AC, localidadActual, "if: jmp hacia else");
		UtGen.restaurarRespaldo();
		/*Genero la parte ELSE*/
		if(n.getParteElse()!=null){
			generar(n.getParteElse());
    	}
		//igualmente debo generar la sentencia que reserve en
		//localidadSaltoEnd al finalizar la ejecucion de un true
		localidadActual = UtGen.emitirSalto(0);
		UtGen.cargarRespaldo(localidadSaltoEnd);
		UtGen.emitirRM_Abs("LDA", UtGen.PC, localidadActual, "if: jmp hacia el final");
		UtGen.restaurarRespaldo();			
		if(UtGen.debug)	UtGen.emitirComentario("<- if");
	}
	
	private static void generarRepeat(NodoBase nodo){
    	NodoRepeat n = (NodoRepeat)nodo;
		int localidadSaltoInicio;
		if(UtGen.debug)	UtGen.emitirComentario("-> repeat");
			localidadSaltoInicio = UtGen.emitirSalto(0);
			UtGen.emitirComentario("repeat: el salto hacia el final (luego del cuerpo) del repeat debe estar aqui");
			/* Genero el cuerpo del repeat */
			generar(n.getCuerpo());
			/* Genero el codigo de la prueba del repeat */
			generar(n.getPrueba());
			UtGen.emitirRM_Abs("JEQ", UtGen.AC, localidadSaltoInicio, "repeat: jmp hacia el inicio del cuerpo");
		if(UtGen.debug)	UtGen.emitirComentario("<- repeat");
	}
	
	private static void generarAsignacion(NodoBase nodo){
		NodoAsignacion n = (NodoAsignacion)nodo;
		int direccion;
		if(UtGen.debug)	UtGen.emitirComentario("-> asignacion");		
		/* Genero el codigo para la expresion a la derecha de la asignacion */
		generar(n.getExpresion());
		/* Ahora almaceno el valor resultante */
		
		//Aqui agregar soporte para vectores
		direccion = tablaSimbolos.getDireccion(n.getIdentificador().getNombre(),n.getAmbito());
		UtGen.emitirRM("ST", UtGen.AC, direccion, UtGen.GP, "asignacion: almaceno el valor para el id "+n.getIdentificador().getNombre());
		if(UtGen.debug)	UtGen.emitirComentario("<- asignacion");
	}
	
	private static void generarLeer(NodoBase nodo){
		NodoLeer n = (NodoLeer)nodo;
		int direccion;
		if(UtGen.debug)	UtGen.emitirComentario("-> leer");
		UtGen.emitirRO("IN", UtGen.AC, 0, 0, "leer: lee un valor entero ");
                NodoBase nodo_id = n.getIdentificador();
                //Auditat lectura para nodos id o vectores
		//direccion = tablaSimbolos.getDireccion();
		//UtGen.emitirRM("ST", UtGen.AC, direccion, UtGen.GP, "leer: almaceno el valor entero leido en el id "+n.getIdentificador());
		if(UtGen.debug)	UtGen.emitirComentario("<- leer");
	}
	
	private static void generarEscribir(NodoBase nodo){
		NodoEscribir n = (NodoEscribir)nodo;
		if(UtGen.debug)	UtGen.emitirComentario("-> escribir");
		/* Genero el codigo de la expresion que va a ser escrita en pantalla */
		generar(n.getExpresion());
		/* Ahora genero la salida */
		UtGen.emitirRO("OUT", UtGen.AC, 0, 0, "escribir: genero la salida de la expresion");
		if(UtGen.debug)	UtGen.emitirComentario("<- escribir");
	}
	
	private static void generarValor(NodoBase nodo){
    	NodoValor n = (NodoValor)nodo;
    	if(UtGen.debug)	UtGen.emitirComentario("-> constante "+n.getValorReal());
    	UtGen.emitirRM("LDC", UtGen.AC, n.getValorReal(), 0, "cargar constante: "+n.getValorRealStr() );
    	if(UtGen.debug)	UtGen.emitirComentario("<- constante");
	}
	
	private static void generarIdentificador(NodoBase nodo){
		NodoIdentificador n = (NodoIdentificador)nodo;
		int direccion;
		if(UtGen.debug)	UtGen.emitirComentario("-> identificador");
		direccion = tablaSimbolos.getDireccion(n.getNombre(),n.getAmbito());
		UtGen.emitirRM("LD", UtGen.AC, direccion, UtGen.GP, "cargar valor de identificador: "+n.getNombre());
		if(UtGen.debug)	UtGen.emitirComentario("<- identificador");
	}

	private static void generarArray(NodoBase nodo){
		NodoArray n = (NodoArray)nodo;
		int direccion;
		if(UtGen.debug)	UtGen.emitirComentario("-> vector");
		direccion = tablaSimbolos.getDireccion(((NodoIdentificador)n.getIdentificador()).getNombre());
		UtGen.emitirRO("ADD",UtGen.L3,UtGen.GP,UtGen.AC,"sumar desplazamiendo al registro L3");
		UtGen.emitirRM("LD", UtGen.AC, direccion,UtGen.GP, "cargar valor de identificador: "+((NodoIdentificador)n.getIdentificador()).getNombre());
		UtGen.emitirRM("LDC",UtGen.GP,0,0,"cargar constante 0 en el resgitro GP");
		if(UtGen.debug)	UtGen.emitirComentario("<- vector");
	}
	

	private static void generarOperacion(NodoBase nodo){
		NodoOperacion n = (NodoOperacion) nodo;
		if(UtGen.debug)	UtGen.emitirComentario("-> Operacion: " + n.getOperacion());
		
		generar(n.getOpIzquierdo());
		/* Almaceno en la pseudo pila de valor temporales el valor de la operacion izquierda */
		UtGen.emitirRM("LDA", UtGen.L1, UtGen.AC, 0, "Pasando operador izquierdo a la pila");
		pilaPush();

		/* Genero la expresion derecha de la operacion */
		generar(n.getOpDerecho());
		/* Ahora cargo/saco de la pila el valor izquierdo */
		pilaPop();
		UtGen.emitirRM("LDA", UtGen.AC1, 0,UtGen.L1,  "Pasando operador izquierdo de la pila a AC1");
		
		//UtGen.emitirRM("LD", UtGen.AC1, ++desplazamientoTmp, UtGen.MP, "op: pop o cargo de la pila el valor izquierdo en AC1");
		switch(n.getOperacion()){
			case	mas:	UtGen.emitirRO("ADD", UtGen.AC, UtGen.AC1, UtGen.AC, "op: +");		
							break;
			case	menos:	UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: -");
							break;
			case	por:	UtGen.emitirRO("MUL", UtGen.AC, UtGen.AC1, UtGen.AC, "op: *");
							break;
			case	entre:	UtGen.emitirRO("DIV", UtGen.AC, UtGen.AC1, UtGen.AC, "op: /");
							break;		
			case	menor:	UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: <");
							UtGen.emitirRM("JLT", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC<0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							//UtGen.emitirRM("LDC", UtGen.MP, 1, UtGen.AC, "Envio a la pila");
							break;
			case	igual:	UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: ==");
							UtGen.emitirRM("JEQ", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC==0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;
			case 	mayor:  UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: >");
							UtGen.emitirRM("JGT", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC>0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;
			case	menori:	UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: <=");
							UtGen.emitirRM("JLE", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC<0 || AC==0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;
			case	mayori:	UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: >=");
							UtGen.emitirRM("JGE", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC>0 || AC==0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;
			case	and:	
							break;
			case	or:
							break;
			case	diferente:
							UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: !=");
							UtGen.emitirRM("JNE", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC>0 || AC<0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;
			default:
							UtGen.emitirComentario("BUG: tipo de operacion desconocida");
		}
		if(UtGen.debug)	UtGen.emitirComentario("<- Operacion: " + n.getOperacion());
	}
        
	//TODO: enviar preludio a archivo de salida, obtener antes su nombre
	private static void generarPreludioEstandar(){
		UtGen.emitirComentario("Compilacion TINY para el codigo objeto TM");
		UtGen.emitirComentario("Archivo: "+ "NOMBRE_ARREGLAR");
		/*Genero inicializaciones del preludio estandar*/
		/*Todos los registros en tiny comienzan en cero*/
		UtGen.emitirComentario("Inicio Preludio estandar:");
		UtGen.emitirRM("LD", UtGen.MP, 0, UtGen.AC, "cargar la maxima direccion desde la localidad 0");
		UtGen.emitirRM("ST", UtGen.AC, 0, UtGen.AC, "limpio el registro de la localidad 0");
		UtGen.emitirRM("LDC", UtGen.L2, 1, 0, "carga constante, para usos de movimientos recursivos");
		registroBloque = UtGen.emitirSalto(1);
		UtGen.emitirComentario("Fin Preludio estandar:");
	} 

	
	public static void generarEjemplo(){
		generarPreludioEstandar();
		
		UtGen.emitirRM("LDA", UtGen.L1, UtGen.PC, 0, "carga la linea donde me encuentro, llamada a funcion");
		pilaPush();
		UtGen.emitirRO("IN", UtGen.L1, 0, 0, "leer: lee un valor entero ");
		pilaPush();
		UtGen.emitirRM("LDC", UtGen.PC, 6, 0, "carga salto");
		UtGen.emitirComentario("Fin de la ejecucion.");
		UtGen.emitirRO("HALT", 0, 0, 0, "");

	} 

	//El registro L1 se usa para obtener los elementos ingresados en la pila
	private static void pilaPush(){
		UtGen.emitirRO("SUB", UtGen.MP, UtGen.MP, UtGen.L2, "op: subir pila");
		UtGen.emitirRM("ST", UtGen.L1, 0, UtGen.MP, "op: push en la pila tmp");
			
	}

	//El registro L1 se usa para obtener los elementos sacar en la pila
	private static void pilaPop(){
		UtGen.emitirRM("LD", UtGen.L1, 0, UtGen.MP, "op: pop o cargo de la pila el valor");
		UtGen.emitirRO("ADD", UtGen.MP, UtGen.MP, UtGen.L2, "op: bajar pila");
	}

}
