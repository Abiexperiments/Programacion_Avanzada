package a2233336135_Tareas_Unidad01;

import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class HandleEvent here.
 * 
 * @author (Eric Y. Chou) 
 * @version (05/28/2016)
 */
public class HandleEvent extends JFrame {
  public HandleEvent() {
    // Create two buttons 
    JButton jbtOK = new JButton("OK");
    JButton jbtCancel = new JButton("Cancel");

    // Create a panel to hold buttons
    JPanel panel = new JPanel();
    panel.add(jbtOK);
    panel.add(jbtCancel);

    add(panel); // Add panel to the frame

    // Register listeners
    OKListenerClass listener1 = new OKListenerClass();
    CancelListenerClass listener2 = new CancelListenerClass();
    jbtOK.addActionListener(listener1);
    jbtCancel.addActionListener(listener2);
  }
  
  public static void main(String[] args) {
    JFrame frame = new HandleEvent();
    frame.setTitle("Handle Event");
    frame.setSize(200, 150);
    frame.setLocation(200, 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

class OKListenerClass implements ActionListener {
  @Override 
  public void actionPerformed(ActionEvent e) {
    System.out.println("OK button clicked");
  }
}

class CancelListenerClass implements ActionListener {
  @Override 
  public void actionPerformed(ActionEvent e) {
    System.out.println("Cancel button clicked");
  }
}