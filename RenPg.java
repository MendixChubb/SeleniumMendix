package Powergen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import marine.Renewal;

public class RenPg extends PgDemo {
	public WebDriver driver;
	public String core;
	public String coreRen;

	public RenPg(WebDriver driver) {
		this.driver=driver;
		
	}
	

	@Test(priority=0)
	public void overview(String core) throws InterruptedException {
		
		driver.findElement(By.xpath("(//*[text()='Search'])[2]")).click();
		WebElement overWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='Core ID'])[1]//following::div[1]//input")));
		driver.findElement(By.xpath("(//*[text()='Core ID'])[1]//following::div[1]//input")).sendKeys(core);
		driver.findElement(By.xpath("(//*[text()='Search'])[1]")).click();
		WebElement clickWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div")));
		driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div")).click();
		driver.findElement(By.xpath("//*[text()='Edit']")).click();
		WebElement polWait=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Policy Number*']//following::td[1]//input")));
		driver.findElement(By.xpath("//*[text()='Policy Number*']//following::td[1]//input")).sendKeys("59768JK54");
		Select statusWait=new Select(driver.findElement(By.xpath("//*[text()='Policy Status*']//following::td[1]//select")));
		statusWait.selectByVisibleText("Bound");
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		
		WebElement infoWaitS=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Information']")));
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Calculate']")).click();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//*[text()='Exit']")).click();
		
		WebElement clickWait1=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div")));
		driver.findElement(By.xpath("//*[text()='Reset']")).click();
		driver.findElement(By.xpath("(//*[text()='Policy Number'])[1]//following::div[1]//input")).sendKeys("59768JK54");
		driver.findElement(By.xpath("(//*[text()='Search'])[1]")).click();
		WebElement clickWait2=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div")));
		driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div")).click();
		driver.findElement(By.xpath("//*[text()='Renew']")).click();
	}
	
	@Test(priority=1)
	public void general(String status,String exdate) throws IOException, InterruptedException {
	
		 //DataFormatter format = new DataFormatter();
		 //String status=format.formatCellValue(sh1.getRow(2).getCell(12));
		 // String exdate=format.formatCellValue(sh1.getRow(2).getCell(11));
		
		WebElement renWait=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='New/Renewal*']//following::td[1]//label")));
		String pstatus=driver.findElement(By.xpath("//*[text()='New/Renewal*']//following::td[1]//label")).getText();
		//Assert.assertTrue(pstatus.contains("Renewal"));
		try {
		Select statusDrop=new Select(driver.findElement(By.xpath("//*[text()='Policy Status*']//following::td[1]//select")));
		statusDrop.selectByVisibleText(status);}
		catch(Exception e) {
			Thread.sleep(1000);
			Select statusDrop=new Select(driver.findElement(By.xpath("//*[text()='Policy Status*']//following::td[1]//select")));
			statusDrop.selectByVisibleText(status);
		}
		driver.findElement(By.xpath("//*[text()='Expiry*']//following::td[1]//input")).clear();
		driver.findElement(By.xpath("//*[text()='Expiry*']//following::td[1]//input")).sendKeys(exdate);
		
		
		
		String eIncep=driver.findElement(By.xpath("//*[text()='Inception*']//following::td[2]//label")).getText();
		String eExpiry=driver.findElement(By.xpath("//*[text()='Expiry*']//following::td[2]//label")).getText();
		Assert.assertEquals(eIncep, "01/09/2017");
		Assert.assertEquals(eExpiry, "31/08/2018");
		Actions action = new Actions(driver);
		 action.sendKeys(Keys.TAB).build().perform();
		 try {
		 WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();}
		 catch(Exception e) {
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[text()='Next']")).click(); 
			 WebElement progwait=new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Program']//following::tr[6]//td[2]//input")));
		
	}}
	@Test(priority=2)
	public void rProgram(String dieselpd,String dieselbi,String hydropd,String hydrobi,String periodren) {
		
		
		driver.findElement(By.xpath("//*[text()='Program']//following::tr[6]//td[2]//input")).clear();
		driver.findElement(By.xpath("//*[text()='Program']//following::tr[6]//td[2]//input")).sendKeys(dieselpd);
		driver.findElement(By.xpath("//*[text()='Program']//following::tr[6]//td[3]//input")).clear();
		driver.findElement(By.xpath("//*[text()='Program']//following::tr[6]//td[3]//input")).sendKeys(dieselbi);
		driver.findElement(By.xpath("//*[text()='Program']//following::tr[8]//td[2]//input")).clear();
		driver.findElement(By.xpath("//*[text()='Program']//following::tr[8]//td[2]//input")).sendKeys(hydropd);
		driver.findElement(By.xpath("//*[text()='Program']//following::tr[8]//td[3]//input")).clear();
		driver.findElement(By.xpath("//*[text()='Program']//following::tr[8]//td[3]//input")).sendKeys(hydrobi);
		
		driver.findElement(By.xpath("//*[text()='BI Indemnity Period (Months)*']//following::td[1]//input")).clear();
		driver.findElement(By.xpath("//*[text()='BI Indemnity Period (Months)*']//following::td[1]//input")).sendKeys(periodren);
		String periodtex=driver.findElement(By.xpath("//*[text()='BI Indemnity Period (Months)*']//following::td[3]//label")).getText();
		Assert.assertEquals(periodtex, "12");
		WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		 WebElement polwait=new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[4]//td[2]//input)[1]")));
	}
	@Test(priority=3)
	public void rPolicyLimits(String rcomloss , String rsir) throws InterruptedException {
		
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[4]//td[2]//input)[1]")).clear();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[4]//td[2]//input)[1]")).sendKeys(rcomloss);
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[5]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[5]//td[2]//input)[1]")).clear();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[5]//td[2]//input)[1]")).sendKeys(rsir);
		Thread.sleep(1000);
		
		String pctchan=driver.findElement(By.xpath("(//*[text()='Policy Limits'])[3]//following::tr[4]//td[4]//div[@class='formatstring ']")).getText();
		Assert.assertEquals(pctchan, "558 %");
		WebElement nxtWait3=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		 WebElement subLimWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Earthquake']//following::td[2]//input")));
	}
	@Test(priority=4)
	public void rSublimits(String rearth,String rspec,String rearthspec) {
		driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[2]//input")).clear();
		driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[2]//input")).sendKeys(rearth);
		Select earSpeDrop =new Select(driver.findElement(By.xpath("//*[text()='Earthquake']//following::tr[1]//td[2]//select")));
		earSpeDrop.selectByVisibleText(rspec);
		driver.findElement(By.xpath("//*[text()='Earthquake']//following::tr[1]//td[3]//input")).clear();
		driver.findElement(By.xpath("//*[text()='Earthquake']//following::tr[1]//td[3]//input")).sendKeys(rearthspec);
		String earthchan= driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[4]//div[@class='formatstring ']")).getText();
			Assert.assertEquals(earthchan, "50 %");	
			WebElement nxtWait3=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			 driver.findElement(By.xpath("//*[text()='Next']")).click();
			 WebElement subLimWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='PD*']//following::td[2]//input")));	
			
		}
	@Test(priority=5)
	public void rdeductibles(String rpd,String rpdbi1,String rtypea,String rdeductdesc,String rdeductlim ) {
		
		driver.findElement(By.xpath("//*[text()='PD*']//following::td[2]//input")).clear();
	driver.findElement(By.xpath("//*[text()='PD*']//following::td[2]//input")).sendKeys(rpd);
	driver.findElement(By.xpath("//*[text()='PD-BI*']//following::td[2]//input")).click();
	driver.findElement(By.xpath("//*[text()='PD-BI*']//following::td[2]//input")).clear();
	driver.findElement(By.xpath("//*[text()='PD-BI*']//following::td[2]//input")).sendKeys(rpdbi1);
	
	Select typeDrop1=new Select(driver.findElement(By.xpath("//*[text()='PD-BI*']//following::td[6]//select")));
	typeDrop1.selectByVisibleText(rtypea);
	driver.findElement(By.xpath("//*[text()='Other Deductible 1']//following::td[1]//input")).clear();
	driver.findElement(By.xpath("//*[text()='Other Deductible 1']//following::td[1]//input")).sendKeys(rdeductdesc);
	driver.findElement(By.xpath("//*[text()='Other Deductible 1']//following::td[2]//input")).sendKeys(rdeductlim);
	WebElement nxtWait5=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	 driver.findElement(By.xpath("//*[text()='Next']")).click();
	WebElement loadWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Commission']//following::td[1]//input")));
	
	}
	@Test(priority=6)
	public void rloadings(String reng,String rspare,String rloca,String rmain) throws IOException {
		Properties prop=new Properties();
		FileReader file=new FileReader("C:/Users/kkswam/eclipse-workspace/Mendix/src/Powergen/Power.properties");
	 
		prop.load(file);
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(prop.getProperty("EngineeringFee"))).click();
		driver.findElement(By.xpath(prop.getProperty("EngineeringFee"))).clear();
		driver.findElement(By.xpath(prop.getProperty("EngineeringFee"))).sendKeys(reng);
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath(prop.getProperty("SpareParts"))).clear();
		driver.findElement(By.xpath(prop.getProperty("SpareParts"))).sendKeys(rspare);
		driver.findElement(By.xpath(prop.getProperty("Location"))).click();
		driver.findElement(By.xpath(prop.getProperty("Location"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Location"))).sendKeys(rloca);
		driver.findElement(By.xpath(prop.getProperty("Maintenance"))).click();
		driver.findElement(By.xpath(prop.getProperty("Maintenance"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Maintenance"))).sendKeys(rmain);
		WebElement nxtWait6=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		WebElement lossWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Losses As At Date*']//following::td[1]//input")));
		WebElement nxtWait7=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		WebElement premWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Loaded*']//following::td[1]//input")));
	}
	@Test(priority=7)
	public void rpremium(String rload,String rgross1,String rgross2,String rwrit,String rsign,String rlead) throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Loaded*']//following::td[1]//input")).clear();
		driver.findElement(By.xpath("//*[text()='Loaded*']//following::td[1]//input")).sendKeys(rload);
		driver.findElement(By.xpath("//*[text()='PD Premium - Gross*']//following::td[3]//input")).clear();
		driver.findElement(By.xpath("//*[text()='PD Premium - Gross*']//following::td[3]//input")).sendKeys(rgross1);
		driver.findElement(By.xpath("//*[text()='BI Premium - Gross*']//following::td[3]//input")).clear();
		driver.findElement(By.xpath("//*[text()='BI Premium - Gross*']//following::td[3]//input")).sendKeys(rgross2);
		driver.findElement(By.xpath("//*[text()='Written % Line']//following::td[1]//input")).clear();
		driver.findElement(By.xpath("//*[text()='Written % Line']//following::td[1]//input")).sendKeys(rwrit);
		driver.findElement(By.xpath("//*[text()='Signed % Line*']//following::td[1]//input")).clear();
		driver.findElement(By.xpath("//*[text()='Signed % Line*']//following::td[1]//input")).sendKeys(rsign);
		
		Select leaddrop=new Select(driver.findElement(By.xpath("//*[text()='Lead/Follow']//following::td[1]//select")));
		leaddrop.selectByVisibleText(rlead);
		driver.findElement(By.xpath("//*[text()='Calculate']")).click();
		try {
			Thread.sleep(5000);}
			catch(Throwable t) {
				Thread.sleep(2000);
			}
			
	        try {
	        WebElement nxtWait8=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement facWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Net Validated Rate Change*']//following::td[1]//input")));}
	        catch(Throwable t) {
	        Thread.sleep(1000);
	        	 WebElement nxtWait8a=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	 			driver.findElement(By.xpath("//*[text()='Next']")).click();
	 			
	        WebElement Wait9=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Net Validated Rate Change*']//following::td[1]//input")));}
	
	 		driver.findElement(By.xpath("//*[text()='Net Validated Rate Change*']//following::td[1]//input")).sendKeys("30");
	 		driver.findElement(By.xpath("//*[text()='Comment on Validated Rate Change*']//following::td[1]//textarea")).click();
	 		driver.findElement(By.xpath("//*[text()='Comment on Validated Rate Change*']//following::td[1]//textarea")).sendKeys("Rate change was Validated successfully and has been notified to the customer");
		
			WebElement nxtWait10=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	 		driver.findElement(By.xpath("//*[text()='Next']")).click();
	 		WebElement Wait10=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='1'])[1]//following::td[1]//input")));
   			driver.findElement(By.xpath("(//*[text()='1'])[1]//following::td[1]//input")).click();
	 		WebElement nxtWait9=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement comWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form-control mx-textarea-input']")));
	}
	@Test(priority=8)
	public void rComments(String rcomm ) throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@class='form-control mx-textarea-input']")).sendKeys("\n"+rcomm);
    	WebElement nxtWait10=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
    	driver.findElement(By.xpath("//*[text()='Next']")).click();
    	WebElement peerWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Notes']//following::td[1]//textarea")));
	}
	@Test(priority=9)
	public void rpeer(String rpeer1,String rpeer2,String rpeerdate ) throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[text()='Notes']//following::td[1]//textarea")).sendKeys("\n"+rpeer1);
		driver.findElement(By.xpath("//*[text()='Peer Reviewer']//following::td[1]//input")).clear();
    	driver.findElement(By.xpath("//*[text()='Peer Reviewer']//following::td[1]//input")).sendKeys(rpeer2);
    	driver.findElement(By.xpath("//*[text()='Date']//following::td[1]//input")).clear();
    	driver.findElement(By.xpath("//*[text()='Date']//following::td[1]//input")).sendKeys(rpeerdate);
		driver.findElement(By.xpath("//*[text()='Peer Reviewed']//following::td[1]//input")).click();
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		try {
		WebElement info=driver.findElement(By.xpath("//*[text()='Information']"));
		Thread.sleep(1000);
		if(info.isDisplayed()) 
			driver.findElement(By.xpath("//*[text()='Information']//following::div[2]//button")).click();
		else
			System.out.println("Go to Catch Block");
		}
				catch(Throwable t) {
		WebElement infoWait=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Information']//following::div[2]//button")));
					driver.findElement(By.xpath("//*[text()='Information']//following::div[2]//button")).click();
					}
			
		driver.findElement(By.xpath("//*[text()='Calculate']")).click();
		Thread.sleep(4000);
		//Utility.syncWait(driver, "//*[text()='Peer Reviewer']//following::td[1]//input", 20).click();
		try {
			WebElement genWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='General']")));	
		driver.findElement(By.xpath("//*[text()='General']")).click();}
		catch(Throwable t) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='General']")).click();	
		}
		
		WebElement coreWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Core ID']//following::td[1]//label")));
		
		String coreRen=driver.findElement(By.xpath("//*[text()='Core ID']//following::td[1]//label")).getText();
		
		System.out.println("Renewal Risk id is :"+" "+coreRen);
		driver.findElement(By.xpath("//*[text()='Exit']")).click();
		Thread.sleep(2000);
		WebElement coreWaitPg=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]//div")));
		WebElement coreLight=driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]//div"));
		PowerNG pg=new PowerNG();
		pg.highLightElement(driver, coreLight);
		try {
			 
			pg.captureScreenshot(driver,coreRen);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rexcelWrite(coreRen);
	}
		//sh.getRow(2).createCell(3).setCellValue(coreRen);
		
		public void rexcelWrite(String coreRen) throws IOException {
			String src="C:\\Users\\kkswam\\Documents\\PowergenData.xlsx";
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			  XSSFSheet sh=wb.getSheet("Login");
			
		 SimpleDateFormat dateFormatr = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 Date timer = new Date();
		 String optimer= dateFormatr.format(timer);
		 sh.getRow(2).createCell(3).setCellValue(coreRen);
		 sh.getRow(2).createCell(4).setCellValue(optimer);
		 //String src="C:\\Users\\kkswam\\Documents\\PowergenData.xlsx";
		FileOutputStream foutr=new FileOutputStream(new File(src));
		wb.write(foutr);
		}
	}
	
