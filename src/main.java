import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static final int MAX_VERLAUF = 5;
    private static final List<String> verlauf = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Erste Zahl (q zum Beenden): ");
            String eingabe = scanner.next();
            if (eingabe.equalsIgnoreCase("q")) {
                break;
            }
            double a = Double.parseDouble(eingabe);

            System.out.print("Operator (+, -, *, /): ");
            String op = scanner.next();

            System.out.print("Zweite Zahl: ");
            double b = scanner.nextDouble();

            if (op.equals("/") && b == 0) {
                System.out.println("Division durch 0 nicht moeglich.");
                continue;
            }

            Double ergebnis = berechne(a, op, b);
            if (ergebnis == null) {
                System.out.println("Unbekannter Operator: " + op);
                continue;
            }

            String rechnung = a + " " + op + " " + b + " = " + ergebnis;
            System.out.println("Ergebnis: " + rechnung);
            speichereInVerlauf(rechnung);
            zeigeVerlauf();
        }

        scanner.close();
    }

    private static Double berechne(double a, String op, double b) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return null;
        }
    }

    private static void speichereInVerlauf(String rechnung) {
        verlauf.add(rechnung);
        if (verlauf.size() > MAX_VERLAUF) {
            verlauf.remove(0);
        }
    }

    private static void zeigeVerlauf() {
        System.out.println("--- Letzte " + MAX_VERLAUF + " Berechnungen ---");
        for (int i = verlauf.size() - 1; i >= 0; i--) {
            System.out.println(verlauf.get(i));
        }
        System.out.println();
    }
}
