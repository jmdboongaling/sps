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
package com.quickbyte.fims.data;

import java.sql.*;
import javax.swing.JOptionPane;


public class DBConnect{
    
   
    
    public boolean loginSuccess;
    
    public static Connection dbConnect() throws ClassNotFoundException{
        
        try{
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            final String dbURL = "jdbc:derby:IMS_DB",
                         dbUsername = "dbadmin",
                         dbPassword = "1311448.14";
            
            Connection dbConnection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            
            
           return dbConnection; 
        }
        catch(SQLException e){
            
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage);
            //System.out.println(errorMessage);
            return null;
            
        }
    }
   
        
       
                
                    
                
         
            
            
            
   
    
    

    
    
}
