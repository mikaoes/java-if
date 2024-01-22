
/**
 * Beschreiben Sie hier die Klasse Patient.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Patient
{
    String name;
    public final boolean nP;

    /**
     * Konstruktor für Objekte der Klasse Patient
     */
    public Patient(String pName)
    {
        name = pName;
        nP = false;
    }
    public Patient(String pName, boolean pBool)
    {
        name = pName;
        nP = pBool;
    }

    public String getName() {
        return name;
    }
    public char getBsProblem() {
        return 'X';
    }
}
