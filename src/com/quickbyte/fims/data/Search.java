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
    public Search(String studentQuery, String categoryQuery) throws ClassNotFoundException{
        Connection dbConnection = DBConnect.dbConnect();
        
        
        if(categoryQuery.equals("Name")){
            SQL = "SELECT * FROM STUDENTS_TABLE WHERE LOWER(LAST_NAME) LIKE LOWER('%"+studentQuery+"%') OR LOWER(FIRST_NAME) LIKE LOWER('%"+studentQuery+"%') OR LOWER(MIDDLE_NAME) LIKE LOWER('%"+studentQuery+"%')";
        }else if(categoryQuery.equals("Student Number")){
            SQL = "SELECT * FROM STUDENTS_TABLE WHERE STUDENT_NO = '"+studentQuery+"'";
        }else{
            switch(categoryQuery){
                case "Student Number":
                    categoryQuery = "STUDENT_NO";
                    break;
                case "Course":
                    categoryQuery = "COURSE";
                    break;
                case "Section":
                    categoryQuery = "YEAR_SECTION";
                    break;
                case "E-Mail":
                    categoryQuery = "EMAIL_ADDRESS";
                    break;
                case "Cellphone Number":
                    categoryQuery = "CELL_NUMBER";
                    break;
                case "Home Phone Number":
                    categoryQuery = "HOME_NUMBER";
                    break;
                case "Permanent Address":
                    categoryQuery = "PERM_ADDRESS";
                    break;
                case "Present Address":
                    categoryQuery = "PRESENT_ADDRESS";
                    break;
                case "Gender":
                    categoryQuery = "GENDER";
                    break;
                case "Civil Status":
                    categoryQuery = "CIVIL_STATUS";
                    break;
                case "Religion":
                    categoryQuery = "RELIGION";
                    break;
                case "Nationality":
                    categoryQuery = "NATIONALITY";
                    break;
                case "Age":
                    categoryQuery = "AGE";
                    break;
                case "Date of Birth":
                    categoryQuery = "BIRTHDAY";
                    break;
                case "Place of Birth":
                    categoryQuery = "BIRTHPLACE";
                    break;
                case "Birth Rank":
                    categoryQuery = "BIRTH_RANK";
                    break;
            }
            SQL = "SELECT * FROM STUDENTS_TABLE WHERE LOWER("+categoryQuery+") LIKE LOWER('%"+studentQuery+"%')";
        }
            
        try{
            
            Statement queryStatement  = dbConnection.createStatement();
            //queryStatement.setString(1, categoryQuery);
            //queryStatement.setString(1, studentQuery);
            ResultSet rs = queryStatement.executeQuery(SQL);
            
        
         do{
             
             table = new JTable(buildTableModel(rs));
             
             
             //JOptionPane.showMessageDialog(null, new JScrollPane(table));
         }while(rs.next());
            FrameComponents guiComp = new FrameComponents();
            table.setFont(guiComp.componentFont);
            table.setRowSelectionAllowed(true);
            table.setCellSelectionEnabled(false);
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
         //rs.close();*/
        }catch(Exception e){
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage);
            //System.out.println(errorMessage);
            
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
                    columnNames.add("#");
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
