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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class ControlPanel {
    //SystemFrame sF = new SystemFrame();
    public JPanel controlPanel = new JPanel(new GridLayout(5, 1 ,5, 5));
    
    private final JButton logoutButton,
                          scheduleSession,
                          optionsButton,
                          helpButton,
                          qbAdminButton;
    
    public ControlPanel(){
        
        FrameComponents guiComp = new FrameComponents();
        logoutButton = new JButton();
        logoutButton.setIcon(guiComp.logoutIcon);
        guiComp.ButtonProperties(logoutButton, "Logout");
        logoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){         
                try {     
                    logoutButtonActionPerformed(e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }      
        });
                
        scheduleSession = new JButton();
        scheduleSession.setIcon(guiComp.addUserIcon);
        guiComp.ButtonProperties(scheduleSession, "Schedule Session");
        scheduleSession.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                scheduleSessionActionPerformed(e);
            }     
        });
                
        optionsButton = new JButton();
        optionsButton.setIcon(guiComp.optionsIcon);
        guiComp.ButtonProperties(optionsButton, "Options");
        optionsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                optionsButtonActionPerformed(e);
            }
        });
                
        helpButton = new JButton();
        helpButton.setIcon(guiComp.helpIcon);
        guiComp.ButtonProperties(helpButton, "Help");
        helpButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                helpButtonActionPerformed(e);
            }
        });
                
        qbAdminButton = new JButton();
        qbAdminButton.setIcon(guiComp.qbAdminIcon);
        guiComp.ButtonProperties(qbAdminButton, "QB Admin");
        qbAdminButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                qbAdminButtonActionPerformed(e);
            }
        });   
        
        controlPanel.setOpaque(false);

        controlPanel.add(logoutButton);
        controlPanel.add(scheduleSession);
        controlPanel.add(optionsButton);
        controlPanel.add(qbAdminButton);
        controlPanel.add(helpButton);
        
    }
    
    private void logoutButtonActionPerformed(ActionEvent e) throws ClassNotFoundException{
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
    private void scheduleSessionActionPerformed(ActionEvent e){
        new AddUser();
    }
    private void optionsButtonActionPerformed(ActionEvent e){
        
    }
    private void helpButtonActionPerformed(ActionEvent e){
        
    }
    private void qbAdminButtonActionPerformed(ActionEvent e){
        
    }
                
}
