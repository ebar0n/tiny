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
    public static String conts_ambito_global = "MAIN";
    private static String conts_ambito_global_padre = "";
    private static String conts_ambito_functions = "MAIN_FUNCTIONS";

    /*Contadores*/
    private int if_ambito_cont = 1;
    private int for_ambito_cont = 1;
    private int repeat_ambito_cont = 1;

    public TablaSimbolos() {
        super();
        tabla = new HashMap<String, RegistroSimbolo>();
        direccion = 0;
    }

    public void cargarTabla(NodoBase raiz) {
        while (raiz != null) {
            /* Hago el recorrido recursivo */

            if (raiz instanceof NodoFunction) {
                ambito = conts_ambito_functions;
                ambito_padre = conts_ambito_global;
                nivel = 1;
                NodoFunction nodof = (NodoFunction) raiz;
                nodof.setAmbito(ambito);
                nodof.getIdentificador().setAmbito(ambito);
                RegistroSimbolo simboloFunction = new RegistroSimbolo(
                        nodof.getIdentificador().getNombre(),
                        nodof.getTipo(),
                        nodof.getSymbol(),
                        ambito,
                        ambito_padre,
                        nivel,
                        tipoSymbol.FUNCTION
                );
                Integer num_arg = 0;
                ambito_padre = ambito;
                ambito = nodof.getIdentificador().getNombre();
                if (nodof.getDeclaracion() != null) {
                    NodoArgList nodoA = (NodoArgList) nodof.getDeclaracion();
                    while (nodoA != null) {
                        nodoA.setAmbito(ambito);
                        InsertarSimbolo(new RegistroSimbolo(nodoA.getIdentificador().getNombre(), nodoA.getTipo(), nodoA.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.VAR));
                        simboloFunction.setTipoParametros(nodoA.getTipo());
                        simboloFunction.setIdParametros(nodoA.getIdentificador().getNombre());
                        nodoA = (NodoArgList) nodoA.getArgumento();
                        num_arg++;
                    }
                }
                simboloFunction.setNumParametros(num_arg);
                InsertarSimbolo((RegistroSimbolo) simboloFunction);
                NodoBase expresion = ((NodoFunction) raiz).getExpression();
                expresion.setAmbito(ambito);
                cargarTabla(expresion);
                ambito = conts_ambito_global;
                ambito_padre = conts_ambito_global_padre;
            }
            else
            if (raiz instanceof NodoBloque) {
                if (ambito == conts_ambito_global || (ambito==null && ambito_padre==null)) {
                    if (ambito == conts_ambito_global ){
                    	//Este simbolo tambien se agraga una sola vez
                    	InsertarSimbolo(new RegistroSimbolo(conts_ambito_functions, raiz.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.AMBITO));
                	}
                    ambito = conts_ambito_global;	
                	ambito_padre = conts_ambito_global_padre;
                    nivel = 1;
                    raiz.setAmbito(ambito);
                    
                    InsertarSimbolo(new RegistroSimbolo(conts_ambito_global, raiz
                    	.getSymbol(), ambito_padre, ambito_padre, nivel, tipoSymbol.AMBITO));

                }
                nivel++;
                cargarTabla(((NodoBloque) raiz).getExpression());
            }
            else
            if (raiz instanceof NodoVariable) {
                NodoVariable nodo = (NodoVariable) raiz;
                if (nodo.getTipo() != null) {
                    tipo = nodo.getTipo();
                }
                if (nodo.getIdentificador() != null) {
                    nodo.setAmbito(ambito);
                    nodo.getIdentificador().setAmbito(ambito);
                    InsertarSimbolo(new RegistroSimbolo(nodo.getIdentificador().getNombre(), tipo, nodo.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.VAR));
                }

                cargarTabla(nodo.getNodo());
            }
            else
            if (raiz instanceof NodoArray) {
                NodoArray nodoA = (NodoArray) raiz;
                if (nodoA.getIdentificador() != null) {
                    nodoA.setAmbito(ambito);
                    nodoA.getIdentificador().setAmbito(ambito);
                    InsertarSimbolo(new RegistroSimbolo(nodoA.getTam(), nodoA.getIdentificador().getNombre(), tipo, nodoA.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.ARRAY));
                }
                cargarTabla(((NodoArray) raiz).getNodo());
            }
            else
            if (raiz instanceof  NodoAsignacion){
                NodoAsignacion nodo = (NodoAsignacion)raiz;
                nodo.setAmbito(ambito);
                RegistroSimbolo simbolo = this.BuscarSimbolo(nodo.getIdentificador().getNombre(), nodo.getAmbito());
                if( simbolo != null && simbolo.getExistInitialize() == false){
                    //si no es usado al otro lado, es una asignacion valida
                    System.out.println(nodo.getIdentificador().getNombre());
                    if( SearhIdentificadorExist(nodo.getIdentificador().getNombre(), ((NodoAsignacion)raiz).getExpresion() ) == false ){
                        simbolo.setSymbolInitialize(nodo.getSymbol());   
                    }
                }
            }
            else if (raiz instanceof  NodoLeer){
                //LECTURA, tambien es asignacion
                NodoIdentificador nodo = null;
                if( ((NodoLeer)raiz).getIdentificador() instanceof NodoIdentificador ){
                    nodo = (NodoIdentificador)((NodoLeer)raiz).getIdentificador();
                }
                else
                if (((NodoLeer)raiz).getIdentificador() instanceof NodoArray){
                    nodo = ((NodoArray)(((NodoLeer)raiz).getIdentificador())).getIdentificador();
                }
                if (nodo != null){
                    nodo.setAmbito(ambito);
                    RegistroSimbolo simbolo = this.BuscarSimbolo(nodo.getNombre(), nodo.getAmbito());
                    if( simbolo.getExistInitialize() == false){
                        simbolo.setSymbolInitialize(nodo.getSymbol());
                    }
                }
            }
            else
            if (raiz instanceof NodoIf) {
                String ambito_aux = "IF_" + String.valueOf(nivel) + "_" + String.valueOf(if_ambito_cont);
                String ambito_aux_padre = conts_ambito_global_padre;
                raiz.setAmbito(ambito);
                InsertarSimbolo(new RegistroSimbolo(ambito_aux,  raiz.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.AMBITO));
                
                RegistroSimbolo registro_else = new RegistroSimbolo(ambito_aux + "_ELSE",  raiz.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.AMBITO);

                ambito_aux_padre = ambito_padre;
                ambito_padre = ambito;
                ambito = ambito_aux;
                nivel++;
                if_ambito_cont++;

                //cargarTabla(((NodoIf)raiz).getPrueba());
                cargarTabla(((NodoIf) raiz).getParteThen());
                if (((NodoIf) raiz).getParteElse() != null) {
                	InsertarSimbolo(registro_else);
                	ambito = registro_else.getIdentificador();
                	cargarTabla(((NodoIf) raiz).getParteElse());
                }
                nivel--;
                ambito = ambito_padre;
                ambito_padre = ambito_aux_padre;
            }
            else 
            if (raiz instanceof NodoRepeat) {
                String ambito_aux = "REPEAT_" + String.valueOf(nivel) + "_" + String.valueOf(repeat_ambito_cont);
                String ambito_aux_padre = conts_ambito_global_padre;
                raiz.setAmbito(ambito);
                InsertarSimbolo(new RegistroSimbolo(ambito_aux, raiz.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.AMBITO));
                ambito_aux_padre = ambito_padre;
                ambito_padre = ambito;
                ambito = ambito_aux;
                nivel++;
                repeat_ambito_cont++;

                cargarTabla(((NodoRepeat) raiz).getCuerpo());
                //cargarTabla(((NodoRepeat)raiz).getPrueba());
                nivel--;
                ambito = ambito_padre;
                ambito_padre = ambito_aux_padre;
            }
            else
            if (raiz instanceof NodoFor) {
                String ambito_aux = "FOR_" + String.valueOf(nivel) + "_" + String.valueOf(for_ambito_cont);
                String ambito_aux_padre = conts_ambito_global_padre;
                raiz.setAmbito(ambito);
                InsertarSimbolo(new RegistroSimbolo(ambito_aux, raiz.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.AMBITO));
                ambito_aux_padre = ambito_padre;
                ambito_padre = ambito;
                ambito = ambito_aux;
                nivel++;
                for_ambito_cont++;

                //Estos 2 nodos se cargan solo para vefificar sus asignaciones
		    	cargarTabla(((NodoFor)raiz).getInicializacion());
                cargarTabla(((NodoFor)raiz).getIncremento());

                //Este nodo no se evalua ya que en el no ocurre ninguna creacion de variables
                //cargarTabla(((NodoFor)raiz).getCondicion());
                
                cargarTabla(((NodoFor) raiz).getSentencia());
                nivel--;
                ambito = ambito_padre;
                ambito_padre = ambito_aux_padre;
            }
            raiz = raiz.getHermanoDerecha();
        }
    }

    public boolean SearhIdentificadorExist(String nombre, NodoBase raiz){
        boolean exist = false;
        if( raiz != null ){
            if (raiz instanceof NodoLogico){
                exist = SearhIdentificadorExist(nombre, ((NodoLogico)raiz).getOpIzquierdo() );
                if( exist == false )
                {
                    exist = SearhIdentificadorExist(nombre, ((NodoLogico)raiz).getOpDerecho() );   
                }
            }
            else
            if (raiz instanceof NodoOperacion){
                exist = SearhIdentificadorExist(nombre, ((NodoOperacion)raiz).getOpIzquierdo() );
                if( exist == false )
                {
                    exist = SearhIdentificadorExist(nombre, ((NodoOperacion)raiz).getOpDerecho() );   
                }
            }
            else
            if (raiz instanceof NodoArray){
                exist = SearhIdentificadorExist(nombre, ((NodoArray)raiz).getIdentificador() );   
            }
            else
            if (raiz instanceof NodoIdentificador){
                return nombre.equals( ((NodoIdentificador)raiz).getNombre() );
            }
            else
            if (raiz instanceof NodoCallFunction){
                exist = SearhIdentificadorExist(nombre, ((NodoCallFunction)raiz).getVariables() );
            }
            else
            if(raiz instanceof NodoParamFunction){
                exist = SearhIdentificadorExist(nombre, ((NodoParamFunction)raiz).getExpresion() );
                if( exist == false )
                {
                    exist = SearhIdentificadorExist(nombre, ((NodoParamFunction)raiz).getSiguiente() );   
                }
            } 
        }
        return exist;
    }

    //true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar
    private boolean Debug_Carcar = false; 
    public boolean InsertarSimbolo(RegistroSimbolo simbolo) {

        if (tabla.containsKey(simbolo.getIdentificador())) {
            RegistroSimbolo simbolo_tabla = BuscarSimbolo(simbolo.getIdentificador());
            if (simbolo_tabla.getAmbito().equals(simbolo.getAmbito())) {
                if( Debug_Carcar )
                	System.out.println( "Tipo symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :(");
                return false;
            } else {
                boolean colision = false;
                RegistroSimbolo simbolo_hermano = simbolo_tabla;
                while (true) {

                    if (simbolo_hermano.getAmbito().equals(simbolo.getAmbito())) {
                        colision = true;
                        break;
                    } else {
                        /*
                        //Buscando padre
                        RegistroSimbolo simbolo_ambito_padre = simbolo_tabla;
                        while (simbolo_ambito_padre != null) {
                            //busco padre inmediato
                            if (simbolo_ambito_padre.getAmbito().equals(simbolo.getAmbitoPadre())) {
                                colision = true;
                                break;
                            } else {
                                colision = ResolverPadres(simbolo_ambito_padre, BuscarSimbolo(simbolo.getAmbito()));

                                if (colision) {
                                    break;
                                }
                            }
                            simbolo_ambito_padre = simbolo_ambito_padre.getHermano();
                        }*/

                        colision = ResolverPadres(simbolo_hermano, BuscarSimbolo(simbolo.getAmbito()));


                        if (simbolo_hermano.getHermano() != null) {
                            simbolo_hermano = simbolo_hermano.getHermano();
                        } else {
							break;
                        }
                    }
                }

                if (colision == false) {
                    simbolo_hermano.setHermano(simbolo);
                    tabla.put(simbolo_tabla.getIdentificador(), simbolo_tabla);
                    if( Debug_Carcar )
                		System.out.println( "Tipo symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :)*");
                    return true;
                } else {
                    if( Debug_Carcar )
                		System.out.println( "Tipo symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :(*");
                	return false;
                }
            }
        } else {
            tabla.put(simbolo.getIdentificador(), simbolo);
            if( Debug_Carcar )
                System.out.println("Tipo symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :)");
            return true;
        }
    }

    public boolean ResolverPadres(RegistroSimbolo arrastre, RegistroSimbolo simbolo_ambito) {
        //busco padre en la cadena    
        if (arrastre != null && simbolo_ambito!=null) {
            //busco padre inmediato
            if (arrastre.getAmbito().equals(simbolo_ambito.getAmbito())) {
                return true;
            } else {
                if (simbolo_ambito.getAmbito() != conts_ambito_global && simbolo_ambito.getAmbito() != conts_ambito_functions) {
                    return ResolverPadres(arrastre, BuscarSimbolo(simbolo_ambito.getAmbito()));
                }
            }
        }
        return false;
    }

    public boolean EstoyDentroDeUnaFuncion(RegistroSimbolo arrastre) {
        //busco padre en la cadena    
        if (arrastre != null) {
            //busco padre inmediato
            if (arrastre.getAmbito().equals(conts_ambito_functions)) {
                return true;
            } else {
                return EstoyDentroDeUnaFuncion(BuscarSimbolo(arrastre.getAmbito()));
            }
        }
        return false;
    }

    public RegistroSimbolo BuscarSimbolo(String identificador) {
    	if( tabla.containsKey(identificador) ){
        	RegistroSimbolo simbolo = (RegistroSimbolo) tabla.get(identificador);
        	return simbolo;
    	}
    	else{
    		return null;
    	}
    }

    public RegistroSimbolo BuscarSimbolo(String identificador, String ambito) {
        //System.out.println("Linea: --------------------------("+identificador+"-"+ambito+")---------------------------");  
        if( tabla.containsKey(identificador) ){
        	
	        RegistroSimbolo simbolo = (RegistroSimbolo) tabla.get(identificador);
	        //System.out.println(":)Linea: "+simbolo.getNumLineaDeclare()+"-> column: "+simbolo.getNumColumnDeclare()+"-> symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador() + " tipo retorno: " + simbolo.getTipo() + " ambito: " + simbolo.getAmbito() + " ambito padre: " + simbolo.getAmbitoPadre() + " nivel: " + String.valueOf(simbolo.getNivel()));
            
	        while(simbolo != null){
	        	if( simbolo.getAmbito().equals(ambito)){
	        		//se consiguio en el mismo ambito
	        		break;
	        	}
	        	else{
	        		simbolo = simbolo.getHermano();
	        	}
	        }
	        if( simbolo != null ){
	        	return simbolo;	
	        }
	        else{
                if( ((RegistroSimbolo)tabla.get(ambito)) == null){
	        		return null;
	        	}
	        	else{
                    //System.out.println("1-Ambito busqueda:"+((RegistroSimbolo)tabla.get(ambito)).getAmbito());
	        		//System.out.println("2-Ambito identificador:"+identificador);
                    
                    return BuscarSimbolo(identificador, ((RegistroSimbolo)tabla.get(ambito)).getAmbito());
	        	}
	    	}
	    }
	    else{
	    	return null;
	    }
    }

    public RegistroSimbolo BuscarSimboloIsFunction(String identificador) {
        //System.out.println("Linea: --------------------------("+identificador+"-"+ambito+")---------------------------");  
        if( tabla.containsKey(identificador) ){
            RegistroSimbolo simbolo = (RegistroSimbolo) tabla.get(identificador);
            //System.out.println("Linea: "+simbolo.getNumLineaDeclare()+"-> column: "+simbolo.getNumColumnDeclare()+"-> symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador() + " tipo retorno: " + simbolo.getTipo() + " ambito: " + simbolo.getAmbito() + " ambito padre: " + simbolo.getAmbitoPadre() + " nivel: " + String.valueOf(simbolo.getNivel()));
            while(simbolo != null){
                if( simbolo.getAmbito().equals(conts_ambito_functions)){
                    //se consiguio en el mismo ambito
                    break;
                }
                else{
                    simbolo = simbolo.getHermano();
                }
            }
            return simbolo; 
        }
        else{
            return null;
        }
    }

    public void ImprimirClaves() {
        System.out.println("*** Tabla de Simbolos ***");
        for (Iterator<String> it = tabla.keySet().iterator(); it.hasNext();) {
            String s = (String) it.next();
            RegistroSimbolo simbolo = BuscarSimbolo(s);
            while (simbolo != null) {
                System.out.print("Key: " + s + ", Line: "+simbolo.getNumLineaDeclare()+", Col: "+simbolo.getNumColumnDeclare()+", Type: " + simbolo.getTipeSymbol() +  ", Type var: " + simbolo.getTipo() + ", Amb: " + simbolo.getAmbito() + ", Amb_p: " + simbolo.getAmbitoPadre());
                if( simbolo.getExistInitialize() == true )
                    System.out.println(", Init: Si, Line: " +simbolo.getNumLineaInitialize() );
                else
                    System.out.println(", Init: NO");

                simbolo = simbolo.getHermano();
               
            }
        }
    }

    public int getDireccion(String Clave) {
        return BuscarSimbolo(Clave).getDireccionMemoria();
    }

    /*
     * TODO:
     * 1. Crear lista con las lineas de codigo donde la variable es usada.
     * */
}
