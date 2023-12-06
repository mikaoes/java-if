import java.util.concurrent.ThreadLocalRandom;
/**
 * Beschreiben Sie hier die Klasse Klausur.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Klausur
{
    public static int linSuche(int[] a, int s) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == s) {
                return i;
            }
        }
        return -1;
    }
    
    public static int[] zufallsArray (int len) {
        int[] a = new int[len];
        for (int i = 0; i < a.length; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(1,101);
        }
        return a;
    }
    
    public static void main (String[] args) {
        int[] array = zufallsArray(15);
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " - " + array[i]);
        }
        int suchZahl = array[ThreadLocalRandom.current().nextInt(0, array.length)];
        System.out.println("Gesuchte Stelle: " + suchZahl + " - " + linSuche(array, suchZahl));
    }
    
    public static int anzahl(int x, int y) {
        int[] nachbarn = new int [8];
        int = {
            b[x-1][y];              b[x+1][y];
            b[x-1][y+1]; b[x][y+1]; b[x+1][y+1];
            b[x-1][y-1]; b[x][y-1]; b[x+1][y-1];
        }
    }
}
