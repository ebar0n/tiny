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
*      -> Operacion: mas
*      -> identificador
10:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
11:       LDA       2,0(0)      Pasando operador izquierdo a la pila
12:       SUB       6,6,3      op: subir pila
13:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
14:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
15:       LD       2,0(6)      op: pop o cargo de la pila el valor
16:       ADD       6,6,3      op: bajar pila
17:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
18:       ADD       0,1,0      op: +
*      <- Operacion: mas
19:       LDA       7,0(4)      Regreso a donde fui llamado
*      Bloque principal
3:       LDA       7,16(7)      bloque unico: jmp a bloque principal
*      -> escribir
*      -> constante 1
20:       LDC       0,1(0)      cargar constante: 1
*      <- constante
21:       LDA       2,0(0)       carga parametro en llamada a funcion
22:       SUB       6,6,3      op: subir pila
23:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
24:       LDC       0,2(0)      cargar constante: 2
*      <- constante
25:       LDA       2,0(0)       carga parametro en llamada a funcion
26:       SUB       6,6,3      op: subir pila
27:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
28:       LDC       0,3(0)      cargar constante: 3
*      <- constante
29:       LDA       2,0(0)       carga parametro en llamada a funcion
30:       SUB       6,6,3      op: subir pila
31:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 4
32:       LDC       0,4(0)      cargar constante: 4
*      <- constante
33:       LDA       2,0(0)       carga parametro en llamada a funcion
34:       SUB       6,6,3      op: subir pila
35:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 5
36:       LDC       0,5(0)      cargar constante: 5
*      <- constante
37:       LDA       2,0(0)       carga parametro en llamada a funcion
38:       SUB       6,6,3      op: subir pila
39:       ST       2,0(6)      op: push en la pila tmp
40:       LDC       2,43(0)      Cargando verdareda linea de retorno
41:       LDA       4,0(2)      Paso ubicacion a la pila
42:       LDC       7,4(0)      carga salto  4
43:       LDA       2,0(0)       carga parametro en llamada a funcion
44:       SUB       6,6,3      op: subir pila
45:       ST       2,0(6)      op: push en la pila tmp
46:       LDC       2,49(0)      Cargando verdareda linea de retorno
47:       LDA       4,0(2)      Paso ubicacion a la pila
48:       LDC       7,4(0)      carga salto  4
49:       LDA       2,0(0)       carga parametro en llamada a funcion
50:       SUB       6,6,3      op: subir pila
51:       ST       2,0(6)      op: push en la pila tmp
52:       LDC       2,55(0)      Cargando verdareda linea de retorno
53:       LDA       4,0(2)      Paso ubicacion a la pila
54:       LDC       7,4(0)      carga salto  4
55:       LDA       2,0(0)       carga parametro en llamada a funcion
56:       SUB       6,6,3      op: subir pila
57:       ST       2,0(6)      op: push en la pila tmp
58:       LDC       2,61(0)      Cargando verdareda linea de retorno
59:       LDA       4,0(2)      Paso ubicacion a la pila
60:       LDC       7,4(0)      carga salto  4
61:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> escribir
*      -> constante 1
62:       LDC       0,1(0)      cargar constante: 1
*      <- constante
63:       LDA       2,0(0)       carga parametro en llamada a funcion
64:       SUB       6,6,3      op: subir pila
65:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
66:       LDC       0,2(0)      cargar constante: 2
*      <- constante
67:       LDA       2,0(0)       carga parametro en llamada a funcion
68:       SUB       6,6,3      op: subir pila
69:       ST       2,0(6)      op: push en la pila tmp
70:       LDC       2,73(0)      Cargando verdareda linea de retorno
71:       LDA       4,0(2)      Paso ubicacion a la pila
72:       LDC       7,4(0)      carga salto  4
73:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
74:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
