package a2233336135_Tareas_Unidad01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio2 extends JFrame {

    private JTextField txtBill;
    private JLabel lblTip;
    private JLabel lblTotal;
    private JSlider sliderTip;
    private JButton btn15;
    private JButton btn20;
    private JButton btnRoundDown;
    private JButton btnRoundUp;

    public Ejercicio2() {
        setTitle("Calculadora de Propinas");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Componentes
        JLabel lblBill = new JLabel("Bill:");
        txtBill = new JTextField(10);
        lblTip = new JLabel("Tip: 0.00");
        lblTotal = new JLabel("Total: 0.00");
        sliderTip = new JSlider(JSlider.HORIZONTAL, 0, 100, 15);

        sliderTip.setMajorTickSpacing(5);
        sliderTip.setMinorTickSpacing(1);
        sliderTip.setPaintTicks(true);
        sliderTip.setPaintLabels(true);
        btn15 = new JButton("15%");
        btn20 = new JButton("20%");
        btnRoundDown = new JButton("Round Down");
        btnRoundUp = new JButton("Round Up");

        // Eventos
        txtBill.addActionListener(e -> calcularPropina());
        sliderTip.addChangeListener(e -> calcularPropina());
        btn15.addActionListener(e -> {
            sliderTip.setValue(15);
            calcularPropina();
        });
        btn20.addActionListener(e -> {
            sliderTip.setValue(20);
            calcularPropina();
        });
        btnRoundDown.addActionListener(e -> {
            double total = Double.parseDouble(lblTotal.getText().substring(6));
            lblTotal.setText("Total: " + Math.floor(total));
        });
        btnRoundUp.addActionListener(e -> {
            double total = Double.parseDouble(lblTotal.getText().substring(6));
            lblTotal.setText("Total: " + Math.ceil(total));
        });

        // Agregar componentes al panel
        add(lblBill);
        add(txtBill);
        add(lblTip);
        add(lblTotal);
        add(sliderTip);
        add(new JLabel()); // Espacio en blanco
        add(btn15);
        add(btn20);
        add(btnRoundDown);
        add(btnRoundUp);

        setVisible(true);
    }

    private void calcularPropina() {
        try {
            double bill = Double.parseDouble(txtBill.getText());
            double tipPercent = sliderTip.getValue() / 100.0;
            double tip = bill * tipPercent;
            double total = bill + tip;
            lblTip.setText("Tip: " + String.format("%.2f", tip));
            lblTotal.setText("Total: " + String.format("%.2f", total));
        } catch (NumberFormatException e) {
            // Manejar error si el usuario ingresa un valor no numérico
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico para la cuenta.");
        }
    }

    public static void main(String[] args) {
        new Ejercicio2();
    }
}