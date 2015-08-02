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

import com.quickbyte.fims.data.LoginAuthentication;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ControlPanel {
    //SystemFrame sF = new SystemFrame();
    public JPanel controlPanel = new JPanel(new GridLayout(5, 1 ,5, 5));
    
    private final JButton logoutButton,
                          addButton,
                          optionsButton,
                          helpButton,
                          qbAdminButton;
    
    public ControlPanel(){
        
        FrameComponents guiComp = new FrameComponents();
        logoutButton = new JButton();
        logoutButton.setIcon(guiComp.logoutIcon);
        guiComp.ButtonProperties(logoutButton, "Logout");
        logoutButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                //SystemFrame callSF = new SystemFrame();
                int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "QuickByte Software - Lougout", JOptionPane.YES_NO_OPTION);
                if(userChoice == JOptionPane.YES_OPTION){
                    //AddUser o = new AddUser();
                    new AddUser().addUserFrame.dispose();
                    new SystemFrame().systemFrame.dispose();
                    
                    Start loopApp = new Start();
                    String[] args = null;
                    loopApp.main(args);
                }       
            }
                    
        });
                
        addButton = new JButton();
        addButton.setIcon(guiComp.addUserIcon);
        guiComp.ButtonProperties(addButton, "Add Student");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                        
               new AddUser();
                        
                        
            }
                    
        });
                
        optionsButton = new JButton();
        optionsButton.setIcon(guiComp.optionsIcon);
        guiComp.ButtonProperties(optionsButton, "Options");
                
        helpButton = new JButton();
        helpButton.setIcon(guiComp.helpIcon);
        guiComp.ButtonProperties(helpButton, "Help");
                
        qbAdminButton = new JButton();
        qbAdminButton.setIcon(guiComp.qbAdminIcon);
        guiComp.ButtonProperties(qbAdminButton, "QB Admin");
                
        //setLayout();
        controlPanel.setOpaque(false);
                //setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.black));
                
       controlPanel.add(logoutButton);
       controlPanel.add(addButton);
       controlPanel.add(optionsButton);
       controlPanel.add(helpButton);
       controlPanel.add(qbAdminButton);
    }
                
}
