
/**
 * Beschreiben Sie hier die Klasse Alrorithmus.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Alrorithmus
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
   private int[] arr = new int[20];

    /**
     * Konstruktor für Objekte der Klasse Alrorithmus
     */
    public Alrorithmus(int pSuch)
    {
        for (int i = 0; i<20; i++) {
            arr[i] = i+1;
        }
        System.out.println(suchen(20, 0, 20));
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int suchen(int such, int von, int bis)
    {
        int mitte = von + (bis-von)/2;
        if (arr[mitte] == such) {
            return mitte;
        } else if (arr[mitte] < such) {
            return suchen(such, mitte+1, bis);
        } else if (arr[mitte] > such) {
            return suchen(such, von, bis-1);
        }
        return -1;
    }
}
