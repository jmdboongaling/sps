/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.gui;


import com.quickbyte.fims.data.AddUserRecord;
import com.quickbyte.fims.data.DBConnect;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.dev.designgridlayout.DesignGridLayout;

public class AddUser extends JFrame{
    
    private JLabel headerLabel,
                   userLevel;
                   
    
    private JTextField usernameField,
                       usernameField2,
                       firstNameField,
                       middleNameField,
                       lastNameField,
                       orgPositionField,
                       orgDepartmentField;
    
    private JPasswordField passwordField,
                           passwordField2;
    
    private JButton loginButton,
                    closeButton,
                    addButton,
                    clearButton;
    
    private JComboBox userLevelList;
    
    private final FrameComponents compGui = new FrameComponents();
    
    public AddUser(){
       headerLabel = new JLabel("Please login using a Administrator level account.");
       compGui.LabelProperties(headerLabel);

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
                try {
                    try {
                        loginButtonActionPerformed(e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        loginButton = new JButton("Login");
        compGui.ButtonProperties(loginButton);
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){        
                try {         
                    loginButtonActionPerformed(e);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        closeButton = new JButton("Cancel");
        compGui.ButtonProperties(closeButton);
        closeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        
        JPanel loginPanel = new JPanel();
        DesignGridLayout loginLayout = new DesignGridLayout(loginPanel);
        loginPanel.setOpaque(false);
        
        loginLayout.row().center().add(headerLabel);
        loginLayout.row().grid().add(usernameField);
        loginLayout.row().grid().add(passwordField);
        loginLayout.row().center().add(loginButton).add(closeButton);
        
        super.setIconImage(compGui.frameIcon.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        add(loginPanel);
        
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    
    
    private void showForm(){
        JFrame formFrame = new JFrame();
        
        usernameField2 = new JTextField("Username");
        compGui.TextFieldProperties(usernameField2);
        usernameField2.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        usernameField2.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                if(usernameField2.getText().equals("Username")){
                    usernameField2.setText("");
                }
                
            }
            public void mouseReleased(MouseEvent e){
                usernameField2.setText("");
            }
            public void mouseExited(MouseEvent e){
                if(usernameField2.getText().equals("")){
                    usernameField2.setText("Username");
                }
                
            }
        });
        
        usernameField2.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                while(usernameField2.getText().equals("Username")){
                    usernameField2.setText("");
                    
                }
                
            }
        });
        
        passwordField2 = new JPasswordField("Password");
        compGui.TextFieldProperties(passwordField2);
        passwordField2.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        passwordField2.setEchoChar((char) 0);
        passwordField2.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                if(passwordField2.getText().equals("Password")){
                    passwordField2.setText("");
                    passwordField2.setEchoChar((char) 0);
                }
                
            }
            public void mouseReleased(MouseEvent e){
                passwordField2.setText("");
                passwordField2.setEchoChar('•');
            }
            public void mouseExited(MouseEvent e){
                if(passwordField2.getText().equals("")){
                    passwordField2.setText("Password");
                    passwordField2.setEchoChar((char) 0);
                }
                
            }
        });
        
        passwordField2.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                while(passwordField2.getText().equals("Password")){
                    passwordField2.setText("");
                    passwordField2.setEchoChar('•');
                }
                passwordField2.setEchoChar('•');
            }
        });
        
        firstNameField = new JTextField("First Name");
        compGui.TextFieldProperties(firstNameField);
        firstNameField.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        firstNameField.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                if(firstNameField.getText().equals("First Name")){
                    firstNameField.setText("");
                }
                
            }
            public void mouseReleased(MouseEvent e){
                firstNameField.setText("");
            }
            public void mouseExited(MouseEvent e){
                if(firstNameField.getText().equals("")){
                    firstNameField.setText("First Name");
                }
                
            }
        });
        
        firstNameField.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                while(firstNameField.getText().equals("First Name")){
                    firstNameField.setText("");
                    
                }
                
            }
        });
        
        middleNameField = new JTextField("Middle Name");
        compGui.TextFieldProperties(middleNameField);
        middleNameField.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        middleNameField.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                if(middleNameField.getText().equals("Middle Name")){
                    middleNameField.setText("");
                }
                
            }
            public void mouseReleased(MouseEvent e){
                middleNameField.setText("");
            }
            public void mouseExited(MouseEvent e){
                if(middleNameField.getText().equals("")){
                    middleNameField.setText("Middle Name");
                }
                
            }
        });
        
        middleNameField.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                while(middleNameField.getText().equals("Middle Name")){
                    middleNameField.setText("");
                    
                }
                
            }
        });
        
        lastNameField = new JTextField("Last Name");
        compGui.TextFieldProperties(lastNameField);
        lastNameField.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        lastNameField.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                if(lastNameField.getText().equals("Last Name")){
                    lastNameField.setText("");
                }
                
            }
            public void mouseReleased(MouseEvent e){
                lastNameField.setText("");
            }
            public void mouseExited(MouseEvent e){
                if(lastNameField.getText().equals("")){
                    lastNameField.setText("Last Name");
                }
                
            }
        });
        
        lastNameField.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                while(lastNameField.getText().equals("Last Name")){
                    lastNameField.setText("");
                    
                }
                
            }
        });
        
        orgPositionField = new JTextField("Position");
        compGui.TextFieldProperties(orgPositionField);
        orgPositionField.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        orgPositionField.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                if(orgPositionField.getText().equals("Position")){
                    orgPositionField.setText("");
                }
                
            }
            public void mouseReleased(MouseEvent e){
                orgPositionField.setText("");
            }
            public void mouseExited(MouseEvent e){
                if(orgPositionField.getText().equals("")){
                    orgPositionField.setText("Position");
                }
                
            }
        });
        
        orgPositionField.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                while(orgPositionField.getText().equals("Position")){
                    orgPositionField.setText("");
                    
                }
                
            }
        });
        
        orgDepartmentField = new JTextField("Department");
        compGui.TextFieldProperties(orgDepartmentField);
        orgDepartmentField.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        orgDepartmentField.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                if(orgDepartmentField.getText().equals("Department")){
                    orgDepartmentField.setText("");
                }
                
            }
            public void mouseReleased(MouseEvent e){
                orgDepartmentField.setText("");
            }
            public void mouseExited(MouseEvent e){
                if(orgDepartmentField.getText().equals("")){
                    orgDepartmentField.setText("Department");
                }
                
            }
        });
        
        orgDepartmentField.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                while(orgDepartmentField.getText().equals("Department")){
                    orgDepartmentField.setText("");
                    
                }
                
            }
        });
        
        userLevel = new JLabel("User Level: ");
        compGui.LabelProperties(userLevel);
        
        userLevelList = new JComboBox(new String[]{"Administrator", "Limited"});
        userLevelList.setFont(compGui.componentFont);
        userLevelList.setBackground(Color.WHITE);
        
        addButton = new JButton("Add User");
        compGui.ButtonProperties(addButton);
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AddUserRecord(usernameField2.getText(), passwordField2.getText(), firstNameField.getText(), middleNameField.getText(), lastNameField.getText(), orgPositionField.getText(), orgDepartmentField.getText(), userLevelList.getSelectedItem().toString());
            }
        });
        
        clearButton = new JButton("Clear Fields");
        compGui.ButtonProperties(clearButton);
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                usernameField2.setText("");
                passwordField2.setText("");
                firstNameField.setText("");
                middleNameField.setText("");
                lastNameField.setText("");
                orgPositionField.setText("");
                orgDepartmentField.setText("");
            }
        });
        formFrame.setTitle("QuickByte Software - Makati Medical Center College Student Profiling System - Add User");
        formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formFrame.setIconImage(compGui.frameIcon.getImage());
        formFrame.getContentPane().setBackground(Color.WHITE);
        formFrame.setMinimumSize(new Dimension(700, 300));
        JPanel containerPanel = new JPanel();
        containerPanel.setOpaque(false);
        DesignGridLayout formLayout = new DesignGridLayout(containerPanel);
        formLayout.row().grid().add(usernameField2);
        formLayout.row().grid().add(passwordField2);
        formLayout.row().grid().add(firstNameField);
        formLayout.row().grid().add(middleNameField);
        formLayout.row().grid().add(lastNameField);
        formLayout.row().grid().add(orgPositionField);
        formLayout.row().grid().add(orgDepartmentField);
        formLayout.row().grid().add(userLevelList);
        formLayout.row().center().add(addButton);
        
        formFrame.add(containerPanel, BorderLayout.CENTER);
        formFrame.setLocationRelativeTo(null);
        formFrame.setVisible(true);
        
        
    }
    
    private void loginButtonActionPerformed(ActionEvent e) throws NoSuchAlgorithmException, ClassNotFoundException{
        if(loginAuthentication(usernameField.getText(), passwordField.getText())){
            JOptionPane.showMessageDialog(null, "Login success!");
            dispose();
            showForm();
        }else{
            JOptionPane.showMessageDialog(null, "Invalid login credentials.");
        }
    }
    private boolean loginAuthentication(String getUsername, String getPassword) throws ClassNotFoundException, NoSuchAlgorithmException{
        boolean loginSuccess = false;
        Connection dbConnection = DBConnect.dbConnect();
        try{
            String SQL = "SELECT * FROM SYSTEM_USERS.USERS_TABLE WHERE USERNAME= ?";
            PreparedStatement queryStatement  = dbConnection.prepareStatement(SQL);
            queryStatement.setString(1, getUsername);
            
            
            ResultSet rs = queryStatement.executeQuery();
            
         if(rs.next()){
             
             loginSuccess = (getUsername.trim().equals(rs.getString("USERNAME")) && encryptPassword(getPassword).equals(rs.getString("PASSWORD")));
     
         }else{
             JOptionPane.showMessageDialog(null, "Username does not exist");
         }
            
            
        }catch(SQLException | HeadlessException e){
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage);
            return false;
            
        }
        
        
        return loginSuccess;
    }
    
    private String encryptPassword(String password) throws NoSuchAlgorithmException{
      
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : digest) {
			stringBuilder.append(String.format("%02x", b & 0xff));
		}

		return stringBuilder.toString();
    }
    

    
}
