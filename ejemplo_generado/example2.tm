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
*      -> Operacion: mas
*      -> identificador
13:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
14:       LDA       2,0(0)      Pasando operador izquierdo a la pila
15:       ST       2,0(6)      op: push en la pila tmp
16:       SUB       6,6,3      op: subir pila
*      -> identificador
17:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
18:       LD       2,0(6)      op: pop o cargo de la pila el valor
19:       ADD       6,6,3      op: bajar pila
20:       LDA       1,2(0)      Pasando operador izquierdo de la pila a AC1
21:       ADD       0,1,0      op: +
*      <- Operacion: mas
22:       LD       2,0(6)      op: pop o cargo de la pila el valor
23:       ADD       6,6,3      op: bajar pila
24:       SUB       6,6,3      op: subir pila
25:       ST       0,0(6)      Cargo variable que genero el return en temporales
26:       ST       7,0(2)      Regreso a donde fui llamado
*      Bloque principal
3:       LDA       7,23(7)      bloque unico: jmp a bloque principal
*      -> escribir
27:       LDA       2,0(7)      carga la linea donde me encuentro, llamada a funcion
28:       ST       2,0(6)      op: push en la pila tmp
29:       SUB       6,6,3      op: subir pila
*      -> constante 1
30:       LDC       0,1(0)      cargar constante: 1
*      <- constante
31:       LDA       2,0(0)       carga parametro en llamada a funcion
32:       ST       2,0(6)      op: push en la pila tmp
33:       SUB       6,6,3      op: subir pila
*      -> constante 2
34:       LDC       0,2(0)      cargar constante: 2
*      <- constante
35:       LDA       2,0(0)       carga parametro en llamada a funcion
36:       ST       2,0(6)      op: push en la pila tmp
37:       SUB       6,6,3      op: subir pila
*      -> constante 0
38:       LDC       0,0(0)      cargar constante: false
*      <- constante
39:       LDA       2,0(0)       carga parametro en llamada a funcion
40:       ST       2,0(6)      op: push en la pila tmp
41:       SUB       6,6,3      op: subir pila
42:       LDC       7,4(0)      carga salto  4
43:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
44:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
