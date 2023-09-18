import java.util.concurrent.ThreadLocalRandom;

public class Schuetze
{
    int[] treffer = new int[5];
    int summe = 0;
    int[][] tabelle = new int[3][5];

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
    public void printTreffer() {
        System.out.print("[");
        for (int i = 0; i < treffer.length; i++) {
            System.out.print(treffer[i]);
            if (i != treffer.length-1) { System.out.print(", "); }
        }
        System.out.println("]");
    }   

    public static void main(String[] args) 
    {
        Schuetze schuetze1 = new Schuetze();
        Schuetze schuetze2 = new Schuetze();
        
        System.out.println("Summe (Schuetze1): " + schuetze1.summeZwanzigSchuesse());
        schuetze1.printTreffer();
        System.out.println();
        
        System.out.println("Summe (Schuetze2): " + schuetze2.summeZwanzigSchuesse());
        schuetze2.printTreffer();
        System.out.println();
        
        if (schuetze1.summe > schuetze2.summe) {
            System.out.println("Schuetze1 gewinnt.");
        } else if (schuetze1.summe < schuetze2.summe) {
            System.out.println("Schuetze2 gewinnt.");
        } else {
            System.out.println("Unentschieden.");
        }
    }
}
