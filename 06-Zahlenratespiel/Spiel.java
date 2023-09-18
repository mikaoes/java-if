import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spiel
{// Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen

    public static void main(String[] args) {
        raten();
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public static void raten()
    {
        int zzahl = ThreadLocalRandom.current().nextInt(1, 101);
        int aVersuche = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            aVersuche += 1;
            int eingabe = sc.nextInt();
            if (eingabe == zzahl) {
                break;
            } else
            if (eingabe < zzahl) {
                System.out.println("Zahl ist hoeher");
            } else {
                System.out.println("Zahl ist niedriger)");
            }
        }
        System.out.println("Du hast mit " + aVersuche + " Versuchen die Zahl " + zzahl + " erraten.");
        sc.close();
    }
}
