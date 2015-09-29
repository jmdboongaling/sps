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
import com.quickbyte.fims.data.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class SearchPanel{
    
    public JPanel containerPanel = new JPanel(new BorderLayout(5, 5));
     
    private JPanel searchEnginePanel,
                   resultsPanel,
                   notificationsPanel,
                   notificationsHeaderPanel,
                   notificationsButtonPanel;
    
    private JScrollPane resultsPane,
                        sessionsList;
    
    private JLabel searchLabel,
                   notificationsLabel;
    
    private JTextField searchField;
    
    private JButton searchButton,
                    refreshButton,
                    accomplishButton;
    
    private JComboBox categoryChooser;
    
    private String listSelectedValue;

            
    private final static FrameComponents compGui = new FrameComponents();
    public SearchPanel(){

        searchLabel = new JLabel(" Search: ");
        compGui.LabelProperties(searchLabel);
        searchLabel.setOpaque(false);
        searchLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        
        searchField = new JTextField("Search student...");
        searchField.setForeground(Color.GRAY);
        searchField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    searchStudent();
                } catch (SQLException ex) {
                    Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        searchField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e){
                 searchField.setText("");
            }
        });
        searchField.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                try {
                    searchStudent();
                } catch (SQLException ex) {
                    Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        searchButton = new JButton();
        searchButton.setIcon(compGui.searchIcon);
        compGui.ButtonProperties(searchButton);
        searchButton.setVerticalTextPosition(SwingConstants.EAST);
        searchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    searchStudent();
                } catch (SQLException ex) {
                    Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        });
        
        categoryChooser = new JComboBox(new String[] {"Student Number", "Name", "Course", "Section", "E-Mail", "Cellphone Number", "Home Phone Number", "Permanent Address", "Present Address", "Gender", "Civil Status", "Religion", "Nationality", "Age", /*"Date of Birth",*/ "Place of Birth", "Birth Rank", "Parent's Status", "Parent's Annual Income", "Primary School", "Secondary School", "Tertiary School", "Year of Entry", "General Percentile Average"});
        categoryChooser.setFont(compGui.componentFont);
        categoryChooser.setBackground(compGui.themeColor4);
        
        searchEnginePanel = new JPanel(new BorderLayout(5, 5));
        searchEnginePanel.setOpaque(true);
        searchEnginePanel.add(searchLabel, BorderLayout.WEST);
        searchEnginePanel.add(searchField, BorderLayout.CENTER);
        searchEnginePanel.add(searchButton, BorderLayout.EAST);
        searchEnginePanel.add(categoryChooser, BorderLayout.SOUTH);
        
        resultsPanel = new JPanel();
        resultsPanel.setOpaque(true);
        resultsPanel.setBackground(Color.WHITE);
        resultsPanel.setLayout(new GridLayout(1, 1, 5, 5));
        resultsPanel.setSize(resultsPanel.getMaximumSize());
        
        notificationsLabel = new JLabel("Counselling Notifications");
        notificationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        notificationsLabel.setVerticalAlignment(SwingConstants.CENTER);
        notificationsLabel.setFont(compGui.headerFont);
        
        sessionsList = new JScrollPane(getSessions());
        
            
        refreshButton = new JButton(compGui.refreshIcon);
        compGui.ButtonProperties(refreshButton);
        refreshButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                refreshButtonActionPerformed(e);
            }
        });
        
        accomplishButton = new JButton(compGui.accomplishIcon);
        compGui.ButtonProperties(accomplishButton);
        accomplishButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                accomplishButtonActionPerformed(e);
                refreshButtonActionPerformed(e);
            }
        });
        
        notificationsButtonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        notificationsButtonPanel.setOpaque(false);
        notificationsButtonPanel.setBorder(new EmptyBorder(5, 0, 5, 5));
        notificationsButtonPanel.add(refreshButton);
        notificationsButtonPanel.add(accomplishButton);
                
        notificationsHeaderPanel = new JPanel(new BorderLayout());
        notificationsHeaderPanel.setOpaque(false);
        notificationsHeaderPanel.setBorder(new LineBorder(Color.BLACK));
        notificationsHeaderPanel.add(notificationsLabel, BorderLayout.CENTER);
        notificationsHeaderPanel.add(notificationsButtonPanel, BorderLayout.EAST);
        
        
        sessionsList.setOpaque(true);
        sessionsList.setBackground(Color.WHITE);
        sessionsList.setBorder(new EmptyBorder(5, 5, 5, 5));
        notificationsPanel = new JPanel(new BorderLayout());
        notificationsPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        notificationsPanel.add(notificationsHeaderPanel, BorderLayout.NORTH);
        notificationsPanel.add(sessionsList, BorderLayout.CENTER);
        
        
        containerPanel.setOpaque(true);
        containerPanel.setBackground(compGui.themeColor4);
        containerPanel.add(searchEnginePanel, BorderLayout.NORTH);
        containerPanel.add(resultsPanel, BorderLayout.CENTER);
        containerPanel.add(notificationsPanel, BorderLayout.SOUTH);
        
        
        
        
    }
    
 
    private void searchStudent() throws SQLException, ParseException{
        try {
            Search query = new Search(searchField.getText(), categoryChooser.getSelectedItem().toString());
            resultsPanel.removeAll();
            resultsPanel.repaint();
            resultsPanel.revalidate();
            JScrollPane resultsPane = new JScrollPane(query.table);
            resultsPane.setOpaque(true);
            resultsPane.setBorder(null);
            resultsPane.getViewport().setBackground(Color.WHITE);
            resultsPanel.add(resultsPane);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private JList getSessions(){
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> sessionList = new JList<>(listModel);
        sessionList.setFont(compGui.componentFont);
        String SQL = "SELECT * FROM SESSIONS_TABLE ORDER BY SESSION_TIME DESC";
        
        try{
            Connection dbConnect = DBConnect.dbConnect();
            PreparedStatement queryStatement = dbConnect.prepareStatement(SQL);
            ResultSet rs = queryStatement.executeQuery();
            Date x = new Date();
            while(rs.next()){
              String scheduleAccomplished = null;
              if(x.after((Date) Date.from(rs.getTimestamp("SESSION_TIME").toInstant()))){
                  scheduleAccomplished = "MISSED";
              }else if(x.before((Date) Date.from(rs.getTimestamp("SESSION_TIME").toInstant()))){
                  scheduleAccomplished = "OPEN";
              }
                
                listModel.addElement(rs.getString("STUDENT_NO") + "   " + new SimpleDateFormat("MMM dd, yyyy 'at' hh aa").format((rs.getTimestamp("SESSION_TIME"))) + "   Status: "+scheduleAccomplished+"");
            }
            
            sessionList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    listSelectedValue = sessionList.getSelectedValue().toString();
                }else{
                    listSelectedValue = sessionList.getSelectedValue().toString();
                }
            }
        });
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
            
        
        
        //sessionList.setFixedCellHeight(1);
        return sessionList;
    }
    
    public void refreshButtonActionPerformed(ActionEvent e){
        notificationsPanel.removeAll();
        notificationsPanel.repaint();
        notificationsPanel.revalidate();
        
        sessionsList = new JScrollPane(getSessions());
        sessionsList.setOpaque(true);
        sessionsList.setBackground(Color.WHITE);
        sessionsList.setBorder(new EmptyBorder(5, 5, 5, 5));
        notificationsPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        notificationsPanel.add(notificationsHeaderPanel, BorderLayout.NORTH);
        notificationsPanel.add(sessionsList, BorderLayout.CENTER);
    }
    
    private void accomplishButtonActionPerformed(ActionEvent e){
        String SQL = "DELETE FROM SESSIONS_TABLE WHERE STUDENT_NO = ?";
        try{
            Connection dbConnect = DBConnect.dbConnect();
            PreparedStatement queryStatement = dbConnect.prepareStatement(SQL);
            queryStatement.setString(1, listSelectedValue.substring(0, 8));
            queryStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Session removed from database!");
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, err);
            err.printStackTrace();
        }
        
    }
    
  
    

    
}
