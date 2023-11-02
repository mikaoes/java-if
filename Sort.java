import Tracer.Tracer;
import java.util.concurrent.ThreadLocalRandom;

public class Sort {
    static int[] a = new int[20];
    public static void main(String[] args) {
        for (int i = 0; i < a.length; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(1, 11);
        }

        sort();
        pprint();

        Tracer t = new Tracer(Sort.class, 2, 100, "sort");
    }

    public static void sort() {
        for (int i = 1; i < a.length; i++) {
            int aktuellesElement = a[i];
            int j = i;
            while (j > 0 && aktuellesElement < a[j-1]) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = aktuellesElement;
        }
    }

    public static void pprint() {
        System.out.print("[");
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length-1] + "]");
    }
}
