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

import com.quickbyte.fims.data.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class ControlPanel {
    
    public JPanel controlPanel = new JPanel(new GridLayout(3, 1 ,5, 5));
    
    private final JButton logoutButton,
                          optionsButton,
                          helpButton,
                          qbAdminButton;
    private final FrameComponents compGui = new FrameComponents();
    public ControlPanel(){
        
        
        logoutButton = new JButton();
        logoutButton.setIcon(compGui.logoutIcon);
        compGui.ButtonProperties(logoutButton, "Logout");
        logoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){         
                   
                logoutButtonActionPerformed(e);
                
            }      
        });
                
        
                
        optionsButton = new JButton();
        optionsButton.setIcon(compGui.optionsIcon);
        compGui.ButtonProperties(optionsButton, "Options");
        if(LoginAuthentication.userLevel.equals("Administrator")){
            optionsButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    optionsButtonActionPerformed(e);
                }
            });
        }else{
            optionsButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "You do not have the authorization to access this feature!");
                }
            });
        }
        
                
        helpButton = new JButton();
        helpButton.setIcon(compGui.helpIcon);
        compGui.ButtonProperties(helpButton, "Help");
        helpButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                helpButtonActionPerformed(e);
            }
        });
                
        qbAdminButton = new JButton();
        qbAdminButton.setIcon(compGui.qbAdminIcon);
        compGui.ButtonProperties(qbAdminButton, "QB Admin");
        if(LoginAuthentication.userLevel.equals("Administrator")){
            qbAdminButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    qbAdminButtonActionPerformed(e);
                }
            });
        }else{
            qbAdminButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "You do not have the authorization to access this feature!");
                }
            });
        }
        
        controlPanel.setOpaque(false);

        controlPanel.add(logoutButton);
        controlPanel.add(optionsButton);
        //controlPanel.add(qbAdminButton);
        controlPanel.add(helpButton);
        
    }
    
    private void logoutButtonActionPerformed(ActionEvent e){
        int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "QuickByte Software - Lougout", JOptionPane.WARNING_MESSAGE, JOptionPane.OK_CANCEL_OPTION, compGui.logoutIcon);
                if(userChoice == JOptionPane.YES_OPTION){
                    Logout userLogout = new Logout(LoginAuthentication.userName);
                    System.exit(0);
                }
    }
 
    private void optionsButtonActionPerformed(ActionEvent e){
        new Options();
    }
    private void helpButtonActionPerformed(ActionEvent e){
        String[] arg = null;
        UserManual run = new UserManual();
        run.main(arg);
    }
    private void qbAdminButtonActionPerformed(ActionEvent e){
        
    }
                
}
