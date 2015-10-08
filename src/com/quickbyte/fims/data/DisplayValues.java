
package com.quickbyte.fims.data;

import com.quickbyte.fims.gui.DisplayPanel;
import static com.quickbyte.fims.gui.DisplayPanel.guardianAddressField;
import static com.quickbyte.fims.gui.DisplayPanel.guardianCellField;
import static com.quickbyte.fims.gui.DisplayPanel.guardianNameField;
import static com.quickbyte.fims.gui.DisplayPanel.guardianRelationField;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.java.dev.designgridlayout.DesignGridLayout;



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
                   studentBirthRank,
                   studentSpouse,
                   studentSpouseOccupation,
                   studentSpouseMarriageDate,
                   studentSpouseMarriagePlace,
                   studentSpouseAge,
                   studentSpouseEmployerAddress,
                   studentNoOfChildren,
                   fatherName,
                   fatherStatus,
                   fatherAddress,
                   fatherAge,
                   fatherEducation,
                   fatherCellNumber,
                   fatherOccupation,
                   fatherEmployerAddress,
                   motherName,
                   motherStatus,
                   motherAddress,
                   motherAge,
                   motherEducation,                   
                   motherCellNumber,
                   motherOccupation,
                   motherEmployerAddress,
                   parentsStatus,
                   parentsEconomicStatus,
                   guardianName,
                   guardianRelation,
                   guardianCell,
                   guardianAddress,
                   workPosition,
                   workAddress,
                   entryYear,
                   studentGPA;
    
    public DisplayValues(String studentPull) throws ClassNotFoundException,  NullPointerException{
        Connection dbConnection = DBConnect.dbConnect();
        try{
            String SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE STUDENT_NO = ?";
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
            studentSpouse = rs.getString("SPOUSE_NAME");
            studentSpouseOccupation = rs.getString("SPOUSE_OCCUPATION");
            studentSpouseMarriageDate = rs.getString("SPOUSE_MARRIAGEDATE");
            studentSpouseMarriagePlace = rs.getString("SPOUSE_MARRIAGEPLACE");
            studentSpouseEmployerAddress = rs.getString("SPOUSE_EMPADDRESS");
            studentNoOfChildren = rs.getString("SPOUSE_NUMCHILDREN");
            
            fatherName = rs.getString("FATHER_NAME");
            fatherStatus = rs.getString("FATHER_STATUS");
            fatherAddress = rs.getString("FATHER_ADDRESS");
            fatherAge = rs.getString("FATHER_AGE");
            fatherEducation = rs.getString("FATHER_EDUCATION");
            fatherOccupation = rs.getString("FATHER_OCCUPATION");
            fatherEmployerAddress = rs.getString("FATHER_EMPADDRESS");
            motherName = rs.getString("MOTHER_NAME");
            motherStatus = rs.getString("MOTHER_STATUS");
            motherAddress = rs.getString("MOTHER_ADDRESS");
            motherAge = rs.getString("MOTHER_AGE");
            motherEducation = rs.getString("MOTHER_EDUCATION");
            motherCellNumber = rs.getString("MOTHER_CELLNUMBER");
            motherOccupation = rs.getString("MOTHER_OCCUPATION");
            motherEmployerAddress = rs.getString("MOTHER_EMPADDRESS");
            parentsStatus = rs.getString("PARENTS_STATUS");
            parentsEconomicStatus = Integer.toString(rs.getInt("PARENTS_INCOME"));
            guardianName = rs.getString("GUARDIAN_NAME");
            guardianRelation = rs.getString("GUARDIAN_RELATION");
            guardianCell = rs.getString("GUARDIAN_CELL");
            guardianAddress = rs.getString("GUARDIAN_ADDRESS");
            workPosition = rs.getString("WORK_POSITION");
            workAddress = rs.getString("WORK_ADDRESS");
            entryYear = rs.getString("ENTRY_YEAR");
            studentGPA = Float.toString(rs.getFloat("STUDENT_GPA"));
             //JOptionPane.showMessageDialog(null, new JScrollPane(table));
         }
         
            String imageDir = DBConnect.imageDir.replace("\"", "\\\"");
            
            if(!DisplayPanel.studentNumberField.getText().equals("")){
                DisplayPanel.studentImageLabel.setIcon(new ImageIcon(imageDir + studentNumber + ".jpg"));
                DisplayPanel.studentImageLabel.setText("");
            }else{
                
                DisplayPanel.studentImageLabel.setText("No Image Available!");
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
            DisplayPanel.studentAgeField.setText(Integer.toString((int)getAge(new java.util.Date(), new java.util.Date(rs.getDate("BIRTHDAY").getTime()))));
            DisplayPanel.studentBirthplaceField.setText(studentBirthplace);
            DisplayPanel.studentBirthRankField.setText(studentBirthRank);
            
            DisplayPanel.studentSpouseField.setText(studentSpouse);
            DisplayPanel.studentSpouseOccupationField.setText(studentSpouseOccupation);
            if(studentSpouse.equals("Not Applicable")){
                DisplayPanel.studentSpouseMarriageDateField.setText("Not Applicable");
            }else{
                DisplayPanel.studentSpouseMarriageDateField.setText(studentSpouseMarriageDate);
            }
            
            DisplayPanel.studentSpouseMarriagePlaceField.setText(studentSpouseMarriagePlace);
            DisplayPanel.studentSpouseAgeField.setText(studentSpouseAge);
            DisplayPanel.studentSpouseEmployerAddressField.setText(studentSpouseEmployerAddress);
            DisplayPanel.studentNoOfChildrenField.setText(studentNoOfChildren);
            DisplayPanel.fatherNameField.setText(fatherName);
            DisplayPanel.fatherStatusField.setText(fatherStatus);
            DisplayPanel.fatherAddressField.setText(fatherAddress);
            DisplayPanel.fatherAgeField.setText(fatherAge);
            DisplayPanel.fatherEducationField.setText(fatherEducation);
            DisplayPanel.fatherCellNumberField.setText(fatherCellNumber);
            DisplayPanel.fatherOccupationField.setText(fatherOccupation);
            DisplayPanel.fatherEmployerAddressField.setText(fatherEmployerAddress);
            DisplayPanel.motherNameField.setText(motherName);
            DisplayPanel.motherStatusField.setText(motherStatus);
            DisplayPanel.motherAddressField.setText(motherAddress);
            DisplayPanel.motherAgeField.setText(motherAge);
            DisplayPanel.motherEducationField.setText(motherEducation);
            DisplayPanel.motherCellNumberField.setText(motherCellNumber);
            DisplayPanel.motherOccupationField.setText(motherOccupation);
            DisplayPanel.motherEmployerAddressField.setText(motherEmployerAddress);
            DisplayPanel.parentsStatusField.setText(parentsStatus);
            DisplayPanel.parentsEconomicStatusField.setText(parentsEconomicStatus);
            DisplayPanel.guardianNameField.setText(guardianName);
            DisplayPanel.guardianRelationField.setText(guardianRelation);
            DisplayPanel.guardianCellField.setText(guardianCell);
            DisplayPanel.guardianAddressField.setText(guardianAddress);
            DisplayPanel.workPositionField.setText(workPosition);
            DisplayPanel.workPositionField.setText(workAddress);
            DisplayPanel.entryYearField.setText(entryYear);
            DisplayPanel.studentGPAField.setText(studentGPA);
        }catch(Exception e){
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage);
            e.printStackTrace();   
        }
        
        
    }

    
