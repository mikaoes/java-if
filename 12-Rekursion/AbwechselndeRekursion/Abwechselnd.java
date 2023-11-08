
/**
 * Beschreiben Sie hier die Klasse Abwechselnd.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Abwechselnd
{
    public static void main(String[] args) {
        Abwechselnd a = new Abwechselnd();
        System.out.println(a.rekStart(3)); // Ergebnis: "aab"
        System.out.println(a.rekStart(6)); // Ergebnis: "aaabbb"
    }
    public String rekStart (int x) {
        return methA(x);
    }

    public String methA (int n) {
        if (n <= 0) {
            return "";
        } else {
            return "a" +  methB(n-1);
        }
    }
    public String methB (int n) {
        if (n <= 0) {
            return "";
        } else {
            return methA(n-1) + "b";
        }
    }
}
