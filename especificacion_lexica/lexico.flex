
package compilador;

import java_cup.runtime.*;


%%
/* Habilitar la compatibilidad con el interfaz CUP para el generador sintactico*/
%cup
/* Acceso a la columna y fila actual de analisis CUP */
%line
%column

/* Llamar Scanner a la clase que contiene el analizador Lexico */

%class Scanner
/*-- CONSTRUCTOR --*/
%{
	public Scanner(java.io.InputStream r, SymbolFactory sf){
		this(r);
		this.sf=sf;
		lineanum=0;
	}

	private SymbolFactory sf;
	private int lineanum;
	private boolean debug = true;

	public void printDebug(String message){
		if(debug) {
			System.out.print(message);
			System.out.println(" - linea " + (yyline + 1) + ", columna " + (yycolumn + 1) + ", valor: \"" + yytext() + "\"");
		}
	}
%}

%eofval{
    return sf.newSymbol("EOF",sym.EOF);
%eofval}

digito		= [0-9]
numero		= {digito}+
letra			= [a-zA-Z]
identificador	= {letra}+{digito}*
nuevalinea		= \n | \n\r | \r\n
espacio		= [ \t]+

%%
"if"        {	
				printDebug("token IF");
				return sf.newSymbol("IF",sym.IF);
			}

"then"      { 
				printDebug("token THEN");
				return sf.newSymbol("THEN",sym.THEN);
			}

"else"      {	
				printDebug("token ELSE");
				return sf.newSymbol("ELSE",sym.ELSE);
			}

"end"       {	
				printDebug("token END");
				return sf.newSymbol("END",sym.END);
			}

"repeat"    {	
				printDebug("token REPEAT");
				return sf.newSymbol("REPEAT",sym.REPEAT);
			}

"until"     {	
				printDebug("token UNTIL");
				return sf.newSymbol("UNTIL",sym.UNTIL);
			}

"read"      {	
				printDebug("token READ");
				return sf.newSymbol("READ",sym.READ);
			}

"write"     {	
				printDebug("token WRITE");
				return sf.newSymbol("WRITE",sym.WRITE);
			}

"for"		{   
				printDebug("token FOR");
				return sf.newSymbol("FOR",sym.FOR);
			}

"boolean"	{   
				printDebug("token BOOLEAN");
				return sf.newSymbol("BOOLEAN",sym.BOOLEAN);
			}	

"int"		{   
				printDebug("token INT");
				return sf.newSymbol("INT",sym.INT);
			}

"begin"		{   
				printDebug("token BEGIN");
				return sf.newSymbol("BEGIN",sym.BEGIN);
			}

"return"	{   
				printDebug("token RETURN");
				return sf.newSymbol("RETURN",sym.RETURN);
			}

"void"		{   
				printDebug("token VOID");
				return sf.newSymbol("VOID",sym.VOID);
			}

"and"		{   
				printDebug("token AND");
				return sf.newSymbol("AND",sym.AND);
			}

"or"		{   
				printDebug("token OR");
				return sf.newSymbol("OR",sym.OR);
			}

"true"		{   
				printDebug("token TRUE");
				return sf.newSymbol("TRUE",sym.TRUE);
			}

"false"		{   
				printDebug("token FALSE");
				return sf.newSymbol("FALSE",sym.FALSE);
			}

">="		{   
				printDebug("token GE");
				return sf.newSymbol("GE",sym.GE);
			}

">"		    {   
				printDebug("token GT");
				return sf.newSymbol("GT",sym.GT);
			}

"<="		{   
				printDebug("token LE");
				return sf.newSymbol("LE",sym.LE);
			}

"<"         {	
				printDebug("token LT");
				return sf.newSymbol("LT",sym.LT);
			}

","		    {   
				printDebug("token COMA");
				return sf.newSymbol("COM",sym.COMA);
			}

"!="		{   
				printDebug("token NE");
				return sf.newSymbol("NE",sym.NE);
			}

":="        {	
				printDebug("token ASSIGN");
				return sf.newSymbol("ASSIGN",sym.ASSIGN);
			}

"="         {	
				printDebug("token EQ");
				return sf.newSymbol("EQ",sym.EQ);
			}

"+"         {	
				printDebug("token PLUS");
				return sf.newSymbol("PLUS",sym.PLUS);
			}

"-"         {	
				printDebug("token MINUS");
				return sf.newSymbol("MINUS",sym.MINUS);
			}


"*"         {	
				printDebug("token TIMES");
				return sf.newSymbol("TIMES",sym.TIMES);
			}

"/"         {	
				printDebug("token OVER");
				return sf.newSymbol("OVER",sym.OVER);
			}

"("         {	
				printDebug("token LPAREN");
				return sf.newSymbol("LPAREN",sym.LPAREN);
			}

")"         {	
				printDebug("token RPAREN");
				return sf.newSymbol("RPAREN",sym.RPAREN);
			}

"["		    {   
				printDebug("token LCLASP");
				return sf.newSymbol("LCLASP",sym.LCLASP);
			}

"]"		    {   
				printDebug("token RCLASP");
				return sf.newSymbol("RCLASP",sym.RCLASP);
			}

";"         {	
				printDebug("token SEMI");
				return sf.newSymbol("SEMI",sym.SEMI);
			}

{numero}    {	
				printDebug("token NUM");
				return sf.newSymbol("NUM",sym.NUM,new Integer(yytext()));
			}

{identificador}	{
				printDebug("token ID");
				return sf.newSymbol("ID",sym.ID,new String((yyline + 1) + " " + (yycolumn + 1) + " " + yytext()) );
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