import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private SlotMachine slotMachine;
    private GUIView view;

    public GameController(SlotMachine slotMachine, GUIView view) {
        this.slotMachine = slotMachine;
        this.view = view;

        view.addSpinButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bet = view.getBet();
                if (bet <= 0) {
                    view.displayResult("Apuesta inválida. Inténtalo de nuevo.", 0);
                    return;
                }

                slotMachine.setBet(bet);

                // Ejecutar la lógica en un hilo separado
                new Thread(() -> {
                    String result = slotMachine.spin();
                    int winnings = slotMachine.calculateWinnings(result);

                    // Actualizar la UI en el hilo de eventos de Swing
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        view.displayResult(result, winnings);
                    });
                }).start();
            }
        });
    }
}
