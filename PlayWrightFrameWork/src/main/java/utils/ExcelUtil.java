package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtil {

    public static String getCellData(
            String sheetName,
            int row,
            int col) {

        String value = "";

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "testdata/LoginData.xlsx");

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheet(sheetName);

            value = sheet
                    .getRow(row)
                    .getCell(col)
                    .getStringCellValue();

            workbook.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return value;
    }
}