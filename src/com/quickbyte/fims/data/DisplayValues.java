/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.data;

import com.quickbyte.fims.gui.DisplayPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;


public class DisplayValues{
    public static String name, xname;
    public static String DisplayValues(String studentPull) throws ClassNotFoundException{
        Connection dbConnection = DBConnect.dbConnect();
        try{
            Statement queryStatement  = dbConnection.createStatement();
            
            
            String SQL = "SELECT * FROM APP.STUDENTS_TABLE WHERE STUDENT_NO = '"+studentPull+"'";
            ResultSet rs = queryStatement.executeQuery(SQL);
        
         while(rs.next()){
             name ="Full Name: " + rs.getString("FIRST_NAME") + " " + rs.getString("MIDDLE_NAME") + " " + rs.getString("LAST_NAME");
             //System.out.println(name);

             
             //JOptionPane.showMessageDialog(null, new JScrollPane(table));
         }
         
         return name;
        }catch(Exception e){
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage);
            //System.out.println(errorMessage);
            return null;
        }
        
        
    }

    

    

}
    
    
    

