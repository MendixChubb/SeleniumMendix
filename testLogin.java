import java.io.FileInputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.*;
import jxl.read.biff.BiffException;
import jxl.read.biff.PasswordException;

public class testLogin {

	public static void main(String[] args) throws BiffException, IOException {
		System.out.println("check");
		String fileInput= "C:\\Users\\suvodip.mukhopadhyay\\Desktop\\test1.xls";
		FileInputStream fis = new FileInputStream(fileInput);
		Workbook wb = Workbook.getWorkbook(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		{
			String Insuredname = sh.getCell(1,1).getContents();
			String Broker = sh.getCell(2,1).getContents();
			
			String Producingregion = sh.getCell(4,1).getContents();
			
			String Producingcountry = sh.getCell(5,1).getContents();
			String Branch = sh.getCell(6,1).getContents();
			String Countryofinsured = sh.getCell(7,1).getContents();
			String Multinationalpolicy = sh.getCell(8,1).getContents();
			String Effectivedate = sh.getCell(9,1).getContents();
			String Currency = sh.getCell(11,1).getContents();
			String Chubbriskmanagement = sh.getCell(12,1).getContents();
			String Direct = sh.getCell(13,1).getContents();
			String FAC = sh.getCell(14,1).getContents();
			String Storageoutside = sh.getCell(15,1).getContents();
			String Storageinformation = sh.getCell(16,1).getContents();
			
			String Claimshistory = sh.getCell(17,1).getContents();
			String Brokeragepct = sh.getCell(18,1).getContents();
			String Noclaims = sh.getCell(19,1).getContents();
			String Bonuspct = sh.getCell(20,1).getContents();
			String GrossnetPrem = sh.getCell(21,1).getContents();
			String Profitcommission = sh.getCell(22,1).getContents();
			String Profitcommissionpct = sh.getCell(23,1).getContents();
			String Basedonpct = sh.getCell(24,1).getContents();

			System.out.println(Insuredname);
			System.out.println(Producingcountry);
		}
}
}
