* Warning (Regla#3.2)-> linea: 4 -> Variable {a} debe ser inicializada antes de su uso
* Warning (Regla#3.2)-> linea: 4 -> Variable {b} debe ser inicializada antes de su uso
* Warning (Regla#3.2)-> linea: 5 -> Variable {a} debe ser inicializada antes de su uso
* Warning (Regla#3.2)-> linea: 5 -> Variable {b} debe ser inicializada antes de su uso
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
*      -> asignacion
13:       LDA       2,0(7)      carga la linea donde me encuentro, llamada a funcion
14:       SUB       6,6,3      op: subir pila
15:       ST       2,0(6)      op: push en la pila tmp
16:       LDA       4,0(6)      cargando ubicacion de la pila, para la llamada del retunn
*      -> identificador
17:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
18:       LDA       2,0(0)       carga parametro en llamada a funcion
19:       SUB       6,6,3      op: subir pila
20:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
21:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
22:       LDA       2,0(0)       carga parametro en llamada a funcion
23:       SUB       6,6,3      op: subir pila
24:       ST       2,0(6)      op: push en la pila tmp
*      -> constante -1
25:       LDC       0,-1(0)      cargar constante: true
*      <- constante
26:       LDA       2,0(0)       carga parametro en llamada a funcion
27:       SUB       6,6,3      op: subir pila
28:       ST       2,0(6)      op: push en la pila tmp
29:       LDC       2,32(0)      Cargando verdareda linea de retorno
30:       ST       2,0(4)      Paso ubicacion a la pila
31:       LDC       7,4(0)      carga salto  4
32:       ST       0,3(5)      asignacion: almaceno el valor para el id c
*      <- asignacion
*      -> Operacion: mas
*      -> Operacion: mas
*      -> identificador
33:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
34:       LDA       2,0(0)      Pasando operador izquierdo a la pila
35:       SUB       6,6,3      op: subir pila
36:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
37:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
38:       LD       2,0(6)      op: pop o cargo de la pila el valor
39:       ADD       6,6,3      op: bajar pila
40:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
41:       ADD       0,1,0      op: +
*      <- Operacion: mas
42:       LDA       2,0(0)      Pasando operador izquierdo a la pila
43:       SUB       6,6,3      op: subir pila
44:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
45:       LD       0,3(5)      cargar valor de identificador: c
*      <- identificador
46:       LD       2,0(6)      op: pop o cargo de la pila el valor
47:       ADD       6,6,3      op: bajar pila
48:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
49:       ADD       0,1,0      op: +
*      <- Operacion: mas
50:       LD       2,0(6)      op: pop o cargo de la pila el valor
51:       ADD       6,6,3      op: bajar pila
52:       SUB       6,6,3      op: subir pila
53:       ST       0,0(6)      Cargo variable que genero el return en temporales
54:       LDA       7,0(2)      Regreso a donde fui llamado
*      Bloque principal
3:       LDA       7,51(7)      bloque unico: jmp a bloque principal
*      -> escribir
55:       LDA       2,0(7)      carga la linea donde me encuentro, llamada a funcion
56:       SUB       6,6,3      op: subir pila
57:       ST       2,0(6)      op: push en la pila tmp
58:       LDA       4,0(6)      cargando ubicacion de la pila, para la llamada del retunn
*      -> constante 1
59:       LDC       0,1(0)      cargar constante: 1
*      <- constante
60:       LDA       2,0(0)       carga parametro en llamada a funcion
61:       SUB       6,6,3      op: subir pila
62:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
63:       LDC       0,2(0)      cargar constante: 2
*      <- constante
64:       LDA       2,0(0)       carga parametro en llamada a funcion
65:       SUB       6,6,3      op: subir pila
66:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 0
67:       LDC       0,0(0)      cargar constante: false
*      <- constante
68:       LDA       2,0(0)       carga parametro en llamada a funcion
69:       SUB       6,6,3      op: subir pila
70:       ST       2,0(6)      op: push en la pila tmp
71:       LDC       2,74(0)      Cargando verdareda linea de retorno
72:       ST       2,0(4)      Paso ubicacion a la pila
73:       LDC       7,4(0)      carga salto  4
74:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
75:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
