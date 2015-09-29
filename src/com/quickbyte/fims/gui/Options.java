/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.gui;

import com.quickbyte.fims.data.DBConnect;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Options extends JFrame{
    
    private JLabel dbURLLabel,
                   dbUsernameLabel,
                   dbPasswordLabel;
    
    private JTextField dbURLField,
                       dbUsernameField;
    
    private JPasswordField dbPasswordField;
    
    private JButton applyButton,
                    closeButton;
    
    private JList menuBar;
    
    private JPanel dbSettingsPanel,
                   dbLabelsPanel,
                   dbFieldsPanel,
                   showPanel,
                   buttonPanel;
    
    private final FrameComponents compGui = new FrameComponents();
    
    public Options(){
        
        initComponents();
    }
    
    private void initComponents(){
        
        dbURLLabel = new JLabel("Database URL: ");
        compGui.LabelProperties(dbURLLabel);
        dbUsernameLabel = new JLabel("Database Username: ");
        compGui.LabelProperties(dbUsernameLabel);
        dbPasswordLabel = new JLabel("Database Password: ");
        compGui.LabelProperties(dbPasswordLabel);
        
        dbURLField = new JTextField(35);
        compGui.TextFieldProperties(dbURLField);
        dbURLField.setText(DBConnect.dbURL);
        dbUsernameField = new JTextField(15);
        compGui.TextFieldProperties(dbUsernameField);
        dbUsernameField.setText(DBConnect.dbUsername);
        dbPasswordField = new JPasswordField(15);
        dbPasswordField.setText("*************");
        compGui.TextFieldProperties(dbPasswordField);
        
        dbLabelsPanel = new JPanel(new GridLayout(15, 1, 5, 5));
        dbLabelsPanel.setOpaque(false);
        dbLabelsPanel.add(dbURLLabel);
        dbLabelsPanel.add(dbUsernameLabel);
        dbLabelsPanel.add(dbPasswordLabel);
        
        dbFieldsPanel = new JPanel(new GridLayout(15, 1, 5, 5));
        dbFieldsPanel.setOpaque(false);
        dbFieldsPanel.add(dbURLField);
        dbFieldsPanel.add(dbUsernameField);
        dbFieldsPanel.add(dbPasswordField);
        
        dbSettingsPanel = new JPanel(new BorderLayout());
        dbSettingsPanel.setOpaque(false);
        dbSettingsPanel.add(dbLabelsPanel, BorderLayout.WEST);
        dbSettingsPanel.add(dbFieldsPanel, BorderLayout.CENTER);
        
        CardLayout switchPanel = new CardLayout();
        showPanel = new JPanel();
        showPanel.setLayout(switchPanel);
        showPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        showPanel.add(dbSettingsPanel, "1");
        showPanel.add(new JLabel("Images"), "2");
        DefaultListModel listModel = new DefaultListModel();
        menuBar = new JList(listModel);
        listModel.addElement("Database Settings");
        listModel.addElement("Images Directory");
        menuBar.setBorder(new EmptyBorder(15, 0, 15, 15));
        menuBar.setFont(compGui.componentFont);
        menuBar.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if(menuBar.getSelectedValue().equals("Database Settings")){
                    switchPanel.show(showPanel, "1");
                }else if(menuBar.getSelectedValue().equals("Images Directory")){
                    switchPanel.show(showPanel, "2");
                }
            }
        });
        
        applyButton = new JButton("Apply");
        compGui.ButtonProperties(applyButton);
        applyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                applyButtonActionPerformed(e);
            }
        });
        
        closeButton = new JButton("Close");
        compGui.ButtonProperties(closeButton);
        closeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);
        buttonPanel.add(applyButton);
        buttonPanel.add(closeButton);
        //super.addW
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(menuBar, BorderLayout.WEST);
        add(showPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void applyButtonActionPerformed(ActionEvent e){
        try {
            String filepath = "dbsettings.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            // Get the root element
            Node userSettings = doc.getFirstChild();

            // Get the systemConfig element , it may not working if tag has spaces, or
            // whatever weird characters in front...it's better to use
            // getElementsByTagName() to get it directly.
            // Node systemConfig = company.getFirstChild();

            // Get the systemConfig element by tag name directly
            Node systemConfig = doc.getElementsByTagName("SYSTEM_CONFIG").item(0);

            // update systemConfig attribute
            NamedNodeMap attr = systemConfig.getAttributes();
            Node nodeAttr = attr.getNamedItem("config_type");
            nodeAttr.setTextContent("DATABASE");
            NodeList list = systemConfig.getChildNodes();
           
            for (int i = 0; i < list.getLength(); i++) {
                 Node node = list.item(i);
                if ("DB_URL".equals(node.getNodeName())) {
                        node.setTextContent(dbURLField.getText());
                }

                if ("DB_USERNAME".equals(node.getNodeName())) {
                        node.setTextContent(dbUsernameField.getText());
                }

                if ("DB_PASSWORD".equals(node.getNodeName())) {
                        node.setTextContent(dbPasswordField.getText());
                }
            
            }
            // append a new node to systemConfig
          

            // loop the systemConfig child node
            //NodeList list = systemConfig.getChildNodes();
            /*
            for (int i = 0; i < list.getLength(); i++) {

               Node node = list.item(i);

               // get the salary element, and update the value
               if ("salary".equals(node.getNodeName())) {
                    node.setTextContent("2000000");
               }

               //remove firstname
               if ("firstname".equals(node.getNodeName())) {
                    systemConfig.removeChild(node);
               }

            }*/

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            System.out.println("Done");

        } catch (ParserConfigurationException pce) {
             pce.printStackTrace();
        } catch (TransformerException tfe) {
             tfe.printStackTrace();
        } catch (IOException ioe) {
             ioe.printStackTrace();
        } catch (SAXException sae) {
             sae.printStackTrace();
        }
    }
}
