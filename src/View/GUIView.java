import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIView {
    private JFrame frame;
    private JTextField betField;
    private JTextArea resultArea;
    private JButton spinButton;

    public GUIView() {
        frame = new JFrame("Juego de Tragamonedas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Panel para la apuesta
        JPanel betPanel = new JPanel();
        betPanel.add(new JLabel("Ingrese su apuesta:"));
        betField = new JTextField(10);
        betPanel.add(betField);
        spinButton = new JButton("Girar");
        betPanel.add(spinButton);
        frame.add(betPanel, BorderLayout.NORTH);

        // Área de resultados
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public int getBet() {
        try {
            return Integer.parseInt(betField.getText());
        } catch (NumberFormatException e) {
            return 0; // Retornar 0 si la entrada no es válida
        }
    }

    public void displayResult(String result, int winnings) {
        resultArea.append("Resultado: " + result + "\n");
        if (winnings > 0) {
            resultArea.append("¡Ganaste " + winnings + "!\n");
        } else {
            resultArea.append("Intenta de nuevo.\n");
        }
    }

    public void addSpinButtonListener(ActionListener listener) {
        spinButton.addActionListener(listener);
    }
}
