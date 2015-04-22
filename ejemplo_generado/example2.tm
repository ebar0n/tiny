*      Compilacion TINY para el codigo objeto TM
*      Archivo: NOMBRE_ARREGLAR
*      Inicio Preludio estandar:
0:       LD       6,0(0)      cargar la maxima direccion desde la localidad 0
1:       ST       0,0(0)      limpio el registro de la localidad 0
2:       LDC       3,1(0)      carga constante, para usos de movimientos recursivos
*      Fin Preludio estandar:
3:       LD       2,0(6)      op: pop o cargo de la pila el valor
4:       ADD       6,6,3      op: bajar pila
5:       ST       2,2(0)      Guardo en la direccion
6:       LD       2,0(6)      op: pop o cargo de la pila el valor
7:       ADD       6,6,3      op: bajar pila
8:       ST       2,1(0)      Guardo en la direccion
9:       LD       2,0(6)      op: pop o cargo de la pila el valor
10:       ADD       6,6,3      op: bajar pila
11:       ST       2,0(0)      Guardo en la direccion
0:       LD       7,11(7)      null
*      -> Operacion: mas
*      -> identificador
12:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
13:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> identificador
14:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
15:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
16:       ADD       0,1,0      op: +
*      <- Operacion: mas
17:       LD       2,0(6)      op: pop o cargo de la pila el valor
18:       ADD       6,6,3      op: bajar pila
19:       SUB       6,6,3      op: subir pila
20:       ST       0,0(6)      Cargo variable que genero el return en temporales
21:       ST       7,0(2)      Regreso a donde fui llamado
0:       LD       7,21(7)      null
*      -> escribir
22:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      Fin de la ejecucion.
23:       HALT       0,0,0