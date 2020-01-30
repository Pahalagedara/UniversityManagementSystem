package com.company;
import java.sql.*;

public class Signin extends Authentication {
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
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getInt(4) + " | " + rs.getString(5) + " | " + rs.getString(6) + " | " + rs.getString(7) + " |");
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
                System.out.println("\n");
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getInt(4) + " | " + rs.getString(5) + " | " + rs.getString(6) + " | " + rs.getString(7) + " |");
            }
           con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}

