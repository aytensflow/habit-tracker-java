import java.awt.*;
import javax.swing.*;

public class HabitTrackerGUI {
    private HabitManager habitManager;

    public HabitTrackerGUI() {
        habitManager = new HabitManager();

        // Create main window
        JFrame frame = new JFrame("🧠 Habit Tracker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 🌸 Make it pink!
        Color softPink = new Color(255, 182, 193);         // light pink
        Color blush = new Color(255, 240, 245);            // lavender blush
        Color buttonPink = new Color(255, 105, 180);       // hot pink

        frame.getContentPane().setBackground(softPink);

        // Area to show habits
        JTextArea habitDisplay = new JTextArea();
        habitDisplay.setEditable(false);
        habitDisplay.setBackground(blush);
        habitDisplay.setForeground(Color.DARK_GRAY);
        frame.add(new JScrollPane(habitDisplay), BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(softPink);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton addButton = new JButton("➕ Add Habit");
        JButton doneButton = new JButton("✅ Mark Done");
        JButton viewButton = new JButton("👀 View Habits");
        JButton removeButton = new JButton("❌ Remove");

        // Style the buttons
        JButton[] buttons = { addButton, doneButton, viewButton, removeButton };
        for (JButton btn : buttons) {
            btn.setBackground(buttonPink);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new Font("SansSerif", Font.BOLD, 12));
            buttonPanel.add(btn);
        }

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button actions

        // ➕ Add Habit
        addButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter habit name:");
            if (name != null && !name.trim().isEmpty()) {
                habitManager.addHabit(name.trim());
            }
        });

        // ✅ Mark as Done
        doneButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter habit to mark as done:");
            if (name != null && !name.trim().isEmpty()) {
                habitManager.markHabitAsDone(name.trim());
            }
        });

        // 👀 View Habits
        viewButton.addActionListener(e -> {
            habitDisplay.setText(""); // Clear the display
            for (Habit h : habitManager.getHabits()) {
                habitDisplay.append("📌 " + h.toString() + "\n");
            }
        });

        // ❌ Remove Habit
        removeButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter habit to remove:");
            if (name != null && !name.trim().isEmpty()) {
                habitManager.removeHabit(name.trim());
            }
        });

        // Show window
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI
        SwingUtilities.invokeLater(() -> new HabitTrackerGUI());
    }
}
