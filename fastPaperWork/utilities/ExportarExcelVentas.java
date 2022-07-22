package com.fastPaperWork.utilities;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fastPaperWork.model.Venta;

public class ExportarExcelVentas {

	 private XSSFWorkbook workbook;
	    private XSSFSheet sheet;
	    private List<Venta> ventaList;


	    public ExportarExcelVentas(List<Venta> listVenta){
	        this.ventaList=listVenta;
	        workbook = new XSSFWorkbook();
	    }
	    
	    private void writeHeaderLine() {
	        sheet = workbook.createSheet("ListaVentas");

	        Row row = sheet.createRow(0);

	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);

	        createCell(row, 0, "idventa", style);
	        createCell(row, 1, "fecha", style);
	        createCell(row, 2, "cantidad", style);
	        createCell(row, 3, "detalle", style);
	        createCell(row, 4, "total", style);


	    }
	    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
	        sheet.autoSizeColumn(columnCount);
	        Cell cell = row.createCell(columnCount);
	        if (value instanceof Integer) {
	            cell.setCellValue((Integer) value);
	        } else if (value instanceof Boolean) {
	            cell.setCellValue((Boolean) value);
	        }else if(value instanceof Double) {
	        	cell.setCellValue((Double) value);
	        }else if(value instanceof Date) {
	        	cell.setCellValue((Date) value);
	        }else {
	        	cell.setCellValue((String) value);
	        }
	        cell.setCellStyle(style);
	    }

	    private void writeDataLines() {
	        int rowCount = 1;

	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);

	        for (Venta ven : this.ventaList) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	            createCell(row, columnCount++, ven.getIdventa(), style);
	            createCell(row, columnCount++, ven.getFecha(), style);
	            createCell(row, columnCount++, ven.getCantidad(), style);
	            createCell(row, columnCount++, ven.getDetalle(), style);
	            createCell(row, columnCount++, ven.getTotal(), style);

	            
	        }
	    }

	    public void export(HttpServletResponse response) throws IOException {
	        writeHeaderLine();
	        writeDataLines();

	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();

	        outputStream.close();

	    }
	
}
