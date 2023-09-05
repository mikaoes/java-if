
/**
 * Beschreiben Sie hier die Klasse rechen_operationen.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class rechen_operationen
{

    public double summiere(double... eingabe)
    {   
        double ergebnis = 0;
        for (double i : eingabe) {
            ergebnis += i;
        }
        return ergebnis;
    }

    public double subtrahiere(double... eingabe)
    {   
        double ergebnis = eingabe[0]*2;
        for (double i : eingabe) {
            ergebnis -= i;
        }
        return ergebnis;
    }

    public double multipliziere(double... eingabe)
    {   
        double ergebnis = eingabe[0];
        for (double i : eingabe) {
            ergebnis *= i;
        }
        ergebnis = ergebnis / eingabe[0];
        return ergebnis;
    }
    public double dividiere(double... eingabe)
    {   
        double ergebnis = eingabe[0]*eingabe[0];
        for (double i : eingabe) {
            ergebnis /= i;
        }
        return ergebnis;
    }
    public double potenz (double basis, double exponent)
    {
        double ergebnis = basis;
        for (int i = 1; i < exponent; i++) {
            ergebnis *= basis;
        }
        return ergebnis;
    }
    public double qwurzel (double radikant)
    {
        double ergebnis = radikant;
        for (int i = 1; i < 100; i++) {
            ergebnis = (ergebnis + radikant/ergebnis)/2;
        }
        return ergebnis;
    }
}
