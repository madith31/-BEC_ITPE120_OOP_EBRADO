import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyPeripherals extends JFrame {
    private ArrayList<String> dataList;
    private ArrayList<String> employeeList;
    private ArrayList<String> statusList;
    private int peripheralSerial = 1;
    private int employeeSerial = 1;

    private DefaultTableModel tableModel;
    private JTable dataTable;
    private int selectedRow = -1;

    public MyPeripherals() {
        dataList = new ArrayList<>();
        employeeList = new ArrayList<>();
        statusList = new ArrayList<>();

        // Create GUI components
       
        
        JButton addButton = new JButton("Add Data");
        JButton removeButton = new JButton("Remove Data");
        JButton editButton = new JButton("Edit Data");
        JButton searchButton = new JButton("Search Data");
        JButton viewPeripheralsButton = new JButton("View All Peripherals");
        JButton viewAllStatusButton = new JButton("View All Status");
        JTextField textField = new JTextField();
        JLabel label = new JLabel("Enter data:");

        // Table setup
        String[] columnNames = {"Serial", "Peripheral (Data Encoded)", "Employee Assigned", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        // Layout
       setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
       
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(viewPeripheralsButton);
        buttonPanel.add(viewAllStatusButton);

        // Y-axis layout for other components
        
        add(buttonPanel); // Adding the panel with buttons
        add(textField);
        add(label);
        add(scrollPane);
              
       

        // Add button action listener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = textField.getText();
                if (!data.isEmpty()) {
                    dataList.add(data);

                    // Get user input for employee name
                    String employeeName = JOptionPane.showInputDialog(null, "Enter the name of the employee:");
                    if (employeeName == null) {
                        // User canceled input
                        return;
                    }

                    // Automatically add a peripheral and assign an employee
                    String peripheral = "2024" + String.format("%05d", peripheralSerial++);
                    employeeList.add(employeeName);
                    statusList.add("Serviceable");

                    // Update the table
                    updateTable();

                    JOptionPane.showMessageDialog(null, "Data '" + data + "' added successfully!\n" +
                            "Peripheral: '" + peripheral + "'\n" +
                            "Employee Assigned: '" + employeeName + "'.");
                    textField.setText(""); // Clear the text field
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter data.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Remove button action listener
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow != -1) {
                    dataList.remove(selectedRow);
                    employeeList.remove(selectedRow);
                    statusList.remove(selectedRow);

                    // Update the table
                    updateTable();

                    JOptionPane.showMessageDialog(null, "Selected data removed successfully!");
                    selectedRow = -1;
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to remove.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Edit button action listener
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow != -1) {
                    // Ask the user what data to edit
                    String[] options = {"Assigned Employee", "Status"};
                    int choice = JOptionPane.showOptionDialog(null, "What data would you like to edit?", "Edit Data",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    if (choice == 0) {
                        // Edit assigned employee
                        String newEmployee = JOptionPane.showInputDialog(null, "Enter the new assigned employee:");
                        if (newEmployee != null) {
                            // Update the assigned employee
                            employeeList.set(selectedRow, newEmployee);

                            // Update the table
                            updateTable();

                            JOptionPane.showMessageDialog(null, "Assigned employee updated successfully!");
                        }
                    } else if (choice == 1) {
                        // Edit status
                        String newStatus = JOptionPane.showInputDialog(null, "Enter the new status (Serviceable or Non-serviceable):");
                        if (newStatus != null) {
                            // Update the status
                            statusList.set(selectedRow, newStatus);

                            // Update the table
                            updateTable();

                            JOptionPane.showMessageDialog(null, "Status updated successfully!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Search button action listener
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchData = textField.getText();
                if (!searchData.isEmpty()) {
                    boolean found = false;
                    for (int i = 0; i < dataList.size(); i++) {
                        if (dataList.get(i).equalsIgnoreCase(searchData) ||
                                employeeList.get(i).equalsIgnoreCase(searchData) ||
                                statusList.get(i).equalsIgnoreCase(searchData) ||
                                ("2024" + String.format("%05d", i + 1)).equalsIgnoreCase(searchData)) {
                            found = true;
                            String resultMessage = "Data found:\n" +
                                    "Peripheral: '" + ("2024" + String.format("%05d", i + 1)) + "'\n" +
                                    "Peripheral (Data Encoded): '" + dataList.get(i) + "'\n" +
                                    "Employee Assigned: '" + employeeList.get(i) + "'\n" +
                                    "Status: '" + statusList.get(i) + "'";
                            JOptionPane.showMessageDialog(null, resultMessage);
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Data '" + searchData + "' not found.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter data to search.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // View All Peripherals button action listener
        viewPeripheralsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the table
                updateTable();
            }
        });

        // View All Status button action listener
        viewAllStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String statusToView = JOptionPane.showInputDialog(null, "Enter the status to view (Serviceable or Non-serviceable):");
                if (statusToView != null) {
                    boolean validStatus = statusToView.equalsIgnoreCase("Serviceable") || statusToView.equalsIgnoreCase("Non-serviceable");
                    if (validStatus) {
                        // Display all peripherals with the specified status
                        displayPeripheralsByStatus(statusToView);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid status entered. Please enter 'Serviceable' or 'Non-serviceable'.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        // Table selection listener
        dataTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                selectedRow = dataTable.getSelectedRow();
            }
        });

        // Frame settings
        setTitle("PERIPHERALS RECORDS");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Set border color and background color
        setBorderColor(Color.green); // You can change the color as per your requirement
        setBackgroundColor(Color.pink); // You can change the color as per your requirement
    }

    private void updateTable() {
        // Clear the table
        tableModel.setRowCount(0);

        // Populate the table with data
        for (int i = 0; i < dataList.size(); i++) {
            String peripheral = "2024" + String.format("%05d", i + 1);
            Object[] rowData = {peripheral, dataList.get(i), employeeList.get(i), statusList.get(i)};
            tableModel.addRow(rowData);
        }
    }

    private void displayPeripheralsByStatus(String statusToView) {
        // Clear the table
        tableModel.setRowCount(0);

        // Populate the table with peripherals having the specified status
        for (int i = 0; i < statusList.size(); i++) {
            if (statusList.get(i).equalsIgnoreCase(statusToView)) {
                String peripheral = "2024" + String.format("%05d", i + 1);
                Object[] rowData = {peripheral, dataList.get(i), employeeList.get(i), statusList.get(i)};
                tableModel.addRow(rowData);
            }
        }
    }

    private void setBorderColor(Color color) {
        // Set border color
        getRootPane().setBorder(BorderFactory.createLineBorder(color, 5));
    }

    private void setBackgroundColor(Color color) {
        // Set background color
        getContentPane().setBackground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyPeripherals();
            }
        });
    }
}
