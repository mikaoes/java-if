
/**
 * Hier soll die binäre Suche implementiert werden.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner;

public class BinSearch {
    static int binary_search(int arr[], int suchwert) {
        int links = 0; /* man beginne beim kleinsten Index */
        int rechts = arr.length - 1; /* Arrays-Index beginnt bei 0 */

        while (links <= rechts) /* solange links und rechts nicht übereinander stehen */
        {
            int mitte = (links + rechts) / 2; /* Mitte des Arrays */
            if (arr[mitte] == suchwert) /* Wert gefunden */
            {
                return mitte; /* Index zurückgeben */
            }
            if (arr[mitte] < suchwert) /* Wert größer als Mitte */
            {
                links = mitte + 1; /* neuer Bereich: rechts von Mitte */
            } else /* Wert kleiner als Mitte */
            {
                rechts = mitte - 1; /* neuer Bereich: links von Mitte */
            }
        }

        return -1; // Rückgabewert, wenn Zahl nicht enthalten
    }

    static int lin_search(int arr[], int suchwert) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == suchwert) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        int[] liste1 = { 1, 2, 8, 10, 13, 17, 22, 24, 31, 40, 55, 69, 71, 81, 91, 100 };
        System.out.println(java.util.Arrays.toString(liste1));

        System.out.print("Welche Zahl soll gesucht werden? ");
        int a = console.nextInt();
        System.out.println("Das gesuchte Element ist: " + a);

        System.out.println("l: lineare Suche / b: binäre Suche");
        String eingabe = console.next();
        int Ausgabe = -1;
        if (eingabe.equals("l")) {
            Ausgabe = lin_search(liste1, a);
        } else if (eingabe.equals("b")) {
            Ausgabe = binary_search(liste1, a);
        } else {
            System.out.println("Falsche Eingabe");
        }

        if (Ausgabe == -1) {
            System.out.println("Das gesuchte Element ist nicht im Array vorhanden");
        } else {
            System.out.println("Das Element " + a + " wurde bei Index " + Ausgabe + " gefunden");
        }
    }
}
