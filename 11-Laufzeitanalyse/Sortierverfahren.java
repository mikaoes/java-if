
/**
 * Überarbeitete Version der Sortierverfahren 
 * 27.9.2023 
 */
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Sortierverfahren

/*
 * Info: Erzeugen einer Zufallszahl int randomNum = ThreadLocalRandom.current().nextInt(1,6);
 */

//    public static int[] a = {7,15,23,2,8,12,17,11,1}; Testarray der Länge 9
//    public static int[] a = {1,2,3,4,5,6,7,8,9}; // Beispiel sortiertes Array der Länge 9

// Hinweis: Individuelle Array-Eingabe in der Form: {3,5,7,1} 

{
    public static void main(String[] args)
    {
        long[][][] zeiten = new long[3][4][5]; // modus (zufall, sort, antisort)
        String[][] arrays = new String[3][5];

        for (int i = 0; i < 5; i++) {
            arrays[0][i] = String.join(",", zArray((i+1)*10, 0, 100));
        }
        for (int i = 0; i < 5; i++) {
            arrays[1][i] = String.join(",", sArray((i+1)*10, 0));
        }
        for (int i = 0; i < 5; i++) {
            arrays[2][i] = String.join(",", srArray((i+1)*10, -1));
        }

        for (int modus = 0; modus < 3; modus++) {
            for (int algo = 0; algo < 4; algo++) {
                for (int i_ar = 0; i_ar < 5; i_ar++) {
                    switch(algo) {
                        case 0:
                            int[] a = stringToIntArray(arrays[modus][i_ar]);
                            long startzeit = System.currentTimeMillis();
                            insertionSort(a);
                            zeiten[modus][algo][i_ar] = (System.currentTimeMillis() - startzeit);
                    }
                }
            }
        }
    }

    public static void insertionSort(int[] a ) // InsertionSort
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

    public static void bubbleSort(int[] a ) // BubbleSort 
    {
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

    public static void maxSort(int[] a ) // MaxSort (SelectionSort) // Methodenkopf für Durchlauf mit konstantem Test-Array
    {
        // Ausgabe des unsortierten Original-Arrays
        int hilf;  
        int aktIndex = 0; 
        int maxIndex = a.length - 1;  
        int minPosition;
        do 
        {
            // Array jeweils nach dem Start bzw. einem Durchlauf ausgeben
            for (int k = 0; k <= maxIndex; k++) 
            {
                System.out.print(a[k] + "; ");
            }                
            System.out.println();

            minPosition = aktIndex;
            for (int i = (aktIndex + 1); i <= maxIndex; i ++)
            {
                if (a[i]  < a[minPosition])
                {
                    minPosition = i;
                }
            }
            // Vertauschen der Feldwerte
            hilf = a[minPosition];
            a[minPosition] = a[aktIndex];
            a[aktIndex] = hilf;
            aktIndex = aktIndex + 1;
        }
        while (aktIndex < maxIndex); 
    } // Ende maxSort

    public static void quickSort(int[] a,int uG, int oG) // Methodenkopf für Durchlauf mit konstantem Test-Array
    {
        if(uG < oG)
        {
            int pivot = uG;
            int i = uG+1;
            int j = oG;
            // Ausgabe des jeweils aktuellen Arrays 
            for (int k = 0; k < a.length; k++) 
            {
                System.out.print(a[k] + "; ");
            }                
            System.out.println(" -- uG/oG " + uG + " / " + oG);

            // Zerlegung in zwei Teilmengen
            while(i < j)
            {
                while((a[i] < a[pivot]) && (i<j))
                {
                    i++;
                }
                while((a[j] >= a[pivot]) && (i<j))
                {
                    j--;
                }
                int hilf=a[i];
                a[i] = a[j];
                a[j] = hilf;
                // Ausgabe des jeweils aktuellen Arrays 
                for (int k = 0; k < a.length; k++) 
                {
                    System.out.print(a[k] + "; ");
                }                
                System.out.println(" -- i/j " + i + " / " + j);
            }
            // Pivot an die richtige Position setzen
            if(a[i] >= a[pivot])
            {
                i--;
            }
            int hilf=a[pivot];
            a[pivot] = a[i];
            a[i] = hilf;
            // rekursiver Aufruf mit den Teilmengen
            quickSort(a, uG, i-1);

            quickSort(a, i+1, oG);
            // Ausgabe des Arrays nach dem rekursiven Aufruf
            for (int k = 0; k < a.length; k++) 
            {
                System.out.print(a[k] + "; ");
            }                
            System.out.println(" Ende Rekursion: uG: " + uG + " oG: " + oG);
        }

    }

    public static String[] zArray(int len, int uG, int oG) { // Zufallsarray
        String[] r = new String[len];
        for (int i = 0; i < len; i++) {
            r[i] = Integer.toString(ThreadLocalRandom.current().nextInt(uG, oG));
        }
        return r;
    }

    public static String[] sArray(int len, int start) { // Sortiertes Array
        String[] r = new String[len];
        for (int i = start; i < len; i++) {
            r[i] = Integer.toString(i);
        }
        return r;
    }

    public static String[] srArray(int len, int start) { // rückwärts sortiertes Array
        if (start == -1) {
            start = len-1;
        }
        String[] r = new String[len];
        for (int i = start; i < len; i++) {
            r[i] = Integer.toString(start-i);
        }
        return r;
    }
    public static int[] stringToIntArray(String input) {
        int[] r = new int[(input.length()/2)];
        for (int i = 0; i < input.length(); i++) {
            String v = Character.toString(input.charAt(i));
            if (v.equals(",")) {
                continue;
            }
            r[i/2] = Integer.parseInt(v);
        }
        return r;
    }
}

