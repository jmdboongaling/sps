/*
  ____        _      _    ____        _       
 / __ \      (_)    | |  |  _ \      | |      
| |  | |_   _ _  ___| | _| |_) |_   _| |_ ___ 
| |  | | | | | |/ __| |/ /  _ <| | | | __/ _ \
| |__| | |_| | | (__|   <| |_) | |_| | ||  __/
 \___\_\\__,_|_|\___|_|\_\____/ \__, |\__\___|
                                 __/ |        
                                |___/         
  _____                          
 / ____|                         
| (___   ___  _   _ _ __ ___ ___ 
 \___ \ / _ \| | | | '__/ __/ _ \
 ____) | (_) | |_| | | | (_|  __/
|_____/ \___/ \__,_|_|  \___\___|

Author: Joshua Myron Deidre D. Boongaling
Last Edit: 8-02-2015 
Edited by: Joshua Myron Deidre D. Boongaling
*/

package com.quickbyte.fims.gui;

import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.tweenengine.Tween;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.border.*;
import com.quickbyte.fims.data.LoginAuthentication;


public class LoginPage{
    
    private JFrame loginFrame;
    
    private JTextField usernameField;
    
    private JPasswordField passwordField;
    
    private JButton loginButton,
                    forgotButton;
    
    private JPanel loginFieldsPanel,
                   loginButtonsPanel,
                   loginForm,
                   framePanel;
    
    public void LoginPage(){
        
        LoginPage run = new LoginPage();
        run.initComponents();
    }
    
    private void initComponents(){
        
        FrameComponents compGui = new FrameComponents(); 
        loginFrame = new JFrame();
        
       
        
        usernameField = new JTextField("Username");
        compGui.TextFieldProperties(usernameField);
        usernameField.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        usernameField.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                if(usernameField.getText().equals("Username")){
                    usernameField.setText("");
                }
                
            }
            public void mouseReleased(MouseEvent e){
                usernameField.setText("");
            }
            public void mouseExited(MouseEvent e){
                if(usernameField.getText().equals("")){
                    usernameField.setText("Username");
                }
                
            }
        });
        
        usernameField.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                while(usernameField.getText().equals("Username")){
                    usernameField.setText("");
                    
                }
                
            }
        });
        
        passwordField = new JPasswordField("Password");
        compGui.TextFieldProperties(passwordField);
        passwordField.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        passwordField.setEchoChar((char) 0);
        passwordField.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                if(passwordField.getText().equals("Password")){
                    passwordField.setText("");
                    passwordField.setEchoChar((char) 0);
                }
                
            }
            public void mouseReleased(MouseEvent e){
                passwordField.setText("");
                passwordField.setEchoChar('•');
            }
            public void mouseExited(MouseEvent e){
                if(passwordField.getText().equals("")){
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0);
                }
                
            }
        });
        
        passwordField.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                while(passwordField.getText().equals("Password")){
                    passwordField.setText("");
                    passwordField.setEchoChar('•');
                }
                passwordField.setEchoChar('•');
            }
        });
        passwordField.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e){
               loginButtonActionPerformed(e);
            }
            
        });
        
        loginButton = new JButton("Login");
        compGui.ButtonProperties(loginButton);
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){        
                loginButtonActionPerformed(e);         
            }
        });
        
        forgotButton = new JButton("Forgot Login?");
        compGui.ButtonProperties(forgotButton);
             
        loginFieldsPanel = new JPanel();
        loginFieldsPanel.setOpaque(false);
        loginFieldsPanel.setLayout(new GridLayout(2, 1, 0, 20));
        loginFieldsPanel.add(usernameField);
        loginFieldsPanel.add(passwordField);       
        
        loginButtonsPanel = new JPanel();
        loginButtonsPanel.setOpaque(false);
        loginButtonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        loginButtonsPanel.add(loginButton);
        loginButtonsPanel.add(forgotButton);
        
        loginForm = new JPanel();
        loginForm.setOpaque(false);
        //loginForm.setBackground(new Color(255, 255, 255, 200));
        loginForm.setBorder(new EmptyBorder(15, 15, 15, 15));
        loginForm.setLayout(new BorderLayout(5, 5));  
        loginForm.add(loginFieldsPanel, BorderLayout.CENTER);
        loginForm.add(loginButtonsPanel, BorderLayout.SOUTH);


 
        framePanel = new JPanel();
        framePanel.setOpaque(false);
        framePanel.setLayout(new BorderLayout());
        //framePanel.setBackground(compGui.themeColor2);

        framePanel.add(loginForm, BorderLayout.CENTER);
        
        
        loginFrame.setTitle("QuickByte Software - Student Management System");
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
        loginFrame.setContentPane(compGui.loginPageBackground);
        loginFrame.setLayout(new GridBagLayout());
 
        loginFrame.add(framePanel);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true); 
        //System.out.println(loginFrame.getSize());
        

        System.out.println(loginFrame.getSize());
    }
    
    private void loginButtonActionPerformed(ActionEvent e){
        String getUsername = usernameField.getText(),
               getPassword = passwordField.getText();
                
        try{
            LoginAuthentication run = new LoginAuthentication();
            
            
            if(run.LoginAuthentication(getUsername, getPassword)){

                JOptionPane.showMessageDialog(null, "Login Success!");
                loginFrame.dispose();
                    
                Tween.registerAccessor(PanelComponents.class, new PanelComponents.Accessor());
                SLAnimator.start();

                SystemFrame runSystem = new SystemFrame();
                runSystem.SystemFrame();

            }

            else{

                JOptionPane.showMessageDialog(null, "Invalid Login Information!");

            }

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                       
    
}
