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
    int belegt = 0;

    public Wartezimmer(int pPlaetze) {
        plaetze = pPlaetze;
    }

    public static void main (String[] args) {
        Wartezimmer wz = new Wartezimmer(12);

        System.out.println("Gestartet.");

        while (true) {
            wz.tick();
            
            try {
                Thread.sleep(500);
              } catch (InterruptedException e) {
                System.out.println("Fehler");
                Thread.currentThread().interrupt();
            }
        }
    }

    public void tick() {
        notfallsuche();

        Patient pat = null;
        Patient dePat = null;

        if (ThreadLocalRandom.current().nextInt(5, 11) == 10 && belegt <= plaetze) {
            String name = "P" + Integer.toString(ThreadLocalRandom.current().nextInt(100, 1000));
            if (ThreadLocalRandom.current().nextInt(0, 3) == 1) {
                pat = new Notfallpatient(name);
            } else {
                pat = new Patient(name);
            }
            belegt++;
            this.enqueue(pat);
        }
        if (pat != null) {
            drucken();
            System.out.println(pat.getName() + " hinzugefuegt.");
            return;
        }


        if (ThreadLocalRandom.current().nextInt(5, 11) == 10 && !schlange.isEmpty()) {
            pat = null;
            dePat = this.dequeue();
            belegt--;
        }
        
        if (dePat != null) {
            drucken();
            System.out.println(dePat.getName() + " entfernt.");
            return;
        }
    }

    public void notfallsuche() {
        if (schlange.isEmpty()) {
            return;
        }

        Knoten<Patient> aE = schlange.getHead();
        while (aE != null) {
            Patient aP = aE.holeInhalt();
            if (aP.nP) {
                try {
                    System.out.println(aP.getName() + " ist ein Notfallpatient! Er hat ein " + aP.getBsProblem() + " Problem.");
                } catch(Exception e) {
                    System.out.println("Fehler");
                }
                    
            }
            aE = aE.holeNachbarKnoten();
            if (aE == null) {return;}
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

        while(!schlange.isEmpty())  {
            druckerSchlange.enqueue(schlange.dequeue()); // von schlange in druckerSchlange übertragen
            laenge++;
        }

        System.out.println("\n".repeat(100)); // Bildschirm leeren
        System.out.println((border + "  ").repeat(laenge));

        for (int i = 0; i < laenge; i++) {
            Patient aP = druckerSchlange.dequeue();
            System.out.print("#   " + aP.getName() + "   #  ");
            schlange.enqueue(aP);
        }
        System.out.println();

        System.out.println((border + "  ").repeat(laenge));
    }
}