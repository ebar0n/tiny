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
*      -> escribir
*      -> constante 1
4:       LDC       0,1(0)      cargar constante: true
*      <- constante
5:       LDA       2,0(0)       carga parametro en llamada a funcion
6:       SUB       6,6,3      op: subir pila
7:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
8:       LDC       0,1(0)      cargar constante: true
*      <- constante
9:       LDA       2,0(0)       carga parametro en llamada a funcion
10:       SUB       6,6,3      op: subir pila
11:       ST       2,0(6)      op: push en la pila tmp
12:       LD       2,0(6)      op: pop o cargo de la pila el valor
13:       ADD       6,6,3      op: bajar pila
14:       MUL       0,0,2      op: *
15:       LD       2,0(6)      op: pop o cargo de la pila el valor
16:       ADD       6,6,3      op: bajar pila
17:       MUL       0,0,2      op: *
18:       LDA       2,0(0)       carga parametro en llamada a funcion
19:       SUB       6,6,3      op: subir pila
20:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
21:       LDC       0,1(0)      cargar constante: true
*      <- constante
22:       LDA       2,0(0)       carga parametro en llamada a funcion
23:       SUB       6,6,3      op: subir pila
24:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
25:       LDC       0,1(0)      cargar constante: true
*      <- constante
26:       LDA       2,0(0)       carga parametro en llamada a funcion
27:       SUB       6,6,3      op: subir pila
28:       ST       2,0(6)      op: push en la pila tmp
29:       LD       2,0(6)      op: pop o cargo de la pila el valor
30:       ADD       6,6,3      op: bajar pila
31:       MUL       0,0,2      op: *
32:       LD       2,0(6)      op: pop o cargo de la pila el valor
33:       ADD       6,6,3      op: bajar pila
34:       MUL       0,0,2      op: *
35:       LDA       2,0(0)       carga parametro en llamada a funcion
36:       SUB       6,6,3      op: subir pila
37:       ST       2,0(6)      op: push en la pila tmp
38:       LD       2,0(6)      op: pop o cargo de la pila el valor
39:       ADD       6,6,3      op: bajar pila
40:       MUL       0,0,2      op: *
41:       LD       2,0(6)      op: pop o cargo de la pila el valor
42:       ADD       6,6,3      op: bajar pila
43:       MUL       0,0,2      op: *
44:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
45:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
