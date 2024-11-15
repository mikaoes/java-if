import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 13.11.2024
 * @author 
 */

public class DreiBits extends JFrame {
  // start attributes
  private JTextField jTextField1 = new JTextField();
  private JButton jButton1 = new JButton();
  private JTextField jTextField2 = new JTextField();
  private JButton jDecodieren = new JButton();
  // end attributes
  
  public DreiBits() { 
    // Frame init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("DreiBits");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jTextField1.setBounds(40, 32, 177, 57);
    jTextField1.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField1);
    jButton1.setBounds(40, 112, 89, 33);
    jButton1.setFont(new Font("Dialog", Font.BOLD, 11));
    jButton1.setText("Button");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jTextField2.setBounds(40, 160, 177, 49);
    jTextField2.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField2);
    jDecodieren.setBounds(152, 120, 64, 25);
    jDecodieren.setFont(new Font("Dialog", Font.BOLD, 11));
    jDecodieren.setText("Button");
    jDecodieren.setMargin(new Insets(2, 2, 2, 2));
    jDecodieren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jDecodieren_ActionPerformed(evt);
      }
    });
    cp.add(jDecodieren);
    // end components
    
    setVisible(true);
  } // end of public DreiBits
  
  // start methods
  
  public static void main(String[] args) {
    new DreiBits();
  } // end of main

  public static String dreimal(String eingabe) {
    String ausgabe = "";
    char c;
    for (int i = 0; i<eingabe.length(); i++) {
      c = eingabe.charAt(i);
      ausgabe += c;
      ausgabe += c;
      ausgabe += c;
    }
    return ausgabe;
  }

  public static String decode(String eingabe) {
    String ausgabe = "";
    int summe;
    for (int i = 0; i<eingabe.length(); i+=3) {
      summe = Character.getNumericValue(eingabe.charAt(i));
      summe += Character.getNumericValue(eingabe.charAt(i+1));
      summe += Character.getNumericValue(eingabe.charAt(i+2));
      
      if (summe < 2) {
        ausgabe += "0";
      } else {
        ausgabe += "1";
      }
    }
    return ausgabe;
  }
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    jTextField2.setText(dreimal(jTextField1.getText()));
  } // end of jButton1_ActionPerformed

  public void jDecodieren_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    jTextField1.setText(decode(jTextField2.getText()));
  } // end of jButton1_ActionPerformed

  // end methods
} // end of class DreiBits
