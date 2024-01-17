
/**
 * Beschreiben Sie hier die Klasse Schlangentest.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Zahlenschlange {
    Queue<Integer> schlange1 = new Queue<Integer>();
    Queue<Integer> schlange2 = new Queue<Integer>();
    Queue<Integer> schlange3 = new Queue<Integer>();

    public void generieren(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            int zufallszahl = ThreadLocalRandom.current().nextInt(10, 100);
            if (zufallszahl % 3 == 0) {
                schlange1.enqueue(zufallszahl);
            } else if (zufallszahl % 3 == 1) {
                schlange2.enqueue(zufallszahl);
            } else {
                schlange3.enqueue(zufallszahl);
            }
        }
    }

    public void ausgeben() {
        System.out.println("\n");

        System.out.println("Schlange 1: (Rest: 0)");
        while (!schlange1.isEmpty()) {
            System.out.print(schlange1.dequeue() + " ");
        }
        System.out.println("\n");

        System.out.println("Schlange 2: (Rest: 1)");
        while (!schlange2.isEmpty()) {
            System.out.print(schlange2.dequeue() + " ");
        }
        System.out.println("\n");

        System.out.println("Schlange 3: (Rest: 2)");
        while (!schlange3.isEmpty()) {
            System.out.print(schlange3.dequeue() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Zahlenschlange zs = new Zahlenschlange();
        Scanner sc = new Scanner(System.in);

        System.out.println("Wie viele Zahlen sollen generiert werden?");
        try {
            zs.generieren(Integer.parseInt(sc.nextLine()));
        } catch (Exception e) {
            zs.generieren(30);
        }

        zs.ausgeben();
    }

}
