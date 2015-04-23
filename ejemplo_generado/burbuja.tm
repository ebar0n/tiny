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
*      Bloque principal
3:       LDA       7,0(7)      bloque unico: jmp a bloque principal
*      -> for
*      -> asignacion
*      -> constante 0
4:       LDC       0,0(0)      cargar constante: 0
*      <- constante
5:       ST       0,6(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> leer
*      -> identificador
6:       LD       0,6(5)      cargar valor de identificador: i
*      <- identificador
7:       LDA       1,0(0)      Regreso a donde fui llamado
8:       IN       0,0,0      leer: lee un valor entero 
9:       ST       0,0(1)      leer: almaceno el valor entero leido
*      <- leer
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
10:       LD       0,6(5)      cargar valor de identificador: i
*      <- identificador
11:       LDA       2,0(0)      Pasando operador izquierdo a la pila
12:       SUB       6,6,3      op: subir pila
13:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
14:       LDC       0,1(0)      cargar constante: 1
*      <- constante
15:       LD       2,0(6)      op: pop o cargo de la pila el valor
16:       ADD       6,6,3      op: bajar pila
17:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
18:       ADD       0,1,0      op: +
*      <- Operacion: mas
19:       ST       0,6(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
20:       LD       0,6(5)      cargar valor de identificador: i
*      <- identificador
21:       LDA       2,0(0)      Pasando operador izquierdo a la pila
22:       SUB       6,6,3      op: subir pila
23:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
24:       LDC       0,5(0)      cargar constante: 5
*      <- constante
25:       LD       2,0(6)      op: pop o cargo de la pila el valor
26:       ADD       6,6,3      op: bajar pila
27:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
28:       SUB       0,1,0      op: <
29:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
30:       LDC       0,0(0)      caso de falso (AC=0)
31:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
32:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
33:       JNE       0,-28(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> for
*      -> asignacion
*      -> constante 1
34:       LDC       0,1(0)      cargar constante: 1
*      <- constante
35:       ST       0,6(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> for
*      -> asignacion
*      -> constante 0
36:       LDC       0,0(0)      cargar constante: 0
*      <- constante
37:       ST       0,7(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> if
*      -> Operacion: mayor
*      -> vector
*      -> identificador
38:       LD       0,7(5)      cargar valor de identificador: j
*      <- identificador
39:       LD       0,0(0)      op: pop o cargo de la pila el valor
*      <- vector
40:       LDA       2,0(0)      Pasando operador izquierdo a la pila
41:       SUB       6,6,3      op: subir pila
42:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> Operacion: mas
*      -> identificador
43:       LD       0,7(5)      cargar valor de identificador: j
*      <- identificador
44:       LDA       2,0(0)      Pasando operador izquierdo a la pila
45:       SUB       6,6,3      op: subir pila
46:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
47:       LDC       0,1(0)      cargar constante: 1
*      <- constante
48:       LD       2,0(6)      op: pop o cargo de la pila el valor
49:       ADD       6,6,3      op: bajar pila
50:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
51:       ADD       0,1,0      op: +
*      <- Operacion: mas
52:       LD       0,0(0)      op: pop o cargo de la pila el valor
*      <- vector
53:       LD       2,0(6)      op: pop o cargo de la pila el valor
54:       ADD       6,6,3      op: bajar pila
55:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
56:       SUB       0,1,0      op: >
57:       JGT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC>0)
58:       LDC       0,0(0)      caso de falso (AC=0)
59:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
60:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: mayor
*      If: el salto hacia el else debe estar aqui
*      -> asignacion
*      -> vector
*      -> identificador
62:       LD       0,7(5)      cargar valor de identificador: j
*      <- identificador
63:       LD       0,0(0)      op: pop o cargo de la pila el valor
*      <- vector
64:       ST       0,5(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> vector
*      -> Operacion: mas
*      -> identificador
65:       LD       0,7(5)      cargar valor de identificador: j
*      <- identificador
66:       LDA       2,0(0)      Pasando operador izquierdo a la pila
67:       SUB       6,6,3      op: subir pila
68:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
69:       LDC       0,1(0)      cargar constante: 1
*      <- constante
70:       LD       2,0(6)      op: pop o cargo de la pila el valor
71:       ADD       6,6,3      op: bajar pila
72:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
73:       ADD       0,1,0      op: +
*      <- Operacion: mas
74:       LD       0,0(0)      op: pop o cargo de la pila el valor
*      <- vector
75:       LDA       2,0(0)      copiamos exprecion
76:       SUB       6,6,3      op: subir pila
77:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
78:       LD       0,7(5)      cargar valor de identificador: j
*      <- identificador
79:       LD       2,0(6)      op: pop o cargo de la pila el valor
80:       ADD       6,6,3      op: bajar pila
81:       ST       2,0(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> identificador
82:       LD       0,5(5)      cargar valor de identificador: temp
*      <- identificador
83:       LDA       2,0(0)      copiamos exprecion
84:       SUB       6,6,3      op: subir pila
85:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: mas
*      -> identificador
86:       LD       0,7(5)      cargar valor de identificador: j
*      <- identificador
87:       LDA       2,0(0)      Pasando operador izquierdo a la pila
88:       SUB       6,6,3      op: subir pila
89:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
90:       LDC       0,1(0)      cargar constante: 1
*      <- constante
91:       LD       2,0(6)      op: pop o cargo de la pila el valor
92:       ADD       6,6,3      op: bajar pila
93:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
94:       ADD       0,1,0      op: +
*      <- Operacion: mas
95:       LD       2,0(6)      op: pop o cargo de la pila el valor
96:       ADD       6,6,3      op: bajar pila
97:       ST       2,0(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      If: el salto hacia el final debe estar aqui
61:       JEQ       0,37(7)      if: jmp hacia else
98:       LDA       7,0(7)      if: salto incondicional hacia el final
*      <- if
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
99:       LD       0,7(5)      cargar valor de identificador: j
*      <- identificador
100:       LDA       2,0(0)      Pasando operador izquierdo a la pila
101:       SUB       6,6,3      op: subir pila
102:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
103:       LDC       0,1(0)      cargar constante: 1
*      <- constante
104:       LD       2,0(6)      op: pop o cargo de la pila el valor
105:       ADD       6,6,3      op: bajar pila
106:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
107:       ADD       0,1,0      op: +
*      <- Operacion: mas
108:       ST       0,7(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
109:       LD       0,7(5)      cargar valor de identificador: j
*      <- identificador
110:       LDA       2,0(0)      Pasando operador izquierdo a la pila
111:       SUB       6,6,3      op: subir pila
112:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: menos
*      -> constante 5
113:       LDC       0,5(0)      cargar constante: 5
*      <- constante
114:       LDA       2,0(0)      Pasando operador izquierdo a la pila
115:       SUB       6,6,3      op: subir pila
116:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
117:       LDC       0,1(0)      cargar constante: 1
*      <- constante
118:       LD       2,0(6)      op: pop o cargo de la pila el valor
119:       ADD       6,6,3      op: bajar pila
120:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
121:       SUB       0,1,0      op: -
*      <- Operacion: menos
122:       LD       2,0(6)      op: pop o cargo de la pila el valor
123:       ADD       6,6,3      op: bajar pila
124:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
125:       SUB       0,1,0      op: <
126:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
127:       LDC       0,0(0)      caso de falso (AC=0)
128:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
129:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
130:       JNE       0,-93(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
131:       LD       0,6(5)      cargar valor de identificador: i
*      <- identificador
132:       LDA       2,0(0)      Pasando operador izquierdo a la pila
133:       SUB       6,6,3      op: subir pila
134:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
135:       LDC       0,1(0)      cargar constante: 1
*      <- constante
136:       LD       2,0(6)      op: pop o cargo de la pila el valor
137:       ADD       6,6,3      op: bajar pila
138:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
139:       ADD       0,1,0      op: +
*      <- Operacion: mas
140:       ST       0,6(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
141:       LD       0,6(5)      cargar valor de identificador: i
*      <- identificador
142:       LDA       2,0(0)      Pasando operador izquierdo a la pila
143:       SUB       6,6,3      op: subir pila
144:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
145:       LDC       0,5(0)      cargar constante: 5
*      <- constante
146:       LD       2,0(6)      op: pop o cargo de la pila el valor
147:       ADD       6,6,3      op: bajar pila
148:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
149:       SUB       0,1,0      op: <
150:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
151:       LDC       0,0(0)      caso de falso (AC=0)
152:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
153:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
154:       JNE       0,-119(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> for
*      -> asignacion
*      -> constante 0
155:       LDC       0,0(0)      cargar constante: 0
*      <- constante
156:       ST       0,6(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> escribir
*      -> vector
*      -> identificador
157:       LD       0,6(5)      cargar valor de identificador: i
*      <- identificador
158:       LD       0,0(0)      op: pop o cargo de la pila el valor
*      <- vector
159:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
160:       LD       0,6(5)      cargar valor de identificador: i
*      <- identificador
161:       LDA       2,0(0)      Pasando operador izquierdo a la pila
162:       SUB       6,6,3      op: subir pila
163:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
164:       LDC       0,1(0)      cargar constante: 1
*      <- constante
165:       LD       2,0(6)      op: pop o cargo de la pila el valor
166:       ADD       6,6,3      op: bajar pila
167:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
168:       ADD       0,1,0      op: +
*      <- Operacion: mas
169:       ST       0,6(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
170:       LD       0,6(5)      cargar valor de identificador: i
*      <- identificador
171:       LDA       2,0(0)      Pasando operador izquierdo a la pila
172:       SUB       6,6,3      op: subir pila
173:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
174:       LDC       0,5(0)      cargar constante: 5
*      <- constante
175:       LD       2,0(6)      op: pop o cargo de la pila el valor
176:       ADD       6,6,3      op: bajar pila
177:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
178:       SUB       0,1,0      op: <
179:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
180:       LDC       0,0(0)      caso de falso (AC=0)
181:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
182:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
183:       JNE       0,-27(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      Fin de la ejecucion.
184:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
