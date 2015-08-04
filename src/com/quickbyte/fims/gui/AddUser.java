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
Last Edit: 5-30-2015
Edited by: Joshua Myron Deidre D. Boongaling
*/

package com.quickbyte.fims.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddUser{
    
    public static JFrame addUserFrame = new JFrame("QuickByte Software - Add Record");
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel infoPanel1 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel2 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel3 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel4 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel5 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel6 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel7 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel8 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel9 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel10 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel11 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel12 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel13 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel14 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel15 = new JPanel(new FlowLayout(FlowLayout.LEADING)),   
                         infoPanel16 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel17 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel18 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel19 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         infoPanel20 = new JPanel(new FlowLayout(FlowLayout.LEADING)),
                         personalInfoPanel = new JPanel(new GridLayout(12, 1, 5, 5)),
                         familyBackgroundPanel = new JPanel(new GridLayout(11, 1, 5, 5)),
                         educationInfoPanel = new JPanel(new GridLayout(1, 1, 5, 5)),
                         othersPanel = new JPanel(new GridLayout(1, 1, 5, 5)),
                         displayPanel = new JPanel(cardLayout),
                         controlBarPanel = new JPanel(new GridLayout(1, 1, 5, 5)),
                         bottomPanel = new JPanel(new GridLayout(2, 1, 5, 5));  
            
    private JLabel nameLabel,
                   courseLabel,
                   yearSectionLabel,
                   emailLabel,
                   nicknameLabel,
                   cellNumberLabel,
                   homeNumberLabel,
                   permanentAddressLabel,
                   presentAddressLabel,
                   genderLabel,
                   civilLabel,
                   religionLabel,
                   nationalityLabel,
                   ageLabel,
                   birthdayLabel,
                   birthplaceLabel,
                   birthrankLabel,
                   spouseLabel,
                   spouseOccupationLabel,
                   marriageDateLabel,
                   marriagePlaceLabel,
                   spouseAgeLabel,
                   spouseEmployerAddressLabel,
                   numberChildrenLabel,
                   fatherNameLabel,
                   fatherAddressLabel,
                   fatherAgeLabel,
                   fatherEducationLabel,
                   fatherCellLabel,
                   fatherOccupationLabel,
                   fatherEmployerAddressLabel,
                   motherNameLabel,
                   motherAddressLabel,
                   motherAgeLabel,
                   motherEducationLabel,
                   motherCellLabel,
                   motherOccupationLabel,
                   motherEmployerAddressLabel,
                   parentsStatusLabel,
                   parentsGrossIncomeLabel;
    
    private JTextField nameTextField1,
                       nameTextField2,
                       nameTextField3,
                       yearSectionTextField,
                       emailTextField,
                       nicknameTextField,
                       cellNumberTextField,
                       homeNumberTextField,
                       permanentAddressTextField,
                       presentAddressTextField,
                       religionTextField,
                       nationalityTextField,
                       ageTextField,
                       birthplaceTextField,
                       spouseTextField,
                       spouseOccupationTextField,
                       marriagePlaceTextField,
                       spouseAgeTextField,
                       spouseEmployerAddressTextField,
                       numberChildrenTextField,
                       fatherNameTextField,
                       fatherAddressTextField,
                       fatherAgeTextField,
                       fatherEducationTextField,
                       fatherCellTextField,
                       fatherOccupationTextField,
                       fatherEmployerAddressTextField,
                       motherNameTextField,
                       motherAddressTextField,
                       motherAgeTextField,
                       motherEducationTextField,
                       motherCellTextField,
                       motherOccupationTextField,
                       motherEmployerAddressTextField,
                       parentsGrossIncomeTextField;
    
    private JButton personalInfoButton,
                    familyBackgroundButton,
                    educationInfoButton,
                    othersButton;
    
    private JComboBox courseList,
                      genderList,
                      monthList,
                      yearList,
                      birthList;
    
    private JRadioButton singleButton,
                         marriedButton,
                         fatherLivingButton,
                         fatherDeceasedButton,
                         motherLivingButton,
                         motherDeceasedButton,
                         parentsMarriedButton,
                         liveinButton,
                         separatedButton,
                         annulledButton,
                         widowButton;
                                 
    
    private JSpinner dayList;
                     
    private ButtonGroup civilStatus,
                        fatherState,
                        motherState,
                        parentsStatus;
    
    private JProgressBar formProgress;
  
    public AddUser(){
        
        initComponents();
    }
    
    private void initComponents(){
        
        FrameComponents guiComp = new FrameComponents();
        
        
        nameLabel = new JLabel("Name ");
        guiComp.LabelProperties(nameLabel);
        nameTextField1 = new JTextField("Last Name", 15);
        nameTextField2 = new JTextField("First Name", 25);
        nameTextField3 = new JTextField("Middle Name", 15);
        nameTextField1.setFont(guiComp.componentFont);
        nameTextField2.setFont(guiComp.componentFont);
        nameTextField3.setFont(guiComp.componentFont);
        
        courseLabel = new JLabel("Course ");
        guiComp.LabelProperties(courseLabel);
        courseList = new JComboBox(new String[]{"Select Course", "BS Nursing", "BS Psychology", "BS Radiologic Technology"});
        courseList.setFont(guiComp.componentFont);

        
        yearSectionLabel = new JLabel("Year/Section ");
        guiComp.LabelProperties(yearSectionLabel);
        yearSectionTextField = new JTextField(5);
        yearSectionTextField.setFont(guiComp.componentFont);
        
        emailLabel = new JLabel("E-Mail Address ");
        guiComp.LabelProperties(emailLabel);
        emailTextField = new JTextField(20);
        emailTextField.setFont(guiComp.componentFont);
        
        nicknameLabel = new JLabel("Nickname ");
        guiComp.LabelProperties(nicknameLabel);
        nicknameTextField = new JTextField(10);
        nicknameTextField.setFont(guiComp.componentFont);
        
        cellNumberLabel = new JLabel("Cellphone # ");
        guiComp.LabelProperties(cellNumberLabel);
        cellNumberTextField = new JTextField(12);
        cellNumberTextField.setFont(guiComp.componentFont);
        
        homeNumberLabel = new JLabel("Home Phone # ");
        guiComp.LabelProperties(homeNumberLabel);
        homeNumberTextField = new JTextField(12);
        homeNumberTextField.setFont(guiComp.componentFont);
        
        permanentAddressLabel = new JLabel("Permanent Address ");
        guiComp.LabelProperties(permanentAddressLabel);
        permanentAddressTextField = new JTextField(60);
        permanentAddressTextField.setFont(guiComp.componentFont);
        
        presentAddressLabel = new JLabel("Present Address ");
        guiComp.LabelProperties(presentAddressLabel);
        presentAddressTextField = new JTextField(60);
        presentAddressTextField.setFont(guiComp.componentFont);
        
        genderLabel = new JLabel("Sex ");
        guiComp.LabelProperties(genderLabel);
        genderList = new JComboBox(new String[]{"Select Gender", "Male", "Female"});
        genderList.setFont(guiComp.componentFont);
        
        civilLabel = new JLabel("Civil Status ");
        guiComp.LabelProperties(civilLabel);
        civilStatus = new ButtonGroup();
        singleButton = new JRadioButton("Single");
        singleButton.setFont(guiComp.componentFont);
        singleButton.setFocusPainted(false);
        marriedButton = new JRadioButton("Married");
        marriedButton.setFont(guiComp.componentFont);
        marriedButton.setFocusPainted(false);
        civilStatus.add(singleButton);
        civilStatus.add(marriedButton);
        
        
        religionLabel = new JLabel("Religion ");
        guiComp.LabelProperties(religionLabel);
        religionTextField = new JTextField(8);
        religionTextField.setFont(guiComp.componentFont);
        
        nationalityLabel = new JLabel("Nationality ");
        guiComp.LabelProperties(nationalityLabel);
        nationalityTextField = new JTextField(8);
        nationalityTextField.setFont(guiComp.componentFont);
        
        ageLabel = new JLabel("Age ");
        guiComp.LabelProperties(ageLabel);
        ageTextField = new JTextField(2);
        ageTextField.setFont(guiComp.componentFont);
        
        birthdayLabel = new JLabel("Date of Birth ");
        guiComp.LabelProperties(birthdayLabel);
        monthList = new JComboBox(new String[]{"Select Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        monthList.setFont(guiComp.componentFont);
        dayList = new JSpinner();
        dayList.setModel(new SpinnerNumberModel(1, 1, 31, 1));
        dayList.setFont(guiComp.componentFont);
        yearList = new JComboBox(new String[]{"Select Year", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"});
        yearList.setFont(guiComp.componentFont);
        
        birthplaceLabel = new JLabel("Place of Birth ");
        guiComp.LabelProperties(birthplaceLabel);
        birthplaceTextField = new JTextField(15);
        birthplaceTextField.setFont(guiComp.componentFont);
        
        birthrankLabel = new JLabel("Birth Rank ");
        guiComp.LabelProperties(birthrankLabel);
        birthList = new JComboBox(new String[]{"Select Birthrank", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th"});
        birthList.setFont(guiComp.componentFont);
        
        spouseLabel = new JLabel("Name of Spouse ");
        guiComp.LabelProperties(spouseLabel);
        spouseTextField = new JTextField(30);
        spouseTextField.setFont(guiComp.componentFont);
        
        spouseOccupationLabel = new JLabel("Occupation ");
        guiComp.LabelProperties(spouseOccupationLabel);
        spouseOccupationTextField = new JTextField(20);
        spouseOccupationTextField.setFont(guiComp.componentFont);
        
        marriageDateLabel = new JLabel("Date of Marriage ");
        guiComp.LabelProperties(marriageDateLabel);
        
        
        marriagePlaceLabel = new JLabel("Place of Marriage ");
        guiComp.LabelProperties(marriagePlaceLabel);
        marriagePlaceTextField = new JTextField(25);
        marriagePlaceTextField.setFont(guiComp.componentFont);
        
        spouseAgeLabel = new JLabel("Age ");
        guiComp.LabelProperties(spouseAgeLabel);
        spouseAgeTextField = new JTextField(2);
        spouseAgeTextField.setFont(guiComp.componentFont);
        
        spouseEmployerAddressLabel = new JLabel("Employer's Address ");
        guiComp.LabelProperties(spouseEmployerAddressLabel);
        spouseEmployerAddressTextField = new JTextField(50);
        spouseEmployerAddressTextField.setFont(guiComp.componentFont);
        
        numberChildrenLabel = new JLabel("# of Children");
        guiComp.LabelProperties(numberChildrenLabel);
        numberChildrenTextField = new JTextField(2);
        numberChildrenTextField.setFont(guiComp.componentFont);
        
        fatherNameLabel = new JLabel("Name of Father ");
        guiComp.LabelProperties(fatherNameLabel);
        fatherNameTextField = new JTextField(60);
        fatherNameTextField.setFont(guiComp.componentFont);
        fatherState = new ButtonGroup();
        fatherLivingButton = new JRadioButton("Living");
        fatherLivingButton.setFont(guiComp.componentFont);
        fatherLivingButton.setFocusPainted(false);
        fatherDeceasedButton = new JRadioButton("Deceased");
        fatherDeceasedButton.setFont(guiComp.componentFont);
        fatherDeceasedButton.setFocusPainted(false);
        fatherState.add(fatherLivingButton);
        fatherState.add(fatherDeceasedButton);
        
        fatherAddressLabel = new JLabel("Address ");
        guiComp.LabelProperties(fatherAddressLabel);
        fatherAddressTextField = new JTextField(80);
        fatherAddressTextField.setFont(guiComp.componentFont);
        
        fatherAgeLabel = new JLabel("Age ");
        guiComp.LabelProperties(fatherAgeLabel);
        fatherAgeTextField = new JTextField(2);
        fatherAgeTextField.setFont(guiComp.componentFont);
        
        fatherEducationLabel = new JLabel("Educational Attainment ");
        guiComp.LabelProperties(fatherEducationLabel);
        fatherEducationTextField = new JTextField(12);
        fatherEducationTextField.setFont(guiComp.componentFont);
        
        fatherCellLabel = new JLabel("Cellphone # ");
        guiComp.LabelProperties(fatherCellLabel);
        fatherCellTextField = new JTextField(12);
        fatherCellTextField.setFont(guiComp.componentFont);
        
        fatherOccupationLabel = new JLabel("Occupation ");
        guiComp.LabelProperties(fatherOccupationLabel);
        fatherOccupationTextField = new JTextField(15);
        fatherOccupationTextField.setFont(guiComp.componentFont);
        
        fatherEmployerAddressLabel = new JLabel("Employer's Address ");
        guiComp.LabelProperties(fatherEmployerAddressLabel);
        fatherEmployerAddressTextField = new JTextField(50);
        fatherEmployerAddressTextField.setFont(guiComp.componentFont);
        
        motherNameLabel = new JLabel("Name of Mother ");
        guiComp.LabelProperties(motherNameLabel);
        motherNameTextField = new JTextField(60);
        motherNameTextField.setFont(guiComp.componentFont);
        motherState = new ButtonGroup();
        motherLivingButton = new JRadioButton("Living");
        motherLivingButton.setFont(guiComp.componentFont);
        motherLivingButton.setFocusPainted(false);
        motherDeceasedButton = new JRadioButton("Deceased");
        motherDeceasedButton.setFont(guiComp.componentFont);
        motherDeceasedButton.setFocusPainted(false);
        motherState.add(motherLivingButton);
        motherState.add(motherDeceasedButton);
        
        motherAddressLabel = new JLabel("Address ");
        guiComp.LabelProperties(motherAddressLabel);
        motherAddressTextField = new JTextField(80);
        motherAddressTextField.setFont(guiComp.componentFont);
        
        motherAgeLabel = new JLabel("Age ");
        guiComp.LabelProperties(motherAgeLabel);
        motherAgeTextField = new JTextField(2);
        motherAgeTextField.setFont(guiComp.componentFont);
        
        motherEducationLabel = new JLabel("Educational Attainment ");
        guiComp.LabelProperties(motherEducationLabel);
        motherEducationTextField = new JTextField(12);
        motherEducationTextField.setFont(guiComp.componentFont);
        
        motherCellLabel = new JLabel("Cellphone # ");
        guiComp.LabelProperties(motherCellLabel);
        motherCellTextField = new JTextField(12);
        motherCellTextField.setFont(guiComp.componentFont);
        
        motherOccupationLabel = new JLabel("Occupation ");
        guiComp.LabelProperties(motherOccupationLabel);
        motherOccupationTextField = new JTextField(15);
        motherOccupationTextField.setFont(guiComp.componentFont);
        
        motherEmployerAddressLabel = new JLabel("Employer's Address ");
        guiComp.LabelProperties(motherEmployerAddressLabel);
        motherEmployerAddressTextField = new JTextField(50);
        motherEmployerAddressTextField.setFont(guiComp.componentFont);
        
        parentsStatusLabel = new JLabel("Status of Parents ");
        guiComp.LabelProperties(parentsStatusLabel);
        parentsStatus = new ButtonGroup();
        parentsMarriedButton = new JRadioButton("Married");
        parentsMarriedButton.setFont(guiComp.componentFont);
        parentsMarriedButton.setFocusPainted(false);
        liveinButton = new JRadioButton("Living-in");
        liveinButton.setFont(guiComp.componentFont);
        liveinButton.setFocusPainted(false);
        separatedButton = new JRadioButton("Separated");
        separatedButton.setFont(guiComp.componentFont);
        separatedButton.setFocusPainted(false);
        annulledButton = new JRadioButton("Annulled");
        annulledButton.setFont(guiComp.componentFont);
        annulledButton.setFocusPainted(false);
        widowButton = new JRadioButton("Widow/Widower");
        widowButton.setFont(guiComp.componentFont);
        widowButton.setFocusPainted(false);
        parentsStatus.add(parentsMarriedButton);
        parentsStatus.add(liveinButton);
        parentsStatus.add(separatedButton);
        parentsStatus.add(annulledButton);
        parentsStatus.add(widowButton);
        
        parentsGrossIncomeLabel = new JLabel("Parents' Economic Status - Estimated Gross Income ");
        guiComp.LabelProperties(parentsGrossIncomeLabel);
        parentsGrossIncomeTextField = new JTextField(12);
        parentsGrossIncomeTextField.setFont(guiComp.componentFont);
        
        formProgress = new JProgressBar(0, 4);
        formProgress.setValue(1);
        formProgress.setBackground(Color.WHITE);
        formProgress.setForeground(Color.GRAY);
        formProgress.setBorderPainted(false);
        //bar.setText();
        personalInfoButton = new JButton("Personal Information");
        guiComp.ButtonProperties(personalInfoButton);
        personalInfoButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout.show(displayPanel, "1");
                formProgress.setValue(1);
            }
            
        });
        
        familyBackgroundButton = new JButton("Family Background");
        guiComp.ButtonProperties(familyBackgroundButton);
        familyBackgroundButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout.show(displayPanel, "2");
                formProgress.setValue(2);
            }
            
        });
        
        educationInfoButton = new JButton("Educational Attainment");
        guiComp.ButtonProperties(educationInfoButton);
        
        othersButton = new JButton("Others");
        guiComp.ButtonProperties(othersButton);
        
        controlBarPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        controlBarPanel.setBackground(Color.WHITE);
        controlBarPanel.add(personalInfoButton);
        controlBarPanel.add(familyBackgroundButton);
        controlBarPanel.add(educationInfoButton);
        controlBarPanel.add(othersButton);
        
        
        bottomPanel.add(formProgress);
        bottomPanel.add(controlBarPanel);
        infoPanel1.add(nameLabel);
        infoPanel1.add(nameTextField1);
        infoPanel1.add(nameTextField2);
        infoPanel1.add(nameTextField3);
        
        infoPanel2.add(courseLabel);
        infoPanel2.add(courseList);
        infoPanel2.add(yearSectionLabel);
        infoPanel2.add(yearSectionTextField);
        infoPanel2.add(emailLabel);
        infoPanel2.add(emailTextField);
              
        infoPanel3.add(nicknameLabel);
        infoPanel3.add(nicknameTextField);
        infoPanel3.add(cellNumberLabel);
        infoPanel3.add(cellNumberTextField);
        infoPanel3.add(homeNumberLabel);
        infoPanel3.add(homeNumberTextField);
        
        infoPanel4.add(permanentAddressLabel);
        infoPanel4.add(permanentAddressTextField);
        
        infoPanel5.add(presentAddressLabel);
        infoPanel5.add(presentAddressTextField);
        
        infoPanel6.add(genderLabel);
        infoPanel6.add(genderList);
        infoPanel6.add(civilLabel);
        infoPanel6.add(singleButton);
        infoPanel6.add(marriedButton);
        infoPanel6.add(religionLabel);
        infoPanel6.add(religionTextField);
        infoPanel6.add(nationalityLabel);
        infoPanel6.add(nationalityTextField);
        
        infoPanel7.add(ageLabel);
        infoPanel7.add(ageTextField);
        infoPanel7.add(birthdayLabel);
        infoPanel7.add(monthList);
        infoPanel7.add(dayList);
        infoPanel7.add(yearList);
        infoPanel7.add(birthplaceLabel);
        infoPanel7.add(birthplaceTextField);
        infoPanel7.add(birthrankLabel);
        infoPanel7.add(birthList);
        
        infoPanel8.add(spouseLabel);
        infoPanel8.add(spouseTextField);
        infoPanel8.add(spouseOccupationLabel);
        infoPanel8.add(spouseOccupationTextField);
       
        //infoPanel9.add(marriageDateLabel);
        //infoPanel9.add(monthList);
        //infoPanel9.add(dayList);
        //infoPanel9.add(yearList);
        infoPanel9.add(marriagePlaceLabel);
        infoPanel9.add(marriagePlaceTextField);
        infoPanel9.add(spouseAgeLabel);
        infoPanel9.add(spouseAgeTextField);
        
        infoPanel10.add(spouseEmployerAddressLabel);
        infoPanel10.add(spouseEmployerAddressTextField);
        infoPanel10.add(numberChildrenLabel);
        infoPanel10.add(numberChildrenTextField);
        
        personalInfoPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        personalInfoPanel.add(infoPanel1);
        personalInfoPanel.add(infoPanel2);
        personalInfoPanel.add(infoPanel3);
        personalInfoPanel.add(infoPanel4);
        personalInfoPanel.add(infoPanel5);
        personalInfoPanel.add(infoPanel6);
        personalInfoPanel.add(infoPanel7);
        JLabel fill = new JLabel("If Married");
        fill.setFont(guiComp.headerFont);
        personalInfoPanel.add(new JSeparator());
        personalInfoPanel.add(fill);
        personalInfoPanel.add(infoPanel8);
        personalInfoPanel.add(infoPanel9);
        personalInfoPanel.add(infoPanel10);
        
        infoPanel11.add(fatherNameLabel);
        infoPanel11.add(fatherNameTextField);
        infoPanel11.add(fatherLivingButton);
        infoPanel11.add(fatherDeceasedButton);
        
        infoPanel12.add(fatherAddressLabel);
        infoPanel12.add(fatherAddressTextField);
        
        infoPanel13.add(fatherAgeLabel);
        infoPanel13.add(fatherAgeTextField);
        infoPanel13.add(fatherEducationLabel);
        infoPanel13.add(fatherEducationTextField);
        infoPanel13.add(fatherCellLabel);
        infoPanel13.add(fatherCellTextField);
        
        infoPanel14.add(fatherOccupationLabel);
        infoPanel14.add(fatherOccupationTextField);
        infoPanel14.add(fatherEmployerAddressLabel);
        infoPanel14.add(fatherEmployerAddressTextField);
       
        infoPanel15.add(motherNameLabel);
        infoPanel15.add(motherNameTextField);
        infoPanel15.add(motherLivingButton);
        infoPanel15.add(motherDeceasedButton);
        
        infoPanel16.add(motherAddressLabel);
        infoPanel16.add(motherAddressTextField);
        
        infoPanel17.add(motherAgeLabel);
        infoPanel17.add(motherAgeTextField);
        infoPanel17.add(motherEducationLabel);
        infoPanel17.add(motherEducationTextField);
        infoPanel17.add(motherCellLabel);
        infoPanel17.add(motherCellTextField);
        
        infoPanel18.add(motherOccupationLabel);
        infoPanel18.add(motherOccupationTextField);
        infoPanel18.add(motherEmployerAddressLabel);
        infoPanel18.add(motherEmployerAddressTextField);
       
        infoPanel19.add(parentsStatusLabel);
        infoPanel19.add(parentsMarriedButton);
        infoPanel19.add(liveinButton);
        infoPanel19.add(separatedButton);
        infoPanel19.add(annulledButton);
        infoPanel19.add(widowButton);
        
        infoPanel20.add(parentsGrossIncomeLabel);
        infoPanel20.add(parentsGrossIncomeTextField);
        
        familyBackgroundPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        familyBackgroundPanel.add(infoPanel11);
        familyBackgroundPanel.add(infoPanel12);
        familyBackgroundPanel.add(infoPanel13);
        familyBackgroundPanel.add(infoPanel14);
        familyBackgroundPanel.add(new JSeparator());
        familyBackgroundPanel.add(infoPanel15);
        familyBackgroundPanel.add(infoPanel16);
        familyBackgroundPanel.add(infoPanel17);
        familyBackgroundPanel.add(infoPanel18);
        familyBackgroundPanel.add(infoPanel19);
        familyBackgroundPanel.add(infoPanel20);
        
        JScrollPane a = new JScrollPane(personalInfoPanel), b = new JScrollPane(familyBackgroundPanel);
        
        
        displayPanel.add(a, "1");
        displayPanel.add(b, "2");
        
        addUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addUserFrame.add(new JLabel(guiComp.addPageBanner), BorderLayout.NORTH);
        addUserFrame.add(displayPanel, BorderLayout.CENTER);
        addUserFrame.add(bottomPanel, BorderLayout.SOUTH);
        addUserFrame.pack();
        
        addUserFrame.setSize(989, 600);
        addUserFrame.setLocationRelativeTo(null);
        addUserFrame.setResizable(false);
        addUserFrame.setVisible(true);
       
        
    }
    
    
    
}
