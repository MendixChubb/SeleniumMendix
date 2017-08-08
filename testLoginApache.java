import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class testLoginApache {
	
	public static void main(String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis();
		
		Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh;  
	    fh = new FileHandler("C:\\Users\\suvodip.mukhopadhyay\\Desktop\\MyLogFile.log");  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  
        logger.info("checking log");
		FileInputStream fis = new FileInputStream("C:\\Users\\suvodip.mukhopadhyay\\Desktop\\test.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0);
 

    /*    for(int i=0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals("UserName"))
                col_num = i;
        }
 */
        row = sheet.getRow(1);
        XSSFCell cell1 = row.getCell(1);
        String value = cell1.getStringCellValue();
        System.out.println("Value of the Excel Cell is - "+ value);
        
        
        logger.info("Testing is done for "+value);
        long stopTime = System.currentTimeMillis();
        double checktime = ((stopTime - startTime)/1000.0);
        logger.info("Total time of execution "+checktime+" seconds");
       
	}
}

