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
*      bloque normal
*      -> asignacion
*      -> constante 0
28:       LDC       0,0(0)      cargar constante: 0
*      <- constante
29:       ST       0,4(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> for
*      -> asignacion
*      -> constante 0
30:       LDC       0,0(0)      cargar constante: 0
*      <- constante
31:       ST       0,5(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> if
*      -> Operacion: mayor
*      -> vector
*      -> identificador
32:       LD       0,5(5)      cargar valor de identificador: i
*      <- identificador
33:       LD       0,11(0)      op: pop o cargo de la pila el valor
*      <- vector
34:       LDA       2,0(0)      Pasando operador izquierdo a la pila
35:       SUB       6,6,3      op: subir pila
36:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
37:       LD       0,4(5)      cargar valor de identificador: ma
*      <- identificador
38:       LD       2,0(6)      op: pop o cargo de la pila el valor
39:       ADD       6,6,3      op: bajar pila
40:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
41:       SUB       0,1,0      op: >
42:       JGT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC>0)
43:       LDC       0,0(0)      caso de falso (AC=0)
44:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
45:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: mayor
*      If: el salto hacia el else debe estar aqui
*      -> asignacion
*      -> vector
*      -> identificador
47:       LD       0,5(5)      cargar valor de identificador: i
*      <- identificador
48:       LD       0,11(0)      op: pop o cargo de la pila el valor
*      <- vector
49:       ST       0,4(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      If: el salto hacia el final debe estar aqui
46:       JEQ       0,4(7)      if: jmp hacia else
50:       LDA       7,0(7)      if: salto incondicional hacia el final
*      <- if
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
51:       LD       0,5(5)      cargar valor de identificador: i
*      <- identificador
52:       LDA       2,0(0)      Pasando operador izquierdo a la pila
53:       SUB       6,6,3      op: subir pila
54:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
55:       LDC       0,1(0)      cargar constante: 1
*      <- constante
56:       LD       2,0(6)      op: pop o cargo de la pila el valor
57:       ADD       6,6,3      op: bajar pila
58:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
59:       ADD       0,1,0      op: +
*      <- Operacion: mas
60:       ST       0,5(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
61:       LD       0,5(5)      cargar valor de identificador: i
*      <- identificador
62:       LDA       2,0(0)      Pasando operador izquierdo a la pila
63:       SUB       6,6,3      op: subir pila
64:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 10
65:       LDC       0,10(0)      cargar constante: 10
*      <- constante
66:       LD       2,0(6)      op: pop o cargo de la pila el valor
67:       ADD       6,6,3      op: bajar pila
68:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
69:       SUB       0,1,0      op: <
70:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
71:       LDC       0,0(0)      caso de falso (AC=0)
72:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
73:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
74:       JNE       0,-43(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> identificador
75:       LD       0,4(5)      cargar valor de identificador: ma
*      <- identificador
76:       LD       2,0(6)      op: pop o cargo de la pila el valor
77:       ADD       6,6,3      op: bajar pila
78:       LDA       7,0(2)      Regreso a donde fui llamado
*      bloque normal
*      -> asignacion
*      -> constante 999
79:       LDC       0,999(0)      cargar constante: 999
*      <- constante
80:       ST       0,6(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> for
*      -> asignacion
*      -> constante 0
81:       LDC       0,0(0)      cargar constante: 0
*      <- constante
82:       ST       0,7(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> if
*      -> Operacion: menori
*      -> vector
*      -> identificador
83:       LD       0,7(5)      cargar valor de identificador: i
*      <- identificador
84:       LD       0,11(0)      op: pop o cargo de la pila el valor
*      <- vector
85:       LDA       2,0(0)      Pasando operador izquierdo a la pila
86:       SUB       6,6,3      op: subir pila
87:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
88:       LD       0,6(5)      cargar valor de identificador: me
*      <- identificador
89:       LD       2,0(6)      op: pop o cargo de la pila el valor
90:       ADD       6,6,3      op: bajar pila
91:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
92:       SUB       0,1,0      op: <=
93:       JLE       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0 || AC==0)
94:       LDC       0,0(0)      caso de falso (AC=0)
95:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
96:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menori
*      If: el salto hacia el else debe estar aqui
*      -> asignacion
*      -> vector
*      -> identificador
98:       LD       0,7(5)      cargar valor de identificador: i
*      <- identificador
99:       LD       0,11(0)      op: pop o cargo de la pila el valor
*      <- vector
100:       ST       0,6(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      If: el salto hacia el final debe estar aqui
97:       JEQ       0,4(7)      if: jmp hacia else
101:       LDA       7,0(7)      if: salto incondicional hacia el final
*      <- if
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
102:       LD       0,7(5)      cargar valor de identificador: i
*      <- identificador
103:       LDA       2,0(0)      Pasando operador izquierdo a la pila
104:       SUB       6,6,3      op: subir pila
105:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
106:       LDC       0,1(0)      cargar constante: 1
*      <- constante
107:       LD       2,0(6)      op: pop o cargo de la pila el valor
108:       ADD       6,6,3      op: bajar pila
109:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
110:       ADD       0,1,0      op: +
*      <- Operacion: mas
111:       ST       0,7(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
112:       LD       0,7(5)      cargar valor de identificador: i
*      <- identificador
113:       LDA       2,0(0)      Pasando operador izquierdo a la pila
114:       SUB       6,6,3      op: subir pila
115:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
116:       LDC       0,5(0)      cargar constante: 5
*      <- constante
117:       LD       2,0(6)      op: pop o cargo de la pila el valor
118:       ADD       6,6,3      op: bajar pila
119:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
120:       SUB       0,1,0      op: <
121:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
122:       LDC       0,0(0)      caso de falso (AC=0)
123:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
124:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
125:       JNE       0,-43(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> identificador
126:       LD       0,6(5)      cargar valor de identificador: me
*      <- identificador
127:       LD       2,0(6)      op: pop o cargo de la pila el valor
128:       ADD       6,6,3      op: bajar pila
129:       LDA       7,0(2)      Regreso a donde fui llamado
*      bloque normal
*      -> asignacion
*      -> Operacion: por
*      -> Operacion: menos
*      -> Operacion: mas
*      -> Operacion: por
*      -> constante -1
130:       LDC       0,-1(0)      cargar constante: -1
*      <- constante
131:       LDA       2,0(0)      Pasando operador izquierdo a la pila
132:       SUB       6,6,3      op: subir pila
133:       ST       2,0(6)      op: push en la pila tmp
*      -> constante -5
134:       LDC       0,-5(0)      cargar constante: -5
*      <- constante
135:       LD       2,0(6)      op: pop o cargo de la pila el valor
136:       ADD       6,6,3      op: bajar pila
137:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
138:       MUL       0,1,0      op: *
*      <- Operacion: por
139:       LDA       2,0(0)      Pasando operador izquierdo a la pila
140:       SUB       6,6,3      op: subir pila
141:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: por
*      -> constante 2
142:       LDC       0,2(0)      cargar constante: 2
*      <- constante
143:       LDA       2,0(0)      Pasando operador izquierdo a la pila
144:       SUB       6,6,3      op: subir pila
145:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 4
146:       LDC       0,4(0)      cargar constante: 4
*      <- constante
147:       LD       2,0(6)      op: pop o cargo de la pila el valor
148:       ADD       6,6,3      op: bajar pila
149:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
150:       MUL       0,1,0      op: *
*      <- Operacion: por
151:       LD       2,0(6)      op: pop o cargo de la pila el valor
152:       ADD       6,6,3      op: bajar pila
153:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
154:       ADD       0,1,0      op: +
*      <- Operacion: mas
155:       LDA       2,0(0)      Pasando operador izquierdo a la pila
156:       SUB       6,6,3      op: subir pila
157:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: por
*      -> constante 5
158:       LDC       0,5(0)      cargar constante: 5
*      <- constante
159:       LDA       2,0(0)      Pasando operador izquierdo a la pila
160:       SUB       6,6,3      op: subir pila
161:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 4
162:       LDC       0,4(0)      cargar constante: 4
*      <- constante
163:       LD       2,0(6)      op: pop o cargo de la pila el valor
164:       ADD       6,6,3      op: bajar pila
165:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
166:       MUL       0,1,0      op: *
*      <- Operacion: por
167:       LD       2,0(6)      op: pop o cargo de la pila el valor
168:       ADD       6,6,3      op: bajar pila
169:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
170:       SUB       0,1,0      op: -
*      <- Operacion: menos
171:       LDA       2,0(0)      Pasando operador izquierdo a la pila
172:       SUB       6,6,3      op: subir pila
173:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
174:       LDC       0,2(0)      cargar constante: 2
*      <- constante
175:       LD       2,0(6)      op: pop o cargo de la pila el valor
176:       ADD       6,6,3      op: bajar pila
177:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
178:       MUL       0,1,0      op: *
*      <- Operacion: por
179:       ST       0,8(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> identificador
180:       LD       0,8(5)      cargar valor de identificador: neg
*      <- identificador
181:       LD       2,0(6)      op: pop o cargo de la pila el valor
182:       ADD       6,6,3      op: bajar pila
183:       LDA       7,0(2)      Regreso a donde fui llamado
*      bloque normal
*      -> asignacion
*      -> constante 10
184:       LDC       0,10(0)      cargar constante: 10
*      <- constante
185:       ST       0,9(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 20
186:       LDC       0,20(0)      cargar constante: 20
*      <- constante
187:       ST       0,10(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> if
*      -> Operacion: menori
*      -> identificador
188:       LD       0,9(5)      cargar valor de identificador: a
*      <- identificador
189:       LDA       2,0(0)      Pasando operador izquierdo a la pila
190:       SUB       6,6,3      op: subir pila
191:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 10
192:       LDC       0,10(0)      cargar constante: 10
*      <- constante
193:       LD       2,0(6)      op: pop o cargo de la pila el valor
194:       ADD       6,6,3      op: bajar pila
195:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
196:       SUB       0,1,0      op: <=
197:       JLE       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0 || AC==0)
198:       LDC       0,0(0)      caso de falso (AC=0)
199:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
200:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menori
201:       LDA       2,0(0)       carga parametro en llamada a funcion
202:       SUB       6,6,3      op: subir pila
203:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: mayori
*      -> identificador
204:       LD       0,10(5)      cargar valor de identificador: b
*      <- identificador
205:       LDA       2,0(0)      Pasando operador izquierdo a la pila
206:       SUB       6,6,3      op: subir pila
207:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 20
208:       LDC       0,20(0)      cargar constante: 20
*      <- constante
209:       LD       2,0(6)      op: pop o cargo de la pila el valor
210:       ADD       6,6,3      op: bajar pila
211:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
212:       SUB       0,1,0      op: >=
213:       JGE       0,2(7)      voy dos instrucciones mas alla if verdadero (AC>0 || AC==0)
214:       LDC       0,0(0)      caso de falso (AC=0)
215:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
216:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: mayori
217:       LD       2,0(6)      op: pop o cargo de la pila el valor
218:       ADD       6,6,3      op: bajar pila
219:       MUL       0,0,2      op: *
*      If: el salto hacia el else debe estar aqui
*      -> if
*      -> Operacion: mayor
*      -> identificador
221:       LD       0,9(5)      cargar valor de identificador: a
*      <- identificador
222:       LDA       2,0(0)      Pasando operador izquierdo a la pila
223:       SUB       6,6,3      op: subir pila
224:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
225:       LDC       0,1(0)      cargar constante: 1
*      <- constante
226:       LD       2,0(6)      op: pop o cargo de la pila el valor
227:       ADD       6,6,3      op: bajar pila
228:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
229:       SUB       0,1,0      op: >
230:       JGT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC>0)
231:       LDC       0,0(0)      caso de falso (AC=0)
232:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
233:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: mayor
234:       LDA       2,0(0)       carga parametro en llamada a funcion
235:       SUB       6,6,3      op: subir pila
236:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: igual
*      -> identificador
237:       LD       0,9(5)      cargar valor de identificador: a
*      <- identificador
238:       LDA       2,0(0)      Pasando operador izquierdo a la pila
239:       SUB       6,6,3      op: subir pila
240:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 10
241:       LDC       0,10(0)      cargar constante: 10
*      <- constante
242:       LD       2,0(6)      op: pop o cargo de la pila el valor
243:       ADD       6,6,3      op: bajar pila
244:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
245:       SUB       0,1,0      op: ==
246:       JEQ       0,2(7)      voy dos instrucciones mas alla if verdadero (AC==0)
247:       LDC       0,0(0)      caso de falso (AC=0)
248:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
249:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: igual
250:       LD       2,0(6)      op: pop o cargo de la pila el valor
251:       ADD       6,6,3      op: bajar pila
252:       MUL       0,0,2      op: *
*      If: el salto hacia el else debe estar aqui
*      -> if
*      -> Operacion: mayor
*      -> identificador
254:       LD       0,10(5)      cargar valor de identificador: b
*      <- identificador
255:       LDA       2,0(0)      Pasando operador izquierdo a la pila
256:       SUB       6,6,3      op: subir pila
257:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 25
258:       LDC       0,25(0)      cargar constante: 25
*      <- constante
259:       LD       2,0(6)      op: pop o cargo de la pila el valor
260:       ADD       6,6,3      op: bajar pila
261:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
262:       SUB       0,1,0      op: >
263:       JGT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC>0)
264:       LDC       0,0(0)      caso de falso (AC=0)
265:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
266:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: mayor
267:       LDA       2,0(0)       carga parametro en llamada a funcion
268:       SUB       6,6,3      op: subir pila
269:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: menor
*      -> identificador
270:       LD       0,10(5)      cargar valor de identificador: b
*      <- identificador
271:       LDA       2,0(0)      Pasando operador izquierdo a la pila
272:       SUB       6,6,3      op: subir pila
273:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 30
274:       LDC       0,30(0)      cargar constante: 30
*      <- constante
275:       LD       2,0(6)      op: pop o cargo de la pila el valor
276:       ADD       6,6,3      op: bajar pila
277:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
278:       SUB       0,1,0      op: <
279:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
280:       LDC       0,0(0)      caso de falso (AC=0)
281:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
282:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
283:       LD       2,0(6)      op: pop o cargo de la pila el valor
284:       ADD       6,6,3      op: bajar pila
285:       MUL       0,0,2      op: *
*      If: el salto hacia el else debe estar aqui
*      -> constante 300
287:       LDC       0,300(0)      cargar constante: 300
*      <- constante
288:       LD       2,0(6)      op: pop o cargo de la pila el valor
289:       ADD       6,6,3      op: bajar pila
290:       LDA       7,0(2)      Regreso a donde fui llamado
*      If: el salto hacia el final debe estar aqui
286:       JEQ       0,5(7)      if: jmp hacia else
*      -> constante 400
292:       LDC       0,400(0)      cargar constante: 400
*      <- constante
293:       LD       2,0(6)      op: pop o cargo de la pila el valor
294:       ADD       6,6,3      op: bajar pila
295:       LDA       7,0(2)      Regreso a donde fui llamado
291:       LDA       7,4(7)      if: salto incondicional hacia el final
*      <- if
*      If: el salto hacia el final debe estar aqui
253:       JEQ       0,43(7)      if: jmp hacia else
*      -> constante 200
297:       LDC       0,200(0)      cargar constante: 200
*      <- constante
298:       LD       2,0(6)      op: pop o cargo de la pila el valor
299:       ADD       6,6,3      op: bajar pila
300:       LDA       7,0(2)      Regreso a donde fui llamado
296:       LDA       7,4(7)      if: salto incondicional hacia el final
*      <- if
*      If: el salto hacia el final debe estar aqui
220:       JEQ       0,81(7)      if: jmp hacia else
*      -> constante 500
302:       LDC       0,500(0)      cargar constante: 500
*      <- constante
303:       LD       2,0(6)      op: pop o cargo de la pila el valor
304:       ADD       6,6,3      op: bajar pila
305:       LDA       7,0(2)      Regreso a donde fui llamado
301:       LDA       7,4(7)      if: salto incondicional hacia el final
*      <- if
*      Bloque principal
3:       LDA       7,302(7)      bloque unico: jmp a bloque principal
*      -> asignacion
*      -> constante 5
306:       LDC       0,5(0)      cargar constante: 5
*      <- constante
307:       LDA       2,0(0)      copiamos exprecion
308:       SUB       6,6,3      op: subir pila
309:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 0
310:       LDC       0,0(0)      cargar constante: 0
*      <- constante
311:       LD       2,0(6)      op: pop o cargo de la pila el valor
312:       ADD       6,6,3      op: bajar pila
313:       ST       2,11(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 7
314:       LDC       0,7(0)      cargar constante: 7
*      <- constante
315:       LDA       2,0(0)      copiamos exprecion
316:       SUB       6,6,3      op: subir pila
317:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
318:       LDC       0,1(0)      cargar constante: 1
*      <- constante
319:       LD       2,0(6)      op: pop o cargo de la pila el valor
320:       ADD       6,6,3      op: bajar pila
321:       ST       2,11(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 2
322:       LDC       0,2(0)      cargar constante: 2
*      <- constante
323:       LDA       2,0(0)      copiamos exprecion
324:       SUB       6,6,3      op: subir pila
325:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
326:       LDC       0,2(0)      cargar constante: 2
*      <- constante
327:       LD       2,0(6)      op: pop o cargo de la pila el valor
328:       ADD       6,6,3      op: bajar pila
329:       ST       2,11(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 9
330:       LDC       0,9(0)      cargar constante: 9
*      <- constante
331:       LDA       2,0(0)      copiamos exprecion
332:       SUB       6,6,3      op: subir pila
333:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
334:       LDC       0,3(0)      cargar constante: 3
*      <- constante
335:       LD       2,0(6)      op: pop o cargo de la pila el valor
336:       ADD       6,6,3      op: bajar pila
337:       ST       2,11(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> Operacion: mas
*      -> constante 9
338:       LDC       0,9(0)      cargar constante: 9
*      <- constante
339:       LDA       2,0(0)      Pasando operador izquierdo a la pila
340:       SUB       6,6,3      op: subir pila
341:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 10
342:       LDC       0,10(0)      cargar constante: 10
*      <- constante
343:       LD       2,0(6)      op: pop o cargo de la pila el valor
344:       ADD       6,6,3      op: bajar pila
345:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
346:       ADD       0,1,0      op: +
*      <- Operacion: mas
347:       LDA       2,0(0)      copiamos exprecion
348:       SUB       6,6,3      op: subir pila
349:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 4
350:       LDC       0,4(0)      cargar constante: 4
*      <- constante
351:       LD       2,0(6)      op: pop o cargo de la pila el valor
352:       ADD       6,6,3      op: bajar pila
353:       ST       2,11(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> escribir
354:       LDC       2,358(0)      Cargando verdareda linea de retorno :)
355:       SUB       6,6,3      op: subir pila
356:       ST       2,0(6)      op: push en la pila tmp
357:       LDC       7,79(0)      carga salto  79
358:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> escribir
359:       LDC       2,363(0)      Cargando verdareda linea de retorno :)
360:       SUB       6,6,3      op: subir pila
361:       ST       2,0(6)      op: push en la pila tmp
362:       LDC       7,28(0)      carga salto  28
363:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> escribir
364:       LDC       2,368(0)      Cargando verdareda linea de retorno :)
365:       SUB       6,6,3      op: subir pila
366:       ST       2,0(6)      op: push en la pila tmp
367:       LDC       7,130(0)      carga salto  130
368:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> escribir
369:       LDC       2,373(0)      Cargando verdareda linea de retorno :)
370:       SUB       6,6,3      op: subir pila
371:       ST       2,0(6)      op: push en la pila tmp
372:       LDC       7,184(0)      carga salto  184
373:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> constante 0
374:       LDC       0,0(0)      cargar constante: 0
*      <- constante
375:       ST       0,21(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 0
376:       LDC       0,0(0)      cargar constante: 0
*      <- constante
377:       ST       0,23(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> for
*      -> asignacion
*      -> constante 0
378:       LDC       0,0(0)      cargar constante: 0
*      <- constante
379:       ST       0,21(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> for
*      -> asignacion
*      -> constante 0
380:       LDC       0,0(0)      cargar constante: 0
*      <- constante
381:       ST       0,22(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> if
*      -> Operacion: menor
*      -> vector
*      -> Operacion: mas
*      -> identificador
382:       LD       0,22(5)      cargar valor de identificador: j
*      <- identificador
383:       LDA       2,0(0)      Pasando operador izquierdo a la pila
384:       SUB       6,6,3      op: subir pila
385:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
386:       LDC       0,1(0)      cargar constante: 1
*      <- constante
387:       LD       2,0(6)      op: pop o cargo de la pila el valor
388:       ADD       6,6,3      op: bajar pila
389:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
390:       ADD       0,1,0      op: +
*      <- Operacion: mas
391:       LD       0,11(0)      op: pop o cargo de la pila el valor
*      <- vector
392:       LDA       2,0(0)      Pasando operador izquierdo a la pila
393:       SUB       6,6,3      op: subir pila
394:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> identificador
395:       LD       0,22(5)      cargar valor de identificador: j
*      <- identificador
396:       LD       0,11(0)      op: pop o cargo de la pila el valor
*      <- vector
397:       LD       2,0(6)      op: pop o cargo de la pila el valor
398:       ADD       6,6,3      op: bajar pila
399:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
400:       SUB       0,1,0      op: <
401:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
402:       LDC       0,0(0)      caso de falso (AC=0)
403:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
404:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
*      If: el salto hacia el else debe estar aqui
*      -> asignacion
*      -> vector
*      -> Operacion: mas
*      -> identificador
406:       LD       0,22(5)      cargar valor de identificador: j
*      <- identificador
407:       LDA       2,0(0)      Pasando operador izquierdo a la pila
408:       SUB       6,6,3      op: subir pila
409:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
410:       LDC       0,1(0)      cargar constante: 1
*      <- constante
411:       LD       2,0(6)      op: pop o cargo de la pila el valor
412:       ADD       6,6,3      op: bajar pila
413:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
414:       ADD       0,1,0      op: +
*      <- Operacion: mas
415:       LD       0,11(0)      op: pop o cargo de la pila el valor
*      <- vector
416:       ST       0,23(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> vector
*      -> identificador
417:       LD       0,22(5)      cargar valor de identificador: j
*      <- identificador
418:       LD       0,11(0)      op: pop o cargo de la pila el valor
*      <- vector
419:       LDA       2,0(0)      copiamos exprecion
420:       SUB       6,6,3      op: subir pila
421:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: mas
*      -> identificador
422:       LD       0,22(5)      cargar valor de identificador: j
*      <- identificador
423:       LDA       2,0(0)      Pasando operador izquierdo a la pila
424:       SUB       6,6,3      op: subir pila
425:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
426:       LDC       0,1(0)      cargar constante: 1
*      <- constante
427:       LD       2,0(6)      op: pop o cargo de la pila el valor
428:       ADD       6,6,3      op: bajar pila
429:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
430:       ADD       0,1,0      op: +
*      <- Operacion: mas
431:       LD       2,0(6)      op: pop o cargo de la pila el valor
432:       ADD       6,6,3      op: bajar pila
433:       ST       2,11(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> identificador
434:       LD       0,23(5)      cargar valor de identificador: aux
*      <- identificador
435:       LDA       2,0(0)      copiamos exprecion
436:       SUB       6,6,3      op: subir pila
437:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
438:       LD       0,22(5)      cargar valor de identificador: j
*      <- identificador
439:       LD       2,0(6)      op: pop o cargo de la pila el valor
440:       ADD       6,6,3      op: bajar pila
441:       ST       2,11(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      If: el salto hacia el final debe estar aqui
405:       JEQ       0,37(7)      if: jmp hacia else
442:       LDA       7,0(7)      if: salto incondicional hacia el final
*      <- if
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
443:       LD       0,22(5)      cargar valor de identificador: j
*      <- identificador
444:       LDA       2,0(0)      Pasando operador izquierdo a la pila
445:       SUB       6,6,3      op: subir pila
446:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
447:       LDC       0,1(0)      cargar constante: 1
*      <- constante
448:       LD       2,0(6)      op: pop o cargo de la pila el valor
449:       ADD       6,6,3      op: bajar pila
450:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
451:       ADD       0,1,0      op: +
*      <- Operacion: mas
452:       ST       0,22(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
453:       LD       0,22(5)      cargar valor de identificador: j
*      <- identificador
454:       LDA       2,0(0)      Pasando operador izquierdo a la pila
455:       SUB       6,6,3      op: subir pila
456:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 4
457:       LDC       0,4(0)      cargar constante: 4
*      <- constante
458:       LD       2,0(6)      op: pop o cargo de la pila el valor
459:       ADD       6,6,3      op: bajar pila
460:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
461:       SUB       0,1,0      op: <
462:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
463:       LDC       0,0(0)      caso de falso (AC=0)
464:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
465:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
466:       JNE       0,-85(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
467:       LD       0,21(5)      cargar valor de identificador: i
*      <- identificador
468:       LDA       2,0(0)      Pasando operador izquierdo a la pila
469:       SUB       6,6,3      op: subir pila
470:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
471:       LDC       0,1(0)      cargar constante: 1
*      <- constante
472:       LD       2,0(6)      op: pop o cargo de la pila el valor
473:       ADD       6,6,3      op: bajar pila
474:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
475:       ADD       0,1,0      op: +
*      <- Operacion: mas
476:       ST       0,21(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
477:       LD       0,21(5)      cargar valor de identificador: i
*      <- identificador
478:       LDA       2,0(0)      Pasando operador izquierdo a la pila
479:       SUB       6,6,3      op: subir pila
480:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
481:       LDC       0,5(0)      cargar constante: 5
*      <- constante
482:       LD       2,0(6)      op: pop o cargo de la pila el valor
483:       ADD       6,6,3      op: bajar pila
484:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
485:       SUB       0,1,0      op: <
486:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
487:       LDC       0,0(0)      caso de falso (AC=0)
488:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
489:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
490:       JNE       0,-111(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> for
*      -> asignacion
*      -> constante 0
491:       LDC       0,0(0)      cargar constante: 0
*      <- constante
492:       ST       0,21(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> escribir
*      -> vector
*      -> identificador
493:       LD       0,21(5)      cargar valor de identificador: i
*      <- identificador
494:       LD       0,11(0)      op: pop o cargo de la pila el valor
*      <- vector
495:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
496:       LD       0,21(5)      cargar valor de identificador: i
*      <- identificador
497:       LDA       2,0(0)      Pasando operador izquierdo a la pila
498:       SUB       6,6,3      op: subir pila
499:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
500:       LDC       0,1(0)      cargar constante: 1
*      <- constante
501:       LD       2,0(6)      op: pop o cargo de la pila el valor
502:       ADD       6,6,3      op: bajar pila
503:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
504:       ADD       0,1,0      op: +
*      <- Operacion: mas
505:       ST       0,21(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
506:       LD       0,21(5)      cargar valor de identificador: i
*      <- identificador
507:       LDA       2,0(0)      Pasando operador izquierdo a la pila
508:       SUB       6,6,3      op: subir pila
509:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
510:       LDC       0,5(0)      cargar constante: 5
*      <- constante
511:       LD       2,0(6)      op: pop o cargo de la pila el valor
512:       ADD       6,6,3      op: bajar pila
513:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
514:       SUB       0,1,0      op: <
515:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
516:       LDC       0,0(0)      caso de falso (AC=0)
517:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
518:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
519:       JNE       0,-27(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      Fin de la ejecucion.
520:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
