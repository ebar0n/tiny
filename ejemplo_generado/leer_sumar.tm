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
*      -> constante -1000
6:       LDC       0,-1000(0)      cargar constante: -1000
*      <- constante
7:       LDA       2,0(0)      copiamos exprecion
8:       SUB       6,6,3      op: subir pila
9:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 0
10:       LDC       0,0(0)      cargar constante: 0
*      <- constante
11:       LD       2,0(6)      op: pop o cargo de la pila el valor
12:       ADD       6,6,3      op: bajar pila
13:       ST       2,1(0)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> asignacion
*      -> Operacion: mas
*      -> vector
*      -> constante 0
14:       LDC       0,0(0)      cargar constante: 0
*      <- constante
15:       LD       0,1(0)      op: pop o cargo de la pila el valor
*      <- vector
16:       LDA       2,0(0)      Pasando operador izquierdo a la pila
17:       SUB       6,6,3      op: subir pila
18:       ST       2,0(6)      op: push en la pila tmp
*      -> identificador
19:       LD       0,0(5)      cargar valor de identificador: x
*      <- identificador
20:       LD       2,0(6)      op: pop o cargo de la pila el valor
21:       ADD       6,6,3      op: bajar pila
22:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
23:       ADD       0,1,0      op: +
*      <- Operacion: mas
24:       ST       0,2(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> escribir
*      -> identificador
25:       LD       0,2(5)      cargar valor de identificador: z
*      <- identificador
26:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
27:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
