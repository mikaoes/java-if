
/**
 * suche1:
 * In einem Zahlenarray, in dem die Zahlen durch einen Zufallsgenerator erzeugt werden  
 * und somit ungeordnet vorliegen, soll geprüft werden, ob eine über die 
 * Tastatur eingegebene Zahl in dem array vorhanden ist.  
 * Die Ausgabe soll entsprechend erfolgen.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.concurrent.ThreadLocalRandom; // Für Erzeugung von Zufallszahlen
import java.util.Scanner;

public class suche1
{
    public static int suche1 (int arr[] , int a) // erstes Element gescht
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                return i;
            }
        }
        return -1;
    }

    public static void main (String args []) 
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Anzahl der Listenelemente: ");
        int elementeAnzahl = console.nextInt();
        int[] liste1 = new int[elementeAnzahl];    // array fuer Liste mit unsortieren Elementen
        // Unsortierte Liste erzeugen und ausgeben
        System.out.print("Unsortierte Liste: ");
        for (int i = 0; i < elementeAnzahl; i++) 
        { 
            int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
            liste1[i] = randomNum;
        }
        System.out.println (java.util.Arrays.toString(liste1));
        
        System.out.print("Welche Zahl soll gesucht werden? ");
        int a = console.nextInt();
        int Ausgabe = suche1 (liste1, a);
        System.out.println ("Das gesuchte Element ist: " + a); 
        if (Ausgabe == -1) 
        {
            System.out.println ("Das gesuchte Element ist nicht im Array vorhanden"); 
        }
        else 
        {
            System.out.println ("Das Element " + a + " wurde bei Index " + Ausgabe + " gefunden"); 
        }
    }
}
