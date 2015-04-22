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
		
		ComplexSymbolFactory csf = new ComplexSymbolFactory();
		parser parser_obj;

		//ScannerBuffer lexer = new ScannerBuffer(new Lexer(new BufferedReader(new FileReader(args[0])),csf));
                Scanner jflex;
		if (args.length==0) 
                {
                        jflex = new Scanner(System.in,csf);
			parser_obj=new parser(jflex,csf);
			//parser_obj=new parser(lexer,csf);
                }
                else{ 
                        jflex = new Scanner(new java.io.FileInputStream(args[0]),csf);
			parser_obj=new parser(jflex,csf);
                }
		UtGen.debug=true;
		//NO muestro mensajes de depuracion del generador (UTGen) para que el codigo sea compatible con la version visual de la TM
		//Para ver depuracion de analisis sintactico se debe ir al parser.java y colocar modoDepuracion en true
		
		/***************************/
		System.out.println("Analizando lexico y sintactico");
		parser_obj.parse();
		NodoBase root=parser_obj.action_obj.getASTroot();
                
		System.out.println("#"+(jflex.error_count-1)+" error(es) lexicos detectado(s)");
		System.out.println("#"+(parser_obj.error_count-1)+" error(es) sintanticos detectado(s)");
		/***************************/

		/***************************/
		//System.out.println("\nIMPRESION DEL AST GENERADO\n");
		//ast.Util.imprimirAST(root);
		/***************************/
		
		TablaSimbolos ts = new TablaSimbolos();
		ts.cargarTabla(root);
		//ts.ImprimirClaves();
		//REALIZAR ACA ANALISIS SEMANTICO
		
		/*******************/
		Semantica semantica = new Semantica(ts);
		System.out.println("\nAnalizando semantica");
		semantica.RecorrerArbol(root);
		System.out.println("#"+(semantica.error_count-1)+" error(es) semanticos detectado(s)");
		System.out.println("#"+(semantica.warning_count-1)+" Warning(s) semanticos detectado(s)");
		/*******************/

		if( semantica.error_count*parser_obj.error_count*jflex.error_count == 1 ){
			Generador.setTablaSimbolos(ts);
			//Generador.generarCodigoObjeto(root);
			Generador.generarEjemplo();
		}

	}

}
