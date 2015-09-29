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


import com.quickbyte.fims.data.DBConnect;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.quickbyte.fims.data.DisplayValues;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.LabelAlignment;


public class DisplayPanel{
    
    public static JPanel containerPanel = new JPanel(new BorderLayout(5, 5)),
                         recordPanel = new JPanel(),
                         buttonPanel = new JPanel(new GridLayout(1, 3, 5, 0)),
                         orgPanel = new JPanel(new FlowLayout());
    
    public JScrollPane resultsPane;
    
    private static JLabel headerLabel,
                          personalLabel,
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
                          studentBirthRank,
                          marriedLabel,
                          studentSpouse,
                          studentSpouseOccupation,
                          studentSpouseMarriageDate,
                          studentSpouseMarriagePlace,
                          studentSpouseAge,
                          studentSpouseEmployerAddress,
                          studentNoOfChildren,
                          familyBackground,
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
                          parentsEconomicStatus;
                          
                          
                          
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
                             studentBirthRankField,
                             studentSpouseField,
                             studentSpouseOccupationField,
                             studentSpouseMarriageDateField,
                             studentSpouseMarriagePlaceField,
                             studentSpouseAgeField,
                             studentSpouseEmployerAddressField,
                             studentNoOfChildrenField,
                             fatherNameField,
                             fatherStatusField,
                             fatherAddressField,
                             fatherAgeField,
                             fatherEducationField,
                             fatherCellNumberField,
                             fatherOccupationField,
                             fatherEmployerAddressField,
                             motherNameField,
                             motherStatusField,
                             motherAddressField,
                             motherAgeField,
                             motherEducationField,
                             motherCellNumberField,
                             motherOccupationField,
                             motherEmployerAddressField,
                             parentsStatusField,
                             parentsEconomicStatusField;

             
    
    
    private final JButton updateButton,
                          scheduleButton,
                          printButton;

    
    private final FrameComponents compGui = new FrameComponents();
     
            
    
