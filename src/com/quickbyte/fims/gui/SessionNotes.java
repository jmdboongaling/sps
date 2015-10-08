
package com.quickbyte.fims.gui;

import com.quickbyte.fims.data.DBConnect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import net.java.dev.designgridlayout.DesignGridLayout;

public class SessionNotes extends JFrame{
    
    private static JLabel studentName,
                          studentCourse,
                          studentSection,
                          sessionReason,
                          sessionStatus,
                          sessionsLabel,
                          behaviorNotesLabel,
                          problemNotesLabel,
                          recommendationNotesLabel;
    
    private String paramPassSessionID,
                   paramPassName;
    
    private JTextArea behaviorNotes,
                      problemNotes,
                      recommendationNotes;
                        
    private JButton newScheduleButton,
                    submitButton,
                    cancelButton,
                    endSession;
    
    private JComboBox studentSessions;
    
    private final FrameComponents compGui = new FrameComponents();
    public SessionNotes(String studentPull){
        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        DesignGridLayout formLayout = new DesignGridLayout(formPanel);
        
        studentName = new JLabel("Name: ");
        compGui.LabelProperties(studentName);
        studentCourse = new JLabel("Course: ");
        compGui.LabelProperties(studentCourse);
        studentSection = new JLabel("Section: ");
        compGui.LabelProperties(studentSection);
        sessionReason = new JLabel("Reason: ");
        compGui.LabelProperties(sessionReason);
        sessionStatus = new JLabel("Status: ");
        compGui.LabelProperties(sessionStatus);
        sessionsLabel = new JLabel("Sessions: ");
        compGui.LabelProperties(sessionsLabel);
        behaviorNotesLabel = new JLabel("Behavior Notes: ");
        compGui.LabelProperties(behaviorNotesLabel);
        problemNotesLabel = new JLabel("Problem Notes: ");
        compGui.LabelProperties(problemNotesLabel);
        recommendationNotesLabel = new JLabel("Recommendation Notes: ");
        compGui.LabelProperties(recommendationNotesLabel);
        
        
        
        behaviorNotes = new JTextArea();
        behaviorNotes.setSize(new Dimension(300, 300));
        behaviorNotes.setFont(compGui.componentFont);
        
        problemNotes = new JTextArea();
        problemNotes.setSize(new Dimension(300, 300));
        problemNotes.setFont(compGui.componentFont);
        
        recommendationNotes = new JTextArea();
        recommendationNotes.setSize(new Dimension(300, 300));
        recommendationNotes.setFont(compGui.componentFont);
        
        newScheduleButton = new JButton("New Schedule");
        compGui.ButtonProperties(newScheduleButton);
        newScheduleButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ScheduleSession().scheduleSession(studentPull, paramPassName);
            }
        });
        
        submitButton = new JButton("Commit Entry");
        compGui.ButtonProperties(submitButton);
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                submitButton(paramPassSessionID);
            }
        });
        
        endSession = new JButton("End Session");
        compGui.ButtonProperties(endSession);
        endSession.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                endSession(paramPassSessionID);
            }
        });
        
        cancelButton = new JButton("Cancel");
        compGui.ButtonProperties(cancelButton);
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        formLayout.row().grid(studentName);
        formLayout.row().grid(studentCourse);
        formLayout.row().grid(studentSection);
        formLayout.row().grid(sessionReason);
        formLayout.row().grid(sessionStatus);
        
        JScrollPane behaviorPane = new JScrollPane(behaviorNotes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane problemPane = new JScrollPane(problemNotes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane recommendationPane = new JScrollPane(recommendationNotes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel fieldPanel = new JPanel();
        DesignGridLayout fieldLayout = new DesignGridLayout(fieldPanel);
        fieldPanel.setOpaque(false);
        fieldLayout.row().grid(sessionsLabel).add(getSessions(studentPull));
        fieldLayout.row().grid(behaviorNotesLabel).add(behaviorPane);
        fieldLayout.row().grid(problemNotesLabel).add(problemPane);
        fieldLayout.row().grid(recommendationNotesLabel).add(recommendationPane);
        fieldLayout.row().center().add(submitButton).add(newScheduleButton).add(endSession).add(cancelButton);
        
        
        
        
        try{
            String SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE STUDENT_NO = ?";
            PreparedStatement queryStatement = DBConnect.dbConnect().prepareStatement(SQL);
            queryStatement.setString(1, studentPull);
            ResultSet rs = queryStatement.executeQuery();
            if(rs.next()){
                
                paramPassName = rs.getString("LAST_NAME") + ", " + rs.getString("FIRST_NAME") + " " + rs.getString("MIDDLE_NAME");
                studentName.setText("Name: " + rs.getString("LAST_NAME") + ", " + rs.getString("FIRST_NAME") + " " + rs.getString("MIDDLE_NAME"));
                studentCourse.setText("Course: " + rs.getString("COURSE"));
                studentSection.setText("Section: " + rs.getString("YEAR_SECTION"));
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setTitle("QuickByte Software - Makati Medical Center College Student Profiling System - Counselling Session");
        setIconImage(compGui.frameIcon.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(700, 600));
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        add(formPanel, BorderLayout.NORTH);
        add(fieldPanel, BorderLayout.CENTER);
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    private JComboBox getSessions(String studentPull){
        ArrayList<String> listModel = new ArrayList<>();
        
        String SQL = "SELECT * FROM STUDENT_RECORDS.SESSIONS_TABLE WHERE STUDENT_NO = ? ORDER BY SESSION_TIME DESC";
        
        try{
            Connection dbConnect = DBConnect.dbConnect();
            PreparedStatement queryStatement = dbConnect.prepareStatement(SQL);
            queryStatement.setString(1, studentPull);
            ResultSet rs = queryStatement.executeQuery();
            java.util.Date x = new java.util.Date();
            listModel.add("");
            while(rs.next()){
              listModel.add(rs.getString("SESSION_ID") + "     " + new SimpleDateFormat("MMM dd, yyyy 'at' hh aa").format((rs.getTimestamp("SESSION_TIME"))));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        studentSessions = new JComboBox(listModel.toArray());
        studentSessions.setFont(compGui.componentFont);
        studentSessions.setBackground(Color.WHITE);
        studentSessions.addItemListener( new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(studentSessions.getSelectedIndex() != 0){
                    paramPassSessionID = studentSessions.getSelectedItem().toString().substring(0, 7);
                    displayNotes(paramPassSessionID);
                }
            }
        });
        
        
        return studentSessions;
    }
    
    private void displayNotes(String sessionID){
        String SQL = "SELECT * FROM STUDENT_RECORDS.SESSIONS_TABLE WHERE SESSION_ID = ?";
        
        try{
            Connection dbConnect = DBConnect.dbConnect();
            PreparedStatement queryStatement = dbConnect.prepareStatement(SQL);
            queryStatement.setString(1, sessionID);
            ResultSet rs = queryStatement.executeQuery();
            if(rs.next()){
                
                sessionReason.setText("Reason: " + rs.getString("SESSION_REASON"));
                if(rs.getBoolean("SESSION_ONGOING")){
                    sessionStatus.setText("Status: Active");
                }else{
                    sessionStatus.setText("Status: Closed");
                }
                behaviorNotes.setText(rs.getString("BEHAVIOR_NOTES"));
                problemNotes.setText(rs.getString("PROBLEM_NOTES"));
                recommendationNotes.setText(rs.getString("RECOMMENDATION_NOTES"));
            }else{

            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void submitButton(String studentPull){
        try{
            String SQL = "UPDATE STUDENT_RECORDS.SESSIONS_TABLE SET BEHAVIOR_NOTES = ?, PROBLEM_NOTES = ?, RECOMMENDATION_NOTES = ? WHERE SESSION_ID = ?";
            PreparedStatement queryStatement = DBConnect.dbConnect().prepareStatement(SQL);
            queryStatement.setString(1, behaviorNotes.getText());
            queryStatement.setString(2, problemNotes.getText());
            queryStatement.setString(3, recommendationNotes.getText());
            queryStatement.setString(4, studentPull);
            queryStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Your notes have been added to the records!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void endSession(String studentPull){
        try{
            String SQL = "UPDATE STUDENT_RECORDS.SESSIONS_TABLE SET SESSION_ONGOING = FALSE WHERE SESSION_ID = ?";
            PreparedStatement queryStatement = DBConnect.dbConnect().prepareStatement(SQL);
            queryStatement.setString(1, studentPull);
            queryStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Counselling Session Complete!");
        }catch(ClassNotFoundException | SQLException | HeadlessException e){
        }
    }
    
    

    
    
    
}
