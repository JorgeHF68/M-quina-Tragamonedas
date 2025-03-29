public class SlotMachine {
    private Reel[] reels; // Array que contiene los carretes de la máquina tragamonedas
    private int bet; // Monto de la apuesta actual

    // Constructor que inicializa la máquina tragamonedas con un número específico de carretes
    public SlotMachine(int numberOfReels) {
        reels = new Reel[numberOfReels]; // Crea un array de carretes
        for (int i = 0; i < numberOfReels; i++) {
            reels[i] = new Reel(); // Inicializa cada carrete
        }
    }

    // Método sincronizado para establecer la apuesta
    public synchronized void setBet(int bet) {
        this.bet = bet; // Asigna el monto de la apuesta a la variable de instancia
    }

    // Método sincronizado que simula el giro de los carretes y devuelve el resultado
    public synchronized String spin() {
        StringBuilder result = new StringBuilder(); // StringBuilder para construir el resultado
        for (Reel reel : reels) {
            result.append(reel.spin()).append(" "); // Gira cada carrete y agrega el símbolo al resultado
            try {
                Thread.sleep(500); // Simula el tiempo de giro de cada carrete
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaura el estado de interrupción del hilo
            }
        }
        return result.toString().trim(); // Devuelve el resultado como una cadena sin espacios adicionales
    }

    // Método que calcula las ganancias basadas en el resultado del giro
    public int calculateWinnings(String result) {
        String[] symbols = result.split(" "); // Divide el resultado en símbolos
        // Verifica si todos los símbolos son iguales y si la cantidad de símbolos coincide con el número de carretes
        if (symbols.length == reels.length && allEqual(symbols)) {
            return bet * 2; // Devuelve el doble de la apuesta si hay una combinación ganadora
        }
        return 0; // Devuelve 0 si no hay ganancias
    }

    // Método privado que verifica si todos los símbolos en el array son iguales
    private boolean allEqual(String[] symbols) {
        String first = symbols[0]; // Toma el primer símbolo como referencia
        for (String symbol : symbols) {
            if (!symbol.equals(first)) { // Compara cada símbolo con el primero
                return false; // Retorna false si encuentra un símbolo diferente
            }
        }
        return true; // Retorna true si todos los símbolos son iguales
    }
}
