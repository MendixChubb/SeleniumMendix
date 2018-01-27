package marine;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MarineEx {
	public static WebDriver driver;
	@Test
	public void script2() throws AWTException, IOException, InterruptedException{
		String src="C:\\Users\\kkswam\\Downloads\\Regression.xlsx";
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheet("RiskDetails");
		  XSSFSheet sh2=wb.getSheet("Transit");
		  XSSFSheet sh3=wb.getSheet("Claims");
		  XSSFSheet sh4=wb.getSheet("Storage");
		  XSSFSheet sh5=wb.getSheet("Summary");
		XSSFSheet sh6=wb.getSheet("Login");
		DataFormatter format=new DataFormatter();
		String username=format.formatCellValue(sh6.getRow(1).getCell(1));
		String password=format.formatCellValue(sh6.getRow(1).getCell(2));
		//Sheet1 Variables
		String insured =  format.formatCellValue(sh1.getRow(3).getCell(1));
		
		String broker = format.formatCellValue(sh1.getRow(3).getCell(2));
		
		String region = format.formatCellValue(sh1.getRow(3).getCell(4));
		
		String country = format.formatCellValue(sh1.getRow(3).getCell(5));
		String branch = format.formatCellValue(sh1.getRow(3).getCell(6));
		String countryIns = format.formatCellValue(sh1.getRow(3).getCell(7));
		String mul = format.formatCellValue(sh1.getRow(3).getCell(8));
		String effect = format.formatCellValue(sh1.getRow(3).getCell(9)); 
		String Currency = sh1.getRow(1).getCell(11).getStringCellValue();
		
		String crisk = format.formatCellValue(sh1.getRow(3).getCell(12));
		String direct = format.formatCellValue(sh1.getRow(3).getCell(13));
		String fac = format.formatCellValue(sh1.getRow(3).getCell(14));
		String storOut = format.formatCellValue(sh1.getRow(3).getCell(15));
		String storInfo = format.formatCellValue(sh1.getRow(3).getCell(16));
		
		String claim = format.formatCellValue(sh1.getRow(3).getCell(17));
		String bropct = format.formatCellValue(sh1.getRow(3).getCell(18));
		String noClaims = format.formatCellValue(sh1.getRow(3).getCell(19));
		String bonuspct = format.formatCellValue(sh1.getRow(3).getCell(20));
		String gross = format.formatCellValue(sh1.getRow(3).getCell(21));
		String profit = format.formatCellValue(sh1.getRow(3).getCell(22));
		String profitpct = format.formatCellValue(sh1.getRow(3).getCell(23));
		String Basedonpct = format.formatCellValue(sh1.getRow(3).getCell(24));
		//Sheet2 Variables
		String annual = format.formatCellValue(sh2.getRow(3).getCell(1));
		String accumulation = format.formatCellValue(sh2.getRow(3).getCell(2));
		String pol = format.formatCellValue(sh2.getRow(3).getCell(3));
		String cyber = format.formatCellValue(sh2.getRow(3).getCell(4));
		String radio = format.formatCellValue(sh2.getRow(3).getCell(5));
		String sanc = format.formatCellValue(sh2.getRow(3).getCell(6));
		String term = format.formatCellValue(sh2.getRow(3).getCell(7));
		String ccd = format.formatCellValue(sh2.getRow(3).getCell(8));
		String sel = format.formatCellValue(sh2.getRow(3).getCell(9));
		String amt = format.formatCellValue(sh2.getRow(3).getCell(10));
		String limit = format.formatCellValue(sh2.getRow(3).getCell(11));
		String deduct = format.formatCellValue(sh2.getRow(3).getCell(12));
		String word = format.formatCellValue(sh2.getRow(3).getCell(13));
		String stowageType = format.formatCellValue(sh2.getRow(3).getCell(15));
		String natl = format.formatCellValue(sh2.getRow(3).getCell(24));
		String natg = format.formatCellValue(sh2.getRow(3).getCell(25));
		//Sheet 3 Variables
		
		String noy = format.formatCellValue(sh3.getRow(3).getCell(1));
		String date = format.formatCellValue(sh3.getRow(3).getCell(2));
		String hist = format.formatCellValue(sh3.getRow(3).getCell(3));
		//Sheet 4 Variables
			String allp = format.formatCellValue(sh4.getRow(3).getCell(1));
			String alllim = format.formatCellValue(sh4.getRow(3).getCell(2));
			String allded = format.formatCellValue(sh4.getRow(3).getCell(3));
			String pctded = format.formatCellValue(sh4.getRow(3).getCell(4));
			String earth = format.formatCellValue(sh4.getRow(3).getCell(21));
			String earthlim = format.formatCellValue(sh4.getRow(3).getCell(22));
			String earthded = format.formatCellValue(sh4.getRow(3).getCell(23));
			String earthpct = format.formatCellValue(sh4.getRow(3).getCell(24));
			String wind = format.formatCellValue(sh4.getRow(3).getCell(25));
			String windlim = format.formatCellValue(sh4.getRow(3).getCell(26));
			String windded = format.formatCellValue(sh4.getRow(3).getCell(27));
			String windpct = format.formatCellValue(sh4.getRow(3).getCell(28));
			String flood = format.formatCellValue(sh4.getRow(3).getCell(29));
			String floodlim = format.formatCellValue(sh4.getRow(3).getCell(30));
			String floodded = format.formatCellValue(sh4.getRow(3).getCell(31));
			String floodpct = format.formatCellValue(sh4.getRow(3).getCell(32));
			String county = format.formatCellValue(sh4.getRow(3).getCell(33));
			String state = format.formatCellValue(sh4.getRow(3).getCell(34));
			String loc = format.formatCellValue(sh4.getRow(3).getCell(8));
			String add = format.formatCellValue(sh4.getRow(3).getCell(9));
			String city = format.formatCellValue(sh4.getRow(3).getCell(10));
			String post = format.formatCellValue(sh4.getRow(3).getCell(11));
			String coun = format.formatCellValue(sh4.getRow(3).getCell(12));
			String loclim = format.formatCellValue(sh4.getRow(3).getCell(13));
			String Com1Code = format.formatCellValue(sh4.getRow(3).getCell(14));
			String com1exp = format.formatCellValue(sh4.getRow(3).getCell(15));
			String OccType = format.formatCellValue(sh4.getRow(3).getCell(16));
			String ConsType = format.formatCellValue(sh4.getRow(3).getCell(17));
			String Earth = format.formatCellValue(sh4.getRow(3).getCell(18));
			String Flood = format.formatCellValue(sh4.getRow(3).getCell(19));
			String Wind = format.formatCellValue(sh4.getRow(3).getCell(20));
			//Sheet 5 Variables
			
			String trans = format.formatCellValue(sh5.getRow(3).getCell(1));
 			String stor = format.formatCellValue(sh5.getRow(3).getCell(2));
 			String chubbs = format.formatCellValue(sh5.getRow(3).getCell(3));
 			String facp = format.formatCellValue(sh5.getRow(3).getCell(4));
 			String polno= format.formatCellValue(sh5.getRow(3).getCell(5));
 			String rev= format.formatCellValue(sh5.getRow(3).getCell(6));
 			String ref = format.formatCellValue(sh5.getRow(3).getCell(7));
 			String uws = format.formatCellValue(sh5.getRow(3).getCell(8));
 			String stat=format.formatCellValue(sh5.getRow(3).getCell(9));
 			String byWhom=format.formatCellValue(sh5.getRow(3).getCell(10));
 			String toWhom=format.formatCellValue(sh5.getRow(3).getCell(11));
	MarinePOM m=new MarinePOM(driver);
	m.init(username,password);
	m.riskDet(insured, broker, region, country, branch, countryIns, mul, effect);
	m.riskDet2( crisk, direct, fac, storOut, storInfo, claim, bropct, noClaims, bonuspct, gross, profit, profitpct, Basedonpct);
	m.transit(annual, accumulation, pol, cyber, radio, sanc, term);
	m.transitInt(ccd,sel,amt,word,limit,deduct,natl,natg);
	m.claims(noy, date, hist);
	m.storage(allp, alllim, allded, pctded, earth, earthlim, earthded, earthpct, wind, windlim, windded, windpct, flood, floodlim, floodded, floodpct);
	m.storage2(loc, add, city, post, county, state, coun, loclim, com1exp, Earth, Wind, Flood);;
	m.sum(stat, trans, stor, chubbs, polno, rev, byWhom, ref, toWhom, uws);
	}

}
