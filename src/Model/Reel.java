import java.util.Random; // Importa la clase Random para generar números aleatorios

public class Reel {
    private String[] symbols = {"🍒", "🍋", "🍊", "🍉", "⭐"}; // Array que contiene los símbolos de la máquina tragamonedas
    private Random random; // Instancia de la clase Random para generar números aleatorios

    // Constructor que inicializa el objeto Reel
    public Reel() {
        random = new Random(); // Crea una nueva instancia de Random
    }

    // Método que simula el giro del carrete y devuelve un símbolo aleatorio
    public String spin() {
        // Genera un índice aleatorio y devuelve el símbolo correspondiente
        return symbols[random.nextInt(symbols.length)];
    }
}
