/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.data;

import com.quickbyte.fims.gui.DisplayPanel;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class DisplayValues{
    private String studentFirstName, 
                   studentMiddleName,
                   studentLastName,
                   studentNumber, 
                   studentCourse, 
                   studentSection, 
                   studentEmail;
    public DisplayValues(String studentPull) throws ClassNotFoundException{
        Connection dbConnection = DBConnect.dbConnect();
        try{
            Statement queryStatement  = dbConnection.createStatement();
            
            
            String SQL = "SELECT * FROM APP.STUDENTS_TABLE WHERE STUDENT_NO = '"+studentPull+"'";
            ResultSet rs = queryStatement.executeQuery(SQL);
        
         while(rs.next()){
             studentNumber = rs.getString("STUDENT_NO");
             studentLastName = rs.getString("LAST_NAME");
             studentMiddleName = rs.getString("MIDDLE_NAME");
             studentFirstName = rs.getString("FIRST_NAME");
             studentCourse = rs.getString("COURSE");
             studentSection = rs.getString("YEAR_SECTION");
             studentEmail = rs.getString("EMAIL_ADDRESS");
             //System.out.println(name);

             
             //JOptionPane.showMessageDialog(null, new JScrollPane(table));
         }
         
            DisplayPanel displayRecord = new DisplayPanel();
            displayRecord.containerPanel.removeAll();
            displayRecord.containerPanel.repaint();
            displayRecord.containerPanel.revalidate();
            //displayRecord.searchLabel.setText(studentName);
            displayRecord.containerPanel.add(new JTextField(studentNumber));
            displayRecord.containerPanel.add(new JTextField(studentFirstName));
            displayRecord.containerPanel.add(new JTextField(studentCourse));
            displayRecord.containerPanel.add(new JTextField(studentSection));
            displayRecord.containerPanel.add(new JTextField(studentEmail));
         
        }catch(Exception e){
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage);
            //System.out.println(errorMessage);
            
        }
        
        
    }

    

    

}
    
    
    

