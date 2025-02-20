package a2233336135_Tareas_Unidad01;
import javax.swing.*;
import java.awt.*;

public class AlineacionEjemplo {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear un panel superior con el título
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(98, 0, 238));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel("Home");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(title);

        // Crear panel para los botones de alineación
        JPanel alignmentPanel = new JPanel();
        alignmentPanel.setLayout(new GridLayout(2, 1, 10, 10));

        // Panel horizontal
        JPanel horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        horizontalPanel.add(new JLabel("Horizontal"));
        horizontalPanel.add(createButton("Start"));
        horizontalPanel.add(createButton("Center"));
        horizontalPanel.add(createButton("End"));
        horizontalPanel.add(createButton("Fill"));

        // Panel vertical
        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        verticalPanel.add(new JLabel("Vertical"));
        verticalPanel.add(createButton("Start"));
        verticalPanel.add(createButton("Center"));
        verticalPanel.add(createButton("End"));
        verticalPanel.add(createButton("Fill"));

        alignmentPanel.add(horizontalPanel);
        alignmentPanel.add(verticalPanel);

        // Crear el panel inferior con el botón "Hello"
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton helloButton = new JButton("Hello");
        helloButton.setBackground(Color.LIGHT_GRAY);
        bottomPanel.add(helloButton);

        // Agregar los paneles al marco principal
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(alignmentPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Mostrar la ventana
        frame.setVisible(true);
    }

    // Método para crear un botón estilizado
    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(98, 0, 238));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        return button;
    }
}
