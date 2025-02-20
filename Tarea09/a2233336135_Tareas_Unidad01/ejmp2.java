package a2233336135_Tareas_Unidad01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ejmp2 extends JFrame {

    private JTextField txtCuenta;
    private JLabel lblTotal;
    private JButton btnCalcular;
    private JToggleButton btnClaro;
    private JToggleButton btnOscuro;

    public ejmp2() {
        setTitle("Calculadora de Propinas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLayout(new BorderLayout());

        // Panel para la información de la cuenta
        JPanel pnlCuenta = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel lblCuenta = new JLabel("Bill:");
        txtCuenta = new JTextField();
        JLabel lblPropina = new JLabel("Tip:");
        JLabel lblPropinaCantidad = new JLabel("0.00"); // Aquí se mostrará la propina
        JLabel lblTotalTexto = new JLabel("Total:");
        lblTotal = new JLabel("0.00"); // Aquí se mostrará el total

        pnlCuenta.add(lblCuenta);
        pnlCuenta.add(txtCuenta);
        pnlCuenta.add(lblPropina);
        pnlCuenta.add(lblPropinaCantidad);
        pnlCuenta.add(lblTotalTexto);
        pnlCuenta.add(lblTotal);

        add(pnlCuenta, BorderLayout.CENTER);

        // Panel para los botones
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCalcular = new JButton("Use Custom Calculator");
        btnClaro = new JToggleButton("Light");
        btnOscuro = new JToggleButton("Dark");

        // Agrupación de los botones de tema
        ButtonGroup grupoTema = new ButtonGroup();
        grupoTema.add(btnClaro);
        grupoTema.add(btnOscuro);

        pnlBotones.add(btnCalcular);
        pnlBotones.add(btnClaro);
        pnlBotones.add(btnOscuro);

        add(pnlBotones, BorderLayout.SOUTH);

        // ActionListener para el botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });

        // ActionListeners para los botones de tema
        btnClaro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                establecerTemaClaro();
            }
        });

        btnOscuro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                establecerTemaOscuro();
            }
        });

        setVisible(true);
    }

    private void calcularTotal() {
        try {
            double cuenta = Double.parseDouble(txtCuenta.getText());
            // Aquí puedes calcular la propina (por ejemplo, 15%)
            double propina = cuenta * 0.15;
            double total = cuenta + propina;

            lblTotal.setText(String.format("%.2f", total));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un número válido para la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void establecerTemaClaro() {
        // TODO: Implementar lógica para cambiar a tema claro
    }

    private void establecerTemaOscuro() {
        // TODO: Implementar lógica para cambiar a tema oscuro
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejmp2());
    }
}