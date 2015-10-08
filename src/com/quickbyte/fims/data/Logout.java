
package com.quickbyte.fims.data;

import java.sql.*;

public class Logout {
    public Logout(String studentQuery){
        try{
            String SQL = "UPDATE SYSTEM_USERS.USERS_TABLE SET ONLINE = FALSE WHERE USERNAME = ?";
            Connection dbConnection = DBConnect.dbConnect();
            PreparedStatement queryStatement = dbConnection.prepareStatement(SQL);
            queryStatement.setString(1, studentQuery);
            queryStatement.executeUpdate();
            
            System.out.println("Logged Out!");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
