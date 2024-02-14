
/**
 * Beschreiben Sie hier die Klasse Knoten.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class Knoten<T>
{
    private T inhalt; // Fach für den Inhalt
    private Knoten<T> naechster; // "Extraabteil" für den Verweis auf 1 anderen Knoten

    public Knoten(T neuesElement) // Konstruktor
    {
        inhalt = neuesElement;
        naechster = null;
    }

    public T holeInhalt()
    {
        return (inhalt);
    }

    public void setzeInhalt(T inhaltNeu)
    {
        inhalt = inhaltNeu;
    }

    public Knoten<T> holeNachbarKnoten()
    {
        return (naechster);
    }

    public void setzeNaechsten (Knoten<T> neuerNaechster) // für Schlange nötig 
    {
        naechster = neuerNaechster;
    }
}