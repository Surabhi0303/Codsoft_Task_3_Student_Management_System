import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Insert extends JFrame implements ActionListener {
    private JLabel prnLabel, nameLabel, rollLabel, branchLabel, divisionLabel;
    private JTextField prnField, nameField, rollField, branchField, divisionField;
    private JButton insertButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Insert();
            }
        });
    }

    Insert() {
        setTitle("Insert Records");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        prnLabel = new JLabel("PRN No.:");
        nameLabel = new JLabel("Student Name:");
        rollLabel = new JLabel("Roll Number:");
        branchLabel = new JLabel("Branch:");
        divisionLabel = new JLabel("Division:");

        prnField = new JTextField(15);
        nameField = new JTextField(15);
        rollField = new JTextField(15);
        branchField = new JTextField(15);
        divisionField = new JTextField(15);

        insertButton = new JButton("Insert");
        insertButton.addActionListener(this);

        // Set layout to GridLayout with 6 rows and 2 columns
        setLayout(new GridLayout(6, 2, 10, 10));

        // Add components to the frame
        add(prnLabel);
        add(prnField);
        add(nameLabel);
        add(nameField);
        add(rollLabel);
        add(rollField);
        add(branchLabel);
        add(branchField);
        add(divisionLabel);
        add(divisionField);
        add(new JLabel());
        add(insertButton);

        // Display the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String prn = prnField.getText();
        String name = nameField.getText();
        String rollNumber = rollField.getText();
        String branch = branchField.getText();
        String division = divisionField.getText();

        // Do something with the data (e.g., save to a database)
        // For this example, we'll just show a message dialog

      Integer rno=  Integer.parseInt(rollNumber);

        try {
            JDBCConnection.Connection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            JDBCConnection.Insert(rno,name,prn,branch,division);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }


        String message ="Record Inserted Successfully";

        JOptionPane.showMessageDialog(this, message);
    }
}
