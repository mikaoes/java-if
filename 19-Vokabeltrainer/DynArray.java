
/**
 * Beschreiben Sie hier die Klasse DynArray.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class DynArray<T>
{
    private Knoten<T> head1; // Verankerung der Struktur
    private Knoten<T> tail1; // Das Ende, erleichtert das Anhaengen neuer Elemente
    private int size = 0; // Anzahl der Elemente

    public DynArray() // Konstruktor
    {
        // um neues leeres Array anzulegen
        head1 = null;
        tail1 = null;
    } 

    public Knoten<T> sucheKnoten(int index) // index muss existieren! Vor Aufruf pruefen
    {
        Knoten<T> gefunden = head1; // Startwert fuer die Suche
        for (int i=0; i<index; i++)
        {
            gefunden = gefunden.holeNachbarKnoten(); // bis zum Index durchhangeln
        }
        return gefunden;
    }

    public boolean isEmpty() // ermittelt, ob der Speicher leer ist
    {
        return (size == 0);
    }

    public T getItem(int index) // gibt das gewuensche Element zurueck
    {
        if(!isEmpty() && (index<size))
        {
            return (sucheKnoten(index).holeInhalt());
        }
        else
        {
            return null;
        }
    }

    public void setItem(int index, T neuerInhalt) // speichert neuen Inhalt
    {
        if(!isEmpty() && (index<size))
        {
            sucheKnoten(index).setzeInhalt(neuerInhalt);
        }
    }

    public void delete(int index) // entfernt das gewuenschte Element aus dem Array
    {
        if(!isEmpty() && (index < size))
        {
            if(index == 0) // Sonderbehandlung: das erste Element soll entfernt werden
            { // nur den Startzeiger auf das 2. Element umsetzen
                head1 = head1.holeNachbarKnoten();
            }
            else
            { // Element aus der Verkettung entfernen
                Knoten<T> vorgaenger = sucheKnoten(index-1);
                vorgaenger.setzeNaechsten((vorgaenger.holeNachbarKnoten()).holeNachbarKnoten());
            }
            size--;
        }
    }

    public void append(T neuesElement) // übergebenes Element an das Array anhaengen
    {
        if(neuesElement != null)
        {
            Knoten kNeu = new Knoten<T>(neuesElement);
            if (isEmpty())
            {
                head1 = kNeu; //1. Element: auch kopf muss auf den neuen Knoten zeigen
            }
            else
            {
                tail1.setzeNaechsten(kNeu); //sonst: Vorgänger muss auf neu zeigen
            }
            tail1 = kNeu; //tail muss immer auf den letzten Knoten zeigen
            size++;
        }
    }

    public void insertAt(int index, T neuesElement) // neues Element an der gewuenschten Position einfuegen
    {
        if((neuesElement != null) && (index <= size))
        {
            if(isEmpty() || (index == size))
            { // array ist leer oder es soll am Ende eingefuegt werden, dann ist es wie anhaengen
                append(neuesElement);
            }
            else
            {
                Knoten kNeu = new Knoten<T>(neuesElement);
                if(index == 0) // element vorne anstellen
                {
                    kNeu.setzeNaechsten(head1);
                    head1 = kNeu;
                }
                else
                {
                    Knoten<T> vorgaenger = sucheKnoten(index-1);
                    kNeu.setzeNaechsten(vorgaenger.holeNachbarKnoten());
                    vorgaenger.setzeNaechsten(kNeu);
                }
                size++;
            }
        }
    }

    public int getLength() // gibt die Anzahl der Array-Elemente zurueck
    {
        return size;
    }

}
