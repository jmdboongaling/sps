
package com.quickbyte.fims.data;

import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
                       studentAge,
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
    public PrintForm(String studentPull, String selectedPrinter, int loop){
        
        try{
            String SQL = "SELECT * FROM STUDENT_RECORDS.STUDENTS_TABLE WHERE STUDENT_NO = ?";
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
                studentAge = Integer.toString((int)getAge(new java.util.Date(), new java.util.Date(rs.getDate("BIRTHDAY").getTime())));
                studentBirthday = rs.getDate("BIRTHDAY").toString();
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
      
            PDDocument document = PDDocument.load("/Temp/form.pdf");
            PDPage page = (PDPage) document.getDocumentCatalog().getAllPages().get(0);
            document.addPage(page);

            
            PDFont font = PDType1Font.COURIER_OBLIQUE;

            
            PDPageContentStream contentStream = new PDPageContentStream(document, page, true, true);

            contentStream.beginText();
            contentStream.setFont(font, 15);
            contentStream.moveTextPositionByAmount(180, 520);
            contentStream.drawString(studentLastName + ", " + studentFirstName + " " + studentMiddleName);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 15);
            contentStream.moveTextPositionByAmount(200, 480);
            contentStream.drawString(studentCourse);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 15);
            contentStream.moveTextPositionByAmount(380, 480);
            contentStream.drawString(studentSection);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 11);
            contentStream.moveTextPositionByAmount(470, 480);
            contentStream.drawString(studentEmail);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(155, 390);
            contentStream.drawString(studentNickname);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(305, 390);
            contentStream.drawString(studentCellNumber);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(480, 390);
            contentStream.drawString(studentHomeNumber);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(200, 377);
            contentStream.drawString(studentPermAddress);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(185, 363);
            contentStream.drawString(studentPresentAddress);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(115, 349);
            contentStream.drawString(studentGender);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(220, 349);
            contentStream.drawString(studentCivilStatus);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(330, 349);
            contentStream.drawString(studentReligion);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(463, 349);
            contentStream.drawString(studentNationality);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(123, 335);
            contentStream.drawString(studentAge);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(210, 335);
            contentStream.drawString(studentBirthday);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(360, 335);
            contentStream.drawString(studentBirthplace);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(510, 335);
            contentStream.drawString(studentBirthRank);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(200, 305);
            contentStream.drawString(studentSpouse);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(430, 305);
            contentStream.drawString(studentSpouseOccupation);
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(190, 290);
            if(!studentSpouse.equals("Not Applicable")){
                contentStream.drawString(studentSpouseMarriageDate);
            }else{
                contentStream.drawString("Not Applicable");
            }
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(430, 305);
            contentStream.drawString(studentSpouseMarriagePlace);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(360, 290);
            contentStream.drawString(studentSpouseEmployerAddress);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(200, 490);
            contentStream.drawString(fatherName);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(180, 520);
            contentStream.drawString(fatherAddress);
            contentStream.endText();
            
            contentStream.close();
            
            document.save( "/Temp/testForm.pdf");
            document.close();
            for (PrintService p: PrintServiceLookup.lookupPrintServices(null, null)) {
                if (p.getName().equals(selectedPrinter)) {
                    for(int i = 0; i < loop; i++){
                        printPDF("/Temp/testForm.pdf", p);
                    }
                    break;
                }
            }
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
    
    private static float getAge(java.util.Date birthdate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static float getAge(final java.util.Date current, final java.util.Date birthdate) {

        if (birthdate == null) {
          return 0;
        }
        if (current == null) {
          return getAge(birthdate);
        } else {
          final Calendar calend = new GregorianCalendar();
          calend.set(Calendar.HOUR_OF_DAY, 0);
          calend.set(Calendar.MINUTE, 0);
          calend.set(Calendar.SECOND, 0);
          calend.set(Calendar.MILLISECOND, 0);

          calend.setTimeInMillis(current.getTime() - birthdate.getTime());

          float result = 0;
          result = calend.get(Calendar.YEAR) - 1970;
          result += (float) calend.get(Calendar.MONTH) / (float) 12;
          return result;
        }

    }
    
    
    
   
    
}
