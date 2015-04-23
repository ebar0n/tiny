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
*      bloque normal
*      -> for
*      -> asignacion
*      -> constante 0
4:       LDC       0,0(0)      cargar constante: 0
*      <- constante
5:       ST       0,0(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> escribir
*      -> identificador
6:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
7:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
8:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
9:       LDA       2,0(0)      Pasando operador izquierdo a la pila
10:       SUB       6,6,3      op: subir pila
11:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
12:       LDC       0,1(0)      cargar constante: 1
*      <- constante
13:       LD       2,0(6)      op: pop o cargo de la pila el valor
14:       ADD       6,6,3      op: bajar pila
15:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
16:       ADD       0,1,0      op: +
*      <- Operacion: mas
17:       ST       0,0(5)      leer: almaceno el valor entero leido
*      <- asignacion
*      -> Operacion: menor
*      -> identificador
18:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
19:       LDA       2,0(0)      Pasando operador izquierdo a la pila
20:       SUB       6,6,3      op: subir pila
21:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 100
22:       LDC       0,100(0)      cargar constante: 100
*      <- constante
23:       LD       2,0(6)      op: pop o cargo de la pila el valor
24:       ADD       6,6,3      op: bajar pila
25:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
26:       SUB       0,1,0      op: <
27:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
28:       LDC       0,0(0)      caso de falso (AC=0)
29:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
30:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
31:       JNE       0,-26(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> constante 1
32:       LDC       0,1(0)      cargar constante: true
*      <- constante
33:       LD       2,0(6)      op: pop o cargo de la pila el valor
34:       ADD       6,6,3      op: bajar pila
35:       LDA       7,0(2)      Regreso a donde fui llamado
*      Bloque principal
3:       LDA       7,32(7)      bloque unico: jmp a bloque principal
*      -> leer
36:       IN       0,0,0      leer: lee un valor entero 
37:       ST       0,1(5)      leer: almaceno el valor entero leido
*      <- leer
*      -> if
*      -> identificador
38:       LD       0,1(5)      cargar valor de identificador: a
*      <- identificador
41:       LDC       2,45(0)      Cargando verdareda linea de retorno :)
42:       SUB       6,6,3      op: subir pila
43:       ST       2,0(6)      op: push en la pila tmp
44:       LDC       7,4(0)      carga salto  4
39:       LDC       4,45(0)      cargo linea para el proximo salto
40:       JNE       0,0(4)      voy dos instrucciones mas alla if verdadero (AC==0)
*      If: el salto hacia el else debe estar aqui
*      -> escribir
*      -> constante 1
46:       LDC       0,1(0)      cargar constante: true
*      <- constante
47:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      If: el salto hacia el final debe estar aqui
45:       JEQ       0,3(7)      if: jmp hacia else
*      -> escribir
*      -> constante 0
49:       LDC       0,0(0)      cargar constante: false
*      <- constante
50:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
48:       LDA       7,2(7)      if: salto incondicional hacia el final
*      <- if
*      Fin de la ejecucion.
51:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
