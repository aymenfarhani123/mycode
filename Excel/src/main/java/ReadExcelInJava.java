import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelInJava {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream(new File("C:/Users/ITPEAC/Desktop/mapping.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        while (itr.hasNext())
        {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch (cell.getCellType())
                {
                    case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                        System.out.print(cell.getStringCellValue() + "\t\t\t");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                        System.out.print(cell.getNumericCellValue() + "\t\t\t");
                        break;
                    default:
                }
            }
            System.out.println("");
        }
}
}