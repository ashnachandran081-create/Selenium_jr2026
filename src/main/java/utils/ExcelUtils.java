package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;
    private static DataFormatter formatter = new DataFormatter();

    public static void loadExcel(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
    }

    public static String getCellData(int row, int col) {
        Cell cell = sheet.getRow(row).getCell(col);

        if (cell == null) {
            return "";
        }

        return formatter.formatCellValue(cell);
    }

    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public static void closeExcel() throws IOException {
        workbook.close();
    }
}