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
*      -> asignacion
*      -> constante 0
4:       LDC       0,0(0)      cargar constante: 0
*      <- constante
5:       ST       0,101(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> for
*      -> asignacion
*      -> constante 0
6:       LDC       0,0(0)      cargar constante: 0
*      <- constante
7:       ST       0,0(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> asignacion
*      -> Operacion: mas
*      -> Operacion: por
*      -> identificador
8:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
9:       LDA       2,0(0)      Pasando operador izquierdo a la pila
10:       SUB       6,6,3      op: subir pila
11:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
12:       LDC       0,2(0)      cargar constante: 2
*      <- constante
13:       LD       2,0(6)      op: pop o cargo de la pila el valor
14:       ADD       6,6,3      op: bajar pila
15:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
16:       MUL       0,1,0      op: *
*      <- Operacion: por
17:       LDA       2,0(0)      Pasando operador izquierdo a la pila
18:       SUB       6,6,3      op: subir pila
19:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 4
20:       LDC       0,4(0)      cargar constante: 4
*      <- constante
21:       LD       2,0(6)      op: pop o cargo de la pila el valor
22:       ADD       6,6,3      op: bajar pila
23:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
24:       ADD       0,1,0      op: +
*      <- Operacion: mas
25:       LDA       2,0(0)      copiamos exprecion
26:       SUB       6,6,3      op: subir pila
27:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
28:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
29:       LD       2,0(6)      op: pop o cargo de la pila el valor
30:       ADD       6,6,3      op: bajar pila
31:       ST       2,1(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> escribir
*      -> vector
*      -> identificador
32:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
33:       LD       0,1(0)      op: pop o cargo de la pila el valor
*      <- vector
34:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
35:       LD       0,101(5)      cargar valor de identificador: sum
*      <- identificador
36:       LDA       2,0(0)      Pasando operador izquierdo a la pila
37:       SUB       6,6,3      op: subir pila
38:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> identificador
39:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
40:       LD       0,1(0)      op: pop o cargo de la pila el valor
*      <- vector
41:       LD       2,0(6)      op: pop o cargo de la pila el valor
42:       ADD       6,6,3      op: bajar pila
43:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
44:       ADD       0,1,0      op: +
*      <- Operacion: mas
45:       ST       0,101(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
46:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
47:       LDA       2,0(0)      Pasando operador izquierdo a la pila
48:       SUB       6,6,3      op: subir pila
49:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
50:       LDC       0,1(0)      cargar constante: 1
*      <- constante
51:       LD       2,0(6)      op: pop o cargo de la pila el valor
52:       ADD       6,6,3      op: bajar pila
53:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
54:       ADD       0,1,0      op: +
*      <- Operacion: mas
55:       ST       0,0(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
56:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
57:       LDA       2,0(0)      Pasando operador izquierdo a la pila
58:       SUB       6,6,3      op: subir pila
59:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 100
60:       LDC       0,100(0)      cargar constante: 100
*      <- constante
61:       LD       2,0(6)      op: pop o cargo de la pila el valor
62:       ADD       6,6,3      op: bajar pila
63:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
64:       SUB       0,1,0      op: <
65:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
66:       LDC       0,0(0)      caso de falso (AC=0)
67:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
68:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
69:       JNE       0,-62(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> escribir
*      -> identificador
70:       LD       0,101(5)      cargar valor de identificador: sum
*      <- identificador
71:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> escribir
*      -> identificador
72:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
73:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> escribir
*      -> Operacion: entre
*      -> identificador
74:       LD       0,101(5)      cargar valor de identificador: sum
*      <- identificador
75:       LDA       2,0(0)      Pasando operador izquierdo a la pila
76:       SUB       6,6,3      op: subir pila
77:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
78:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
79:       LD       2,0(6)      op: pop o cargo de la pila el valor
80:       ADD       6,6,3      op: bajar pila
81:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
82:       DIV       0,1,0      op: /
*      <- Operacion: entre
83:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
84:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
