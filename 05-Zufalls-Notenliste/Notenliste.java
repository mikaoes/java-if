import java.util.concurrent.ThreadLocalRandom;
/**
 * Beschreiben Sie hier die Klasse Notenliste.
 * 
 * @author (Ihr Name) 
 * @version 11.9.
 */
public class Notenliste
{
    public static void main(String[] args) {
        int size = 20;
        int[] nListe = new int[size];
        
        for (int i = 0; i < size; i++) {
            nListe[i] = ThreadLocalRandom.current().nextInt(0, 16);
        }
        
        ausgabe(nListe);
        
        System.out.println("Durchschnitt " + durchschnitt(nListe));
        System.out.println("Maximum: " + maximum(nListe));
    }
    
    public static void ausgabe(int[] input) {
        System.out.print("[");
        for (int i : input) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
    
    public static double durchschnitt(int[] input) {
        double summe = 0;
        for (int i : input) {
            summe += i;
        }
        return summe/input.length;
    }
    
    public static int maximum(int[] input) {
        int maximum = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] > maximum) {
                maximum = input[i];
            }
        }
        return maximum;
    }
}
