package id.ac.pnb.jobsheet_1;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

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
  private JPanel mainPanel;
  private JTextField textField1;
  private JButton buttonDel;
  private JButton buttonClear;
  private JButton buttonNegative;

  private Character operator;
  private double num1 = 0;
  private double num2 = 0;
  private double result = 0;

  private final DecimalFormat df = new DecimalFormat("0.###");

  public Calculator() {
    this.setContentPane(mainPanel);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
    this.setResizable(false);

    this.textField1.setFont(new Font("Fira Code", Font.PLAIN, 20));

    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      SwingUtilities.updateComponentTreeUI(this);
    } catch (Exception e) {
      e.printStackTrace();
    }

    this.setVisible(true);

    buttonZero.addActionListener(e -> textField1.setText(textField1.getText()
        + "0"));
    buttonOne.addActionListener(e -> textField1.setText(textField1.getText()
        + "1"));
    buttonTwo.addActionListener(e -> textField1.setText(textField1.getText()
        + "2"));
    buttonThree.addActionListener(e -> textField1.setText(textField1.getText()
        + "3"));
    buttonFour.addActionListener(e -> textField1.setText(textField1.getText()
        + "4"));
    buttonFive.addActionListener(e -> textField1.setText(textField1.getText()
        + "5"));
    buttonSix.addActionListener(e -> textField1.setText(textField1.getText()
        + "6"));
    buttonSeven.addActionListener(e -> textField1.setText(textField1.getText()
        + "7"));
    buttonEight.addActionListener(e -> textField1.setText(textField1.getText()
        + "8"));
    buttonNine.addActionListener(e -> textField1.setText(textField1.getText()
        + "9"));

    buttonPoint.addActionListener(e -> {
      if (checkCurrentPoint()) {
        return;
      }

      textField1.setText(textField1.getText()
          + ".");
    });

    buttonClear.addActionListener(e -> {
      textField1.setText("");
      num1 = 0;
      num2 = 0;
      result = 0;
    });

    buttonDel.addActionListener(e -> {
      if (textField1.getText().isBlank()) {
        return;
      }

      textField1.setText(textField1.getText().substring(0, textField1
          .getText().length()-1));
    });

    buttonNegative.addActionListener(e -> {
      if (textField1.getText().isBlank()) {
        return;
      }

      double temp = Double.parseDouble(textField1.getText());
      temp *= -1;
      textField1.setText(df.format(temp));
    });

    buttonPlus.addActionListener(e -> {
      if (this.operator != null || textField1.getText().isBlank()) {
        return;
      }

      this.num1 = Double.parseDouble(textField1.getText());
      this.operator = '+';
      textField1.setText("");
    });

    buttonMinus.addActionListener(e -> {
      if (this.operator != null || textField1.getText().isBlank()) {
        return;
      }

      this.num1 = Double.parseDouble(textField1.getText());
      this.operator = '-';
      textField1.setText("");
    });

    buttonTimes.addActionListener(e -> {
      if (this.operator != null || textField1.getText().isBlank()) {
        return;
      }

      this.num1 = Double.parseDouble(textField1.getText());
      this.operator = '*';
      textField1.setText("");
    });

    buttonDivide.addActionListener(e -> {
      if (this.operator != null || textField1.getText().isBlank()) {
        return;
      }

      this.num1 = Double.parseDouble(textField1.getText());
      this.operator = '/';
      textField1.setText("");
    });

    buttonEqual.addActionListener(e -> {
      if (this.operator == null || textField1.getText().isBlank()) {
        return;
      }

      this.num2 = Double.parseDouble(textField1.getText());
      switch (this.operator) {
        case '+' -> {
          result = num1 + num2;
          textField1.setText(this.df.format(this.result));
        }

        case '-' -> {
          result = num1 - num2;
          textField1.setText(this.df.format(this.result));
        }

        case '*' -> {
          result = num1 * num2;
          textField1.setText(this.df.format(this.result));
        }

        case '/' -> {
          result = num1 / num2;
          textField1.setText(this.df.format(this.result));
        }
      }

      this.operator = null;
    });
  }

  private boolean checkCurrentPoint() {
    if (textField1.getText().isEmpty()) {
      return true;
    }

    for(char c: textField1.getText().toCharArray()) {
      if (c == '.') {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    new Calculator();
  }
}
