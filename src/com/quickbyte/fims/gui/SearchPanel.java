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
import com.quickbyte.fims.data.Search;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchPanel{
    
    public JPanel containerPanel = new JPanel(new BorderLayout(5, 5)),
                  searchEnginePanel,
                  resultsPanel;
    
    public JScrollPane resultsPane;
    
    public JLabel searchLabel;
    
    public JTextField searchField;
    
    public JButton searchButton;
    
     
            
    
    public SearchPanel(){
        
        FrameComponents compGui = new FrameComponents();
        searchLabel = new JLabel(" Search: ");
        compGui.LabelProperties(searchLabel);
        searchLabel.setOpaque(false);
        searchLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        
        searchField = new JTextField("Search student...");
        searchField.setFont(compGui.componentFont);
        searchField.setForeground(Color.GRAY);
        
        searchButton = new JButton();
        searchButton.setIcon(compGui.searchIcon);
        compGui.ButtonProperties(searchButton);
        searchButton.setVerticalTextPosition(SwingConstants.EAST);
        searchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                try {
                    searchButtonActionPerformed(e);
                } catch (ClassNotFoundException ex) {
                    //Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }   
        });
        
        searchEnginePanel = new JPanel(new BorderLayout(5, 5));
        searchEnginePanel.setOpaque(false);
        searchEnginePanel.setBackground(compGui.themeColor4);
        searchEnginePanel.add(searchLabel, BorderLayout.WEST);
        searchEnginePanel.add(searchField, BorderLayout.CENTER);
        searchEnginePanel.add(searchButton, BorderLayout.EAST);
        
        resultsPanel = new JPanel();
        resultsPanel.setOpaque(true);
        resultsPanel.setBackground(Color.WHITE);
        resultsPanel.setLayout(new GridLayout(1, 1, 5, 5));
        resultsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        resultsPanel.setSize(resultsPanel.getMaximumSize());
        
        resultsPane = new JScrollPane(resultsPanel);
        
        containerPanel.setOpaque(true);
        containerPanel.setBackground(compGui.themeColor3);
        containerPanel.add(searchEnginePanel, BorderLayout.NORTH);
        containerPanel.add(resultsPane, BorderLayout.CENTER);
        
        
        
    }
    
    private void searchButtonActionPerformed(ActionEvent e) throws ClassNotFoundException{
        resultsPanel.removeAll();
        resultsPanel.repaint();
        resultsPanel.revalidate();
        Search query = new Search(searchField.getText());
        resultsPanel.add(query.table);
        
    }
    
  
    

    
}
