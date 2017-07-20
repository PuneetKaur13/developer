package com.ncs.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.BuyerReportForm;

public class PdfBuilder {

	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

	private static Font TIME_ROMAN_BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public static Document createPDF(String file, List list, BuyerBiddingForm form) {

		Document document = null;

		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			addMetaData(document);

			addTitlePage(document, form);

			createTable(document, list);

			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

	private static void addMetaData(Document document) {
		/*
		 * document.addTitle("Generate PDF report"); document.addSubject(
		 * "Generate PDF report"); document.addAuthor("Java Honk");
		 * document.addCreator("Java Honk");
		 */
	}

	private static void addTitlePage(Document document, BuyerBiddingForm form) throws DocumentException {

		Paragraph preface = new Paragraph();
		Paragraph preface1 = new Paragraph();
		Paragraph preface2 = new Paragraph();
		preface.add(new Paragraph("Buyer Report", TIME_ROMAN));
		preface.setAlignment(Element.ALIGN_CENTER);
		StringBuffer sb = new StringBuffer();
		if (form.getProductName() != null) {
			sb.append("Product Name:  " + form.getProductName() + "  ");
		}
		if (form.getStateName() != null) {
			sb.append("State Name  " + form.getStateName() + "  ");
		}
		if (form.getCityName() != null) {
			sb.append("City NAME:  " + form.getCityName() + "  ");
		}
		if (form.getStatus() != null) {
			sb.append("Status:  " + form.getStatus() + "  ");
		}

		if (form.getStartDate() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String dateWithoutTime = sdf.format(form.getStartDate());
			System.out.println("sdf.format(d) " + dateWithoutTime);
			sb.append("START DATE:  " + dateWithoutTime + "     ");
		}

		if (form.getEnddate() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String dateWithoutTime = sdf.format(form.getEnddate());
			sb.append("END DATE:  " + dateWithoutTime + "    ");
		}
		if (form.getProductName() != null || form.getCityName() != null || form.getStateName() != null
				|| form.getStartDate() != null || form.getEnddate() != null) {
			preface2.setAlignment(Element.ALIGN_LEFT);
			preface2.add(new Paragraph(sb.toString(), TIME_ROMAN_BOLD));
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		preface1.add(new Paragraph("Date : " + simpleDateFormat.format(new Date()), TIME_ROMAN_BOLD));
		preface1.setAlignment(Element.ALIGN_RIGHT);
		document.add(preface);
		document.add(preface1);
		document.add(preface2);

	}

	private static void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	private static void createTable(Document document, List list) throws DocumentException {
		Paragraph paragraph = new Paragraph();

		creteEmptyLine(paragraph, 2);
		document.add(paragraph);
		PdfPTable table = new PdfPTable(7);

		PdfPCell c1 = new PdfPCell(new Phrase("BidRef No.", TIME_ROMAN_BOLD));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("PACKAGING", TIME_ROMAN_BOLD));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("QUANTITY", TIME_ROMAN_BOLD));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("REMAIN QUANTITY", TIME_ROMAN_BOLD));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("WON QUANTITY", TIME_ROMAN_BOLD));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("FREEZING TYPE", TIME_ROMAN_BOLD));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("STATUS", TIME_ROMAN_BOLD));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		table.setHeaderRows(1);
		Iterator<BuyerBiddingDTO> it = list.iterator();
		int sum = 0;
		int count = 1;
		while (it.hasNext()) {
			BuyerBiddingDTO object = it.next();
			table.setWidthPercentage(100);
			Double quantity = object.getQuantity();
			String quantityAsString = Double.toString(quantity);
			Double remainQuantity = object.getQuantity();
			String remainQuantityAsString = Double.toString(remainQuantity);
			Double wonQuantity = object.getQuantity();
			String wonQuantityAsString = Double.toString(wonQuantity);

			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			/* table.addCell("" + count++); */
			table.addCell(object.getBidRefrenceNo());
			table.addCell(object.getPackaging());
			table.addCell(quantityAsString);
			table.addCell(remainQuantityAsString);
			table.addCell(wonQuantityAsString);
			table.addCell(object.getFreezingType());
			table.addCell(object.getStatus());
			/*
			 * SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); String
			 * dateWithoutTime = sdf.format(object.getEnddate());
			 * table.addCell(dateWithoutTime.toString()); long diffSeconds =
			 * object.getStartDate().getSeconds(); long diffMinutes =
			 * object.getStartDate().getMinutes(); long diffHours =
			 * object.getStartDate().getHours(); long endSeconds =
			 * object.getEnddate().getSeconds(); long endMinutes =
			 * object.getEnddate().getMinutes(); long endHours =
			 * object.getEnddate().getHours(); String stratdate = diffHours +
			 * ":" + diffMinutes + ":" + diffSeconds; String endate = endHours +
			 * ":" + endMinutes + ":" + endSeconds; table.addCell(stratdate);
			 * table.addCell(endate);
			 */
		}

	/*	int hours = (int) Math.floor(sum / 3600);
		int minutes = (int) Math.floor((sum - (hours * 3600)) / 60);
		int seconds = sum - (hours * 3600) - (minutes * 60);

		String diffFormat = hours + ":" + minutes + ":" + seconds;*/
		table.setWidthPercentage(110);

		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_RIGHT);
		table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		table.addCell("");
		table.addCell("");
		table.addCell("");
		table.addCell("");
		table.addCell("");
		table.addCell("");

		/*table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);*/
		/*table.addCell(diffFormat);*/
		document.add(table);
	}
}
