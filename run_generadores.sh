#!/bin/bash

OPTION=$1
shift 1

case "$OPTION" in 
    "compile" )
        echo "# =================================================================== #"
        echo "# ===========Generando analizador lexico: (JFLEX)==================== #"
        echo "# =================================================================== #"
        java -jar JAR/JFlex.jar -d src/compilador especificacion_lexica/lexico.flex
        echo "# =================================================================== #"
        echo "# ===============Generando analizador sintactico: (CUP)============== #"
        echo "# =================================================================== #"
        java -jar JAR/java-cup-11a.jar $@ -destdir src/compilador/ especificacion_sintactica/sintactico.cup
    ;;

    "run" )
        FILE=$1
        javac -sourcepath ./src -classpath ./JAR/java-cup-11a-runtime.jar ./src/compilador/Compilador.java -d build/classes 
        java -cp ./build/classes:./JAR/java-cup-11a-runtime.jar compilador.Compilador $FILE
    ;;

esac
