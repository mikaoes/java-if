import java.util.concurrent.ThreadLocalRandom;

public class Schuetze
{
    int[] treffer = new int[5];
    int summe = 0;
    int[][] tabelle;

    public Schuetze()
    {
        for (int i = 0; i < treffer.length; i++) {
            treffer[i] = 0;
        }
    }

    public void trefferEinfuegen(int pTreffer)
    {
        if (pTreffer > treffer.length || pTreffer < 1) {
            System.out.println("Fehler: Eingabe ausserhalb der Punkteskala");
            return;
        }
        treffer[pTreffer-1]++;

    }

    public int summeZwanzigSchuesse()
    {   
        for (int i = 0; i < 20; i++) {
            int rand = ThreadLocalRandom.current().nextInt(1, 6);
            treffer[rand-1]++;
            summe += rand;
        }
        return summe;
    }
    public int summeZSmehrereDurchG(int anzahlDurchG)
    {
        int summen[] = new int[anzahlDurchG];
        tabelle = new int[anzahlDurchG][5];
        for (int i = 0; i < anzahlDurchG; i++) {
            for (int j = 0; j < 20; j++) {
                int rand = ThreadLocalRandom.current().nextInt(1, 6);
                tabelle[i][rand-1]++;
                summen[i] += rand;
            }
        }
        int max = 0;
        for (int i = 0; i < summen.length; i++) {
            if (summen[i] > max) {
                max = summen[i];
            }
        }
        summe = max;
        return max;
    }
    public void printTreffer() {
        System.out.print("[");
        for (int i = 0; i < treffer.length; i++) {
            System.out.print(treffer[i]);
            if (i != treffer.length-1) { System.out.print(", "); }
        }
        System.out.println("]");
    }
    public void printTabelle() {
        int maxRowSum = 0;
        int maxRowSumIndex = 0;

        for (int i = 0; i < tabelle.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < tabelle[i].length; j++) {
                rowSum += tabelle[i][j] * (j+1);
            }
            if (rowSum > maxRowSum) {
                maxRowSum = rowSum;
                maxRowSumIndex = i;
            }
        }

        for (int i = 0; i < tabelle.length; i++) {
            System.out.print("[");
            for (int j = 0; j < tabelle[i].length; j++) {
                System.out.print(tabelle[i][j]);
                if (j != tabelle[i].length-1) { System.out.print(", "); }
            }
            System.out.print("]");

            if (i == maxRowSumIndex) {
                System.out.println(" <--- " + maxRowSum);
            }   else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) 
    {
        Schuetze schuetze1 = new Schuetze();
        Schuetze schuetze2 = new Schuetze();


        if (args.length == 0) {
            System.out.println("Summe (Schuetze1): " + schuetze1.summeZwanzigSchuesse());
            schuetze1.printTreffer();
            System.out.println();
            
            System.out.println("Summe (Schuetze2): " + schuetze2.summeZwanzigSchuesse());
            schuetze2.printTreffer();
            System.out.println();
        } else {
            int anzahlDurchG = Integer.parseInt(args[0]);
            System.out.println("Summe (Schuetze1): " + schuetze1.summeZSmehrereDurchG(anzahlDurchG));
            schuetze1.printTabelle();
            System.out.println();
            
            System.out.println("Summe (Schuetze2): " + schuetze2.summeZSmehrereDurchG(anzahlDurchG));
            schuetze2.printTabelle();
            System.out.println();
        }

        
        if (schuetze1.summe > schuetze2.summe) {
            System.out.println("Schuetze1 gewinnt.");
        } else if (schuetze1.summe < schuetze2.summe) {
            System.out.println("Schuetze2 gewinnt.");
        } else {
            System.out.println("Unentschieden.");
        }
    }
}
