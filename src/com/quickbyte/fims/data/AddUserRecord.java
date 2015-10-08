/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.JOptionPane;

public class AddUserRecord {
    
    public AddUserRecord(String username, String password, String firstname, String middlename, String lastname, String orgposition, String orgdepartment, String userlevel){
        try{
            String SQL = "INSERT INTO SYSTEM_USERS.USERS_TABLE (USER_ID, USERNAME, PASSWORD, FIRST_NAME, MIDDLE_NAME, LAST_NAME, ORG_POSITION, ORG_DEPARTMENT, USER_LEVEL, LAST_LOGIN, ONLINE)" + 
                         " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE)";
            PreparedStatement queryStatement = DBConnect.dbConnect().prepareStatement(SQL);
            queryStatement.setString(1, generateUserID(userlevel));
            queryStatement.setString(2, username);
            queryStatement.setString(3, encryptPassword(password));
            queryStatement.setString(4, firstname);
            queryStatement.setString(5, middlename);
            queryStatement.setString(6, lastname);
            queryStatement.setString(7, orgposition);
            queryStatement.setString(8, orgdepartment);
            queryStatement.setString(9, userlevel);
            queryStatement.setTimestamp(10, new Timestamp(new java.util.Date().getTime()));
            
            queryStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "The new user has been successfully registered!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static String generateUserID(String userlevel){
        String userID = null;
        try{
            Statement queryStatement = DBConnect.dbConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = queryStatement.executeQuery("SELECT * FROM SYSTEM_USERS.USERS_TABLE ORDER BY USER_ID ASC");
            rs.last();
            if(userlevel.equals("Administrator")){
                userID = Integer.toString(Integer.parseInt(rs.getString("USER_ID").substring(2, 5)) + 1);
                if(userID.length() == 1){
                    userID = "A-00" + userID;
                }else if(userID.length() == 2){
                    userID = "A-0" + userID;
                }else if(userID.length() == 3){
                    userID = "A-" + userID;
                }
            }else{
                userID = Integer.toString(Integer.parseInt(rs.getString("USER_ID").substring(2, 5)) + 1);
                if(userID.length() == 1){
                    userID = "L-00" + userID;
                }else if(userID.length() == 2){
                    userID = "L-0" + userID;
                }else if(userID.length() == 3){
                    userID = "L-" + userID;
                }
            }
            
            return userID;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
       
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
