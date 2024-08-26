import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.tree.*;


/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 08.09.2022 mit Ergänzungen von 2024
 * @author 
 */

public class BinSuchBaumTestCanvas extends JFrame {
  // Anfang Attribute
  // Spalten und Zeilen fuer die Tabelle mit der Pseudografik fuer die Baumdarstellung
  final private static int tabSpalten = 128;
  final private static int tabZeilen = 7;
  
  // Textefeld fuer alle Textausgaben
  public static JTextArea jTextArea1 = new JTextArea("");
  private static JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  
  // Tabelle fuer die Baumdarstellung
  public static JTable jTable1 = new JTable(tabZeilen, tabSpalten);
  private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
  private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  
  // Schaltflaechen fuer die Bedienung 
  private JButton bDemoBaumerzeugen = new JButton();
  private JButton bPreorder = new JButton();
  private JButton bMaxSuche = new JButton();
  private JButton bInorder = new JButton();
  private JButton bBaumloeschen = new JButton();
  private JButton bBaumrestaurieren = new JButton();
  private JButton bBaumsichern = new JButton();
  private JButton bElementloeschen = new JButton();
  private JButton bElementeinfuegen = new JButton();
  private JNumberField nf7 = new JNumberField();
  private JButton bBegruessung = new JButton();
  private JButton bPostorder = new JButton();
  
  // Anzahl der Ebenen des Baumes zur Beurteilung, ob er dargestellt werden kann
  private static int baumtiefe = 0;
  
  // Instanz des Baumes erzeugen
  private static BinSuchBaumTest bnb = new BinSuchBaumTest();
  
  // Ende Attribute

