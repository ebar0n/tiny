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
*      -> leer
4:       IN       0,0,0      leer: lee un valor entero 
5:       ST       0,0(5)      leer: almaceno el valor entero leido
*      <- leer
*      -> if
*      -> Operacion: menor
*      -> constante 0
6:       LDC       0,0(0)      cargar constante: 0
*      <- constante
7:       LDA       2,0(0)      Pasando operador izquierdo a la pila
8:       SUB       6,6,3      op: subir pila
9:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
10:       LD       0,0(5)      cargar valor de identificador: x
*      <- identificador
11:       LD       2,0(6)      op: pop o cargo de la pila el valor
12:       ADD       6,6,3      op: bajar pila
13:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
14:       SUB       0,1,0      op: <
15:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
16:       LDC       0,0(0)      caso de falso (AC=0)
17:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
18:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
*      If: el salto hacia el else debe estar aqui
*      -> asignacion
*      -> constante 1
20:       LDC       0,1(0)      cargar constante: 1
*      <- constante
21:       ST       0,1(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> repeat
*      repeat: el salto hacia el final (luego del cuerpo) del repeat debe estar aqui
*      -> asignacion
*      -> Operacion: por
*      -> identificador
22:       LD       0,1(5)      cargar valor de identificador: fact
*      <- identificador
23:       LDA       2,0(0)      Pasando operador izquierdo a la pila
24:       SUB       6,6,3      op: subir pila
25:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
26:       LD       0,0(5)      cargar valor de identificador: x
*      <- identificador
27:       LD       2,0(6)      op: pop o cargo de la pila el valor
28:       ADD       6,6,3      op: bajar pila
29:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
30:       MUL       0,1,0      op: *
*      <- Operacion: por
31:       ST       0,1(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> Operacion: menos
*      -> identificador
32:       LD       0,0(5)      cargar valor de identificador: x
*      <- identificador
33:       LDA       2,0(0)      Pasando operador izquierdo a la pila
34:       SUB       6,6,3      op: subir pila
35:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
36:       LDC       0,1(0)      cargar constante: 1
*      <- constante
37:       LD       2,0(6)      op: pop o cargo de la pila el valor
38:       ADD       6,6,3      op: bajar pila
39:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
40:       SUB       0,1,0      op: -
*      <- Operacion: menos
41:       ST       0,0(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: igual
*      -> identificador
42:       LD       0,0(5)      cargar valor de identificador: x
*      <- identificador
43:       LDA       2,0(0)      Pasando operador izquierdo a la pila
44:       SUB       6,6,3      op: subir pila
45:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 0
46:       LDC       0,0(0)      cargar constante: 0
*      <- constante
47:       LD       2,0(6)      op: pop o cargo de la pila el valor
48:       ADD       6,6,3      op: bajar pila
49:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
50:       SUB       0,1,0      op: ==
51:       JEQ       0,2(7)      voy dos instrucciones mas alla if verdadero (AC==0)
52:       LDC       0,0(0)      caso de falso (AC=0)
53:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
54:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: igual
55:       JEQ       0,-34(7)      repeat: jmp hacia el inicio del cuerpo
*      <- repeat
*      -> escribir
*      -> identificador
56:       LD       0,1(5)      cargar valor de identificador: fact
*      <- identificador
57:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      If: el salto hacia el final debe estar aqui
19:       JEQ       0,39(7)      if: jmp hacia else
58:       LDA       7,0(7)      if: salto incondicional hacia el final
*      <- if
*      -> if
*      -> Operacion: menor
*      -> constante 0
59:       LDC       0,0(0)      cargar constante: 0
*      <- constante
60:       LDA       2,0(0)      Pasando operador izquierdo a la pila
61:       SUB       6,6,3      op: subir pila
62:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
63:       LD       0,0(5)      cargar valor de identificador: x
*      <- identificador
64:       LD       2,0(6)      op: pop o cargo de la pila el valor
65:       ADD       6,6,3      op: bajar pila
66:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
67:       SUB       0,1,0      op: <
68:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
69:       LDC       0,0(0)      caso de falso (AC=0)
70:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
71:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
*      If: el salto hacia el else debe estar aqui
*      -> asignacion
*      -> constante 1
73:       LDC       0,1(0)      cargar constante: 1
*      <- constante
74:       ST       0,1(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> escribir
*      -> identificador
75:       LD       0,1(5)      cargar valor de identificador: fact
*      <- identificador
76:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      If: el salto hacia el final debe estar aqui
72:       JEQ       0,5(7)      if: jmp hacia else
77:       LDA       7,0(7)      if: salto incondicional hacia el final
*      <- if
*      Fin de la ejecucion.
78:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
