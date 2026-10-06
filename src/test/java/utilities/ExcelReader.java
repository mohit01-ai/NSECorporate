package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

public static Workbook workbook;
public static Sheet sheet;

public static void openExcelFile(String path,String sheetName) throws Exception {
    try(FileInputStream file = new FileInputStream(path)){
      workbook= new XSSFWorkbook(file);
      sheet = workbook.getSheet(sheetName);
    }catch (Exception e){
        throw new Exception("error in opening file :"+path);
    }
}
public static String getCellData(int row,int column){
    return sheet.getRow(row).getCell(column).toString();
}

public static int getRowCount(){
    return sheet.getPhysicalNumberOfRows();
}
public static int getColmCount(){
    return sheet.getRow(0).getPhysicalNumberOfCells();
}
}
