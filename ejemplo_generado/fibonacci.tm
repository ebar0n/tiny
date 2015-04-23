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
*      -> Operacion: menori
*      -> identificador
7:       LD       0,0(5)      cargar valor de identificador: n
*      <- identificador
8:       LDA       2,0(0)      Pasando operador izquierdo a la pila
9:       SUB       6,6,3      op: subir pila
10:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
11:       LDC       0,2(0)      cargar constante: 2
*      <- constante
12:       LD       2,0(6)      op: pop o cargo de la pila el valor
13:       ADD       6,6,3      op: bajar pila
14:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
15:       SUB       0,1,0      op: <=
16:       JLE       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0 || AC==0)
17:       LDC       0,0(0)      caso de falso (AC=0)
18:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
19:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menori
*      If: el salto hacia el else debe estar aqui
*      -> identificador
21:       LD       0,0(5)      cargar valor de identificador: n
*      <- identificador
22:       LD       2,0(6)      op: pop o cargo de la pila el valor
23:       ADD       6,6,3      op: bajar pila
24:       LDA       7,0(2)      Regreso a donde fui llamado
*      If: el salto hacia el final debe estar aqui
20:       JEQ       0,5(7)      if: jmp hacia else
*      -> Operacion: mas
*      -> Operacion: menos
*      -> identificador
29:       LD       0,0(5)      cargar valor de identificador: n
*      <- identificador
30:       LDA       2,0(0)      Pasando operador izquierdo a la pila
31:       SUB       6,6,3      op: subir pila
32:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
33:       LDC       0,1(0)      cargar constante: 1
*      <- constante
34:       LD       2,0(6)      op: pop o cargo de la pila el valor
35:       ADD       6,6,3      op: bajar pila
36:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
37:       SUB       0,1,0      op: -
*      <- Operacion: menos
38:       LDA       2,0(0)       carga parametro en llamada a funcion
39:       SUB       6,6,3      op: subir pila
40:       ST       2,0(6)      op: push en la pila tmp
26:       LDC       2,42(0)      Cargando verdareda linea de retorno :)
27:       SUB       6,6,3      op: subir pila
28:       ST       2,0(6)      op: push en la pila tmp
41:       LDC       7,4(0)      carga salto  4
42:       LDA       2,0(0)      Pasando operador izquierdo a la pila
43:       SUB       6,6,3      op: subir pila
44:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: menos
*      -> identificador
48:       LD       0,0(5)      cargar valor de identificador: n
*      <- identificador
49:       LDA       2,0(0)      Pasando operador izquierdo a la pila
50:       SUB       6,6,3      op: subir pila
51:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
52:       LDC       0,2(0)      cargar constante: 2
*      <- constante
53:       LD       2,0(6)      op: pop o cargo de la pila el valor
54:       ADD       6,6,3      op: bajar pila
55:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
56:       SUB       0,1,0      op: -
*      <- Operacion: menos
57:       LDA       2,0(0)       carga parametro en llamada a funcion
58:       SUB       6,6,3      op: subir pila
59:       ST       2,0(6)      op: push en la pila tmp
45:       LDC       2,61(0)      Cargando verdareda linea de retorno :)
46:       SUB       6,6,3      op: subir pila
47:       ST       2,0(6)      op: push en la pila tmp
60:       LDC       7,4(0)      carga salto  4
61:       LD       2,0(6)      op: pop o cargo de la pila el valor
62:       ADD       6,6,3      op: bajar pila
63:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
64:       ADD       0,1,0      op: +
*      <- Operacion: mas
65:       LD       2,0(6)      op: pop o cargo de la pila el valor
66:       ADD       6,6,3      op: bajar pila
67:       LDA       7,0(2)      Regreso a donde fui llamado
25:       LDA       7,42(7)      if: salto incondicional hacia el final
*      <- if
*      Bloque principal
3:       LDA       7,64(7)      bloque unico: jmp a bloque principal
*      -> for
*      -> asignacion
*      -> constante 0
68:       LDC       0,0(0)      cargar constante: 0
*      <- constante
69:       ST       0,1(5)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
70:       LD       0,1(5)      cargar valor de identificador: j
*      <- identificador
71:       LDA       2,0(0)      Pasando operador izquierdo a la pila
72:       SUB       6,6,3      op: subir pila
73:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
74:       LDC       0,1(0)      cargar constante: 1
*      <- constante
75:       LD       2,0(6)      op: pop o cargo de la pila el valor
76:       ADD       6,6,3      op: bajar pila
77:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
78:       ADD       0,1,0      op: +
*      <- Operacion: mas
79:       ST       0,1(5)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      -> escribir
*      -> identificador
83:       LD       0,1(5)      cargar valor de identificador: j
*      <- identificador
84:       LDA       2,0(0)       carga parametro en llamada a funcion
85:       SUB       6,6,3      op: subir pila
86:       ST       2,0(6)      op: push en la pila tmp
80:       LDC       2,88(0)      Cargando verdareda linea de retorno :)
81:       SUB       6,6,3      op: subir pila
82:       ST       2,0(6)      op: push en la pila tmp
87:       LDC       7,4(0)      carga salto  4
88:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> Operacion: menor
*      -> identificador
89:       LD       0,1(5)      cargar valor de identificador: j
*      <- identificador
90:       LDA       2,0(0)      Pasando operador izquierdo a la pila
91:       SUB       6,6,3      op: subir pila
92:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 10
93:       LDC       0,10(0)      cargar constante: 10
*      <- constante
94:       LD       2,0(6)      op: pop o cargo de la pila el valor
95:       ADD       6,6,3      op: bajar pila
96:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
97:       SUB       0,1,0      op: <
98:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
99:       LDC       0,0(0)      caso de falso (AC=0)
100:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
101:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
102:       JNE       0,-33(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      Fin de la ejecucion.
103:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
