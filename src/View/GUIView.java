import javax.swing.*; // Importa las clases de Swing para crear la interfaz gráfica
import java.awt.*; // Importa las clases de AWT para el diseño de la interfaz
import java.awt.event.ActionEvent; // Importa la clase ActionEvent para manejar eventos de acción
import java.awt.event.ActionListener; // Importa la interfaz ActionListener para escuchar eventos de acción

public class GUIView {
    private JFrame frame; // Ventana principal de la aplicación
    private JTextField betField; // Campo de texto para ingresar la apuesta
    private JTextArea resultArea; // Área de texto para mostrar los resultados
    private JButton spinButton; // Botón para iniciar el giro

    // Constructor que inicializa la interfaz gráfica
    public GUIView() {
        frame = new JFrame("Juego de Tragamonedas"); // Crea la ventana con un título
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        frame.setSize(400, 300); // Establece el tamaño de la ventana
        frame.setLayout(new BorderLayout()); // Establece el layout de la ventana

        // Panel para la apuesta
        JPanel betPanel = new JPanel(); // Crea un panel para contener los elementos de la apuesta
        betPanel.add(new JLabel("Ingrese su apuesta:")); // Agrega una etiqueta al panel
        betField = new JTextField(10); // Crea un campo de texto para la apuesta con un tamaño de 10 columnas
        betPanel.add(betField); // Agrega el campo de texto al panel
        spinButton = new JButton("Girar"); // Crea un botón para girar
        betPanel.add(spinButton); // Agrega el botón al panel
        frame.add(betPanel, BorderLayout.NORTH); // Agrega el panel al norte de la ventana

        // Área de resultados
        resultArea = new JTextArea(); // Crea un área de texto para mostrar los resultados
        resultArea.setEditable(false); // Hace que el área de texto no sea editable
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER); // Agrega el área de texto dentro de un JScrollPane al centro de la ventana

        frame.setVisible(true); // Hace visible la ventana
    }

    // Método que obtiene la apuesta ingresada por el usuario
    public int getBet() {
        try {
            return Integer.parseInt(betField.getText()); // Intenta convertir el texto del campo de apuesta a un entero
        } catch (NumberFormatException e) {
            return 0; // Retorna 0 si la entrada no es válida (no es un número)
        }
    }

    // Método que muestra el resultado del giro y las ganancias
    public void displayResult(String result, int winnings) {
        resultArea.append("Resultado: " + result + "\n"); // Agrega el resultado al área de texto
        if (winnings > 0) { // Verifica si hay ganancias
            resultArea.append("¡Ganaste " + winnings + "!\n"); // Muestra un mensaje de éxito si hay ganancias
        } else {
            resultArea.append("Intenta de nuevo.\n"); // Mensaje de aliento si no hay ganancias
        }
    }

    // Método que agrega un listener al botón de girar
    public void addSpinButtonListener(ActionListener listener) {
        spinButton.addActionListener(listener); // Asocia el listener al botón
    }
}
