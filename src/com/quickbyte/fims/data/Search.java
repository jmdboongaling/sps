/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.data;

import com.quickbyte.fims.gui.FrameComponents;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;


public class Search{
    public JTable table;
    private String SQL;
    public Search(String studentQuery, String categoryQuery) throws ClassNotFoundException, SQLException, ParseException{
        Connection dbConnection = DBConnect.dbConnect();
        
        try{
            PreparedStatement queryStatement = null;
            ResultSet rs;
            
            switch(categoryQuery){
                case "Student Number":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE STUDENT_NO = ?";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, studentQuery);
                    
                    break;
                case "Name":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(LAST_NAME) LIKE LOWER(?) OR LOWER(FIRST_NAME) LIKE LOWER(?) OR LOWER(MIDDLE_NAME) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    queryStatement.setString(2, "%" + studentQuery + "%");
                    queryStatement.setString(3, "%" + studentQuery + "%");
                    break;
                case "Course":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(COURSE) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Section":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(YEAR_SECTION) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "E-Mail":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(EMAIL_ADDRESS) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Cellphone Number":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE CELL_NUMBER = ?";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, studentQuery);
                    break;
                case "Home Phone Number":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE HOME_NUMBER = ?";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, studentQuery);
                    break;
                case "Permanent Address":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(PERM_ADDRESS) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Present Address":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(PRESENT_ADDRESS) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Gender":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(GENDER) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Civil Status":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(CIVIL_STATUS) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Religion":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(RELIGION) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Nationality":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(NATIONALITY) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                /*case "Age":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE BIRTHDAY = ?";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-mm");
                    java.util.Date date = format.parse(studentQuery);
                    queryStatement.setDate(1, new java.sql.Date(date.getTime()));
                    break;*/
                case "Place of Birth":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(BIRTHPLACE) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Birth Rank":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(BIRTH_RANK) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Parent's Status":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(PARENTS_STATUS) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Parent's Annual Income":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE PARENTS_INCOME = ?";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setInt(1, Integer.parseInt(studentQuery));
                    break;
                case "Primary School":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(PRIMARY_SCHOOL) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Secondary School":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(SECONDARY_SCHOOL) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Tertiary School":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE LOWER(TERTIARY_SCHOOL) LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "Year of Entry":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE ENTRY_YEAR LIKE LOWER(?)";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setString(1, "%" + studentQuery + "%");
                    break;
                case "General Percentile Average":
                    SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE STUDENT_GPA = ?";
                    queryStatement = dbConnection.prepareStatement(SQL);
                    queryStatement.setFloat(1, Float.parseFloat(studentQuery));
                    break;
            }
            
            
            
            
            rs = queryStatement.executeQuery();
        
            do{

                table = new JTable(buildTableModel(rs));


                //JOptionPane.showMessageDialog(null, new JScrollPane(table));
            }while(rs.next());
            FrameComponents guiComp = new FrameComponents();
            table.setFont(guiComp.componentFont);
            table.setRowSelectionAllowed(true);
            //table.setCellSelectionEnabled(false);
            table.setShowGrid(false);
            table.getTableHeader().setBackground(Color.WHITE);
            table.getTableHeader().setOpaque(false);
            
            table.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                try {
                    String studentNumber = (String) table.getValueAt(table.getSelectedRow(), 0);
                    

                    new DisplayValues(studentNumber);
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                }
            });
            rs.close();
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
        
        
    }

    private static DefaultTableModel buildTableModel(ResultSet rs)throws SQLException{

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = 6;//metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++){
           switch(column){
                case 1:
                    columnNames.add("Student #");
                    break;
                case 2:
                    columnNames.add("Last Name");
                    break;
                case 3:
                    columnNames.add("First Name");
                    break;
                case 4:
                    columnNames.add("Middle Name");
                    break;
                case 5:
                    columnNames.add("Course");
                    break;
                case 6:
                    columnNames.add("Year and Section");
                    break;
           }
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }


        return new DefaultTableModel(data, columnNames);

    }
    
 
    
    
    
}
