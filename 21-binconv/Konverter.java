import java.lang.Math;
/**
 * Beschreiben Sie hier die Klasse Konverter.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Konverter {

    public static String to_bin(int zahl) {
        String ergebnis = "";
        while (zahl > 0) {
            ergebnis = (zahl % 2) + ergebnis;
            zahl = zahl / 2;
        }
        return ergebnis;
    }

    public static int to_dec(String zahl) {
        int ergebnis = 0;

        for (int i=0; i<zahl.length(); i++) {
            ergebnis +=  Character.getNumericValue(zahl.charAt(i)) * java.lang.Math.pow(2, (zahl.length()-(i+1)));
        }
        return ergebnis;
    }

    public static void main (String args[]) {
        for (int i : new int[] { 0, 10, 25, 100, 256, 738 }) {
            System.out.println(i + " -> " + to_bin(i));
        }

        System.out.println("110 -> " + to_dec("110"));
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
