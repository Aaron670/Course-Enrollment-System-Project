package enrollmentSystem;
import javax.swing.*;
import java.awt.*;

public class CardLayoutExampleWithScrollbar {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example with Scrollbar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Left panel with a logout button
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JButton logoutButton = new JButton("Logout");
        leftPanel.add(logoutButton);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Card panel on the right
        JPanel cardPanel = new JPanel(new CardLayout());
        JPanel studentCanvas = new JPanel(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        String[] columnNames = { "ID", "First Name", "Last Name", "Contact Number", "Date", "Course "};
        String[][] data = {
                {"1", "John", "Doe", "123-456-7890", "2025-01-10", "Computer Science"},
                {"2", "Jane", "Smith", "234-567-8901", "2025-01-11", "Biology"},
                {"3", "Michael", "Johnson", "345-678-9012", "2025-01-12", "Mathematics"},
                {"4", "Emily", "Davis", "456-789-0123", "2025-01-13", "Physics"},
                {"5", "David", "Wilson", "567-890-1234", "2025-01-14", "Chemistry"},
                {"6", "Sarah", "Martinez", "678-901-2345", "2025-01-15", "Literature"},
                {"7", "Robert", "Taylor", "789-012-3456", "2025-01-16", "Engineering"},
                {"8", "Laura", "Anderson", "890-123-4567", "2025-01-17", "Medicine"},
                {"9", "James", "Thomas", "901-234-5678", "2025-01-18", "History"},
                {"1120", "Linda", "Moore", "012-345-6789", "2025-01-19", "Art"}
        };

        // Add column headers with borders
        gbc.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < columnNames.length; i++) {
            gbc.gridx = i;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 0.1;
            JLabel label = new JLabel(columnNames[i], JLabel.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add line border
            panel.add(label, gbc);
        }

        // Add data rows with borders
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                gbc.gridx = col;
                gbc.gridy = row + 1;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                JLabel label = new JLabel(data[row][col], JLabel.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add line border
                panel.add(label, gbc);
            }
        }

        // Wrap the panel with a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(panel);
        studentCanvas.add(scrollPane, BorderLayout.NORTH);
        studentCanvas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cardPanel.add(studentCanvas, "Student Data");

        // Add left panel and card panel to the main panel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(cardPanel, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); // Add space between the left and right panels

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
