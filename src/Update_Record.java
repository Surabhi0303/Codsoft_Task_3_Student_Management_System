import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Update_Record extends JFrame {
    JFrame f;
    private JLabel prnLabel, rollLabel, divisionLabel;
    private JTextField prnField, rollField, divisionField;
    private JButton updateButton;
    Update_Record()

    {
        f=new JFrame("STUDENT DATA");//creating instance of JFrame

        f.setVisible(true);//making the frame visible


        f.setTitle("Update Student Records");
        f.setSize(400, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);



        // Create components
        prnLabel = new JLabel("PRN No.:");
        rollLabel = new JLabel("Roll Number:");
        divisionLabel = new JLabel("Division:");

        prnField = new JTextField(15);
        rollField = new JTextField(15);
        divisionField = new JTextField(15);

        updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String prn=prnField.getText();
                String rollNo=rollField.getText();
                String division=divisionField.getText();

                int rno=Integer.parseInt(rollNo);

                try {
                    JDBCConnection.Update(prn,rno,division);

                    String message ="Record Updated Successfully";

                    JOptionPane.showMessageDialog(Update_Record.this, message);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    String message ="Error";

                    JOptionPane.showMessageDialog(Update_Record.this, message);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }





            }
        });


        // Set layout to GridLayout with 4 rows and 2 columns
        f.setLayout(new GridLayout(4, 2, 10, 10));

        // Add components to the frame
        f.add(prnLabel);
        f.add(prnField);
        f.add(rollLabel);
        f.add(rollField);
        f.add(divisionLabel);
        f.add(divisionField);
        f.add(new JLabel());
        f.add(updateButton);




        // Display the frame
        f.setVisible(true);
    }




    public static void main(String[] args) {

        new Update_Record();


    }
}
