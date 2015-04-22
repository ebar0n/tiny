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
19:       LDA       2,0(0)      Cargo variable que genero el return en temporales
20:       SUB       6,6,3      op: subir pila
21:       ST       2,0(6)      op: push en la pila tmp
22:       LDA       7,0(4)      Regreso a donde fui llamado
*      Bloque principal
3:       LDA       7,19(7)      bloque unico: jmp a bloque principal
*      -> escribir
*      -> constante 1
23:       LDC       0,1(0)      cargar constante: 1
*      <- constante
24:       LDA       2,0(0)       carga parametro en llamada a funcion
25:       SUB       6,6,3      op: subir pila
26:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 2
27:       LDC       0,2(0)      cargar constante: 2
*      <- constante
28:       LDA       2,0(0)       carga parametro en llamada a funcion
29:       SUB       6,6,3      op: subir pila
30:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 3
31:       LDC       0,3(0)      cargar constante: 3
*      <- constante
32:       LDA       2,0(0)       carga parametro en llamada a funcion
33:       SUB       6,6,3      op: subir pila
34:       ST       2,0(6)      op: push en la pila tmp
35:       LDC       2,38(0)      Cargando verdareda linea de retorno
36:       LDA       4,0(2)      Paso ubicacion a la pila
37:       LDC       7,4(0)      carga salto  4
38:       LDA       2,0(0)       carga parametro en llamada a funcion
39:       SUB       6,6,3      op: subir pila
40:       ST       2,0(6)      op: push en la pila tmp
41:       LDC       2,44(0)      Cargando verdareda linea de retorno
42:       LDA       4,0(2)      Paso ubicacion a la pila
43:       LDC       7,4(0)      carga salto  4
44:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
45:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
