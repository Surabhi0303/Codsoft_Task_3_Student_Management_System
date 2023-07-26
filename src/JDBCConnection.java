import java.sql.*;
import java.util.*;

// Console based application
public class JDBCConnection {
   private  int counter=0;


    public static void main(String[] args) {



       Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/database_name";
        String user = "your_username";
        String pwd = "your_password";






        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            Statement st = con.createStatement();
            System.out.println("Enter 1 for inserting Record");
            System.out.println("Enter 2 for Updating Record");
            System.out.println("Enter 3 for Deleting Record");
            System.out.println("Enter 4 for Viewing Records");


            int choice;
            System.out.println("Please Enter a choice :");

            choice=sc.nextInt();



            switch (choice)
            {
                case 1:
                    System.out.println("Enter rollNo: ");
                    int rno = sc.nextInt();

                    System.out.println("Enter Student name: ");

                    String sname = sc.next();
                    System.out.println("Enter Student PRN Number: ");
                    String sprnNumber=sc.next();
                    System.out.println("Enter Student Branch: ");
                    String sbranch=sc.next();
                    System.out.println("Enter Student Division:");
                    String sDivision=sc.next();
                    String sqlInsert = "insert into student values('" + rno + "','" +sname+"','" +sprnNumber+"','" +sbranch+"','" +sDivision+"')";

                     st.executeUpdate(sqlInsert);

                    System.out.println("record inserted successfully");
                    break;


                case 2:
                    System.out.println("Enter PRN Number of Student you want to Update");
                    String prn= sc.next();
                    System.out.println("Enter changed branch of student of Student you want to Update");
                    String branch=sc.next();



                    String sqlupdate="update student set Branch='"+branch+"' where PRN_Number='" + prn + "'";
                    st.executeUpdate(sqlupdate);

                    System.out.println("record updated successfully");
                    break;


                case 3:
                    System.out.println("Enter PRN Number of Student you want to Delete");
                    String prn1= sc.next();


                    String sqldelete="delete from student where PRN_Number='" + prn1 + "'";
                    st.executeUpdate(sqldelete);
                    System.out.println("record deleted successfully");
                    break;


                case 4:

                    String sql = "select * from student ORDER BY PRN_Number ";

                    ResultSet rs = st.executeQuery(sql);
                    JDBCConnection j=new JDBCConnection();


                    //View the records
                    System.out.println("Student Records");
                    while(rs.next()) {

                        System.out.println("RollNo: "+rs.getInt(1));
                        System.out.println("Student name: "+rs.getString(2));
                        System.out.println("PRN_Number "+rs.getInt(3));
                        System.out.println("Branch: "+rs.getString(4));
                        System.out.println("Divison: "+rs.getString(5));

                        ++j.counter;





                    }

                    System.out.println("Total "+j.counter+" Student Records Found");

                    break;






            }



            con.close();





    }



        catch(Exception ex) {
            System.out.println(ex);
        }
    }


    public static Connection Connection() throws ClassNotFoundException, SQLException {

         String url = "jdbc:mysql://localhost:3306/database_name";
        String user = "your_username";
        String pwd = "your_password";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pwd);


        return con;





    }


    public static void Insert(int rno,String sname,String sprnNumber,String sbranch,String sDivision) throws SQLException, ClassNotFoundException {



        Connection con=Connection();
        Statement st = con.createStatement();
        String sqlInsert = "insert into student values('" + rno + "','" +sname+"','" +sprnNumber+"','" +sbranch+"','" +sDivision+"')";

        st.executeUpdate(sqlInsert);
    }




    public  static void Update(String prnNo,int Rollno,String division) throws SQLException, ClassNotFoundException {

        Connection con=Connection();
        Statement st = con.createStatement();







        String sqlUpdate = "UPDATE student SET `Roll Number` = '" + Rollno + "', Divison = '" + division + "' WHERE PRN_Number = '" + prnNo + "'";
        st.executeUpdate(sqlUpdate);

    }

    public static void Delete(String prN) throws SQLException, ClassNotFoundException {
        Connection con=Connection();
        Statement st = con.createStatement();

        String sqldelete="delete from student where PRN_Number='" + prN + "'";
        st.executeUpdate(sqldelete);










    }



}
