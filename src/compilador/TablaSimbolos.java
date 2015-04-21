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
                ambito = "MAIN_FUNCTIONS";
                ambito_padre = "MAIN";
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
                ambito = "MAIN";
                ambito_padre = "";
            }

            if (raiz instanceof NodoBloque) {
                if (ambito == "MAIN" || (ambito==null && ambito_padre==null)) {
                    if (ambito == "MAIN" ){
                    	//Este simbolo tambien se agraga una sola vez
                    	InsertarSimbolo(new RegistroSimbolo("MAIN_FUNCTIONS", raiz.getSymbol(), "MAIN_FUNCTIONS", ambito, nivel, tipoSymbol.AMBITO));
                	}
                    ambito = "MAIN";	
                	ambito_padre = "";
                    nivel = 1;
                    raiz.setAmbito(ambito);
                    
                    InsertarSimbolo(new RegistroSimbolo("MAIN", raiz
                    	.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.AMBITO));

                }
                nivel++;
                cargarTabla(((NodoBloque) raiz).getExpression());
            }

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

            if (raiz instanceof NodoArray) {
                NodoArray nodoA = (NodoArray) raiz;
                if (nodoA.getIdentificador() != null) {
                    nodoA.setAmbito(ambito);
                    nodoA.getIdentificador().setAmbito(ambito);
                    InsertarSimbolo(new RegistroSimbolo(nodoA.getTam(), nodoA.getIdentificador().getNombre(), tipo, nodoA.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.ARRAY));
                }
                cargarTabla(((NodoArray) raiz).getNodo());
            }

            if (raiz instanceof NodoLogico) {
                cargarTabla(((NodoLogico) raiz).getOpIzquierdo());
                cargarTabla(((NodoLogico) raiz).getOpDerecho());
            }

            if (raiz instanceof NodoIf) {
                String ambito_aux = "IF_" + String.valueOf(nivel) + "_" + String.valueOf(if_ambito_cont);
                String ambito_aux_padre = "";
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
            } else if (raiz instanceof NodoRepeat) {
                String ambito_aux = "REPEAT_" + String.valueOf(nivel) + "_" + String.valueOf(repeat_ambito_cont);
                String ambito_aux_padre = "";
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
            } else if (raiz instanceof NodoFor) {
                String ambito_aux = "FOR_" + String.valueOf(nivel) + "_" + String.valueOf(for_ambito_cont);
                String ambito_aux_padre = "";
                raiz.setAmbito(ambito);
                InsertarSimbolo(new RegistroSimbolo(ambito_aux, raiz.getSymbol(), ambito, ambito_padre, nivel, tipoSymbol.AMBITO));
                ambito_aux_padre = ambito_padre;
                ambito_padre = ambito;
                ambito = ambito_aux;
                nivel++;
                for_ambito_cont++;

		    	//cargarTabla(((NodoFor)raiz).getInicializacion());
                //cargarTabla(((NodoFor)raiz).getCondicion());
                //cargarTabla(((NodoFor)raiz).getIncremento());
                cargarTabla(((NodoFor) raiz).getSentencia());
                nivel--;
                ambito = ambito_padre;
                ambito_padre = ambito_aux_padre;
            }
            raiz = raiz.getHermanoDerecha();
        }
    }

    //true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar
    private boolean DebufCarcar = false; 
    public boolean InsertarSimbolo(RegistroSimbolo simbolo) {

        if (tabla.containsKey(simbolo.getIdentificador())) {
            RegistroSimbolo simbolo_tabla = BuscarSimbolo(simbolo.getIdentificador());
            if (simbolo_tabla.getAmbito().equals(simbolo.getAmbito())) {
                if( DebufCarcar )
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
                        }

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
                    if( DebufCarcar )
                		System.out.println( "Tipo symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :)*");
                    return true;
                } else {
                    if( DebufCarcar )
                		System.out.println( "Tipo symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :(*");
                	return false;
                }
            }
        } else {
            tabla.put(simbolo.getIdentificador(), simbolo);
            if( DebufCarcar )
                System.out.println("Tipo symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :)");
            return true;
        }
    }

    public boolean ResolverPadres(RegistroSimbolo arrastre, RegistroSimbolo simbolo) {
        //busco padre en la cadena
        RegistroSimbolo simbolo_padre = arrastre;
        if (simbolo_padre != null && simbolo!=null) {
            //busco padre inmediato
            if (simbolo_padre.getAmbito().equals(simbolo.getAmbito())) {
                return true;
            } else {
                if (simbolo.getAmbito() != "MAIN") {
                    return ResolverPadres(simbolo_padre.getHermano(), BuscarSimbolo(simbolo.getAmbito()));
                }
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
        System.out.println("Linea: --------------------------("+identificador+"-"+ambito+")---------------------------");
            
        if( tabla.containsKey(identificador) ){
        	
	        RegistroSimbolo simbolo = (RegistroSimbolo) tabla.get(identificador);
	        //System.out.println("Linea: "+simbolo.getNumLinea()+"-> column: "+simbolo.getNumColumn()+"-> symbol: " + simbolo.getTipeSymbol() + " -> key: " + simbolo.getIdentificador() + " tipo retorno: " + simbolo.getTipo() + " ambito: " + simbolo.getAmbito() + " ambito padre: " + simbolo.getAmbitoPadre() + " nivel: " + String.valueOf(simbolo.getNivel()));
            
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
	        		return BuscarSimbolo(identificador, ((RegistroSimbolo)tabla.get(ambito)).getAmbito());
	        	}
	    	}
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
                System.out.print(String.format("Linea: %4d | column: %4d | symbol: %10s | key: %13s | tipo: %5s | ambito: %13s | ambito_padre: %5s | nivel: %s", simbolo.getNumLinea(), simbolo.getNumColumn(), simbolo.getTipeSymbol(), s, simbolo.getTipo(), simbolo.getAmbito(), simbolo.getAmbitoPadre(), String.valueOf(simbolo.getNivel())));
                System.out.println("");

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
