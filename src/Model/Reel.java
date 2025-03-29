import java.util.Random;

public class Reel {
    private String[] symbols = {"🍒", "🍋", "🍊", "🍉", "⭐"};
    private Random random;

    public Reel() {
        random = new Random();
    }

    public String spin() {
        return symbols[random.nextInt(symbols.length)];
    }
}
