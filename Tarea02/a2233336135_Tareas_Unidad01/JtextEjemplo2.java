package a2233336135_Tareas_Unidad01;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JtextEjemplo2 extends JFrame {
    static JLabel La, Lb, Lc;
    static JButton Bcalcular, Bsalir;
    static JTextField Ta, Th, Tb;

    public JtextEjemplo2() {
        getContentPane().setLayout(null);
        this.setTitle("abigail garcia rodriguez ejemplo 2 jtext");
        this.setBounds(10, 10, 350, 300);

        La = new JLabel("Introduce el valor de la Altura");
        La.setBounds(10, 10, 200, 30);

        Lb = new JLabel("Introduce el valor de la Base");
        Lb.setBounds(10, 40, 200, 30);

        Lc = new JLabel("El area es igual a ->");
        Lc.setBounds(10, 110, 200, 30);

        Th = new JTextField("");
        Th.setBounds(220, 10, 100, 30);

        Tb = new JTextField("");
        Tb.setBounds(220, 40, 100, 30);

        Ta = new JTextField("");
        Ta.setBounds(220, 110, 100, 30);
        Ta.setEditable(false);
    
    Bcalcular = new JButton();
    Bcalcular.setText("Calcular");
    Bcalcular.setBounds(10, 60, 100, 30);

    Bcalcular.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            double h, b, a;
            String Sh, Sb;

            Sh = Th.getText();
            Sb = Tb.getText();

            if (!Sh.isEmpty() && !Sb.isEmpty()) {
                h = Double.parseDouble(Sh);
                b = Double.parseDouble(Sb);
                a = (h * b) / 2;
                Ta.setText(String.valueOf(a));
            } else {
                JOptionPane.showMessageDialog(null, "Lo siento un o dos textbos estan vacios");
            }
        }
    });
    Bsalir = new JButton();
    Bsalir.setText("Salir");
    Bsalir.setBounds(120, 60, 100, 30);

    Bsalir.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });

    getContentPane().add(La);
    getContentPane().add(Lb);
    getContentPane().add(Lc);
    getContentPane().add(Bcalcular);
    getContentPane().add(Bsalir);
    getContentPane().add(Th);
    getContentPane().add(Tb);
    getContentPane().add(Ta);
    }

    public static void main(String parametro[]) {
        JtextEjemplo2 ventana = new JtextEjemplo2();
        ventana.setVisible(true);
    }
}