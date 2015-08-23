
package com.quickbyte.fims.data;

import com.quickbyte.fims.gui.DisplayPanel;
import java.sql.*;
import javax.swing.*;



public class DisplayValues{
    private String studentFirstName, 
                   studentMiddleName,
                   studentLastName,
                   studentNumber, 
                   studentCourse, 
                   studentSection,
                   studentGender,
                   studentEmail,
                   studentNickname,
                   studentPermAddress,
                   studentPresentAddress,
                   studentCellNumber,
                   studentHomeNumber,
                   studentCivilStatus,
                   studentReligion,
                   studentNationality,
                   studentBirthday,
                   studentBirthplace,
                   studentBirthRank;
    public DisplayValues(String studentPull) throws ClassNotFoundException{
        Connection dbConnection = DBConnect.dbConnect();
        try{
            Statement queryStatement  = dbConnection.createStatement();
            
            
            String SQL = "SELECT * FROM APP.STUDENTS_TABLE WHERE STUDENT_NO = '"+studentPull+"'";
            ResultSet rs = queryStatement.executeQuery(SQL);
        
         if(rs.next()){
            studentNumber = rs.getString("STUDENT_NO");
            studentLastName = rs.getString("LAST_NAME");
            studentMiddleName = rs.getString("MIDDLE_NAME");
            studentFirstName = rs.getString("FIRST_NAME");
            studentCourse = rs.getString("COURSE");
            studentSection = rs.getString("YEAR_SECTION");
            studentEmail = rs.getString("EMAIL_ADDRESS");
            studentGender = rs.getString("GENDER");
            studentEmail = rs.getString("EMAIL_ADDRESS");
            studentNickname = rs.getString("NICKNAME");
            studentPermAddress = rs.getString("PERM_ADDRESS");
            studentPresentAddress = rs.getString("PRESENT_ADDRESS");
            studentCellNumber = rs.getString("CELL_NUMBER");
            studentHomeNumber = rs.getString("HOME_NUMBER");
            studentCivilStatus = rs.getString("CIVIL_STATUS");
            studentReligion = rs.getString("RELIGION");
            studentNationality = rs.getString("NATIONALITY");
            studentBirthday = rs.getString("BIRTHDAY");
            studentBirthplace = rs.getString("BIRTHPLACE");
            studentBirthRank = rs.getString("BIRTH_RANK");

             
             //JOptionPane.showMessageDialog(null, new JScrollPane(table));
         }
         
            DisplayPanel displayRecord = new DisplayPanel();
            displayRecord.containerPanel.removeAll();
            displayRecord.containerPanel.repaint();
            displayRecord.containerPanel.revalidate();
            displayRecord.containerPanel.add(new JLabel("Student Number: "+studentNumber+""));
            displayRecord.containerPanel.add(new JLabel("Full Name: "+studentFirstName+" "+studentMiddleName+" "+studentLastName+""));
            displayRecord.containerPanel.add(new JLabel("Course: "+studentCourse+""));
            displayRecord.containerPanel.add(new JLabel("Section: "+studentSection+""));
            displayRecord.containerPanel.add(new JLabel("E-Mail Address: "+studentEmail+""));
            displayRecord.containerPanel.add(new JLabel("Nickname: "+studentNickname+""));
            displayRecord.containerPanel.add(new JLabel("Permanent Address: "+studentPermAddress+""));
            displayRecord.containerPanel.add(new JLabel("Present Address: "+studentPresentAddress+""));
            displayRecord.containerPanel.add(new JLabel("Cellphone Number: "+studentCellNumber+""));
            displayRecord.containerPanel.add(new JLabel("Home Phone Number: "+studentHomeNumber+""));
            displayRecord.containerPanel.add(new JLabel("Civil Status: "+studentCivilStatus+""));
            displayRecord.containerPanel.add(new JLabel("Religion: "+studentReligion+""));
            displayRecord.containerPanel.add(new JLabel("Nationality: "+studentNationality+""));
            displayRecord.containerPanel.add(new JLabel("Date of Birth: "+studentBirthday+""));
            displayRecord.containerPanel.add(new JLabel("Place of Birth: "+studentBirthplace+""));
            displayRecord.containerPanel.add(new JLabel("Birth Rank: "+studentBirthRank+""));
         
        }catch(Exception e){
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage);
            e.printStackTrace();
            //System.out.println(errorMessage);
            
        }
        
        
    }

    

    

}
    
    
    

