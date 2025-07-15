import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CleanRegistrationFormAWT extends Frame implements ActionListener {
    TextField tfFirst, tfMiddle, tfLast, tfRoll, tfPass, tfConfirm;
    CheckboxGroup courseGroup, genderGroup;
    Button btnSubmit;

    CleanRegistrationFormAWT() {
        setTitle("Student Registration Form");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        Label lblTitle = new Label("Registration Form", Label.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitle.setBackground(new Color(0, 102, 204));
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle, BorderLayout.NORTH);

        Panel form = new Panel(new GridLayout(8, 2, 10, 10));
        form.setBackground(new Color(240, 248, 255));
        form.setFont(new Font("SansSerif", Font.PLAIN, 14));

        form.add(new Label("First Name:"));
        tfFirst = new TextField(); form.add(tfFirst);

        form.add(new Label("Middle Name:"));
        tfMiddle = new TextField(); form.add(tfMiddle);

        form.add(new Label("Last Name:"));
        tfLast = new TextField(); form.add(tfLast);

        form.add(new Label("Roll No:"));
        tfRoll = new TextField(); form.add(tfRoll);

        form.add(new Label("Course:"));
        Panel coursePanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        courseGroup = new CheckboxGroup();
        coursePanel.add(new Checkbox("BCA", courseGroup, true));
        coursePanel.add(new Checkbox("ITM", courseGroup, false));
        coursePanel.add(new Checkbox("CS", courseGroup, false));
        coursePanel.add(new Checkbox("DS", courseGroup, false));
        form.add(coursePanel);

        form.add(new Label("Gender:"));
        Panel genderPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        genderGroup = new CheckboxGroup();
        genderPanel.add(new Checkbox("Male", genderGroup, true));
        genderPanel.add(new Checkbox("Female", genderGroup, false));
        genderPanel.add(new Checkbox("Other", genderGroup, false));
        form.add(genderPanel);

        form.add(new Label("Password:"));
        tfPass = new TextField(); tfPass.setEchoChar('*'); form.add(tfPass);

        form.add(new Label("Confirm Password:"));
        tfConfirm = new TextField(); tfConfirm.setEchoChar('*'); form.add(tfConfirm);

        add(form, BorderLayout.CENTER);

        Panel buttonPanel = new Panel();
        btnSubmit = new Button("Submit");
        btnSubmit.setBackground(new Color(34, 139, 34));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnSubmit.addActionListener(this);
        buttonPanel.add(btnSubmit);
        add(buttonPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String fname = tfFirst.getText();
        String mname = tfMiddle.getText();
        String lname = tfLast.getText();
        String roll = tfRoll.getText();
        String course = courseGroup.getSelectedCheckbox().getLabel();
        String gender = genderGroup.getSelectedCheckbox().getLabel();
        String pass = tfPass.getText();
        String cpass = tfConfirm.getText();

        if (!pass.equals(cpass)) {
            showDialog("Passwords do not match!");
            return;
        }

        try {
            // MySQL connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "root"
            );

            String query = "INSERT INTO registration (first_name, middle_name, last_name, roll_no, course, gender, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, fname);
            stmt.setString(2, mname);
            stmt.setString(3, lname);
            stmt.setString(4, roll);
            stmt.setString(5, course);
            stmt.setString(6, gender);
            stmt.setString(7, pass);

            int result = stmt.executeUpdate();
            if (result > 0) {
                showDialog(" Registration Successful!");
                clearFields();
            } else {
                showDialog(" Registration Failed!");
            }

            con.close();
        } catch (SQLException ex) {
            showDialog(" Error: " + ex.getMessage());
        }
    }

    void showDialog(String message) {
        Dialog d = new Dialog(this, "Message", true);
        d.setLayout(new FlowLayout());
        d.setSize(300, 120);
        d.setLocationRelativeTo(this);
        d.add(new Label(message));
        Button ok = new Button("OK");
        ok.addActionListener(e -> d.setVisible(false));
        d.add(ok);
        d.setVisible(true);
    }

    void clearFields() {
        tfFirst.setText("");
        tfMiddle.setText("");
        tfLast.setText("");
        tfRoll.setText("");
        tfPass.setText("");
        tfConfirm.setText("");
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            return;
        }

        new CleanRegistrationFormAWT();
    }
}
