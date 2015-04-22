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
81:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
82:       SUB       6,6,3      op: subir pila
83:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
84:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
85:       LD       2,0(6)      op: pop o cargo de la pila el valor
86:       ADD       6,6,3      op: bajar pila
87:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> escribir
*      -> Operacion: por
*      -> identificador
88:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
89:       LDA       2,0(0)      Pasando operador izquierdo a la pila
90:       SUB       6,6,3      op: subir pila
91:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
92:       LDC       0,2(0)      cargar constante: 2
*      <- constante
93:       LD       2,0(6)      op: pop o cargo de la pila el valor
94:       ADD       6,6,3      op: bajar pila
95:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
96:       MUL       0,1,0      op: *
*      <- Operacion: por
97:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
98:       LD       2,0(6)      op: pop o cargo de la pila el valor
99:       ADD       6,6,3      op: bajar pila
100:       LDA       4,0(2)      Paso ubicacion de retorno
101:       LDA       7,0(4)      Regreso a donde fui llamado sin devolver nada
*      Bloque principal
3:       LDA       7,98(7)      bloque unico: jmp a bloque principal
*      -> asignacion
*      -> Operacion: por
*      -> constante 1
102:       LDC       0,1(0)      cargar constante: 1
*      <- constante
103:       LDA       2,0(0)      Pasando operador izquierdo a la pila
104:       SUB       6,6,3      op: subir pila
105:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
106:       LDC       0,3(0)      cargar constante: 3
*      <- constante
107:       LD       2,0(6)      op: pop o cargo de la pila el valor
108:       ADD       6,6,3      op: bajar pila
109:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
110:       MUL       0,1,0      op: *
*      <- Operacion: por
111:       LDA       2,0(0)      asignacion: almaceno el valor para el id j
112:       SUB       6,6,3      op: subir pila
113:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
114:       LD       0,3(5)      cargar valor de identificador: j
*      <- identificador
115:       LD       2,0(6)      op: pop o cargo de la pila el valor
116:       ADD       6,6,3      op: bajar pila
117:       ST       2,0(1)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      -> asignacion
*      -> constante 1
118:       LDC       0,1(0)      cargar constante: 1
*      <- constante
119:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
120:       SUB       6,6,3      op: subir pila
121:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 0
122:       LDC       0,0(0)      cargar constante: 0
*      <- constante
123:       ADD       1,5,0      sumar desplazamiendo al registro L3
124:       LD       0,4(1)      cargar valor de identificador: a
*      <- vector
125:       LD       2,0(6)      op: pop o cargo de la pila el valor
126:       ADD       6,6,3      op: bajar pila
127:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> constante 4
128:       LDC       0,4(0)      cargar constante: 4
*      <- constante
129:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
130:       SUB       6,6,3      op: subir pila
131:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 3
132:       LDC       0,3(0)      cargar constante: 3
*      <- constante
133:       ADD       1,5,0      sumar desplazamiendo al registro L3
134:       LD       0,4(1)      cargar valor de identificador: a
*      <- vector
135:       LD       2,0(6)      op: pop o cargo de la pila el valor
136:       ADD       6,6,3      op: bajar pila
137:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> constante 2
138:       LDC       0,2(0)      cargar constante: 2
*      <- constante
139:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
140:       SUB       6,6,3      op: subir pila
141:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 1
142:       LDC       0,1(0)      cargar constante: 1
*      <- constante
143:       ADD       1,5,0      sumar desplazamiendo al registro L3
144:       LD       0,4(1)      cargar valor de identificador: a
*      <- vector
145:       LD       2,0(6)      op: pop o cargo de la pila el valor
146:       ADD       6,6,3      op: bajar pila
147:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> constante 3
148:       LDC       0,3(0)      cargar constante: 3
*      <- constante
149:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
150:       SUB       6,6,3      op: subir pila
151:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 2
152:       LDC       0,2(0)      cargar constante: 2
*      <- constante
153:       ADD       1,5,0      sumar desplazamiendo al registro L3
154:       LD       0,4(1)      cargar valor de identificador: a
*      <- vector
155:       LD       2,0(6)      op: pop o cargo de la pila el valor
156:       ADD       6,6,3      op: bajar pila
157:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> vector
*      -> constante 3
158:       LDC       0,3(0)      cargar constante: 3
*      <- constante
159:       ADD       1,5,0      sumar desplazamiendo al registro L3
160:       LD       0,4(1)      cargar valor de identificador: a
161:       LDA       0,0(0)      cargar valor de identificador: a
*      <- vector
162:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
163:       SUB       6,6,3      op: subir pila
164:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 4
165:       LDC       0,4(0)      cargar constante: 4
*      <- constante
166:       ADD       1,5,0      sumar desplazamiendo al registro L3
167:       LD       0,4(1)      cargar valor de identificador: a
*      <- vector
168:       LD       2,0(6)      op: pop o cargo de la pila el valor
169:       ADD       6,6,3      op: bajar pila
170:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> escribir
*      -> vector
*      -> constante 2
171:       LDC       0,2(0)      cargar constante: 2
*      <- constante
172:       ADD       1,5,0      sumar desplazamiendo al registro L3
173:       LD       0,4(1)      cargar valor de identificador: a
*      <- vector
174:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> vector
*      -> constante 2
178:       LDC       0,2(0)      cargar constante: 2
*      <- constante
179:       ADD       1,5,0      sumar desplazamiendo al registro L3
180:       LD       0,4(1)      cargar valor de identificador: a
*      <- vector
181:       LDA       2,0(0)       carga parametro en llamada a funcion
182:       SUB       6,6,3      op: subir pila
183:       ST       2,0(6)      op: push en la pila tmp
175:       LDC       2,185(0)      Cargando verdareda linea de retorno :)
176:       SUB       6,6,3      op: subir pila
177:       ST       2,0(6)      op: push en la pila tmp
184:       LDC       7,23(0)      carga salto  23
*      Fin de la ejecucion.
185:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
