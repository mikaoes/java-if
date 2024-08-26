
/**
 * Beschreiben Sie hier die Klasse BaumElementInt.
  * Hinweis:
  * Die Klasse der Objekte, die in dem Suchbaum verwaltet werden sollen, muss das 
  * generische Interface ComparableContent implementieren. Dabei muss durch 
  * Überschreiben der drei Vergleichsmethoden: isLess, isEqual und isGreater
  * (s. dazu auch Infos zum Interface) eine eideutige Ordnungsrelation festgelegt
  * sein. 
 * @author (Ihr Name) 
 * @version 1.0 von 2022 mit Ergänzungen von 2024
 */
public class BaumElementInt implements ComparableContent<BaumElementInt>
{
    private Integer intContent;

    /**
     * Konstruktor für Objekte der Klasse BaumElementInt
     */
    public BaumElementInt(Integer i)
    {
        // den Inhaltswert speichern
        intContent = i;
    }

    /**
     * Zugriffsfunktion auf den "eigentlichen" Inhalt des Baumelementes: den Integer-Wert
     */
    public Integer getValue()
    {
        return intContent;
    }
    
    /**
     * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
     * wird, bzgl. der gewuenschten Ordnungsrelation groesser als das Objekt
     * pContent ist, wird true geliefert. Sonst wird false geliefert.
     *
     * @param pContent
     *          das mit dem aufrufenden Objekt zu vergleichende Objekt vom
     *          Typ ContentType
     * @return true, wenn das aufrufende Objekt groesser ist als das Objekt
     *         pContent, sonst false
     */
    public boolean isGreater(BaumElementInt pContent)
    {
        return this.intContent > pContent.getValue();
    }

    /**
     * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
     * wird, bzgl. der gewuenschten Ordnungsrelation gleich gross wie das Objekt
     * pContent ist, wird true geliefert. Sonst wird false geliefert.
     *
     * @param pContent
     *          das mit dem aufrufenden Objekt zu vergleichende Objekt vom
     *          Typ ContentType
     * @return true, wenn das aufrufende Objekt gleich gross ist wie das Objekt
     *         pContent, sonst false
     */
    public boolean isEqual(BaumElementInt pContent)
    {
        return this.intContent == pContent.getValue();
    }

    /**
     * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
     * wird, bzgl. der gewuenschten Ordnungsrelation kleiner als das Objekt
     * pContent ist, wird true geliefert. Sonst wird false geliefert.
     *
     * @param pContent
     *          das mit dem aufrufenden Objekt zu vergleichende Objekt vom
     *          Typ ContentType
     * @return true, wenn das aufrufende Objekt kleiner ist als das Objekt
     *         pContent, sonst false   
     */     
    public boolean isLess(BaumElementInt pContent)
    {
        return this.intContent < pContent.getValue();
    }

}
