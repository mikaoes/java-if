package mindestanforderung;


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

public class Vokabeltrainer
{
    private static DynArray<Vokabel> vocab = new DynArray<Vokabel>();

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        {
            System.out.println("Wilkommen zum Vokabeltrainer!");
            laden();
            clear();
        }

        while (true) {
            String deutsch;
            String fs;
            Vokabel aE;

            switch (console.nextInt()) {
                case -1:
                    clear();
                    break;
                case 0: // ausgeben
                    ausgeben();
                    break;
                case 1: // hinzufügen
                    System.out.println("Deutsches Wort: ");
                    deutsch = console.next();
                    System.out.println("Fremdsprachen Wort: ");
                    fs = console.next();
                    vocab.append(new Vokabel(deutsch, fs));
                    break;
                case 2: // eins löschen
                    System.out.println("zu loeschende Vokabel: ");
                    String zuLoeV = console.next();
                    int l = vocab.getLength();
                    if (zuLoeV.equals("2")) {
                        for (int i = 0; i<l; i++) {
                            vocab.delete(0);
                        }
                        break;
                    }
                    for (int j = 0; j<vocab.getLength(); j++) {
                        aE = vocab.getItem(j);
                        if (aE.getDeutsch().equals(zuLoeV)) {
                            vocab.delete(j);
                        }
                    }
                    break;
                case 3:
                    System.out.println(vocab.getLength() + " Vokabeln in der Liste");
                    break;
                case 4:
                    aE = vocab.getItem(ThreadLocalRandom.current().nextInt(0, vocab.getLength()-1));
                    System.out.println(aE.getDeutsch() + " - " + aE.getFS());
                    break;
            }
        }
    }

    public static void ausgeben() {
        Vokabel aE;
        for (int i=0; i < vocab.getLength(); i++) {
            aE = vocab.getItem(i);
            System.out.println(aE.getDeutsch() + " - " + aE.getFS());
        }
    }

    public static void clear() {
        for (int i =0; i<100; i++) {
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
            vocab.append(new Vokabel(lineSplit[0], lineSplit[1]));
        }
    }
}
