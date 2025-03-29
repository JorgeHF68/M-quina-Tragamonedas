import java.awt.event.ActionEvent; // Importa la clase ActionEvent para manejar eventos de acción
import java.awt.event.ActionListener; // Importa la interfaz ActionListener para escuchar eventos de acción

public class GameController {
    private SlotMachine slotMachine; // Instancia de la máquina tragamonedas
    private GUIView view; // Instancia de la vista gráfica

    // Constructor que inicializa el controlador con la máquina tragamonedas y la vista
    public GameController(SlotMachine slotMachine, GUIView view) {
        this.slotMachine = slotMachine; // Asigna la máquina tragamonedas a la variable de instancia
        this.view = view; // Asigna la vista a la variable de instancia

        // Agrega un listener al botón de girar en la vista
        view.addSpinButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Método que se ejecuta cuando se presiona el botón
                int bet = view.getBet(); // Obtiene la apuesta ingresada por el usuario
                if (bet <= 0) { // Verifica si la apuesta es válida
                    view.displayResult("Apuesta inválida. Inténtalo de nuevo.", 0); // Muestra un mensaje de error
                    return; // Sale del método si la apuesta es inválida
                }

                slotMachine.setBet(bet); // Establece la apuesta en la máquina tragamonedas

                // Ejecutar la lógica en un hilo separado para no bloquear la interfaz de usuario
                new Thread(() -> {
                    String result = slotMachine.spin(); // Gira la máquina tragamonedas y obtiene el resultado
                    int winnings = slotMachine.calculateWinnings(result); // Calcula las ganancias basadas en el resultado

                    // Actualiza la interfaz de usuario en el hilo de eventos de Swing
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        view.displayResult(result, winnings); // Muestra el resultado y las ganancias en la vista
                    });
                }).start(); // Inicia el hilo
            }
        });
    }
}