    public DisplayPanel() throws ClassNotFoundException{
        headerLabel = new JLabel("Student Record");
        headerLabel.setFont(compGui.headerFont);
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        personalLabel = new JLabel("Personal Information");
        personalLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        studentNumber = new JLabel("Student Number: ");
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
        
        marriedLabel = new JLabel("If Married");
        marriedLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        studentSpouse = new JLabel("Name of Spouse: ");
        compGui.LabelProperties(studentSpouse);
        studentSpouseOccupation = new JLabel("Occupation: ");
        compGui.LabelProperties(studentSpouseOccupation);
        studentSpouseMarriageDate = new JLabel("Date of Marriage: ");
        compGui.LabelProperties(studentSpouseMarriageDate);
        studentSpouseMarriagePlace = new JLabel("Place of Marriage: ");
        compGui.LabelProperties(studentSpouseMarriagePlace);
        studentSpouseAge = new JLabel("Age: ");
        compGui.LabelProperties(studentSpouseAge);
        studentSpouseEmployerAddress = new JLabel("Employers's Address");
        compGui.LabelProperties(studentSpouseEmployerAddress);
        studentNoOfChildren = new JLabel("No. of Children: ");
        compGui.LabelProperties(studentNoOfChildren);
        familyBackground = new JLabel("Family Background");
        familyBackground.setFont(new Font("Verdana", Font.BOLD, 25));
        fatherName = new JLabel("Name of Father: ");
        compGui.LabelProperties(fatherName);
        fatherStatus = new JLabel("Status: ");
        compGui.LabelProperties(fatherStatus);
        fatherAddress = new JLabel("Address: ");
        compGui.LabelProperties(fatherAddress);
        fatherAge = new JLabel("Age: ");
        compGui.LabelProperties(fatherAge);
        fatherEducation = new JLabel("Education: ");
        compGui.LabelProperties(fatherEducation);
        fatherCellNumber = new JLabel("Cellphone #: ");
        compGui.LabelProperties(fatherCellNumber);
        fatherOccupation = new JLabel("Occupation: ");
        compGui.LabelProperties(fatherOccupation);
        fatherEmployerAddress = new JLabel("Employer's Address: ");
        compGui.LabelProperties(fatherEmployerAddress);
        motherName = new JLabel("Name of Mother: ");
        compGui.LabelProperties(motherName);
        motherStatus = new JLabel("Status: ");
        compGui.LabelProperties(motherStatus);
        motherAddress = new JLabel("Address: ");
        compGui.LabelProperties(motherAddress);
        motherAge = new JLabel("Age: ");
        compGui.LabelProperties(motherAge);
        motherEducation = new JLabel("Education: ");
        compGui.LabelProperties(motherEducation);
        motherCellNumber = new JLabel("Cellphone #: ");
        compGui.LabelProperties(motherCellNumber);
        motherOccupation = new JLabel("Occupation: ");
        compGui.LabelProperties(motherOccupation);
        motherEmployerAddress = new JLabel("Employer's Address: ");
        compGui.LabelProperties(motherEmployerAddress);
        parentsStatus = new JLabel("Status of Parents: ");
        compGui.LabelProperties(parentsStatus);
        parentsEconomicStatus = new JLabel("Parent's Economic Status: ");
        compGui.LabelProperties(parentsEconomicStatus);
        
        
        
        studentNumberField = new JTextField();
        compGui.TextFieldProperties(studentNumberField);
        studentCourseField = new JTextField(); 
        compGui.TextFieldProperties(studentCourseField);
        studentSectionField = new JTextField();
        compGui.TextFieldProperties(studentSectionField);
        studentLastNameField = new JTextField();
        compGui.TextFieldProperties(studentLastNameField);
        studentFirstNameField = new JTextField(); 
        compGui.TextFieldProperties(studentFirstNameField);
        studentMiddleNameField = new JTextField(); 
        compGui.TextFieldProperties(studentMiddleNameField);
        studentGenderField = new JTextField();
        compGui.TextFieldProperties(studentGenderField);
        studentEmailField = new JTextField();
        compGui.TextFieldProperties(studentEmailField);
        studentNicknameField = new JTextField();
        compGui.TextFieldProperties(studentNicknameField);
        studentPermAddressField = new JTextField();
        compGui.TextFieldProperties(studentPermAddressField);
        studentPresentAddressField = new JTextField();
        compGui.TextFieldProperties(studentPresentAddressField);
        studentCellNumberField = new JTextField();
        compGui.TextFieldProperties(studentCellNumberField);
        studentHomeNumberField = new JTextField();
        compGui.TextFieldProperties(studentHomeNumberField);
        studentCivilStatusField = new JTextField();
        compGui.TextFieldProperties(studentCivilStatusField);
        studentReligionField = new JTextField();
        compGui.TextFieldProperties(studentReligionField);
        studentNationalityField = new JTextField();
        compGui.TextFieldProperties(studentNationalityField);
        studentBirthdayField = new JTextField();
        compGui.TextFieldProperties(studentBirthdayField);
        studentBirthplaceField = new JTextField();
        compGui.TextFieldProperties(studentBirthplaceField);
        studentBirthRankField = new JTextField();
        compGui.TextFieldProperties(studentBirthRankField);
        
        studentSpouseField = new JTextField();
        compGui.TextFieldProperties(studentSpouseField);
        studentSpouseOccupationField = new JTextField();
        compGui.TextFieldProperties(studentSpouseOccupationField);
        studentSpouseMarriageDateField = new JTextField();
        compGui.TextFieldProperties(studentSpouseMarriageDateField);
        studentSpouseMarriagePlaceField = new JTextField();
        compGui.TextFieldProperties(studentSpouseMarriagePlaceField);
        studentSpouseAgeField = new JTextField();
        compGui.TextFieldProperties(studentSpouseAgeField);
        studentSpouseEmployerAddressField = new JTextField();
        compGui.TextFieldProperties(studentSpouseEmployerAddressField);
        studentNoOfChildrenField = new JTextField();
        compGui.TextFieldProperties(studentNoOfChildrenField);
        
        fatherNameField = new JTextField();
        compGui.TextFieldProperties(fatherNameField);
        fatherStatusField = new JTextField();
        compGui.TextFieldProperties(fatherStatusField);
        fatherAddressField = new JTextField();
        compGui.TextFieldProperties(fatherAddressField);
        fatherAgeField = new JTextField();
        compGui.TextFieldProperties(fatherAgeField);
        fatherEducationField = new JTextField();
        compGui.TextFieldProperties(fatherEducationField);
        fatherCellNumberField = new JTextField();
        compGui.TextFieldProperties(fatherCellNumberField);
        fatherOccupationField = new JTextField();
        compGui.TextFieldProperties(fatherOccupationField);
        fatherEmployerAddressField = new JTextField();
        compGui.TextFieldProperties(fatherEmployerAddressField);
        motherNameField = new JTextField();
        compGui.TextFieldProperties(motherNameField);
        motherStatusField = new JTextField();
        compGui.TextFieldProperties(motherStatusField);
        motherAddressField = new JTextField();
        compGui.TextFieldProperties(motherAddressField);
        motherAgeField = new JTextField();
        compGui.TextFieldProperties(motherAgeField);
        motherEducationField = new JTextField();
        compGui.TextFieldProperties(motherEducationField);
        motherCellNumberField = new JTextField();
        compGui.TextFieldProperties(motherCellNumberField);
        motherOccupationField = new JTextField();
        compGui.TextFieldProperties(motherOccupationField);
        motherEmployerAddressField = new JTextField();
        compGui.TextFieldProperties(motherEmployerAddressField);
        parentsStatusField = new JTextField();
        compGui.TextFieldProperties(parentsStatusField);
        parentsEconomicStatusField = new JTextField();
        compGui.TextFieldProperties(parentsEconomicStatusField);
        
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
        studentSpouseField.setEditable(false);
        studentSpouseOccupationField.setEditable(false);
        studentSpouseMarriageDateField.setEditable(false);
        studentSpouseMarriagePlaceField.setEditable(false);
        studentSpouseAgeField.setEditable(false);
        studentSpouseEmployerAddressField.setEditable(false);
        studentNoOfChildrenField.setEditable(false);
        fatherNameField.setEditable(false);
        fatherStatusField.setEditable(false);
        fatherAddressField.setEditable(false);
        fatherAgeField.setEditable(false);
        fatherEducationField.setEditable(false);
        fatherCellNumberField.setEditable(false);
        fatherOccupationField.setEditable(false);
        fatherEmployerAddressField.setEditable(false);
        motherNameField.setEditable(false);
        motherStatusField.setEditable(false);
        motherAddressField.setEditable(false);
        motherAgeField.setEditable(false);
        motherEducationField.setEditable(false);
        motherCellNumberField.setEditable(false);
        motherOccupationField.setEditable(false);
        motherEmployerAddressField.setEditable(false);
        parentsStatusField.setEditable(false);
        parentsEconomicStatusField.setEditable(false);
        
        
        
        recordPanel.setBackground(Color.WHITE);
        recordPanel.setOpaque(true);
        
        DesignGridLayout formLayout = new DesignGridLayout(recordPanel);
        formLayout.disableSmartVerticalResize();
        formLayout.labelAlignment(LabelAlignment.RIGHT);
        formLayout.row().grid().add(personalLabel);
        formLayout.row().grid(studentNumber).add(studentNumberField);
        formLayout.row().grid(studentCourse).add(studentCourseField);
        formLayout.row().grid(studentSection).add(studentSectionField);
        //;formLayout.row()
        formLayout.row().grid(studentLastName).add(studentLastNameField);
        formLayout.row().grid(studentFirstName).add(studentFirstNameField);
        formLayout.row().grid(studentMiddleName).add(studentMiddleNameField);
        formLayout.row().grid(studentNickname).add(studentNicknameField);
        formLayout.row().grid(studentGender).add(studentGenderField);
        formLayout.row().grid(studentEmail).add(studentEmailField);
        formLayout.row().grid(studentHomeNumber).add(studentHomeNumberField);
        formLayout.row().grid(studentCellNumber).add(studentCellNumberField);
        formLayout.row().grid(studentPermAddress).add(studentPermAddressField);
        formLayout.row().grid(studentPresentAddress).add(studentPresentAddressField);
        formLayout.row().grid(studentCivilStatus).add(studentCivilStatusField);
        formLayout.row().grid(studentReligion).add(studentReligionField);
        formLayout.row().grid(studentNationality).add(studentNationalityField);
        formLayout.row().grid(studentBirthday).add(studentBirthdayField);
        formLayout.row().grid(studentBirthplace).add(studentBirthplaceField);
        formLayout.row().grid(studentBirthRank).add(studentBirthRankField);
        formLayout.emptyRow();
        formLayout.row().grid().add(marriedLabel);
        formLayout.row().grid(studentSpouse).add(studentSpouseField);
        formLayout.row().grid(studentSpouseAge).add(studentSpouseAgeField);
        formLayout.row().grid(studentSpouseOccupation).add(studentSpouseOccupationField);
        formLayout.row().grid(studentSpouseMarriageDate).add(studentSpouseMarriageDateField);
        formLayout.row().grid(studentSpouseMarriagePlace).add(studentSpouseMarriagePlaceField);
        formLayout.row().grid(studentNoOfChildren).add(studentNoOfChildrenField);
        formLayout.row().grid(studentSpouseEmployerAddress).add(studentSpouseEmployerAddressField);
        formLayout.emptyRow();
        formLayout.row().grid().add(familyBackground);
        formLayout.row().grid(fatherName).add(fatherNameField);
        formLayout.row().grid(fatherStatus).add(fatherStatusField);
        formLayout.row().grid(fatherAddress).add(fatherAddressField);
        formLayout.row().grid(fatherAge).add(fatherAgeField);
        formLayout.row().grid(fatherEducation).add(fatherEducationField);
        formLayout.row().grid(fatherCellNumber).add(fatherCellNumberField);
        formLayout.emptyRow();
        formLayout.emptyRow();
        formLayout.row().center().add(new JSeparator());
        formLayout.row().grid(motherName).add(motherNameField);
        formLayout.row().grid(motherStatus).add(motherStatusField);
        formLayout.row().grid(motherAddress).add(motherAddressField);
        formLayout.row().grid(motherAge).add(motherAgeField);
        formLayout.row().grid(motherEducation).add(motherEducationField);
        formLayout.row().grid(motherCellNumber).add(motherCellNumberField);
        
        
        
        
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
                printButtonActionPerformed(e);
            }
        });
        
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setOpaque(true);
        buttonPanel.add(updateButton);
        buttonPanel.add(scheduleButton);
        buttonPanel.add(printButton);
        
        
        
      
        JScrollPane recordPane = new JScrollPane(recordPanel);
        recordPane.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        recordPane.setOpaque(false);
        recordPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        containerPanel.add(headerLabel, BorderLayout.NORTH);
        containerPanel.add(recordPane, BorderLayout.CENTER);
        //containerPanel.add(new JButton("Sessions"), BorderLayout.EAST);
        containerPanel.add(buttonPanel, BorderLayout.SOUTH);
       
    }
    
    private void updateButtonActionPerformed(ActionEvent e){
        if(!studentNumberField.getText().equals("")){
           if(studentCourseField.isEditable()){
                int updateChoice = JOptionPane.showConfirmDialog(null, "Commit changes?", "Update Record", JOptionPane.YES_NO_OPTION);

                if(updateChoice == JOptionPane.YES_OPTION){
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
                    studentSpouseField.setEditable(false);
                    studentSpouseOccupationField.setEditable(false);
                    studentSpouseMarriageDateField.setEditable(false);
                    studentSpouseMarriagePlaceField.setEditable(false);
                    studentSpouseAgeField.setEditable(false);
                    studentSpouseEmployerAddressField.setEditable(false);
                    studentNoOfChildrenField.setEditable(false);
                    fatherNameField.setEditable(false);
                    fatherStatusField.setEditable(false);
                    fatherAddressField.setEditable(false);
                    fatherAgeField.setEditable(false);
                    fatherEducationField.setEditable(false);
                    fatherCellNumberField.setEditable(false);
                    fatherOccupationField.setEditable(false);
                    fatherEmployerAddressField.setEditable(false);
                    motherNameField.setEditable(false);
                    motherStatusField.setEditable(false);
                    motherAddressField.setEditable(false);
                    motherAgeField.setEditable(false);
                    motherEducationField.setEditable(false);
                    motherCellNumberField.setEditable(false);
                    motherOccupationField.setEditable(false);
                    motherEmployerAddressField.setEditable(false);
                    parentsStatusField.setEditable(false);
                    parentsEconomicStatusField.setEditable(false);
                    try{
                        String SQL = "UPDATE STUDENTS_TABLE SET " +
                                     "COURSE = ?, " + 
                                     "YEAR_SECTION = ?, " + 
                                     "EMAIL_ADDRESS = ?, " + 
                                     "PERM_ADDRESS = ?, " + 
                                     "PRESENT_ADDRESS = ?, " + 
                                     "CELL_NUMBER = ?, " + 
                                     "HOME_NUMBER = ?, " + 
                                     "CIVIL_STATUS = ?, " + 
                                     "RELIGION = ?, " + 
                                     "SPOUSE_NAME = ?, " + 
                                     "SPOUSE_OCCUPATION = ?, " + 
                                     "SPOUSE_MARRIAGEDATE = ?, " + 
                                     "SPOUSE_MARRIAGEPLACE = ?, " + 
                                     "SPOUSE_EMPADDRESS = ?, " + 
                                     "SPOUSE_NUMCHILDREN = ?, " + 
                                     "FATHER_NAME = ?, " + 
                                     "FATHER_STATUS = ?, " + 
                                     "FATHER_ADDRESS = ?, " + 
                                     "FATHER_AGE = ?, " + 
                                     "FATHER_EDUCATION = ?, " +
                                     "FATHER_CELLNUMBER = ?, " +
                                     "FATHER_OCCUPATION = ?, " + 
                                     "FATHER_EMPADDRESS = ?, " + 
                                     "MOTHER_NAME = ?, " + 
                                     "MOTHER_STATUS = ?, " + 
                                     "MOTHER_ADDRESS = ?, " + 
                                     "MOTHER_AGE = ?, " + 
                                     "MOTHER_EDUCATION = ?, " + 
                                     "MOTHER_CELLNUMBER = ?, " + 
                                     "MOTHER_OCCUPATION = ?, " + 
                                     "MOTHER_EMPADDRESS = ?, " + 
                                     "PARENTS_STATUS = ?, " + 
                                     "PARENTS_INCOME = ? " + 
                                     " WHERE STUDENT_NO = ?";
                        Connection dbConnection = DBConnect.dbConnect();
                        PreparedStatement queryStatement = dbConnection.prepareStatement(SQL);
                        queryStatement.setString(1, studentCourseField.getText());
                        queryStatement.setString(2, studentSectionField.getText());
                        queryStatement.setString(3, studentEmailField.getText());
                        queryStatement.setString(4, studentPermAddressField.getText());
                        queryStatement.setString(5, studentPresentAddressField.getText());
                        queryStatement.setString(6, studentCellNumberField.getText());
                        queryStatement.setString(7, studentHomeNumberField.getText());
                        queryStatement.setString(8, studentCivilStatusField.getText());
                        queryStatement.setString(9, studentReligionField.getText());
                        queryStatement.setString(10, studentSpouseField.getText());
                        queryStatement.setString(11, studentSpouseOccupationField.getText());
                        if(!studentSpouseMarriageDateField.getText().equals("")){
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-mm");
                            java.util.Date parsed = format.parse(studentSpouseMarriageDateField.getText());
                            queryStatement.setDate(12, new java.sql.Date(parsed.getTime())); 
                        }else{
                            queryStatement.setDate(12, null); 
                        }
                        
                        queryStatement.setString(13, studentSpouseMarriagePlaceField.getText());
                        queryStatement.setString(14, studentSpouseEmployerAddressField.getText());
                        queryStatement.setString(15, studentNoOfChildrenField.getText());
                        queryStatement.setString(16, fatherNameField.getText());
                        queryStatement.setString(17, fatherStatusField.getText());
                        queryStatement.setString(18, fatherAddressField.getText());
                        queryStatement.setString(19, fatherAgeField.getText());
                        queryStatement.setString(20, fatherEducationField.getText());
                        queryStatement.setString(21, fatherCellNumberField.getText());
                        queryStatement.setString(22, fatherOccupationField.getText());
                        queryStatement.setString(23, fatherEmployerAddressField.getText());
                        queryStatement.setString(24, motherNameField.getText());
                        queryStatement.setString(25, motherStatusField.getText());
                        queryStatement.setString(26, motherAddressField.getText());
                        queryStatement.setString(27, motherAgeField.getText());
                        queryStatement.setString(28, motherEducationField.getText());
                        queryStatement.setString(29, motherCellNumberField.getText());
                        queryStatement.setString(30, motherOccupationField.getText());
                        queryStatement.setString(31, motherEmployerAddressField.getText());
                        queryStatement.setString(32, parentsStatusField.getText());
                        queryStatement.setInt(33, Integer.parseInt(parentsEconomicStatusField.getText()));
                        queryStatement.setString(34, studentNumberField.getText());
                        queryStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record Updated!");

                    }catch(Exception err){
                        err.printStackTrace();
                    }
                }else{
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
                    studentSpouseField.setEditable(false);
                    studentSpouseOccupationField.setEditable(false);
                    studentSpouseMarriageDateField.setEditable(false);
                    studentSpouseMarriagePlaceField.setEditable(false);
                    studentSpouseAgeField.setEditable(false);
                    studentSpouseEmployerAddressField.setEditable(false);
                    studentNoOfChildrenField.setEditable(false);
                    fatherNameField.setEditable(false);
                    fatherStatusField.setEditable(false);
                    fatherAddressField.setEditable(false);
                    fatherAgeField.setEditable(false);
                    fatherEducationField.setEditable(false);
                    fatherCellNumberField.setEditable(false);
                    fatherOccupationField.setEditable(false);
                    fatherEmployerAddressField.setEditable(false);
                    motherNameField.setEditable(false);
                    motherStatusField.setEditable(false);
                    motherAddressField.setEditable(false);
                    motherAgeField.setEditable(false);
                    motherEducationField.setEditable(false);
                    motherCellNumberField.setEditable(false);
                    motherOccupationField.setEditable(false);
                    motherEmployerAddressField.setEditable(false);
                    parentsStatusField.setEditable(false);
                    parentsEconomicStatusField.setEditable(false);
                }

            }else{
                studentCourseField.setEditable(true); 
                studentSectionField.setEditable(true);
                studentEmailField.setEditable(true);        
                studentPermAddressField.setEditable(true);
                studentPresentAddressField.setEditable(true);
                studentCellNumberField.setEditable(true);
                studentHomeNumberField.setEditable(true);
                studentCivilStatusField.setEditable(true);
                studentReligionField.setEditable(true);
                studentSpouseField.setEditable(true);
                studentSpouseOccupationField.setEditable(true);
                studentSpouseMarriageDateField.setEditable(true);
                studentSpouseMarriagePlaceField.setEditable(true);
                studentSpouseAgeField.setEditable(true);
                studentSpouseEmployerAddressField.setEditable(true);
                studentNoOfChildrenField.setEditable(true);
                fatherNameField.setEditable(true);
                fatherStatusField.setEditable(true);
                fatherAddressField.setEditable(true);
                fatherAgeField.setEditable(true);
                fatherEducationField.setEditable(true);
                fatherCellNumberField.setEditable(true);
                fatherOccupationField.setEditable(true);
                fatherEmployerAddressField.setEditable(true);
                motherNameField.setEditable(true);
                motherStatusField.setEditable(true);
                motherAddressField.setEditable(true);
                motherAgeField.setEditable(true);
                motherEducationField.setEditable(true);
                motherCellNumberField.setEditable(true);
                motherOccupationField.setEditable(true);
                motherEmployerAddressField.setEditable(true);
                parentsStatusField.setEditable(true);
                parentsEconomicStatusField.setEditable(true);
            } 
        }
        
    }
    
    private void scheduleButtonActionPerformed(ActionEvent e){
        new ScheduleSession().scheduleSession(studentNumberField.getText(), studentLastNameField.getText() + ", " + studentFirstNameField.getText() + " " + studentMiddleNameField.getText());
    }
    
    private void printButtonActionPerformed(ActionEvent e){
        new Print(studentNumberField.getText());
    }

    
}
