import java.util.InputMismatchException;
import java.util.Scanner;

 class CalculatorSystem {
     static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1, num2, result;
        int choice;

        System.out.println("========================================");
        System.out.println("          SIMPLE JAVA CALCULATOR");
        System.out.println("=======================================");

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1️⃣  Addition (+)");
            System.out.println("2️⃣  Subtraction (-)");
            System.out.println("3️⃣  Multiplication (×)");
            System.out.println("4️⃣  Division (÷)");
            System.out.println("5️⃣  Exit");
            System.out.print(" Enter your choice (1-5): ");

            if (!sc.hasNextInt()) {
                System.out.println("⚠ Please enter a valid number between 1 and 5!");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();

            if (choice == 5) {
                System.out.println(" Thank you for using the calculator!");
                break;
            }

            try {
                System.out.print("Enter first number: ");
                num1 = sc.nextDouble();
                System.out.print("Enter second number: ");
                num2 = sc.nextDouble();

                switch (choice) {
                    case 1:
                        result = num1 + num2;
                        System.out.println(" Result: " + num1 + " + " + num2 + " = " + result);
                        break;

                    case 2:
                        result = num1 - num2;
                        System.out.println(" Result: " + num1 + " - " + num2 + " = " + result);
                        break;

                    case 3:
                        result = num1 * num2;
                        System.out.println(" Result: " + num1 + " × " + num2 + " = " + result);
                        break;

                    case 4:
                        if (num2 == 0) {
                            System.out.println(" Division by zero is not allowed!");
                        } else {
                            result = num1 / num2;
                            System.out.println(" Result: " + num1 + " ÷ " + num2 + " = " + result);
                        }
                        break;

                    default:
                        System.out.println("⚠ Invalid choice. Please select between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠ Invalid input! Please enter numeric values only.");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
