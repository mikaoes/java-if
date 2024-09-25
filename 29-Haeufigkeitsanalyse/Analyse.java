import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 25.09.2024
 * @author 
 */

public class Analyse extends JFrame {
  // start attributes
  private JLabel lHaeufigkeitsanalyse = new JLabel();
  private JTextField jSuchtext = new JTextField();
  private JButton bAnalyse = new JButton();
  // end attributes
  
  public Analyse() { 
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
    setTitle("Analyse");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    lHaeufigkeitsanalyse.setBounds(8, 8, 249, 33);
    lHaeufigkeitsanalyse.setFont(new Font("Dialog", Font.BOLD, 11));
    lHaeufigkeitsanalyse.setText("Häufigkeitsanalyse");
    cp.add(lHaeufigkeitsanalyse);
    jSuchtext.setBounds(8, 56, 257, 41);
    jSuchtext.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jSuchtext);
    bAnalyse.setBounds(8, 104, 65, 33);
    bAnalyse.setFont(new Font("Dialog", Font.BOLD, 11));
    bAnalyse.setText("Analyse");
    bAnalyse.setMargin(new Insets(2, 2, 2, 2));
    bAnalyse.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bAnalyse_ActionPerformed(evt);
      }
    });
    cp.add(bAnalyse);
    // end components
    
    setVisible(true);
  } // end of public Analyse
  
  // start methods
  
  public static void main(String[] args) {
    new Analyse();
  } // end of main
  
  public void bAnalyse_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    zaehlen(jSuchtext.getText());
  } // end of bAnalyse_ActionPerformed

  public void zaehlen(String text) {
    int[] haeuf = new int[26];
    text = text.toUpperCase();
    char c;

    for (int i = 0; i < text.length(); i++) {
      c = text.charAt(i);
      haeuf[c-65]++;
    }

    for (int i = 65; i <= 90; i++) {
      c = (char) i;
      System.out.println(c + " - " + String.valueOf(haeuf[i-65]));
    }

  }

  // end methods
} // end of class Analyse
