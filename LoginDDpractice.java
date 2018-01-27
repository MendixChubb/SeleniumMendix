package marine;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;

import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.*;
import jxl.read.biff.BiffException;
import jxl.read.biff.PasswordException;
public class LoginDDpractice 
{
 
	private static final TimeUnit SECONDS = null;
	//static String driverPath = "C:\\Users\\kkswam\\Documents\\Selenium\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe";
	public static WebDriver driver;
	public static String Ann_Open,AccClause,PctOfLimit,CyberClause,RadClause,SancClause,TermClause,CodeDesc,Selection,Amt,Limit,Deduct,WordSource,StowageType;
	public static String NoOfYears,DateAsAt,HistIns,AllRisPer,AllRisLim,AllRisDed,AllRisPct,EarthPer,WindPer,FloodPer,LocName,Address,City,Post,Country,LocLim,Com1Code,Com1Exp;
	public static String  OccType,ConsType,Earth,Flood,Wind,TransitPct,StoragePct,ChubbPct,FacPrem,PolNo,Previewed,Preferred,UW;
	public static String CodeDesc1,Selection1,Amt1,Limit1,Deduct1,WordSource1,StowageType1,NationLess,NationGreat,Continadj,Contin,LandPct,AirPct;
	public static String EarthPeril,EarthLim,EarthDed,EarthPct,WindPeril,WindLim,WindDed,WindPct,FloodPeril,FloodLim,FloodDed,FloodPct;
	
