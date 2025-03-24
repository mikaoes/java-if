
/**
 * Beschreiben Sie hier die Klasse kartenspiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class kartenspiel
{
    

    /**
     * Konstruktor für Objekte der Klasse kartenspiel
     */
    public kartenspiel()
    {
       //
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int anzahlDerTerminale (String pKartenfolge)
    {
        int anzTermi = 0;
        String kartenfolge = pKartenfolge;
        int l = kartenfolge.length();
        for (int i = 1; i <= l; i= i + 2)
        {
            anzTermi = anzTermi + 1;  
        }// tragen Sie hier den Code ein
        return anzTermi;
    }

    public String terminalAn (String pKartenfolge, int pPosition)
    {
        String termi = "";
        String kartenfolge = pKartenfolge;
        int pos = pPosition;
        int hPos = 0;
        int l = kartenfolge.length();
        int j = 2*(pos+1)-2;
        if (l == 0)
        {
            return "";
        }
        else
        {
            for (int i = 0; i <= j; i++) 
            {
                hPos = i;
            }
            termi = termi + kartenfolge.charAt(hPos) + kartenfolge.charAt(hPos + 1);

            return termi;
        }
    }
    
    public boolean pruefe (String pKartenfolge) {
        int max = (pKartenfolge.length()/2)-1;
        int pos = 0;
        
        switch (terminalAn(pKartenfolge, pos)) {
            case "H8":
                return zstA(pos+1, pKartenfolge, max);
            case "H7":
                return zstB(pos+1, pKartenfolge, max);
            case "K7":
                return zstC(pos+1, pKartenfolge, max);
            default:
                return false;
            }
    }
    
    public boolean zstA(int pos, String pKartenfolge, int max) {
        if (pos >= max) { return true; }
        switch (terminalAn(pKartenfolge, pos)) {
            case "H8":
                return zstA(pos+1, pKartenfolge, max);
            case "H7":
                return zstB(pos+1, pKartenfolge, max);
            default:
                return false;
            }
        }
    public boolean zstB(int pos, String pKartenfolge, int max) {
        if (pos >= max) { return true; }
        switch (terminalAn(pKartenfolge, pos)) {
            case "H8":
                return zstA(pos+1, pKartenfolge, max);
            case "H7":
                return zstB(pos+1, pKartenfolge, max);
            case "K7":
                return zstC(pos+1, pKartenfolge, max);
            default:
                return false;
            }
        }
    public boolean zstC(int pos, String pKartenfolge, int max) {
        if (pos >= max) { return true; }
        switch (terminalAn(pKartenfolge, pos)) {
            case "H7":
                return zstB(pos+1, pKartenfolge, max);
            case "K7":
                return zstC(pos+1, pKartenfolge, max);
            default:
                return false;
            }
        }
    }

