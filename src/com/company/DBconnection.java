package com.company;
import java.sql.*;
public class DBconnection {

    public String name;

    public void createTables() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement lecturer = con.prepareStatement("create table IF NOT EXISTS lecturer( name varchar(20),user_name varchar(20) NOT NULL,password varchar(15) NOT NULL,age int,sub1 varchar(40),sub2 varchar(40),sub3 varchar(40),primary key (user_name));");
            lecturer.executeUpdate();
            PreparedStatement student = con.prepareStatement("create table IF NOT EXISTS student( name varchar(20),user_name varchar(20) NOT NULL,password varchar(15) NOT NULL,age int,sub1 varchar(40),sub2 varchar(40),sub3 varchar(40),primary key (user_name));");
            student.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }













}
