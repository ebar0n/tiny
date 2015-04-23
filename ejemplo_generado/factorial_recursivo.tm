*
*
* ------ CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
*
*
*      Compilacion TINY para el codigo objeto TM
*      Archivo: NOMBRE_ARREGLAR
*      Inicio Preludio estandar:
0:       LD       6,0(0)      cargar la maxima direccion desde la localidad 0
1:       ST       0,0(0)      limpio el registro de la localidad 0
2:       LDC       3,1(0)      carga constante, para usos de movimientos recursivos
*      Fin Preludio estandar:
4:       LD       2,0(6)      op: pop o cargo de la pila el valor
5:       ADD       6,6,3      op: bajar pila
6:       ST       2,0(5)      Guardo en la direccion 0 n
*      bloque normal
*      -> if
*      -> Operacion: igual
*      -> identificador
7:       LD       0,0(5)      cargar valor de identificador: n
*      <- identificador
8:       LDA       2,0(0)      Pasando operador izquierdo a la pila
9:       SUB       6,6,3      op: subir pila
10:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 0
11:       LDC       0,0(0)      cargar constante: 0
*      <- constante
12:       LD       2,0(6)      op: pop o cargo de la pila el valor
13:       ADD       6,6,3      op: bajar pila
14:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
15:       SUB       0,1,0      op: ==
16:       JEQ       0,2(7)      voy dos instrucciones mas alla if verdadero (AC==0)
17:       LDC       0,0(0)      caso de falso (AC=0)
18:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
19:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: igual
*      If: el salto hacia el else debe estar aqui
*      -> constante 1
21:       LDC       0,1(0)      cargar constante: 1
*      <- constante
22:       LD       2,0(6)      op: pop o cargo de la pila el valor
23:       ADD       6,6,3      op: bajar pila
24:       LDA       7,0(2)      Regreso a donde fui llamado
*      If: el salto hacia el final debe estar aqui
20:       JEQ       0,5(7)      if: jmp hacia else
*      -> Operacion: menos
*      -> Operacion: mas
*      -> Operacion: por
*      -> constante 0
26:       LDC       0,0(0)      cargar constante: 0
*      <- constante
27:       LDA       2,0(0)      Pasando operador izquierdo a la pila
28:       SUB       6,6,3      op: subir pila
29:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
30:       LDC       0,2(0)      cargar constante: 2
*      <- constante
31:       LD       2,0(6)      op: pop o cargo de la pila el valor
32:       ADD       6,6,3      op: bajar pila
33:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
34:       MUL       0,1,0      op: *
*      <- Operacion: por
35:       LDA       2,0(0)      Pasando operador izquierdo a la pila
36:       SUB       6,6,3      op: subir pila
37:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: por
*      -> identificador
38:       LD       0,0(5)      cargar valor de identificador: n
*      <- identificador
39:       LDA       2,0(0)      Pasando operador izquierdo a la pila
40:       SUB       6,6,3      op: subir pila
41:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: menos
*      -> identificador
45:       LD       0,0(5)      cargar valor de identificador: n
*      <- identificador
46:       LDA       2,0(0)      Pasando operador izquierdo a la pila
47:       SUB       6,6,3      op: subir pila
48:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
49:       LDC       0,1(0)      cargar constante: 1
*      <- constante
50:       LD       2,0(6)      op: pop o cargo de la pila el valor
51:       ADD       6,6,3      op: bajar pila
52:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
53:       SUB       0,1,0      op: -
*      <- Operacion: menos
54:       LDA       2,0(0)       carga parametro en llamada a funcion
55:       SUB       6,6,3      op: subir pila
56:       ST       2,0(6)      op: push en la pila tmp
42:       LDC       2,58(0)      Cargando verdareda linea de retorno :)
43:       SUB       6,6,3      op: subir pila
44:       ST       2,0(6)      op: push en la pila tmp
57:       LDC       7,4(0)      carga salto  4
58:       LD       2,0(6)      op: pop o cargo de la pila el valor
59:       ADD       6,6,3      op: bajar pila
60:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
61:       MUL       0,1,0      op: *
*      <- Operacion: por
62:       LD       2,0(6)      op: pop o cargo de la pila el valor
63:       ADD       6,6,3      op: bajar pila
64:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
65:       ADD       0,1,0      op: +
*      <- Operacion: mas
66:       LDA       2,0(0)      Pasando operador izquierdo a la pila
67:       SUB       6,6,3      op: subir pila
68:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: por
*      -> constante 0
69:       LDC       0,0(0)      cargar constante: 0
*      <- constante
70:       LDA       2,0(0)      Pasando operador izquierdo a la pila
71:       SUB       6,6,3      op: subir pila
72:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
73:       LDC       0,2(0)      cargar constante: 2
*      <- constante
74:       LD       2,0(6)      op: pop o cargo de la pila el valor
75:       ADD       6,6,3      op: bajar pila
76:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
77:       MUL       0,1,0      op: *
*      <- Operacion: por
78:       LD       2,0(6)      op: pop o cargo de la pila el valor
79:       ADD       6,6,3      op: bajar pila
80:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
81:       SUB       0,1,0      op: -
*      <- Operacion: menos
82:       LD       2,0(6)      op: pop o cargo de la pila el valor
83:       ADD       6,6,3      op: bajar pila
84:       LDA       7,0(2)      Regreso a donde fui llamado
25:       LDA       7,59(7)      if: salto incondicional hacia el final
*      <- if
*      Bloque principal
3:       LDA       7,81(7)      bloque unico: jmp a bloque principal
*      -> leer
85:       IN       0,0,0      leer: lee un valor entero 
86:       ST       0,2(5)      leer: almaceno el valor entero leido
*      <- leer
*      -> escribir
*      -> identificador
90:       LD       0,2(5)      cargar valor de identificador: x
*      <- identificador
91:       LDA       2,0(0)       carga parametro en llamada a funcion
92:       SUB       6,6,3      op: subir pila
93:       ST       2,0(6)      op: push en la pila tmp
87:       LDC       2,95(0)      Cargando verdareda linea de retorno :)
88:       SUB       6,6,3      op: subir pila
89:       ST       2,0(6)      op: push en la pila tmp
94:       LDC       7,4(0)      carga salto  4
95:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
96:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
