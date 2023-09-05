import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Schulnoten.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Schulnoten
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Bitte geben Sie eine Schulnote ein: ");
            String[] zahlnote = sc.next().split("");

            if (zahlnote[0].equals("q")) {
                break;
            }

            String[] wortnote = new String[zahlnote.length];
            for(int i = 0; i < zahlnote.length; i++) {
                if (zahlnote[i].equals(",")) {
                    wortnote[i] = "komma";}
                else {
                    wortnote[i] = zahlZuWort(Integer.parseInt(zahlnote[i]));
                }
            }

            for (String i : wortnote) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public static String zahlZuWort(int zahl)
    {
        switch(zahl)
        {
            case 0: return "null";
            case 1: return "eins";
            case 2: return "zwei";
            case 3: return "drei";
            case 4: return "vier";
            case 5: return "fünf";
            case 6: return "sechs";
            case 7: return "sieben";
            case 8: return "acht";
            case 9: return "neun";
        }
        return "Fehler";
    }
}
