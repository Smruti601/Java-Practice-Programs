import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentForm extends JFrame {

    private JTextField rollField, nameField;
    private JComboBox<String> deptBox;
    private JRadioButton maleButton, femaleButton, otherButton;
    private JButton submitButton;

    public StudentForm() {
        setTitle("Student Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Create components
        JLabel rollLabel = new JLabel("Roll No:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel deptLabel = new JLabel("Department:");
        JLabel genderLabel = new JLabel("Gender:");

        rollField = new JTextField(20);
        nameField = new JTextField(20);

        String[] departments = { "BCA", "CS", "ITM" };
        deptBox = new JComboBox<>(departments);

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        otherButton = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        submitButton = new JButton("Submit");

        // Main panel with grid layout
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.add(rollLabel); formPanel.add(rollField);
        formPanel.add(nameLabel); formPanel.add(nameField);
        formPanel.add(deptLabel); formPanel.add(deptBox);
        formPanel.add(genderLabel);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);
        formPanel.add(genderPanel);

        formPanel.add(new JLabel()); // Empty cell
        formPanel.add(submitButton);

        // Wrapper panel with padding (30px left and right)
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30)); // top, left, bottom, right
        wrapperPanel.add(formPanel, BorderLayout.CENTER);

        // Add to frame
        add(wrapperPanel);

        // Submit button action
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String rollNo = rollField.getText();
                String name = nameField.getText();
                String dept = (String) deptBox.getSelectedItem();
                String gender = "";

                if (maleButton.isSelected()) gender = "Male";
                else if (femaleButton.isSelected()) gender = "Female";
                else if (otherButton.isSelected()) gender = "Other";

                JOptionPane.showMessageDialog(
                    StudentForm.this,
                    "Roll No: " + rollNo + "\n" +
                    "Name: " + name + "\n" +
                    "Department: " + dept + "\n" +
                    "Gender: " + gender,
                    "Submitted Data",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentForm().setVisible(true);
        });
    }
}
