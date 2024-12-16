package enrollmentSystem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GuiPrototype {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create frame
            JFrame frame = new JFrame("Editable JTable Example with Array");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);

            // Create table model with editable cells
            DefaultTableModel model = new DefaultTableModel(new Object[][]{
                {"John", "Doe", "12345"},
                {"Jane", "Smith", "67890"}
            }, new Object[]{"First Name", "Last Name", "ID"});

            // Create table with the model
            JTable table = new JTable(model);

            // Add table to scroll pane
            JScrollPane scrollPane = new JScrollPane(table);

            // Panel for buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());

            // Add row button with array data
            JButton addButton = new JButton("Add Row with Array");
            addButton.addActionListener(e -> {
                // Define the new row data as an array
                Object[] newRow = {"Alice", "Wonderland", "11223"};
                model.addRow(newRow);
            });
            buttonPanel.add(addButton);

            // Update cell button
            JButton updateButton = new JButton("Update Cell");
            updateButton.addActionListener(e -> {
                if (table.getSelectedRow() != -1) {
                    model.setValueAt("Updated", table.getSelectedRow(), 0); // Update first name of selected row
                }
            });
            buttonPanel.add(updateButton);

            // Remove row button
            JButton removeButton = new JButton("Remove Row");
            removeButton.addActionListener(e -> {
                if (table.getSelectedRow() != -1) {
                    model.removeRow(table.getSelectedRow());
                }
            });
            buttonPanel.add(removeButton);

            // Add components to frame
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
