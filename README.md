Máquina tragamonedas

Descripción:

Este es un juego de tragamonedas desarrollado en Java con el patrón "MVC".  
Cuenta con una interfaz de consola y una GUI, además de soporte para "concurrencia" mediante hilos.

Características
- Implementación del "patrón MVC".
- Uso de "hilos (Threads)"para el giro de los rodillos.
- Sicronización.
- Interfaces de usuario en "consola y GUI".

Cómo ejecutar
1. Clona el repositorio:
   git clone https://github.com/tu-usuario/tu-repo.git

2. Compila los archivos Java:
javac -d bin src/**/*.java

3. Ejecuta el juego:
java -cp bin Main

Estructura del Proyecto

 📂 src
 ├── 📂 model
 │   ├── Player.java
 │   ├── Bet.java
 │   ├── SlotMachine.java
 ├── 📂 view
 │   ├── ConsoleView.java
 │   ├── GUIView.java
 ├── 📂 controller
 │   ├── GameController.java
 ├── Main.java

 
Tecnologías usadas
Java
Swing (para GUI)
Manejo de Hilos (Threads)
