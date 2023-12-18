/**
 * Abstrakte Klasse Geschirr - beschreiben Sie hier die Klasse
 * 
 * @author (Ihr Name)
 * @version (eine Version-Nummer oder ein Datum)
 */
public abstract class Geschirr
{
    private int durchmesser;
    private int hoehe;
    private int gewicht;

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public Geschirr(int pDurchmesser, int pHoehe, int pGewicht)
    {
        durchmesser = pDurchmesser;
        hoehe = pHoehe;
        gewicht = pGewicht;
    }

    public abstract void benutzen();

    public void mase() {
        System.out.println("Durchmesser: " + durchmesser + "\nHoehe: " + hoehe + "\nGewicht: " + gewicht);
    }

    public int getDurchmesser() {
        return durchmesser;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getGewicht() {
        return gewicht;
    }
}
