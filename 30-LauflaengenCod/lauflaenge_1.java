import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 28.11.2022
 * @author 
 */

public class lauflaenge_1 extends JFrame {
  // Anfang Attribute
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JTextArea jTextArea2 = new JTextArea("");
    private JScrollPane jTextArea2ScrollPane = new JScrollPane(jTextArea2);
  private JButton bLauflaengencodierungdurchfuehren = new JButton();
  private JLabel lOriginaltextinGrossbuchstabenohneLeerzeicheneingeben = new JLabel();
  private JLabel lCodierterText = new JLabel();
  private JButton bDecodierungdescodiertenTextes = new JButton();
  // Ende Attribute
  
  public lauflaenge_1() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 632; 
    int frameHeight = 450;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("lauflaenge_1");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    bDecodierungdescodiertenTextes.setBounds(16, 176, 240, 24);
    bDecodierungdescodiertenTextes.setText("Decodierung des codierten Textes");
    bDecodierungdescodiertenTextes.setMargin(new Insets(2, 2, 2, 2));
    bDecodierungdescodiertenTextes.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDecodierungdescodiertenTextes_ActionPerformed(evt);
      }
    });
    cp.add(bDecodierungdescodiertenTextes);
    lCodierterText.setBounds(320, 136, 248, 24);
    lCodierterText.setText("codierter Text");
    cp.add(lCodierterText);
    lOriginaltextinGrossbuchstabenohneLeerzeicheneingeben.setBounds(256, 16, 346, 24);
    lOriginaltextinGrossbuchstabenohneLeerzeicheneingeben.setText("Originaltext in Grossbuchstaben ohne Leerzeichen eingeben");
    cp.add(lOriginaltextinGrossbuchstabenohneLeerzeicheneingeben);
    bLauflaengencodierungdurchfuehren.setBounds(16, 80, 240, 24);
    bLauflaengencodierungdurchfuehren.setText("Lauflaengencodierung durchfuehren");
    bLauflaengencodierungdurchfuehren.setMargin(new Insets(2, 2, 2, 2));
    bLauflaengencodierungdurchfuehren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bLauflaengencodierungdurchfuehren_ActionPerformed(evt);
      }
    });
    cp.add(bLauflaengencodierungdurchfuehren);
    jTextArea2ScrollPane.setBounds(320, 168, 248, 80);
    cp.add(jTextArea2ScrollPane);
    jTextArea1ScrollPane.setBounds(320, 40, 248, 80);
    cp.add(jTextArea1ScrollPane);
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public lauflaenge_1
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new lauflaenge_1();
  } // end of main
  
  // eigene Methoden
  public String codiere(String otext)
  {
  int l = otext.length();
  String lc = "";  
  int anz = 1;  
  for (int i = 0;i < l-1 ;i++ )
  {
   if (otext.charAt(i) == otext.charAt(i+1))
    {
    anz = anz + 1;      
    }  
    
    else // neues Zeichen kommt
      {
    lc = lc + otext.charAt(i) + Integer.toString(anz)  ;
    anz = 1;    
      } // end of if-else
 
    
  } // end of for
    // letztes Zeichen analysieren
      lc = lc + otext.charAt(l-1) + Integer.toString(anz)  ;
  
     return lc; 
  } // Ende of Methode codiere
  public String decodiere(String otext)
  {
    char buchstabe= ' ';
    String wort = "";
    for (int i = 1; i<otext.length(); i+=2) {
      buchstabe = otext.charAt(i-1);
      wort = wort + (new String(new char[Character.getNumericValue(otext.charAt(i))]).replace("\0", (buchstabe+"")));
    }
    return wort;
  }

  public void bLauflaengencodierungdurchfuehren_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfuegen
    String o_text = jTextArea1.getText();
    String lauflaenge = codiere(o_text);
 //   jTextArea2.append(o_text);
     jTextArea2.setText(lauflaenge);
  } // end of bLauflaengencodierungdurchfuehren_ActionPerformed

  public void bDecodierungdescodiertenTextes_ActionPerformed(ActionEvent evt) {
    // Hier fehlt noch etwas!!!
    jTextArea1.setText(decodiere(jTextArea2.getText()));
  } // end of bDecodierungdescodiertenTextes_ActionPerformed

  // Ende Methoden
} // end of class lauflaenge_1
