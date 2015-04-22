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
6:       ST       2,1(5)      Guardo en la direccion 1 b
7:       LD       2,0(6)      op: pop o cargo de la pila el valor
8:       ADD       6,6,3      op: bajar pila
9:       ST       2,0(5)      Guardo en la direccion 0 a
*      bloque normal
10:       LD       2,0(6)      op: pop o cargo de la pila el valor
11:       ADD       6,6,3      op: bajar pila
12:       LDA       4,0(2)      Paso ubicacion de retorno
*      -> Operacion: mas
*      -> identificador
13:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
14:       LDA       2,0(0)      Pasando operador izquierdo a la pila
15:       SUB       6,6,3      op: subir pila
16:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
17:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
18:       LD       2,0(6)      op: pop o cargo de la pila el valor
19:       ADD       6,6,3      op: bajar pila
20:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
21:       ADD       0,1,0      op: +
*      <- Operacion: mas
22:       LDA       7,0(4)      Regreso a donde fui llamado
23:       LD       2,0(6)      op: pop o cargo de la pila el valor
24:       ADD       6,6,3      op: bajar pila
25:       ST       2,2(5)      Guardo en la direccion 2 a
*      bloque normal
*      -> escribir
*      -> identificador
26:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
27:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> Operacion: por
*      -> identificador
28:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
29:       LDA       2,0(0)      Pasando operador izquierdo a la pila
30:       SUB       6,6,3      op: subir pila
31:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
35:       LDC       0,1(0)      cargar constante: 1
*      <- constante
36:       LDA       2,0(0)       carga parametro en llamada a funcion
37:       SUB       6,6,3      op: subir pila
38:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
42:       LDC       0,2(0)      cargar constante: 2
*      <- constante
43:       LDA       2,0(0)       carga parametro en llamada a funcion
44:       SUB       6,6,3      op: subir pila
45:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
49:       LDC       0,3(0)      cargar constante: 3
*      <- constante
50:       LDA       2,0(0)       carga parametro en llamada a funcion
51:       SUB       6,6,3      op: subir pila
52:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 4
56:       LDC       0,4(0)      cargar constante: 4
*      <- constante
57:       LDA       2,0(0)       carga parametro en llamada a funcion
58:       SUB       6,6,3      op: subir pila
59:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
60:       LDC       0,5(0)      cargar constante: 5
*      <- constante
61:       LDA       2,0(0)       carga parametro en llamada a funcion
62:       SUB       6,6,3      op: subir pila
63:       ST       2,0(6)      op: push en la pila tmp
53:       LDC       2,65(0)      Cargando verdareda linea de retorno :)
54:       SUB       6,6,3      op: subir pila
55:       ST       2,0(6)      op: push en la pila tmp
64:       LDC       7,4(0)      carga salto  4
65:       LDA       2,0(0)       carga parametro en llamada a funcion
66:       SUB       6,6,3      op: subir pila
67:       ST       2,0(6)      op: push en la pila tmp
46:       LDC       2,69(0)      Cargando verdareda linea de retorno :)
47:       SUB       6,6,3      op: subir pila
48:       ST       2,0(6)      op: push en la pila tmp
68:       LDC       7,4(0)      carga salto  4
69:       LDA       2,0(0)       carga parametro en llamada a funcion
70:       SUB       6,6,3      op: subir pila
71:       ST       2,0(6)      op: push en la pila tmp
39:       LDC       2,73(0)      Cargando verdareda linea de retorno :)
40:       SUB       6,6,3      op: subir pila
41:       ST       2,0(6)      op: push en la pila tmp
72:       LDC       7,4(0)      carga salto  4
73:       LDA       2,0(0)       carga parametro en llamada a funcion
74:       SUB       6,6,3      op: subir pila
75:       ST       2,0(6)      op: push en la pila tmp
32:       LDC       2,77(0)      Cargando verdareda linea de retorno :)
33:       SUB       6,6,3      op: subir pila
34:       ST       2,0(6)      op: push en la pila tmp
76:       LDC       7,4(0)      carga salto  4
77:       LD       2,0(6)      op: pop o cargo de la pila el valor
78:       ADD       6,6,3      op: bajar pila
79:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
80:       MUL       0,1,0      op: *
*      <- Operacion: por
81:       ST       0,2(5)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> escribir
*      -> Operacion: por
*      -> identificador
82:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
83:       LDA       2,0(0)      Pasando operador izquierdo a la pila
84:       SUB       6,6,3      op: subir pila
85:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
86:       LDC       0,2(0)      cargar constante: 2
*      <- constante
87:       LD       2,0(6)      op: pop o cargo de la pila el valor
88:       ADD       6,6,3      op: bajar pila
89:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
90:       MUL       0,1,0      op: *
*      <- Operacion: por
91:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
92:       LD       2,0(6)      op: pop o cargo de la pila el valor
93:       ADD       6,6,3      op: bajar pila
94:       LDA       4,0(2)      Paso ubicacion de retorno
95:       LDA       7,0(4)      Regreso a donde fui llamado sin devolver nada
*      Bloque principal
3:       LDA       7,92(7)      bloque unico: jmp a bloque principal
*      -> asignacion
*      -> Operacion: por
*      -> constante 1
96:       LDC       0,1(0)      cargar constante: 1
*      <- constante
97:       LDA       2,0(0)      Pasando operador izquierdo a la pila
98:       SUB       6,6,3      op: subir pila
99:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
100:       LDC       0,3(0)      cargar constante: 3
*      <- constante
101:       LD       2,0(6)      op: pop o cargo de la pila el valor
102:       ADD       6,6,3      op: bajar pila
103:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
104:       MUL       0,1,0      op: *
*      <- Operacion: por
105:       ST       0,3(5)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      -> escribir
*      -> identificador
106:       LD       0,3(5)      cargar valor de identificador: j
*      <- identificador
107:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> identificador
111:       LD       0,3(5)      cargar valor de identificador: j
*      <- identificador
112:       LDA       2,0(0)       carga parametro en llamada a funcion
113:       SUB       6,6,3      op: subir pila
114:       ST       2,0(6)      op: push en la pila tmp
108:       LDC       2,116(0)      Cargando verdareda linea de retorno :)
109:       SUB       6,6,3      op: subir pila
110:       ST       2,0(6)      op: push en la pila tmp
115:       LDC       7,23(0)      carga salto  23
*      Fin de la ejecucion.
116:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
