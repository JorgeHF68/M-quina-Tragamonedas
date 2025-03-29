import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario

public class ConsoleView {
    private Scanner scanner; // Variable privada que almacena la instancia de Scanner

    // Constructor que inicializa el objeto ConsoleView
    public ConsoleView() {
        scanner = new Scanner(System.in); // Crea una nueva instancia de Scanner para leer la entrada del sistema
    }

    // Método que solicita al usuario que ingrese una apuesta y la valida
    public int getBet() {
        int bet = -1; // Inicializa la apuesta con un valor inválido
        while (bet < 1) { // Continúa solicitando la apuesta hasta que sea válida
            System.out.print("Ingrese su apuesta: "); // Solicita al usuario que ingrese su apuesta
            if (scanner.hasNextInt()) { // Verifica si la entrada es un número entero
                bet = scanner.nextInt(); // Lee la apuesta ingresada
                if (bet < 1) { // Verifica si la apuesta es menor a 1
                    System.out.println("La apuesta debe ser mayor a 0."); // Mensaje de error si la apuesta es inválida
                }
            } else {
                System.out.println("Entrada inválida. Por favor ingrese un número."); // Mensaje de error si la entrada no es un número
                scanner.next(); // Limpia el input incorrecto para evitar un bucle infinito
            }
        }
        return bet; // Devuelve la apuesta válida
    }

    // Método que muestra el resultado del giro y las ganancias
    public void displayResult(String result, int winnings) {
        System.out.println("Resultado: " + result); // Muestra el resultado del giro
        if (winnings > 0) { // Verifica si hay ganancias
            System.out.println("¡Ganaste " + winnings + "!"); // Mensaje de éxito si hay ganancias
        } else {
            System.out.println("Intenta de nuevo."); // Mensaje de aliento si no hay ganancias
        }
    }
}
