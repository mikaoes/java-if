
/**
 * Beschreiben Sie hier die Klasse Konverter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Konverter
{
    public static String conv (int zahl) {
        String ergebnis = "";
        while (zahl>=1) {
            ergebnis = ergebnis + zahl%2;
            zahl = zahl/2;
        }
        return ergebnis;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public static void main(String args[])
    {
        // tragen Sie hier den Code ein
        System.out.println(conv(100));
    }
}
