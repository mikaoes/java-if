
/**
 * Beschreiben Sie hier die Klasse Spieler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spieler
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String name = "";
    private int punkte;

    /**
     * Konstruktor für Objekte der Klasse Spieler
     */
    public Spieler(String pName)
    {
        name = pName;
        punkte = 0;
    }

    public String getName() {
        return name;
    }

    public int getPunkte() {
        return punkte;
    }

    public void addPunkte(int pPunkte) {
        punkte = punkte + pPunkte;
    }

}
