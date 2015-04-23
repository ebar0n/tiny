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
*      -> asignacion
*      -> constante 2
6:       LDC       0,2(0)      cargar constante: 2
*      <- constante
*      -> constante 2
7:       LDC       0,2(0)      cargar constante: 2
*      <- constante
8:       LDC       1,1(0)      carga direccion de vector
9:       ADD       1,0,1      carcular direccion vector
10:       ST       0,0(1)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 1
11:       LDC       0,1(0)      cargar constante: 1
*      <- constante
*      -> constante 1
12:       LDC       0,1(0)      cargar constante: 1
*      <- constante
13:       LDC       1,1(0)      carga direccion de vector
14:       ADD       1,0,1      carcular direccion vector
15:       ST       0,0(1)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> constante 0
16:       LDC       0,0(0)      cargar constante: 0
*      <- constante
*      -> constante 0
17:       LDC       0,0(0)      cargar constante: 0
*      <- constante
18:       LDC       1,1(0)      carga direccion de vector
19:       ADD       1,0,1      carcular direccion vector
20:       ST       0,0(1)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> Operacion: mas
*      -> Operacion: mas
*      -> Operacion: mas
*      -> identificador
21:       LD       0,0(5)      cargar valor de identificador: x
*      <- identificador
22:       LDA       2,0(0)      Pasando operador izquierdo a la pila
23:       SUB       6,6,3      op: subir pila
24:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 0
25:       LDC       0,0(0)      cargar constante: 0
*      <- constante
26:       LDC       1,1(0)      carga direccion de vector
27:       ADD       1,0,1      calcular direccion de vector
28:       LD       0,0(1)      op: pop o cargo de la pila el valor
*      <- vector
29:       LD       2,0(6)      op: pop o cargo de la pila el valor
30:       ADD       6,6,3      op: bajar pila
31:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
32:       ADD       0,1,0      op: +
*      <- Operacion: mas
33:       LDA       2,0(0)      Pasando operador izquierdo a la pila
34:       SUB       6,6,3      op: subir pila
35:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 1
36:       LDC       0,1(0)      cargar constante: 1
*      <- constante
37:       LDC       1,1(0)      carga direccion de vector
38:       ADD       1,0,1      calcular direccion de vector
39:       LD       0,0(1)      op: pop o cargo de la pila el valor
*      <- vector
40:       LD       2,0(6)      op: pop o cargo de la pila el valor
41:       ADD       6,6,3      op: bajar pila
42:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
43:       ADD       0,1,0      op: +
*      <- Operacion: mas
44:       LDA       2,0(0)      Pasando operador izquierdo a la pila
45:       SUB       6,6,3      op: subir pila
46:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 2
47:       LDC       0,2(0)      cargar constante: 2
*      <- constante
48:       LDC       1,1(0)      carga direccion de vector
49:       ADD       1,0,1      calcular direccion de vector
50:       LD       0,0(1)      op: pop o cargo de la pila el valor
*      <- vector
51:       LD       2,0(6)      op: pop o cargo de la pila el valor
52:       ADD       6,6,3      op: bajar pila
53:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
54:       ADD       0,1,0      op: +
*      <- Operacion: mas
55:       ST       0,4(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> escribir
*      -> identificador
56:       LD       0,4(5)      cargar valor de identificador: z
*      <- identificador
57:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
58:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
