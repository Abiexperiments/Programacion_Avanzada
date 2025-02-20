package flascards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;
import java.text.DecimalFormat;

public class FlasCards extends JFrame {
    JLabel triedLabel = new JLabel();
    JTextField triedTextField = new JTextField();
    JLabel correctLabel = new JLabel();
    JTextField correctTextField = new JTextField();
    JLabel problemLabel = new JLabel();
    JLabel dividerLabel = new JLabel();
    JPanel typePanel = new JPanel();
    JCheckBox[] typeCheckBox = new JCheckBox[4];
    JPanel factorPanel = new JPanel();
    ButtonGroup factorButtonGroup = new ButtonGroup();
    JRadioButton[] factorRadioButton = new JRadioButton[11];
    JPanel timerPanel = new JPanel();
    ButtonGroup timerButtonGroup = new ButtonGroup();
    JRadioButton[] timerRadioButton = new JRadioButton[3];
    JTextField timerTextField = new JTextField();
    JScrollBar timerScrollBar = new JScrollBar();
    JButton comienzoboton = new JButton();
    JButton botonsalida = new JButton();
    Timer problemastemporizador;
    Font myFont = new Font("Arial", Font.PLAIN, 18);
    Color luzazul = new Color(192, 192, 255);
    Random myRandom = new Random();
    int numberTried, numerocorrecto;
    int respuestacorrecta, numerodigitos;
    String problema;
    String yourAnswer;
    int numerodigital;
    int tiempoproblema;

    public static void main(String[] args) {
        // Create frame
        new FlasCards().setVisible(true);
    }

    public FlasCards() {
        // Frame constructor
        setTitle("Flash Card Math");
        getContentPane().setBackground(new Color(255, 255, 192));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;

        triedLabel.setText("intento:");
        triedLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(triedLabel, gridConstraints);

        triedTextField.setText("0");
        triedTextField.setPreferredSize(new Dimension(90, 30));
        triedTextField.setEditable(false);
        triedTextField.setBackground(Color.RED);
        triedTextField.setForeground(Color.YELLOW);
        triedTextField.setHorizontalAlignment(SwingConstants.CENTER);
        triedTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(triedTextField, gridConstraints);

        correctLabel.setText("Correcto:");
        correctLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.EAST;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(correctLabel, gridConstraints);

        correctTextField.setText("0");
        correctTextField.setPreferredSize(new Dimension(90, 30));
        correctTextField.setEditable(false);
        correctTextField.setBackground(Color.RED);
        correctTextField.setForeground(Color.YELLOW);
        correctTextField.setHorizontalAlignment(SwingConstants.CENTER);
        correctTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(correctTextField, gridConstraints);

        problemLabel.setText(" ");
        problemLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        problemLabel.setPreferredSize(new Dimension(450, 100));
        problemLabel.setBackground(Color.WHITE);
        problemLabel.setOpaque(true);
        problemLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        problemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 5;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(problemLabel, gridConstraints);

        dividerLabel.setPreferredSize(new Dimension(450, 10));
        dividerLabel.setBackground(Color.RED);
        dividerLabel.setOpaque(true);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.gridwidth = 5;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(dividerLabel, gridConstraints);

        typePanel.setPreferredSize(new Dimension(130, 130));
        typePanel.setBorder(BorderFactory.createTitledBorder(" Tipo: "));
        typePanel.setBackground(luzazul);
        typePanel.setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.gridwidth = 2;
        gridConstraints.anchor = GridBagConstraints.NORTH;
        getContentPane().add(typePanel, gridConstraints);

        for (int i = 0; i < 4; i++) {
            typeCheckBox[i] = new JCheckBox();
            typeCheckBox[i].setBackground(luzazul);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 0;
            gridConstraints.gridy = i;
            gridConstraints.anchor = GridBagConstraints.WEST;
            typePanel.add(typeCheckBox[i], gridConstraints);
            typeCheckBox[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    actionPerformed(e);
                }
            });
        }

        typeCheckBox[0].setText("Adicion");
        typeCheckBox[1].setText("Subtraccion");
        typeCheckBox[2].setText("multiplicacion");
        typeCheckBox[3].setText("Division");
        typeCheckBox[0].setSelected(true);

        // Factor panel setup
        factorPanel.setPreferredSize(new Dimension(130, 130));
        factorPanel.setBorder(BorderFactory.createTitledBorder(" Factor: "));
        factorPanel.setBackground(luzazul);
        factorPanel.setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        gridConstraints.gridwidth = 2;
        gridConstraints.anchor = GridBagConstraints.NORTH;
        getContentPane().add(factorPanel, gridConstraints);

        int x = 2;
        int y = 0;
        for (int i = 0; i < 11; i++) {
            factorRadioButton[i] = new JRadioButton();
            factorRadioButton[i].setText(String.valueOf(i));
            factorRadioButton[i].setBackground(luzazul);
            factorButtonGroup.add(factorRadioButton[i]);
            gridConstraints = new GridBagConstraints();
            if (i < 10) {
                gridConstraints.gridx = x;
                gridConstraints.gridy = y;
            } else {
                gridConstraints.gridx = 0;
                gridConstraints.gridy = 0;
                gridConstraints.gridwidth = 2;
            }
            gridConstraints.anchor = GridBagConstraints.WEST;
            factorPanel.add(factorRadioButton[i], gridConstraints);
            factorRadioButton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    factorRadioButtonActionPerformed(e);
                }

				private void factorRadioButtonActionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
            });
            x++;
            if (x > 2) {
                x = 0;
                y++;
            }
        }

        factorRadioButton[10].setText("Random");
        factorRadioButton[10].setSelected(true);

        // Timer panel setup
        timerPanel.setPreferredSize(new Dimension(130, 130));
        timerPanel.setBorder(BorderFactory.createTitledBorder("Timer:"));
        timerPanel.setBackground(luzazul);
        timerPanel.setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 4;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(0, 0, 0, 10);
        gridConstraints.anchor = GridBagConstraints.NORTH;
        getContentPane().add(timerPanel, gridConstraints);

        for (int i = 0; i < 3; i++) {
            timerRadioButton[i] = new JRadioButton();
            timerRadioButton[i].setBackground(luzazul);
            timerButtonGroup.add(timerRadioButton[i]);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 0;
            gridConstraints.gridy = i;
            gridConstraints.gridwidth = 2;
            gridConstraints.anchor = GridBagConstraints.WEST;
            timerPanel.add(timerRadioButton[i], gridConstraints);
            timerRadioButton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    timerRadioButtonActionPerformed(e);
                }

				private void timerRadioButtonActionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
            });
        }

        timerRadioButton[0].setText("apagado");
        timerRadioButton[1].setText("en contador arriba");
        timerRadioButton[2].setText("en contador abajo ");
        timerRadioButton[0].setSelected(true);

        timerTextField.setText("Off");
        timerTextField.setPreferredSize(new Dimension(90, 25));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.gridwidth = 2;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        timerPanel.add(timerTextField, gridConstraints);

        comienzoboton.setText("comenzar");
        comienzoboton.setFont(myFont);
        comienzoboton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformed(e);
            }
        });

        botonsalida.setText("salida");
        botonsalida.setFont(myFont);
        botonsalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed(e);
            }

			private void exitButtonActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });

        // Layout placement of start and exit buttons
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.anchor = GridBagConstraints.EAST;
        getContentPane().add(comienzoboton, gridConstraints);

        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(botonsalida, gridConstraints);

        pack();
    }
}