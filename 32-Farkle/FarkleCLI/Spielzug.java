import java.util.concurrent.ThreadLocalRandom;
/**
 * Beschreiben Sie hier die Klasse Spielzug.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spielzug
{
    int[] wuerfel;
    int[] alte_wurfel;
    int[] speicher_wurfel;
    public Spielzug(Spieler pSpieler)
    {
        Spieler spieler = pSpieler;
        int punkte = 0;
        int freie_wuerfel = 6;
    }
    
    public void zug_eingeben(String eingabe) {
        if (eingabe.length()<6) {
            alte_wurfel = wuerfel;
        }
        wuerfel = new int[6];
        for (int i=0; i<eingabe.length(); i++) {
            wuerfel[i] = eingabe.charAt(i)-48;
        }
        
        for (int i=0; i<6; i++) {
            System.out.print("[" + wuerfel[i] + "]");
        }
        
    }
    
    public void berechnen() {
        // wuerfelarray differenz
        for (int i=0; i<6; i++) {
            int suchzahl = alte_wuerfel[
        }
    }
}
