
import java.util.Scanner;

public class Console_Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//scanner function used to take the user input from the console
        boolean running = true;

        System.out.println("=== Advanced Java Calculator ===");

        while (running) {
            try {
                System.out.print("\nEnter starting number: ");
                double total = sc.nextDouble();

                while (true) {
                    System.out.print("Enter operator (+, -, *, /) or '=' to get result: ");
                    String operator = sc.next();

                    if (operator.equals("=")) {
                        break;
                    }

                    System.out.print("Enter next number: ");
                    double nextNum = sc.nextDouble();

                    double previousTotal = total;// it stores the total after every operation

                    if (operator.equals("+")) {
                        total = addition(total, nextNum);
                    } else if (operator.equals("-")) {
                        total = subtraction(total, nextNum);
                    } else if (operator.equals("*")) {
                        total = multiplication(total, nextNum);
                    } else if (operator.equals("/")) {
                        if (nextNum == 0) {
                            System.out.println("Error: Cannot divide by zero!"); // 
                            continue;
                        } else {
                            total = division(total, nextNum);
                        }
                    } else {
                        System.out.println("Invalid operator!");
                        continue;
                    }

                    System.out.printf("Calculation: %.2f %s %.2f = %.2f\n", previousTotal, operator, nextNum, total);
                    System.out.println("Current Total: " + total);
                }

                System.out.println("\nFinal Result of the Calculation: " + total);

                System.out.print("\nDo you want to start a new calculation? (yes/no): "); // 
                String choice = sc.next().toLowerCase();
                if (choice.equals("no") || choice.equals("n")) {
                    running = false;
                }

            } catch (Exception e) {
                System.out.println("Error: Please enter valid numbers.");
                sc.next();
            }
        }

        System.out.println("Thank you for using the calculator...!");
        sc.close();
    }

    // Modular methods for arithmetic operations..
    public static double addition(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        return a / b;
    }
}
