package com.quickbyte.fims.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.print.*;
import javax.swing.*;
import javax.swing.border.*;
public class Print extends JFrame{
    
    private JLabel printersLabel,
                   numberCopiesLabel,
                   printPreviewLabel;
    private JButton printButton,
                    cancelButton;
    
    private JComboBox printerList;
    
    private JSpinner numberCopies;
    
    private JPanel printPanel,
                   footerPanel,
                   optionsPanel;
    
    private final FrameComponents compGui = new FrameComponents();

    public Print(String studentNumber){
        
        initComponents();
        
    }
    

    private String[] getPrinterNames(){
        
        ArrayList<String> printerNamesList = new ArrayList();
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        
        for (PrintService printer : printServices) {
            printerNamesList.add(printer.getName());
        }
        
        String[] printerNames = new String[printServices.length];
        printerNames = (String[])printerNamesList.toArray(printerNames);
        return printerNames;
        
    }

    public void initComponents(){
        printersLabel = new JLabel("Printers: ");
        compGui.LabelProperties(printersLabel);
        numberCopiesLabel = new JLabel("Copies: ");
        compGui.LabelProperties(numberCopiesLabel);

        printerList = new JComboBox(getPrinterNames());
        printerList.setFont(compGui.componentFont);
        printerList.setBackground(Color.WHITE);

        numberCopies = new JSpinner();
        numberCopies.setModel(new SpinnerNumberModel(1, 1, 17, 1));
        numberCopies.setFont(compGui.componentFont);
        numberCopies.setBackground(Color.WHITE);
        numberCopies.setPreferredSize(new Dimension(61, 30));

        optionsPanel = new JPanel(new FlowLayout());
        optionsPanel.setOpaque(false);
        optionsPanel.add(printersLabel);
        optionsPanel.add(printerList);
        optionsPanel.add(numberCopiesLabel);
        optionsPanel.add(numberCopies);

        printPreviewLabel = new JLabel("sda");//compGui.documentPreviewIcon);
        compGui.LabelProperties(printPreviewLabel);
        printPreviewLabel.setHorizontalTextPosition(0);
        printPreviewLabel.setVerticalTextPosition(0);
        printPreviewLabel.setPreferredSize(printPreviewLabel.getMaximumSize());
        printPreviewLabel.setMinimumSize(printPreviewLabel.getMaximumSize());

        printButton = new JButton("Print");
        compGui.ButtonProperties(printButton);
        printButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {}
        });
        cancelButton = new JButton("Cancel");
        compGui.ButtonProperties(cancelButton);
        cancelButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {}
        });
        footerPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        footerPanel.setOpaque(false);
        footerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        footerPanel.add(printButton);
        footerPanel.add(cancelButton);

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(2);
        setLayout(new BorderLayout());
        add(optionsPanel, "North");
        add(printPreviewLabel, "Center");
        add(footerPanel, "South");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
