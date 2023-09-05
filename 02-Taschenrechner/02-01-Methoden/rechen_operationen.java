
/**
 * Beschreiben Sie hier die Klasse rechen_operationen.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class rechen_operationen
{
    public rechen_operationen()
    {

    }

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

    public double teste_summiere()
    {
        return summiere(3.14, 2.7);
    }

    public double teste_subtrahiere()
    {
        return subtrahiere(3.14, 2.7);
    }

    public double teste_multipliziere()
    {
        return multipliziere(3, 17);
    }
}
