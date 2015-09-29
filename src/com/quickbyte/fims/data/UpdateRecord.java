/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.data;

import java.sql.*;
import javax.swing.JOptionPane;

public class UpdateRecord {
    
    public UpdateRecord(String studentNumber){
        try{
            String SQL = "UPDATE STUDENTS_TABLE SET" +
                         "COURSE = ?," + 
                         "YEAR_SECTION = ?," + 
                         "EMAIL_ADDRESS = ?," + 
                         "PERM_ADDRESS = ?," + 
                         "PRESENT_ADDRESS = ?," + 
                         "CELL_NUMBER = ?," + 
                         "HOME_NUMBER = ?," + 
                         "CIVIL_STATUS = ?," + 
                         "RELIGION = ?," + 
                         "SPOUSE_NAME = ?," + 
                         "SPOUSE_OCCUPATION = ?," + 
                         "SPOUSE_MARRIAGEDATE = ?," + 
                         "SPOUSE_MARRIAGEPLACE = ?," + 
                         "SPOUSE_EMPADDRESS = ?," + 
                         "SPOUSE_NUMCHILDREN = ?," + 
                         "FATHER_NAME = ?," + 
                         "FATHER_STATUS = ?," + 
                         "FATHER_ADDRESS = ?," + 
                         "FATHER_AGE = ?," + 
                         "FATHER_EDUCATION = ?," + 
                         "FATHER_OCCUPATION = ?," + 
                         "FATHER_EMPADDRESS = ?," + 
                         "MOTHER_NAME = ?," + 
                         "MOTHER_STATUS = ?," + 
                         "MOTHER_ADDRESS = ?," + 
                         "MOTHER_AGE = ?," + 
                         "MOTHER_EDUCATION = ?," + 
                         "MOTHER_CELLNUMBER = ?," + 
                         "MOTHER_OCCUPATION = ?," + 
                         "MOTHER_EMPADDRESS = ?," + 
                         "PARENTS_STATUS = ?," + 
                         "PARENTS_INCOME = ? " + 
                         "WHERE STUDENT_NO = ?";
            Connection dbConnection = DBConnect.dbConnect();
            PreparedStatement queryStatement = dbConnection.prepareStatement(SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            queryStatement.setString(1, SQL);
            
            
        }catch(Exception e){
            
        }
    }
}
