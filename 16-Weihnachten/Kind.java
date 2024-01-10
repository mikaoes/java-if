
/**
 * Beschreiben Sie hier die Klasse Kind.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kind extends Mensch
{
    Weihnachtsmann wm;
    Geschenk[] geschenke = new Geschenk[3];
    
    public Kind(String pVorname, String pNachname, String pStrasse, int pHausnummer)
    {
        vorname = pVorname;
        nachname = pNachname;
        strasse = pStrasse;
        hausnummer = pHausnummer;
    }
    
    public void sichBedanken() {
        System.out.println("Danke Weihnachtsmann!");
    }
}
