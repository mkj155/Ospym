package com.osdepym.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.dto.AfiliadoImportDTO;
import com.osdepym.exception.CustomException;

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

    public static void export(List<AfiliadoDTO> objs) throws IOException, InvalidFormatException, CustomException {
        // Create a Workbook
    	Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        Sheet sheet = workbook.createSheet("Export");

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
        CellStyle dateCellStyleDate = workbook.createCellStyle();
        CellStyle dateCellStyleDatetime = workbook.createCellStyle();
        dateCellStyleDate.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd"));
        dateCellStyleDatetime.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        
        // Create Other rows and cells with employees data
        int rowNum = 1;
        try {
	        for(AfiliadoDTO o : objs) {
	        	Integer count = 0;
	    		Integer cell = 0;
	        	Row row = sheet.createRow(rowNum++);
	
	            row.createCell(cell++).setCellValue(o.getRegistroID());
	            row.createCell(cell++).setCellValue(o.getObraSocial());
	            row.createCell(cell++).setCellValue(o.getTipoCarga());
	            row.createCell(cell++).setCellValue(o.getTipoAfiliado());
	            if(o.getCuit() != null)
	            	row.createCell(cell++).setCellValue(o.getCuit());
	            else
	            	row.createCell(cell++);
	            if(o.getCuil() != null)
	            	row.createCell(cell++).setCellValue(o.getCuil());
	            else
	            	row.createCell(cell++);
	            row.createCell(cell++).setCellValue(o.getApellido());
	            row.createCell(cell++).setCellValue(o.getNombre());
	            row.createCell(cell++).setCellValue(o.getTipoDocumento());
	            try {
	            	count = cell++;
	            	row.createCell(count).setCellValue(new Long(o.getNroDocumento()));
	            } catch(Exception e) {
	            	row.createCell(count).setCellValue(o.getNroDocumento());
	            }
	            row.createCell(cell++).setCellValue(o.getDireccion());
	            try {
	            	count = cell++;
	            	row.createCell(count).setCellValue(new Long(o.getDireccionNumero()));
	            } catch(Exception e) {
	            	row.createCell(count).setCellValue(o.getDireccionNumero());
	            }
	            try {
	            	count = cell++;
	            	row.createCell(count).setCellValue(new Long(o.getDireccionPiso()));
	            } catch(Exception e) {
	            	row.createCell(count).setCellValue(o.getDireccionPiso());
	            }
	            row.createCell(cell++).setCellValue(o.getDireccionDepartamento());
	            row.createCell(cell++).setCellValue(o.getDireccionLocalidad());
	            row.createCell(cell++).setCellValue(o.getDireccionProvincia());
	            try {
	            	count = cell++;
	            	row.createCell(count).setCellValue(new Long(o.getCodigoPostal()));
	            } catch(Exception e) {
	            	row.createCell(count).setCellValue(o.getCodigoPostal());
	            }
	            row.createCell(cell++).setCellValue(o.getTelefono());
	            row.createCell(cell++).setCellValue(o.getEmail());
	            
	            Cell c = row.createCell(cell++);
	            c.setCellValue(o.getFechaNacimiento());
	            c.setCellStyle(dateCellStyleDate);
	            
	            row.createCell(cell++).setCellValue(o.getSexo());
	            row.createCell(cell++).setCellValue(o.getEstadoCivil());
	            if(o.getCuilTitular() != null)
	            	row.createCell(cell++).setCellValue(o.getCuilTitular());
	            else
	            	row.createCell(cell++);
	            
	            c = row.createCell(cell++);
	            c.setCellValue(o.getFechaInicio());
	            c.setCellStyle(dateCellStyleDatetime);
	            
	            row.createCell(cell++).setCellValue(o.getCentroMedico());
	            row.createCell(cell++).setCellValue(o.getPlan());
	            row.createCell(cell++).setCellValue(o.getEstado());
	            if(o.getSolicitudID() != null)
	            	row.createCell(cell++).setCellValue(o.getSolicitudID());
	            else
	            	row.createCell(cell++);
	            row.createCell(cell++).setCellValue(o.getArchivo());
	            
	            c = row.createCell(cell++);
	            c.setCellValue(o.getFechaCarga());
	            c.setCellStyle(dateCellStyleDatetime);
	            
	            if(o.getCodigoError() != null)
	            	row.createCell(cell++).setCellValue(o.getCodigoError());
	            else
	            	row.createCell(cell++);
	            row.createCell(cell++).setCellValue(o.getDescripcionError());
	
	        }
        } catch(Exception e) {
        	workbook.close();
        	throw new CustomException(e.getMessage(), "ERROR AL EXPORTAR A EXCEL");
        }
		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        
        try { 
        	// this Writes the workbook excel 
        	File f = new File("Export.xlsx");
            FileOutputStream out = new FileOutputStream(f); 
            workbook.write(out); 
            out.close(); 
            System.out.println("excel.xlsx written successfully on disk."); 
	        workbook.close();
	        
	        try {
	        	Desktop dt = Desktop.getDesktop();
	        	dt.open(f);
	        } catch (IOException e) {
	        	throw new CustomException(e.getMessage(), "ERROR AL EXPORTAR A EXCEL");
	        }
        } catch (Exception e) { 
        	throw new CustomException(e.getMessage(), "ERROR AL EXPORTAR A EXCEL");
        } 
    }
    
    public static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
                return false;
        }
        return true;
    }
    
    public static List<AfiliadoImportDTO> getAfiliadosByFileXLSX(MultipartFile file) throws Exception {
		List<AfiliadoImportDTO> afiliados = new ArrayList<AfiliadoImportDTO>();

		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		OPCPackage fs = OPCPackage.open(file.getInputStream());
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		DataFormatter df = new DataFormatter();
		FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) wb);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		int rows; // No of rows
		rows = sheet.getPhysicalNumberOfRows();

		int cols = 0; // No of columns
		int tmp = 0;
		// This trick ensures that we get the data properly even if it doesn't start
		// from first few rows
		for (int i = 0; i < 10 || i < rows; i++) {
			row = sheet.getRow(i);
			if (row != null) {
				tmp = sheet.getRow(i).getPhysicalNumberOfCells();
				if (tmp > cols)
					cols = tmp;
			}
		}

		for (int r = 1; r < rows; r++) {
			row = sheet.getRow(r);
			if (row != null && !ExcelWriter.isRowEmpty(row)) {
				AfiliadoImportDTO afiliado = new AfiliadoImportDTO();
				for (int c = 0; c < cols; c++) {
					cell = row.getCell((short) c);
					String cellValue;
					if (cell != null) {
						objFormulaEvaluator.evaluate(cell);
						cellValue = df.formatCellValue(cell, objFormulaEvaluator);
					} else {
						cellValue = "";
					}
					switch (c) {
					case 0:
						afiliado.setCuil(cellValue);
						break;

					case 1:
						afiliado.setApellido(cellValue);
						break;
					case 2:
						afiliado.setNombre(cellValue);
						break;
					case 3:
						afiliado.setTipoDocumento(cellValue);
						break;
					case 4:
						afiliado.setNroDocumento(cellValue);
						break;
					case 5:
						afiliado.setCodParentesco(cellValue);
						break;
					case 6:
						afiliado.setDireccion(cellValue);
						break;
					case 7:
						afiliado.setNumero(cellValue);
						break;
					case 8:
						afiliado.setPiso(cellValue);
						break;
					case 9:
						afiliado.setDepartamento(cellValue);
						break;
					case 10:
						afiliado.setLocalidad(cellValue);
						break;
					case 11:
						afiliado.setProvincia(cellValue);
						break;
					case 12:
						afiliado.setCodigoPostal(cellValue);
						break;
					case 13:
						afiliado.setTelefono(cellValue);
						break;
					case 14:
						if (cellValue == null || cellValue.equals("")) {
							afiliado.setFechaNacimiento(cellValue);
						}else {
							try {
								afiliado.setFechaNacimiento(dateFormatter.format(cell.getDateCellValue()));
							}catch(Exception e) {
								afiliado.setFechaNacimiento(cellValue);
							}
							
						}
						break;
					case 15:
						afiliado.setSexo(cellValue);
						break;
					case 16:
						afiliado.setEstadoCivil(cellValue);
						break;
					case 17:
						if (cellValue == null || cellValue.equals("")) {
							afiliado.setFechaInicioCobertura(cellValue);
						}else {
							try {
								afiliado.setFechaInicioCobertura(dateFormatter.format(cell.getDateCellValue()));
							}catch(Exception e) {
								afiliado.setFechaInicioCobertura(cellValue);
							}
							
						}
						break;
					case 18:
						afiliado.setEmail(cellValue);
						break;
					}
				}

				afiliados.add(afiliado);
			}
		}
		wb.close();
		return afiliados;

	}

	
    public static List<AfiliadoImportDTO> getAfiliadosByFileXLS(MultipartFile file) throws Exception {
		List<AfiliadoImportDTO> afiliados = new ArrayList<AfiliadoImportDTO>();

		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		
		
		POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
	    HSSFWorkbook wb = new HSSFWorkbook(fs);
	    DataFormatter df = new DataFormatter();
	    FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);
	    HSSFSheet sheet = wb.getSheetAt(0);
	    HSSFRow row;
	    HSSFCell cell;

		int rows; // No of rows
		rows = sheet.getPhysicalNumberOfRows();

		int cols = 0; // No of columns
		int tmp = 0;
		// This trick ensures that we get the data properly even if it doesn't start
		// from first few rows
		for (int i = 0; i < 10 || i < rows; i++) {
			row = sheet.getRow(i);
			if (row != null) {
				tmp = sheet.getRow(i).getPhysicalNumberOfCells();
				if (tmp > cols)
					cols = tmp;
			}
		}

		for (int r = 1; r < rows; r++) {
			row = sheet.getRow(r);
			if (row != null && !ExcelWriter.isRowEmpty(row)) {
				AfiliadoImportDTO afiliado = new AfiliadoImportDTO();
				for (int c = 0; c < cols; c++) {
					cell = row.getCell((short) c);
					String cellValue;
					if (cell != null) {
						objFormulaEvaluator.evaluate(cell);
						cellValue = df.formatCellValue(cell, objFormulaEvaluator);
					} else {
						cellValue = "";
					}
					switch (c) {
					case 0:
						afiliado.setCuil(cellValue);
						break;
					case 1:
						afiliado.setApellido(cellValue);
						break;
					case 2:
						afiliado.setNombre(cellValue);
						break;
					case 3:
						afiliado.setTipoDocumento(cellValue);
						break;
					case 4:
						afiliado.setNroDocumento(cellValue);
						break;
					case 5:
						afiliado.setCodParentesco(cellValue);
						break;
					case 6:
						afiliado.setDireccion(cellValue);
						break;
					case 7:
						afiliado.setNumero(cellValue);
						break;
					case 8:
						afiliado.setPiso(cellValue);
						break;
					case 9:
						afiliado.setDepartamento(cellValue);
						break;
					case 10:
						afiliado.setLocalidad(cellValue);
						break;
					case 11:
						afiliado.setProvincia(cellValue);
						break;
					case 12:
						afiliado.setCodigoPostal(cellValue);
						break;
					case 13:
						afiliado.setTelefono(cellValue);
						break;
					case 14:
						if (cellValue == null || cellValue.equals("")) {
							afiliado.setFechaNacimiento(cellValue);
						}else {
							try {
								afiliado.setFechaNacimiento(dateFormatter.format(cell.getDateCellValue()));
							}catch(Exception e) {
								afiliado.setFechaNacimiento(cellValue);
							}
							
						}
						break;
					case 15:
						afiliado.setSexo(cellValue);
						break;
					case 16:
						afiliado.setEstadoCivil(cellValue);
						break;
					case 17:
						if (cellValue == null || cellValue.equals("")) {
							afiliado.setFechaInicioCobertura(cellValue);
						}else {
							try {
								afiliado.setFechaInicioCobertura(dateFormatter.format(cell.getDateCellValue()));
							}catch(Exception e) {
								afiliado.setFechaInicioCobertura(cellValue);
							}
							
						}
						break;
					case 18:
						afiliado.setEmail(cellValue);
						break;
					}
				}

				afiliados.add(afiliado);
			}
		}
		wb.close();
		return afiliados;

	}
	
}