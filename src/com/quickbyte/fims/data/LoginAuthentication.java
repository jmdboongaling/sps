/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.data;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
   
    public boolean LoginAuthentication(String getUsername, String getPassword) throws ClassNotFoundException, NoSuchAlgorithmException{
        
        Connection dbConnection = DBConnect.dbConnect();
        try{
            String SQL = "SELECT * FROM SYSTEM_USERS.USERS_TABLE WHERE USERNAME= ?";
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
                    if((userName.equals(getUsername.trim())) && (passWord.equals(encryptPassword(getPassword)))){
                    
                        if(rs.getBoolean("ONLINE")){
                            JOptionPane.showMessageDialog(null, "The account you are trying to access is currently logged in right now.");
                        }else{
                            loginSuccess = true;
                            try{
                                String SQL2 = "UPDATE SYSTEM_USERS.USERS_TABLE SET ONLINE = TRUE, LAST_LOGIN = ? WHERE USERNAME = ?";
                                PreparedStatement pst = dbConnection.prepareStatement(SQL2);
                                pst.setTimestamp(1, new Timestamp(new java.util.Date().getTime()));
                                pst.setString(2, userName);
                                pst.executeUpdate();
                            }catch(Exception e){
                                e.printStackTrace();
                            }
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
