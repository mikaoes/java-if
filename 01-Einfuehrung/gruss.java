
/**
 * Beschreiben Sie hier die Klasse gruss.
 * 
 * @author github@mikaoes
 * @version 21.08.2023
 */
public class gruss
{
    public gruss() {
        System.out.println("Guten Tag!");
    }
    public void grundAufgabe(String name, char tageszeit)
    {
        if (tageszeit == 'm') {
            System.out.println("Guten Morgen, " + name + "!");
        } else if (tageszeit == 'a') {
            System.out.println("Guten Tag, " + name + "!");
        }
    }
}
