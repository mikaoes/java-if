
/**
 * Beschreiben Sie hier die Klasse Collatz.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Collatz
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.println(i + ": " + berechne(i));
        }
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public static int berechne(int n)
    {
        int zaehler = 0;
        while (n != 1) {
            if (n%2 == 0) {
                n = n/2;
            } else {
                n = n*3+1;
            }
            zaehler++;
        }
        return zaehler;
    }
}
