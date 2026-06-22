package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    private Workbook workbook;

   

	public void loadExcel(String filePath) {

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            workbook = new XSSFWorkbook(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public int getRowCount(String sheetName) {

        Sheet sheet = workbook.getSheet(sheetName);

        return sheet.getLastRowNum();
    }

    public Map<String,String> getRowData(String sheetName,
                                         int rowNum) {

        Map<String,String> data =
                new HashMap<>();

        Sheet sheet =
                workbook.getSheet(sheetName);

        Row headerRow =
                sheet.getRow(0);

        Row currentRow =
                sheet.getRow(rowNum);

        DataFormatter formatter =
                new DataFormatter();

        for(int i=0;
            i<headerRow.getLastCellNum();
            i++) {

            String key =
                    formatter.formatCellValue(
                            headerRow.getCell(i));

            String value =
                    formatter.formatCellValue(
                            currentRow.getCell(i));

            data.put(key, value);
        }

        return data;
    }

    public void closeWorkbook() {

        try {

            workbook.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}