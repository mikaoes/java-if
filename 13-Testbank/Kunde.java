import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kunde
{
    private int kundenNr;
    private String passwort;

    private String vorname;
    private String nachname;
    private String geburtsD;

    private int[] konten = new int[10];

    private String admin_passwort;

    public Kunde(int pKundenNr, String pPasswort, String pVorname, String pNachname, String pGeburtsD, int[] pKonten) {
        kundenNr = pKundenNr;
        passwort = pPasswort;
        vorname = pVorname;
        nachname = pNachname;
        geburtsD = pGeburtsD;
        konten = pKonten;

        try {
            File admin_file = new File("admin_passwort.txt");
            Scanner sc_admin = new Scanner(admin_file);
            admin_passwort = sc_admin.nextLine();
            sc_admin.close();
        } catch (FileNotFoundException e) {
            System.out.println("Admin-Passwort Speicher nicht gefunden");
            admin_passwort = "admin";
            return;
        }
    }

    public int getKundenNr() {
        return kundenNr;
    }

    public int[] getKonten() {
        return konten;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getGeburtsdatum() {
        return geburtsD;
    }

    public String getPasswort(String pPasswort) {
        if (admin_passwort.equals(pPasswort)) {
            return passwort;
        } else {
            return null;
        }
    }

    public Boolean login(String pPasswort) {
        if (passwort.equals(pPasswort)) {
            return true;
        } else {
            return false;
        }
    }
}
