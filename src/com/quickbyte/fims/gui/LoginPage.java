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
Last Edit: 
Edited by: 
*/

package com.quickbyte.fims.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.border.*;
import com.quickbyte.fims.data.LoginAuthentication;


public class LoginPage extends FrameComponents{
    
    private JLabel usernameLabel,
                   passwordLabel;

    
    private JTextField usernameField;
    
    private JPasswordField passwordField;
    
    private JButton loginButton,
                    forgotButton;
    
    private JPanel loginFieldsPanel,
                   loginButtonsPanel,
                   loginForm,
                   fillerPanel1,
                   fillerPanel2,
                   fillerPanel3,
                   fillerPanel4,
                   framePanel;
    
    public void LoginPage(){
        
        LoginPage run = new LoginPage();
        run.initComponents();
    }
    
    private void initComponents(){
        
        usernameLabel = new JLabel("Username: ");
        LabelProperties(usernameLabel);
        
        passwordLabel = new JLabel("Password");
        LabelProperties(passwordLabel);
        
        usernameField = new JTextField(22);
        
        passwordField = new JPasswordField(22);
        
        loginButton = new JButton("Login");
        ButtonProperties(loginButton);
        loginButton.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent loginButton){
                
                String getUsername = usernameField.getText(),
                       getPassword = passwordField.getText();
                
                
   
                try {
                    LoginAuthentication run = new LoginAuthentication(getUsername, getPassword);
                    
                    if(run.loginSuccess == true){
                    
                        JOptionPane.showMessageDialog(null, "Login Success!");
                        dispose();
                        //setVisible(false);
                        SystemFrame runSystem = new SystemFrame();
                        
                    
                    }
                    
                    else{
                    
                        JOptionPane.showMessageDialog(null, "Invalid Login Information!");
                    
                    }
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                    

            }
            
        });
        
        forgotButton = new JButton("Forgot Login?");
        ButtonProperties(forgotButton);
             
        loginFieldsPanel = new JPanel();
        loginFieldsPanel.setOpaque(false);
        loginFieldsPanel.setLayout(new GridLayout(4, 1, 5, 5));
        loginFieldsPanel.add(usernameLabel);
        loginFieldsPanel.add(usernameField);
        loginFieldsPanel.add(passwordLabel);
        loginFieldsPanel.add(passwordField);       
        
        loginButtonsPanel = new JPanel();
        loginButtonsPanel.setOpaque(false);
        loginButtonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        loginButtonsPanel.add(loginButton);
        loginButtonsPanel.add(forgotButton);
        
        loginForm = new JPanel();
        loginForm.setOpaque(true);
        loginForm.setBackground(new Color(255, 255, 255, 70));
        loginForm.setBorder(new EmptyBorder(15, 15, 15, 15));
        loginForm.setLayout(new BorderLayout(5, 5));  
        loginForm.add(loginFieldsPanel, BorderLayout.CENTER);
        loginForm.add(loginButtonsPanel, BorderLayout.SOUTH);


 
        framePanel = new JPanel();
        framePanel.setOpaque(true);
        framePanel.setLayout(new BorderLayout(5, 5));
        framePanel.setBackground(themeColor2);

        framePanel.add(loginForm, BorderLayout.CENTER);


        
        //logoLabel = new JLabel(logoImage);
        FrameComponents();
        
        setSize(400, 400);
        //setResizable(false);
        //getContentPane().setBackground(themeColor2);
        setLayout(new FlowLayout());
        
        add(framePanel);
        //pack();
        

        
    }
                       
    
}
