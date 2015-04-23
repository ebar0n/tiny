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
*      -> leer
6:       IN       0,0,0      leer: lee un valor entero 
7:       ST       0,1(5)      leer: almaceno el valor entero leido
*      <- leer
*      -> escribir
*      -> identificador
8:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
*      -> identificador
11:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
9:       LDC       4,12(0)      cargo linea para el proximo salto
10:       JNE       0,0(4)      voy dos instrucciones mas alla if verdadero (AC==0)
12:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
13:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
