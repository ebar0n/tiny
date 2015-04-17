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
		direccion=0;
	}

	public void cargarTabla(NodoBase raiz){
		while (raiz != null) {
	    /* Hago el recorrido recursivo */

		    if (raiz instanceof NodoFunction){
		    	ambito = "MAIN_FUNTIONS";
		    	ambito_padre = "MAIN";
		    	nivel = 1;
		    	NodoFunction nodof = (NodoFunction)raiz;
		    	nodof.setAmbito(ambito);
		    	RegistroSimboloFunction simboloFunction = new RegistroSimboloFunction(
										nodof.getIdentificador(),
		    							nodof.getTipo(),
                                        1,
                                        ambito,
                                        ambito_padre,
                                        nivel
                                       );
		    	Integer num_arg = 0;
		    	ambito_padre = ambito;
		    	ambito = nodof.getIdentificador();
		    	if(nodof.getDeclaracion()!=null){
		    		NodoArgList nodoA = (NodoArgList)nodof.getDeclaracion();	    	
		    		while(nodoA !=null ){
		    			nodoA.setAmbito(ambito);
		    			InsertarSimbolo(new RegistroSimbolo(nodoA.getIdentificador().getNombre(), nodoA.getTipo(), 1,  ambito,ambito_padre, nivel));
		    			simboloFunction.setTipoParametros(nodoA.getTipo());
		    			simboloFunction.setIdParametros(nodoA.getIdentificador().getNombre());
		    			nodoA = (NodoArgList)nodoA.getArgumento();
		    			num_arg++;
		    		}
		    	}
		    	simboloFunction.setNumParametros(num_arg);
		    	InsertarSimbolo((RegistroSimbolo)simboloFunction);
		    	cargarTabla(((NodoFunction)raiz).getExpression());
		    	ambito = "MAIN";
		    	ambito_padre = "";		    
		    }

		    if (raiz instanceof NodoBloque){
		    	if (ambito == "MAIN"){
		    		nivel = 1;
		    		raiz.setAmbito(ambito);
		    		//Este simbolo tambien se agraga una sola vez
		    		InsertarSimbolo(new RegistroSimbolo("MAIN_FUNTIONS", 1, "MAIN_FUNTIONS", ambito, nivel));
		    	
		    		InsertarSimbolo(new RegistroSimbolo("MAIN", 1, ambito, ambito_padre, nivel));
		    		
		    	}
		    	nivel++;
		    	cargarTabla(((NodoBloque)raiz).getExpression());
		    }

		    if (raiz instanceof NodoVariable){
		    	NodoVariable nodo = (NodoVariable)raiz;
		    	if(nodo.getTipo()!=null){
		    		tipo = nodo.getTipo();
		    	}
		    	if(nodo.getId()!=null){
		    		nodo.setAmbito(ambito);
		    		InsertarSimbolo(new RegistroSimbolo(nodo.getId().getNombre(), tipo, 1,  ambito,ambito_padre, nivel));
		    	}
		    	
		    	cargarTabla(nodo.getNodo());
		    }

		    if (raiz instanceof NodoArray){
		    	NodoArray nodoA = (NodoArray)raiz;
		    	if(nodoA.getId()!=null){
		    		nodoA.setAmbito(ambito);
		    		InsertarSimbolo(new RegistroSimboloArray(nodoA.getTam(),nodoA.getIdentificador().getNombre(), tipo, 1,  ambito,ambito_padre, nivel));
		    	}
		    	cargarTabla(((NodoArray)raiz).getNodo());
		    }

		    if (raiz instanceof NodoLogico){
		    	cargarTabla(((NodoLogico)raiz).getOpIzquierdo());
		    	cargarTabla(((NodoLogico)raiz).getOpDerecho());
		    }

		    if (raiz instanceof  NodoIf){
		    	String ambito_aux = "IF_"+String.valueOf(nivel)+"_"+String.valueOf(if_ambito_cont);
		    	String ambito_aux_padre = "";
		    	raiz.setAmbito(ambito);
		    	InsertarSimbolo(new RegistroSimbolo(ambito_aux, 1,  ambito,ambito_padre, nivel));
		    	ambito_aux_padre = ambito_padre;
		    	ambito_padre = ambito;
		    	ambito = ambito_aux;
		    	nivel++;
		    	if_ambito_cont++;
		 
		    	//cargarTabla(((NodoIf)raiz).getPrueba());
		    	cargarTabla(((NodoIf)raiz).getParteThen());
		    	if(((NodoIf)raiz).getParteElse()!=null){
		    		cargarTabla(((NodoIf)raiz).getParteElse());
		    	}

		    	ambito = ambito_padre;
		    	ambito_padre = ambito_aux_padre;
		    }
		    else if (raiz instanceof  NodoRepeat){
		    	String ambito_aux = "REPEAT_"+String.valueOf(nivel)+"_"+String.valueOf(repeat_ambito_cont);
		    	String ambito_aux_padre = "";
		    	raiz.setAmbito(ambito);
		    	InsertarSimbolo(new RegistroSimbolo(ambito_aux, 1,  ambito,ambito_padre, nivel));
		    	ambito_aux_padre = ambito_padre;
		    	ambito_padre = ambito;
		    	ambito = ambito_aux;
		    	nivel++;
		    	repeat_ambito_cont++;

		    	cargarTabla(((NodoRepeat)raiz).getCuerpo());
		    	cargarTabla(((NodoRepeat)raiz).getPrueba());

		    	ambito = ambito_padre;
		    	ambito_padre = ambito_aux_padre;
		    }
		    else if (raiz instanceof NodoFor){
		    	String ambito_aux = "FOR_"+String.valueOf(nivel)+"_"+String.valueOf(for_ambito_cont);
		    	String ambito_aux_padre = "";
		    	raiz.setAmbito(ambito);
		    	InsertarSimbolo(new RegistroSimbolo(ambito_aux, 1,  ambito, ambito_padre, nivel));
		    	ambito_aux_padre = ambito_padre;
		    	ambito_padre = ambito;
		    	ambito = ambito_aux;
		    	nivel++;
		    	for_ambito_cont++;

		    	//cargarTabla(((NodoFor)raiz).getInicializacion());
		    	//cargarTabla(((NodoFor)raiz).getCondicion());
		    	//cargarTabla(((NodoFor)raiz).getIncremento());
		    	cargarTabla(((NodoFor)raiz).getSentencia());

		    	ambito = ambito_padre;
		    	ambito_padre = ambito_aux_padre;
		    }
	    	raiz = raiz.getHermanoDerecha();
	  }
	}
	
	//true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar 
	public boolean InsertarSimbolo(RegistroSimbolo simbolo){
		if(tabla.containsKey(simbolo.getIdentificador())){
			RegistroSimbolo simbolo_tabla = BuscarSimbolo(simbolo.getIdentificador());
			if (simbolo_tabla.getAmbito().equals(simbolo.getAmbito())){
				//System.out.println(simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :(");
				return false;
			}
			else{
				boolean colision = false;
				RegistroSimbolo simbolo_hermano = simbolo_tabla; 
				while(true){
					////System.out.println("(1) "+simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre());
					
					if (simbolo_hermano.getAmbito().equals(simbolo.getAmbito())){
						colision = true;
						break;
					}
					else{
        				/*
        				if(simbolo.getNivel() > simbolo_hermano.getNivel()){
        					colision = true;
							break;
        				}
        				else{
        				
        					if(simbolo_hermano.getHermano()!=null)
        						simbolo_hermano = simbolo_hermano.getHermano();
        					else
        						break;
            			}
            			*/

            			//Buscando padre
            			RegistroSimbolo simbolo_ambito_padre = simbolo_tabla; 
						while(simbolo_ambito_padre != null){
							//busco padre inmediato
							if (simbolo_ambito_padre.getAmbito().equals(simbolo.getAmbitoPadre())){
								colision = true;
								break;
							}
							else{
								colision = ResolverPadres(simbolo_ambito_padre, BuscarSimbolo(simbolo.getAmbito()));
							
								if (colision ){
									break;
								}
							}
							simbolo_ambito_padre = simbolo_ambito_padre.getHermano();
						}

            			if(simbolo_hermano.getHermano()!=null)
            				simbolo_hermano = simbolo_hermano.getHermano();
            			else
            				break;
            		}
            	}

            	if (colision == false){
            		
            		simbolo_hermano.setHermano(simbolo);
            		
            		//System.out.println(simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :)*");
					
					tabla.put(simbolo_hermano.getIdentificador(),simbolo_hermano);
					return true;	
            	}
            	else{
            		//System.out.println(simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :(*");
					return false;
            	}
				
			}
		}else{
			//System.out.println(simbolo.getIdentificador() + " -> " + simbolo.getAmbito() + " -> " + simbolo.getAmbitoPadre() + " -> " + simbolo.getNivel() + " :)");
			tabla.put(simbolo.getIdentificador(),simbolo);
			return true;			
		}
	}
	
	public boolean ResolverPadres(RegistroSimbolo arrastre, RegistroSimbolo simbolo){
		//busco padre en la cadena
		RegistroSimbolo simbolo_padre = arrastre; 
		if(simbolo_padre != null){
			//busco padre inmediato
			if (simbolo_padre.getAmbito().equals( simbolo.getAmbito())) {
				return true;
			}
			else{
				if( simbolo.getAmbito() != "MAIN" ){
					return ResolverPadres(simbolo_padre.getHermano(), BuscarSimbolo(simbolo.getAmbito()));
				}
			}
		}
		return false;
	}

	public RegistroSimbolo BuscarSimbolo(String identificador){
		RegistroSimbolo simbolo=(RegistroSimbolo)tabla.get(identificador);
		return simbolo;
	}
	
	public void ImprimirClaves(){
		System.out.println("*** Tabla de Simbolos ***");
		for( Iterator <String>it = tabla.keySet().iterator(); it.hasNext();) { 
            String s = (String)it.next();
            RegistroSimbolo simbolo = BuscarSimbolo(s);
            while(simbolo!=null){
        		System.out.println("Consegui Key: "+s+  " tipo: " + simbolo.getTipo() + " ambito: " + simbolo.getAmbito()+ " ambito padre: " + simbolo.getAmbitoPadre()+ " nivel: " + String.valueOf(simbolo.getNivel()));    	
            	simbolo = simbolo.getHermano();
            }
	    }
	}

	public int getDireccion(String Clave){
		return BuscarSimbolo(Clave).getDireccionMemoria();
	}
	
	/*
	 * TODO:
	 * 1. Crear lista con las lineas de codigo donde la variable es usada.
	 * */
}
