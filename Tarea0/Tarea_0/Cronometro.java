package Tarea_0;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro extends JFrame implements ActionListener {
    private JLabel lblRunningTime, lblTotalTime;
    private JButton btnStart, btnReset, btnExit;
    private Timer timer;
    private int seconds = 0;
    private int totalSeconds = 0;

    public Cronometro() {
        super("Cronómetro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 150);
        setLayout(new GridLayout(3, 2));

        lblRunningTime = new JLabel("00:00:00");
        lblTotalTime = new JLabel("00:00:00");
        btnStart = new JButton("Start");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");

        add(new JLabel("Running Time:"));
        
        add(lblRunningTime);
        add(new JLabel("Total Time:"));
        add(lblTotalTime);
        add(btnStart);
        add(btnReset);
        add(btnExit);

        btnStart.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);

        timer = new Timer(1000, this);
        timer.stop();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            timer.start();
        } else if (e.getSource() == btnReset) {
            timer.stop();
            seconds = 0;
            totalSeconds = 0;
            updateLabels();
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        } else {
            seconds++;
            totalSeconds++;
            updateLabels();
        }
    }

    private void updateLabels() {
        String runningTime = String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
        String totalTime = String.format("%02d:%02d:%02d", totalSeconds / 3600, (totalSeconds % 3600) / 60, totalSeconds % 60);
        lblRunningTime.setText(runningTime);
        lblTotalTime.setText(totalTime);
    }

    public static void main(String[] args) {
        new Cronometro();
    }
}