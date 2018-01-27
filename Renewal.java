package marine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	
	public class Renewal extends LoginDDpractice {
		public String riskRenew;
		public static void popUpClick () {
			String actText= driver.findElement(By.xpath("//*[text()='Information']")).getText();
	         String exptext="Information";
	         
		    if(actText.contains(exptext)) 
		    	driver.findElement(By.xpath("//*[text()='Information']//following::div[2]/button")).click();
		    else 
		    System.out.println("No Pop up message ");
		}
	public void renewFlow() throws InterruptedException {
	WebElement riskWait1=(new WebDriverWait(driver,40)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='System Risk ID']//following::tr[1]/td[1]/div")));
   
	WebElement elementr1= driver.findElement(By.xpath("//*[text()='System Risk ID']//following::tr[1]/td[1]/div"));
    elementr1.click();
    driver.findElement(By.xpath("//*[text()='Renew']")).click();
    driver.findElement(By.xpath("//*[text()='Proceed']")).click();
    //Thread.sleep(1000);
    WebElement renewpopWait=(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Renewal']")));
    String actText1=driver.findElement(By.xpath("//*[text()='Renewal']")).getText();
    String exptext1="Renewal";
    if(actText1.contains(exptext1))
    driver.findElement(By.xpath("//*[text()='Yes, I will update the Policy Status before the Renewal Process.']")).click();
    else
    System.out.println("No Warning Message");
    Thread.sleep(1000);
    elementr1.click();
    driver.findElement(By.xpath("//*[text()='Edit']")).click();
    WebDriverWait waitRiskr1 =new WebDriverWait(driver,60);
    WebElement dynamicRiskr1 = waitRiskr1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Insured Name *']//following::td[2]//input")));
   
    
    driver.findElement(By.xpath("//*[text()='Summary']")).click();
    WebElement myDynamicElement2r1 = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='TRANSIT  Rate (%)']//following::div[3]/input")));
    driver.findElement(By.xpath("//*[text()='Risk Status *']//following::td[2]//select"));
    Select dropStatusr1= new Select(driver.findElement(By.xpath("//*[text()='Risk Status *']//following::td[2]//select")));
    dropStatusr1.selectByVisibleText("Bound");
    driver.findElement(By.xpath("//*[text()='Calculate/Save']")).click();
    try {
    Thread.sleep(9000);
    driver.findElement(By.xpath("//*[text()='Exit']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[text()='Yes' and @class='btn mx-button mx-name-actionButton1 btn-success']")).click();}
    catch(Exception e) {
    	Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Exit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Yes' and @class='btn mx-button mx-name-actionButton1 btn-success']")).click();
    }
    WebElement riskWait2=(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='System Risk ID']//following::tr[1]/td[1]/div")));
	}
	public void renewEdit() throws IOException, InterruptedException {
		String src="C:\\Users\\kkswam\\Downloads\\Regression.xlsx";
		  
		  FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheet("RiskDetails");
		XSSFSheet sh2=wb.getSheet("Transit");
		XSSFSheet sh3=wb.getSheet("Claims");
		XSSFSheet sh4=wb.getSheet("Storage");
		XSSFSheet sh5=wb.getSheet("Summary");
		String Insuredname, Broker,Multinationalpolicy,FAC,Storageoutside,Storageinformation,Claimshistory,Producingregion;
		String Producingcountry,Branch,Countryofinsured,Effectivedate,Currency,Chubbriskmanagement,Direct;
		String Brokeragepct, Noclaims,Bonuspct,GrossnetPrem ,Profitcommission,Profitcommissionpct ,Basedonpct;
		DataFormatter format = new DataFormatter();
		Insuredname =  format.formatCellValue(sh1.getRow(2).getCell(1));
		
		Broker = format.formatCellValue(sh1.getRow(2).getCell(2));
		
		Producingregion = format.formatCellValue(sh1.getRow(2).getCell(4));
		
		Producingcountry = format.formatCellValue(sh1.getRow(2).getCell(5));
		Branch = format.formatCellValue(sh1.getRow(2).getCell(6));
		Countryofinsured = format.formatCellValue(sh1.getRow(2).getCell(7));
		Multinationalpolicy = format.formatCellValue(sh1.getRow(2).getCell(8));
		Effectivedate = format.formatCellValue(sh1.getRow(2).getCell(9));
		//Currency = sh1.getRow(2).getCell(11).getStringCellValue();
		Chubbriskmanagement = format.formatCellValue(sh1.getRow(2).getCell(12));
		Direct = format.formatCellValue(sh1.getRow(2).getCell(13));
		FAC = format.formatCellValue(sh1.getRow(2).getCell(14));
		Storageoutside = format.formatCellValue(sh1.getRow(2).getCell(15));
		Storageinformation = format.formatCellValue(sh1.getRow(2).getCell(16));
		
		Claimshistory = format.formatCellValue(sh1.getRow(2).getCell(17));
		Brokeragepct = format.formatCellValue(sh1.getRow(2).getCell(18));
		Noclaims = format.formatCellValue(sh1.getRow(2).getCell(19));
		Bonuspct = format.formatCellValue(sh1.getRow(2).getCell(20));
		GrossnetPrem = format.formatCellValue(sh1.getRow(2).getCell(21));
		Profitcommission = format.formatCellValue(sh1.getRow(2).getCell(22));
		Profitcommissionpct = format.formatCellValue(sh1.getRow(2).getCell(23));
		Basedonpct = format.formatCellValue(sh1.getRow(2).getCell(24));
		//Transit sheet variables
		
		Ann_Open = format.formatCellValue(sh2.getRow(2).getCell(1));
		AccClause = format.formatCellValue(sh2.getRow(2).getCell(2));
		PctOfLimit = format.formatCellValue(sh2.getRow(2).getCell(3));
		CyberClause = format.formatCellValue(sh2.getRow(2).getCell(4));
		RadClause = format.formatCellValue(sh2.getRow(2).getCell(5));
		CodeDesc1 = format.formatCellValue(sh2.getRow(2).getCell(16));
		Selection1 = format.formatCellValue(sh2.getRow(2).getCell(17));
		Amt1 = format.formatCellValue(sh2.getRow(2).getCell(18));
		Limit1 = format.formatCellValue(sh2.getRow(2).getCell(19));
		Deduct1 = format.formatCellValue(sh2.getRow(2).getCell(20));
		WordSource1 = format.formatCellValue(sh2.getRow(2).getCell(21));
		StowageType1 = format.formatCellValue(sh2.getRow(2).getCell(22));
		NationLess = format.formatCellValue(sh2.getRow(2).getCell(23));
		NationGreat = format.formatCellValue(sh2.getRow(2).getCell(24));
		Continadj = format.formatCellValue(sh2.getRow(2).getCell(25));
		Contin = format.formatCellValue(sh2.getRow(2).getCell(26));
		LandPct = format.formatCellValue(sh2.getRow(2).getCell(27));
		AirPct = format.formatCellValue(sh2.getRow(2).getCell(28));
		
		//Claims History Variables
		NoOfYears = format.formatCellValue(sh3.getRow(2).getCell(1));
		DateAsAt = format.formatCellValue(sh3.getRow(2).getCell(2));
		HistIns = format.formatCellValue(sh3.getRow(2).getCell(3));
		
		//Storage screen Variables
			AllRisPer = format.formatCellValue(sh4.getRow(2).getCell(1));
			AllRisLim = format.formatCellValue(sh4.getRow(2).getCell(2));
			AllRisDed = format.formatCellValue(sh4.getRow(2).getCell(3));
			AllRisPct = format.formatCellValue(sh4.getRow(2).getCell(4));
			EarthPer = format.formatCellValue(sh4.getRow(2).getCell(5));
			WindPer = format.formatCellValue(sh4.getRow(2).getCell(6));
			FloodPer = format.formatCellValue(sh4.getRow(2).getCell(7));
			LocName = format.formatCellValue(sh4.getRow(2).getCell(8));
			Address = format.formatCellValue(sh4.getRow(2).getCell(9));
			City = format.formatCellValue(sh4.getRow(2).getCell(10));
			Post = format.formatCellValue(sh4.getRow(2).getCell(11));
			Country = format.formatCellValue(sh4.getRow(2).getCell(12));
			LocLim = format.formatCellValue(sh4.getRow(2).getCell(13));
			Com1Code = format.formatCellValue(sh4.getRow(2).getCell(14));
			Com1Exp = format.formatCellValue(sh4.getRow(2).getCell(15));
			OccType = format.formatCellValue(sh4.getRow(2).getCell(16));
			ConsType = format.formatCellValue(sh4.getRow(2).getCell(17));
			Earth = format.formatCellValue(sh4.getRow(2).getCell(18));
			Flood = format.formatCellValue(sh4.getRow(2).getCell(19));
			Wind = format.formatCellValue(sh4.getRow(2).getCell(20));
			EarthPeril = format.formatCellValue(sh4.getRow(2).getCell(21));
			EarthLim = format.formatCellValue(sh4.getRow(2).getCell(22));
			EarthDed = format.formatCellValue(sh4.getRow(2).getCell(23));
			EarthPct = format.formatCellValue(sh4.getRow(2).getCell(24));
			WindPeril = format.formatCellValue(sh4.getRow(2).getCell(25));
			WindLim = format.formatCellValue(sh4.getRow(2).getCell(26));
			WindDed = format.formatCellValue(sh4.getRow(2).getCell(27));
			WindPct = format.formatCellValue(sh4.getRow(2).getCell(28));
			FloodPeril = format.formatCellValue(sh4.getRow(2).getCell(29));
			FloodLim = format.formatCellValue(sh4.getRow(2).getCell(30));
			FloodDed = format.formatCellValue(sh4.getRow(2).getCell(31));
			FloodPct = format.formatCellValue(sh4.getRow(2).getCell(32));
			
			//Summary Sheet Variables
			
			PolNo = format.formatCellValue(sh5.getRow(2).getCell(5));
 			Previewed= format.formatCellValue(sh5.getRow(2).getCell(6));
 			Preferred = format.formatCellValue(sh5.getRow(2).getCell(7));
 			UW = format.formatCellValue(sh5.getRow(2).getCell(8));
			
			
		
			
			WebElement elementr1= driver.findElement(By.xpath("//*[text()='System Risk ID']//following::tr[1]/td[1]/div"));
		    elementr1.click();
		    driver.findElement(By.xpath("//*[text()='Renew']")).click();
		    driver.findElement(By.xpath("//*[text()='Proceed']")).click();
		    WebElement dynamicRiskr1 = (new WebDriverWait(driver, 200)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Renewal']")));   
		    
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[text()='Insured Name *']//following::td[2]//input")).clear();
		    driver.findElement(By.xpath("//*[text()='Insured Name *']//following::td[2]//input")).sendKeys(Insuredname);
		    driver.findElement(By.xpath("//*[text()='Broker *']//following::td[2]//input")).clear();
		    driver.findElement(By.xpath("//*[text()='Broker *']//following::td[2]//input")).sendKeys(Broker);
		    Select dropdown = new Select(driver.findElement(By.xpath("//*[text()='Producing Region *']//following::td[2]//select")));
	        
	         dropdown.selectByVisibleText(Producingregion);
	         //Thread.sleep(1000);
	         WebElement popup1 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Information']")));
	         
	         String actText= driver.findElement(By.xpath("//*[text()='Information']")).getText();
	         String exptext="Information";
	         
		    if(actText.contains(exptext)) 
		    	driver.findElement(By.xpath("//*[text()='Information']//following::div[2]/button")).click();
		    else 
		    System.out.println("No Pop up message ");
		    
		    Select dropdown1 = new Select(driver.findElement(By.xpath("//*[text()='Producing Country *']//following::div[2]/select")));
	         
	        dropdown1.selectByVisibleText(Producingcountry);
	        WebElement branchWait=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Branch *']//following::div[2]/select")));
	        Select dropdown3 = new Select(driver.findElement(By.xpath("//*[text()='Branch *']//following::div[2]/select")));
	         
	        dropdown3.selectByVisibleText(Branch);
	         Thread.sleep(1000);
	        Select dropdown2 = new Select(driver.findElement(By.xpath("//*[text()='Country of Insured *']//following::div[2]/select")));
	         
	        dropdown2.selectByVisibleText(Countryofinsured);
		    //Thread.sleep(1000);
		    WebElement popup2 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Information']")));
	        if(actText.contains(exptext)) 
	 	       driver.findElement(By.xpath("//*[text()='Information']//following::div[2]/button")).click();
	 		    else 
	 		    System.out.println("No Pop up message ");
	        Select dropdown5 = new Select(driver.findElement(By.xpath("//*[text()='Chubb Risk Management Involvement *']//following::td[2]//select")));
	          
	         dropdown5.selectByVisibleText(Chubbriskmanagement);
		
	        Select dropdown6 = new Select(driver.findElement(By.xpath("//*[text()='Direct / Inwards Policy *']//following::td[2]//select")));
	          
	        dropdown6.selectByVisibleText(Direct);
	        Actions action=new Actions(driver);
	        action.sendKeys(Keys.TAB).build().perform();
	        Thread.sleep(2000);
	        if (FAC.equalsIgnoreCase("Yes"))
	          driver.findElement(By.xpath("//*[text()='FAC RI for this policy *']//following::td[2]//label/input[@value='Yes']")).click();
	          else
	        driver.findElement(By.xpath("//*[text()='FAC RI for this policy *']//following::td[2]//label/input[@value='No']")).click();
	          Thread.sleep(1000);
	         if(Storageoutside.equalsIgnoreCase("No"))
	          
	          driver.findElement(By.xpath("//*[text()='Storage outside ordinary course of transit *']//following::td[2]//input[@value='No']")).click();
	          
	          else
	        	  driver.findElement(By.xpath("//*[text()='Storage outside ordinary course of transit *']//following::td[2]//input[@value='Yes']")).click();
	        //Thread.sleep(1000);
	        WebElement popup3 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Delete Storage']")));
	        String actText2= driver.findElement(By.xpath("//*[text()='Delete Storage']")).getText();
	        String exptext2= "Delete Storage";
	        
	        if(actText2.contains(exptext2))
	        driver.findElement(By.xpath("//*[text()='Do you wish to proceed?']//following::div[2]/button")).click();
	        else 
	 		  System.out.println("No Pop up message for Delete Storage ");
	        
	        boolean claimsRadio=driver.findElement(By.xpath("//*[text()='Claims History Available *']//following::td[2]//label/input[@value='Yes']")).isEnabled();
		    if(claimsRadio == false)
		    	System.out.println("Radio button for claims is disabled");
		    else
		    	System.out.println("Radio button for claims is enabled");
		    driver.findElement(By.xpath("//*[text()='Bonus Percentage *']//following::td[2]//input")).clear();
		    driver.findElement(By.xpath("//*[text()='Bonus Percentage *']//following::td[2]//input")).sendKeys(Bonuspct);
		    Select dropdown8r1 = new Select(driver.findElement(By.xpath("//*[text()='Gross Net Premium *']//following::td[2]//select")));
	          
	        dropdown8r1.selectByVisibleText(GrossnetPrem);
	        driver.findElement(By.xpath("//*[text()='Profit Commission % *']//following::td[2]//input")).clear();
	        driver.findElement(By.xpath("//*[text()='Profit Commission % *']//following::td[2]//input")).sendKeys(Profitcommissionpct);
	        driver.findElement(By.xpath("//*[text()='Based on % of Gross Premium *']//following::td[2]//input")).clear();
	        driver.findElement(By.xpath("//*[text()='Based on % of Gross Premium *']//following::td[2]//input")).sendKeys(Basedonpct);
	        driver.findElement(By.xpath("//*[text()='Brokerage % *']//following::td[2]//input")).clear();
	        driver.findElement(By.xpath("//*[text()='Brokerage % *']//following::td[2]//input")).sendKeys(Brokeragepct);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[text()='Next']")).click();
	         
		//Transit Exposure screen
	        WebElement myDynamicElementr1 = (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Annual/Open Cover or Single Shipment *']//following::td[2]//select")));
	        Select dropdown21 = new Select(driver.findElement(By.xpath("//*[text()='Annual/Open Cover or Single Shipment *']//following::td[2]//select")));
	        
	        dropdown21.selectByVisibleText(Ann_Open);
	        if (RadClause.equalsIgnoreCase("Yes"))
	    	driver.findElement(By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::span[3]//following::div[2]/label/input[@value='Yes']")).click();
	    	else 
	    	driver.findElement(By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::span[3]//following::div[2]/label/input[@value='No']")).click();
	        Thread.sleep(1000);
			driver.findElement(By.xpath("//*[text()='Information']//following::button")).click();
			WebElement addIntWait=(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Add Interest']")));
	        driver.findElement(By.xpath("//*[text()='Add Interest']")).click();
	        WebElement button4Wait=(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Code description *']//following::button[4]")));
	        driver.findElement(By.xpath("//*[text()='Code description *']//following::button[4]")).click();
	        
	        
	        WebElement elementWait=(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Commodity Code Description']")));
			Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[text()='Commodity Code Description']//following::div/input")).sendKeys(CodeDesc1);
	        driver.findElement(By.xpath("//*[text()='Search']")).click();
	        WebElement codeDescWait=(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='CommodityCode Description']//following::tr/td/div")));
			WebElement element = driver.findElement(By.xpath("//*[text()='CommodityCode Description']//following::tr/td/div"));
			action.doubleClick(element).perform();
			popUpClick();
			Select dropdown22 = new Select(driver.findElement(By.xpath("//*[text()='Selection *']//following::select[3]")));
	        
	        dropdown22.selectByVisibleText(Selection1);
	        
	        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[13]")).sendKeys(Amt1);//Amount
	        action.sendKeys(Keys.TAB).build().perform();
		
	        Select dropdown23 = new Select(driver.findElement(By.xpath("//*[text()='Selection *']//following::select[4]")));
	        
	        dropdown23.selectByVisibleText(WordSource1);
	        
	        driver.findElement(By.xpath("//*[text()='Code description *']//following::button[5]")).click();
	        WebElement covWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='ICC B or equivalent']")));
	        WebElement covBasis= driver.findElement(By.xpath("//*[text()='ICC B or equivalent']"));
	        action.doubleClick(covBasis).perform();
	        
	        WebElement stoWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Code description *']//following::button[6]")));
	        driver.findElement(By.xpath("//*[text()='Code description *']//following::button[6]")).click();
	        Thread.sleep(1000);
	        WebElement stow=driver.findElement(By.xpath("//*[text()='Breakbulk']"));
	        action.doubleClick(stow).perform();
			
	        WebElement LimWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Amount *']//following::input[14]")));
			
			
			driver.findElement(By.xpath("//*[text()='Amount *']//following::input[14]")).sendKeys(Limit1);//Limit
			
	        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[15]")).sendKeys(Deduct1);//Deductible
	        
	        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[18]")).sendKeys(NationLess);
	        
	        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[19]")).sendKeys(NationGreat);
	        //Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[20]")).sendKeys(Continadj);
	       
	        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[21]")).sendKeys(Contin);
	        //Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[22]")).sendKeys(LandPct);
	        
	        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[23]")).sendKeys(AirPct);
	        //Thread.sleep(1000);
	        WebElement nxtWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	        driver.findElement(By.xpath("//*[text()='Next']")).click();
		
	        //Claims History screen
	        WebElement myDynamicElement1 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Number of years of claims history *']//following::div")));
	        driver.findElement(By.xpath("//*[text()='Data as at *']//following::div[@class='mx-name-datePicker1']//input[1]")).sendKeys(DateAsAt);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("(//*[@class='mx-dateinput-input-wrapper'])[5]//following::td[1]/div/input")).clear();
	        driver.findElement(By.xpath("(//*[@class='mx-dateinput-input-wrapper'])[5]//following::td[1]/div/input")).sendKeys("1500000");
	        WebElement nxtWait1=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	        driver.findElement(By.xpath("//*[text()='Next']")).click();
	        
	        //Storage screen
	        WebElement dynamicStore = (new WebDriverWait(driver, 200)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All Risks excl CAT']//following::td[1]/div/select")));
			String riskRenew= driver.findElement(By.xpath("//td[@class='header']//preceding::td[2]//label")).getText();
			System.out.println("Risk id of the Renewal is"+" : "+riskRenew);
			
			if(EarthPeril.equalsIgnoreCase("Included")) {
				Select earthQuakedrop=new Select(driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[1]//select")));
				earthQuakedrop.selectByVisibleText(EarthPeril);
				WebElement EarthLimwait=(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Earthquake']//following::td[2]//input")));
				driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[2]//input")).sendKeys(EarthLim);
				driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[3]//input")).sendKeys(EarthDed);
				driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[4]//input")).sendKeys(EarthPct);}
			else { 
				Select earthQuakedrop=new Select(driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[1]//select")));
				earthQuakedrop.selectByVisibleText(EarthPeril);}
			
			if(WindPeril.equalsIgnoreCase("Included")) {
				Select earthQuakedrop=new Select(driver.findElement(By.xpath("//*[text()='Windstorm']//following::td[1]//select")));
				earthQuakedrop.selectByVisibleText(WindPeril);
				WebElement WindLimwait=(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Windstorm']//following::td[2]//input")));
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[text()='Windstorm']//following::td[2]//input")).sendKeys(WindLim);
				driver.findElement(By.xpath("//*[text()='Windstorm']//following::td[3]//input")).sendKeys(WindDed);
				driver.findElement(By.xpath("//*[text()='Windstorm']//following::td[4]//input")).sendKeys(WindPct);}
			else { 
				Select earthQuakedrop=new Select(driver.findElement(By.xpath("//*[text()='Windstorm']//following::td[1]//select")));
				earthQuakedrop.selectByVisibleText(WindPeril);}
			
			if(FloodPeril.equalsIgnoreCase("Included")) {
				Select earthQuakedrop=new Select(driver.findElement(By.xpath("//*[text()='Flood']//following::td[1]//select")));
				earthQuakedrop.selectByVisibleText(FloodPeril);
				WebElement FloodLimwait=(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Flood']//following::td[2]//input")));
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[text()='Flood']//following::td[2]//input")).sendKeys(FloodLim);
				driver.findElement(By.xpath("//*[text()='Flood']//following::td[3]//input")).sendKeys(FloodDed);
				driver.findElement(By.xpath("//*[text()='Flood']//following::td[4]//input")).sendKeys(FloodPct);}
			else { 
				Select earthQuakedrop=new Select(driver.findElement(By.xpath("//*[text()='Flood']//following::td[1]//select")));
				earthQuakedrop.selectByVisibleText(FloodPeril);}
			
			driver.findElement(By.xpath("//*[text()='Add Location']")).click();
			WebElement Location2Wait= (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='Location Name']//following::div[@class='mx-name-textBox1'])[2]/input")));
			
			driver.findElement(By.xpath("(//*[text()='Location Name']//following::div[@class='mx-name-textBox1'])[2]/input")).sendKeys(LocName);
			driver.findElement(By.xpath("(//*[text()='Location Name']//following::div[@class='mx-name-textBox2'])[2]/input")).sendKeys(Address);
			driver.findElement(By.xpath("(//*[text()='Location Name']//following::div[@class='mx-name-textBox3'])[2]/input")).sendKeys(City);
			driver.findElement(By.xpath("(//*[text()='Location Name']//following::div[@class='mx-name-textBox4'])[2]/input")).sendKeys(Post);
			
			driver.findElement(By.xpath("((//*[text()='Location Name']//following::div[@class='mx-name-textBox6'])[2]/following::div/button)[1]")).click();
			WebElement countryWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Country']//following::div/input")));
			
			driver.findElement(By.xpath("//*[text()='Country']//following::div/input")).sendKeys(Country);
			driver.findElement(By.xpath("//*[text()='Search']")).click();
		
			WebElement element12 = driver.findElement(By.xpath("((//*[text()='Country'])[2]//following::td/div)[1]"));
			
			action.doubleClick(element12).perform();
			
			driver.findElement(By.xpath("(//*[text()='Location Name']//following::div[@class='mx-name-textBox7'])[2]/input")).sendKeys(LocLim);
			
			driver.findElement(By.xpath("((//*[text()='Location Name']//following::div[@class='mx-name-textBox7'])[2]/input//following::div/button)[1]")).click();
			WebElement ccdWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Commodity Code Description']//following::div/input")));
			driver.findElement(By.xpath("//*[text()='Commodity Code Description']//following::div/input")).sendKeys(Com1Code);
			driver.findElement(By.xpath("//*[text()='Search']")).click();
			WebElement element13 = driver.findElement(By.xpath("//*[text()='Description']//following::td[1]/div"));
			
			action.doubleClick(element13).perform();
			
			driver.findElement(By.xpath("(//*[text()='Location Name']//following::div[@class='mx-name-textBox8'])[2]/input")).sendKeys(Com1Exp);
			
			driver.findElement(By.xpath("((//*[text()='Location Name']//following::div[@class='mx-name-textBox7'])[2]/input//following::div/button)[3]")).click();
			WebElement OccWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Select Occupancy Type']")));
			WebElement element14 = driver.findElement(By.xpath("//*[text()='Permanent Dwelling (multi family housing)']"));
			
			action.doubleClick(element14).perform();
			
			driver.findElement(By.xpath("((//*[text()='Location Name']//following::div[@class='mx-name-textBox7'])[2]/input//following::div/button)[4]")).click();
			WebElement ConsWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Light Metal Frame']")));
			WebElement element15 = driver.findElement(By.xpath("//*[text()='Light Metal Frame']"));
			
			action.doubleClick(element15).perform();
			Thread.sleep(1000);
			
			Select dropdown45 = new Select(driver.findElement(By.xpath("(//*[text()='Earthquake *']//following::div[@class='mx-name-dropDown1']/select)[2]")));
	        
	        dropdown45.selectByVisibleText(Earth);
		
	        Select dropdown46 = new Select(driver.findElement(By.xpath("(//*[text()='Earthquake *']//following::div[@class='mx-name-dropDown6']/select)[2]")));
	        
	        dropdown46.selectByVisibleText(Flood);
	        
	        Select dropdown47 = new Select(driver.findElement(By.xpath("(//*[text()='Earthquake *']//following::div[@class='mx-name-dropDown7']/select)[2]")));
	        
	        dropdown47.selectByVisibleText(Wind);
	        WebElement nxtWait2=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	        driver.findElement(By.xpath("//*[text()='Next']")).click();
			//Summary screen
	        
	        WebElement myDynamicElement2 = (new WebDriverWait(driver, 50)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='TRANSIT  Rate (%)']//following::div[3]/input")));
	        if(Previewed.equalsIgnoreCase("Yes")){
	        Select dropdown51 = new Select(driver.findElement(By.xpath("//*[text()='Has this risk been Peer Reviewed? *']//following::td[1]/div/select")));
	        
	        dropdown51.selectByVisibleText(Previewed);
	        Thread.sleep(1000);
	        Select dropByWhom = new Select(driver.findElement(By.xpath("//*[text()='By whom?']//following::td[1]//select")));
	        
	        dropByWhom.selectByIndex(5);}
	        else {
	        Select dropdown51No = new Select(driver.findElement(By.xpath("//*[text()='Has this risk been Peer Reviewed? *']//following::td[1]/div/select")));
	        
	        dropdown51No.selectByVisibleText(Previewed);}
	        
	        if(Preferred.equalsIgnoreCase("Yes")) {
	        Select dropdown52 = new Select(driver.findElement(By.xpath("//*[text()='Has this risk been Referred? *']//following::td[1]/div/select")));
	        
	        dropdown52.selectByVisibleText(Preferred);
	        Select toWhom = new Select(driver.findElement(By.xpath("(//*[text()='To whom?']//following::td//select)[1]")));
	        
	        toWhom.selectByIndex(6);}
	        else {
	        Select dropdown52 = new Select(driver.findElement(By.xpath("//*[text()='Has this risk been Referred? *']//following::td[1]/div/select")));
		        
		    dropdown52.selectByVisibleText(Preferred);}
	        	
	        
	        driver.findElement(By.xpath("//*[text()='Underwriting Rationale *']//following::div/textarea")).sendKeys(UW);
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//*[text()='Rate Change']")).click();
	        WebElement rateChgWait=(new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Risk Status']//following::td[2]//select")));
	        
	        driver.findElement(By.xpath("//*[text()='Calculate/Save']")).click();
	        
	        
	        Thread.sleep(9000);
	        WebElement calculWaitRen=(new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Exit']")));
	        driver.findElement(By.xpath("//*[text()='Exit']")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[text()='Yes' and @class='btn mx-button mx-name-actionButton1 btn-success']")).click();
	        
	       
	        
	        
	}
	
	
}
