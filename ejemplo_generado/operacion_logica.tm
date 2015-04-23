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
6:       ST       2,0(5)      Guardo en la direccion 0 a
*      bloque normal
*      -> identificador
7:       LD       0,0(5)      cargar valor de identificador: a
*      <- identificador
8:       LD       2,0(6)      op: pop o cargo de la pila el valor
9:       ADD       6,6,3      op: bajar pila
10:       LDA       7,0(2)      Regreso a donde fui llamado
11:       LD       2,0(6)      op: pop o cargo de la pila el valor
12:       ADD       6,6,3      op: bajar pila
13:       ST       2,1(5)      Guardo en la direccion 1 a
*      bloque normal
*      -> identificador
17:       LD       0,1(5)      cargar valor de identificador: a
*      <- identificador
18:       LDA       2,0(0)       carga parametro en llamada a funcion
19:       SUB       6,6,3      op: subir pila
20:       ST       2,0(6)      op: push en la pila tmp
14:       LDC       2,22(0)      Cargando verdareda linea de retorno :)
15:       SUB       6,6,3      op: subir pila
16:       ST       2,0(6)      op: push en la pila tmp
21:       LDC       7,4(0)      carga salto  4
22:       LD       2,0(6)      op: pop o cargo de la pila el valor
23:       ADD       6,6,3      op: bajar pila
24:       LDA       7,0(2)      Regreso a donde fui llamado
*      Bloque principal
3:       LDA       7,21(7)      bloque unico: jmp a bloque principal
*      -> if
*      -> Operacion: menor
*      -> constante 1
28:       LDC       0,1(0)      cargar constante: 1
*      <- constante
29:       LDA       2,0(0)       carga parametro en llamada a funcion
30:       SUB       6,6,3      op: subir pila
31:       ST       2,0(6)      op: push en la pila tmp
25:       LDC       2,33(0)      Cargando verdareda linea de retorno :)
26:       SUB       6,6,3      op: subir pila
27:       ST       2,0(6)      op: push en la pila tmp
32:       LDC       7,11(0)      carga salto  11
33:       LDA       2,0(0)      Pasando operador izquierdo a la pila
34:       SUB       6,6,3      op: subir pila
35:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 7
36:       LDC       0,7(0)      cargar constante: 7
*      <- constante
37:       LD       2,0(6)      op: pop o cargo de la pila el valor
38:       ADD       6,6,3      op: bajar pila
39:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
40:       SUB       0,1,0      op: <
41:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
42:       LDC       0,0(0)      caso de falso (AC=0)
43:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
44:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
*      -> Operacion: mayor
*      -> constante 2
48:       LDC       0,2(0)      cargar constante: 2
*      <- constante
49:       LDA       2,0(0)       carga parametro en llamada a funcion
50:       SUB       6,6,3      op: subir pila
51:       ST       2,0(6)      op: push en la pila tmp
45:       LDC       2,53(0)      Cargando verdareda linea de retorno :)
46:       SUB       6,6,3      op: subir pila
47:       ST       2,0(6)      op: push en la pila tmp
52:       LDC       7,11(0)      carga salto  11
53:       LDA       2,0(0)      Pasando operador izquierdo a la pila
54:       SUB       6,6,3      op: subir pila
55:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
56:       LDC       0,1(0)      cargar constante: 1
*      <- constante
57:       LD       2,0(6)      op: pop o cargo de la pila el valor
58:       ADD       6,6,3      op: bajar pila
59:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
60:       SUB       0,1,0      op: >
61:       JGT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC>0)
62:       LDC       0,0(0)      caso de falso (AC=0)
63:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
64:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: mayor
*      -> Operacion: menor
*      -> constante 2
68:       LDC       0,2(0)      cargar constante: 2
*      <- constante
69:       LDA       2,0(0)       carga parametro en llamada a funcion
70:       SUB       6,6,3      op: subir pila
71:       ST       2,0(6)      op: push en la pila tmp
65:       LDC       2,73(0)      Cargando verdareda linea de retorno :)
66:       SUB       6,6,3      op: subir pila
67:       ST       2,0(6)      op: push en la pila tmp
72:       LDC       7,11(0)      carga salto  11
73:       LDA       2,0(0)      Pasando operador izquierdo a la pila
74:       SUB       6,6,3      op: subir pila
75:       ST       2,0(6)      op: push en la pila tmp
*      -> constante 1
76:       LDC       0,1(0)      cargar constante: 1
*      <- constante
77:       LD       2,0(6)      op: pop o cargo de la pila el valor
78:       ADD       6,6,3      op: bajar pila
79:       LDA       1,0(2)      Pasando operador izquierdo de la pila a AC1
80:       SUB       0,1,0      op: <
81:       JLT       0,2(7)      voy dos instrucciones mas alla if verdadero (AC<0)
82:       LDC       0,0(0)      caso de falso (AC=0)
83:       LDA       7,1(7)      Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)
84:       LDC       0,1(0)      caso de verdadero (AC=1)
*      <- Operacion: menor
*      If: el salto hacia el else debe estar aqui
*      -> escribir
*      -> constante 1
86:       LDC       0,1(0)      cargar constante: true
*      <- constante
87:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
*      If: el salto hacia el final debe estar aqui
85:       JEQ       0,3(7)      if: jmp hacia else
*      -> escribir
*      -> constante 0
89:       LDC       0,0(0)      cargar constante: false
*      <- constante
90:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
88:       LDA       7,2(7)      if: salto incondicional hacia el final
*      <- if
*      Fin de la ejecucion.
91:       HALT       0,0,0      
*
*
* ------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------
