# tiny
Versión en java muy simple del compilador del lenguaje Tiny diseñado por el profesor Louden en su libro compiladores e intérpretes usado en la UNET
#Gramática Compilador (Sin modificaciones)

Program	::= stmt_seq;

stmt_seq	::= stmt_seq stmt SEMI | stmt SEMI;

Stmt		::= if_stmt  | decl_var	|  funcion_stmt	| bloque_stmt	|   repeat_stmt	| assign_stmt	|    read_stmt  |   write_stmt	|  array_var_access	| for_stmt | return_stmt  | call_funcion | error;

If_stmt	::=  IF logica_exp THEN stmt_seq END	|   IF logica_exp THEN stmt_seq ELSE stmt_seq END	;

decl_var	::=   INT var_list	|  BOOLEAN var_list;

var_list	::=    ID COMA var_list	|  ID	|  ID LCLASP NUM RCLASP COMA var_list	|  ID LCLASP NUM RCLASP;

funcion_stmt	::=  VOID ID LPAREN decl_fun RPAREN bloque_stmt	|  INT ID LPAREN decl_fun RPAREN bloque_stmt	|  BOOLEAN ID LPAREN decl_fun RPAREN bloque_stmr	|  VOID ID LPAREN RPAREN bloque_stmt	| INT ID LPAREN RPAREN bloque_stmt	|  BOOEAN ID LPAREN RPAREN bloque_stmt;
 
bloque_stmt	::=  BEGIN stmt_seq END;

repeat_stmt	::=  REPEAT stmt_seq UNTIL exp;

assign_stmt		::=    ID ASSIGN exp  |   array_var_access ASSIGN exp;

read_stmt		::=    READ ID  |  READ array_var_access;

write_stmt	::=  WRITE exp;

array_var_access	::=  ID LCLASP simple_exp RCLASP;

for_stmt	::= FOR LPAREN eq_stmt SEMI logica_exp SEMI eq_stmt RPAREN stmt_seq END;

return_stmt	::= RETUNR factor	| RETUNR;

call_funcion  ::=  ID LPAREN param_funcion RPAREN	|  ID LPAREN RPAREN;

decl_fun	::= INT ID COMA decl_fun	|   BOOLEAN ID COMA decl_fun	| INT ID	|   BOOLEAN ID;

exp	::= simple_exp GE simple_exp | simple_exp GT simple_exp	| simple_exp LE simple_exp | simple_exp LT simple_exp | simple_exp EQ simple_exp	|  simple_exp NE simple_exp |  call_funcion |  simple_exp | array_var_access;

simple_exp	::=  simple_exp PLUS term  |  simple_exp MINUS term | term;

eq_stmt	::= ID EQ exp;

factor	::=  LPAREN exp RPAREN  | NUM | MINUS NUM | ID  | TRUE  | FALSE | error;

param_funcion	 ::=  simple_exp COMA param_funcion | simple_exp;

term	::= term TIMES factor | term OVER factor  | factor;

logica_exp	::= exp AND logica_exp  |  exp OR logica_exp  |  exp;
