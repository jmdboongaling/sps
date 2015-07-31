/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchPanel extends FrameComponents{
    
    public JPanel containerPanel = new JPanel(new BorderLayout(5, 5)),
                  searchEnginePanel,
                  resultsPanel;
    
    public JScrollPane resultsPane;
    
    public JLabel searchLabel;
    
    public JTextField searchField;
    
    public JButton searchButton;
    
     
            
    
    public SearchPanel(){
        
        searchLabel = new JLabel(" Search: ");
        LabelProperties(searchLabel);
        searchLabel.setOpaque(false);
        searchLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        
        searchField = new JTextField("Search student...");
        searchField.setFont(componentFont);
        searchField.setForeground(Color.GRAY);
        
        searchButton = new JButton();
        searchButton.setIcon(searchIcon);
        ButtonProperties(searchButton);
        searchButton.setVerticalTextPosition(SwingConstants.EAST);
        
        searchEnginePanel = new JPanel(new BorderLayout(5, 5));
        searchEnginePanel.setOpaque(false);
        searchEnginePanel.setBackground(themeColor4);
        searchEnginePanel.add(searchLabel, BorderLayout.WEST);
        searchEnginePanel.add(searchField, BorderLayout.CENTER);
        searchEnginePanel.add(searchButton, BorderLayout.EAST);
        
        resultsPanel = new JPanel();
        resultsPanel.setOpaque(true);
        resultsPanel.setBackground(Color.WHITE);
        resultsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        resultsPanel.setSize(getMaximumSize());
        
        resultsPane = new JScrollPane(resultsPanel);
        
        containerPanel.setOpaque(true);
        containerPanel.setBackground(themeColor3);
        containerPanel.add(searchEnginePanel, BorderLayout.NORTH);
        containerPanel.add(resultsPane, BorderLayout.CENTER);
        
        
        
    }
    

    
}
