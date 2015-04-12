#!/bin/bash
echo "# =================================================================== #"
echo "# ===========Generando analizador lexico: (JFLEX)==================== #"
echo "# =================================================================== #"
java -jar JAR/JFlex.jar -d src/compilador especificacion_lexica/lexico.flex
echo "# =================================================================== #"
echo "# ===============Generando analizador sintactico: (CUP)============== #"
echo "# =================================================================== #"
java -jar JAR/java-cup-11a.jar -destdir src/compilador/ especificacion_sintactica/sintactico.cup
