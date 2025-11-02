import java.util.*;

class ExpressionCalculator {

    public static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static double applyOp(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public static double evaluate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ')
                continue;

            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--;
                values.push(Double.parseDouble(sb.toString()));
            }

            else if (ch == '(') {
                ops.push(ch);
            }

            else if (ch == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    double val2 = values.pop();
                    double val1 = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(val1, val2, op));
                }
                ops.pop();
            }

            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
                    double val2 = values.pop();
                    double val1 = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(val1, val2, op));
                }
                ops.push(ch);
            }
        }

        while (!ops.isEmpty()) {
            double val2 = values.pop();
            double val1 = values.pop();
            char op = ops.pop();
            values.push(applyOp(val1, val2, op));
        }

        return values.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("  ADVANCED EXPRESSION CALCULATOR");
        System.out.println("========================================");

        while (true) {
            System.out.print("\n Enter a mathematical expression (or type '#' to quit): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("#")) {
                System.out.println(" Goodbye! Thanks for using the calculator.");
                break;
            }

            try {
                double result = evaluate(input);
                System.out.println(" Result = " + result);
            } catch (Exception e) {
                System.out.println("Invalid expression! Please try again.");
            }
        }

        sc.close();
    }
}
