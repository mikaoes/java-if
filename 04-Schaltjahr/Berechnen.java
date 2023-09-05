import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Berechnen.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Berechnen
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Jahreszahl: ");
            int jahr = sc.nextInt();
            if (jahr == 0) {
                break;
            }
            
            rechner(jahr);
        }
    }

    private static void rechner(int jahr) {
        if (jahr%4 == 0 && jahr%100 != 0 || jahr%100 == 0 && jahr%400 == 0) { // durch 4 teilbar und nicht durch 100   oder   durch 100 und 400 teilbar
            System.out.println("Schaltjahr");
        } else {
            System.out.println("Kein Schaltjahr");
        }
    }
}
