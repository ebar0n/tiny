*
*
* ------ CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
*
*
*      Compilacion TINY para el codigo objeto TM
*      Archivo: NOMBRE_ARREGLAR
*      Preludio estandar:
0:       LD       6,0(0)      cargar la maxima direccion desde la localidad 0
1:       ST       0,0(0)      limpio el registro de la localidad 0
*      -> asignacion
*      -> constante
2:       LDC       0,1(0)      cargar constante: 1
*      <- constante
3:       ST       0,2(5)      asignacion: almaceno el valor para el id x
*      <- asignacion
*      -> for
*      -> asignacion
*      -> constante
4:       LDC       0,0(0)      cargar constante: 0
*      <- constante
5:       ST       0,0(5)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
6:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
7:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> constante
8:       LDC       0,1(0)      cargar constante: 1
*      <- constante
9:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
10:       ADD       0,1,0      op: +
*      <- Operacion: mas
11:       ST       0,0(5)      asignacion: almaceno el valor para el id a
*      <- asignacion
*      -> asignacion
*      -> Operacion: por
*      -> identificador
12:       LD       0,2(5)      cargar valor de identificador: x
*      <- identificador
13:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> constante
14:       LDC       0,2(0)      cargar constante: 2
*      <- constante
15:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
16:       MUL       0,1,0      op: *
*      <- Operacion: por
17:       ST       0,2(5)      asignacion: almaceno el valor para el id x
*      <- asignacion
*      -> escribir
*      -> identificador
18:       LD       0,2(5)      cargar valor de identificador: x
*      <- identificador
19:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> for
*      -> asignacion
*      -> constante
20:       LDC       0,0(0)      cargar constante: 0
*      <- constante
21:       ST       0,1(5)      asignacion: almaceno el valor para el id b
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
22:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
23:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> constante
24:       LDC       0,1(0)      cargar constante: 1
*      <- constante
25:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
26:       ADD       0,1,0      op: +
*      <- Operacion: mas
27:       ST       0,1(5)      asignacion: almaceno el valor para el id b
*      <- asignacion
*      -> escribir
*      -> identificador
28:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
29:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> for
*      -> asignacion
*      -> constante
30:       LDC       0,0(0)      cargar constante: 0
*      <- constante
31:       ST       0,3(5)      asignacion: almaceno el valor para el id c
*      <- asignacion
*      for condicion: el salto hacia la condicion del for debe estar aqui
*      -> asignacion
*      -> Operacion: mas
*      -> identificador
32:       LD       0,3(5)      cargar valor de identificador: c
*      <- identificador
33:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> constante
34:       LDC       0,1(0)      cargar constante: 1
*      <- constante
35:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
36:       ADD       0,1,0      op: +
*      <- Operacion: mas
37:       ST       0,3(5)      asignacion: almaceno el valor para el id c
*      <- asignacion
*      -> escribir
*      -> identificador
38:       LD       0,3(5)      cargar valor de identificador: c
*      <- identificador
39:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      -> Operacion: menor
*      -> identificador
40:       LD       0,3(5)      cargar valor de identificador: c
*      <- identificador
41:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> constante
42:       LDC       0,2(0)      cargar constante: 2
*      <- constante
43:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
44:       SUB       0,1,0      op: <
45:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
46:       LDC       0,0(0)      caso de falso (AC=0)
47:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
48:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
49:       JNE       0,-18(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> Operacion: menor
*      -> identificador
50:       LD       0,1(5)      cargar valor de identificador: b
*      <- identificador
51:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> constante
52:       LDC       0,2(0)      cargar constante: 2
*      <- constante
53:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
54:       SUB       0,1,0      op: <
55:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
56:       LDC       0,0(0)      caso de falso (AC=0)
57:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
58:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
59:       JNE       0,-38(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      -> Operacion: menor
*      -> identificador
60:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
61:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> constante
62:       LDC       0,7(0)      cargar constante: 7
*      <- constante
63:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
64:       SUB       0,1,0      op: <
65:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
66:       LDC       0,0(0)      caso de falso (AC=0)
67:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
68:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
69:       JNE       0,-64(7)      for: jmp hacia el inicio del cuerpo
*      <- for
*      Fin de la ejecucion.
70:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
