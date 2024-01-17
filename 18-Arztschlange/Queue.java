
/**
 * Beschreiben Sie hier die Klasse Queue.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Queue<T>
{
    private Knoten<T> head1; // Verankerung der Struktur
    private Knoten<T> tail1;

    public Queue() // Konstruktor
    {
        head1 = null; // um neue leere Schlange anzulegen
        tail1 = null;
    } 

    public boolean isEmpty() // sagt, ob der Speicher leer ist
    { // genau dann wahr, wenn die Schlange leer ist
        return (head1 == null);
    }

    public T head() // zeigt/kopiert oberstes Element, ohne die Schlange zu ändern
    {
        if(!isEmpty())
        {
            return (head1.holeInhalt());
        }
        else
        {
            return null;
        }
    }

    public Knoten getHead() {
        return head1;
    }

    public T dequeue() // zeigt oberstes El. und entfernt es aus der Schlange
    {
        if(!isEmpty())
        {
            T altesElement = head1.holeInhalt();
            head1 = head1.holeNachbarKnoten();
            return (altesElement);
        }
        else
        {
            return null;
        }
    }

    public void enqueue(T neuesElement) // übergebenes Element kommt in die Schlange
    {
        if(neuesElement != null)
        {
            Knoten neu = new Knoten<T>(neuesElement);
            if (isEmpty())
            {
                head1 = neu; //1. Element: auch kopf muss auf den neuen Knoten zeigen
            }
            else
            {
                tail1.setzeNaechsten(neu); //sonst: Vorgänger muss auf neu zeigen
            }
            tail1 = neu; //tail muss immer auf den letzten Knoten zeigen
        }
    }

}
