package com.quickbyte.fims.gui;

import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;


/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class PanelComponents extends JPanel {
	

	private static final TweenManager tweenManager = SLAnimator.createTweenManager();
	private final JLabel label = new JLabel();
	private BufferedImage bgImg;
	private Runnable action;
	private boolean actionEnabled = true;
	private boolean hover = false;
	private int borderThickness = 1;
        private FrameComponents guiComponent = new FrameComponents();
	public PanelComponents() {
		//setBackground(BG_COLOR);
		setLayout(new BorderLayout());
                setBackground(guiComponent.themeColor4);
                //setBorder(BorderFactory.createLineBorder(Color.BLACK));

		label.setForeground(guiComponent.themeColor4);
		label.setFont(new Font("Sans", Font.BOLD, 90));
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		//label.setText(panelName);
                

		
                        //add(label, BorderLayout.CENTER);
		

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hover = true;
				if (actionEnabled) showBorder();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hover = false;
				hideBorder();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (action != null && actionEnabled) action.run();
                                //JFrame x = new JFrame();
                                //x.setSize(500, 500);
                                //x.show();
			}
		});
	}

	public void setAction(Runnable action) {this.action = action;}
	public void enableAction() {actionEnabled = true; if (hover) showBorder();}
	public void disableAction() {actionEnabled = false;}

	private void showBorder() {
		tweenManager.killTarget(borderThickness);
		Tween.to(PanelComponents.this, Accessor.BORDER_THICKNESS, 0.4f)
			.target(10)
			.start(tweenManager);
	}

	private void hideBorder() {
		tweenManager.killTarget(borderThickness);
		Tween.to(PanelComponents.this, Accessor.BORDER_THICKNESS, 0f)
			.target(2)
			.start(tweenManager);
	}
        
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D gg = (Graphics2D) g;

		int w = getWidth();
		int h = getHeight();

		if (bgImg != null) {
			int imgW = bgImg.getWidth();
			int imgH = bgImg.getHeight();

			if ((float)w/h < (float)imgW/imgH) {
				int tw = h * imgW/ imgH;
				int th = h;
				gg.drawImage(bgImg, (w-tw)/2, 0, tw, th, null);
			} else {
				int tw = w;
				int th = w * imgH / imgW;
				gg.drawImage(bgImg, 0, (h-th)/2, tw, th, null);
			}
		}

		int t = borderThickness;
		//gg.setColor(BORDER_COLOR);
		gg.fillRect(0, 0, t, h-1);
		gg.fillRect(0, 0, w-1, t);
		gg.fillRect(0, h-1-t, w-1, t);
		gg.fillRect(w-1-t, 0, t, h-1);
	}

        
	public static class Accessor extends SLAnimator.ComponentAccessor {
		public static final int BORDER_THICKNESS = 100;

		@Override
		public int getValues(Component target, int tweenType, float[] returnValues) {
			PanelComponents tp = (PanelComponents) target;

			int ret = super.getValues(target, tweenType, returnValues);
			if (ret >= 0) return ret;

			switch (tweenType) {
				case BORDER_THICKNESS: returnValues[0] = tp.borderThickness; return 1;
				default: return -1;
			}
		}

		@Override
		public void setValues(Component target, int tweenType, float[] newValues) {
			PanelComponents tp = (PanelComponents) target;

			super.setValues(target, tweenType, newValues);

			switch (tweenType) {
				case BORDER_THICKNESS:
					tp.borderThickness = Math.round(newValues[0]);
					tp.repaint();
					break;
			}
		}
	}
}
