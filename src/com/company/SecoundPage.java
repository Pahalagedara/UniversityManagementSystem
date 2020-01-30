package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;


public class SecoundPage extends JFrame{

    private JTabbedPane panelSecound;
    private JPanel panel1;
    private JPanel subjectEnrolment;
    private JButton saveandexitButton;
    private JCheckBox subject1;
    private JCheckBox subject2;
    private JCheckBox subject3;
    private JPanel panel2;
    private JLabel img;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JFrame frame;
    private String username;
    private String password;
    private JTextField name;
    private JSpinner age;
    private JButton saveAndGoBackButton;
    private JButton goBackButton;
    private JButton exitButton;
    private JCheckBox isstudent;

    public SecoundPage() {

        add(panel1);
        setTitle("University Management System");
        setBounds(20,20,1000,800);
        setBounds(20,20,1000,800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(SecoundPage.EXIT_ON_CLOSE);
        setUndecorated(true);

        Signup signup=new Signup();
        Courses courses=new Courses();

        saveandexitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(age.getValue().toString())<=0){
                    JOptionPane.showMessageDialog(null,"Age must be greater than zero","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    signup.setUsername(username);
                    signup.setPassword(password);
                    signup.setName(name.getText());
                    signup.setAge(Integer.valueOf(age.getValue().toString()));

                    if(subject1.isSelected()){
                       signup.sub1=courses.s1;
                    }
                    if(subject2.isSelected()){
                       signup.sub2=courses.s2;
                    }
                    if(subject3.isSelected()){
                        signup.sub3=courses.s3;
                    }

                    if(isstudent.isSelected()){
                        signup.addStudent();
                    }
                    else{
                        signup.addLecturer();
                    }
                    JOptionPane.showMessageDialog(null, "Successful");
                    System.exit(0);
                }
            }
        });

        saveAndGoBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(age.getValue().toString())<=0){
                    JOptionPane.showMessageDialog(null,"Age must be greater than zero","ERROR",JOptionPane.ERROR_MESSAGE);
                    age.setValue(0);
                }
                else {
                    signup.setUsername(username);
                    signup.setPassword(password);
                    signup.setName(name.getText());

                    signup.setAge(Integer.parseInt(age.getValue().toString()));

                    if (subject1.isSelected()) {
                        signup.sub1 = courses.s1;
                    }
                    if (subject2.isSelected()) {
                        signup.sub2 = courses.s2;
                    }
                    if (subject3.isSelected()) {
                        signup.sub3 = courses.s3;
                    }

                    if (isstudent.isSelected()) {
                        signup.addStudent();
                    } else {
                        signup.addLecturer();
                    }
                    JOptionPane.showMessageDialog(null, "Successful");
                    FirstPage firstPage = new FirstPage();
                    dispose();
                    firstPage.setVisible(true);
                }

                }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstPage firstPage=new FirstPage();
                dispose();
                firstPage.setVisible(true);

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
    }
    public void secoundPage(String username, String password, JCheckBox isstudent){
             this.username=username;
             this.password=password;
             this.isstudent=isstudent;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        img =new JLabel(new ImageIcon("imag/profile (2).png"));
    }
}
