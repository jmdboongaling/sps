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



import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.slidinglayout.SLConfig;
import aurelienribon.slidinglayout.SLKeyframe;
import aurelienribon.slidinglayout.SLPanel;
import aurelienribon.slidinglayout.SLSide;
import com.quickbyte.fims.data.DBConnect;
import java.awt.*;
import javax.swing.*;
import com.quickbyte.fims.data.LoginAuthentication;
import com.quickbyte.fims.data.Logout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class SystemFrame{
        //public static JLabel header;
        public static JFrame systemFrame;
        
        private JLabel headerLabel,
                       footerLabel;
	private final SLPanel panel = new SLPanel();
	private PanelComponents controlPanel = new PanelComponents(new ControlPanel().controlPanel),
                                      searchPanel = new PanelComponents(new SearchPanel().containerPanel),
                                      displayPanel;
	private SLConfig mainCfg = null, 
                         searchPanelCfg = null,
                         displayPanelCfg = null;
        
   
    
    

    public void SystemFrame() throws ClassNotFoundException{
        
        displayPanel = new PanelComponents(new DisplayPanel().containerPanel);
        FrameComponents compGui = new FrameComponents();
        headerLabel = new JLabel("Welcome " + LoginAuthentication.firstName);
        headerLabel.setFont(compGui.headerFont);
        headerLabel.setBackground(compGui.themeColor2);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBorder(new EmptyBorder(5, 5, 0, 5));
        headerLabel.setOpaque(true);

        footerLabel = new JLabel("   Version:                          " + "License Owner: " + "Makati Medical Center College");
        footerLabel.setFont(compGui.componentFont);
        footerLabel.setBackground(compGui.themeColor3);
        footerLabel.setForeground(Color.BLACK);
        footerLabel.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));
        footerLabel.setOpaque(true);


        systemFrame = new JFrame();
        systemFrame.setTitle("QuickByte Software - Student Management System");
        systemFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        systemFrame.setExtendedState(systemFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        systemFrame.getContentPane().setBackground(compGui.themeColor4);
        systemFrame.setIconImage(compGui.frameIcon.getImage());
        systemFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "QuickByte Software - Lougout", JOptionPane.WARNING_MESSAGE, JOptionPane.OK_CANCEL_OPTION, compGui.logoutIcon);
                if(userChoice == JOptionPane.YES_OPTION){
                    Logout userLogout = new Logout(LoginAuthentication.userName);
                    System.exit(0);
                }
            }
        });
        systemFrame.add(headerLabel, BorderLayout.NORTH);
        systemFrame.add(panel, BorderLayout.CENTER);
        systemFrame.add(footerLabel, BorderLayout.SOUTH);
        systemFrame.setVisible(true); 



        searchPanel.setAction(searchPanelAction);

        displayPanel.setAction(displayPanelAction);

        mainCfg = new SLConfig(panel)
            .gap(10, 10)
            .row(1f).col(150).col(1f).col(2f)
            .beginGrid(0, 0)
            .row(2f).col(1f)
            .place(0, 0, controlPanel)
            .endGrid()
            .beginGrid(0, 1)
            .row(3f).col(1f)
            .place(0, 0, searchPanel)
            .endGrid()
            .place(0, 2, displayPanel);


        searchPanelCfg = new SLConfig(panel)
            .gap(10, 10)
            .row(1f).col(2f).col(1f)
            .place(0, 0, searchPanel)
            .place(0, 1, displayPanel);

        displayPanelCfg = new SLConfig(panel)
            .gap(10, 10)
            .row(1f).col(1f)
            .place(0, 0, displayPanel);

        panel.setTweenManager(SLAnimator.createTweenManager());
        panel.initialize(mainCfg);
    }



    private void disableActions() {

        searchPanel.disableAction();
        displayPanel.disableAction();

    }

    private void enableActions() {

        searchPanel.enableAction();
        displayPanel.enableAction();

    }

    private final Runnable searchPanelAction = new Runnable() {@Override public void run() {
        disableActions();

        panel.createTransition()
            .push(new SLKeyframe(searchPanelCfg, 0.5f)
            .setEndSide(SLSide.LEFT, controlPanel)
            .setCallback(new SLKeyframe.Callback() {@Override public void done() {
                searchPanel.setAction(searchPanelBackAction);
                searchPanel.enableAction();
    }}))
        .play();
    }};

    private final Runnable searchPanelBackAction = new Runnable() {@Override public void run() {
            disableActions();

            panel.createTransition()
                    .push(new SLKeyframe(mainCfg, 0.5f)
                            .setStartSide(SLSide.LEFT, controlPanel)
                            .setCallback(new SLKeyframe.Callback() {@Override public void done() {
                                    searchPanel.setAction(searchPanelAction);
                                    enableActions();
                            }}))
                    .play();
    }};

    private final Runnable displayPanelAction = new Runnable() {@Override public void run() {
            disableActions();

            panel.createTransition()
                    .push(new SLKeyframe(displayPanelCfg, 0.5f)
                            .setEndSide(SLSide.LEFT, controlPanel, searchPanel)
                            .setCallback(new SLKeyframe.Callback() {@Override public void done() {
                                    displayPanel.setAction(displayPanelBackAction);
                                    displayPanel.enableAction();
                            }}))
                    .play();
    }};

    private final Runnable displayPanelBackAction = new Runnable() {@Override public void run() {
            disableActions();

            panel.createTransition()
                    .push(new SLKeyframe(mainCfg, 0.5f)
                            .setStartSide(SLSide.LEFT, controlPanel, searchPanel)
                            .setCallback(new SLKeyframe.Callback() {@Override public void done() {
                                    displayPanel.setAction(displayPanelAction);
                                    enableActions();
                            }}))
                    .play();
    }};
    
    
}
