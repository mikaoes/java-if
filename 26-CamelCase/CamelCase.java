import java.util.Scanner;

public class CamelCase {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("String eingeben oder 'exit' zum abbrechen.");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            for (int i = 97; i < 123; i++) {
                char c = (char) i;
                String such = " " + String.valueOf(c);
                String ers = String.valueOf((char)(c - 32));

                input = input.replace(such, ers);
            }

            System.out.println("Converted string: " + input);
        }

        sc.close();
    }
}