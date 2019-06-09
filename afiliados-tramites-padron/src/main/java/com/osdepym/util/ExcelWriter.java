package com.osdepym.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
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
    private static String[] columns = {
		"Registro Nº",
		"Obra Social",
		"Tipo carga (Titular – Adherente)",
		"Tipo de Afiliado (Rel dep, monotributista, voluntario)",
		"CUIT",
		"CUIL",
		"Apellido",
		"Nombre",
		"Tipo Documento",
		"Nro Documento",
		"Dirección",
		"Nro",
		"Piso",
		"Departamento",
		"Localidad",
		"Provincia",
		"Código Postal",
		"Teléfono",
		"Email",
		"Fecha Nacimiento",
		"Sexo",
		"Estado Civil",
		"CUIL Titular", 
		"Fecha Inicio",
		"Centro Medico",
		"Plan",
		"Estado",
		"Nº Solicitud",
		"Archivo",
		"Fecha carga",      
		"Código Error",
		"Descripción de error"	
    };

    public static void export(List<AfiliadoDTO> objs) throws IOException, InvalidFormatException {
        // Create a Workbook
    	Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        Sheet sheet = workbook.createSheet("File1");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();

        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();

        headerCellStyle.setBorderBottom(BorderStyle.MEDIUM);

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
        
        // Create Other rows and cells with employees data
        int rowNum = 1;
        try {
	        for(AfiliadoDTO o : objs) {
	    		Integer cell = 0;
	        	Row row = sheet.createRow(rowNum++);
	
	            row.createCell(cell++).setCellValue(o.getRegistroID());
	            row.createCell(cell++).setCellValue(o.getObraSocial());
	            row.createCell(cell++).setCellValue(o.getTipoCarga());
	            row.createCell(cell++).setCellValue(o.getTipoAfiliado());
	            row.createCell(cell++).setCellValue(o.getCuit() != null ? o.getCuit().toString() : "");
	            row.createCell(cell++).setCellValue(o.getCuil() != null ? o.getCuil().toString() : "");
	            row.createCell(cell++).setCellValue(o.getApellido());
	            row.createCell(cell++).setCellValue(o.getNombre());
	            row.createCell(cell++).setCellValue(o.getTipoDocumento());
	            row.createCell(cell++).setCellValue(o.getNroDocumento());
	            row.createCell(cell++).setCellValue(o.getDireccion());
	            row.createCell(cell++).setCellValue(o.getDireccionNumero());
	            row.createCell(cell++).setCellValue(o.getDireccionPiso());
	            row.createCell(cell++).setCellValue(o.getDireccionDepartamento());
	            row.createCell(cell++).setCellValue(o.getDireccionLocalidad());
	            row.createCell(cell++).setCellValue(o.getDireccionProvincia());
	            row.createCell(cell++).setCellValue(o.getCodigoPostal());
	            row.createCell(cell++).setCellValue(o.getTelefono());
	            row.createCell(cell++).setCellValue(o.getEmail());
	            
	            Cell c = row.createCell(cell++);
	            c.setCellValue(o.getFechaNacimiento());
	            c.setCellStyle(dateCellStyle);
	            
	            row.createCell(cell++).setCellValue(o.getSexo());
	            row.createCell(cell++).setCellValue(o.getEstadoCivil());
	            row.createCell(cell++).setCellValue(o.getCuilTitular() != null ? o.getCuilTitular().toString() : "");
	            
	            c = row.createCell(cell++);
	            row.createCell(cell++).setCellValue(o.getFechaInicio());
	            c.setCellStyle(dateCellStyle);
	            
	            row.createCell(cell++).setCellValue(o.getCentroMedico());
	            row.createCell(cell++).setCellValue(o.getPlan());
	            row.createCell(cell++).setCellValue(o.getEstado());
	            row.createCell(cell++).setCellValue(o.getSolicitudID() != null ? o.getSolicitudID().toString() : "");
	            row.createCell(cell++).setCellValue(o.getArchivo());
	            
	            c = row.createCell(cell++);
	            row.createCell(cell++).setCellValue(o.getFechaCarga());
	            c.setCellStyle(dateCellStyle);
	            
	            row.createCell(cell++).setCellValue(o.getCodigoError() != null ? o.getCodigoError().toString() : "");
	            row.createCell(cell++).setCellValue(o.getDescripcionError());
	
	        }
        } catch(Exception e) {
        	e.getStackTrace();
        }
		// Resize all columns to fit the content size
        //for(int i = 0; i < columns.length; i++) {
        //    sheet.autoSizeColumn(i);
       // }
        
        try { 
        	// this Writes the workbook excel 
        	File f = new File("excel.xlsx");
            FileOutputStream out = new FileOutputStream(f); 
            workbook.write(out); 
            out.close(); 
            System.out.println("excel.xlsx written successfully on disk."); 
            
	        /*ByteArrayOutputStream excelOutput = new ByteArrayOutputStream();
	        byte[] byteRpt = null;
	         
	        workbook.write(excelOutput);
	        byteRpt = excelOutput.toByteArray();
	         
	        byte[] encodedBytes = Base64.encodeBase64(byteRpt);
	        String base64 = new String(encodedBytes);*/
	        workbook.close();
	        
	        try {
	        	Desktop dt = Desktop.getDesktop();
	        	dt.open(f);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
}