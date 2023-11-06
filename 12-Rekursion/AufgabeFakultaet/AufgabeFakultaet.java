
/**
 * Aufgabe Fakultät
 * Version vom Oktober 2023
 * 
 */
import java.util.Scanner;

public class AufgabeFakultaet

{   static long zeitRek = 0;
    static long zeitIter = 0;
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);   
        boolean flag = true;
        while (flag == true)
        {
            System.out.print("Gib die natürliche Zahl (> 0) an, für die die Fakultaet berechnet werden soll. ");   
            int nZahl = console.nextInt();
            
            long zeit = System.currentTimeMillis();
            double ergebnis = fak(nZahl);
            zeitRek = System.currentTimeMillis() - zeit;
            
            zeit = System.currentTimeMillis();
            double itErgebnis = itFak(nZahl);
            zeitIter = System.currentTimeMillis() -zeit;
            
            System.out.println("Der Wert für " + nZahl + "! beträgt " + ergebnis + "." + " Iterativ ist das Ergebnis: " + itErgebnis);
            System.out.println("Die Laufzeiten betragen: Rekursiv - " + zeitRek + "   iterativ - " + zeitIter);
            System.out.println("Möchtest du eine weitere Fakultät berechnen? (Eingabe j für ja und n für nein)"); 
            if (console.next().charAt(0) == 'n')  // Nächstes Zeichen analysieren
            {
                flag = false;   
            }

        }

    }

    public static double fak(double n)
    {
        if (n <= 1) {
            return 1;
        } else {
            return n * fak(n-1);
        }

    }
    
    public static double itFak(double n) {
        double ergebnis = 1;
        for (int i = 1; i <= n; i++) {
            ergebnis *= i;
        }
        return ergebnis;
    }
}
