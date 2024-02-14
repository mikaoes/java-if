
/**
 * Beschreiben Sie hier die Klasse Vokabeltrainer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Vokabeltrainer
{
    private static DynArray<Vokabel> vocab = new DynArray<Vokabel>();

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        {
            System.out.println("Wilkommen zum Vokabeltrainer!");
            laden();
        }

        while (true) {
            String deutsch;
            String fs;
            Vokabel aE;

            switch (console.nextInt()) {
                case 0: // ausgeben
                    ausgeben();
                case 1: // hinzufügen
                    System.out.println("Deutsches Wort: ");
                    deutsch = console.next();
                    System.out.println("Fremdsprachen Wort: ");
                    fs = console.next();
                    vocab.append(new Vokabel(deutsch, fs));
                case 2: // eins löschen
                    System.out.println("zu loeschende Vokabel: ");
                    zuLoeV = console.next();
                    for (int i = 0; i<vocab.getLength(); i++) {
                        aE = vocab.getItem(i);
                        if aE.getDeutsch.equals(zuLoeV) {
                            // unfertig
                        }
                    }
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
