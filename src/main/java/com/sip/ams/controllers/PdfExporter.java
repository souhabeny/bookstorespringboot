package com.sip.ams.controllers;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.sip.ams.entities.Book;

public class PdfExporter {
private List<Book> listbooks;

public PdfExporter(List<Book> listbooks) {
	super();
	this.listbooks = listbooks;
}
private void writeTableHeader(PdfPTable table) {
    PdfPCell cell = new PdfPCell();
    cell.setBackgroundColor(Color.BLUE);
    cell.setPadding(5);
     
    Font font = FontFactory.getFont(FontFactory.HELVETICA);
    font.setColor(Color.WHITE);
     
    cell.setPhrase(new Phrase("title", font));
     
    table.addCell(cell);
     
    cell.setPhrase(new Phrase("author", font));
    table.addCell(cell);
     
    cell.setPhrase(new Phrase("price", font));
    table.addCell(cell);
    
}
private void writeTableData(PdfPTable table) {
    for (Book book : listbooks) {
        
        table.addCell(book.getTitle());
        table.addCell(book.getAuthor());
        table.addCell(String.valueOf(book.getPrice()));
    }
}


public void export(HttpServletResponse response) throws IOException {
    Document document = new Document(PageSize.A4);
    PdfWriter.getInstance(document, response.getOutputStream());
     
    document.open();
    Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
    font.setSize(18);
    font.setColor(Color.BLUE);
     
    Paragraph p = new Paragraph("List of books", font);
    p.setAlignment(Paragraph.ALIGN_CENTER);
     
    document.add(p);
     
    PdfPTable table = new PdfPTable(3);
    table.setWidthPercentage(100f);
    table.setWidths(new float[] {3.5f, 3.5f, 3.0f});
    table.setSpacingBefore(10);
     
    writeTableHeader(table);
    writeTableData(table);
     
    document.add(table);
     
    document.close();
     
}


}
