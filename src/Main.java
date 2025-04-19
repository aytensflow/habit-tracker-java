import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HabitManager manager = new HabitManager();

        System.out.println("Welcome to Habit Tracker!");

        // Loop for user input
        while (true) {
            // Display the menu
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a new habit");
            System.out.println("2. Mark habit as done");
            System.out.println("3. View all habits");
            System.out.println("4. Remove a habit");
            System.out.println("5. Exit");

            // Get user choice
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the habit: ");
                    String habitName = scanner.nextLine();
                    manager.addHabit(habitName);
                    break;
                case 2:
                    System.out.print("Enter the name of the habit to mark as done: ");
                    String doneHabitName = scanner.nextLine();
                    manager.markHabitAsDone(doneHabitName);
                    break;
                case 3:
                    manager.printHabits();
                    break;
                case 4:
                    System.out.print("Enter the name of the habit to remove: ");
                    String removeHabitName = scanner.nextLine();
                    manager.removeHabit(removeHabitName);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
