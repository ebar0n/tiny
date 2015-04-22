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
64:       LDC       2,68(0)      Cargando verdareda linea de retorno
65:       SUB       6,6,3      op: subir pila
66:       ST       2,0(6)      op: push en la pila tmp
67:       LDC       7,4(0)      carga salto  4
68:       LDA       2,0(0)       carga parametro en llamada a funcion
69:       SUB       6,6,3      op: subir pila
70:       ST       2,0(6)      op: push en la pila tmp
71:       LDC       2,75(0)      Cargando verdareda linea de retorno
72:       SUB       6,6,3      op: subir pila
73:       ST       2,0(6)      op: push en la pila tmp
74:       LDC       7,4(0)      carga salto  4
75:       LDA       2,0(0)       carga parametro en llamada a funcion
76:       SUB       6,6,3      op: subir pila
77:       ST       2,0(6)      op: push en la pila tmp
78:       LDC       2,82(0)      Cargando verdareda linea de retorno
79:       SUB       6,6,3      op: subir pila
80:       ST       2,0(6)      op: push en la pila tmp
81:       LDC       7,4(0)      carga salto  4
82:       LDA       2,0(0)       carga parametro en llamada a funcion
83:       SUB       6,6,3      op: subir pila
84:       ST       2,0(6)      op: push en la pila tmp
85:       LDC       2,89(0)      Cargando verdareda linea de retorno
86:       SUB       6,6,3      op: subir pila
87:       ST       2,0(6)      op: push en la pila tmp
88:       LDC       7,4(0)      carga salto  4
89:       LD       2,0(6)      op: pop o cargo de la pila el valor
90:       ADD       6,6,3      op: bajar pila
91:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
92:       MUL       0,1,0      op: *
*      <- Operacion: por
93:       ST       0,2(5)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> escribir
*      -> Operacion: por
*      -> identificador
94:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
95:       LDA       2,0(0)      Pasando operador izquierdo a la pila
96:       SUB       6,6,3      op: subir pila
97:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
98:       LDC       0,2(0)      cargar constante: 2
*      <- constante
99:       LD       2,0(6)      op: pop o cargo de la pila el valor
100:       ADD       6,6,3      op: bajar pila
101:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
102:       MUL       0,1,0      op: *
*      <- Operacion: por
103:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
104:       LD       2,0(6)      op: pop o cargo de la pila el valor
105:       ADD       6,6,3      op: bajar pila
106:       LDA       4,0(2)      Paso ubicacion de retorno
107:       LDA       7,0(4)      Regreso a donde fui llamado sin devolver nada
*      Bloque principal
3:       LDA       7,104(7)      bloque unico: jmp a bloque principal
*      -> asignacion
*      -> Operacion: por
*      -> constante 1
108:       LDC       0,1(0)      cargar constante: 1
*      <- constante
109:       LDA       2,0(0)      Pasando operador izquierdo a la pila
110:       SUB       6,6,3      op: subir pila
111:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
112:       LDC       0,3(0)      cargar constante: 3
*      <- constante
113:       LD       2,0(6)      op: pop o cargo de la pila el valor
114:       ADD       6,6,3      op: bajar pila
115:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
116:       MUL       0,1,0      op: *
*      <- Operacion: por
117:       ST       0,3(5)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      -> escribir
*      -> identificador
118:       LD       0,3(5)      cargar valor de identificador: j
*      <- identificador
119:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> identificador
123:       LD       0,3(5)      cargar valor de identificador: j
*      <- identificador
124:       LDA       2,0(0)       carga parametro en llamada a funcion
125:       SUB       6,6,3      op: subir pila
126:       ST       2,0(6)      op: push en la pila tmp
127:       LDC       2,131(0)      Cargando verdareda linea de retorno
128:       SUB       6,6,3      op: subir pila
129:       ST       2,0(6)      op: push en la pila tmp
130:       LDC       7,23(0)      carga salto  23
*      Fin de la ejecucion.
131:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------