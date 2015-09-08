/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;


public class ScheduleSession extends JFrame{
    
    private JComboBox monthList,
                  dayList,
                  yearList;
    private JSlider timePicker;
    
    private JPanel datePanel;
    
    public void scheduleSession(String studentNumber, String studentName) throws NullPointerException{
        
        monthList = new JComboBox(new String[]{"January", "February"});
        dayList = new JComboBox(new String[]{"10", "11"});
        yearList = new JComboBox(new String[]{"2015", "2016"});
        datePanel = new JPanel(new BorderLayout(5, 5));
        datePanel.add(monthList, BorderLayout.WEST);
        datePanel.add(dayList,  BorderLayout.CENTER);
        datePanel.add(yearList, BorderLayout.EAST);
        
        timePicker = new JSlider();
        
        setLayout(new GridLayout(5, 1, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Schedule counselling session for: "));
        add(new JLabel("Student Number: " + studentNumber));
        add(new JLabel("Name: " + studentName));
        add(datePanel);
        add(timePicker);
        pack();
        setVisible(true);
    }
    
    
    
}
