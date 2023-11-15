import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Bank
{
    static Kunde[] kunden = new Kunde[100];
    static String path = "";
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String eingabe;
        Kunde kunde = null;

        kundenErzeugen();

        while (true) {
            pprint("");
            eingabe = sc.nextLine();

            if (eingabe.equals("exit")) {
                break;
            }
            /* ADMIN BEREICH */
            if (eingabe.equals("admin")) {
                while (true) {
                    chPathAndPrint("admin");
                    eingabe = sc.nextLine();
                    if (eingabe.equals("exit")) {
                        break;
                    }

                    System.out.println("Eingabe: " + eingabe);
                }
            }
            /* KUNDEN BEREICH */
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

            if ((eingabe.equals("exit") || eingabe.equals("logout") && kunde != null)) {
                kunde = null;
                path = "";
                System.out.println("Logout erfolgreich");
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
            kunden[i] = new Kunde(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4]);
            i++;
        }
        sc.close();
    }

    private static void chPathAndPrint(String pPath) {
        path = pPath;
        System.out.println(path + ">> ");
    }
    private static void pprint(String pString) {
        System.out.print(path + ">> " + pString);
    }
}