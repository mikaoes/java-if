
/**
 * Beschreiben Sie hier die Klasse Rueckwaerts.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Rueckwaerts
{
    public static void rueck(String eingabe)
    {
       for (int i = 0; i<eingabe.length(); i++) {
        System.out.print(eingabe.charAt(eingabe.length()-i-1));
       }
       System.out.println();
    }
}
