/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.data;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL-PC
 */
public class LoginAuthentication {
    private String userName,
                   passWord;
    
    private boolean loginSuccess;
   
    public boolean LoginAuthentication(String getUsername, String getPassword) throws ClassNotFoundException{
        
        Connection dbConnection = DBConnect.dbConnect();
        try{
            Statement queryStatement  = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            
            String SQL = "SELECT * FROM APP.USERS_TABLE WHERE USERNAME='"+getUsername+"'";
            ResultSet rs = queryStatement.executeQuery(SQL);
        
         if(rs.next()){
                
                userName = rs.getString("USERNAME");
                passWord = rs.getString("PASSWORD");
                if((userName.equals(getUsername.trim())) && (passWord.equals(getPassword))){
                    
                    loginSuccess = true;
                
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
