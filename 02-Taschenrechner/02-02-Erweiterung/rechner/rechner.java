import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class rechner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Bitte geben Sie eine Rechnung ein:");
            String eingabe = sc.nextLine();
            if (eingabe.equals("exit")) {
                System.out.println("Programm wird beendet...");
                break;
            }
            double ergebnis = handler(eingabe);
            if (ergebnis%1 == 0) {
                System.out.println((int)ergebnis);
            } else {
                System.out.println(ergebnis);
            }
        }
        sc.close();
    }

    private static double handler(String eingabe) {
        rechen_operationen rechen_op = new rechen_operationen();
        String[] split = eingabe.split("(?<=[-+*/√r^])|(?=[-+*/√r^])"); // Split bei allen Operatoren, aber behalte diese im Array

        // Exponential berechnen
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("^")) {
                double basis = Double.parseDouble(split[i-1]);
                double exponent = Double.parseDouble(split[i+1]);
                double ergebnis = rechen_op.potenz(basis, exponent);
                split[i-1] = Double.toString(ergebnis);
                split[i] = "";
                split[i+1] = "";
            }
        }
        // Quadratwurzel berechnen
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("√") || split[i].equals("r")) {
                double radikant = Double.parseDouble(split[i+1]);
                double ergebnis = rechen_op.qwurzel(radikant);
                split[i+1] = "";
                split[i] = Double.toString(ergebnis);
            }
        }

        split = Arrays.stream(split).filter(s -> (s != null && s.length() > 0)).toArray(String[]::new);

        // Auftrennen bei + und - (Punkt vor Strich)
        List<String[]> split2 = new ArrayList<String[]>();
        List<String> temp = new ArrayList<String>();
        for (String i : split) {
            if (i.equals("+") || i.equals("-")) {
                split2.add(temp.toArray(new String[temp.size()]));
                temp.clear();
                split2.add(new String[]{i});
            } else {
                temp.add(i);
            }
        }
        split2.add(temp.toArray(new String[temp.size()]));
        temp.clear();
        
        // Multiplikation und Division berechnen
        ArrayList<String> split3 = new ArrayList<String>(); 
        for (String[] a : split2) {
            if (a.length == 1) {
                split3.add(a[0]);
            } else {
                ArrayList<String> b = new ArrayList<String>(Arrays.asList(a));
                while (b.size() > 1) {
                    if (b.get(1).equals("*")) {
                        double ergebnis = rechen_op.multipliziere(Double.parseDouble(b.get(0)), Double.parseDouble(b.get(2)));
                        b.remove(0);
                        b.remove(0);
                        b.remove(0);
                        b.add(0, Double.toString(ergebnis));
                    } else if (b.get(1).equals("/")) {
                        double ergebnis = rechen_op.dividiere(Double.parseDouble(b.get(0)), Double.parseDouble(b.get(2)));
                        b.remove(0);
                        b.remove(0);
                        b.remove(0);
                        b.add(0, Double.toString(ergebnis));
                    }
                }
                split3.add(b.get(0));
            }
        }
        
        // Addition und Subtraktion berechnen
        while (split3.size() > 1) {
            if (split3.get(1).equals("+")) {
                double ergebnis = rechen_op.summiere(Double.parseDouble(split3.get(0)), Double.parseDouble(split3.get(2)));
                split3.remove(0);
                split3.remove(0);
                split3.remove(0);
                split3.add(0, Double.toString(ergebnis));
            } else if (split3.get(1).equals("-")) {
                double ergebnis = rechen_op.subtrahiere(Double.parseDouble(split3.get(0)), Double.parseDouble(split3.get(2)));
                split3.remove(0);
                split3.remove(0);
                split3.remove(0);
                split3.add(0, Double.toString(ergebnis));
            }
        }

        return Double.parseDouble(split3.get(0));
}
}
