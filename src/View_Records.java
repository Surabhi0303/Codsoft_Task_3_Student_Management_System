import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class View_Records {



    String driverName = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/student_data";
    static final String USER = "root";
    static final String PASS = "sheru123#";
    public void showTableData() {

        JFrame frame1 = new JFrame(" Student  Database Result");
        JTable table;
        PreparedStatement pst;
        String[] columnNames = {"Roll Number","Student Name" ,"PRN_Number","Branch","Divison"};

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "select * from student";
            Statement ps =  con.createStatement();
            ResultSet rs = ps.executeQuery(sql);

            int i = 0;
            while(rs.next())
            {
                String roll_number = rs.getString("Roll Number");
                String Name =rs.getString("Student Name");
                String prn_number =rs.getString("PRN_Number");
                String branch = rs.getString("Branch");
                String divison = rs.getString("Divison");

                model.addRow(new Object[]{roll_number,Name,prn_number,branch,divison});
                i++;
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if(i ==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400,300);
    }

    public static void main(String[] args) {
        View_Records v=new View_Records();
        v.showTableData();
    }
}



