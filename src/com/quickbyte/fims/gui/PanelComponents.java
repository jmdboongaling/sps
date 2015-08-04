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
import aurelienribon.tweenengine.TweenManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class PanelComponents extends JPanel{

	private static final TweenManager tweenManager = SLAnimator.createTweenManager();
        private final FrameComponents guiComp = new FrameComponents();
	private Runnable action;
	private boolean actionEnabled = true;
        
	public PanelComponents(JPanel panel){
            
                setLayout(new GridLayout(1,1));
                
                setBackground(Color.WHITE);
		add(panel);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (actionEnabled){
                                    
                                    //panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                                    //setBorder(BorderFactory.createLineBorder(Color.black, 5));
                                    
                                }
                                
                           
			}

			@Override
			public void mouseExited(MouseEvent e) {
                            
                                
                                
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (action != null && actionEnabled){ action.run();}
                                
			}
		});
	}
        /*
        public PanelComponents(){

                //SystemFrame sF = new SystemFrame();
            
                logoutButton = new JButton();
                logoutButton.setIcon(guiComp.logoutIcon);
                guiComp.ButtonProperties(logoutButton, "Logout");
                logoutButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        LoginAuthentication x = new LoginAuthentication();
                        
                        
                        //new SystemFrame().disposeFrame();
                                
                        
                        //SystemFrame y = new SystemFrame(1);
                        
                        //Frame y = new JFrame();
                        //y.getFrames();
                        //y.dispose();
                        x.loginSuccess = false;
                        //System.exit(0);
                        //sF.systemFrame.hide();
                        //new LoginPage();
                        
                    }
                    
                });
                
                addButton = new JButton();
                addButton.setIcon(guiComp.addUserIcon);
                guiComp.ButtonProperties(addButton, "Add Student");
                addButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        

                        
                        
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
                
                setLayout(new GridLayout(5, 1 ,5, 5));
                setOpaque(false);
                //setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.black));
                
                add(logoutButton);
                add(addButton);
                add(optionsButton);
                add(helpButton);
                add(qbAdminButton);
                
	}*/

	public void setAction(Runnable action) {this.action = action;}
	public void enableAction() {actionEnabled = true;}
	public void disableAction() {actionEnabled = false;}

	public static class Accessor extends SLAnimator.ComponentAccessor {
		public static final int BORDER_THICKNESS = 100;

		@Override
		public int getValues(Component target, int tweenType, float[] returnValues) {


			int ret = super.getValues(target, tweenType, returnValues);
			if (ret >= 0) return ret;

			switch (tweenType) {
				
				default: return -1;
			}
		}

		@Override
		public void setValues(Component target, int tweenType, float[] newValues) {


			super.setValues(target, tweenType, newValues);

			switch (tweenType) {
				case BORDER_THICKNESS:
					
					break;
			}
		}
	}
}
