package netmauiaswing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteApp extends JFrame {
    private JTextField noteField;

    public NoteApp() {
        setTitle("Home");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Etiqueta "Notes"
        JLabel label = new JLabel("Notes");
        panel.add(label);

        // Campo de texto para la nota
        noteField = new JTextField();
        panel.add(noteField);

        // Botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton saveButton = new JButton("Save");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel);

        // Acciones de los botones (implementarás esta lógica según tus necesidades)
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String note = noteField.getText();
                // Aquí guardarías la nota (por ejemplo, en un archivo o base de datos)
                System.out.println("Nota guardada: " + note);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteField.setText("");
                // Aquí eliminarías la nota (si corresponde)
                System.out.println("Nota eliminada");
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NoteApp();
    }
}