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

public class DisplayPanel{
    
    public static JPanel containerPanel = new JPanel(new GridLayout(16, 1, 5, 5));
                  //searchEnginePanel,
                  //resultsPanel;
    
    public JScrollPane resultsPane;
    
    public static JLabel searchLabel;
    
    public JTextField searchField;
    
    public JButton searchButton;
    
     
            
    
    public DisplayPanel() throws ClassNotFoundException{
        searchLabel = new JLabel("Hello");
        //DisplayValues o = new DisplayValues();
        //searchLabel.setText(o.DisplayValues());
        containerPanel.add(searchLabel);
        containerPanel.add(new JButton("a"));
        containerPanel.setFont(new FrameComponents().componentFont);
        
    }

    
}
