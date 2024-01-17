import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;
/**
 * Beschreiben Sie hier die Klasse Wartezimmer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Wartezimmer
{   
    Queue<Patient> schlange = new Queue<Patient>();
    int plaetze;

    public Wartezimmer(int pPlaetze) {
        plaetze = pPlaetze;
    }

    public static void main (String[] args) {
        Wartezimmer wz = new Wartezimmer(12);

        /* for (int i = 0; i < wz.plaetze; i++) {
            String name = "P" + Integer.toString(ThreadLocalRandom.current().nextInt(100, 1000));
            wz.enqueue(new Patient(name));
        } */

        while (true) {
            wz.tick();
            wz.drucken();
            
            try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                System.out.println("Fehler");
                Thread.currentThread().interrupt();
            }
        }
    }

    public void tick() {
        Patient pat = null;
        Patient dePat = null;

        if (ThreadLocalRandom.current().nextInt(0, 11) == 10) {
            String name = "P" + Integer.toString(ThreadLocalRandom.current().nextInt(100, 1000));
            pat = new Patient(name);
            this.enqueue(pat);
        }

        if (ThreadLocalRandom.current().nextInt(0, 11) == 10 && !schlange.isEmpty()) {
            pat = null;
            dePat = this.dequeue();
        }

        if (pat != null) {
            System.out.println(pat.name + " hinzugefuegt.");
        }
        if (dePat != null) {
            System.out.println(dePat.name + " entfernt.");
        }
    }

    public void enqueue(Patient pPatient) {
        schlange.enqueue(pPatient);
    }

    public Patient dequeue() {
        return schlange.dequeue();
    }

    public void drucken() {
        // Zweitschlange zu Übungszwecken (überflüssig)
        Queue<Patient> druckerSchlange = new Queue<Patient>();
        int laenge = 0;

        String border = "############";
        System.out.println(border);
        System.out.println(schlange.isEmpty());
        System.out.println(schlange.head());

        while(!schlange.isEmpty())  {
            druckerSchlange.enqueue(schlange.dequeue()); // von schlange in druckerSchlange übertragen
            laenge++;
        }

        System.out.println("\n".repeat(100)); // Bildschirm leeren
        System.out.println((border + "  ").repeat(laenge));

        for (int i = 0; i < laenge; i++) {
            Patient aP = druckerSchlange.dequeue();
            System.out.print("#   " + aP.name + "   #  ");
            schlange.enqueue(aP);
        }
        System.out.println();

        System.out.println((border + "  ").repeat(laenge));
    }
}