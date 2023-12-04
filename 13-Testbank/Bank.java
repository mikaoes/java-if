import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Bank
{
    static Kunde[] kunden = new Kunde[100];
    static Konto[] konten = new Konto[1000];
    static Konto ckont;
    static String path = "";
    static String admin_passwort;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String eingabe;
        Kunde kunde = null;
        boolean admin = false;
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
        
        kundenErzeugen();
        kontenErzeugen();

        clear();

        while (true) {
            pprint("");
            eingabe = sc.nextLine();

            if (eingabe.equals("exit")) {
                break;
            }
            /* ADMIN LOGIN */
            if (eingabe.equals("admin")) {
                Boolean erfolg = false;
                while (!erfolg) {
                    chPathAndPrint("admin-login");
                    eingabe = sc.nextLine();
                    if (eingabe.equals("exit")) {
                        path = "";
                        break;
                    }
                    if (eingabe.equals(admin_passwort)) {
                        admin = true;
                        erfolg = true;
                        path = "admin";
                        break;
                    }
                }
            }
            /* KUNDEN LOGIN */
            if (eingabe.equals("login")) {
                Boolean erfolg = false;
                while (!erfolg) {
                    path = "login";
                    System.out.print("login>> Geben sie ihre Kundennummer ein: ");
                    eingabe = sc.nextLine();
                    if (eingabe.equals("exit")) {
                        break;
                    }

                    for (int i = 0; i < 100; i++) {
                        if (kunden[i] != null) {
                            if (kunden[i].getKundenNr() == Integer.parseInt(eingabe)) {
                                System.out.print("login>> Geben sie ihr Passwort ein: ");
                                eingabe = sc.nextLine();
                                if (kunden[i].login(eingabe)) {
                                    kunde = kunden[i];
                                    erfolg = true;
                                    path = "nutzer/" + String.format("%04d", kunde.getKundenNr());
                                    break;
                                } else {
                                    System.out.println("Passwort falsch");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Kunde nicht gefunden");
                            break;
                        }
                    }
                }
            }

            if (eingabe.equals("logout") && kunde != null) {
                kunde = null;
                path = "";
                ckont = null;
                System.out.println("Logout erfolgreich");
            }

            if (eingabe.equals("logout") && admin == true) {
                path = "";
                kunde = null;
                ckont = null;
                admin = false;
            }

            /* KUNDEN METHODEN */
            if (eingabe.equals("konto") && kunde != null) {
                int[] kunden_konten = kunde.getKonten();
                for (int i = 0; i < kunden_konten.length; i++) {
                    if (kunden_konten[i] > 0 && konten[i] != null) {
                        System.out.println("Konto " + (i+1) + ": " + konten[kunden_konten[i]-1].getKontoNr());
                    }
                }
                pprint("Welches Konto wollen sie öffen? : ");
                ckont = konten[kunden_konten[sc.nextInt()-1]-1];
                path = path + "/" + ckont.getKontoNr();
            }
            if (eingabe.equals("kontostand") && kunde != null && ckont != null) {
                boolean erfolg = false;
                while(!erfolg) {
                    pprint("PIN: ");
                    String pincode = sc.nextLine();
                    long ret = ckont.getKontoStand(pincode);
                    if (ret == -1) {
                        pprint("Falscher PIN!");
                        continue;
                    } else {
                        pprint("Kontostand: " + ret);
                        erfolg = true;
                    }
                }
            }
            if (eingabe.equals("einzahlen") && kunde != null && ckont != null) {
                pprint("Betrag: ");
                long bet = sc.nextLong();
                if (bet <= 0) {
                    System.out.println("Fehler: Betrag muss positiv sein!");
                }

                System.out.println("PIN: ");
                String pincode = sc.next();

                if (ckont.kontostandAendern(pincode, bet)) {
                    System.out.println("erfolgreich");
                } else {
                    System.out.println("unbekannter Fehler");
                }
            }
            if (eingabe.equals("auszahlen") && kunde != null && ckont != null) {
                pprint("Betrag: ");
                long bet = sc.nextLong();
                if (bet <= 0) {
                    System.out.println("Fehler: Auszahlungsbetrag muss positiv sein!");
                }

                System.out.println("PIN: ");
                String pincode = sc.next();

                bet = 0 - bet;
                if (ckont.kontostandAendern(pincode, bet)) {
                    System.out.println("erfolgreich");
                } else {
                    System.out.println("unbekannter Fehler");
                }
            }
            if (eingabe.equals("ueberweisen") && kunde != null && ckont != null) {
                pprint("Empfänger: ");
                int empfaenger = sc.nextInt();
                pprint("Betrag: ");
                long bet = sc.nextLong();

                pprint("PIN: ");
                String pincode = sc.next();

                if (ckont.ueberweisen(konten, empfaenger, bet, pincode)) {
                    System.out.println("erfolgreich");
                } else {
                    System.out.println("unbekannter Fehler");
                }

            }
            if (eingabe.equals("clear")) {
               clear();
            }
        }
        sc.close();
    }

    private static void kundenErzeugen() {
        Scanner sc;
        try {
            File file = new File("kunden.txt");
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Kundendatei nicht gefunden");
            return;
        }
        String line;
        String[] lineSplit;
        int i = 0;

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            lineSplit = line.split(";");
            // Parameter: KundenNr, Passwort, Vorname, Nachname, Geburtsdatum
            int[] kunden_konten = new int[10];
            String[] kontenSplit = lineSplit[5].split(",");
            for (int j = 0; j < kontenSplit.length; j++) {
                if (kontenSplit[j].equals("")) {
                    break;
                }
                kunden_konten[j] = Integer.parseInt(kontenSplit[j])+1;
                System.out.println("Added konto: " + kunden_konten[j]);
            }
            kunden[i] = new Kunde(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], kunden_konten);
            i++;
        }
        sc.close();
    }

    private static void kontenErzeugen() {
        Scanner sc;
        try {
            File file = new File("konten.txt");
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Kontendatei nicht gefunden");
            return;
        }
        String line;
        String[] lineSplit;
        int i = 0;

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            lineSplit = line.split(";");
            // Parameter: kontoNr, name, kontoStand, typ, pin
            konten[i] = new Konto(Integer.parseInt(lineSplit[0]), lineSplit[1], Long.parseLong(lineSplit[2]), lineSplit[3].charAt(0), lineSplit[4]);
            i++;
        }
    }

    private static void chPathAndPrint(String pPath) {
        path = pPath;
        System.out.print(path + ">> ");
    }
    private static void pprint(String pString) {
        System.out.println(path + ">> " + pString);
    }

    private static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
       }
    }
}