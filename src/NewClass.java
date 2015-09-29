
import java.io.IOException;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL-PC
 */
public class NewClass {
    public static void main(String[]args) throws IOException, COSVisitorException{
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        String x = "Marc Bigotilyo";
        contentStream.beginText();
        contentStream.setFont(null, 25);
        contentStream.moveTextPositionByAmount(100, 700);
        contentStream.drawString(x);
        contentStream.endText();
        
        contentStream.close();
        document.save("Test.pdf");
        document.close();
    }
}
