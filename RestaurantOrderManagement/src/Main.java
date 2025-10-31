import java.util.*;

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class Main {
     static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MenuItem[] menu = {
                new MenuItem("Pizza", 250),
                new MenuItem("Burger", 120),
                new MenuItem("Pasta", 180),
                new MenuItem("Sandwich", 100),
                new MenuItem("Cold Drink", 50)
        };

        System.out.println("===== Restaurant Menu =====");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i].name + " - ₹" + menu[i].price);
        }

        // Store order items
        List<String> orderedItems = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();

        int choice = 1; //

        while (choice == 1) {
            System.out.print("\nEnter item number to order: ");
            int itemNo = sc.nextInt();

            if (itemNo < 1 || itemNo > menu.length) {
                System.out.println("Invalid item number. Try again!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            orderedItems.add(menu[itemNo - 1].name);
            quantities.add(qty);

            System.out.println("\nDo you want to add more items?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
        }

        double total = 0;
        System.out.println("\n===== Order Summary =====");
        for (int i = 0; i < orderedItems.size(); i++) {
            String itemName = orderedItems.get(i);
            int qty = quantities.get(i);
            double itemPrice = 0;

            for (MenuItem item : menu) {
                if (item.name.equals(itemName)) {
                    itemPrice = item.price;
                    break;
                }
            }

            double cost = itemPrice * qty;
            System.out.println(itemName + " x " + qty + " = ₹" + cost);
            total += cost;
        }

        double gst = total * 0.05;
        double grandTotal = total + gst;

        System.out.println("\nSubtotal: ₹" + total);
        System.out.println("GST (5%): ₹" + gst);
        System.out.println("Total Amount: ₹" + grandTotal);
        System.out.println("\nThank you! Visit again ");
    }
}