  // Konstruktor
  public BinSuchBaumTestCanvas() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1384; 
    int frameHeight = 584;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("BinSuchBaumTestCanvas");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    bBegruessung.setBounds(240, 40, 136, 24);
    bBegruessung.setText("Begruessung");
    bBegruessung.setMargin(new Insets(2, 2, 2, 2));
    bBegruessung.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBegruessung_ActionPerformed(evt);
      }
    });
    cp.add(bBegruessung);
    bBaumsichern.setBounds(424, 64, 128, 24);
    bBaumsichern.setText("Baum sichern");
    bBaumsichern.setMargin(new Insets(2, 2, 2, 2));
    bBaumsichern.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBaumsichern_ActionPerformed(evt);
      }
    });
    cp.add(bBaumsichern);
    bBaumrestaurieren.setBounds(616, 64, 120, 24);
    bBaumrestaurieren.setText("Baum restaurieren");
    bBaumrestaurieren.setMargin(new Insets(2, 2, 2, 2));
    bBaumrestaurieren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBaumrestaurieren_ActionPerformed(evt);
      }
    });
    cp.add(bBaumrestaurieren);
    bElementeinfuegen.setBounds(424, 32, 128, 24);
    bElementeinfuegen.setText("Element einfügen");
    bElementeinfuegen.setMargin(new Insets(2, 2, 2, 2));
    bElementeinfuegen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bElementeinfuegen_ActionPerformed(evt);
      }
    });
    cp.add(bElementeinfuegen);
    
    bElementloeschen.setBounds(616, 32, 120, 24);
    bElementloeschen.setText("Element löschen");
    bElementloeschen.setMargin(new Insets(2, 2, 2, 2));
    bElementloeschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bElementloeschen_ActionPerformed(evt);
      }
    });
    cp.add(bElementloeschen);
    
    nf7.setBounds(560, 32, 48, 24);
    nf7.setText("7");
    nf7.setCaretPosition(0);
    nf7.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(nf7);
    
    bBaumloeschen.setBounds(16, 64, 152, 24);
    bBaumloeschen.setText("Baum loeschen");
    bBaumloeschen.setMargin(new Insets(2, 2, 2, 2));
    bBaumloeschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBaumloeschen_ActionPerformed(evt);
      }
    });
    cp.add(bBaumloeschen);
    
    jTable1ScrollPane.setBounds(24, 472, 1320, 184);
    for (int i = 0; i < tabSpalten; i++) {
      jTable1.getColumnModel().getColumn(i).setHeaderValue(".");
    }
    jTable1.setShowGrid(false);
    cp.add(jTable1ScrollPane);
    
    bDemoBaumerzeugen.setBounds(16, 32, 155, 25);
    bDemoBaumerzeugen.setText("Demo-Baum erzeugen");
    bDemoBaumerzeugen.setMargin(new Insets(2, 2, 2, 2));
    bDemoBaumerzeugen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDemoBaumerzeugen_ActionPerformed(evt);
      }
    });
    cp.add(bDemoBaumerzeugen);
    
    bPreorder.setBounds(867, 32, 123, 25);
    bPreorder.setText("Preorder ");
    bPreorder.setMargin(new Insets(2, 2, 2, 2));
    bPreorder.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bPreorder_ActionPerformed(evt);
      }
    });
    cp.add(bPreorder);
    
    jTextArea1ScrollPane.setBounds(19, 120, 1328, 340);
    cp.add(jTextArea1ScrollPane);
    bMaxSuche.setBounds(864, 64, 123, 25);
    bMaxSuche.setText("MaxSuche");
    bMaxSuche.setMargin(new Insets(2, 2, 2, 2));
    bMaxSuche.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bMaxSuche_ActionPerformed(evt);
      }
    });
    cp.add(bMaxSuche);
    
    bInorder.setBounds(1016, 32, 123, 25);
    bInorder.setText("Inorder");
    bInorder.setMargin(new Insets(2, 2, 2, 2));
    bInorder.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bInorder_ActionPerformed(evt);
      }
    });
    cp.add(bInorder);
    bPostorder.setBounds(1176, 32, 104, 24);
    bPostorder.setFont(new Font("Dialog", Font.BOLD, 11));
    bPostorder.setText("Postorder");
    bPostorder.setMargin(new Insets(2, 2, 2, 2));
    bPostorder.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bPostorder_ActionPerformed(evt);
      }
    });
    cp.add(bPostorder);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public BinSuchBaumTestCanvas
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new BinSuchBaumTestCanvas();
  } // end of main
  
  // Textausgabe mit Zeilenumbruch  
  public static void ausgabeZeile(String txt)
  {
    jTextArea1.append(txt + "\n");
  }
  
  // Textausgabe ohne Zeilenumbruch
  public static void ausgabeText(String txt)
  {
    jTextArea1.append(txt);
  }

  // Ausgabe einer Zahl mit Zeilenumbruch
  public static void ausgabeZahl(int z)
  {
    jTextArea1.append(Integer.toString(z) + "\n");
  }

  // Auf klick Demo-Baum erzeugen
  public static void bDemoBaumerzeugen_ActionPerformed(ActionEvent evt) {
    bnb.makeDemobaum();
    ausgabeZeile("Demo-Baum erzeugt");
    baumzeigen();
  } // end of bDemoBaumerzeugen_ActionPerformed
  
  // Baum loeschen
  public void bBaumloeschen_ActionPerformed(ActionEvent evt) {
    bnb.loescheBaum();
    baumBildLoeschen();
  } // end of bBaumloeschen_ActionPerformed
  
  // PreOrder-Durchlauf ausgeben
  public static void bPreorder_ActionPerformed(ActionEvent evt) {
    ausgabeZeile("Ausgabe Preorder ...");
    bnb.preorderAusgabe(bnb.suchBaum);
  }
  
  // PostOrder-Durchlauf ausgeben
  public static void bPostorder_ActionPerformed(ActionEvent evt) {
    ausgabeZeile("Ausgabe Postorder ...");
    bnb.postorderAusgabe(bnb.suchBaum);
  }
  
  // Baum aus Sicherung restaurieren
  public void bBaumrestaurieren_ActionPerformed(ActionEvent evt) {
    // Aufruf mit ArrayListe als Parameter
    bnb.makeSuchbaum(bnb.lBaumSicherung);
    baumzeigen();
    ausgabeZeile("gesicherten Baum restauriert!");
  } // end of bBaumrestaurieren_ActionPerformed
  
  // aktuellen Baum in Array-Liste sichern
  public void bBaumsichern_ActionPerformed(ActionEvent evt) {
    bnb.baumsichern(bnb.suchBaum);
  } // end of bBaumsichern_ActionPerformed

  // Suche des groessten Wertes
  public void bMaxSuche_ActionPerformed(ActionEvent evt) {
    ausgabeZeile("Suche Maximum ...");
    ausgabeZeile("Maximum: " + bnb.sucheMax(bnb.suchBaum)); 
  } // end of bMaxSuche_ActionPerformed
  
  // InOrder-Durchlauf ausgeben
  public void bInorder_ActionPerformed(ActionEvent evt) {
    ausgabeZeile("Ausgabe Inorder ...");
    bnb.inorderAusgabe(bnb.suchBaum);
    ausgabeZeile(" ");
  } // end of bInorder_ActionPerformed

  // ein Element aus dem Baum entfernen
  public void bElementloeschen_ActionPerformed(ActionEvent evt) {
    if (!nf7.isNumeric()) {
      ausgabeZeile("FEHLER (löschen): Wert eingeben!");
      return;
    } // end of if
    int el = nf7.getInt();
    BaumElementInt be = new BaumElementInt(el);
    if (!bnb.suchBaum.remove(be)) {
      ausgabeZeile("FEHLER (löschen): Element " + Integer.toString(el) + " ist nicht vorhanden!");
    } // end of if
    else {
      ausgabeZeile("Element " + Integer.toString(el) + " wurde gelöscht!");
      baumzeigen();
    } // end of if-else
    
  } // end of bElementloeschen_ActionPerformed
  
  // ein Element in den Baum einfuegen
  public void bElementeinfuegen_ActionPerformed(ActionEvent evt) {
    if (!nf7.isNumeric()) {
      ausgabeZeile("FEHLER (einfügen): Wert eingeben!");
      return;
    } // end of if
    int el = nf7.getInt();
    BaumElementInt be = new BaumElementInt(el);
    if (bnb.suchBaum.insert(be)) {
      ausgabeZeile("Element " + Integer.toString(el) + " wurde hinzugefügt!");
      baumzeigen();
    } 
    else {
      ausgabeZeile("FEHLER (einfügen): Element " + Integer.toString(el) + " existiert bereits!");
    } // end of if-else
  } // end of bElementeinfuegen_ActionPerformed
  
  // die Anzeige des Baumbildes loeschen
  private static void baumBildLoeschen()
  {
    for (int i = 0; i < tabSpalten; i++) {
      for (int k = 0; k < tabZeilen; k++) {
        jTable1.setValueAt(".", k, i);
      }
    }
  }
  
  // Baum als Pseudografik in der Tabelle anzeigen
  public static void baumzeigen()
  {
    baumBildLoeschen();
    baumtiefe = 0;
    int x1 = (tabSpalten/2);
    int y1 = 0;
    knotenzeigen(bnb.suchBaum, x1, y1, x1);
    if (Math.pow(2, baumtiefe) > (tabSpalten/2)) {
      jTextArea1.append("Baumtiefe ist zu groß - Darstellung passt nicht in die Tabelle.\n");
      baumBildLoeschen();
    } // end of if-else
    // Spaltenbreiten der Tabelle den Inhalten anpassen
    initColumnSizes(jTable1);
  }
  
  // den Wert eines Knoten in die Tabelle eintragen und rekursiv den ganzen Baum durchlaufen 
  public static void knotenzeigen(BinarySearchTree baum1, int xx, int yy, int bt)
  {
    if (!baum1.isEmpty()) {
      if (yy > baumtiefe) {
        baumtiefe = yy;
      } // end of if
      if ((xx >= tabSpalten) || (yy >= tabZeilen)) {
        return; // Baum ist zu gross, passt nicht in die Tabelle
      } // end of if
      jTable1.setValueAt(baum1.getContent().getValue(), yy, xx);
      bt = bt/2;
      if (!baum1.getLeftTree().isEmpty()) {
        knotenzeigen(baum1.getLeftTree(), xx-bt, yy+1, bt);
      } // end of if
      if (!baum1.getRightTree().isEmpty()) {
        knotenzeigen(baum1.getRightTree(), xx+bt, yy+1, bt);
      } // end of if
    } // end of if
  }
  
  // Spaltenbreiten einer Tabelle den Inhalten anpassen, damit sie vollstaendig angezeigt werden (wenn moeglich)
  // Aus dem Internet kopiert und leicht verändert)  
  private static void initColumnSizes(JTable table) {
    TableColumn column = null;
    Component comp = null;
    int cellWidth = 0;
    TableCellRenderer render = table.getTableHeader().getDefaultRenderer();
    int colNum = table.getColumnCount();
    int rowNum = table.getRowCount();
    for (int i = 0; i < (colNum); i++) { // Loop über alle cols
      column = table.getColumnModel().getColumn(i);
      comp = render.getTableCellRendererComponent(
             null, column.getHeaderValue(),false, false, 0, 0);
      cellWidth = 2; // gewünschte Mindestbreite
      for (int j=0; j<(rowNum); j++){ // Loop über alle rows
        comp = render.getTableCellRendererComponent(
        table, table.getValueAt(j, i), false, false, j, i);
        cellWidth = Math.max(cellWidth, comp.getPreferredSize().width-2);
      }
      column.setMinWidth(cellWidth);
      column.setPreferredWidth(cellWidth);
    }
  }
  public void bBegruessung_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
        jTextArea1.append("Guten Morgen\n");
  
  } // end of bBegruessung_ActionPerformed

  // Ende Methoden
} // end of class BinSuchBaumTestCanvas
