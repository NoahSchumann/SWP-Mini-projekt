import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Erste Zahl: ");
        double a = scanner.nextDouble();

        System.out.print("Operator (+, -, *, /): ");
        String op = scanner.next();

        System.out.print("Zweite Zahl: ");
        double b = scanner.nextDouble();

        System.out.println("Eingabe: " + a + " " + op + " " + b);

        scanner.close();
    }
}
