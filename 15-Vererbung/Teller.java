
/**
 * Beschreiben Sie hier die Klasse Teller.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Teller extends Essgeschirr
{
    public Teller(int pDurchmesser, int pHoehe, int pGewicht) {
        super(pDurchmesser, pHoehe, pGewicht);
    }

    public static void main(String[] args) {
        Teller t = new Teller(30, 10, 50);
        t.benutzen();
        t.mase();
    }
    
}
