package Utilities;

import jxl.Sheet;
import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by ShykulaD on 03/10/2019.
 */
public class Exceldata {

    @DataProvider(name = "TestData")
    public Object[][] ExcelDatas() throws IOException, BiffException {

        String filepath = "/Users/denys/Documents/GitHub/amazonGoods/src/test/java/TestData/TestData.xls";

        // Read Excel data
        FileInputStream Excelfile = new FileInputStream(filepath);

        // Read WorkBook
        Workbook Exbook = Workbook.getWorkbook(Excelfile);

        // Read Sheet
        Sheet ExSheet = Exbook.getSheet("TestData");

        // Read Rows and Columns in a sheet
        int Rows = ExSheet.getRows();
        int Columns = ExSheet.getColumns();

        // Now Save both Rows and Columns in String array

        String TestData[][] = new String[Rows - 1][Columns];
        int count = 0;

        // For loop to get the cell data
        for (int i = 1; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                // Read Cells from Sheet
                Cell Excell = ExSheet.getCell(j, i);
                // Now Get contents from String Array
                TestData[count][j] = Excell.getContents();
            }
            count++;
        }
        Excelfile.close();
        return TestData;

    }
}
