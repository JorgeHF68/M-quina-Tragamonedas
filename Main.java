public class Main {
    // Método principal que se ejecuta al iniciar la aplicación
    public static void main(String[] args) {
        // Crea una instancia de la máquina tragamonedas con 3 carretes
        SlotMachine slotMachine = new SlotMachine(3);
        
        // Crea una instancia de la vista gráfica
        GUIView view = new GUIView();
        
        // Crea una instancia del controlador, que conecta la máquina tragamonedas y la vista
        GameController controller = new GameController(slotMachine, view);
    }
}
