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
    
    private JLabel usernameLabel,
                   passwordLabel;

    
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
        
        FrameComponents guiComp = new FrameComponents(); 
        loginFrame = new JFrame();
        
        usernameLabel = new JLabel("Username: ");
        guiComp.LabelProperties(usernameLabel);
        
        passwordLabel = new JLabel("Password");
        guiComp.LabelProperties(passwordLabel);
        
        usernameField = new JTextField(22);
        
        passwordField = new JPasswordField(22);
        passwordField.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e){
               loginButtonActionPerformed(e);
            }
            
        });
        
        loginButton = new JButton("Login");
        guiComp.ButtonProperties(loginButton);
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){        
                loginButtonActionPerformed(e);         
            }
        });
        
        forgotButton = new JButton("Forgot Login?");
        guiComp.ButtonProperties(forgotButton);
             
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
        loginForm.setBackground(new Color(255, 255, 255, 200));
        loginForm.setBorder(new EmptyBorder(15, 15, 15, 15));
        loginForm.setLayout(new BorderLayout(5, 5));  
        loginForm.add(loginFieldsPanel, BorderLayout.CENTER);
        loginForm.add(loginButtonsPanel, BorderLayout.SOUTH);


 
        framePanel = new JPanel();
        framePanel.setOpaque(true);
        framePanel.setLayout(new BorderLayout());
        framePanel.setBackground(guiComp.themeColor2);

        framePanel.add(loginForm, BorderLayout.CENTER);
        
        
        loginFrame.setTitle("QuickByte Software - Student Management System");
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
        loginFrame.setContentPane(guiComp.loginPageBackground);
        loginFrame.setLayout(new GridBagLayout());
 
        loginFrame.add(framePanel);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true); 
        //System.out.println(loginFrame.getSize());
        

        
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
