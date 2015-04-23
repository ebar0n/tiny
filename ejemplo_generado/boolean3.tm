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
4:       LDC       0,1(0)      cargar constante: true
*      <- constante
*      -> constante 0
5:       LDC       0,0(0)      cargar constante: false
*      <- constante
*      -> constante 0
8:       LDC       0,0(0)      cargar constante: false
*      <- constante
6:       LDC       4,9(0)      cargo linea para el proximo salto
7:       JNE       0,0(4)      voy dos instrucciones mas alla if verdadero (AC==0)
9:       ST       0,0(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> escribir
*      -> identificador
10:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
11:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> constante 0
12:       LDC       0,0(0)      cargar constante: false
*      <- constante
*      -> identificador
13:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
*      -> identificador
14:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
*      -> constante 1
17:       LDC       0,1(0)      cargar constante: true
*      <- constante
15:       LDC       4,18(0)      cargo linea para el proximo salto
16:       JNE       0,0(4)      voy dos instrucciones mas alla if verdadero (AC==0)
18:       ST       0,1(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> escribir
*      -> identificador
19:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
20:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> identificador
21:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
*      -> identificador
24:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
22:       LDC       4,25(0)      cargo linea para el proximo salto
23:       JNE       0,0(4)      voy dos instrucciones mas alla if verdadero (AC==0)
25:       ST       0,2(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> escribir
*      -> identificador
26:       LD       0,2(5)      cargar valor de identificador: c
*      <- identificador
27:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> escribir
*      -> constante 1
28:       LDC       0,1(0)      cargar constante: true
*      <- constante
*      -> constante 0
31:       LDC       0,0(0)      cargar constante: false
*      <- constante
29:       LDC       4,32(0)      cargo linea para el proximo salto
30:       JNE       0,0(4)      voy dos instrucciones mas alla if verdadero (AC==0)
32:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
33:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
