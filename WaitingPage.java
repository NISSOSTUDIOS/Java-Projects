import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaitingPage extends JFrame {
    private JLabel titleLabel;
    private JTable waitingTable;
    private JButton cancelButton;

    public WaitingPage() {
        // Set up the main frame
        setTitle("Restaurant Management System - Waiting Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create and add components
        titleLabel = new JLabel("Waiting List");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Create table model and add columns
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("NAME");
        tableModel.addColumn("FOOD ORDERED");
        tableModel.addColumn("TIME");
        tableModel.addColumn("STATUS");

        // Add sample data to the table
        tableModel.addRow(new Object[]{"John Doe", "Steak", "18:30", true});
        tableModel.addRow(new Object[]{"Jane Smith", "Pasta", "18:45", false});

        // Create the table using the table model
        waitingTable = new JTable(tableModel) {
            // Override to make the "STATUS" column render as checkboxes
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 3 ? Boolean.class : Object.class;
            }
        };

        JScrollPane scrollPane = new JScrollPane(waitingTable);
        add(scrollPane, BorderLayout.CENTER);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle cancel button action (e.g., close the waiting page)
                dispose(); // Close the waiting page
            }
        });
        add(cancelButton, BorderLayout.SOUTH);

        // Set up the visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        // Example usage
        SwingUtilities.invokeLater(() -> {
            new WaitingPage();
        });
    }
}
