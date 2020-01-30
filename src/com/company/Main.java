package com.company;

public class Main {
    public static void main(String[] args) {
        DBconnection database=new DBconnection();
        database.createTables();
        main1();
    }
    public static void main1() {
        FirstPage t=new FirstPage();
        t.setVisible(true);

    }
}
