
package com.quickbyte.fims.data;

import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class PrintForm {
        private String studentFirstName, 
                       studentMiddleName,
                       studentLastName,
                       studentNumber, 
                       studentCourse, 
                       studentSection,
                       studentGender,
                       studentEmail,
                       studentNickname,
                       studentPermAddress,
                       studentPresentAddress,
                       studentCellNumber,
                       studentHomeNumber,
                       studentCivilStatus,
                       studentReligion,
                       studentNationality,
                       studentBirthday,
                       studentBirthplace,
                       studentBirthRank,
                       studentSpouse,
                       studentSpouseOccupation,
                       studentSpouseMarriageDate,
                       studentSpouseMarriagePlace,
                       studentSpouseAge,
                       studentSpouseEmployerAddress,
                       studentNoOfChildren,
                       fatherName,
                       fatherStatus,
                       fatherAddress,
                       fatherAge,
                       fatherEducation,
                       fatherCellNumber,
                       fatherOccupation,
                       fatherEmployerAddress,
                       motherName,
                       motherStatus,
                       motherAddress,
                       motherAge,
                       motherEducation,                   
                       motherCellNumber,
                       motherOccupation,
                       motherEmployerAddress,
                       parentsStatus,
                       parentsEconomicStatus;
    public PrintForm(String studentPull){
        
        try{
            String SQL = "SELECT * FROM STUDENTS_TABLE WHERE STUDENT_NO = ?";
            PreparedStatement queryStatement = DBConnect.dbConnect().prepareStatement(SQL);
            queryStatement.setString(1, studentPull);
            ResultSet rs = queryStatement.executeQuery();
            
            if(rs.next()){
                studentNumber = rs.getString("STUDENT_NO");
                studentLastName = rs.getString("LAST_NAME");
                studentMiddleName = rs.getString("MIDDLE_NAME");
                studentFirstName = rs.getString("FIRST_NAME");
                studentCourse = rs.getString("COURSE");
                studentSection = rs.getString("YEAR_SECTION");
                studentEmail = rs.getString("EMAIL_ADDRESS");
                studentGender = rs.getString("GENDER");
                studentEmail = rs.getString("EMAIL_ADDRESS");
                studentNickname = rs.getString("NICKNAME");
                studentPermAddress = rs.getString("PERM_ADDRESS");
                studentPresentAddress = rs.getString("PRESENT_ADDRESS");
                studentCellNumber = rs.getString("CELL_NUMBER");
                studentHomeNumber = rs.getString("HOME_NUMBER");
                studentCivilStatus = rs.getString("CIVIL_STATUS");
                studentReligion = rs.getString("RELIGION");
                studentNationality = rs.getString("NATIONALITY");
                studentBirthday = rs.getString("BIRTHDAY");
                studentBirthplace = rs.getString("BIRTHPLACE");
                studentBirthRank = rs.getString("BIRTH_RANK");
                studentSpouse = rs.getString("SPOUSE_NAME");
                studentSpouseOccupation = rs.getString("SPOUSE_OCCUPATION");
                studentSpouseMarriageDate = rs.getString("SPOUSE_MARRIAGEDATE");
                studentSpouseMarriagePlace = rs.getString("SPOUSE_MARRIAGEPLACE");
                studentSpouseEmployerAddress = rs.getString("SPOUSE_EMPADDRESS");
                studentNoOfChildren = rs.getString("SPOUSE_NUMCHILDREN");

                fatherName = rs.getString("FATHER_NAME");
                fatherStatus = rs.getString("FATHER_STATUS");
                fatherAddress = rs.getString("FATHER_ADDRESS");
                fatherAge = rs.getString("FATHER_AGE");
                fatherEducation = rs.getString("FATHER_EDUCATION");
                fatherOccupation = rs.getString("FATHER_OCCUPATION");
                fatherEmployerAddress = rs.getString("FATHER_EMPADDRESS");
                motherName = rs.getString("MOTHER_NAME");
                motherStatus = rs.getString("MOTHER_STATUS");
                motherAddress = rs.getString("MOTHER_ADDRESS");
                motherAge = rs.getString("MOTHER_AGE");
                motherEducation = rs.getString("MOTHER_EDUCATION");
                motherCellNumber = rs.getString("MOTHER_CELLNUMBER");
                motherOccupation = rs.getString("MOTHER_OCCUPATION");
                motherEmployerAddress = rs.getString("MOTHER_EMPADDRESS");
                parentsStatus = rs.getString("PARENTS_STATUS");
                parentsEconomicStatus = Integer.toString(rs.getInt("PARENTS_INCOME"));
            }
      
            PDDocument document = PDDocument.load("/Temp/Hello World.pdf");
            PDPage page = (PDPage) document.getDocumentCatalog().getAllPages().get(0);
            document.addPage(page);

            
            PDFont font = PDType1Font.HELVETICA;

            
            PDPageContentStream contentStream = new PDPageContentStream(document, page, true, true);

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(50, 700);
            contentStream.drawString("Student Number: " + studentNumber);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount(50, 680);
            contentStream.drawString("Last Name: " + studentLastName);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount(50, 660);
            contentStream.drawString("First Name: " + studentFirstName);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount(50, 660);
            contentStream.drawString("Middle Name: " + studentMiddleName);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount(50, 660);
            contentStream.drawString("Course: " + studentCourse);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount(50, 660);
            contentStream.drawString("Section: " + studentSection);
            contentStream.endText();contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount(50, 660);
            contentStream.drawString("Email Address: " + studentEmail);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount(50, 660);
            contentStream.drawString("Nickname: " + studentNickname);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount(50, 660);
            contentStream.drawString("Perm Address: " + studentPermAddress);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount(50, 660);
            contentStream.drawString("Perm Address: " + studentPermAddress);
            contentStream.endText();
            

            contentStream.close();
            //document.
            document.save( "/Temp/Hello World.pdf");
            document.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static PrintService choosePrinter() {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        if(printJob.printDialog()) {
            return printJob.getPrintService();          
        }
        else {
            return null;
        }
    }
    
    public static void printPDF(String fileName, PrintService printer)throws IOException, PrinterException {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintService(printer);
        PDDocument doc = PDDocument.load(fileName);
        doc.silentPrint(job);
    }
    public static void main(String[]args) throws IOException, PrinterException{
        new PrintForm("11-00003");
        printPDF("/Temp/Hello World.pdf", PrintServiceLookup.lookupDefaultPrintService());
    }
}
