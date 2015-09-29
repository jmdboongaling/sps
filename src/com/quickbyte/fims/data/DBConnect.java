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
package com.quickbyte.fims.data;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DBConnect{
    
    public boolean loginSuccess;
    
    public static String dbURL,
                         dbUsername,
                         imageDir;
                         
    private static String dbPassword;
    
    public static Connection dbConnect() throws ClassNotFoundException{
        
        try {	
            File inputFile = new File("dbsettings.xml");
            DocumentBuilderFactory dbFactory 
               = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("SYSTEM_CONFIG");

            
            Node nNode = nList.item(0);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                dbURL = "jdbc:postgresql:" + (eElement.getElementsByTagName("DB_URL").item(0).getTextContent());
                dbUsername = (eElement.getElementsByTagName("DB_USERNAME").item(0).getTextContent());
                dbPassword = (eElement.getElementsByTagName("DB_PASSWORD").item(0).getTextContent());
                imageDir = (eElement.getElementsByTagName("IMAGE_DIR").item(0).getTextContent());
            }
            
        }catch (ParserConfigurationException | SAXException | IOException | DOMException e){
            e.printStackTrace();
        }
        
        try{     
            Class.forName("org.postgresql.Driver");        
            Connection dbConnection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            return dbConnection; 
        }
        catch(SQLException e){
            
            e.printStackTrace();
            return null;
            
        }
    }
   
        
       
                
                    
                
         
            
            
            
   
    
    

    
    
}
