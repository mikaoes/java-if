
/**
 * Beschreiben Sie hier die Klasse Fibonacci.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Fibonacci
{
    public static void main(String[] args) {
        System.out.println((fibonacci(10)));
    }

    public static double fibonacci(double n) {
        if (n <= 1) {
            return n;
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print("#");
            }
            System.out.println();
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