	public static void main(String[] args) throws AWTException, InterruptedException, BiffException, IOException
	{
		// TODO Auto-generated method stub

			String Insuredname, Broker,Multinationalpolicy,FAC,Storageoutside,Storageinformation,Claimshistory,Producingregion;
			String Producingcountry,Branch,Countryofinsured,Effectivedate,Currency,Chubbriskmanagement,Direct;
 			String Brokeragepct, Noclaims,Bonuspct,GrossnetPrem ,Profitcommission,Profitcommissionpct ,Basedonpct;
 			String AccClause,PctOfLimit,CyberClause,RadClause,SancClause,TermClause,CodeDesc,Selection,Amt,Limit,Deduct,WordSource,StowageType;
 			String NoOfYears,DateAsAt,HistIns,AllRisPer,AllRisLim,AllRisDed,AllRisPct,EarthPer,WindPer,FloodPer,LocName,Address,City,Post,Country,LocLim,Com1Code,Com1Exp;
 			String OccType,ConsType,Earth,Flood,Wind,TransitPct,StoragePct,ChubbPct,FacPrem,PolNo,Previewed,Preferred,UW;
 			
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kkswam\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
 		System.setProperty("webdriver.ie.driver", "C:\\Users\\kkswam\\Documents\\Selenium\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
 			
 		driver = new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://sit.marinecargorating.acegroup.com/");
		Robot rb = new Robot(); 

        //Thread.sleep(2000);
		long startTime = System.currentTimeMillis();
		
		Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh;  
	    fh = new FileHandler("C:\\Users\\kkswam\\Desktop\\MyLogFile.log");  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  
        logger.info("***************Regression Testing Started***************");
        try {
    		driver.findElement(By.xpath("//*[text()='Continue to this website (not recommended).']")).click();}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
		
        WebDriverWait waitLog =new WebDriverWait(driver,100);
        WebElement dynamicLog = waitLog.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Login']//following::div[2]/input")));

        //Enter user name by ctrl-v
        
        /*rb.keyPress(KeyEvent.VK_TAB);

        rb.keyRelease(KeyEvent.VK_TAB);

        Thread.sleep(1000);
        
        StringSelection username = new StringSelection("testing@abc.com");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username,username);

         rb.keyPress(KeyEvent.VK_CONTROL);

         rb.keyPress(KeyEvent.VK_V);

         rb.keyRelease(KeyEvent.VK_V);

         rb.keyRelease(KeyEvent.VK_CONTROL);

         

        //tab to password entry field

         rb.keyPress(KeyEvent.VK_TAB);

         rb.keyRelease(KeyEvent.VK_TAB);

         
         Thread.sleep(1000);
         

        //Enter password by ctrl-v

         StringSelection pwd = new StringSelection("Marine123");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);

         rb.keyPress(KeyEvent.VK_CONTROL);

         rb.keyPress(KeyEvent.VK_V);

         rb.keyRelease(KeyEvent.VK_V);

         rb.keyRelease(KeyEvent.VK_CONTROL);*/

         

        //press enter
         driver.findElement(By.xpath("//*[text()='Login']//following::div[2]/input")).sendKeys("testing@abc.com");
         driver.findElement(By.xpath("//*[text()='Login']//following::div[3]/input")).sendKeys("Marine123");

         rb.keyPress(KeyEvent.VK_ENTER);

         rb.keyRelease(KeyEvent.VK_ENTER);

        //wait
         logger.info("*****************Login Successfull********************");
         //Thread.sleep(5000);
         
        // assertEquals("Marine Risk Overview" , driver.getTitle());
         //driver.getTitle();
         
         //logger.info("Testcase 1 : Create New Risk ");
         
         WebDriverWait wait =new WebDriverWait(driver,100);
         WebElement dynamic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Create New Risk']")));
        		
         driver.findElement(By.xpath("//*[text()='Create New Risk']")).click();
         //Thread.sleep(5000);
         
         WebDriverWait waitRisk =new WebDriverWait(driver,100);
         WebElement dynamicRisk = waitRisk.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Insured Name *']//following::td[2]//input")));
         
 		  String src="C:\\Users\\kkswam\\Downloads\\Regression.xlsx";
 		  
 		  FileInputStream fis=new FileInputStream(src);
 		  XSSFWorkbook wb=new XSSFWorkbook(fis);
 		  XSSFSheet sh1=wb.getSheet("RiskDetails");
 		  XSSFSheet sh2=wb.getSheet("Transit");
 		  XSSFSheet sh3=wb.getSheet("Claims");
 		  XSSFSheet sh4=wb.getSheet("Storage");
 		  XSSFSheet sh5=wb.getSheet("Summary");
 		  //FileOutputStream fout=new FileOutputStream(src);
 		  
 		  	DataFormatter format = new DataFormatter();
 		  
 		  	/*Insuredname =  sh1.getRow(1).getCell(1).getStringCellValue();
 			Broker = sh1.getRow(1).getCell(2).getStringCellValue();
 			
 			Producingregion = sh1.getRow(1).getCell(4).getStringCellValue();
 			
 			Producingcountry = sh1.getRow(1).getCell(5).getStringCellValue();
 			Branch = sh1.getRow(1).getCell(6).getStringCellValue();
 			Countryofinsured = sh1.getRow(1).getCell(7).getStringCellValue();
 			Multinationalpolicy = sh1.getRow(1).getCell(8).getStringCellValue();
 			Effectivedate = sh1.getRow(1).getCell(9).getStringCellValue();
 			Currency = sh1.getRow(1).getCell(11).getStringCellValue();
 			Chubbriskmanagement = sh1.getRow(1).getCell(12).getStringCellValue();
 			Direct = sh1.getRow(1).getCell(13).getStringCellValue();
 			FAC = sh1.getRow(1).getCell(14).getStringCellValue();
 			Storageoutside = sh1.getRow(1).getCell(15).getStringCellValue();
 			Storageinformation = sh1.getRow(1).getCell(16).getStringCellValue();
 			
 			Claimshistory = sh1.getRow(1).getCell(17).getStringCellValue();
 			Brokeragepct = sh1.getRow(1).getCell(18).getStringCellValue();
 			Noclaims = sh1.getRow(1).getCell(19).getStringCellValue();
 			Bonuspct = sh1.getRow(1).getCell(20).getStringCellValue();
 			GrossnetPrem = sh1.getRow(1).getCell(21).getStringCellValue();
 			Profitcommission = sh1.getRow(1).getCell(22).getStringCellValue();
 			Profitcommissionpct = sh1.getRow(1).getCell(23).getStringCellValue();
 			Basedonpct = sh1.getRow(1).getCell(24).getStringCellValue();*/
         
 		 	Insuredname =  format.formatCellValue(sh1.getRow(1).getCell(1));
			
			Broker = format.formatCellValue(sh1.getRow(1).getCell(2));
			
			Producingregion = format.formatCellValue(sh1.getRow(1).getCell(4));
			
			Producingcountry = format.formatCellValue(sh1.getRow(1).getCell(5));
			Branch = format.formatCellValue(sh1.getRow(1).getCell(6));
			Countryofinsured = format.formatCellValue(sh1.getRow(1).getCell(7));
			Multinationalpolicy = format.formatCellValue(sh1.getRow(1).getCell(8));
			Effectivedate = format.formatCellValue(sh1.getRow(1).getCell(9));
			Currency = sh1.getRow(1).getCell(11).getStringCellValue();
			Chubbriskmanagement = format.formatCellValue(sh1.getRow(1).getCell(12));
			Direct = format.formatCellValue(sh1.getRow(1).getCell(13));
			FAC = format.formatCellValue(sh1.getRow(1).getCell(14));
			Storageoutside = format.formatCellValue(sh1.getRow(1).getCell(15));
			Storageinformation = format.formatCellValue(sh1.getRow(1).getCell(16));
			
			Claimshistory = format.formatCellValue(sh1.getRow(1).getCell(17));
			Brokeragepct = format.formatCellValue(sh1.getRow(1).getCell(18));
			Noclaims = format.formatCellValue(sh1.getRow(1).getCell(19));
			Bonuspct = format.formatCellValue(sh1.getRow(1).getCell(20));
			GrossnetPrem = format.formatCellValue(sh1.getRow(1).getCell(21));
			Profitcommission = format.formatCellValue(sh1.getRow(1).getCell(22));
			Profitcommissionpct = format.formatCellValue(sh1.getRow(1).getCell(23));
			Basedonpct = format.formatCellValue(sh1.getRow(1).getCell(24));
			//Sheet2 Variables
			Ann_Open = format.formatCellValue(sh2.getRow(1).getCell(1));
			AccClause = format.formatCellValue(sh2.getRow(1).getCell(2));
			PctOfLimit = format.formatCellValue(sh2.getRow(1).getCell(3));
			CyberClause = format.formatCellValue(sh2.getRow(1).getCell(4));
			RadClause = format.formatCellValue(sh2.getRow(1).getCell(5));
			SancClause = format.formatCellValue(sh2.getRow(1).getCell(6));
			TermClause = format.formatCellValue(sh2.getRow(1).getCell(7));
			CodeDesc = format.formatCellValue(sh2.getRow(1).getCell(8));
			Selection = format.formatCellValue(sh2.getRow(1).getCell(9));
			Amt = format.formatCellValue(sh2.getRow(1).getCell(10));
			Limit = format.formatCellValue(sh2.getRow(1).getCell(11));
			Deduct = format.formatCellValue(sh2.getRow(1).getCell(12));
			WordSource = format.formatCellValue(sh2.getRow(1).getCell(13));
			StowageType = format.formatCellValue(sh2.getRow(1).getCell(15));
			//Sheet3 Variables
			NoOfYears = format.formatCellValue(sh3.getRow(1).getCell(1));
			DateAsAt = format.formatCellValue(sh3.getRow(1).getCell(2));
			HistIns = format.formatCellValue(sh3.getRow(1).getCell(3));
			
			//Sheet4 Variables
 			AllRisPer = format.formatCellValue(sh4.getRow(1).getCell(1));
 			AllRisLim = format.formatCellValue(sh4.getRow(1).getCell(2));
 			AllRisDed = format.formatCellValue(sh4.getRow(1).getCell(3));
 			AllRisPct = format.formatCellValue(sh4.getRow(1).getCell(4));
 			EarthPer = format.formatCellValue(sh4.getRow(1).getCell(5));
 			WindPer = format.formatCellValue(sh4.getRow(1).getCell(6));
 			FloodPer = format.formatCellValue(sh4.getRow(1).getCell(7));
 			LocName = format.formatCellValue(sh4.getRow(1).getCell(8));
 			Address = format.formatCellValue(sh4.getRow(1).getCell(9));
 			City = format.formatCellValue(sh4.getRow(1).getCell(10));
 			Post = format.formatCellValue(sh4.getRow(1).getCell(11));
 			Country = format.formatCellValue(sh4.getRow(1).getCell(12));
 			LocLim = format.formatCellValue(sh4.getRow(1).getCell(13));
 			Com1Code = format.formatCellValue(sh4.getRow(1).getCell(14));
 			Com1Exp = format.formatCellValue(sh4.getRow(1).getCell(15));
 			OccType = format.formatCellValue(sh4.getRow(1).getCell(16));
 			ConsType = format.formatCellValue(sh4.getRow(1).getCell(17));
 			Earth = format.formatCellValue(sh4.getRow(1).getCell(18));
 			Flood = format.formatCellValue(sh4.getRow(1).getCell(19));
 			Wind = format.formatCellValue(sh4.getRow(1).getCell(20));
 			//Sheet5 Variables
 			TransitPct = format.formatCellValue(sh5.getRow(1).getCell(1));
 			StoragePct = format.formatCellValue(sh5.getRow(1).getCell(2));
 			ChubbPct = format.formatCellValue(sh5.getRow(1).getCell(3));
 			FacPrem = format.formatCellValue(sh5.getRow(1).getCell(4));
 			PolNo = format.formatCellValue(sh5.getRow(1).getCell(5));
 			Previewed= format.formatCellValue(sh5.getRow(1).getCell(6));
 			Preferred = format.formatCellValue(sh5.getRow(1).getCell(7));
 			UW = format.formatCellValue(sh5.getRow(1).getCell(8));
         driver.findElement(By.xpath("//*[text()='Insured Name *']//following::td[2]//input")).sendKeys(Insuredname);
         driver.findElement(By.xpath("//*[text()='Broker *']//following::td[2]//input")).sendKeys(Broker);
       
		
         Select dropdown = new Select(driver.findElement(By.xpath("//*[text()='Producing Region *']//following::td[2]//select")));
        
         dropdown.selectByVisibleText(Producingregion);
         Actions action = new Actions(driver); 
         
         action.sendKeys(Keys.TAB).build().perform();
         try {
        	
         WebElement prodCountry = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Producing Country *']//following::div[2]/select")));
         Select dropdown1 = new Select(driver.findElement(By.xpath("//*[text()='Producing Country *']//following::div[2]/select")));
         
         dropdown1.selectByVisibleText(Producingcountry);
         
         action.sendKeys(Keys.TAB).build().perform();
         Thread.sleep(1000);}
         catch(Exception e) {
        	 WebElement prodCountry = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Producing Country *']//following::div[2]/select")));
             Select dropdown1 = new Select(driver.findElement(By.xpath("//*[text()='Producing Country *']//following::div[2]/select")));
             
             dropdown1.selectByVisibleText(Producingcountry);
             action.sendKeys(Keys.TAB).build().perform();
             Thread.sleep(1000);
        	 
         }
         
         WebElement branchWait = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Branch *']//following::div[2]/select")));
         Select dropdown3 = new Select(driver.findElement(By.xpath("//*[text()='Branch *']//following::div[2]/select")));
         
         dropdown3.selectByVisibleText(Branch);
         
         Select dropdown2 = new Select(driver.findElement(By.xpath("//*[text()='Country of Insured *']//following::div[2]/select")));
         
         dropdown2.selectByVisibleText(Countryofinsured);
         
         
         Robot rb1 = new Robot();
         
         
         
         Thread.sleep(2000);
         
         rb.keyPress(KeyEvent.VK_ENTER);

         rb.keyRelease(KeyEvent.VK_ENTER);
         
     

         if (Multinationalpolicy.equalsIgnoreCase("Yes"))
         {
         driver.findElement(By.xpath("//*[text()='Multinational Policy *']//following::td[2]//label/input[@value='Yes']")).click();
         }
         else
         {
         driver.findElement(By.xpath("//*[text()='Multinational Policy *']//following::td[2]//label/input[@value='No']")).click();
         }
         
         driver.findElement(By.xpath("//*[text()='Policy Effective Date *']//following::td[2]//div/div/input")).sendKeys(Effectivedate);	
	
          

          action.sendKeys(Keys.TAB).build().perform();
          
          //Thread.sleep(1000);
          
          action.sendKeys(Keys.TAB).build().perform();
          Thread.sleep(1000);
          Select dropdown4 = new Select(driver.findElement(By.xpath("//*[text()='Currency*']//following::td[2]//select")));
          
          dropdown4.selectByVisibleText(Currency);
          action.sendKeys(Keys.TAB).build().perform();
          Thread.sleep(1000);
          Select dropdown5 = new Select(driver.findElement(By.xpath("//*[text()='Chubb Risk Management Involvement *']//following::td[2]//select")));
          
          dropdown5.selectByVisibleText(Chubbriskmanagement);
	
          Select dropdown6 = new Select(driver.findElement(By.xpath("//*[text()='Direct / Inwards Policy *']//following::td[2]//select")));
          
          dropdown6.selectByVisibleText(Direct);
           

          //action.sendKeys(Keys.TAB).build().perform();
          Thread.sleep(1000);
          if (FAC.equalsIgnoreCase("Yes"))
          {
          driver.findElement(By.xpath("//input[@id='FacRI_np_RadioButtonList_widget_AttrRadioButtonList_1_undefined' and @value='Yes']")).click();
          }
          else
          {
        	  driver.findElement(By.xpath("//input[@id='FacRI_np_RadioButtonList_widget_AttrRadioButtonList_1_undefined' and @value='No']")).click();
          }
          Thread.sleep(1000);
          if(Storageoutside.equalsIgnoreCase("Yes"))
          {
          driver.findElement(By.xpath("//*[text()='Storage outside ordinary course of transit *']//following::td[2]//input[@value='Yes']")).click();
          }
          else
          {
        	  driver.findElement(By.xpath("//*[text()='Storage outside ordinary course of transit *']//following::td[2]//input[@value='No']")).click();
          }
          WebElement childStorageWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Can Storage information be entered into model *']//following::td[2]//input[@value='Yes']")));
          //Thread.sleep(1000);
          if (Storageinformation.equalsIgnoreCase("Yes"))
          {
          driver.findElement(By.xpath("//*[text()='Can Storage information be entered into model *']//following::td[2]//input[@value='Yes']")).click();
          }
          else
          {
        	  driver.findElement(By.xpath("//*[text()='Can Storage information be entered into model *']//following::td[2]//input[@value='No']")).click();
          }
          Thread.sleep(1000);
          
          if (Claimshistory.equalsIgnoreCase("Yes"))
          {
          driver.findElement(By.xpath("//input[@id='ClaimsHistoryAvailable_np_RadioButtonList_widget_AttrRadioButtonList_3_undefined' and @value='Yes']")).click();
          }
          else
          {
        	  driver.findElement(By.xpath("//input[@id='ClaimsHistoryAvailable_np_RadioButtonList_widget_AttrRadioButtonList_3_undefined' and @value='No']")).click();
          }
          
          
          Select dropdown7 = new Select(driver.findElement(By.xpath("//*[text()='No Claims Bonus *']//following::td[2]//select")));
          
          dropdown7.selectByVisibleText(Noclaims);
          action.sendKeys(Keys.TAB).build().perform();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//*[text()='Bonus Percentage *']//following::td[2]//input")).sendKeys(Bonuspct);
          
          Select dropdown8 = new Select(driver.findElement(By.xpath("//*[text()='Gross Net Premium *']//following::td[2]//select")));
          
          dropdown8.selectByVisibleText(GrossnetPrem);
          action.sendKeys(Keys.TAB).build().perform();
          
          Select dropdown9 = new Select(driver.findElement(By.xpath("//*[text()='Profit Commission *']//following::td[2]//select")));
          
          dropdown9.selectByVisibleText(Profitcommission);
          action.sendKeys(Keys.TAB).build().perform();
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[text()='Profit Commission % *']//following::td[2]//input")).sendKeys(Profitcommissionpct);
          driver.findElement(By.xpath("//*[text()='Based on % of Gross Premium *']//following::td[2]//input")).sendKeys(Basedonpct);
          driver.findElement(By.xpath("//*[text()='Brokerage % *']//following::td[2]//input")).sendKeys(Brokeragepct);
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[text()='Next']")).click();
        
          //Thread.sleep(5000);
          
          //Transit Exposure screen
          
        
          try {
         WebElement myDynamicElement = (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Annual/Open Cover or Single Shipment *']//following::td[2]//select")));
         Select dropdown21 = new Select(driver.findElement(By.xpath("//*[text()='Annual/Open Cover or Single Shipment *']//following::td[2]//select")));
         
         dropdown21.selectByVisibleText(Ann_Open);
          }catch(Exception e) {
        	  Thread.sleep(2000);
        	  Select dropdown21 = new Select(driver.findElement(By.xpath("//*[text()='Annual/Open Cover or Single Shipment *']//following::td[2]//select")));
              
              dropdown21.selectByVisibleText(Ann_Open);
          }
         String actualTitle = driver.getTitle();
         System.out.println(actualTitle);
         
         String expectedTitle = "Mendix - Transit Exposure";
		assertEquals(expectedTitle,actualTitle);
		
		
		if (AccClause.equalsIgnoreCase("Yes"))
        driver.findElement(By.xpath("//*[text()='Accumulation Clause *']//following::td[2]//input[@value='Yes']")).click();
		else
		driver.findElement(By.xpath("//*[text()='Accumulation Clause *']//following::td[2]//input[@value='No']")).click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Percentage of limit (%) *']//following::td[2]//input")).sendKeys(PctOfLimit);
        if (CyberClause.equalsIgnoreCase("Yes"))
        driver.findElement(By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::td[2]//input[@value='Yes']")).click();	
        else
		driver.findElement(By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::td[2]//input[@value='No']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Information']//following::button")).click();
		Thread.sleep(1000);
		if (RadClause.equalsIgnoreCase("Yes"))
		driver.findElement(By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::span[3]//following::div[2]/label/input[@value='Yes']")).click();
		else 
		driver.findElement(By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::span[3]//following::div[2]/label/input[@value='No']")).click();
		if (SancClause.equalsIgnoreCase("Yes"))
		driver.findElement(By.xpath("//*[text()='Chubb approved Sanctions Limitation and Exclusion Clause *']//following::div[2]//input[@value='Yes']")).click();
		else
		driver.findElement(By.xpath("//*[text()='Chubb approved Sanctions Limitation and Exclusion Clause *']//following::div[2]//input[@value='No']")).click();	
		if (TermClause.equalsIgnoreCase("Yes"))
		driver.findElement(By.xpath("//*[text()='Termination of Transit Clause (Terrorism) JC 2009/ 56 01/01/2009 *']//following::div[2]//input[@value='Yes']")).click();
		else
		driver.findElement(By.xpath("//*[text()='Termination of Transit Clause (Terrorism) JC 2009/ 56 01/01/2009 *']//following::div[2]//input[@value='No']")).click();
		
		driver.findElement(By.xpath("//label[text()='Code description *']//following::button[1]")).click();
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//*[text()='Aggregates/rock/stone (92516)']"));
		
		action.doubleClick(element).perform();
		/*WebElement popup1 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Information']")));
        
        String actText= driver.findElement(By.xpath("//*[text()='Information']")).getText();
        String exptext="Information";
        
	    if(actText.contains(exptext)) 
	    	driver.findElement(By.xpath("//*[text()='Information']//following::div[2]/button")).click();
	    else 
	    System.out.println("No Pop up message for Code description ");*/
	    
		Select dropdown22 = new Select(driver.findElement(By.xpath("//*[text()='Selection *']//following::select[1]")));
        
        dropdown22.selectByVisibleText(Selection);
        
        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[2]")).sendKeys(Amt);//Amount
        action.sendKeys(Keys.TAB).build().perform();
        
        //Thread.sleep(1000);
        
        
        
        Select dropdown23 = new Select(driver.findElement(By.xpath("//*[text()='Selection *']//following::select[2]")));
        
        dropdown23.selectByVisibleText(WordSource);
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()='Stowage type *']//following::div[@class='mx-name-textBox9 Factor']//following::button")).click();
		Thread.sleep(1000);
		WebElement element1 = driver.findElement(By.xpath("//*[text()='Bulk']"));
		action.doubleClick(element1).perform();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[text()='Amount *']//following::input[3]")).sendKeys(Limit);//Limit
		Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[4]")).sendKeys(Deduct);//Deductible
		Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Next']")).click();
		
        //Claims History	
        
        WebElement myDynamicElement1 = (new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Number of years of claims history *']//following::td[2]//input")));
        
        String actualTitle1 = driver.getTitle();
        System.out.println(actualTitle1);
       
        String expectedTitle1 = "Mendix - Claims History";
		assertEquals(expectedTitle1,actualTitle1);
		
		driver.findElement(By.xpath("//*[text()='Number of years of claims history *']//following::td[2]//input")).sendKeys(NoOfYears);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3500);
        
        driver.findElement(By.xpath("//*[text()='Data as at *']//following::div[@class='mx-name-datePicker1']//input[1]")).sendKeys(DateAsAt);
        
        Thread.sleep(1000);
        Select dropdown31 = new Select(driver.findElement(By.xpath("//*[text()='Historical insured value available *']//following::div[@class='mx-name-dropDown1 Format']/select")));
        
        dropdown31.selectByVisibleText(HistIns);
       

        	
        	  
        try {
        	Thread.sleep(6000);
        	 driver.findElement(By.xpath("//*[text()='Next']")).click();
        	 WebElement dynamicStore = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All Risks excl CAT']//following::td[1]/div/select")));
        	 
        }catch(Exception e) {
        	Thread.sleep(4000);
        	 driver.findElement(By.xpath("//*[text()='Next']")).click();
        	 WebElement dynamicStore = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All Risks excl CAT']//following::td[1]/div/select")));
        
        }
        
		
		
        //driver.findElement(By.xpath("//*[text()='Next']")).click();
        
        
	
		
		//Storage screen
        //WebElement dynamicStore = (new WebDriverWait(driver, 100)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All Risks excl CAT']//following::td[1]/div/select")));
		String risk= driver.findElement(By.xpath("//td[@class='header']//preceding::td[2]//label")).getText();
		//System.out.println("Printing risk id: "+risk);
		
		Select dropdown41 = new Select(driver.findElement(By.xpath("//*[text()='All Risks excl CAT']//following::td[1]/div/select")));
		dropdown41.selectByVisibleText(AllRisPer);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='All Risks excl CAT']//following::td[2]/div/input")).sendKeys(AllRisLim);
		
		driver.findElement(By.xpath("//*[text()='All Risks excl CAT']//following::td[3]/div/input")).sendKeys(AllRisDed);
		
		driver.findElement(By.xpath("//*[text()='All Risks excl CAT']//following::td[4]/div/input")).sendKeys(AllRisPct);
		
		Select dropdown42 = new Select(driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[1]/div/select")));
        
        dropdown42.selectByVisibleText(EarthPer);
        Select dropdown43 = new Select(driver.findElement(By.xpath("//*[text()='Windstorm']//following::td[1]/div/select")));
        
        dropdown43.selectByVisibleText(WindPer);
        Select dropdown44 = new Select(driver.findElement(By.xpath("//*[text()='Flood']//following::td[1]/div/select")));
        
        dropdown44.selectByVisibleText(FloodPer);
        action.sendKeys(Keys.TAB).build().perform();
        //Locations
        Thread.sleep(1000);
        
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox1']/input")).sendKeys(LocName);
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox2']/input")).sendKeys(Address);
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox3']/input")).sendKeys(City);
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox4']/input")).sendKeys(Post);
		
		driver.findElement(By.xpath("//div[@class='mx-name-textBox6']//following::div[1]/button")).click();
		Thread.sleep(1000);
		WebElement element11 = driver.findElement(By.xpath("//*[text()='Austria']"));
		
		action.doubleClick(element11).perform();
		
		
		
		driver.findElement(By.xpath("//div[@class='mx-name-textBox7']//following::div[1]/button")).click();
		Thread.sleep(1000);
		WebElement element12 = driver.findElement(By.xpath("//*[text()='Animal feed (2300)']"));//Commodity Code1
		
		action.doubleClick(element12).perform();
		
		
		driver.findElement(By.xpath("//div[@class='mx-name-textBox9']//following::div[1]/button")).click();
		Thread.sleep(1000);
		WebElement element13 = driver.findElement(By.xpath("//*[text()='Air']"));//Occupancy type
		
		action.doubleClick(element13).perform();
		driver.findElement(By.xpath("//div[@class='mx-name-textBox9']//following::div[3]/button")).click();
		Thread.sleep(1000);
		WebElement element14 = driver.findElement(By.xpath("//*[text()='Masonry']"));//Construction type
		
		action.doubleClick(element14).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox7']/input")).sendKeys(LocLim);
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox8']/input")).sendKeys(Com1Exp);
	
		Select dropdown45 = new Select(driver.findElement(By.xpath("//*[text()='Earthquake *']//following::div[@class='mx-name-dropDown1']/select")));
        
        dropdown45.selectByVisibleText(Earth);
	
        Select dropdown46 = new Select(driver.findElement(By.xpath("//*[text()='Earthquake *']//following::div[@class='mx-name-dropDown6']/select")));
        
        dropdown46.selectByVisibleText(Flood);
        
        Select dropdown47 = new Select(driver.findElement(By.xpath("//*[text()='Earthquake *']//following::div[@class='mx-name-dropDown7']/select")));
        
        dropdown47.selectByVisibleText(Wind);
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[text()='Next']")).click();
        
        //Summary screen
        
        WebElement myDynamicElement2 = (new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='TRANSIT  Rate (%)']//following::div[3]/input")));
        
        driver.findElement(By.xpath("//*[text()='TRANSIT  Rate (%)']//following::div[3]/input")).sendKeys(TransitPct);
        
        driver.findElement(By.xpath("//*[text()='STORAGE RATE (%)']//following::div[3]/input")).sendKeys(StoragePct);
        
        driver.findElement(By.xpath("//*[text()='Chubb Share %']//following::td[2]//input")).sendKeys(ChubbPct);
        driver.findElement(By.xpath("//*[text()='FAC RI Premium *']//following::td[1]//input")).sendKeys(FacPrem);
        
        driver.findElement(By.xpath("//*[text()='Policy Number']//following::td[1]//input")).sendKeys(PolNo);//Policy Number
        
        Select dropdown51 = new Select(driver.findElement(By.xpath("//*[text()='Has this risk been Peer Reviewed? *']//following::td[1]/div/select")));
        
        dropdown51.selectByVisibleText(Previewed);
        
        Select dropdown52 = new Select(driver.findElement(By.xpath("//*[text()='Has this risk been Referred? *']//following::td[1]/div/select")));
        
        dropdown52.selectByVisibleText(Preferred);
        
        driver.findElement(By.xpath("//*[text()='Underwriting Rationale *']//following::div/textarea")).sendKeys(UW);
        
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[text()='Calculate/Save']")).click();
        
        try {
        	Thread.sleep(6000);	
        	WebElement calculWait1=(new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Exit']")));
            driver.findElement(By.xpath("//*[text()='Exit']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()='Yes' and @class='btn mx-button mx-name-actionButton1 btn-success']")).click();
        }catch(Exception e) {
        	e.printStackTrace();
        	Thread.sleep(3000);
        	WebElement calculWait2=(new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Exit']")));
            driver.findElement(By.xpath("//*[text()='Exit']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()='Yes' and @class='btn mx-button mx-name-actionButton1 btn-success']")).click();
        }
        
        
        
        
        //logger.info("Testing is done for Create New Risk");
        
        /*logger.info("*****************Regression Testing Successfully ended********************");
        long stopTime = System.currentTimeMillis();
        double checktime = ((stopTime - startTime)/1000.0);
        logger.info("Total time of execution =  "+checktime+" seconds");
        logger.info("System Risk id is:"+risk); (/
        //Renewal
        /*Thread.sleep(2000);
        WebElement elementr1= driver.findElement(By.xpath("//*[text()='System Risk ID']//following::tr[1]/td[1]/div"));
        elementr1.click();
        driver.findElement(By.xpath("//*[text()='Renew']")).click();
        driver.findElement(By.xpath("//*[text()='Proceed']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Yes, I will update the Policy Status before the Renewal Process.']")).click();
        Thread.sleep(1000);
        elementr1.click();
        driver.findElement(By.xpath("//*[text()='Edit']")).click();
        WebDriverWait waitRiskr1 =new WebDriverWait(driver,20);
        WebElement dynamicRiskr1 = waitRiskr1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Insured Name *']//following::td[2]//input")));
        driver.findElement(By.xpath("//*[text()='Summary']")).click();
        WebElement myDynamicElement2r1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='TRANSIT  Rate (%)']//following::div[3]/input")));
        driver.findElement(By.xpath("//*[text()='Risk Status *']//following::td[2]//select"));
        Select dropStatusr1= new Select(driver.findElement(By.xpath("//*[text()='Risk Status *']//following::td[2]//select")));
        dropStatusr1.selectByVisibleText("Bound");
        driver.findElement(By.xpath("//*[text()='Calculate/Save']")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[text()='Exit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Yes' and @class='btn mx-button mx-name-actionButton1 btn-success']")).click();*/
        
        Renewal r =new Renewal();
        r.renewFlow();
        r.renewEdit();
        logger.info("*****************Regression Testing Successfully ended********************");
        long stopTime = System.currentTimeMillis();
        double checktime = ((stopTime - startTime)/60000.0);
        logger.info("Total time of execution =  "+checktime+" minutes");
        logger.info("System New Risk id is:"+risk);
        logger.info("System Renewal Risk id is:"+r.riskRenew);
        
	}


	
	

	 

	private static void assertEquals(String string, String title) {
		// TODO Auto-generated method stub
		
	}
}



