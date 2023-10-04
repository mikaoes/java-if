
/**
 * Überarbeitete Version der Sortierverfahren 
 * 27.9.2023 
 */

public class Sortierverfahren 
{

    // Individuelle Array-Eingabe in der Form: {3,5,7,1} 

    public static void sort(int[] a) // Insertionsort
    {
        // Ausgabe des unsortierten Original-Arrays
        for (int k = 0; k < a.length; k++) 
        {
            System.out.print(a[k] + "; ");
        }
        System.out.println();
        // Beginn der Sortierung
        for (int i = 1; i < a.length; i++) 
        {
            int aktuellesElement = a[i];
            int j = i;
            while (j > 0 && aktuellesElement < a[j - 1])
            {
                a[j] = a[j - 1];  
                j--;
            }
            a[j] = aktuellesElement;
            // Ausgabe nach Ende jedes Schleifendurchlaufs
            for (int k = 0; k < a.length; k++) 
            {
                System.out.print(a[k] + "; ");
            }
            System.out.println();

        }
    }

    //    public static void sort2(int[] a)  // Methodenkopf für Durchlauf mit einzugebendem Array
    public static void sort2()  // Methodenkopf für Durchlauf mit konstantem Test-Array
    {
        int[] a = {7,5,23,2,8,12,17,11,1}; // Beispiel fuer Array für den Test
        // Ausgabe des unsortierten Original-Arrays
        for (int k = 0; k < a.length; k++) 
        {
            System.out.print(a[k] + "; ");
        }
        System.out.println();    

        int hilf;
        int laenge = a.length;
        for (int j = 0; j < laenge - 1; j++) {
            for (int i = 0; i < laenge - 1 - j; i++)
            {
                if (a[i] > a[i+1])
                {
                    hilf = a[i];
                    a[i] = a[i+1];
                    a[i+1] = hilf;
                }
            }

            // Ausgabe nach Ende jedes Schleifendurchlaufs
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + "; ");
            }                
            System.out.println();
        }

    }

    
    // Variante des 2. Sortierverfahrens mit alternativer Schleifenvariante
    //    public static void sort3(int[] a)  // Methodenkopf für Durchlauf mit einzugebendem Array
    public static void sort3()  // Methodenkopf für Durchlauf mit konstantem Test-Array
    {
        int[] a = {7,15,23,2,8,12,17,11,1}; // Beispiel fuer Array für den Test
        // Ausgabe des unsortierten Original-Arrays
        for (int k = 0; k < a.length; k++) 
        {
            System.out.print(a[k] + "; ");
        }
        System.out.println();       

        int hilf; 
        int laenge = a.length;
        for (int j = laenge - 1; j > 0; j--) {
            for (int i = 0; i < j; i++)
            {
                if (a[i] > a[i+1])
                {
                    hilf = a[i];
                    a[i] = a[i+1];
                    a[i+1] = hilf;
                }
            }
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + "; ");
            }                
            System.out.println();
        }

    }
    public static void kleinsterNachVorne() {
        int[] a = {4, 2, 5, 1, 3};

        for (int i = 0; i < a.length - 1; i++) {
            // Suche index des kleinsten Elements ab i
            int kleinster = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[kleinster]) {
                    kleinster = j;
                }
            }
            // Tausch
            int hilf = a[i];
            a[i] = a[kleinster];
            a[kleinster] = hilf;
        }

        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + "; ");
        }
    }
}
