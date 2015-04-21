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

//		ScannerBuffer lexer = new ScannerBuffer(new Lexer(new BufferedReader(new FileReader(args[0])),csf));

		if (args.length==0) 
			parser_obj=new parser(new Scanner(System.in,csf),csf);
			//parser_obj=new parser(lexer,csf);
		else 
			parser_obj=new parser(new Scanner(new java.io.FileInputStream(args[0]),csf),csf);

		UtGen.debug=true; //NO muestro mensajes de depuracion del generador (UTGen) para que el codigo sea compatible con la version visual de la TM
		//Para ver depuracion de analisis sintactico se debe ir al parser.java y colocar modoDepuracion en true
		parser_obj.parse();
		NodoBase root=parser_obj.action_obj.getASTroot();
		//System.out.println();
		//System.out.println("IMPRESION DEL AST GENERADO");
		//System.out.println();
		//ast.Util.imprimirAST(root);
		
		TablaSimbolos ts = new TablaSimbolos();
		ts.cargarTabla(root);
		//ts.ImprimirClaves();
	    //REALIZAR ACA ANALISIS SEMANTICO
		Semantica semantica = new Semantica(ts);
		System.out.println("\nBuscando errores semanticos");
		semantica.RecorrerArbol(root);

		System.out.println("#"+(semantica.error_count-1)+" error(es) detectados semanticamente");
		System.out.println("#"+(semantica.warning_count-1)+" Warning(s) detectados");
					
		//Generador.setTablaSimbolos(ts);
		//Generador.generarCodigoObjeto(root);
	}

}
