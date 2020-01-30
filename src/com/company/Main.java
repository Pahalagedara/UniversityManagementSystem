package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Signin signin = new Signin();
        Signup signup = new Signup();
        Courses courses = new Courses();
        DBconnection database=new DBconnection();

        database.createTables();
        String a;
        int age,i=0;
        char[] b=new char [6];

	    System.out.println("Select, [1] sign up,[2] sign in.");
        int selection1  = scan.nextInt();
        System.out.println("Please select your registration role [1] Lecture,[2] Student.");
        int selection2  = scan.nextInt();
        if (selection1==1) {
            System.out.println("Name:");
            a = scan.next();
            signup.setName(a);
            System.out.println("Username:");
            a = scan.next();
            signup.setUsername(a);
            System.out.println("Password:");
            a = scan.next();
            signup.setPassword(a);
            System.out.println("Age:");
            age = scan.nextInt();
            signup.setAge(age);
            System.out.println("\nSelect the courses\n [1]"+ courses.s1 + " \n [2]" + courses.s2 + " \n [3]" + courses.s1);
            a = scan.next();

            signup.sub1="NULL";
            signup.sub2="NULL";
            signup.sub3="NULL";

            String[] part = a.split(",");
            Integer.parseInt(part[1]);

            for (i = 0; i < part.length; i++) {
                switch (part[i])
                {
                    case "1":
                        System.out.println(courses.s1);
                        signup.sub1=courses.s1;
                        break;
                    case "2":
                        System.out.println(courses.s2);
                        signup.sub2=courses.s2;

                        break;
                    case "3":
                        System.out.println(courses.s3);
                        signup.sub3=courses.s3;
                        break;
                    default:
                        System.out.println("Entered numbers are wrong");
                }
            }
            if (selection2==1){                       //signup change database using user role start
                signup.addLecturer();
            }

            else if(selection2==2){
                signup.addStudent();
            }
            else
                System.out.println("registration role is wrong");    //sign up change database using user role end
        }
        else if (selection1== 2)
        {

            System.out.println("Username:");
            a=scan.next();
            signin.setUsername(a);
            System.out.println("Password:");
            a=scan.next();
            signin.setPassword(a);


            if (selection2==1){                    //sign in change database using user role start
                signin.getLecturer();
            }

            else if(selection2==2){
                signin.getStudent();
            }
            else
                System.out.println("registration role is wrong");

        }
        else
        {
            System.out.println("Wrong input try again");
        }                                                        // change database using user role end


    }




}
