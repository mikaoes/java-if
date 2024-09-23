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
  private JLabel lSchluesselwort = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JButton bSwortextrahieren = new JButton();
  private JLabel lExtrahiertesSchluesselwort = new JLabel();
  private JTextField jTextField2 = new JTextField();
  private JButton bSwortmitRestalphabetauffuellen = new JButton();
  private JTextField jTextField3 = new JTextField();
  private JLabel lMitRestalphabetaufgefuelltesSchluesselwort = new JLabel();
  // Ende Attribute
  
  public caesar1() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 723; 
    int frameHeight = 560;
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
    lMitRestalphabetaufgefuelltesSchluesselwort.setBounds(24, 272, 254, 24);
    lMitRestalphabetaufgefuelltesSchluesselwort.setText("Mit Restalphabet aufgefülltes Schlüsselwort");
    cp.add(lMitRestalphabetaufgefuelltesSchluesselwort);
    jTextField3.setBounds(304, 272, 376, 24);
    cp.add(jTextField3);
    bSwortmitRestalphabetauffuellen.setBounds(16, 80, 256, 24);
    bSwortmitRestalphabetauffuellen.setText("Swort mit Restalphabet auffüllen");
    bSwortmitRestalphabetauffuellen.setMargin(new Insets(2, 2, 2, 2));
    bSwortmitRestalphabetauffuellen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSwortmitRestalphabetauffuellen_ActionPerformed(evt);
      }
    });
    cp.add(bSwortmitRestalphabetauffuellen);
    jTextField2.setBounds(304, 232, 376, 24);
    cp.add(jTextField2);
    lExtrahiertesSchluesselwort.setBounds(104, 232, 159, 24);
    lExtrahiertesSchluesselwort.setText("extrahiertes Schlüsselwort");
    cp.add(lExtrahiertesSchluesselwort);
    bSwortextrahieren.setBounds(16, 24, 168, 24);
    bSwortextrahieren.setText("Swort extrahieren");
    bSwortextrahieren.setMargin(new Insets(2, 2, 2, 2));
    bSwortextrahieren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSwortextrahieren_ActionPerformed(evt);
      }
    });
    cp.add(bSwortextrahieren);
    jTextField1.setBounds(304, 200, 376, 24);
    cp.add(jTextField1);
    lSchluesselwort.setBounds(176, 200, 86, 24);
    lSchluesselwort.setText("Schlüsselwort");
    cp.add(lSchluesselwort);
    bVomGeheimtextzumKlartext.setBounds(216, 456, 352, 24);
    bVomGeheimtextzumKlartext.setText("Vom Geheimtext zum Klartext");
    bVomGeheimtextzumKlartext.setMargin(new Insets(2, 2, 2, 2));
    bVomGeheimtextzumKlartext.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bVomGeheimtextzumKlartext_ActionPerformed(evt);
      }
    });
    cp.add(bVomGeheimtextzumKlartext);
    bVomKlartextzumGeheimtext.setBounds(304, 168, 368, 24);
    bVomKlartextzumGeheimtext.setText("Vom Klartext zum Geheimtext");
    bVomKlartextzumGeheimtext.setMargin(new Insets(2, 2, 2, 2));
    bVomKlartextzumGeheimtext.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bVomKlartextzumGeheimtext_ActionPerformed(evt);
      }
    });
    cp.add(bVomKlartextzumGeheimtext);
    jTextArea2ScrollPane.setBounds(216, 320, 353, 129);
    cp.add(jTextArea2ScrollPane);
    lGeheimtext.setBounds(88, 328, 80, 24);
    lGeheimtext.setText("Geheimtext");
    cp.add(lGeheimtext);
    jTextArea1ScrollPane.setBounds(304, 24, 369, 137);
    cp.add(jTextArea1ScrollPane);
    lGebenSiedenKlartextinGrossbuchstabenundohneLeerzeichenein1.setBounds(304, 0, 480, 24);
    lGebenSiedenKlartextinGrossbuchstabenundohneLeerzeichenein1.setText("Geben Sie den Klartext in Großbuchstaben und ohne Leerzeichen ein.");
    cp.add(lGebenSiedenKlartextinGrossbuchstabenundohneLeerzeichenein1);
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public caesar1
  
  public static void main(String[] args)
  {
    new caesar1();
  } // end of main
  
  // Anfang Methoden
  
  public String SWortExtrahieren(String sw_alt) 
  {
    boolean flag = false; 
    String sw_neu = "";
    int sw_alt_Laenge = sw_alt.length(); 
    for (int i = 0; i < sw_alt_Laenge; i++ )
    {
      if (i == 0) // Erstes Zeichen betrachtet
      {
        char char_akt = sw_alt.charAt(i);  
        sw_neu = sw_neu + char_akt;  
      } // Ende if-Zweig
      else // weitere Zeichen 
      {
        char char_akt = sw_alt.charAt(i); 
        for (int j = 0;j < sw_neu.length();j++)
        {
          char char_akt2 = sw_neu.charAt(j);
          if (char_akt2 == char_akt)
          {
            flag = true;
          }
          
        } // end of for mit j
        if (flag == false) // aktuelles Zeichen ist noch nicht im Schlüsselwort drin
        {
          sw_neu = sw_neu + char_akt;  
        }  
      } // end of if-else 
      flag = false;
    } // end of for mit i
    return sw_neu;
  } // Ende Methode sWort extrahieren
  
  public String sWortAuffuellen(String sw_neu)
  {
    boolean flag = false;
    String sWort_lang = sw_neu;
    int sw_laenge = sw_neu.length();
    char char_letzt = sw_neu.charAt(sw_laenge - 1);  
    // Schleife über dem Restalphabet 
    for (int i = 0; i < 26; i++)
    {
      char_letzt++;   // liefert das nächste Zeichen im ASCII-Code
      if (char_letzt > 'Z')
      {
        char_letzt = 'A';
      }
      
      for (int j = 0;j < sw_laenge; j++) 
      {
        char char_akt = sw_neu.charAt(j);
        if (char_letzt == char_akt)
        {
          flag = true;
        }
        
      } // end of for
      if (flag == false)
      {
        sWort_lang = sWort_lang +char_letzt;
      }
      flag = false;
    }  
    
    return sWort_lang; 
  }
  
  
  
  public void bVomKlartextzumGeheimtext_ActionPerformed(ActionEvent evt)
  {
    // 
    String keywort = jTextField1.getText(); 
    String klartext = jTextArea1.getText();
    String keywort_neu = SWortExtrahieren(keywort);  
    String keywort_lang = sWortAuffuellen(keywort_neu);
    String geheimtext = chiffriereCaesar(klartext, keywort_lang);
    jTextArea2.setText(geheimtext);
    
  } // end of bVomKlartextzumGeheimtext_ActionPerformed
 
  public void bVomGeheimtextzumKlartext_ActionPerformed(ActionEvent evt)
  {
    // Hier fehlt noch der Quelltext
    jTextArea1.setText(dechiffriereCaesar(jTextArea1.getText(), jTextField3.getText()));
    
  } // end of bVomGeheimtextzumKlartext_ActionPerformed
  
  public String chiffriereCaesar(String klartext, String keywort_lang) 
  {
    String kText = klartext;
    int l_kt = klartext.length(); 
    String gText = "";
    String kWort = keywort_lang;
    String Alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    boolean flag = false;  
    // Geheimtext erzeugen
    for (int i = 0; i < l_kt; i++)
    {
      char char_akt = kText.charAt(i); 
      int j = 0;
      while ((flag == false) &&  (j < 26))
      {
        char alpha = Alphabet.charAt(j);  
        if (char_akt == alpha)
        {
          gText = gText + kWort.charAt(j); 
          flag = true; 
          
        } 
        j++;
      } // Ende of while
      flag = false;
    } // end of for
    return gText;
  }
  
  public String dechiffriereCaesar(String geheimtext, String keywort_lang) 
  {
    String gText = geheimtext;
    int l_gt = geheimtext.length(); 
    String kText = "";
    String kWort = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String Alphabet =keywort_lang;
    boolean flag = false;  
    // Klartext erzeugen
    for (int i = 0; i < l_gt; i++)
    {
      char char_akt = gText.charAt(i); 
      int j = 0;
      while ((flag == false) &&  (j < 26))
      {
        char alpha = Alphabet.charAt(j);  
        if (char_akt == alpha)
        {
          kText = kText + kWort.charAt(j); 
          flag = true;
          
        } 
        j++;
      } // Ende of while
      flag = false;
    } // end of for
    return kText;
  }
   
   public void bSwortextrahieren_ActionPerformed(ActionEvent evt) 
  // Testbutton zum Testen vom Extrahieren des Schlüsselwortes
  {
    String keywort = jTextField1.getText();
    String keywort_neu = SWortExtrahieren(keywort);  
    jTextField2.setText(keywort_neu);  
    
  } // end of bSwortextrahieren_ActionPerformed

  public void bSwortmitRestalphabetauffuellen_ActionPerformed(ActionEvent evt) 
  // Testbutton um extrahiertes Schlüsselwort mit Aphabetbuchstaben auffüllen
  {
    String keywort_n = jTextField2.getText(); 
    String keywort_lang = sWortAuffuellen(keywort_n);
    jTextField3.setText(keywort_lang);    
    
  } // end of bSwortmitRestalphabetauffuellen_ActionPerformed

  // Ende Methoden
} // end of class caesar1
  