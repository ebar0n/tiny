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
*      -> constante 1
4:       LDC       0,1(0)      cargar constante: 1
*      <- constante
5:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
6:       SUB       6,6,3      op: subir pila
7:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 0
8:       LDC       0,0(0)      cargar constante: 0
*      <- constante
9:       ADD       1,5,0      sumar desplazamiendo al registro L3
10:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
11:       LD       2,0(6)      op: pop o cargo de la pila el valor
12:       ADD       6,6,3      op: bajar pila
13:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> constante 4
14:       LDC       0,4(0)      cargar constante: 4
*      <- constante
15:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
16:       SUB       6,6,3      op: subir pila
17:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 3
18:       LDC       0,3(0)      cargar constante: 3
*      <- constante
19:       ADD       1,5,0      sumar desplazamiendo al registro L3
20:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
21:       LD       2,0(6)      op: pop o cargo de la pila el valor
22:       ADD       6,6,3      op: bajar pila
23:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> constante 2
24:       LDC       0,2(0)      cargar constante: 2
*      <- constante
25:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
26:       SUB       6,6,3      op: subir pila
27:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 1
28:       LDC       0,1(0)      cargar constante: 1
*      <- constante
29:       ADD       1,5,0      sumar desplazamiendo al registro L3
30:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
31:       LD       2,0(6)      op: pop o cargo de la pila el valor
32:       ADD       6,6,3      op: bajar pila
33:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> constante 3
34:       LDC       0,3(0)      cargar constante: 3
*      <- constante
35:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
36:       SUB       6,6,3      op: subir pila
37:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 2
38:       LDC       0,2(0)      cargar constante: 2
*      <- constante
39:       ADD       1,5,0      sumar desplazamiendo al registro L3
40:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
41:       LD       2,0(6)      op: pop o cargo de la pila el valor
42:       ADD       6,6,3      op: bajar pila
43:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> vector
*      -> constante 3
44:       LDC       0,3(0)      cargar constante: 3
*      <- constante
45:       ADD       1,5,0      sumar desplazamiendo al registro L3
46:       LD       0,0(1)      cargar valor de identificador: a
47:       LDA       0,0(0)      cargar valor de identificador: a
*      <- vector
48:       LDA       2,0(0)      asignacion: almaceno el valor para el id a
49:       SUB       6,6,3      op: subir pila
50:       ST       2,0(6)      op: push en la pila tmp
*      -> vector
*      -> constante 4
51:       LDC       0,4(0)      cargar constante: 4
*      <- constante
52:       ADD       1,5,0      sumar desplazamiendo al registro L3
53:       LD       0,0(1)      cargar valor de identificador: a
*      <- vector
54:       LD       2,0(6)      op: pop o cargo de la pila el valor
55:       ADD       6,6,3      op: bajar pila
56:       ST       2,0(1)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      Fin de la ejecucion.
57:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
