public class Bet {
    private int amount; // Variable privada que almacena el monto de la apuesta

    // Constructor que inicializa el objeto Bet con un monto específico
    public Bet(int amount) {
        this.amount = amount; // Asigna el monto de la apuesta a la variable de instancia
    }

    // Método público que devuelve el monto de la apuesta
    public int getAmount() {
        return amount; // Retorna el monto de la apuesta
    }
}

