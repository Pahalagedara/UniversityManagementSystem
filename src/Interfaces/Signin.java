package Interfaces;
import java.sql.*;

public class Signin extends Authentication {
    private String name;
    private int age;
    private String password1;
    private String s1;
    private String s2;
    private String s3;

    public Signin() {
    }
//database query
    public void getStudent() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student where user_name='"+getUsername()+"' && password='"+getPassword()+"'");
            while(rs.next()) {
                name=rs.getString(1);
                password1=rs.getString(3);
                age=rs.getInt(4);
                s1=rs.getString(5);
                s2=rs.getString(6);
                s3=rs.getString(7);
                //System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getInt(4) + " | " + rs.getString(5) + " | " + rs.getString(6) + " | " + rs.getString(7) + " |");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getLecturer() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from lecturer where user_name='"+getUsername()+"' && password='"+getPassword()+"' ");
            while(rs.next()) {
                name=rs.getString(1);
                password1=rs.getString(3);
                age=rs.getInt(4);
                s1=rs.getString(5);
                s2=rs.getString(6);
                s3=rs.getString(7);
                //System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getInt(4) + " | " + rs.getString(5) + " | " + rs.getString(6) + " | " + rs.getString(7) + " |");
            }
           con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword1(){
        return password1; }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public String getS3() {
        return s3;
    }
}

