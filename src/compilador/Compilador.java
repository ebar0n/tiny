package compilador;

import ast.*;
import java_cup.runtime.*;
import java.io.*;

public class Compilador {
    
    int a;
	
	/***********
	SymbolFactory es una nueva caracteristica que ha sido añadida a las version 11a de cup, la cual facilita la implementacion de clases Symbol personalizadas
	, esto debido a que dicha clase no provee mucha información de contexto que podria ser util para el analisis semantico o ayudar en la construccion del AST
	Mas informacion en: http//4thmouse.com/index.php/2007/02/15/using-custom-symbols-in-cup/
	***********/

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("deprecation")
		boolean debuglexico = false;
		boolean debugsintactico = false;
		boolean debugsemantico = false;
		boolean debugtablasimbolos = false;
		boolean debugarbolast = false;
		boolean debuggeneracion = true;

		ComplexSymbolFactory csf = new ComplexSymbolFactory();
		parser parser_obj;

		//ScannerBuffer lexer = new ScannerBuffer(new Lexer(new BufferedReader(new FileReader(args[0])),csf));
        Scanner jflex;
		if (args.length==0) 
        {
            jflex = new Scanner(System.in,csf,debuglexico);
			parser_obj=new parser(jflex,csf,debugsintactico);
			//parser_obj=new parser(lexer,csf);
        }
        else{ 
            jflex = new Scanner(new java.io.FileInputStream(args[0]),csf,debuglexico);
			parser_obj=new parser(jflex,csf,debugsintactico);
        }
		UtGen.debug=debuggeneracion;
		//NO muestro mensajes de depuracion del generador (UTGen) para que el codigo sea compatible con la version visual de la TM
		//Para ver depuracion de analisis sintactico se debe ir al parser.java y colocar modoDepuracion en true
		
		/***************************/
		if(debuglexico || debugsintactico)
			System.out.println("Analizando lexico y sintactico");
		parser_obj.parse();
		NodoBase root=parser_obj.action_obj.getASTroot();
                
		if(debuglexico || debugsintactico) {
			System.out.println("#"+(jflex.error_count-1)+" error(es) lexicos detectado(s)");
			System.out.println("#"+(parser_obj.error_count-1)+" error(es) sintanticos detectado(s)");
		}
		/***************************/

		/***************************/
		if(debugarbolast) {
			System.out.println("\nIMPRESION DEL AST GENERADO\n");
			ast.Util.imprimirAST(root);
		}

		/***************************/
		
		TablaSimbolos ts = new TablaSimbolos();
		ts.cargarTabla(root);
		if(debugtablasimbolos)
			ts.ImprimirClaves();

		//System.out.println();
		//System.out.println("IMPRESION DEL AST GENERADO");
		//System.out.println();
		//ast.Util.imprimirAST(root);
		
		/*******************/
		Semantica semantica = new Semantica(ts);
		if(debugsemantico) 
			System.out.println("\nBuscando errores semanticos");
		
		semantica.RecorrerArbol(root);
		if(debugsemantico) {
			System.out.println("#"+(semantica.error_count-1)+" error(es) semanticos detectado(s)");
			System.out.println("#"+(semantica.warning_count-1)+" Warning(s) semanticos detectado(s)");
		}
	
		/*******************/

		if( semantica.error_count*parser_obj.error_count*jflex.error_count == 1 ){
			Generador.setTablaSimbolos(ts);
			Generador.generarCodigoObjeto(root, debuggeneracion);
			//Generador.generarEjemplo();
		}

	}

}
