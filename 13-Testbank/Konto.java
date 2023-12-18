import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Konto
{
    private int kontoNr;
    private String name;

    private long kontoStand;
    private char typ;

    private String pin;

    private String admin_passwort;

    public Konto(int pKontoNr, String pName, long pKontoStand, char pTyp, String pPin) {
        kontoNr = pKontoNr;
        name = pName;
        kontoStand = pKontoStand;
        typ = pTyp;
        pin = pPin;

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

    public int getKontoNr() {
        return kontoNr;
    }

    public String getName() {
        return name;
    }

    public long getKontoStand() {
        return kontoStand;
    }

    public char getTyp() {
        return typ;
    }

    public String getPin(String pPasswort) {
        if (admin_passwort.equals(pPasswort)) {
            return pin;
        } else {
            return "Falsches Passwort";
        }
    }

    public boolean empfangen(long betrag) {
        if (betrag > 0) {
            kontoStand += betrag;
            return true;
        } else {
            return false;
        }
    }

    public long getKontoStand(String pPin) {
        if (pin.equals(pPin)) {
            return kontoStand;
        } else {
            return -1;
        }
    }
    public boolean kontostandAendern(String pPin, long betrag) {
        if (pin.equals(pPin)) {
            if (kontoStand >= betrag) {
                kontoStand += betrag;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public boolean ueberweisen(Konto[] kListe, int empf, long betrag, String pPin) {
        if (betrag > kontoStand) {
            return false;
        }
        Konto con = null;
        
        for (int i = 0; i < 1000; i++) {
            if (kListe[i].getKontoNr() == empf) {
                con = kListe[i];
                break;
            }
        }
        if (con.empfangen(betrag)) {
            kontoStand -= betrag;
            return true;
        } else {
            return false;
        }
    }
}
