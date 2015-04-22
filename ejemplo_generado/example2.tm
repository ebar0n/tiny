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
*      Bloque principal
3:       LDA       7,19(7)      bloque unico: jmp a bloque principal
*      -> asignacion
*      -> Operacion: por
*      -> constante 1
23:       LDC       0,1(0)      cargar constante: 1
*      <- constante
24:       LDA       2,0(0)      Pasando operador izquierdo a la pila
25:       SUB       6,6,3      op: subir pila
26:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
27:       LDC       0,3(0)      cargar constante: 3
*      <- constante
28:       LD       2,0(6)      op: pop o cargo de la pila el valor
29:       ADD       6,6,3      op: bajar pila
30:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
31:       MUL       0,1,0      op: *
*      <- Operacion: por
32:       LDA       2,0(0)      asignacion: almaceno el valor para el id j
33:       SUB       6,6,3      op: subir pila
34:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
35:       LD       0,2(5)      cargar valor de identificador: j
*      <- identificador
36:       LD       2,0(6)      op: pop o cargo de la pila el valor
37:       ADD       6,6,3      op: bajar pila
38:       ST       2,0(1)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      -> asignacion
*      -> constante 1
39:       LDC       0,1(0)      cargar constante: 1
*      <- constante
40:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
41:       SUB       6,6,3      op: subir pila
42:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 0
43:       LDC       0,0(0)      cargar constante: 0
*      <- constante
44:       ADD       1,5,0      sumar desplazamiendo al registro L3
45:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
46:       LD       2,0(6)      op: pop o cargo de la pila el valor
47:       ADD       6,6,3      op: bajar pila
48:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> constante 4
49:       LDC       0,4(0)      cargar constante: 4
*      <- constante
50:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
51:       SUB       6,6,3      op: subir pila
52:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 3
53:       LDC       0,3(0)      cargar constante: 3
*      <- constante
54:       ADD       1,5,0      sumar desplazamiendo al registro L3
55:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
56:       LD       2,0(6)      op: pop o cargo de la pila el valor
57:       ADD       6,6,3      op: bajar pila
58:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> constante 2
59:       LDC       0,2(0)      cargar constante: 2
*      <- constante
60:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
61:       SUB       6,6,3      op: subir pila
62:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 1
63:       LDC       0,1(0)      cargar constante: 1
*      <- constante
64:       ADD       1,5,0      sumar desplazamiendo al registro L3
65:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
66:       LD       2,0(6)      op: pop o cargo de la pila el valor
67:       ADD       6,6,3      op: bajar pila
68:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> constante 3
69:       LDC       0,3(0)      cargar constante: 3
*      <- constante
70:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
71:       SUB       6,6,3      op: subir pila
72:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 2
73:       LDC       0,2(0)      cargar constante: 2
*      <- constante
74:       ADD       1,5,0      sumar desplazamiendo al registro L3
75:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
76:       LD       2,0(6)      op: pop o cargo de la pila el valor
77:       ADD       6,6,3      op: bajar pila
78:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> vector
*      -> constante 3
79:       LDC       0,3(0)      cargar constante: 3
*      <- constante
80:       ADD       1,5,0      sumar desplazamiendo al registro L3
81:       LD       0,0(1)      cargar valor de identificador: a
82:       LDA       0,0(0)      cargar valor de identificador: a
*      <- vector
83:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
84:       SUB       6,6,3      op: subir pila
85:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 4
86:       LDC       0,4(0)      cargar constante: 4
*      <- constante
87:       ADD       1,5,0      sumar desplazamiendo al registro L3
88:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
89:       LD       2,0(6)      op: pop o cargo de la pila el valor
90:       ADD       6,6,3      op: bajar pila
91:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> escribir
*      -> vector
*      -> constante 3
92:       LDC       0,3(0)      cargar constante: 3
*      <- constante
93:       ADD       1,5,0      sumar desplazamiendo al registro L3
94:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
95:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> identificador
99:       LD       0,2(5)      cargar valor de identificador: j
*      <- identificador
100:       LDA       2,0(0)       carga parametro en llamada a funcion
101:       SUB       6,6,3      op: subir pila
102:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
103:       LDC       0,2(0)      cargar constante: 2
*      <- constante
104:       LDA       2,0(0)       carga parametro en llamada a funcion
105:       SUB       6,6,3      op: subir pila
106:       ST       2,0(6)      op: push en la pila tmp
96:       LDC       2,108(0)      Cargando verdareda linea de retorno :)
97:       SUB       6,6,3      op: subir pila
98:       ST       2,0(6)      op: push en la pila tmp
107:       LDC       7,4(0)      carga salto  4
108:       LDA       2,0(0)      asignacion: almaceno el valor para el id j
109:       SUB       6,6,3      op: subir pila
110:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
111:       LD       0,2(5)      cargar valor de identificador: j
*      <- identificador
112:       LD       2,0(6)      op: pop o cargo de la pila el valor
113:       ADD       6,6,3      op: bajar pila
114:       ST       2,0(1)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      -> escribir
*      -> identificador
115:       LD       0,2(5)      cargar valor de identificador: j
*      <- identificador
116:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
117:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
