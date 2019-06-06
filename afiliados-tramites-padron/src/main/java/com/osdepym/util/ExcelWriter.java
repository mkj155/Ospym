package com.osdepym.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.osdepym.dto.AfiliadoDTO;

public class ExcelWriter {



    private static String[] columns = {"Name", "Email", "Date Of Birth", "Salary"};

    private static List<Object> objs =  new ArrayList<>();



	// Initializing employees data to insert into the excel file
    /*static {

        Calendar dateOfBirth = Calendar.getInstance();

        dateOfBirth.set(1992, 7, 21);

        employees.add(new Employee("Rajeev Singh", "rajeev@example.com", 

                dateOfBirth.getTime(), 1200000.0));



        dateOfBirth.set(1965, 10, 15);

        employees.add(new Employee("Thomas cook", "thomas@example.com", 

                dateOfBirth.getTime(), 1500000.0));



        dateOfBirth.set(1987, 4, 18);

        employees.add(new Employee("Steve Maiden", "steve@example.com", 

                dateOfBirth.getTime(), 1800000.0));

    }*/



    public static void export(List<AfiliadoDTO> objs) throws IOException, InvalidFormatException {

        // Create a Workbook

        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file



        /* CreationHelper helps us create instances of various things like DataFormat, 

           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */

        CreationHelper createHelper = workbook.getCreationHelper();



        // Create a Sheet

        Sheet sheet = workbook.createSheet("File1");



        // Create a Font for styling header cells

        Font headerFont = workbook.createFont();

        headerFont.setBold(true);

        headerFont.setFontHeightInPoints((short) 14);

        headerFont.setColor(IndexedColors.RED.getIndex());



        // Create a CellStyle with the font

        CellStyle headerCellStyle = workbook.createCellStyle();

        headerCellStyle.setFont(headerFont);



        // Create a Row

        Row headerRow = sheet.createRow(0);



        // Create cells

        for(int i = 0; i < columns.length; i++) {

            Cell cell = headerRow.createCell(i);

            cell.setCellValue(columns[i]);

            cell.setCellStyle(headerCellStyle);

        }



        // Create Cell Style for formatting Date

        CellStyle dateCellStyle = workbook.createCellStyle();

        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));



        // Create Other rows and cells with employees data

        int rowNum = 1;
        
        for(Object o : objs) {

            Row row = sheet.createRow(rowNum++);



            row.createCell(0)

                    .setCellValue("Test");



            row.createCell(1)

                    .setCellValue("Email");



            Cell dateOfBirthCell = row.createCell(2);

            dateOfBirthCell.setCellValue("DIA");

            dateOfBirthCell.setCellStyle(dateCellStyle);



            row.createCell(3)

                    .setCellValue("12");

        }

		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {

            sheet.autoSizeColumn(i);

        }



        // Write the output to a file

        String fileName = "sampleObjectFile.xlsx";
        File file = new File(fileName);
        file.setWritable(true); //make it writable.
        workbook.write(new FileOutputStream(file));
        
        /*FileOutputStream fileOut = new FileOutputStream("C:\\poi-generated-file.xlsx");

        workbook.write(fileOut);*/

        //file.close();



        // Closing the workbook

        workbook.close();

    }

}