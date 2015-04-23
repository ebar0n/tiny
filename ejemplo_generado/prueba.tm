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
*      bloque normal
*      -> asignacion
*      -> constante 1
4:       LDC       0,1(0)      cargar constante: 1
*      <- constante
5:       ST       0,0(5)      leer: almaceno el valor entero leido
*      <- asignacion
6:       LD       2,0(6)      op: pop o cargo de la pila el valor
7:       ADD       6,6,3      op: bajar pila
8:       ST       2,2(5)      Guardo en la direccion 2 b
9:       LD       2,0(6)      op: pop o cargo de la pila el valor
10:       ADD       6,6,3      op: bajar pila
11:       ST       2,1(5)      Guardo en la direccion 1 a
*      bloque normal
*      -> asignacion
*      -> constante 0
12:       LDC       0,0(0)      cargar constante: 0
*      <- constante
13:       ST       0,3(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
14:       LD       0,1(5)      cargar valor de identificador: a
*      <- identificador
15:       LDA       2,0(0)      Pasando operador izquierdo a la pila
16:       SUB       6,6,3      op: subir pila
17:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
18:       LD       0,2(5)      cargar valor de identificador: b
*      <- identificador
19:       LD       2,0(6)      op: pop o cargo de la pila el valor
20:       ADD       6,6,3      op: bajar pila
21:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
22:       ADD       0,1,0      op: +
*      <- Operacion: mas
23:       ST       0,3(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> identificador
24:       LD       0,3(5)      cargar valor de identificador: resultado
*      <- identificador
25:       LD       2,0(6)      op: pop o cargo de la pila el valor
26:       ADD       6,6,3      op: bajar pila
27:       LDA       7,0(2)      Regreso a donde fui llamado
*      Bloque principal
3:       LDA       7,24(7)      bloque unico: jmp a bloque principal
*      -> asignacion
*      -> constante 5
28:       LDC       0,5(0)      cargar constante: 5
*      <- constante
29:       LDA       2,0(0)      copiamos exprecion
30:       SUB       6,6,3      op: subir pila
31:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 0
32:       LDC       0,0(0)      cargar constante: 0
*      <- constante
33:       LD       2,0(6)      op: pop o cargo de la pila el valor
34:       ADD       6,6,3      op: bajar pila
35:       ST       2,4(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 7
36:       LDC       0,7(0)      cargar constante: 7
*      <- constante
37:       LDA       2,0(0)      copiamos exprecion
38:       SUB       6,6,3      op: subir pila
39:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
40:       LDC       0,1(0)      cargar constante: 1
*      <- constante
41:       LD       2,0(6)      op: pop o cargo de la pila el valor
42:       ADD       6,6,3      op: bajar pila
43:       ST       2,4(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 2
44:       LDC       0,2(0)      cargar constante: 2
*      <- constante
45:       LDA       2,0(0)      copiamos exprecion
46:       SUB       6,6,3      op: subir pila
47:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
48:       LDC       0,2(0)      cargar constante: 2
*      <- constante
49:       LD       2,0(6)      op: pop o cargo de la pila el valor
50:       ADD       6,6,3      op: bajar pila
51:       ST       2,4(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 9
52:       LDC       0,9(0)      cargar constante: 9
*      <- constante
53:       LDA       2,0(0)      copiamos exprecion
54:       SUB       6,6,3      op: subir pila
55:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
56:       LDC       0,3(0)      cargar constante: 3
*      <- constante
57:       LD       2,0(6)      op: pop o cargo de la pila el valor
58:       ADD       6,6,3      op: bajar pila
59:       ST       2,4(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> leer
*      -> constante 4
60:       LDC       0,4(0)      cargar constante: 4
*      <- constante
61:       LDA       1,0(0)      Regreso a donde fui llamado
62:       IN       0,0,0      leer: lee un valor entero 
63:       ST       0,4(1)      leer: almaceno el valor entero leido
*      <- leer
*      -> asignacion
*      -> constante 0
64:       LDC       0,0(0)      cargar constante: 0
*      <- constante
65:       ST       0,14(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 0
66:       LDC       0,0(0)      cargar constante: 0
*      <- constante
67:       ST       0,16(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> for
*      -> asignacion
*      -> constante 0
68:       LDC       0,0(0)      cargar constante: 0
*      <- constante
69:       ST       0,14(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> for
*      -> asignacion
*      -> constante 0
70:       LDC       0,0(0)      cargar constante: 0
*      <- constante
71:       ST       0,15(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> if
*      -> Operacion: menor
*      -> vector
*      -> Operacion: mas
*      -> identificador
72:       LD       0,15(5)      cargar valor de identificador: j
*      <- identificador
73:       LDA       2,0(0)      Pasando operador izquierdo a la pila
74:       SUB       6,6,3      op: subir pila
75:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
76:       LDC       0,1(0)      cargar constante: 1
*      <- constante
77:       LD       2,0(6)      op: pop o cargo de la pila el valor
78:       ADD       6,6,3      op: bajar pila
79:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
80:       ADD       0,1,0      op: +
*      <- Operacion: mas
81:       LD       0,4(0)      op: pop o cargo de la pila el valor
*      <- vector
82:       LDA       2,0(0)      Pasando operador izquierdo a la pila
83:       SUB       6,6,3      op: subir pila
84:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> identificador
85:       LD       0,15(5)      cargar valor de identificador: j
*      <- identificador
86:       LD       0,4(0)      op: pop o cargo de la pila el valor
*      <- vector
87:       LD       2,0(6)      op: pop o cargo de la pila el valor
88:       ADD       6,6,3      op: bajar pila
89:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
90:       SUB       0,1,0      op: <
91:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
92:       LDC       0,0(0)      caso de falso (AC=0)
93:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
94:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
*      If: el salto hacia el else debe estar aqui
*      -> asignacion
*      -> vector
*      -> Operacion: mas
*      -> identificador
96:       LD       0,15(5)      cargar valor de identificador: j
*      <- identificador
97:       LDA       2,0(0)      Pasando operador izquierdo a la pila
98:       SUB       6,6,3      op: subir pila
99:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
100:       LDC       0,1(0)      cargar constante: 1
*      <- constante
101:       LD       2,0(6)      op: pop o cargo de la pila el valor
102:       ADD       6,6,3      op: bajar pila
103:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
104:       ADD       0,1,0      op: +
*      <- Operacion: mas
105:       LD       0,4(0)      op: pop o cargo de la pila el valor
*      <- vector
106:       ST       0,16(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> vector
*      -> identificador
107:       LD       0,15(5)      cargar valor de identificador: j
*      <- identificador
108:       LD       0,4(0)      op: pop o cargo de la pila el valor
*      <- vector
109:       LDA       2,0(0)      copiamos exprecion
110:       SUB       6,6,3      op: subir pila
111:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: mas
*      -> identificador
112:       LD       0,15(5)      cargar valor de identificador: j
*      <- identificador
113:       LDA       2,0(0)      Pasando operador izquierdo a la pila
114:       SUB       6,6,3      op: subir pila
115:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
116:       LDC       0,1(0)      cargar constante: 1
*      <- constante
117:       LD       2,0(6)      op: pop o cargo de la pila el valor
118:       ADD       6,6,3      op: bajar pila
119:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
120:       ADD       0,1,0      op: +
*      <- Operacion: mas
121:       LD       2,0(6)      op: pop o cargo de la pila el valor
122:       ADD       6,6,3      op: bajar pila
123:       ST       2,4(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> identificador
124:       LD       0,16(5)      cargar valor de identificador: aux
*      <- identificador
125:       LDA       2,0(0)      copiamos exprecion
126:       SUB       6,6,3      op: subir pila
127:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
128:       LD       0,15(5)      cargar valor de identificador: j
*      <- identificador
129:       LD       2,0(6)      op: pop o cargo de la pila el valor
130:       ADD       6,6,3      op: bajar pila
131:       ST       2,4(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      If: el salto hacia el final debe estar aqui
95:       JEQ       0,37(7)      if: jmp hacia else
132:       LDA       7,0(7)      if: salto incondicional hacia el final
*      <- if
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
133:       LD       0,15(5)      cargar valor de identificador: j
*      <- identificador
134:       LDA       2,0(0)      Pasando operador izquierdo a la pila
135:       SUB       6,6,3      op: subir pila
136:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
137:       LDC       0,1(0)      cargar constante: 1
*      <- constante
138:       LD       2,0(6)      op: pop o cargo de la pila el valor
139:       ADD       6,6,3      op: bajar pila
140:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
141:       ADD       0,1,0      op: +
*      <- Operacion: mas
142:       ST       0,15(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
143:       LD       0,15(5)      cargar valor de identificador: j
*      <- identificador
144:       LDA       2,0(0)      Pasando operador izquierdo a la pila
145:       SUB       6,6,3      op: subir pila
146:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 4
147:       LDC       0,4(0)      cargar constante: 4
*      <- constante
148:       LD       2,0(6)      op: pop o cargo de la pila el valor
149:       ADD       6,6,3      op: bajar pila
150:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
151:       SUB       0,1,0      op: <
152:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
153:       LDC       0,0(0)      caso de falso (AC=0)
154:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
155:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
156:       JNE       0,-85(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
157:       LD       0,14(5)      cargar valor de identificador: i
*      <- identificador
158:       LDA       2,0(0)      Pasando operador izquierdo a la pila
159:       SUB       6,6,3      op: subir pila
160:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
161:       LDC       0,1(0)      cargar constante: 1
*      <- constante
162:       LD       2,0(6)      op: pop o cargo de la pila el valor
163:       ADD       6,6,3      op: bajar pila
164:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
165:       ADD       0,1,0      op: +
*      <- Operacion: mas
166:       ST       0,14(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
167:       LD       0,14(5)      cargar valor de identificador: i
*      <- identificador
168:       LDA       2,0(0)      Pasando operador izquierdo a la pila
169:       SUB       6,6,3      op: subir pila
170:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
171:       LDC       0,5(0)      cargar constante: 5
*      <- constante
172:       LD       2,0(6)      op: pop o cargo de la pila el valor
173:       ADD       6,6,3      op: bajar pila
174:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
175:       SUB       0,1,0      op: <
176:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
177:       LDC       0,0(0)      caso de falso (AC=0)
178:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
179:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
180:       JNE       0,-111(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> for
*      -> asignacion
*      -> constante 0
181:       LDC       0,0(0)      cargar constante: 0
*      <- constante
182:       ST       0,14(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> escribir
*      -> vector
*      -> identificador
183:       LD       0,14(5)      cargar valor de identificador: i
*      <- identificador
184:       LD       0,4(0)      op: pop o cargo de la pila el valor
*      <- vector
185:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
186:       LD       0,14(5)      cargar valor de identificador: i
*      <- identificador
187:       LDA       2,0(0)      Pasando operador izquierdo a la pila
188:       SUB       6,6,3      op: subir pila
189:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
190:       LDC       0,1(0)      cargar constante: 1
*      <- constante
191:       LD       2,0(6)      op: pop o cargo de la pila el valor
192:       ADD       6,6,3      op: bajar pila
193:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
194:       ADD       0,1,0      op: +
*      <- Operacion: mas
195:       ST       0,14(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
196:       LD       0,14(5)      cargar valor de identificador: i
*      <- identificador
197:       LDA       2,0(0)      Pasando operador izquierdo a la pila
198:       SUB       6,6,3      op: subir pila
199:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
200:       LDC       0,5(0)      cargar constante: 5
*      <- constante
201:       LD       2,0(6)      op: pop o cargo de la pila el valor
202:       ADD       6,6,3      op: bajar pila
203:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
204:       SUB       0,1,0      op: <
205:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
206:       LDC       0,0(0)      caso de falso (AC=0)
207:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
208:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
209:       JNE       0,-27(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      Fin de la ejecucion.
210:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
