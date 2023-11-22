import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame {

    private JTextField inputField;
    private JComboBox<String> fromComboBox, toComboBox;
    private JLabel resultLabel;

    public TemperatureConverterGUI() {
        super("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        // Set the color of the frame border to red
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.RED));

        // Components
        inputField = new JTextField(10);
        fromComboBox = new JComboBox<>(new String[]{"Fahrenheit", "Celsius", "Kelvin"});
        toComboBox = new JComboBox<>(new String[]{"Fahrenheit", "Celsius", "Kelvin"});
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result:");

        // Layout
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);  // Set the background color to pink
        panel.add(new JLabel("Enter Temperature: "));
        panel.add(inputField);
        panel.add(fromComboBox);
        panel.add(new JLabel("to"));
        panel.add(toComboBox);
        panel.add(convertButton);
        panel.add(resultLabel);

        // Add ActionListener to the Convert Button
        convertButton.addActionListener(e -> convertTemperature());

        // Set layout manager
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Set GroupLayout
        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(panel)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(panel)
        );
    }

    private void convertTemperature() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String fromUnit = fromComboBox.getSelectedItem().toString();
            String toUnit = toComboBox.getSelectedItem().toString();

            double result;

            if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
                result = (inputValue - 32) * 5 / 9;
            } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Kelvin")) {
                result = (inputValue + 459.67) * 5 / 9;
            } else if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
                result = (inputValue * 9 / 5) + 32;
            } else if (fromUnit.equals("Celsius") && toUnit.equals("Kelvin")) {
                result = inputValue + 273.15;
            } else if (fromUnit.equals("Kelvin") && toUnit.equals("Fahrenheit")) {
                result = (inputValue * 9 / 5) - 459.67;
            } else if (fromUnit.equals("Kelvin") && toUnit.equals("Celsius")) {
                result = inputValue - 273.15;
            } else {
                result = inputValue; // Same unit conversion
            }

            resultLabel.setText("Result: " + result + " " + toUnit);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TemperatureConverterGUI().setVisible(true);
        });
    }
}
