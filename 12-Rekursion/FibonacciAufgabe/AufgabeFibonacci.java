
/**
 * Aufgabe Fibonacci
 * Version vom Oktober 2023
 * 
 */
import java.util.Scanner;

public class AufgabeFibonacci

{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);   
        boolean flag = true;
        while (flag == true)
        {
            System.out.print("Gib die natürliche Zahl n (> 0) an, für die die n-te Fibonacci-Zahl berechnet werden soll. ");   
            int nZahl = console.nextInt();
            long zeit = System.currentTimeMillis();
            long ergebnis = fib(nZahl);
            zeit = System.currentTimeMillis() - zeit;
            System.out.println("Der Wert der " + nZahl + "-ten Fibonacci-Zahl beträgt " + ergebnis + ". Zeit: " + zeit + "ms.");
            // System.out.println("Möchtest du eine weitere Fibonacci-Zahl berechnen lassen? (Eingabe j für ja und n für nein)"); 
            // if (console.next().charAt(0) == 'n')  
            // {
                // flag = false;   
            // }

        }

    }

    public static long fib(long n)
    {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }
    
    public static void zeitTabelle(int n) {
        for (int i = 1; i <= n; i++) {
            long zeit = System.currentTimeMillis();
            long ergebnis = fib(i);
            zeit = System.currentTimeMillis() - zeit;
            System.out.println(i + ": " + zeit + "ms. : " + ergebnis);
        }
    }
    public static int itFib(int n) {
        int[] zahlen = new int[n];
        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                zahlen[i-1] = 1;
            } else {
                zahlen[i-1] = zahlen[i-2] + zahlen[i-3];
            }
            System.out.println(i + ": " + zahlen[i-1]);
        }
        return zahlen[n-1];
    }
}
