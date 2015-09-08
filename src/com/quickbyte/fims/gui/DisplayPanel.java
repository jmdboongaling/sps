/*
  ____        _      _    ____        _       
 / __ \      (_)    | |  |  _ \      | |      
| |  | |_   _ _  ___| | _| |_) |_   _| |_ ___ 
| |  | | | | | |/ __| |/ /  _ <| | | | __/ _ \
| |__| | |_| | | (__|   <| |_) | |_| | ||  __/
 \___\_\\__,_|_|\___|_|\_\____/ \__, |\__\___|
                                 __/ |        
                                |___/         
  _____                          
 / ____|                         
| (___   ___  _   _ _ __ ___ ___ 
 \___ \ / _ \| | | | '__/ __/ _ \
 ____) | (_) | |_| | | | (_|  __/
|_____/ \___/ \__,_|_|  \___\___|

Author: Joshua Myron Deidre D. Boongaling
Last Edit: 8-02-2015 
Edited by: Joshua Myron Deidre D. Boongaling
*/

package com.quickbyte.fims.gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.quickbyte.fims.data.DisplayValues;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class DisplayPanel{
    
    public static JPanel containerPanel = new JPanel(new BorderLayout(5, 5)),
                         recordPanel = new JPanel(new BorderLayout(5, 5)),
                         labelPanel = new JPanel(new GridLayout(19, 1, 5, 5)),
                         fieldPanel = new JPanel(new GridLayout(19, 1, 5, 5)),
                         buttonPanel = new JPanel(new GridLayout(1, 3, 5, 0));
    
    public JScrollPane resultsPane;
    
    private static JLabel headerLabel,
                          studentFirstName, 
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
                          
    public static JTextField studentFirstNameField, 
                             studentMiddleNameField,
                             studentLastNameField,
                             studentNumberField, 
                             studentCourseField, 
                             studentSectionField,
                             studentGenderField,
                             studentEmailField,
                             studentNicknameField,
                             studentPermAddressField,
                             studentPresentAddressField,
                             studentCellNumberField,
                             studentHomeNumberField,
                             studentCivilStatusField,
                             studentReligionField,
                             studentNationalityField,
                             studentBirthdayField,
                             studentBirthplaceField,
                             studentBirthRankField;

             
    
    
    private final JButton updateButton,
                          scheduleButton,
                          printButton;

    
    private final FrameComponents compGui = new FrameComponents();
     
            
    
    public DisplayPanel() throws ClassNotFoundException{
        headerLabel = new JLabel("Student Record");
        headerLabel.setFont(compGui.headerFont);
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        studentNumber = new JLabel("Student Number");
        compGui.LabelProperties(studentNumber);
        studentLastName = new JLabel("Last Name: ");
        compGui.LabelProperties(studentLastName);
        studentFirstName = new JLabel("First Name: "); 
        compGui.LabelProperties(studentFirstName);
        studentMiddleName = new JLabel("Middle Name: "); 
        compGui.LabelProperties(studentMiddleName);
        studentCourse = new JLabel("Course: "); 
        compGui.LabelProperties(studentCourse);
        studentSection = new JLabel("Section: ");
        compGui.LabelProperties(studentSection);
        studentGender = new JLabel("Gender: ");
        compGui.LabelProperties(studentGender);
        studentEmail = new JLabel("Email: ");
        compGui.LabelProperties(studentEmail);
        studentNickname = new JLabel("Nickname: ");
        compGui.LabelProperties(studentNickname);
        studentPermAddress = new JLabel("Permanent Address: ");
        compGui.LabelProperties(studentPermAddress);
        studentPresentAddress = new JLabel("Present Address: ");
        compGui.LabelProperties(studentPresentAddress);
        studentCellNumber = new JLabel("Cellphone Number: ");
        compGui.LabelProperties(studentCellNumber);
        studentHomeNumber = new JLabel("Home Number: ");
        compGui.LabelProperties(studentHomeNumber);
        studentCivilStatus = new JLabel("Civil Status: ");
        compGui.LabelProperties(studentCivilStatus);
        studentReligion = new JLabel("Religion: ");
        compGui.LabelProperties(studentReligion);
        studentNationality = new JLabel("Nationality: ");
        compGui.LabelProperties(studentNationality);
        studentBirthday = new JLabel("Date of Birth: ");
        compGui.LabelProperties(studentBirthday);
        studentBirthplace = new JLabel("Place of Birth: ");
        compGui.LabelProperties(studentBirthplace);
        studentBirthRank = new JLabel("Birth Rank: ");
        compGui.LabelProperties(studentBirthRank);
        
        studentNumberField = new JTextField("Student Number: ");
        compGui.TextFieldProperties(studentNumberField);
        studentLastNameField = new JTextField("Last Name: ");
        compGui.TextFieldProperties(studentLastNameField);
        studentFirstNameField = new JTextField("First Name: "); 
        compGui.TextFieldProperties(studentFirstNameField);
        studentMiddleNameField = new JTextField("Middle Name: "); 
        compGui.TextFieldProperties(studentMiddleNameField);
        studentCourseField = new JTextField("Course: "); 
        compGui.TextFieldProperties(studentCourseField);
        studentSectionField = new JTextField("Section: ");
        compGui.TextFieldProperties(studentSectionField);
        studentGenderField = new JTextField("Gender: ");
        compGui.TextFieldProperties(studentGenderField);
        studentEmailField = new JTextField("Email: ");
        compGui.TextFieldProperties(studentEmailField);
        studentNicknameField = new JTextField("Nickname: ");
        compGui.TextFieldProperties(studentNicknameField);
        studentPermAddressField = new JTextField("Permanent Address: ");
        compGui.TextFieldProperties(studentPermAddressField);
        studentPresentAddressField = new JTextField("Present Address: ");
        compGui.TextFieldProperties(studentPresentAddressField);
        studentCellNumberField = new JTextField("Cellphone Number: ");
        compGui.TextFieldProperties(studentCellNumberField);
        studentHomeNumberField = new JTextField("Home Number: ");
        compGui.TextFieldProperties(studentHomeNumberField);
        studentCivilStatusField = new JTextField("Civil Status: ");
        compGui.TextFieldProperties(studentCivilStatusField);
        studentReligionField = new JTextField("Religion: ");
        compGui.TextFieldProperties(studentReligionField);
        studentNationalityField = new JTextField("Nationality: ");
        compGui.TextFieldProperties(studentNationalityField);
        studentBirthdayField = new JTextField("Date of Birth: ");
        compGui.TextFieldProperties(studentBirthdayField);
        studentBirthplaceField = new JTextField("Place of Birth: ");
        compGui.TextFieldProperties(studentBirthplaceField);
        studentBirthRankField = new JTextField("Birth Rank: ");
        compGui.TextFieldProperties(studentBirthRankField);
        
        studentFirstNameField.setEditable(false); 
        studentMiddleNameField.setEditable(false);
        studentLastNameField.setEditable(false);
        studentNumberField.setEditable(false); 
        studentCourseField.setEditable(false); 
        studentSectionField.setEditable(false);
        studentGenderField.setEditable(false);
        studentEmailField.setEditable(false);
        studentNicknameField.setEditable(false);
        studentPermAddressField.setEditable(false);
        studentPresentAddressField.setEditable(false);
        studentCellNumberField.setEditable(false);
        studentHomeNumberField.setEditable(false);
        studentCivilStatusField.setEditable(false);
        studentReligionField.setEditable(false);
        studentNationalityField.setEditable(false);
        studentBirthdayField.setEditable(false);
        studentBirthplaceField.setEditable(false);
        studentBirthRankField.setEditable(false);
        
        labelPanel.setOpaque(false);
        
        labelPanel.add(studentNumber); 
        labelPanel.add(studentFirstName); 
        labelPanel.add(studentMiddleName);
        labelPanel.add(studentLastName);
        labelPanel.add(studentCourse); 
        labelPanel.add(studentSection);
        labelPanel.add(studentGender);
        labelPanel.add(studentEmail);
        labelPanel.add(studentNickname);
        labelPanel.add(studentPermAddress);
        labelPanel.add(studentPresentAddress);
        labelPanel.add(studentCellNumber);
        labelPanel.add(studentHomeNumber);
        labelPanel.add(studentCivilStatus);
        labelPanel.add(studentReligion);
        labelPanel.add(studentNationality);
        labelPanel.add(studentBirthday);
        labelPanel.add(studentBirthplace);
        labelPanel.add(studentBirthRank);
        
        fieldPanel.setOpaque(false);
        
        fieldPanel.add(studentNumberField);
        fieldPanel.add(studentFirstNameField); 
        fieldPanel.add(studentMiddleNameField);
        fieldPanel.add(studentLastNameField); 
        fieldPanel.add(studentCourseField); 
        fieldPanel.add(studentSectionField);
        fieldPanel.add(studentGenderField);
        fieldPanel.add(studentEmailField);
        fieldPanel.add(studentNicknameField);
        fieldPanel.add(studentPermAddressField);
        fieldPanel.add(studentPresentAddressField);
        fieldPanel.add(studentCellNumberField);
        fieldPanel.add(studentHomeNumberField);
        fieldPanel.add(studentCivilStatusField);
        fieldPanel.add(studentReligionField);
        fieldPanel.add(studentNationalityField);
        fieldPanel.add(studentBirthdayField);
        fieldPanel.add(studentBirthplaceField);
        fieldPanel.add(studentBirthRankField);
        
        updateButton = new JButton("Update");
        updateButton.setIcon(compGui.updateIcon);
        compGui.ButtonProperties(updateButton);
        updateButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        updateButton.setHorizontalTextPosition(SwingConstants.CENTER);
        updateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                updateButtonActionPerformed(e);
            }
        });
        
        scheduleButton = new JButton("Schedule Session");
        scheduleButton.setIcon(compGui.sheduleSessionIcon);
        compGui.ButtonProperties(scheduleButton);
        scheduleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        scheduleButton.setHorizontalTextPosition(SwingConstants.CENTER);
        scheduleButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                scheduleButtonActionPerformed(e);
            }     
        });
        
        printButton = new JButton("Print Form");
        printButton.setIcon(compGui.printIcon);
        compGui.ButtonProperties(printButton);
        printButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        printButton.setHorizontalTextPosition(SwingConstants.CENTER);
        printButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setOpaque(true);
        buttonPanel.add(updateButton);
        buttonPanel.add(scheduleButton);
        buttonPanel.add(printButton);
        
        
        recordPanel.setBackground(Color.WHITE);
        recordPanel.setOpaque(true);
        recordPanel.add(labelPanel, BorderLayout.WEST);
        recordPanel.add(fieldPanel, BorderLayout.CENTER);
        
        JScrollPane recordPane = new JScrollPane(recordPanel);
        recordPane.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        recordPane.setOpaque(false);
        
        containerPanel.add(headerLabel, BorderLayout.NORTH);
        containerPanel.add(recordPane, BorderLayout.CENTER);
        containerPanel.add(buttonPanel, BorderLayout.SOUTH);
       
    }
    
    private void updateButtonActionPerformed(ActionEvent e){
        
        if(studentNumberField.isEditable()){
            studentFirstNameField.setEditable(false); 
            studentMiddleNameField.setEditable(false);
            studentLastNameField.setEditable(false);
            studentNumberField.setEditable(false); 
            studentCourseField.setEditable(false); 
            studentSectionField.setEditable(false);
            studentGenderField.setEditable(false);
            studentEmailField.setEditable(false);
            studentNicknameField.setEditable(false);
            studentPermAddressField.setEditable(false);
            studentPresentAddressField.setEditable(false);
            studentCellNumberField.setEditable(false);
            studentHomeNumberField.setEditable(false);
            studentCivilStatusField.setEditable(false);
            studentReligionField.setEditable(false);
            studentNationalityField.setEditable(false);
            studentBirthdayField.setEditable(false);
            studentBirthplaceField.setEditable(false);
            studentBirthRankField.setEditable(false);
        }else{
            studentFirstNameField.setEditable(true); 
            studentMiddleNameField.setEditable(true);
            studentLastNameField.setEditable(true);
            studentNumberField.setEditable(true); 
            studentCourseField.setEditable(true); 
            studentSectionField.setEditable(true);
            studentGenderField.setEditable(true);
            studentEmailField.setEditable(true);
            studentNicknameField.setEditable(true);
            studentPermAddressField.setEditable(true);
            studentPresentAddressField.setEditable(true);
            studentCellNumberField.setEditable(true);
            studentHomeNumberField.setEditable(true);
            studentCivilStatusField.setEditable(true);
            studentReligionField.setEditable(true);
            studentNationalityField.setEditable(true);
            studentBirthdayField.setEditable(true);
            studentBirthplaceField.setEditable(true);
            studentBirthRankField.setEditable(true);
        }
    }
    
    private void scheduleButtonActionPerformed(ActionEvent e){
        new ScheduleSession().scheduleSession(studentNumberField.getText(), studentLastNameField.getText() + ", " + studentFirstNameField.getText() + " " + studentMiddleNameField.getText());
    }

    
}
