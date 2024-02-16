
/**
 * Beschreiben Sie hier die Klasse Vokabel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Vokabel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String deutsch;
    private String fremdSprache;

    /**
     * Konstruktor für Objekte der Klasse Vokabel
     */
    public Vokabel(String pDeutsch, String pFremdSprache)
    {
        deutsch = pDeutsch;
        fremdSprache = pFremdSprache;
    }

    public String getDeutsch() {
        return deutsch;
    }

    public String getFS() {
        return fremdSprache;
    }
}
