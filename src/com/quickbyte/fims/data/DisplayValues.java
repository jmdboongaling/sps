
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
            String SQL = "SELECT * FROM STUDENTS_TABLE WHERE STUDENT_NO = ?";
            PreparedStatement queryStatement  = dbConnection.prepareStatement(SQL);
            queryStatement.setString(1, studentPull);
            ResultSet rs = queryStatement.executeQuery();
        
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
         
            
            
            DisplayPanel.studentFirstNameField.setText(studentFirstName); 
            DisplayPanel.studentMiddleNameField.setText(studentMiddleName);
            DisplayPanel.studentLastNameField.setText(studentLastName);
            DisplayPanel.studentNumberField.setText(studentNumber); 
            DisplayPanel.studentCourseField.setText(studentCourse); 
            DisplayPanel.studentSectionField.setText(studentSection);
            DisplayPanel.studentGenderField.setText(studentGender);
            DisplayPanel.studentEmailField.setText(studentEmail);
            DisplayPanel.studentNicknameField.setText(studentNickname);
            DisplayPanel.studentPermAddressField.setText(studentPermAddress);
            DisplayPanel.studentPresentAddressField.setText(studentPresentAddress);
            DisplayPanel.studentCellNumberField.setText(studentCellNumber);
            DisplayPanel.studentHomeNumberField.setText(studentHomeNumber);
            DisplayPanel.studentCivilStatusField.setText(studentCivilStatus);
            DisplayPanel.studentReligionField.setText(studentReligion);
            DisplayPanel.studentNationalityField.setText(studentNationality);
            DisplayPanel.studentBirthdayField.setText(studentBirthday);
            DisplayPanel.studentBirthplaceField.setText(studentBirthplace);
            DisplayPanel.studentBirthRankField.setText(studentBirthRank);
         
        }catch(Exception e){
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage);
            e.printStackTrace();
            //System.out.println(errorMessage);
            
        }
        
        
    }

    

    

}
    
    
    

