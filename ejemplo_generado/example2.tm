* Warning (Regla#3.2)-> linea: 3 -> Variable {a} debe ser inicializada antes de su uso
* Warning (Regla#3.2)-> linea: 3 -> Variable {b} debe ser inicializada antes de su uso
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
6:       ST       2,2(5)      Guardo en la direccion 2 ban
7:       LD       2,0(6)      op: pop o cargo de la pila el valor
8:       ADD       6,6,3      op: bajar pila
9:       ST       2,1(5)      Guardo en la direccion 1 b
10:       LD       2,0(6)      op: pop o cargo de la pila el valor
11:       ADD       6,6,3      op: bajar pila
12:       ST       2,0(5)      Guardo en la direccion 0 a
*      bloque normal
13:       LDA       2,0(7)      carga la linea donde me encuentro, llamada a funcion
14:       SUB       6,6,3      op: subir pila
15:       ST       2,0(6)      op: push en la pila tmp
16:       LDA       4,0(6)      cargando ubicacion de la pila, para la llamada del retunn
*      -> Operacion: por
*      -> identificador
17:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
18:       LDA       2,0(0)      Pasando operador izquierdo a la pila
19:       SUB       6,6,3      op: subir pila
20:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
21:       LDC       0,2(0)      cargar constante: 2
*      <- constante
22:       LD       2,0(6)      op: pop o cargo de la pila el valor
23:       ADD       6,6,3      op: bajar pila
24:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
25:       MUL       0,1,0      op: *
*      <- Operacion: por
26:       LDA       2,0(0)       carga parametro en llamada a funcion
27:       SUB       6,6,3      op: subir pila
28:       ST       2,0(6)      op: push en la pila tmp
*      -> Operacion: por
*      -> identificador
29:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
30:       LDA       2,0(0)      Pasando operador izquierdo a la pila
31:       SUB       6,6,3      op: subir pila
32:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
33:       LDC       0,2(0)      cargar constante: 2
*      <- constante
34:       LD       2,0(6)      op: pop o cargo de la pila el valor
35:       ADD       6,6,3      op: bajar pila
36:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
37:       MUL       0,1,0      op: *
*      <- Operacion: por
38:       LDA       2,0(0)       carga parametro en llamada a funcion
39:       SUB       6,6,3      op: subir pila
40:       ST       2,0(6)      op: push en la pila tmp
*      -> constante -1
41:       LDC       0,-1(0)      cargar constante: true
*      <- constante
42:       LDA       2,0(0)       carga parametro en llamada a funcion
43:       SUB       6,6,3      op: subir pila
44:       ST       2,0(6)      op: push en la pila tmp
45:       LDC       2,48(0)      Cargando verdareda linea de retorno
46:       ST       2,0(4)      Paso ubicacion a la pila
47:       LDC       7,4(0)      carga salto  4
48:       LD       2,0(6)      op: pop o cargo de la pila el valor
49:       ADD       6,6,3      op: bajar pila
50:       SUB       6,6,3      op: subir pila
51:       ST       0,0(6)      Cargo variable que genero el return en temporales
52:       LDA       7,0(2)      Regreso a donde fui llamado
*      Bloque principal
3:       LDA       7,49(7)      bloque unico: jmp a bloque principal
*      -> escribir
53:       LDA       2,0(7)      carga la linea donde me encuentro, llamada a funcion
54:       SUB       6,6,3      op: subir pila
55:       ST       2,0(6)      op: push en la pila tmp
56:       LDA       4,0(6)      cargando ubicacion de la pila, para la llamada del retunn
*      -> constante 1
57:       LDC       0,1(0)      cargar constante: 1
*      <- constante
58:       LDA       2,0(0)       carga parametro en llamada a funcion
59:       SUB       6,6,3      op: subir pila
60:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
61:       LDC       0,2(0)      cargar constante: 2
*      <- constante
62:       LDA       2,0(0)       carga parametro en llamada a funcion
63:       SUB       6,6,3      op: subir pila
64:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 0
65:       LDC       0,0(0)      cargar constante: false
*      <- constante
66:       LDA       2,0(0)       carga parametro en llamada a funcion
67:       SUB       6,6,3      op: subir pila
68:       ST       2,0(6)      op: push en la pila tmp
69:       LDC       2,72(0)      Cargando verdareda linea de retorno
70:       ST       2,0(4)      Paso ubicacion a la pila
71:       LDC       7,4(0)      carga salto  4
72:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
73:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
