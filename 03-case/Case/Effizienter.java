import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Effizienter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Effizienter
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] zaehlwoerter = {"null", "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun"};
        while (true) {
            System.out.println("Bitte geben Sie eine Schulnote ein: ");
            String[] zahlnote = sc.next().split("");
            if (zahlnote[0].equals("q")) {
                break;
            }
            for (String i : zahlnote) {
                if (i.equals(",")) {
                    System.out.print("komma ");
                }
                else {
                    System.out.print(zaehlwoerter[Integer.parseInt(i)] + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
