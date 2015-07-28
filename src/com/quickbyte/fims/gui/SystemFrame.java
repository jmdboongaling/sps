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


public class SystemFrame extends FrameComponents{
    
    private JButton libraryButton,
                    laboratoryButton,
                    adminButton;
    private JPanel northPanel,
                   southPanel,
                   centerPanel;
    
    private JLabel headerLabel1,
                   headerLabel2,
                   headerLabel3;
                   
            
    public SystemFrame(){
        
        
        initComponents();
        
    }
    
    private void initComponents(){
        

        Library libComponent = new Library();
        libComponent.initComponents();
        
        headerLabel1 = new JLabel("Inventory");
        headerLabel1.setFont(headerFont);
        headerLabel1.setForeground(themeColor4);
        
        headerLabel2 = new JLabel("     Management");
        headerLabel2.setFont(headerFont);
        headerLabel2.setForeground(themeColor4);
        
        headerLabel3 = new JLabel("         System");
        headerLabel3.setFont(headerFont);
        headerLabel3.setForeground(themeColor4);
        
        libraryButton = new JButton("Library");
        ButtonProperties(libraryButton);
        
        laboratoryButton = new JButton("Laboratory");
        ButtonProperties(laboratoryButton);
        
        adminButton = new JButton("Admin");
        ButtonProperties(adminButton);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        buttonPanel.setOpaque(true);
        buttonPanel.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        buttonPanel.add(libraryButton);
        buttonPanel.add(laboratoryButton);
        buttonPanel.add(adminButton);
        
        northPanel = new JPanel();
        northPanel.setBackground(themeColor2);
        northPanel.setOpaque(true);
        northPanel.setLayout(new BorderLayout(5, 5));
        northPanel.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        northPanel.add(headerLabel1, BorderLayout.NORTH);
        northPanel.add(headerLabel2, BorderLayout.CENTER);
        northPanel.add(headerLabel3, BorderLayout.SOUTH);
        northPanel.add(buttonPanel, BorderLayout.EAST);
        JPanel fillerPanel1 = new JPanel();
        fillerPanel1.setBackground(themeColor1);
        fillerPanel1.setOpaque(true);
        centerPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        centerPanel.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        centerPanel.setOpaque(false);
        centerPanel.add(libComponent.libraryPanel);
        centerPanel.add(libComponent.searchPanel1);
        FrameComponents();
        //setSize(100, 100);
        setExtendedState(super.MAXIMIZED_BOTH);
        setResizable(false);
        JPanel container = new JPanel(new BorderLayout(5, 5));
        container.setBorder(new MatteBorder(5, 5, 5, 5, Color.WHITE));
        container.add(northPanel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);
        
        add(container);
        
    }
    
    private void navigationBar(){
        
    }
    
    public static void main(String[]args){
        new SystemFrame();
    }
    
    
}
