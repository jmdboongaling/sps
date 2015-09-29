/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.data;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL-PC
 */
public class LoginAuthentication {
    
    public static String userName,
                         firstName,
                         userLevel;
    private String passWord;
    
    private boolean loginSuccess;
   
    public boolean LoginAuthentication(String getUsername, String getPassword) throws ClassNotFoundException{
        
        Connection dbConnection = DBConnect.dbConnect();
        try{
            String SQL = "SELECT * FROM USERS_TABLE WHERE USERNAME= ?";
            PreparedStatement queryStatement  = dbConnection.prepareStatement(SQL);
            queryStatement.setString(1, getUsername);
            
            
            ResultSet rs = queryStatement.executeQuery();
        
         if(rs.next()){
                
                userName = rs.getString("USERNAME");
                passWord = rs.getString("PASSWORD");
                firstName = rs.getString("FIRST_NAME");
                userLevel = rs.getString("USER_LEVEL");
                if(rs.getString("ONLINE").equals("True")){
                    JOptionPane.showMessageDialog(null, "The account that you are trying to access is currently online. There can only be 1 session per account.");
                }else{
                    if((userName.equals(getUsername.trim())) && (passWord.equals(getPassword))){
                    
                    loginSuccess = true;
                    try{
                        String SQL2 = "UPDATE USERS_TABLE SET ONLINE = 'True' WHERE USERNAME = ?";
                        PreparedStatement pst = dbConnection.prepareStatement(SQL2);
                        pst.setString(1, userName);
                        pst.executeUpdate();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    
                
                    }else{

                        loginSuccess = false;

                    }
                }
                
         }
         else{
             JOptionPane.showMessageDialog(null, "Username does not exist");
         }
            
            
        }catch(SQLException | HeadlessException e){
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage);
            //System.out.println(errorMessage);
            
        }
        
        
        return loginSuccess;
    }
    
}
