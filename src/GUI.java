import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class GUI  {

  JFrame f;
    public static void main(String[] args) {

        GUI g=new GUI();


    }


    GUI()
    {
        f=new JFrame("STUDENT DATA");//creating instance of JFrame






        JButton b=new JButton("INSERT RECORD");//creating instance of JButton


        b.setBounds(50,150,150, 40);
        JButton b1=new JButton("UPDATE RECORD");
        b1.setBounds(210,150,150,40);

        JButton b2=new JButton("DELETE RECORD");
        b2.setBounds(50,250,150,40);
        JButton b3=new JButton("VIEW RECORDS");
        b3.setBounds(210,250,150,40);

        JLabel l1;
        l1=new JLabel("STUDENT DATABASE MANAGEMENT ");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBounds(70,70, 250,30);
        f.add(l1);



        f.add(b);//adding button in JFrame
        f.add(b1);
        f.add(b2);
        f.add(b3);

        f.setSize(400,400);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                   new Insert();

                   b.setEnabled(false);

            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Update_Record();
                b1.setEnabled(false);

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Delete_Records();
                b2.setEnabled(false);
            }
        });


        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             View_Records v=   new View_Records();
             v.showTableData();
                b3.setEnabled(false);
            }
        });

    }



}
