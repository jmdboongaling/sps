/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.data;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL-PC
 */
public class LoginAuthentication {
    public static String userName;
    private String passWord;
    
    private boolean loginSuccess;
   
    public boolean LoginAuthentication(String getUsername, String getPassword) throws ClassNotFoundException{
        
        Connection dbConnection = DBConnect.dbConnect();
        try{
            String SQL = "SELECT * FROM APP.USERS_TABLE WHERE USERNAME= ?";
            PreparedStatement queryStatement  = dbConnection.prepareStatement(SQL);
            queryStatement.setString(1, getUsername);
            
            
            ResultSet rs = queryStatement.executeQuery();
        
         if(rs.next()){
                
                userName = rs.getString("USERNAME");
                passWord = rs.getString("PASSWORD");
                if((userName.equals(getUsername.trim())) && (passWord.equals(getPassword))){
                    
                    loginSuccess = true;
                    //new com.quickbyte.fims.gui.SystemFrame().systemFrame.add(new JLabel("Welcome" + userName), BorderLayout.NORTH);
                
                }
                else{
                
                    loginSuccess = false;
                
                }
         }
         else{
             JOptionPane.showMessageDialog(null, "Username does not exist");
         }
            
            
        }catch(Exception e){
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage);
            //System.out.println(errorMessage);
            
        }
        return loginSuccess;
    }
    
}
