
/**
 * Beschreiben Sie hier die Klasse Vokabeltrainer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

public class Vokabeltrainer {
    private static DynArray<Vokabel> vocab = new DynArray<Vokabel>(); // aktuelles Set
    private static DynArray<Vokabel> neu = new DynArray<Vokabel>(); // noch nicht gelernt
    private static DynArray<Vokabel> gelernt = new DynArray<Vokabel>(); // einmal richtig
    private static DynArray<Vokabel> perfekt = new DynArray<Vokabel>(); // zweimal richtig

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        {
            System.out.println("Wilkommen zum Vokabeltrainer!");
            laden();
            clear();
            System.out.println("""
                    Befehle:
                    -10: alle Vokabeln ausgeben
                    -1: Konsole leeren
                    0: Vokabelset ausgeben
                    1: Vokabelset aendern
                    2: Vokabel hinzufuegen
                    3: Vokabel loeschen
                    4: Anzahl der Vokabeln
                    5: Zufaellige Vokabel ausgeben
                    6: Lernen (aktuelles Set)
                    """);

            vocab = neu;
        }

        while (true) {
            String deutsch;
            String fs;
            Vokabel aE;
            int l;

            switch (console.nextInt()) {
                case -10: // alle ausgeben
                    alleAusgeben();
                    break;
                case -1: // konsole leeren
                    clear();
                    break;

                case 0: // ausgeben
                    ausgeben(vocab);
                    break;

                case 1: // vocabelset aendern (z.B. neu -> vocab)
                    System.out.println("Welches Set soll geladen werden?");
                    System.out.println("1: neu");
                    System.out.println("2: gelernt");
                    System.out.println("3: perfekt");
                    int set = console.nextInt();
                    switch (set) {
                        case 1:
                            vocab = neu;
                            break;
                        case 2:
                            vocab = gelernt;
                            break;
                        case 3:
                            vocab = perfekt;
                            break;
                    }
                    break;

                case 2: // hinzufügen
                    System.out.println("Deutsches Wort: ");
                    deutsch = console.next();
                    System.out.println("Fremdsprachen Wort: ");
                    fs = console.next();
                    vocab.append(new Vokabel(deutsch, fs));
                    break;
                case 3: // eins löschen
                    System.out.println("zu loeschende Vokabel: ");
                    String zuLoeV = console.next();
                    l = vocab.getLength();
                    if (zuLoeV.equals("2")) {
                        for (int i = 0; i < l; i++) {
                            vocab.delete(0);
                        }
                        break;
                    }
                    for (int j = 0; j < vocab.getLength(); j++) {
                        aE = vocab.getItem(j);
                        if (aE.getDeutsch().equals(zuLoeV)) {
                            vocab.delete(j);
                        }
                    }
                    break;
                case 4: // Anzahl der Vokabeln
                    System.out.println(vocab.getLength() + " Vokabeln in der Liste");
                    break;
                case 5: // zufällige Vokabel
                    aE = vocab.getItem(ThreadLocalRandom.current().nextInt(0, vocab.getLength() - 1));
                    System.out.println(aE.getDeutsch() + " - " + aE.getFS());
                    break;
                case 6: // lernen
                    while (vocab.getLength() > 0) {
                        int r = ThreadLocalRandom.current().nextInt(0, vocab.getLength());
                        aE = vocab.getItem(r);
                        System.out.println(aE.getFS() + " : ");
                        String antwort = console.nextLine();
                        if (antwort.equals("/exit")) {
                            break;
                        }
                        if (antwort.equalsIgnoreCase(aE.getDeutsch())) {
                            System.out.println("Richtig!");
                            if (vocab == neu) {
                                gelernt.append(aE);
                                neu.delete(r);
                            } else if (vocab == gelernt) {
                                perfekt.append(aE);
                                gelernt.delete(r);
                            } else if (vocab == perfekt) {
                                perfekt.delete(r);
                            }
                        } else {
                            System.out.println("Falsch! Die richtige Antwort ist: " + aE.getDeutsch());
                            continue;
                        }

                    }
                    break;
            }
        }
    }

    public static void ausgeben(DynArray<Vokabel> pVokabelset) {
        Vokabel aE;
        if (pVokabelset.getLength() == 0) {
            System.out.println("Keine Vokabeln in der Liste");
            return;
        }
        for (int i = 0; i < vocab.getLength(); i++) {
            try {
                aE = pVokabelset.getItem(i);
                System.out.println(aE.getDeutsch() + " - " + aE.getFS());
            } catch (Exception e) {
                ;
            }
        }
    }

    public static void alleAusgeben() {
        System.out.println("Neu: ");
        ausgeben(neu);
        System.out.println("\nGelernt: ");
        ausgeben(gelernt);
        System.out.println("\nPerfekt: ");
        ausgeben(perfekt);
    }

    public static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void laden() {
        Scanner fSc;
        try {
            File file = new File("vocab.txt");
            fSc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Kontendatei nicht gefunden");
            return;
        }
        String line;
        String[] lineSplit;
        int i = 0;

        while (fSc.hasNextLine()) {
            line = fSc.nextLine();
            lineSplit = line.split(", ");
            neu.append(new Vokabel(lineSplit[0], lineSplit[1]));
        }
    }
}
