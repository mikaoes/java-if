import java.util.concurrent.ThreadLocalRandom;
/**
 * Beschreiben Sie hier die Klasse Schlangentest.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner;

public class Schlangetest
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    // private static Stack stapel;

    /**
     * Konstruktor für Objekte der Klasse Schlangentest
     */
    public Schlangetest()
    {
    }

    /**
     * 
     */
    public static void main(String[] args)
    {

        System.out.println("Es soll eine Schlange aus Zeichenketten erzeugt werden.");
        // Erzeugung eines Schlagenobjekts
        Queue<String> schlange = new Queue<String> ();
        // Erzeugung eines Scanner-Objekts     
        Scanner console = new Scanner(System.in);
        int z = 0;
        while (z !=5) 
        {
            System.out.println("Was wollen sie machen? ");
            System.out.println("Geben Sie 1 ein für Element in die Schlange einfügen.");
            System.out.println("Geben Sie 2 ein für Elemente der Schlange anzeigen.");
            System.out.println("Geben Sie 3 ein für Kopf der Schlange anzeigen.");
            System.out.println("Geben Sie 4 ein für Kopf der Schlange löschen.");
            System.out.println("Geben Sie 5 ein für Programm mit Schlange beenden.");
            System.out.println("Geben Sie 6 ein für Ausgabe ohne Löschen.");
            System.out.println("Geben Sie 7 ein für Ausgabe nach Index.");
            System.out.println("Geben Sie 8 ein für das Zufallsprogramm.")
            System.out.println();

            z = console.nextInt();
            switch(z){
                case 1:
                    System.out.println("Welche Zeichenkette soll in die Schlange eingefügt werden?");
                    String ein = console.next();
                    schlange.enqueue(ein);
                    break;
                case 2:
                int i = 1;
                    while(!schlange.isEmpty()) {
                        System.out.println("Element"+ i + ": "+ schlange.dequeue());
                        i++;
                    }
                    System.out.println("Schlange leer!");
                    break;
                case 3:
                    if (!schlange.isEmpty()) {
                        System.out.println(schlange.head());
                    } else {
                        System.out.println("Schlange leer!");
                    }
                    break;
                case 4:
                    String aus = schlange.dequeue();
                    if (aus != null)
                    {
                        System.out.println(aus + " wurde gelöscht");
                    }
                    else{
                        System.out.println("Es war nichts mehr da zum Löschen.");
                    }

                    break;  
                case 5:
                    break;
                case 6:
                    Knoten aE = schlange.getHead();
                    int j = 1;
                    while(!schlange.isEmpty() && aE != null) {
                        System.out.println("Element" + ": " + aE.holeInhalt());
                        aE = aE.holeNachbarKnoten();
                        j++;
                    }
                case 7:
                    System.out.println("Welcher Index soll ausgegeben werden: ");
                    int suchIndex = console.nextInt();
                    
                    Knoten aE7 = schlange.getHead();
                    int x = 0;
                    while(!schlange.isEmpty() && aE7 != null) {
                        if (x == suchIndex) {
                            System.out.println(aE7.holeInhalt());
                            break;
                        }
                        aE7 = aE7.holeNachbarKnoten();
                        x++;
                    }
                    break;

                case 8:
                    zufallsAufgabe();
                    break;

                default:
                    System.out.println("Ungültige Zahl eingegeben");
                    break;
            } 

        }   

    }
    public static void zufallsAufgabe() {
        Queue schlange1 = new Queue();
        Queue schlage2 = new Queue();
        Queue schlange3 = new Queue();

        int z;

        for (int i = 0; i < 30; i++) {
            z = ThreadLocalRandom.nextInt();
            switch (z%3) {
                case 0:
                    schlange1.enqueue(z);
                case 1:
                    schlange2.enqueue(z);
                case 2:
                    schlange3.enqueue(z);
            }

        }

        for(int z = 0; z < 30; z++) {
            System.out.println();
        }

        Knoten aE = schlange1.getHead();
        while(!schlange1.isEmpty() && aE != null) {
            System.out.print(aE.holeInhalt() + "   ");
            aE = aE.holeNachbarKnoten();
        }
        Knoten aE = schlange2.getHead();
        while(!schlange2.isEmpty() && aE != null) {
            System.out.print(aE.holeInhalt() + "   ");
            aE = aE.holeNachbarKnoten();
        }
        Knoten aE = schlange2.getHead();
        while(!schlange2.isEmpty() && aE != null) {
            System.out.print(aE.holeInhalt() + "   ");
            aE = aE.holeNachbarKnoten();
        }
    }
}
