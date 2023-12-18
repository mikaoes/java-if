/**
 * Abstrakte Klasse Essgeschirr - beschreiben Sie hier die Klasse
 * 
 * @author (Ihr Name)
 * @version (eine Version-Nummer oder ein Datum)
 */
public abstract class Essgeschirr extends Geschirr

{
    String typ = "essen";

    public Essgeschirr(int pDurchmesser, int pHoehe, int pGewicht) {
        super(pDurchmesser, pHoehe, pGewicht);
    }

    public void benutzen() {
        System.out.println("Essgeschirr wurde benutzt.");
    }
}
