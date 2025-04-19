import java.time.LocalDate;

public class Habit {
    private String name;
    private int streak;
    private LocalDate lastCompletedDate;

    public Habit(String name) {
        this.name = name;
        this.streak = 0;  // Initially, the streak is 0
        this.lastCompletedDate = null;  // Initially, there’s no completion date
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getStreak() {
        return streak;
    }

    public LocalDate getLastCompletedDate() {
        return lastCompletedDate;
    }

    // Mark the habit as done
    public void markAsDone() {
        streak++;  // Increment the streak
        lastCompletedDate = LocalDate.now();  // Update the last completed date to today
    }

    @Override
    public String toString() {
        // Display the habit with its streak and last completed date
        return name + " - Streak: " + streak + " day(s)" + (lastCompletedDate != null ? " | Last completed: " + lastCompletedDate : "");
    }
}
