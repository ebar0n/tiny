*      Compilacion TINY para el codigo objeto TM
*      Archivo: NOMBRE_ARREGLAR
*      Preludio estandar:
0:       LD       6,0(0)      cargar la maxima direccion desde la localidad 0
1:       ST       0,0(0)      limpio el registro de la localidad 0
2:       LDC       3,1(0)      carga constante, para usos de movimientos recursivos
3:       LDA       2,7(0)      carga la linea donde me encuentro, llamada a funcion
4:       ST       2,0(6)      op: push en la pila tmp
5:       SUB       6,6,3      op: -
6:       IN       2,0,0      leer: lee un valor entero 
7:       ST       2,0(6)      op: push en la pila tmp
8:       SUB       6,6,3      op: -
9:       LDC       7,6(0)      carga salto
*      Fin de la ejecucion.
10:       HALT       0,0,0      