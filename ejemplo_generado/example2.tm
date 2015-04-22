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
6:       ST       2,2(0)      Guardo en la direccion
7:       LD       2,0(6)      op: pop o cargo de la pila el valor
8:       ADD       6,6,3      op: bajar pila
9:       ST       2,1(0)      Guardo en la direccion
10:       LD       2,0(6)      op: pop o cargo de la pila el valor
11:       ADD       6,6,3      op: bajar pila
12:       ST       2,0(0)      Guardo en la direccion
*      bloque normal
*      -> Operacion: mas
*      -> identificador
13:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
14:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> identificador
15:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
16:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
17:       ADD       0,1,0      op: +
*      <- Operacion: mas
18:       LD       2,0(6)      op: pop o cargo de la pila el valor
19:       ADD       6,6,3      op: bajar pila
20:       SUB       6,6,3      op: subir pila
21:       ST       0,0(6)      Cargo variable que genero el return en temporales
22:       ST       7,0(2)      Regreso a donde fui llamado
*      Bloque principal
3:       LDA       7,19(7)      bloque unico: jmp a bloque principal
*      -> escribir
23:       LDA       2,7(0)      carga la linea donde me encuentro, llamada a funcion
24:       ST       2,0(6)      op: push en la pila tmp
25:       SUB       6,6,3      op: subir pila
*      -> constante 1
26:       LDC       0,1(0)      cargar constante: 1
*      <- constante
27:       LDA       2,0(0)       carga parametro en llamada a funcion
28:       ST       2,0(6)      op: push en la pila tmp
29:       SUB       6,6,3      op: subir pila
*      -> constante 2
30:       LDC       0,2(0)      cargar constante: 2
*      <- constante
31:       LDA       2,0(0)       carga parametro en llamada a funcion
32:       ST       2,0(6)      op: push en la pila tmp
33:       SUB       6,6,3      op: subir pila
*      -> constante 0
34:       LDC       0,0(0)      cargar constante: false
*      <- constante
35:       LDA       2,0(0)       carga parametro en llamada a funcion
36:       ST       2,0(6)      op: push en la pila tmp
37:       SUB       6,6,3      op: subir pila
38:       LDC       7,6(0)      carga salto
39:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
40:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
