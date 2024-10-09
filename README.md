**Juego** 

Debemos controlar un personaje (una bola azul con ojos) a través de un laberinto y llegar a la meta. Cada nivel tiene un diseño distinto y un mayor nivel de dificultad.
El laberinto se compone de bloques y caminos libres. Los bloques (paredes) están representados por cuadrados de diferentes colores, según el nivel en el que te encuentres.
El personaje no puede atravesar las paredes, llevalo desde el inicio del laberinto hasta el final, marcado con la palabra "Fin". ¡Ten cuidado con los enemigos!.

**Instrucciones para Ejecutar:**

Descomprime el archivo ZIP y coloca los archivos en una carpeta local.
1. Abre Eclipse.
2. Ve a File > New > Java Project.
3. Asigna un nombre al proyecto y haz clic en Finish.
4. Una vez creado el proyecto, haz clic derecho sobre él en el panel izquierdo y selecciona Import.
5. Selecciona File System y busca la carpeta donde están los archivos de código (Juego.java, Personaje.java, Laberinto.java, Enemigo.java, etc).
6. Haz clic en Finish para importar los archivos.

Comprueba que el package de los archivos sea mazecab y que todas las clases estén correctamente importadas.
Haz clic derecho en el archivo Juego.java y selecciona Run As > Java Application para ejecutar el juego.

**Requerimientos**:

Java JDK: Asegúrate de tener instalada la versión correcta de Java Development Kit (JDK).

Eclipse IDE: El código está pensado para ser ejecutado en un entorno de desarrollo como Eclipse.

Librerías: Utiliza las librerías estándar de Java como javax.swing para la interfaz gráfica y java.awt para los gráficos.

**Controles del Juego:**
Movimiento del personaje: Usa las teclas de flechas (arriba, abajo, izquierda, derecha) para mover al personaje dentro del laberinto.
