public class Kunde
{
    private int kundenNr;
    private String passwort;

    private String vorname;
    private String nachname;
    private String geburtsD;

    private int[] konten = new int[10];

    public Kunde(int pKundenNr, String pPasswort, String pVorname, String pNachname, String pGeburtsD, int[] pKonten) {
        kundenNr = pKundenNr;
        passwort = pPasswort;
        vorname = pVorname;
        nachname = pNachname;
        geburtsD = pGeburtsD;
        konten = pKonten;
    }

    public int getKundenNr() {
        return kundenNr;
    }

    public int[] getKonten() {
        return konten;
    }

    public Boolean login(String pPasswort) {
        if (passwort.equals(pPasswort)) {
            return true;
        } else {
            return false;
        }
    }
}
