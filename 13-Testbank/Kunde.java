public class Kunde
{
    private int kundenNr;
    private String passwort;

    private String vorname;
    private String nachname;
    private String geburtsD;

    private Konto[] konten = new Konto[10];

    public Kunde(int pKundenNr, String pPasswort, String pVorname, String pNachname, String pGeburtsD) {
        kundenNr = pKundenNr;
        passwort = pPasswort;
        vorname = pVorname;
        nachname = pNachname;
        geburtsD = pGeburtsD;
        
    }

    public int getKundenNr() {
        return kundenNr;
    }

    public Boolean login(String pPasswort) {
        if (passwort.equals(pPasswort)) {
            return true;
        } else {
            return false;
        }
    }
}
