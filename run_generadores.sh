#!/bin/bash

case "$1" in 
    "compile" )
        echo "# =================================================================== #"
        echo "# ===========Generando analizador lexico: (JFLEX)==================== #"
        echo "# =================================================================== #"
        java -jar JAR/JFlex.jar -d src/compilador especificacion_lexica/lexico.flex
        echo "# =================================================================== #"
        echo "# ===============Generando analizador sintactico: (CUP)============== #"
        echo "# =================================================================== #"
        java -jar JAR/java-cup-11a.jar -destdir src/compilador/ especificacion_sintactica/sintactico.cup
    ;;

    "run" )
        javac -d build/classes -classpath src:compilador:src/ast:JAR/java-cup-11a-runtime.jar src/compilador/Compilador.java
        java -cp build/classes:JAR/java-cup-11a-runtime.jar compilador.Compilador $2
    ;;

esac
