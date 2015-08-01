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



import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.slidinglayout.SLConfig;
import aurelienribon.slidinglayout.SLKeyframe;
import aurelienribon.slidinglayout.SLPanel;
import aurelienribon.slidinglayout.SLSide;
import java.awt.*;
import javax.swing.*;


public class SystemFrame{
        
        private JFrame systemFrame;
        private final SearchPanel sPanel = new SearchPanel();
	private final SLPanel panel = new SLPanel();
	private final PanelComponents controlPanel = new PanelComponents();
	private final PanelComponents searchPanel = new PanelComponents(sPanel.containerPanel);
	private final PanelComponents displayPanel = new PanelComponents(new JPanel());
	private SLConfig mainCfg = null, controlPanelCfg = null, searchPanelCfg = null, displayPanelCfg = null;
        
       
	public void SystemFrame(){
            FrameComponents guiComp = new FrameComponents();
            systemFrame = new JFrame();
            //FrameComponents x = new FrameComponents(systemFrame);
            systemFrame.setTitle("QuickByte Software - Student Management System");
            systemFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            systemFrame.setSize(systemFrame.getMaximumSize());
            systemFrame.setResizable(false);
            //systemFrame.getContentPane().setBackground(themeColor4);
            //systemFrame.setContentPane(guiComp.loginPageBackground);
            //systemFrame.setLayout(new GridBagLayout());
            systemFrame.setVisible(true); 
            systemFrame.add(panel, BorderLayout.CENTER);
            //dispose();

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

		controlPanelCfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(150).col(1f).col(2f)
			.place(0, 0, controlPanel)
			.beginGrid(0, 1)
				.row(1f).row(2f).col(1f)
				.place(0, 1, searchPanel)
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
		controlPanel.disableAction();
		searchPanel.disableAction();
		displayPanel.disableAction();
	}

	private void enableActions() {
		controlPanel.enableAction();
		searchPanel.enableAction();
		displayPanel.enableAction();
	}

	private final Runnable controlPanelAction = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(controlPanelCfg, 0.6f)
				.setEndSide(SLSide.BOTTOM, searchPanel)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					controlPanel.setAction(controlPanelBackAction);
					controlPanel.enableAction();
				}}))
			.play();
	}};

	private final Runnable controlPanelBackAction = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(mainCfg, 0.6f)
				.setStartSide(SLSide.BOTTOM, searchPanel)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					controlPanel.setAction(controlPanelAction);
					enableActions();
				}}))
			.play();
	}};
        
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
