public class SlotMachine {
    private Reel[] reels;
    private int bet;

    public SlotMachine(int numberOfReels) {
        reels = new Reel[numberOfReels];
        for (int i = 0; i < numberOfReels; i++) {
            reels[i] = new Reel();
        }
    }

    public synchronized void setBet(int bet) {
        this.bet = bet;
    }

    public synchronized String spin() {
        StringBuilder result = new StringBuilder();
        for (Reel reel : reels) {
            result.append(reel.spin()).append(" ");
            try {
                Thread.sleep(500); // Simula el tiempo de giro de cada carrete
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return result.toString().trim();
    }

    public int calculateWinnings(String result) {
        String[] symbols = result.split(" ");
        if (symbols.length == reels.length && allEqual(symbols)) {
            return bet * 2;
        }
        return 0;
    }

    private boolean allEqual(String[] symbols) {
        String first = symbols[0];
        for (String symbol : symbols) {
            if (!symbol.equals(first)) {
                return false;
            }
        }
        return true;
    }
}
