package a2233336135_Tareas_Unidad01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class ejemploJframe_05_a2 extends JFrame implements ActionListener {
    static JLabel La, Lb, Lc;
    static JButton Bcalcular, Bsalir;
    static JTextField Ta, Th, Tb;
    static JPanel Panel;

    public ejemploJframe_05_a2() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
        // Instancia un objeto FlowLayout object alineado al centro y con una separación de 3px en horizontal y vertical
        this.setTitle("Layout FlowLayout JPanel");
        this.setBounds(10, 10, 550, 100);
        Panel = new JPanel();
     // Creación de etiquetas (JLabel)
        La = new JLabel("Altura ->");
        Lb = new JLabel("Base ->");
        Lc = new JLabel("El area ->");

        // Creación de campos de texto (JTextField)
        Th = new JTextField();
        Tb = new JTextField();
        Ta = new JTextField();
        // El campo Ta se establece como no editable para mostrar el resultado
        Ta.setEditable(false);

        // Creación de botones (JButton)
        Bcalcular = new JButton();
        Bcalcular.setText("Calcular");
        Bcalcular.addActionListener(this); // Agrega un oyente de eventos para el botón "Calcular"

        Bsalir = new JButton();
        Bsalir.setText("Salir");
        Bsalir.addActionListener(this); // Agrega un oyente de eventos para el botón "Salir"

        // Agregar componentes al panel (JPanel)
        Panel.add(La);
        Panel.add(Th);
        Panel.add(Lb);
        Panel.add(Tb);
        Panel.add(Bcalcular);
        Panel.add(Lc);
        Panel.add(Ta);
        Panel.add(Bsalir);

        // Agregar el panel a la ventana principal (JFrame)
        add(Panel);
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            // Si se presiona el botón "Calcular"
            if (e.getSource() == Bcalcular) {
                // Declaramos variables para almacenar los valores de altura, base y área
                double h, b, a;

                // Obtenemos los valores de los campos de texto y los almacenamos en variables de tipo String
                String Sh = Th.getText();
                String Sb = Tb.getText();

                // Verificamos si ambos campos de texto están vacíos
                if (!Sh.isEmpty() && !Sb.isEmpty()) {
                    // Convertimos los valores de los Strings a números de punto flotante (double)
                    h = Double.parseDouble(Sh);
                    b = Double.parseDouble(Sb);

                    // Calculamos el área del triángulo
                    a = (h * b) / 2;

                    // Mostramos el resultado en el campo de texto Ta
                    Ta.setText(String.valueOf(a));
                } else {
                    // Si alguno de los campos está vacío, mostramos un mensaje de error
                    JOptionPane.showMessageDialog(this, "Lo siento, uno o dos textbox están vacíos");
                }
            } else if (e.getSource() == Bsalir) {
                // Si se presiona el botón "Salir", cerramos la aplicación
                System.exit(0);
            }
        }

        public static void main(String parametro[]) {
            // Creamos una instancia de la clase ejemploJframe_05_a2 y la almacenamos en la variable ventana
            ejemploJframe_05_a2 ventana = new ejemploJframe_05_a2();
            // Hacemos que la ventana sea visible
            ventana.setVisible(true);
        
    }
}