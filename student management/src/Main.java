import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String sapId;
    String name;
    String course;

    Student(String sapId, String name, String course) {
        this.sapId = sapId;
        this.name = name;
        this.course = course;
    }

    public String toString() {
        return "SAP ID: " + sapId + ", Name: " + name + ", Course: " + course;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter SAP ID: ");
                    String sapId = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    students.add(new Student(sapId, name, course));
                    System.out.println("✅ Student added successfully!");
                }
                case 2 -> {
                    System.out.println("\n--- Student List ---");
                    if (students.isEmpty()) System.out.println("No students found!");
                    else students.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Enter SAP ID to Remove: ");
                    String sapToRemove = sc.nextLine();
                    boolean removed = students.removeIf(s -> s.sapId.equals(sapToRemove));
                    if (removed) System.out.println("🗑️ Student removed successfully!");
                    else System.out.println("⚠️ Student not found!");
                }
                case 4 -> System.out.println("👋 Exiting program...");
                default -> System.out.println("❌ Invalid choice. Try again!");
            }
        } while (choice != 4);

        sc.close();
    }
}