private static float getAge(java.util.Date birthdate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static float getAge(final java.util.Date current, final java.util.Date birthdate) {

        if (birthdate == null) {
          return 0;
        }
        if (current == null) {
          return getAge(birthdate);
        } else {
          final Calendar calend = new GregorianCalendar();
          calend.set(Calendar.HOUR_OF_DAY, 0);
          calend.set(Calendar.MINUTE, 0);
          calend.set(Calendar.SECOND, 0);
          calend.set(Calendar.MILLISECOND, 0);

          calend.setTimeInMillis(current.getTime() - birthdate.getTime());

          float result = 0;
          result = calend.get(Calendar.YEAR) - 1970;
          result += (float) calend.get(Calendar.MONTH) / (float) 12;
          return result;
        }

    }

    /*private DisplayValues() {
    }

    
    
   public ArrayList<Object> siblingsTable(String studentPull){
       try{
            JPanel x = new JPanel();
            DesignGridLayout y = new DesignGridLayout(x);
            ArrayList<Object> list = new ArrayList<>();
            PreparedStatement queryStatement = DBConnect.dbConnect().prepareStatement("SELECT * FROM STUDENT_RECORDS.STUDENT_COLLECTIONS WHERE STUDENT_NO = ? ORDER BY SIBLINGS_BIRTHRANK ASC");
            queryStatement.setString(1, studentPull);
            ResultSet rs = queryStatement.executeQuery();
            while(rs.next()){
                JLabel fieldLabel = new JLabel(rs.getString(motherName));
                y.row().grid(new JLabel("Name")).add(new JTextField(rs.getString("SIBLING_NAME")));
            }
            
            JOptionPane.showMessageDialog(null, x);
            return list;
       }catch(Exception err){
           err.printStackTrace();
           return null;
       }
        
    }
    
    public static void main(String[]args){
        new DisplayValues().siblingsTable("14-10001");
    }*/
    

}
    
    
    

