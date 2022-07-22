package com.fastPaperWork.utilities;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fastPaperWork.model.Usuario;

public class ExportarExcel {
   
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Usuario> usuariosList;


    public ExportarExcel(List<Usuario> listUsuarios){
        this.usuariosList=listUsuarios;
        workbook = new XSSFWorkbook();
    }
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("ListaUsuarios");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "id", style);
        createCell(row, 1, "primer nombre", style);
        createCell(row, 2, "segundo nombre", style);
        createCell(row, 3, "primer apellido", style);
        createCell(row, 4, "segundo apellido", style);
        createCell(row, 5, "tipo identificacion", style);
        createCell(row, 6, "no identificacion", style);
        createCell(row, 7, "telefono", style);
        createCell(row, 8, "direccion", style);
  
    }
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
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

        for (Usuario usu : this.usuariosList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, usu.getIdusuario(), style);
            createCell(row, columnCount++, usu.getPrimer_nombre(), style);
            createCell(row, columnCount++, usu.getSegundo_nombre(), style);
            createCell(row, columnCount++, usu.getPrimer_apellidos(), style);
            createCell(row, columnCount++, usu.getSegundo_apellido(), style);
            createCell(row, columnCount++, usu.getTipoIdentificacion(), style);
            createCell(row, columnCount++, usu.getNoIdentificacion(), style);
            createCell(row, columnCount++, usu.getTelefono(), style);
            createCell(row, columnCount++, usu.getDireccion(), style);

            
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