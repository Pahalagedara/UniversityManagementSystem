package com.company;

import javax.swing.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Signup extends Authentication {
    private String name;
    private int age;
    public String sub1;
    public String sub2;
    public String sub3;


    public Signup() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




    public void addStudent() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement add_stu = con.prepareStatement("INSERT INTO student VALUES ('"+getName()+ "','"+getUsername()+"','"+getPassword()+"','"+getAge()+"','"+sub1+ "','"+sub2 + "','"+sub3+"') ");
            add_stu.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Username already exist","Error",2);
        }
    }

    public void addLecturer() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement add_lec = con.prepareStatement("INSERT INTO lecturer VALUES('" +getName()+ "','"+getUsername()+"','"+getPassword()+"','"+getAge()+"','"+sub1+ "','"+sub2 + "','"+sub3+"') ");
            add_lec.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Username already exist");
        }
    }
}
