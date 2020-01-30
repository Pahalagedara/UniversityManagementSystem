package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ThirdPage extends JFrame{
    private JPanel mainPanel_3;
    private JRadioButton subject1;
    private JRadioButton subject2;
    private JRadioButton subject3;
    private JTextField name;
    private JTextField age;
    private JButton exitButton;
    private JButton backButton;
    private JButton saveNewDataButton;
    private String nameDB;
    private String username;
    private int ageDB;
    private String sub1;
    private String sub2;
    private String sub3;

    public ThirdPage() {
        add(mainPanel_3);
        setTitle("University Management System");
        setBounds(20,20,1000,800);
        setBounds(20,20,1000,800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(ThirdPage.EXIT_ON_CLOSE);
        setUndecorated(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstPage firstPage=new FirstPage();
                firstPage.setVisible(true);
            }
        });
        saveNewDataButton.addActionListener(new ActionListener() {
            Courses courses=new Courses();

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    nameDB=name.getText();
                    ageDB=Integer.valueOf(age.getText());
                    if(subject1.isSelected()){
                        sub1=courses.s1;
                    }
                    else{
                        sub1=null;
                    }
                    if(subject2.isSelected()){
                        sub2=courses.s2;
                    }
                    else{
                        sub2=null;
                    }
                    if(subject3.isSelected()){
                        sub3=courses.s3;
                    }
                    else{
                        sub3=null;
                    }
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
                    PreparedStatement add_stu = con.prepareStatement("UPDATE student SET name='"+nameDB+ "',age='"+ageDB+"',sub1='"+sub1+ "',sub2='"+sub2+ "',sub3='"+sub3+"' WHERE user_name='"+username+"'");
                    PreparedStatement add_lec = con.prepareStatement("UPDATE lecturer SET name='"+nameDB+ "',age='"+ageDB+"',sub1='"+sub1+ "',sub2='"+sub2+ "',sub3='"+sub3+"' WHERE user_name='"+username+"'");

                    add_stu.executeUpdate();
                    add_lec.executeUpdate();
                    con.close();
                    JOptionPane.showMessageDialog(null,"Update successful");
                    FirstPage firstPage=new FirstPage();
                    firstPage.setVisible(true);
                    dispose();
                }catch (Exception a){
                    if(a instanceof NumberFormatException){
                    System.out.println(a);
                    JOptionPane.showMessageDialog(null,"Please Enter valid number try again");
                    }
                }
            }

        });
    }
    public void  thirdPage(String username,String nameDB,int ageDB,String sub1,String sub2,String sub3) {
        this.username=username;
        this.nameDB = nameDB;
        this.ageDB = ageDB;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        name.setText(nameDB);
        age.setText(String.valueOf(ageDB));
        if(sub1.compareTo("null")!=0){
            subject1.setSelected(true);
        }
        if(sub2.compareTo("null")!=0){
            subject2.setSelected(true);
        }
        if(sub3.compareTo("null")!=0){
            subject3.setSelected(true);
        }
    }
}
