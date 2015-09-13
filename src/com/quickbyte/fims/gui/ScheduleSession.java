/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.gui;

import com.quickbyte.fims.data.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class ScheduleSession extends JFrame{
    
    private JLabel headerLabel,
                   studentNumberLabel,
                   studentNameLabel,
                   dateLabel,
                   timeLabel;
    
    private JButton submitButton,
                    cancelButton;
    
    private JComboBox monthList,
                      dayList,
                      yearList;
    
    private JSlider timePicker;
    
    private JPanel datePanel,
                   schedulePanel,
                   buttonPanel,
                   containerPanel;
    
    private int currentYear;
                
    private int[] selectedSchedule;
    
    private final FrameComponents compGui = new FrameComponents();
    
    private String studentNumberSelected,
                   sessionScheduler;
    
    public void scheduleSession(String studentNumber, String studentName) throws NullPointerException{
        
        studentNumberSelected = studentNumber;
        sessionScheduler = LoginAuthentication.userName;
        if(studentNumber.equals("")){
            
            JOptionPane.showMessageDialog(null, "No Student Selected!");
            
        }else{
        
            headerLabel = new JLabel("Schedule Session");
            headerLabel.setFont(compGui.headerFont);
            headerLabel.setHorizontalAlignment(0);
            headerLabel.setVerticalAlignment(0);
            headerLabel.setBackground(compGui.themeColor1);
            headerLabel.setForeground(Color.WHITE);
            headerLabel.setOpaque(true);

            studentNumberLabel = new JLabel("Student Number: " + studentNumber);
            compGui.LabelProperties(studentNumberLabel);
            studentNameLabel = new JLabel("Name: " + studentName);
            compGui.LabelProperties(studentNameLabel);
            dateLabel = new JLabel("Date");
            dateLabel.setFont(compGui.headerFont);
            dateLabel.setHorizontalAlignment(0);
            dateLabel.setVerticalAlignment(0);
            timeLabel = new JLabel("Time");
            timeLabel.setFont(compGui.headerFont);
            timeLabel.setHorizontalAlignment(0);
            timeLabel.setVerticalAlignment(0);

            monthList = new JComboBox(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" });
            monthList.setBackground(Color.WHITE);
            monthList.setFont(compGui.componentFont);
            dayList = new JComboBox(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" });
            dayList.setBackground(Color.WHITE);
            dayList.setFont(compGui.componentFont);
            currentYear = Calendar.getInstance().get(1);
            yearList = new JComboBox(new String[] { Integer.toString(currentYear), Integer.toString(currentYear + 1) });
            yearList.setBackground(Color.WHITE);
            yearList.setFont(compGui.componentFont);
            datePanel = new JPanel(new GridLayout(1, 3, 3, 3));
            datePanel.setBackground(Color.WHITE);
            datePanel.setOpaque(true);
            datePanel.add(dayList, "West");
            datePanel.add(monthList, "Center");
            datePanel.add(yearList, "East");

            Hashtable<Integer, JLabel> labels = new Hashtable();
            labels.put(7, new JLabel("7AM"));
            labels.put(8, new JLabel("8AM"));
            labels.put(9, new JLabel("9AM"));
            labels.put(10, new JLabel("10AM"));
            labels.put(11, new JLabel("11AM"));
            labels.put(12, new JLabel("12PM"));
            labels.put(13, new JLabel("1PM"));
            labels.put(14, new JLabel("2PM"));
            labels.put(15, new JLabel("3PM"));
            labels.put(16, new JLabel("4PM"));
            labels.put(17, new JLabel("5PM"));

            timePicker = new JSlider(0, 7, 17, 7);
            timePicker.setFont(compGui.componentFont);
            timePicker.setBackground(Color.WHITE);
            timePicker.setLabelTable(labels);
            timePicker.setPaintLabels(true);
            timePicker.setMinimumSize(timePicker.getMaximumSize());
            timePicker.setPreferredSize(new Dimension(450, 30));

            schedulePanel = new JPanel(new GridLayout(6, 1));
            schedulePanel.setOpaque(false);
            schedulePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            schedulePanel.add(headerLabel);
            schedulePanel.add(studentNumberLabel);
            schedulePanel.add(studentNameLabel);
            schedulePanel.add(dateLabel);
            schedulePanel.add(datePanel);
            schedulePanel.add(timeLabel);
            schedulePanel.add(timePicker);

            submitButton = new JButton("Submit");
            compGui.ButtonProperties(submitButton);
            submitButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    submitButtonActionPerformed(e);
                }
            });
            cancelButton = new JButton("Cancel");
            compGui.ButtonProperties(cancelButton);
            cancelButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    cancelButtonActionPerformed(e);

                }
            });
            buttonPanel = new JPanel(new GridLayout(1, 2, 3, 3));
            buttonPanel.setBorder(new EmptyBorder(0, 5, 5, 5));
            buttonPanel.add(submitButton);
            buttonPanel.add(cancelButton);

            containerPanel = new JPanel(new BorderLayout());
            containerPanel.setOpaque(false);

            containerPanel.add(headerLabel, "North");
            containerPanel.add(schedulePanel, "Center");
            containerPanel.add(buttonPanel, "South");

            setTitle("QuickByte Software - Student Profiling System");
            getContentPane().setBackground(Color.WHITE);
            setDefaultCloseOperation(2);
            setResizable(false);
            add(containerPanel);
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }
    
    public void submitButtonActionPerformed(ActionEvent e){
        selectedSchedule = new int[4];
        selectedSchedule[0] = Integer.parseInt((String) yearList.getSelectedItem());
        switch((String) monthList.getSelectedItem()){
            case "January":
                selectedSchedule[1] = 1;
                break;
            case "February":
                selectedSchedule[1] = 2;
                break;
            case "March":
                selectedSchedule[1] = 3;
                break;
            case "April":
                selectedSchedule[1] = 4;
                break;
            case "May":
                selectedSchedule[1] = 5;
                break;
            case "June":
                selectedSchedule[1] = 6;
                break;
            case "July":
                selectedSchedule[1] = 7;
                break;
            case "August":
                selectedSchedule[1] = 8;
                break;
            case "September":
                selectedSchedule[1] = 9;
                break;
            case "October":
                selectedSchedule[1] = 10;
                break;
            case "November":
                selectedSchedule[1] = 11;
                break;
            case "December":
                selectedSchedule[1] = 12;
                break;
        }
        selectedSchedule[2] = Integer.parseInt((String) dayList.getSelectedItem());
        selectedSchedule[3] = timePicker.getValue();
        
        new Schedule(studentNumberSelected, sessionScheduler, selectedSchedule);
    }
  
     public void cancelButtonActionPerformed(ActionEvent e){
        dispose();
    }
    
    
    
}
