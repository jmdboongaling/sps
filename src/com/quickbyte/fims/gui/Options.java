/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.gui;

import com.quickbyte.fims.data.DBConnect;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Options extends JFrame{
    
    private JLabel dbURLLabel,
                   dbUsernameLabel,
                   dbPasswordLabel;
    
    private JTextField dbURLField,
                       dbUsernameField;
    
    private JPasswordField dbPasswordField;
    
    private JButton applyButton,
                    cancelButton;
    
    private JList menuBar;
    
    private JPanel dbSettingsPanel,
                   dbLabelsPanel,
                   dbFieldsPanel,
                   showPanel;
    
    private final FrameComponents compGui = new FrameComponents();
    
    public static void main(String[]args){
        new Options().initComponents();
    }
    
    private void initComponents(){
        
        dbURLLabel = new JLabel("Database URL: ");
        compGui.LabelProperties(dbURLLabel);
        dbUsernameLabel = new JLabel("Database Username: ");
        compGui.LabelProperties(dbUsernameLabel);
        dbPasswordLabel = new JLabel("Database Password");
        compGui.LabelProperties(dbPasswordLabel);
        
        dbURLField = new JTextField(35);
        compGui.TextFieldProperties(dbURLField);
        dbURLField.setText("jdbc:postgresql//" + DBConnect.dbURL);
        dbUsernameField = new JTextField(15);
        compGui.TextFieldProperties(dbUsernameField);
        dbUsernameField.setText(DBConnect.dbUsername);
        dbPasswordField = new JPasswordField(15);
        dbPasswordField.setText("*************");
        compGui.TextFieldProperties(dbPasswordField);
        
        dbLabelsPanel = new JPanel(new GridLayout(15, 1, 5, 5));
        dbLabelsPanel.setOpaque(false);
        dbLabelsPanel.add(dbURLLabel);
        dbLabelsPanel.add(dbUsernameLabel);
        dbLabelsPanel.add(dbPasswordLabel);
        
        dbFieldsPanel = new JPanel(new GridLayout(15, 1, 5, 5));
        dbFieldsPanel.setOpaque(false);
        dbFieldsPanel.add(dbURLField);
        dbFieldsPanel.add(dbUsernameField);
        dbFieldsPanel.add(dbPasswordField);
        
        dbSettingsPanel = new JPanel(new BorderLayout());
        dbSettingsPanel.setOpaque(false);
        dbSettingsPanel.add(dbLabelsPanel, BorderLayout.WEST);
        dbSettingsPanel.add(dbFieldsPanel, BorderLayout.CENTER);
        
        CardLayout switchPanel = new CardLayout();
        showPanel = new JPanel();
        showPanel.setLayout(switchPanel);
        showPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        showPanel.add(dbSettingsPanel, "1");
        showPanel.add(new JLabel("Images"), "2");
        DefaultListModel listModel = new DefaultListModel();
        menuBar = new JList(listModel);
        listModel.addElement("Database Settings");
        listModel.addElement("Images Directory");
        menuBar.setBorder(new EmptyBorder(15, 0, 15, 15));
        menuBar.setFont(compGui.componentFont);
        menuBar.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if(menuBar.getSelectedValue().equals("Database Settings")){
                    switchPanel.show(showPanel, "1");
                }else if(menuBar.getSelectedValue().equals("Images Directory")){
                    switchPanel.show(showPanel, "2");
                }
            }
        });
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(menuBar, BorderLayout.WEST);
        add(showPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
