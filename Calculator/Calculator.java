import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return Double.NaN;
        }
        return a / b;
    }

    public static double square(double a) {
        return a * a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

loop:
        do {
            System.out.println("\nWelcome to My Calculator Console Application");
            System.out.println("Please select which operator you want to use:");
            System.out.println(" 1. Addition (+)");
            System.out.println(" 2. Subtraction (-)");
            System.out.println(" 3. Multiplication (*)");
            System.out.println(" 4. Division (/)");
            System.out.println(" 5. Square (^)");
            System.out.println(" 6. All Operators (all)");
            System.out.println(" 7. Exit");


           String operator = sc.nextLine().toLowerCase();
            System.out.println();

            if (operator.equals("7") || operator.equals("exit")) {
                System.out.println("Thank you for using My Console Calculator!");
                break loop;
            }

            System.out.print("Great!  Please Enter the first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Final Step!!  Enter the second number (ignored for square): ");
            double num2 = sc.nextDouble();
            sc.nextLine();;


            double result = 0;

            switch (operator) {
                case "+":
                case "1":
                case "addition":
                    result = add(num1, num2);
                    System.out.println("Result: " + result);
                    break;

                case "-":
                case "2":
                case "subtraction":
                    result = subtract(num1, num2);
                    System.out.println("Result: " + result);
                    break;

                case "*":
                case "3":
                case "multiplication":
                    result = multiplication(num1, num2);
                    System.out.println("Result: " + result);
                    break;

                case "/":
                case "4":
                case "division":
                    result = divide(num1, num2);
                    System.out.println("Result: " + result);
                    break;

                case "^":
                case "5":
                case "square":
                    result = square(num1);
                    System.out.println("Result: " + result);
                    break;

                case "6":
                case "all":
                case "all operators":
                    System.out.println("Addition: " + add(num1, num2));
                    System.out.println("Subtraction: " + subtract(num1, num2));
                    System.out.println("Multiplication: " + multiplication(num1, num2));
                    System.out.println("Division: " + divide(num1, num2));
                    System.out.println("Square: " + square(num1));
                    break;

                default:
                    System.out.println("Invalid operator! Please try again.");
            }

        } while (true);


    }
}
