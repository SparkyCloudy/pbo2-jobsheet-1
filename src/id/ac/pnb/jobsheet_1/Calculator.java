package id.ac.pnb.jobsheet_1;

import javax.swing.*;

public class Calculator extends JFrame {
  private JButton buttonSeven;
  private JButton buttonZero;
  private JButton buttonOne;
  private JButton buttonTwo;
  private JButton buttonThree;
  private JButton buttonFour;
  private JButton buttonFive;
  private JButton buttonSix;
  private JButton buttonEight;
  private JButton buttonNine;
  private JButton buttonDivide;
  private JButton buttonTimes;
  private JButton buttonMinus;
  private JButton buttonPoint;
  private JButton buttonPlus;
  private JButton buttonEqual;
  private JFormattedTextField formattedTextField1;
  private JPanel mainPanel;


  public Calculator() {
    setContentPane(mainPanel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }
}
