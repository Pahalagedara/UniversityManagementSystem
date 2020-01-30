package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstPage extends JFrame{
    private JPasswordField passwordSI;
    private JTextField usernameSI;
    private JPasswordField passwordSU_2;
    private JPasswordField passwordSU_1;
    private JTextField usernameSU;
    private JButton signInButton;
    private JButton signUpButton;
    private JCheckBox studentCheckBoxSI;
    private JCheckBox lecturerCheckBoxSI;
    private JCheckBox studentCheckBoxSU;
    private JCheckBox lecturerCheckBoxSU;
    private JPanel panelMain;
    private JButton exitButton;
    private String username;
    private String password_1;
    private String password_2;

    public FirstPage() {

        Signin signin=new Signin();

        add(panelMain);
        setTitle("University Management System");
        setBounds(20,20,1000,800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(SecoundPage.EXIT_ON_CLOSE);
        setUndecorated(true);

        ButtonGroup bg1 =new ButtonGroup();
        ButtonGroup bg2 =new ButtonGroup();
        bg1.add(studentCheckBoxSI);
        bg2.add(studentCheckBoxSU);
        bg1.add(lecturerCheckBoxSI);
        bg2.add(lecturerCheckBoxSU);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signin.setUsername(usernameSI.getText());
                signin.setPassword(passwordSI.getText());
                if(studentCheckBoxSI.isSelected()){
                    signin.getStudent();
                }
                else {
                    signin.getLecturer();
                }
                if(signin.getPassword1()!=null){
                    ThirdPage thirdPage=new ThirdPage();
                    thirdPage.thirdPage(usernameSI.getText(),signin.getName(),signin.getAge(),signin.getS1(),signin.getS2(),signin.getS3());
                    thirdPage.setVisible(true);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Username or Password invalid","ERROR",JOptionPane.ERROR_MESSAGE);
                    passwordSI.setText(null);
                    usernameSI.setText(null);
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usernameSU.getText().isEmpty()||passwordSU_1.getText().isEmpty()||passwordSU_2.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"please enter data for all filed","ERROR",JOptionPane.ERROR_MESSAGE);

                }
                else {

                    if ((passwordSU_1.getText().compareTo(passwordSU_2.getText())) == 0) {
                        username= usernameSU.getText();
                        password_1=passwordSU_1.getText();
                        password_2=passwordSU_2.getText();
                        dispose();
                        SecoundPage secoundPage=new SecoundPage();
                        secoundPage.secoundPage(username,password_1,studentCheckBoxSU);
                        secoundPage.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Entered password is not valid");
                        usernameSU.setText(null);
                        passwordSU_1.setText(null);
                        passwordSU_2.setText(null);
                    }
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }//end of FirstPage


}

