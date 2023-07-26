import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Delete_Records  extends JFrame {

    private JFrame f;

    private JTextField PRNTextfield;
    private JLabel PRNLabel;

    private JButton delete;


    Delete_Records(){

        f=new JFrame("Delete Records");
        f.setSize(300,150);
        f.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a content pane with an EmptyBorder to set margin from the right side
        JPanel contentPane = new JPanel(new GridLayout(3, 2, 5, 5));
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 20)); // 20

        PRNTextfield=new JTextField(12);
        PRNLabel=new JLabel("PRN No.");

        delete=new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String prn=PRNTextfield.getText();


                try {
                    JDBCConnection.Delete(prn);
                    JOptionPane.showMessageDialog(Delete_Records.this,"Record Deleted Successfully");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(Delete_Records.this,"Error");
                }


            }
        });


        contentPane.add(PRNLabel);
        contentPane.add(PRNTextfield);
        contentPane.add(new JLabel());
        contentPane.add(delete);
        contentPane.setVisible(true);

        f.setContentPane(contentPane);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Delete_Records();
    }
}
