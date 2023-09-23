import java.util.concurrent.ThreadLocalRandom;

public class DemoTabelle
{
    public int[][] t = new int[4][5];

    public void fuelle() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                t[i][j] = ThreadLocalRandom.current().nextInt(0, 101);
            }
        }
    }
    
    public void ausgabe() {

        for (int i = 0; i < t.length; i++) {
            System.out.print("[");
            for (int j = 0; j < t[i].length-1; j++) {
                System.out.print(t[i][j] + ", ");
            }
            System.out.println(t[i][t[i].length-1] + "]");
        }
    }
    
    public int summe(int index) {
        int summe = 0;
        for (int i = 0; i < t[index].length; i++) {
            summe += t[index][i];
        }
        return summe;
    }
    
    public int min () {
        int min = 100;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 4; j++) {
                if (t[i][j] < min) {
                    min = t[i][j];
                }
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        DemoTabelle tab = new DemoTabelle();
        
        tab.fuelle();
        tab.ausgabe();
        System.out.println("Summe Zeile 1: " + tab.summe(0));
        System.out.println("Minimum: " + tab.min());
    }
}
