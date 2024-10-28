import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 09.10.2022
 * @author 
 */

public class caesar1 extends JFrame {
  // Anfang Attribute
  private JLabel lGebenSiedenKlartextinGrossbuchstabenundohneLeerzeichenein1 = new JLabel();
  private JTextArea jTextArea1 = new JTextArea("");
  private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JLabel lGeheimtext = new JLabel();
  private JTextArea jTextArea2 = new JTextArea("");
  private JScrollPane jTextArea2ScrollPane = new JScrollPane(jTextArea2);
  private JButton bVomKlartextzumGeheimtext = new JButton();
  private JButton bVomGeheimtextzumKlartext = new JButton();
  private JLabel lSchluessel = new JLabel();
  private JNumberField jNumberField1 = new JNumberField();
  // Ende Attribute
  
  public caesar1() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 620; 
    int frameHeight = 471;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("caesar1");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    jNumberField1.setBounds(24, 200, 80, 24);
    jNumberField1.setText("");
    cp.add(jNumberField1);
    lSchluessel.setBounds(24, 176, 80, 24);
    lSchluessel.setText("Schlüssel");
    cp.add(lSchluessel);
    bVomGeheimtextzumKlartext.setBounds(144, 384, 352, 24);
    bVomGeheimtextzumKlartext.setText("Vom Geheimtext zum Klartext");
    bVomGeheimtextzumKlartext.setMargin(new Insets(2, 2, 2, 2));
    bVomGeheimtextzumKlartext.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bVomGeheimtextzumKlartext_ActionPerformed(evt);
      }
    });
    cp.add(bVomGeheimtextzumKlartext);
    bVomKlartextzumGeheimtext.setBounds(128, 176, 368, 24);
    bVomKlartextzumGeheimtext.setText("Vom Klartext zum Geheimtext");
    bVomKlartextzumGeheimtext.setMargin(new Insets(2, 2, 2, 2));
    bVomKlartextzumGeheimtext.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bVomKlartextzumGeheimtext_ActionPerformed(evt);
      }
    });
    cp.add(bVomKlartextzumGeheimtext);
    jTextArea2ScrollPane.setBounds(144, 248, 353, 129);
    cp.add(jTextArea2ScrollPane);
    lGeheimtext.setBounds(48, 304, 80, 24);
    lGeheimtext.setText("Geheimtext");
    cp.add(lGeheimtext);
    jTextArea1ScrollPane.setBounds(128, 24, 369, 137);
    cp.add(jTextArea1ScrollPane);
    lGebenSiedenKlartextinGrossbuchstabenundohneLeerzeichenein1.setBounds(120, 0, 480, 24);
    lGebenSiedenKlartextinGrossbuchstabenundohneLeerzeichenein1.setText("Geben Sie den Klartext in Großbuchstaben und ohne Leerzeichen ein.");
    cp.add(lGebenSiedenKlartextinGrossbuchstabenundohneLeerzeichenein1);
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public caesar1
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new caesar1();
  } // end of main
  
  public void bVomKlartextzumGeheimtext_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    int key = jNumberField1.getInt();
    String klartext = jTextArea1.getText();
    String geheimtext = chiffriereCaesar(klartext, key);
    jTextArea2.setText(geheimtext);
    
  } // end of bVomKlartextzumGeheimtext_ActionPerformed

  public void bVomGeheimtextzumKlartext_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    int key = jNumberField1.getInt();
    String klartext = jTextArea2.getText();
    String geheimtext = dEchiffriereCaesar(klartext, key);
    jTextArea1.setText(geheimtext);
    
  } // end of bVomGeheimtextzumKlartext_ActionPerformed
  public String chiffriereCaesar(String kt, Integer s) 
  { 
    String geheimtext = "";
    kt = kt.toUpperCase(); // Alles in Großbuchstaben

    int ci; // Integer-Variable initialisiert

    for (int i = 0; i < kt.length(); i++) { // Schleife für jeden char im Eingabetext
      ci = kt.charAt(i); // char->Integer zuweisund generiert automatisch Ascii-Nummer des Zeichens
      ci += s; // Schlüssel wird addiert

      if (ci > 90) { // Wenn >90 (Ascii für "Z") wird zum Anfang gesprungen
        ci = ci - 26;
      }
      
      geheimtext = geheimtext + String.valueOf((char) ci); // Nummer wird wieder als char angehängt
    }
    

    return geheimtext.replace("%", ""); // "%" wird aus Rückgabe entfernt, entsteht aus Leerzeichen
  }

  public String dEchiffriereCaesar(String kt, Integer s) 
  { 
    String geheimtext = "";
    kt = kt.toUpperCase(); // Alles in Großbuchstaben

    int ci; // Integer-Variable initialisiert

    for (int i = 0; i < kt.length(); i++) { // Schleife für jeden char im Eingabetext
      ci = kt.charAt(i); // char->Integer zuweisund generiert automatisch Ascii-Nummer des Zeichens
      ci -= s; // Schlüssel wird addiert

      if (ci < 41) { // Wenn >90 (Ascii für "Z") wird zum Anfang gesprungen
        ci = ci + 26;
      }
      
      geheimtext = geheimtext + String.valueOf((char) ci); // Nummer wird wieder als char angehängt
    }
    

    return geheimtext.replace("%", ""); // "%" wird aus Rückgabe entfernt, entsteht aus Leerzeichen
  }
  // Ende Methoden
} // end of class caesar1
