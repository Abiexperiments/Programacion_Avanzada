package a2233336135_Tareas_Unidad01;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ejm1 extends JFrame {

    public ejm1() {
        setTitle("Moon Phase");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Panel para la información de la fase lunar
        JPanel phasePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel phaseLabel = new JLabel("Waxing Crescent"); // Texto dinámico
        phaseLabel.setFont(new Font("Arial", Font.BOLD, 24));
        phasePanel.add(phaseLabel);
        add(phasePanel, BorderLayout.CENTER);

        // Panel para la fecha
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel dateLabel = new JLabel(getCurrentDate());
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        datePanel.add(dateLabel);
        add(datePanel, BorderLayout.NORTH);

        // Panel para los días de la semana (esto es estático en el ejemplo)
        JPanel daysPanel = new JPanel(new GridLayout(1, 7));
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (String day : days) {
            daysPanel.add(new JLabel(day, SwingConstants.CENTER));
        }
        add(daysPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy", new Locale("es", "MX")); // Formato en español
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejm1());
    }
}