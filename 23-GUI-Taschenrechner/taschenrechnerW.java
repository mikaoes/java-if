import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 21.08.2024
 * @author
 */

public class taschenrechnerW extends JFrame {
  // start attributes
  private JLabel ltaschenrechnerW = new JLabel();
  private JTextField jLinks = new JTextField();
  private JButton bRechnen = new JButton();
  private JButton b1 = new JButton();
  private JButton b2 = new JButton();
  private JButton b3 = new JButton();
  private JButton b = new JButton();
  private JButton b5 = new JButton();
  private JButton b61 = new JButton();
  private JButton b7 = new JButton();
  private JButton b8 = new JButton();
  private JButton b9 = new JButton();
  private JButton b0 = new JButton();
  private JTextField jRechts = new JTextField();
  private JButton lRZ = new JButton();
  private JButton bToggleLR = new JButton();

  private String lr = "L";
  // end attributes

  public taschenrechnerW() {
    // Frame init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300;
    int frameHeight = 500;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("taschenrechner");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components

    ltaschenrechnerW.setBounds(24, 16, 169, 18);
    ltaschenrechnerW.setFont(new Font("Dialog", Font.BOLD, 11));
    ltaschenrechnerW.setText("taschenrechner");
    cp.add(ltaschenrechnerW);
    jLinks.setBounds(32, 48, 64, 24);
    jLinks.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jLinks);
    bRechnen.setBounds(32, 80, 152, 16);
    bRechnen.setFont(new Font("Dialog", Font.BOLD, 11));
    bRechnen.setText("Berechnen");
    bRechnen.setMargin(new Insets(2, 2, 2, 2));
    bRechnen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bRechnen_ActionPerformed(evt);
      }
    });
    this.getRootPane().setDefaultButton(bRechnen);
    cp.add(bRechnen);
    b1.setBounds(32, 112, 40, 33);
    b1.setFont(new Font("Dialog", Font.BOLD, 11));
    b1.setText("1");
    b1.setMargin(new Insets(2, 2, 2, 2));
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        b1_ActionPerformed(evt);
      }
    });
    cp.add(b1);
    b2.setBounds(88, 112, 40, 33);
    b2.setFont(new Font("Dialog", Font.BOLD, 11));
    b2.setText("2");
    b2.setMargin(new Insets(2, 2, 2, 2));
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        b2_ActionPerformed(evt);
      }
    });
    cp.add(b2);
    b3.setBounds(144, 112, 40, 33);
    b3.setFont(new Font("Dialog", Font.BOLD, 11));
    b3.setText("3");
    b3.setMargin(new Insets(2, 2, 2, 2));
    b3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        b3_ActionPerformed(evt);
      }
    });
    cp.add(b3);
    b.setBounds(32, 160, 40, 33);
    b.setFont(new Font("Dialog", Font.BOLD, 11));
    b.setText("4");
    b.setMargin(new Insets(2, 2, 2, 2));
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        b_ActionPerformed(evt);
      }
    });
    b.setSelected(false);
    cp.add(b);
    b5.setBounds(88, 160, 40, 33);
    b5.setFont(new Font("Dialog", Font.BOLD, 11));
    b5.setText("5");
    b5.setMargin(new Insets(2, 2, 2, 2));
    b5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        b5_ActionPerformed(evt);
      }
    });
    cp.add(b5);
    b61.setBounds(144, 160, 40, 33);
    b61.setFont(new Font("Dialog", Font.BOLD, 11));
    b61.setText("6");
    b61.setMargin(new Insets(2, 2, 2, 2));
    b61.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        b61_ActionPerformed(evt);
      }
    });
    cp.add(b61);
    b7.setBounds(32, 208, 40, 33);
    b7.setFont(new Font("Dialog", Font.BOLD, 11));
    b7.setText("7");
    b7.setMargin(new Insets(2, 2, 2, 2));
    b7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        b7_ActionPerformed(evt);
      }
    });
    cp.add(b7);
    b8.setBounds(88, 208, 40, 33);
    b8.setFont(new Font("Dialog", Font.BOLD, 11));
    b8.setText("8");
    b8.setMargin(new Insets(2, 2, 2, 2));
    b8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        b8_ActionPerformed(evt);
      }
    });
    cp.add(b8);
    b9.setBounds(144, 208, 40, 33);
    b9.setFont(new Font("Dialog", Font.BOLD, 11));
    b9.setText("9");
    b9.setMargin(new Insets(2, 2, 2, 2));
    b9.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        b9_ActionPerformed(evt);
      }
    });
    cp.add(b9);
    b0.setBounds(88, 256, 40, 33);
    b0.setFont(new Font("Dialog", Font.BOLD, 11));
    b0.setText("0");
    b0.setMargin(new Insets(2, 2, 2, 2));
    b0.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        b0_ActionPerformed(evt);
      }
    });
    cp.add(b0);
    jRechts.setBounds(140, 48, 64, 24);
    jRechts.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jRechts);
    lRZ.setBounds(92, 48, 50, 25);
    lRZ.setFont(new Font("Dialog", Font.BOLD, 11));
    lRZ.setText("+");
    lRZ.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        lRZ_ActionPerformed(evt);
      }
    });
    cp.add(lRZ);
    bToggleLR.setBounds(144, 256, 41, 33);
    bToggleLR.setFont(new Font("Dialog", Font.BOLD, 11));
    bToggleLR.setText("L");
    bToggleLR.setMargin(new Insets(2, 2, 2, 2));
    bToggleLR.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bToggleLR_ActionPerformed(evt);
      }
    });
    cp.add(bToggleLR);

    jLinks.addFocusListener(new FocusAdapter() {
      public void focusGained(FocusEvent evt) {
        lr = "L";
        bToggleLR.setText("L");
        bToggleLR.repaint();
      }
    });

    jRechts.addFocusListener(new FocusAdapter() {
      public void focusGained(FocusEvent evt) {
        lr = "R";
        bToggleLR.setText("R");
        bToggleLR.repaint();
      }
    });

    // end components

    setVisible(true);
  } // end of public taschenrechnerW

  // start methods

  public static void main(String[] args) {
    new taschenrechnerW();
  } // end of main

  public void add(int zahl) {
    if (lr == "L") {
      jLinks.setText(jLinks.getText() + zahl);
    }
    if (lr == "R") {
      jRechts.setText(jRechts.getText() + zahl);
    }
  }

  public void bRechnen_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    int zahl1 = Integer.parseInt(jLinks.getText());
    int zahl2 = Integer.parseInt(jRechts.getText());
    long ergebnis = 0;
    if (lRZ.getText().equals("+")) {
      ergebnis = zahl1 + zahl2;
    } else if (lRZ.getText().equals("-")) {
      ergebnis = zahl1 - zahl2;
    } else if (lRZ.getText().equals("*")) {
      ergebnis = zahl1 * zahl2;
    } else if (lRZ.getText().equals("/")) {
      ergebnis = zahl1 / zahl2;
    }
    JOptionPane.showMessageDialog(null, "Das Ergebnis ist: " + ergebnis);
  } // end of bRechnen_ActionPerformed

  public void b1_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    add(1);
  } // end of b1_ActionPerformed

  public void b2_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    add(2);
  } // end of b2_ActionPerformed

  public void b3_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    add(3);
  } // end of b3_ActionPerformed

  public void b_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    add(4);
  } // end of b_ActionPerformed

  public void b5_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    add(5);
  } // end of b5_ActionPerformed

  public void b61_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    add(6);
  } // end of b61_ActionPerformed

  public void b7_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    add(7);
  } // end of b7_ActionPerformed

  public void b8_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    add(8);
  } // end of b8_ActionPerformed

  public void b9_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    add(9);
  } // end of b9_ActionPerformed

  public void b0_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    add(0);
  } // end of b0_ActionPerformed

  public void lRZ_ActionPerformed(ActionEvent evt) {
    // change the operator
    if (lRZ.getText().equals("+")) {
      lRZ.setText("-");
    } else if (lRZ.getText().equals("-")) {
      lRZ.setText("*");
    } else if (lRZ.getText().equals("*")) {
      lRZ.setText("/");
    } else if (lRZ.getText().equals("/")) {
      lRZ.setText("+");
    }

    lRZ.repaint();
  } // end of lRZ_ActionPerformed

  public void bToggleLR_ActionPerformed(ActionEvent evt) {
    if (bToggleLR.getText().equals("L")) {
      lr = "R";
      bToggleLR.setText("R");
      jRechts.requestFocus();
    } else if (bToggleLR.getText().equals("R")) {
      lr = "L";
      bToggleLR.setText("L");
      jLinks.requestFocus();
    }
    bToggleLR.repaint();

  } // end of bToggleLR_ActionPerformed

  // end methods
} // end of class taschenrechnerW
