import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 22.08.2024
 * @author 
 */

public class Ketten extends JFrame {
  // start attributes
  private JTextField jAText = new JTextField();
  private JTextField jZeichen = new JTextField();
  private JButton jButton1 = new JButton();
  private JLabel jAusgabe = new JLabel();
  // end attributes
  public static String rayk;
  
  public Ketten() { 
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
    setTitle("Ketten");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jAText.setBounds(24, 16, 193, 65);
    jAText.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jAText);
    jZeichen.setBounds(24, 96, 97, 41);
    jZeichen.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jZeichen);
    jButton1.setBounds(144, 96, 73, 41);
    jButton1.setFont(new Font("Dialog", Font.BOLD, 11));
    jButton1.setText("Button");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jAusgabe.setBounds(24, 144, 193, 25);
    jAusgabe.setFont(new Font("Dialog", Font.BOLD, 11));
    jAusgabe.setText("Text");
    cp.add(jAusgabe);
    // end components
    
    setVisible(true);
  } // end of public Ketten
  
  // start methods
  
  public static void main(String[] args) {
    new Ketten();
    
  } // end of main

  public String zaehlezeichen(String text, String c) {
    if (c.length() != 1 || text.length() < 1) {
      return "Error";
    }

    for (int i = 0; i < text.length(); i++) {
      String xc = Character.toString(text.charAt(i));
      System.out.println(xc);
    }
    return String.parseInt(1);
  }
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    jAusgabe.setText(zaehlezeichen(jAText.getText(), jZeichen.getText()));
  } // end of jButton1_ActionPerformed

  // end methods
} // end of class Ketten
