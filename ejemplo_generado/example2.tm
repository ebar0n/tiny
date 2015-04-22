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
*      -> identificador
95:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
96:       LDA       7,0(4)      Regreso a donde fui llamado
*      Bloque principal
3:       LDA       7,93(7)      bloque unico: jmp a bloque principal
*      -> asignacion
*      -> constante 1
97:       LDC       0,1(0)      cargar constante: 1
*      <- constante
98:       ST       0,3(5)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      -> asignacion
*      -> identificador
99:       LD       0,3(5)      cargar valor de identificador: j
*      <- identificador
100:       LDA       2,0(0)       carga parametro en llamada a funcion
101:       SUB       6,6,3      op: subir pila
102:       ST       2,0(6)      op: push en la pila tmp
103:       LDC       2,107(0)      Cargando verdareda linea de retorno
104:       SUB       6,6,3      op: subir pila
105:       ST       2,0(6)      op: push en la pila tmp
106:       LDC       7,23(0)      carga salto  23
107:       ST       0,3(5)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      Fin de la ejecucion.
108:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
