import java.util.concurrent.ThreadLocalRandom;
/**
 * Beschreiben Sie hier die Klasse Notfallpatient.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Notfallpatient extends Patient
{   
    char bsProblem;

    /**
     * Konstruktor für Objekte der Klasse Notfallpatient
     */
    public Notfallpatient(String pName)
    {   
        super(pName.replace("P", "N"), true);
        
        bsProblem = "ABCDE".charAt(ThreadLocalRandom.current().nextInt(0, 5));

    }
    public char getBsProblem() {
        return bsProblem;
    }
}
