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
*      -> constante 1
39:       LDC       0,1(0)      cargar constante: 1
*      <- constante
40:       LDA       2,0(0)       carga parametro en llamada a funcion
41:       SUB       6,6,3      op: subir pila
42:       ST       2,0(6)      op: push en la pila tmp
32:       LDC       2,46(0)      Cargando verdareda linea de retorno
33:       SUB       6,6,3      op: subir pila
34:       ST       2,0(6)      op: push en la pila tmp
43:       LDC       7,4(0)      carga salto  4
44:       LD       2,0(6)      op: pop o cargo de la pila el valor
45:       ADD       6,6,3      op: bajar pila
46:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
47:       MUL       0,1,0      op: *
*      <- Operacion: por
48:       ST       0,2(5)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> escribir
*      -> identificador
49:       LD       0,2(5)      cargar valor de identificador: a
*      <- identificador
50:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
51:       LD       2,0(6)      op: pop o cargo de la pila el valor
52:       ADD       6,6,3      op: bajar pila
53:       LDA       4,0(2)      Paso ubicacion de retorno
54:       LDA       7,0(4)      Regreso a donde fui llamado sin devolver nada
*      Bloque principal
3:       LDA       7,51(7)      bloque unico: jmp a bloque principal
*      -> asignacion
*      -> constante 2
55:       LDC       0,2(0)      cargar constante: 2
*      <- constante
56:       ST       0,3(5)      asignacion: almaceno el valor para el id j
*      <- asignacion
*      -> escribir
*      -> identificador
57:       LD       0,3(5)      cargar valor de identificador: j
*      <- identificador
58:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> identificador
62:       LD       0,3(5)      cargar valor de identificador: j
*      <- identificador
63:       LDA       2,0(0)       carga parametro en llamada a funcion
64:       SUB       6,6,3      op: subir pila
65:       ST       2,0(6)      op: push en la pila tmp
59:       LDC       2,69(0)      Cargando verdareda linea de retorno
60:       SUB       6,6,3      op: subir pila
61:       ST       2,0(6)      op: push en la pila tmp
66:       LDC       7,23(0)      carga salto  23
*      Fin de la ejecucion.
67:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
