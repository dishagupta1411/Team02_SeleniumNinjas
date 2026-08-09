package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderFile {

    private String xlfilePath;

    public ExcelReaderFile(String xlfilePath) {
        this.xlfilePath = xlfilePath;
    }



    
    public String getData(String sheetName, String rowName, String columnName)
            throws IOException {

        FileInputStream fis = new FileInputStream(xlfilePath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheet(sheetName);

        if (sheet == null) {
            wb.close();
            fis.close();
            throw new IllegalArgumentException(
                    "Sheet not found: " + sheetName
            );
        }

        // Find the column number from the header
        XSSFRow headerRow = sheet.getRow(0);

        int columnIndex = -1;

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {

            XSSFCell cell = headerRow.getCell(i);

            if (cell != null &&
                cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {

                columnIndex = i;
                break;
            }
        }

        if (columnIndex == -1) {
            wb.close();
            fis.close();
            throw new IllegalArgumentException(
                    "Column not found: " + columnName
            );
        }

        // Find the row using TestCase name in column 0
        int rowIndex = -1;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            XSSFRow row = sheet.getRow(i);

            if (row != null) {

                XSSFCell cell = row.getCell(0);

                if (cell != null &&
                    cell.getStringCellValue().trim().equalsIgnoreCase(rowName.trim())) {

                    rowIndex = i;
                    break;
                }
            }
        }

        if (rowIndex == -1) {
            wb.close();
            fis.close();
            throw new IllegalArgumentException(
                    "Row not found: " + rowName
            );
        }

        // Get the actual requested cell
        XSSFRow dataRow = sheet.getRow(rowIndex);
        XSSFCell dataCell = dataRow.getCell(columnIndex);

        String cellData = "";

        if (dataCell != null) {
            DataFormatter formatter = new DataFormatter();
            cellData = formatter.formatCellValue(dataCell);
        }

        wb.close();
        fis.close();

       return cellData;
    }
}
    




//public int rowCount(String sheetName) throws IOException {
//
//  FileInputStream fis = new FileInputStream(xlfilePath);
//  XSSFWorkbook wb = new XSSFWorkbook(fis);
//
//  XSSFSheet sheet = wb.getSheet(sheetName);
//
//  int rowCount = sheet.getLastRowNum();
//
//  wb.close();
//  fis.close();
//
//  return rowCount;
//}

//public int colCount(String sheetName, int rowNum) throws IOException {
//
//  FileInputStream fis = new FileInputStream(xlfilePath);
//  XSSFWorkbook wb = new XSSFWorkbook(fis);
//
//  XSSFSheet sheet = wb.getSheet(sheetName);
//  XSSFRow row = sheet.getRow(rowNum);
//
//  int cellCount = row.getLastCellNum();
//
//  wb.close();
//  fis.close();
//
//  return cellCount;
//}




/////USING INDEXES
///
//  public String getData(String sheetName, int rowNum, int columnNum)
//  throws IOException {
//
//FileInputStream fis = new FileInputStream(xlfilePath);
//XSSFWorkbook wb = new XSSFWorkbook(fis);
//
//XSSFSheet sheet = wb.getSheet(sheetName);
//XSSFRow row = sheet.getRow(rowNum);
//
//String cellData = "";
//
//if (row != null) {
//
//  XSSFCell cell = row.getCell(columnNum);
//
//  if (cell != null) {
//      DataFormatter formatter = new DataFormatter();
//      cellData = formatter.formatCellValue(cell);
//  }
//}
//
//wb.close();
//fis.close();
//
//return cellData;
//}
