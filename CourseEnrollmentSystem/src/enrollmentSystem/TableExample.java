package enrollmentSystem;
import javax.swing.*;
import java.awt.*;

public class TableExample {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create the main panel with GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(3, 3)); // 3 rows, 3 columns

        // Add labels to the panel
        for (int i = 1; i <= 9; i++) {
            JLabel label = new JLabel("Cell " + i, SwingConstants.CENTER);
            mainPanel.add(label);
        }

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Display the frame
        frame.setVisible(true);
    }
}
