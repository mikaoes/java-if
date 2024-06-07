/**
 * Beschreiben Sie hier die Klasse Konverter.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Konverter {

    public static String conv(int zahl) {
        String ergebnis = "";
        while (zahl > 0) {
            ergebnis = (zahl % 2) + ergebnis;
            zahl = zahl / 2;
        }
        return ergebnis;
    }

    public static void main(String args[]) {
        for (int i : new int[] { 0, 10, 25, 100, 256, 738 }) {
            System.out.println(i + " -> " + conv(i));
        }
    }

    /*
     * Korrekte Ergebnisse:
     * 0 -> 0
     * 10 -> 1010
     * 25 -> 11001
     * 100 -> 1100100
     * 256 -> 100000000
     * 738 -> 1011100010
     */
}
