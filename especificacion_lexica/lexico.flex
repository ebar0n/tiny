
package compilador;

import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;


%%
/* Habilitar la compatibilidad con el interfaz CUP para el generador sintactico*/
%cup
/* Acceso a la columna y fila actual de analisis CUP */
%line
%column
%public
%class Lexer

/* Llamar Scanner a la clase que contiene el analizador Lexico */

%class Scanner
/*-- CONSTRUCTOR --*/
%{
	StringBuffer string = new StringBuffer();

	public Scanner(java.io.InputStream r, ComplexSymbolFactory csf){
		this(r);
		this.csf=csf;
		lineanum=0;
	}

//	private SymbolFactory csf;
	private ComplexSymbolFactory csf;
	private int lineanum;
	private boolean debug = false;

	private Symbol symbol(String name, int sym) {
	    return csf.newSymbol(name, sym, new Location(yyline+1,yycolumn+1,yychar), new Location(yyline+1,yycolumn+yylength(),yychar+yylength()));
	}

	private Symbol symbol(String name, int sym, Object val) {
	    Location left = new Location(yyline+1,yycolumn+1,yychar);
	    Location right= new Location(yyline+1,yycolumn+yylength(), yychar+yylength());
	    return csf.newSymbol(name, sym, left, right,val);
	}

	private void error(String message) {	
	  System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
	}

	public void printDebug(String message){
		if(debug) {
			System.out.print(message);
			System.out.println(" - linea " + (yyline + 1) + ", columna " + (yycolumn + 1) + ", valor: \"" + yytext() + "\"");
		}
	}
%}

%eofval{
     return csf.newSymbol("EOF", sym.EOF, new Location(yyline+1,yycolumn+1,yychar), new Location(yyline+1,yycolumn+1,yychar+1));
%eofval}

digito		= [0-9]
numero		= {digito}+
letra			= [a-zA-Z]
identificador	= {letra}+{digito}*{letra}*{digito}*
nuevalinea		= \n | \n\r | \r\n
espacio		= [ \t]+

%%
"if"        {	
				printDebug("token IF");
				return symbol("IF",sym.IF);
			}

"then"      { 
				printDebug("token THEN");
				return symbol("THEN",sym.THEN);
			}

"else"      {	
				printDebug("token ELSE");
				return symbol("ELSE",sym.ELSE);
			}

"end"       {	
				printDebug("token END");
				return symbol("END",sym.END);
			}

"repeat"    {	
				printDebug("token REPEAT");
				return symbol("REPEAT",sym.REPEAT);
			}

"until"     {	
				printDebug("token UNTIL");
				return symbol("UNTIL",sym.UNTIL);
			}

"read"      {	
				printDebug("token READ");
				return symbol("READ",sym.READ);
			}

"write"     {	
				printDebug("token WRITE");
				return symbol("WRITE",sym.WRITE);
			}

"for"		{   
				printDebug("token FOR");
				return symbol("FOR",sym.FOR);
			}

"boolean"	{   
				printDebug("token BOOLEAN");
				return symbol("BOOLEAN",sym.BOOLEAN);
			}	

"int"		{   
				printDebug("token INT");
				return symbol("INT",sym.INT);
			}

"begin"		{   
				printDebug("token BEGIN");
				return symbol("BEGIN",sym.BEGIN);
			}

"return"	{   
				printDebug("token RETURN");
				return symbol("RETURN",sym.RETURN);
			}

"void"		{   
				printDebug("token VOID");
				return symbol("VOID",sym.VOID);
			}

"and"		{   
				printDebug("token AND");
				return symbol("AND",sym.AND);
			}

"or"		{   
				printDebug("token OR");
				return symbol("OR",sym.OR);
			}

"true"		{   
				printDebug("token TRUE");
				return symbol("TRUE",sym.TRUE);
			}

"false"		{   
				printDebug("token FALSE");
				return symbol("FALSE",sym.FALSE);
			}

">="		{   
				printDebug("token GE");
				return symbol("GE",sym.GE);
			}

">"		    {   
				printDebug("token GT");
				return symbol("GT",sym.GT);
			}

"<="		{   
				printDebug("token LE");
				return symbol("LE",sym.LE);
			}

"<"         {	
				printDebug("token LT");
				return symbol("LT",sym.LT);
			}

","		    {   
				printDebug("token COMA");
				return symbol("COM",sym.COMA);
			}

"!="		{   
				printDebug("token NE");
				return symbol("NE",sym.NE);
			}

":="        {	
				printDebug("token ASSIGN");
				return symbol("ASSIGN",sym.ASSIGN);
			}

"="         {	
				printDebug("token EQ");
				return symbol("EQ",sym.EQ);
			}

"+"         {	
				printDebug("token PLUS");
				return symbol("PLUS",sym.PLUS);
			}

"-"         {	
				printDebug("token MINUS");
				return symbol("MINUS",sym.MINUS);
			}


"*"         {	
				printDebug("token TIMES");
				return symbol("TIMES",sym.TIMES);
			}

"/"         {	
				printDebug("token OVER");
				return symbol("OVER",sym.OVER);
			}

"("         {	
				printDebug("token LPAREN");
				return symbol("LPAREN",sym.LPAREN);
			}

")"         {	
				printDebug("token RPAREN");
				return symbol("RPAREN",sym.RPAREN);
			}

"["		    {   
				printDebug("token LCLASP");
				return symbol("LCLASP",sym.LCLASP);
			}

"]"		    {   
				printDebug("token RCLASP");
				return symbol("RCLASP",sym.RCLASP);
			}

";"         {	
				printDebug("token SEMI");
				return symbol("SEMI",sym.SEMI);
			}

{numero}    {	
				printDebug("token NUM");
				return symbol("NUM",sym.NUM,new Integer(yytext()));
			}

{identificador}	{
				printDebug("token ID");
				//return symbol("ID",sym.ID,new String((yyline + 1) + " " + (yycolumn + 1) + " " + yytext()) );
				return symbol("ID",sym.ID,new String(yytext()) );
			}

{nuevalinea} {
				lineanum++;
			}

{espacio}   { 
				/* saltos espacios en blanco*/
			}

"{"[^}]+"}" { 
				/* salto comentarios */ 
				printDebug("token COMENTARIO"); 
			}

.           {
				System.err.println("Error lexico , linea " + (yyline+1) + ", columna " + (yycolumn+1) + " -> " + yytext() + "\n");
			}