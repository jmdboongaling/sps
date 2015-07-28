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
Last Edit: 5-30-2015
Edited by: Joshua Myron Deidre D. Boongaling
*/

package com.quickbyte.fims.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;



public class FrameComponents extends JFrame{
    
    public final Font headerFont = new Font("Consolas", Font.PLAIN, 30),
                      componentFont = new Font("Consolas", Font.PLAIN, 15);
    
    public final ImageIcon logoImage = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/qblogo.png"));
                           //titlebarIcon = new ImageIcon(getClass().getResource("/AppImages/icon.png")),
                           //iconImage = new ImageIcon(getClass().getResource("/AppImages/sideicon.png"));
    
    public final Color themeColor1 = new Color(204, 204, 204),
                       themeColor2 = new Color(0, 51, 102),
                       themeColor3 = new Color(204, 204, 153),
                       themeColor4 = new Color(255, 255, 255);
    
    public void FrameComponents(){
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setTitle("QuickByte Software - Student Management System");
                //setIconImage(titlebarIcon.getImage());
                    getContentPane().setBackground(Color.WHITE);
                        setLocationRelativeTo(null);
                            setResizable(false);
                                setVisible(true); 
                                
                                
        
    }
    
    public JLabel LabelProperties(JLabel label){

        label.setFont(componentFont);
        
        return label;
    }
    
    public JButton ButtonProperties(JButton button){
        
        
        button.setFont(componentFont);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setBackground(themeColor2);
        button.setForeground(themeColor4);
        return button;
    }
    
    public JLabel DateTimeProperties(final JLabel timeLabel){
        
        final DateFormat timeFormat = new SimpleDateFormat("hh:mm:ssa MM-dd-yyyy");
        ActionListener timerListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                Date date = new Date();
                String time = timeFormat.format(date);
                timeLabel.setText(time);
            }
        };
        
        Timer timer = new Timer(1000, timerListener);
        timer.setInitialDelay(0);
        timer.start();
        
        return timeLabel;
        
    }
}




















































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
Last Edit: 5-30-2015
Edited by: Joshua Myron Deidre D. Boongaling
*/