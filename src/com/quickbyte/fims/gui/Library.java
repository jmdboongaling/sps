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
Last Edit: 
Edited by: 
*/
package com.quickbyte.fims.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Library extends FrameComponents{
    
    public JButton searchButton,
                    borrowButton,
                    returnButton,
                    searchButton2;
    
    public JLabel refNumberLabel,
                  locationLabel,
                  deweyLabel,
                  titleLabel,
                  authorLabel,
                  publisherLabel,
                  yearPublishedLabel,
                  editionLabel,
                  subjectLabel,
                  isbnLabel,
                  copiesLabel,
                  lastBorrowedLabel,
                  lastBorrowerLabel,
                  dueDateLabel,
                  reservedByLabel,
                  reservedOnLabel,
                  borrowCounterLabel,
                  lastReturnedLabel,
                  statusLabel,
                  notesLabel,
                  searchLabel,
                  headerLabel5;
    
    public JTextField refNumberTextField,
                      locationTextField,
                      titleTextField,
                      authorTextField,
                      publisherTextField,
                      yearPublishedTextField,
                      deweyTextField,
                      subjectTextField,
                      isbnTextField,
                      copiesTextField,
                      editionTextField,
                      lastBorrowedTextField,
                      dueDateTextField,
                      lastBorrowerTextField,
                      reservedByTextField,
                      reservedOnTextField,
                      borrowCounterTextField,
                      lastReturnedTextField,
                      statusTextField,
                      searchTextField;
    
    public JTextArea notesTextField;
    
    public JPanel libraryLabelPanel,
                  libraryFieldPanel,
                  libraryButtonsPanel,
                  libraryPanel,
                  headerPanel,
                  displayPanel,
                  headerPanel1,
                  fillerPanel1,
                  searchPanel,
                  searchPanel1;
    
    
    public void initComponents(){
        
        refNumberLabel = new JLabel("Ref. Number: ");
        locationLabel = new JLabel("Location: ");
        deweyLabel = new JLabel("Dewey: ");
        titleLabel = new JLabel("Title: ");
        authorLabel = new JLabel("Author: ");
        publisherLabel = new JLabel("Publisher: ");
        yearPublishedLabel = new JLabel("Year Published: ");
        editionLabel = new JLabel("Edition: ");
        subjectLabel = new JLabel("Subject: ");
        isbnLabel = new JLabel("ISBN: ");
        copiesLabel = new JLabel("Copies: ");
        lastBorrowedLabel = new JLabel("Last Borrowed: ");
        lastBorrowerLabel = new JLabel("Last Borrower: ");
        dueDateLabel = new JLabel("Due Date: ");
        reservedByLabel = new JLabel("Reserved by: ");
        reservedOnLabel = new JLabel("Reserved on: ");
        borrowCounterLabel = new JLabel("Borrow Counter: ");
        lastReturnedLabel = new JLabel("Last Returned: ");
        statusLabel = new JLabel("Status: ");
        notesLabel = new JLabel("Notes: ");
        
        LabelProperties(refNumberLabel);
        LabelProperties(locationLabel);
        LabelProperties(deweyLabel);
        LabelProperties(titleLabel);
        LabelProperties(authorLabel);
        LabelProperties(publisherLabel);
        LabelProperties(yearPublishedLabel);
        LabelProperties(editionLabel);
        LabelProperties(subjectLabel);
        LabelProperties(isbnLabel);
        LabelProperties(copiesLabel);
        LabelProperties(lastBorrowedLabel);
        LabelProperties(lastBorrowerLabel);
        LabelProperties(dueDateLabel);
        LabelProperties(reservedByLabel);
        LabelProperties(reservedOnLabel);
        LabelProperties(borrowCounterLabel);
        LabelProperties(lastReturnedLabel);
        LabelProperties(statusLabel);
        LabelProperties(notesLabel);
        
        libraryLabelPanel = new JPanel();
        libraryLabelPanel.setOpaque(false);
        libraryLabelPanel.setLayout(new GridLayout(20, 1, 5, 5));
        libraryLabelPanel.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        libraryLabelPanel.add(refNumberLabel);
        libraryLabelPanel.add(locationLabel);
        libraryLabelPanel.add(deweyLabel);
        libraryLabelPanel.add(titleLabel);
        libraryLabelPanel.add(authorLabel);
        libraryLabelPanel.add(publisherLabel);
        libraryLabelPanel.add(yearPublishedLabel);
        libraryLabelPanel.add(editionLabel);
        libraryLabelPanel.add(subjectLabel);
        libraryLabelPanel.add(isbnLabel);
        libraryLabelPanel.add(copiesLabel);
        libraryLabelPanel.add(lastBorrowedLabel);
        libraryLabelPanel.add(lastBorrowerLabel);
        libraryLabelPanel.add(dueDateLabel);
        libraryLabelPanel.add(reservedByLabel);
        libraryLabelPanel.add(reservedOnLabel);
        libraryLabelPanel.add(borrowCounterLabel);
        libraryLabelPanel.add(lastReturnedLabel);
        libraryLabelPanel.add(statusLabel);
        libraryLabelPanel.add(notesLabel);
        
        refNumberTextField = new JTextField();
        locationTextField = new JTextField();
        deweyTextField = new JTextField();
        titleTextField = new JTextField();
        authorTextField = new JTextField();
        publisherTextField = new JTextField();
        yearPublishedTextField = new JTextField();
        editionTextField = new JTextField();
        subjectTextField = new JTextField();
        isbnTextField = new JTextField();
        copiesTextField = new JTextField();
        lastBorrowedTextField = new JTextField();
        lastBorrowerTextField = new JTextField();
        dueDateTextField = new JTextField();
        reservedByTextField = new JTextField();
        reservedOnTextField = new JTextField();
        borrowCounterTextField = new JTextField();
        lastReturnedTextField = new JTextField();
        statusTextField = new JTextField();
        notesTextField = new JTextArea("NOTES");
        
        libraryFieldPanel = new JPanel();
        libraryFieldPanel.setOpaque(false);
        libraryFieldPanel.setLayout(new GridLayout(20, 1, 5, 5));
        libraryFieldPanel.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        libraryFieldPanel.add(refNumberTextField);
        libraryFieldPanel.add(locationTextField);
        libraryFieldPanel.add(deweyTextField);
        libraryFieldPanel.add(titleTextField);
        libraryFieldPanel.add(authorTextField);
        libraryFieldPanel.add(publisherTextField);
        libraryFieldPanel.add(yearPublishedTextField);
        libraryFieldPanel.add(editionTextField);
        libraryFieldPanel.add(subjectTextField);
        libraryFieldPanel.add(isbnTextField);
        libraryFieldPanel.add(copiesTextField);
        libraryFieldPanel.add(lastBorrowedTextField);
        libraryFieldPanel.add(lastBorrowerTextField);
        libraryFieldPanel.add(dueDateTextField);
        libraryFieldPanel.add(reservedByTextField);
        libraryFieldPanel.add(reservedOnTextField);
        libraryFieldPanel.add(borrowCounterTextField);
        libraryFieldPanel.add(lastReturnedTextField);
        libraryFieldPanel.add(statusTextField);
        libraryFieldPanel.add(notesTextField);
        
        searchButton = new JButton("Search");
        ButtonProperties(searchButton);
        
        borrowButton = new JButton("Borrow");
        ButtonProperties(borrowButton);
        
        returnButton = new JButton("Return");
        ButtonProperties(returnButton);
        
        libraryButtonsPanel = new JPanel();
        libraryButtonsPanel.setOpaque(false);
        libraryButtonsPanel.setLayout(new GridLayout(1, 3, 5, 5));
        libraryButtonsPanel.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        libraryButtonsPanel.add(searchButton);
        libraryButtonsPanel.add(borrowButton);
        libraryButtonsPanel.add(returnButton);
        
        headerPanel = new JPanel();
        headerPanel.setOpaque(true);
        headerPanel.setBackground(themeColor2);
        headerPanel.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        JLabel titleLabel = new JLabel("Library");
        titleLabel.setFont(headerFont);
        titleLabel.setForeground(themeColor4);
        headerPanel.add(titleLabel);
        
        libraryPanel = new JPanel(new BorderLayout(5, 5));
        libraryPanel.setOpaque(false);
        libraryPanel.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        libraryPanel.add(headerPanel, BorderLayout.NORTH);
        libraryPanel.add(libraryLabelPanel, BorderLayout.WEST);
        libraryPanel.add(libraryFieldPanel, BorderLayout.CENTER);
        libraryPanel.add(libraryButtonsPanel, BorderLayout.SOUTH);
        
        searchLabel = new JLabel("Search Inventory: ");
        searchLabel.setFont(componentFont);
        
        searchTextField = new JTextField();
        
        searchButton2 = new JButton("Go");
        ButtonProperties(searchButton2);
        
        searchPanel = new JPanel(new BorderLayout(5, 5));
        searchPanel.add(searchLabel, BorderLayout.WEST);
        searchPanel.add(searchTextField, BorderLayout.CENTER);
        searchPanel.add(searchButton2, BorderLayout.EAST);
        
        headerLabel5 = new JLabel("Search"); 
        headerLabel5.setFont(componentFont);
        headerLabel5.setForeground(themeColor4);
        
        headerPanel1 = new JPanel(new BorderLayout(5, 5));
        headerPanel1.setOpaque(true);
        headerPanel1.setBackground(themeColor2);
        headerPanel1.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        headerPanel1.add(headerLabel5, BorderLayout.NORTH);
        headerPanel1.add(searchPanel, BorderLayout.CENTER);
        
        fillerPanel1 = new JPanel();
        fillerPanel1.setOpaque(true);
        fillerPanel1.setBackground(themeColor3);
        
        
        
        
        searchPanel1 = new JPanel(new BorderLayout(5, 5));
        searchPanel1.setOpaque(false);
        searchPanel1.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        searchPanel1.add(headerPanel1, BorderLayout.NORTH);
        searchPanel1.add(fillerPanel1, BorderLayout.CENTER);

        
        
        
        
        
    }
                   
                   
    
}
