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
6:       LDA       4,0(2)      Paso ubicacion de retorno
7:       LD       2,0(6)      op: pop o cargo de la pila el valor
8:       ADD       6,6,3      op: bajar pila
9:       ST       2,1(5)      Guardo en la direccion 1 b
10:       LD       2,0(6)      op: pop o cargo de la pila el valor
11:       ADD       6,6,3      op: bajar pila
12:       ST       2,0(5)      Guardo en la direccion 0 a
*      bloque normal
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
25:       LDA       4,0(2)      Paso ubicacion de retorno
26:       LD       2,0(6)      op: pop o cargo de la pila el valor
27:       ADD       6,6,3      op: bajar pila
28:       ST       2,2(5)      Guardo en la direccion 2 a
*      bloque normal
*      -> escribir
*      -> identificador
29:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
30:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> Operacion: por
*      -> identificador
31:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
32:       LDA       2,0(0)      Pasando operador izquierdo a la pila
33:       SUB       6,6,3      op: subir pila
34:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
35:       LDC       0,1(0)      cargar constante: 1
*      <- constante
36:       LDA       2,0(0)       carga parametro en llamada a funcion
37:       SUB       6,6,3      op: subir pila
38:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
39:       LDC       0,2(0)      cargar constante: 2
*      <- constante
40:       LDA       2,0(0)       carga parametro en llamada a funcion
41:       SUB       6,6,3      op: subir pila
42:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
43:       LDC       0,3(0)      cargar constante: 3
*      <- constante
44:       LDA       2,0(0)       carga parametro en llamada a funcion
45:       SUB       6,6,3      op: subir pila
46:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 4
47:       LDC       0,4(0)      cargar constante: 4
*      <- constante
48:       LDA       2,0(0)       carga parametro en llamada a funcion
49:       SUB       6,6,3      op: subir pila
50:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
51:       LDC       0,5(0)      cargar constante: 5
*      <- constante
52:       LDA       2,0(0)       carga parametro en llamada a funcion
53:       SUB       6,6,3      op: subir pila
54:       ST       2,0(6)      op: push en la pila tmp
55:       LDC       2,59(0)      Cargando verdareda linea de retorno
56:       SUB       6,6,3      op: subir pila
57:       ST       2,0(6)      op: push en la pila tmp
58:       LDC       7,4(0)      carga salto  4
59:       LDA       2,0(0)       carga parametro en llamada a funcion
60:       SUB       6,6,3      op: subir pila
61:       ST       2,0(6)      op: push en la pila tmp
62:       LDC       2,66(0)      Cargando verdareda linea de retorno
63:       SUB       6,6,3      op: subir pila
64:       ST       2,0(6)      op: push en la pila tmp
65:       LDC       7,4(0)      carga salto  4
66:       LDA       2,0(0)       carga parametro en llamada a funcion
67:       SUB       6,6,3      op: subir pila
68:       ST       2,0(6)      op: push en la pila tmp
69:       LDC       2,73(0)      Cargando verdareda linea de retorno
70:       SUB       6,6,3      op: subir pila
71:       ST       2,0(6)      op: push en la pila tmp
72:       LDC       7,4(0)      carga salto  4
73:       LDA       2,0(0)       carga parametro en llamada a funcion
74:       SUB       6,6,3      op: subir pila
75:       ST       2,0(6)      op: push en la pila tmp
76:       LDC       2,80(0)      Cargando verdareda linea de retorno
77:       SUB       6,6,3      op: subir pila
78:       ST       2,0(6)      op: push en la pila tmp
79:       LDC       7,4(0)      carga salto  4
80:       LD       2,0(6)      op: pop o cargo de la pila el valor
81:       ADD       6,6,3      op: bajar pila
82:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
83:       MUL       0,1,0      op: *
*      <- Operacion: por
84:       ST       0,2(5)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> escribir
*      -> Operacion: por
*      -> identificador
85:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
86:       LDA       2,0(0)      Pasando operador izquierdo a la pila
87:       SUB       6,6,3      op: subir pila
88:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
89:       LDC       0,2(0)      cargar constante: 2
*      <- constante
90:       LD       2,0(6)      op: pop o cargo de la pila el valor
91:       ADD       6,6,3      op: bajar pila
92:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
93:       MUL       0,1,0      op: *
*      <- Operacion: por
94:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
95:       LDA       7,0(4)      Regreso a donde fui llamado sin devolver nada
*      Bloque principal
3:       LDA       7,92(7)      bloque unico: jmp a bloque principal
*      -> asignacion
*      -> constante 1
96:       LDC       0,1(0)      cargar constante: 1
*      <- constante
97:       LDA       2,0(0)       carga parametro en llamada a funcion
98:       SUB       6,6,3      op: subir pila
99:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
100:       LDC       0,2(0)      cargar constante: 2
*      <- constante
101:       LDA       2,0(0)       carga parametro en llamada a funcion
102:       SUB       6,6,3      op: subir pila
103:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
104:       LDC       0,3(0)      cargar constante: 3
*      <- constante
105:       LDA       2,0(0)       carga parametro en llamada a funcion
106:       SUB       6,6,3      op: subir pila
107:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 4
108:       LDC       0,4(0)      cargar constante: 4
*      <- constante
109:       LDA       2,0(0)       carga parametro en llamada a funcion
110:       SUB       6,6,3      op: subir pila
111:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
112:       LDC       0,5(0)      cargar constante: 5
*      <- constante
113:       LDA       2,0(0)       carga parametro en llamada a funcion
114:       SUB       6,6,3      op: subir pila
115:       ST       2,0(6)      op: push en la pila tmp
116:       LDC       2,120(0)      Cargando verdareda linea de retorno
117:       SUB       6,6,3      op: subir pila
118:       ST       2,0(6)      op: push en la pila tmp
119:       LDC       7,4(0)      carga salto  4
120:       LDA       2,0(0)       carga parametro en llamada a funcion
121:       SUB       6,6,3      op: subir pila
122:       ST       2,0(6)      op: push en la pila tmp
123:       LDC       2,127(0)      Cargando verdareda linea de retorno
124:       SUB       6,6,3      op: subir pila
125:       ST       2,0(6)      op: push en la pila tmp
126:       LDC       7,4(0)      carga salto  4
127:       LDA       2,0(0)       carga parametro en llamada a funcion
128:       SUB       6,6,3      op: subir pila
129:       ST       2,0(6)      op: push en la pila tmp
130:       LDC       2,134(0)      Cargando verdareda linea de retorno
131:       SUB       6,6,3      op: subir pila
132:       ST       2,0(6)      op: push en la pila tmp
133:       LDC       7,4(0)      carga salto  4
134:       LDA       2,0(0)       carga parametro en llamada a funcion
135:       SUB       6,6,3      op: subir pila
136:       ST       2,0(6)      op: push en la pila tmp
137:       LDC       2,141(0)      Cargando verdareda linea de retorno
138:       SUB       6,6,3      op: subir pila
139:       ST       2,0(6)      op: push en la pila tmp
140:       LDC       7,4(0)      carga salto  4
141:       ST       0,3(5)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      -> identificador
142:       LD       0,3(5)      cargar valor de identificador: j
*      <- identificador
143:       LDA       2,0(0)       carga parametro en llamada a funcion
144:       SUB       6,6,3      op: subir pila
145:       ST       2,0(6)      op: push en la pila tmp
146:       LDC       2,150(0)      Cargando verdareda linea de retorno
147:       SUB       6,6,3      op: subir pila
148:       ST       2,0(6)      op: push en la pila tmp
149:       LDC       7,23(0)      carga salto  23
*      Fin de la ejecucion.
150:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
