
/**
 * Beschreiben Sie hier die Klasse Haeufigkeit.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Haeufigkeit
{
    public static void analyse(String eingabe) {
        eingabe = eingabe.toLowerCase();
        eingabe = eingabe.replace(" ", "");
        int[] anzahl = new int[26];

        for (int i = 0; i<eingabe.length(); i++) {
            anzahl[eingabe.charAt(i)-97]++;
        }
        for (int i = 0; i<26; i++) {
            System.out.println((char) (i+97) + "x" + anzahl[i]);
        }
    }
}
