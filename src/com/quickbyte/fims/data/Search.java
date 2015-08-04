/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.data;

import com.quickbyte.fims.gui.FrameComponents;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;


public class Search {
    public JTable table;
    public Search(String studentQuery) throws ClassNotFoundException{
        Connection dbConnection = DBConnect.dbConnect();
        try{
            Statement queryStatement  = dbConnection.createStatement();
            
            
            String SQL = "SELECT * FROM APP.STUDENTS_TABLE WHERE COURSE = '"+studentQuery+"'";
            ResultSet rs = queryStatement.executeQuery(SQL);
        
         do{
             table = new JTable(buildTableModel(rs));
             
             
             //JOptionPane.showMessageDialog(null, new JScrollPane(table));
         }while(rs.next());
            FrameComponents guiComp = new FrameComponents();
            table.setFont(guiComp.componentFont);
            
         /*
         table.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                try {
                String y = (String) table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn());
                
                    DisplayValues b = new DisplayValues();
                    new DisplayPanel().searchLabel.setText(b.DisplayValues(y));
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
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++){
       switch(column){
            case 1:
                columnNames.add("Student Number");
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
            case 7:
                columnNames.add("Email Address");
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
