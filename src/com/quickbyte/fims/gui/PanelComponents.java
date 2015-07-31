package com.quickbyte.fims.gui;

import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.tweenengine.TweenManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class PanelComponents extends JPanel{

        private JLabel label = new JLabel();
	private static final TweenManager tweenManager = SLAnimator.createTweenManager();
        private FrameComponents guiComp = new FrameComponents();
	private Runnable action;
	private boolean actionEnabled = true;
        private boolean panelVisibility;
        FrameComponents x = new FrameComponents();
        private JButton searchButton,
                        addButton,
                        optionsButton,
                        helpButton,
                        qbAdminButton;

        
	public PanelComponents(String labelText){
        
                panelVisibility = false;
                //setVisible(panelVisibility);
                //setMinimumSize(getSize());
                //setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                label.setText(labelText);

		add(label, BorderLayout.CENTER);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (actionEnabled) setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));//showBorder();
                                
                           
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));//hideBorder();
                                
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (action != null && actionEnabled){ action.run();}
                                
			}
		});
	}
        public PanelComponents(){

        
            
                searchButton = new JButton();
                searchButton.setIcon(x.searchIcon);
                guiComp.ButtonProperties(searchButton, "Search");
                searchButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                        
                    }
                    
                });
                
                addButton = new JButton();
                addButton.setIcon(x.addUserIcon);
                guiComp.ButtonProperties(addButton, "Add Student");
                
                optionsButton = new JButton();
                optionsButton.setIcon(x.optionsIcon);
                guiComp.ButtonProperties(optionsButton, "Options");
                
                helpButton = new JButton();
                helpButton.setIcon(x.helpIcon);
                guiComp.ButtonProperties(helpButton, "Help");
                
                qbAdminButton = new JButton();
                qbAdminButton.setIcon(x.qbAdminIcon);
                guiComp.ButtonProperties(qbAdminButton, "QB Admin");
                
                setLayout(new GridLayout(5, 1 ,5, 5));
                setOpaque(false);
                //setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.black));
                
                add(searchButton);
                add(addButton);
                add(optionsButton);
                add(helpButton);
                add(qbAdminButton);
                
	}

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
