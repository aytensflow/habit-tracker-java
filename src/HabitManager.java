import java.util.ArrayList;

public class HabitManager {
    private ArrayList<Habit> habits;

    public HabitManager() {
        habits = new ArrayList<>();
    }

    // Add a new habit
    public void addHabit(String habitName) {
        Habit newHabit = new Habit(habitName);
        habits.add(newHabit);
        System.out.println("Habit added: " + habitName);
    }

    // Mark a habit as done
    public void markHabitAsDone(String habitName) {
        for (Habit habit : habits) {
            if (habit.getName().equalsIgnoreCase(habitName)) {
                habit.markAsDone();
                System.out.println("Marked " + habitName + " as done!");
                return;
            }
        }
        System.out.println("Habit not found: " + habitName);
    }

    // Print all habits (used in console version)
    public void printHabits() {
        for (Habit habit : habits) {
            System.out.println(habit);
        }
    }

    // Remove a habit by name
    public void removeHabit(String habitName) {
        for (int i = 0; i < habits.size(); i++) {
            if (habits.get(i).getName().equalsIgnoreCase(habitName)) {
                habits.remove(i);
                System.out.println("Habit removed: " + habitName);
                return;
            }
        }
        System.out.println("Habit not found: " + habitName);
    }

    // Getter to use in GUI
    public ArrayList<Habit> getHabits() {
        return habits;
    }
}
