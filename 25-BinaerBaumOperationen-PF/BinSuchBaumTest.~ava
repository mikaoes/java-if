
/**
 * Beschreiben Sie hier die Klasse BinSuchBaumTest.
 * 
 * Pfeifer
 * @version 1.0 von 2022 
 */
 import java.util.*;

public class BinSuchBaumTest
{
  // Vorgabe des Demo-Baum-Inhaltes:
  private static Integer[] demoBaumInhalt = {17, 14, 15, 11, 8, 10, 13, 4, 55, 9, 71, 91, 81, 31, 40, 99};
  // Speicher fuer die Sicherung des Baumes (ArrayList ist ein dynamisches Array)
  public static ArrayList<Integer> lBaumSicherung = new ArrayList<Integer>();
  // Tiefe der rekursiven Aufrufe bei den Baum-Durchlaeufen
  private static int ebene = 0; 
  
  // leeren Knoten fuer den Anfang erzeugen (die Wurzel):
  public static BinarySearchTree <BaumElementInt> suchBaum = new BinarySearchTree<BaumElementInt>();
  
  /**
  * Konstruktor für Objekte der Klasse BinSuchBaumTest
  */
  public BinSuchBaumTest()  {
  }
  
  // Zwischenspeicherung vorbereiten
  public static void baumsichern(BinarySearchTree baum) {
    if (baum.isEmpty()) {
      return;
    } // end of if
    // Speicher fuer die Sicherung leeren
    lBaumSicherung.clear();
    // den Preorder-Durchlauf in den Sicherungspeicher (ArrayList) speichern
    preorderSpeichern(baum);
    BinSuchBaumTestCanvas.ausgabeZeile ("Baum gesichert!");
  }
  
  // Speichert den PreOrder-Durchlauf in einem dynamischen Array (ArrayList)
  private static void preorderSpeichern(BinarySearchTree baum)
  {
    if (baum.isEmpty()) { // bei leerem Baum nichs tun (Abbruch der Rekursion)
      return;
    } // end of if
    // aktuellen Knoten der Array-Liste hinzufuegen
    lBaumSicherung.add(baum.getContent().getValue());
    // Baum rekursiv durchlaufen
    if(!baum.getLeftTree().isEmpty())
    {
      preorderSpeichern(baum.getLeftTree());
    }
    if(!baum.getRightTree().isEmpty())
    {
      preorderSpeichern(baum.getRightTree());
    }
  }
  
  // PreOrder-Durchlauf ausgeben (mit Zwischenergebnissen nur zur Info!)
  public static void preorderAusgabe(BinarySearchTree baum)
  {
    if (baum.isEmpty()) {
      return; // bei leerem Baum nichs tun (Abbruch der Rekursion)
    } // end of if
    // Tiefe des Baumes protokollieren
    ebene++;
    // Inhalt des aktuellen Kontens ausgeben 
    BinSuchBaumTestCanvas.ausgabeZeile(Integer.toString(baum.getContent().getValue()));
    // Baum rekursiv durchlaufen
    if(!baum.getLeftTree().isEmpty())
    {
      BinSuchBaumTestCanvas.ausgabeText ("L: Ebene: " + Integer.toString(ebene) + " Wert: ");  // nur zu Ausgabezwecken
      preorderAusgabe(baum.getLeftTree());
    }
    if(!baum.getRightTree().isEmpty())
    {
      BinSuchBaumTestCanvas.ausgabeText ("R: Ebene: " + Integer.toString(ebene) + " Wert: "); // nur zur Ausgabezwecken
      preorderAusgabe(baum.getRightTree());
    }
    // es geht wieder eine Ebene zurueck
    ebene--;
  }
  
  // InOrder-Durchlauf starten
  public static void inorderAusgabe(BinarySearchTree baum)
  {
    if (baum.isEmpty()) {
      return; // bei leerem Baum nichs tun (Abbruch der Rekursion)
    } // end of if
    // Baum rekursiv durchlaufen
    if(!baum.getLeftTree().isEmpty())
    {
      inorderAusgabe(baum.getLeftTree());
    }
    BinSuchBaumTestCanvas.ausgabeText(Integer.toString(baum.getContent().getValue()) + ", ");
    if(!baum.getRightTree().isEmpty())
    {
      inorderAusgabe(baum.getRightTree());
    }
  }
  
  // PostOrder-Durchlauf starten
  public static void postorderAusgabe(BinarySearchTree baum)
  {
    if (baum.isEmpty()) {
      return; // bei leerem Baum nichs tun (Abbruch der Rekursion)
    } // end of if
    // Baum rekursiv durchlaufen
    if(!baum.getLeftTree().isEmpty())
    {
      postorderAusgabe(baum.getLeftTree());
    }
    if(!baum.getRightTree().isEmpty())
    {
      postorderAusgabe(baum.getRightTree());
    }
    BinSuchBaumTestCanvas.ausgabeText(Integer.toString(baum.getContent().getValue()) + ", ");
  }
  
  // Groeste Zahl im Baum ausgeben
  public static Integer sucheMax(BinarySearchTree baum)
  {
    if (baum.isEmpty()) {
      return null;
    } // end of if
    if(baum.getRightTree().isEmpty()) // Am Ende der rechten Zweige steht der groesste Wert
    {
      BinSuchBaumTestCanvas.ausgabeZeile ("Gefunden! Ebene: " + Integer.toString(ebene) + " Wert: " + Integer.toString(baum.getContent().getValue()));
      ebene = 0;
      return baum.getContent().getValue();
    }
    else
    {
      ebene++;
      // rekursiv weitersuchen
      return sucheMax(baum.getRightTree());
    }
  }
  
  // Baum ganz loeschen
  public static void loescheBaum() {
    BinSuchBaumTestCanvas.ausgabeZeile ("Baum geloescht!");
    suchBaum.emptyTree();
  }
  
  // einen Baum aus vorgegebenen Elementen zur Demonstration erzeugen
  public static void makeDemobaum()
  {
    // das statische Array mit den vorgegebenen Werten in eine Arrayliste umspeichern
    ArrayList<Integer> aListe = new ArrayList<Integer>(Arrays.asList(demoBaumInhalt));
    makeSuchbaum(aListe);
    for(int i=0; i < (demoBaumInhalt.length); i++)
    {
      // Vorgabe-Werte aendern, dann können bei wiederholtem Aufruf neue Elemente hinzugefuegt werden 
      // (bei 3 werden noch 2 zusaetzliche Aufrufe dargestellt)
      demoBaumInhalt[i]+=3;
    }
  }
  
  // Baum erzeugen mit ArrayList als Parameter
  public static void makeSuchbaum(ArrayList<Integer> al)
  {
    for (Integer el: al)    {    // Schleife ueber Liste
      BaumElementInt be = new BaumElementInt(el);       // xx Zugriff auf Liste
      boolean b = suchBaum.insert(be);  // Returnwert interessiert hier nicht.
    }    
  }
}
