import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    public int getBet() {
        int bet = -1;
        while (bet < 1) {
            System.out.print("Ingrese su apuesta: ");
            if (scanner.hasNextInt()) {
                bet = scanner.nextInt();
                if (bet < 1) {
                    System.out.println("La apuesta debe ser mayor a 0.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                scanner.next(); // Limpia el input incorrecto
            }
        }
        return bet;
    }

    public void displayResult(String result, int winnings) {
        System.out.println("Resultado: " + result);
        if (winnings > 0) {
            System.out.println("¡Ganaste " + winnings + "!");
        } else {
            System.out.println("Intenta de nuevo.");
        }
    }
}
