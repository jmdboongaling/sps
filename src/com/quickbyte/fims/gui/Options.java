
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
import net.java.dev.designgridlayout.DesignGridLayout;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Options extends JFrame{
    
    private JLabel dbURLLabel,
                   dbUsernameLabel,
                   dbPasswordLabel,
                   imageDirectoryLabel;
    
    private JTextField dbURLField,
                       dbUsernameField,
                       imageDirectoryField;
    
    private JPasswordField dbPasswordField;
    
    private JButton applyButton,
                    closeButton;
    
    private JList menuBar;
    
    private JPanel dbSettingsPanel,
                   imageDirectoryPanel,
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
        
        dbURLField = new JTextField();
        compGui.TextFieldProperties(dbURLField);
        dbURLField.setText(DBConnect.dbURL);
        dbUsernameField = new JTextField();
        compGui.TextFieldProperties(dbUsernameField);
        dbUsernameField.setText(DBConnect.dbUsername);
        dbPasswordField = new JPasswordField();
        dbPasswordField.setText("*************");
        compGui.TextFieldProperties(dbPasswordField);
        

        dbSettingsPanel = new JPanel();
        DesignGridLayout formLayout = new DesignGridLayout(dbSettingsPanel);
        dbSettingsPanel.setOpaque(false);
        formLayout.row().grid(dbURLLabel).add(dbURLField);
        formLayout.row().grid(dbUsernameLabel).add(dbUsernameField);
        formLayout.row().grid(dbPasswordLabel).add(dbPasswordField);
        
        imageDirectoryLabel = new JLabel("Image Directory: ");
        compGui.LabelProperties(imageDirectoryLabel);
        
        imageDirectoryField = new JTextField(DBConnect.imageDir);
        compGui.TextFieldProperties(imageDirectoryField);
        
        
        
        imageDirectoryPanel = new JPanel();
        imageDirectoryPanel.setOpaque(false);
        DesignGridLayout formLayout2 = new DesignGridLayout(imageDirectoryPanel);
        formLayout2.row().grid(imageDirectoryLabel).add(imageDirectoryField);
        
        CardLayout switchPanel = new CardLayout();
        showPanel = new JPanel();
        showPanel.setLayout(switchPanel);
        showPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        showPanel.add(dbSettingsPanel, "1");
        showPanel.add(imageDirectoryPanel, "2");
        DefaultListModel listModel = new DefaultListModel();
        menuBar = new JList(listModel);
        menuBar.setOpaque(false);
        listModel.addElement("Database Settings");
        listModel.addElement("Images Directory");
        JLabel sideBar = new JLabel(compGui.optionsSidebar);
        sideBar.setLayout(new BorderLayout());
        sideBar.add(menuBar, BorderLayout.CENTER);
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
        buttonPanel.setOpaque(true);
        buttonPanel.add(applyButton);
        buttonPanel.add(closeButton);
        
        setTitle("Student Profiling System - Options");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setResizable(false);
        add(sideBar, BorderLayout.WEST);
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

           
            Node userSettings = doc.getFirstChild();

            
            Node systemConfig = doc.getElementsByTagName("SYSTEM_CONFIG").item(0);

            
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
                
                if ("IMAGE_DIR".equals(node.getNodeName())) {
                        node.setTextContent(imageDirectoryField.getText());
                }
            
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            JOptionPane.showMessageDialog(null, "Settings Updated!");

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
