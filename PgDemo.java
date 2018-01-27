package Powergen;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import marine.RetryF;

public class PgDemo {

	public WebDriver driver;
	public static Workbook wb;
	public Sheet sh;
	public String uname,password;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Sheet sh1,sh2,sh3,sh4,sh5,sh6,sh7,sh8,sh9,sh10;
	public static String status,exdate;
	@BeforeTest
	public void setUp() throws AWTException, IOException {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\kkswam\\Documents\\Selenium\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
		driver =new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://uat.powergenrating.acegroup.com:8088/");
		 
		
		
		}
	/*@BeforeMethod
	public void exceldata(Method method) throws IOException {
		extent =new ExtentReports("C:\\Users\\kkswam\\eclipse-workspace\\Mendix\\Report\\advanceReport.html", true);
		extent.loadConfig(new File("C:\\Users\\kkswam\\eclipse-workspace\\Mendix\\extent-config.xml"));
		test=extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()),method.getName());
		test.assignAuthor("Karthik");
		test.assignCategory("Regression Testing");
	}*/
	
	@Test(priority=-1,retryAnalyzer=RetryF.class)
	public void newRisk() throws AWTException, IOException, InterruptedException {
		String src="C:\\Users\\kkswam\\Documents\\PowergenData.xlsx";
		  
		  FileInputStream fis=new FileInputStream(src);
		  XSSFWorkbook wb=new XSSFWorkbook(fis);
		  XSSFSheet sh=wb.getSheet("Login");
		  XSSFSheet sh1=wb.getSheet("General");
		  XSSFSheet sh2=wb.getSheet("Program");
		  XSSFSheet sh2a=wb.getSheet("Policy Limits");
		  XSSFSheet sh3=wb.getSheet("Sublimits");
		  XSSFSheet sh4=wb.getSheet("Deductibles");
		  XSSFSheet sh5=wb.getSheet("Loadings");
		  XSSFSheet sh6=wb.getSheet("Losses");
		  XSSFSheet sh7=wb.getSheet("Premium");
		  XSSFSheet sh8=wb.getSheet("Facultative");
		  XSSFSheet sh9=wb.getSheet("Comments");
		  XSSFSheet sh10=wb.getSheet("Peer Review");
		  DataFormatter format = new DataFormatter();
		  //Login Variables
		  String uname = format.formatCellValue(sh.getRow(1).getCell(1));
		  String password = format.formatCellValue(sh.getRow(1).getCell(2));
		  //General Screen Variables
		  String insname=format.formatCellValue(sh1.getRow(1).getCell(1));
		  String rename=format.formatCellValue(sh1.getRow(1).getCell(2));
		  String loc=format.formatCellValue(sh1.getRow(1).getCell(3));
		  String polcov=format.formatCellValue(sh1.getRow(1).getCell(4));
		  String broker=format.formatCellValue(sh1.getRow(1).getCell(5));
		  String dom=format.formatCellValue(sh1.getRow(1).getCell(6));
		  String cur=format.formatCellValue(sh1.getRow(1).getCell(7));
		  String type=format.formatCellValue(sh1.getRow(1).getCell(8));
		  String branch=format.formatCellValue(sh1.getRow(1).getCell(9));
		  String date=format.formatCellValue(sh1.getRow(1).getCell(10));
		  String status=format.formatCellValue(sh1.getRow(2).getCell(12));
		  String exdate=format.formatCellValue(sh1.getRow(2).getCell(11));
			//Program screen variables
		  String cogpd=date=format.formatCellValue(sh2.getRow(1).getCell(1));
		  String cogbi=date=format.formatCellValue(sh2.getRow(1).getCell(2));	  
		  String compd=date=format.formatCellValue(sh2.getRow(1).getCell(3));	  
		  String combi=date=format.formatCellValue(sh2.getRow(1).getCell(4));	  
		  String waspd=date=format.formatCellValue(sh2.getRow(1).getCell(5));
		  String wasbi=date=format.formatCellValue(sh2.getRow(1).getCell(6));
		  String months=date=format.formatCellValue(sh2.getRow(1).getCell(7));
		  String periodren=date=format.formatCellValue(sh2.getRow(2).getCell(7));
		  String dieselpd=date=format.formatCellValue(sh2.getRow(2).getCell(8));
		  String dieselbi=date=format.formatCellValue(sh2.getRow(2).getCell(9));
		  String hydropd=date=format.formatCellValue(sh2.getRow(2).getCell(10));
		  String hydrobi=date=format.formatCellValue(sh2.getRow(2).getCell(11));
		  //Policy Limits
		  String pdloss=date=format.formatCellValue(sh2a.getRow(1).getCell(1));
		  String pdbiloss=date=format.formatCellValue(sh2a.getRow(1).getCell(2));	  
		  String comloss=date=format.formatCellValue(sh2a.getRow(1).getCell(3));	  
		  String sir=date=format.formatCellValue(sh2a.getRow(1).getCell(4));	  
		  String as=date=format.formatCellValue(sh2a.getRow(1).getCell(5));
		  String pmlpd=date=format.formatCellValue(sh2a.getRow(1).getCell(6));
		  String pmlmb=date=format.formatCellValue(sh2a.getRow(1).getCell(7));
		  String nle=date=format.formatCellValue(sh2a.getRow(1).getCell(8));
		  String rcomloss=date=format.formatCellValue(sh2a.getRow(2).getCell(3));	  
		  String rsir=date=format.formatCellValue(sh2a.getRow(2).getCell(4));
		  //Sub Limits
		  String earth=date=format.formatCellValue(sh3.getRow(1).getCell(1));
		  String spec=date=format.formatCellValue(sh3.getRow(1).getCell(2));	  
		  String earthspec=date=format.formatCellValue(sh3.getRow(1).getCell(3));	  
		  String flood=date=format.formatCellValue(sh3.getRow(1).getCell(4));	  
		  String mac1=date=format.formatCellValue(sh3.getRow(1).getCell(5));
		  String mac2=date=format.formatCellValue(sh3.getRow(1).getCell(6));
		  String extra=date=format.formatCellValue(sh3.getRow(1).getCell(7));
		  String desc=date=format.formatCellValue(sh3.getRow(1).getCell(8));
		  String amt=date=format.formatCellValue(sh3.getRow(1).getCell(9));
		  String rearth=date=format.formatCellValue(sh3.getRow(2).getCell(1));
		  String rspec=date=format.formatCellValue(sh3.getRow(2).getCell(2));	  
		  String rearthspec=date=format.formatCellValue(sh3.getRow(2).getCell(3));	
		  //Deductibles
		  String pd=date=format.formatCellValue(sh4.getRow(1).getCell(1));
		  String pdbi1=date=format.formatCellValue(sh4.getRow(1).getCell(2));	  
		  String typea=date=format.formatCellValue(sh4.getRow(1).getCell(3));	  
		  String macb1=date=format.formatCellValue(sh4.getRow(1).getCell(4));	  
		  String macb2=date=format.formatCellValue(sh4.getRow(1).getCell(5));
		  String typeb=date=format.formatCellValue(sh4.getRow(1).getCell(6));
		  String earthq=date=format.formatCellValue(sh4.getRow(1).getCell(7));
		  String flood1=date=format.formatCellValue(sh4.getRow(1).getCell(8));
		  String wind=date=format.formatCellValue(sh4.getRow(1).getCell(9));
		  String rpd=date=format.formatCellValue(sh4.getRow(2).getCell(1));
		  String rpdbi1=date=format.formatCellValue(sh4.getRow(2).getCell(2));	  
		  String rtypea=date=format.formatCellValue(sh4.getRow(2).getCell(3));
		  String rdeductdesc=date=format.formatCellValue(sh4.getRow(2).getCell(10));
		  String rdeductlim=date=format.formatCellValue(sh4.getRow(2).getCell(11));
		  //Loadings and Discounts
		  String com1=date=format.formatCellValue(sh5.getRow(1).getCell(1));
		  String com2=date=format.formatCellValue(sh5.getRow(1).getCell(2));	  
		  String eng=date=format.formatCellValue(sh5.getRow(1).getCell(3));	  
		  String spare=date=format.formatCellValue(sh5.getRow(1).getCell(4));	  
		  String loca=date=format.formatCellValue(sh5.getRow(1).getCell(5));
		  String main=date=format.formatCellValue(sh5.getRow(1).getCell(6));
		  String pro=date=format.formatCellValue(sh5.getRow(1).getCell(7));
		  String noc=date=format.formatCellValue(sh5.getRow(1).getCell(8));
		  String lon=date=format.formatCellValue(sh5.getRow(1).getCell(9));
		  String reng=date=format.formatCellValue(sh5.getRow(2).getCell(3));	  
		  String rspare=date=format.formatCellValue(sh5.getRow(2).getCell(4));	  
		  String rloca=date=format.formatCellValue(sh5.getRow(2).getCell(5));
		  String rmain=date=format.formatCellValue(sh5.getRow(2).getCell(6));
		  //Losses screen
		  String paid1=date=format.formatCellValue(sh6.getRow(1).getCell(1));
		  String out1=date=format.formatCellValue(sh6.getRow(1).getCell(2));
		  //Premium screen
		  String load=date=format.formatCellValue(sh7.getRow(1).getCell(1));
		  String gross1=date=format.formatCellValue(sh7.getRow(1).getCell(2));	  
		  String gross2=date=format.formatCellValue(sh7.getRow(1).getCell(3));	  
		  String writ=date=format.formatCellValue(sh7.getRow(1).getCell(4));	  
		  String sign=date=format.formatCellValue(sh7.getRow(1).getCell(5));
		  String lead=date=format.formatCellValue(sh7.getRow(1).getCell(6));
		  String rload=date=format.formatCellValue(sh7.getRow(2).getCell(1));
		  String rgross1=date=format.formatCellValue(sh7.getRow(2).getCell(2));	  
		  String rgross2=date=format.formatCellValue(sh7.getRow(2).getCell(3));	  
		  String rwrit=date=format.formatCellValue(sh7.getRow(2).getCell(4));	  
		  String rsign=date=format.formatCellValue(sh7.getRow(2).getCell(5));
		  String rlead=date=format.formatCellValue(sh7.getRow(2).getCell(6));
		  //Facultative Premium screen
		  String line1=date=format.formatCellValue(sh8.getRow(1).getCell(1));
		  String com1f=date=format.formatCellValue(sh8.getRow(1).getCell(2));	  
		  String front1=date=format.formatCellValue(sh8.getRow(1).getCell(3));	  
		  String line2=date=format.formatCellValue(sh8.getRow(1).getCell(4));	  
		  String com2f=date=format.formatCellValue(sh8.getRow(1).getCell(5));
		  String front2=date=format.formatCellValue(sh8.getRow(1).getCell(6));
		  String lim1=date=format.formatCellValue(sh8.getRow(1).getCell(7));
		  String att1=date=format.formatCellValue(sh8.getRow(1).getCell(8));	  
		  String pri1=date=format.formatCellValue(sh8.getRow(1).getCell(9));	  
		  String cov1=date=format.formatCellValue(sh8.getRow(1).getCell(10));	  
		  String lpct1=date=format.formatCellValue(sh8.getRow(1).getCell(11));
		  String lim2=date=format.formatCellValue(sh8.getRow(1).getCell(12));
		  String att2=date=format.formatCellValue(sh8.getRow(1).getCell(13));	  
		  String pri2=date=format.formatCellValue(sh8.getRow(1).getCell(14));	  
		  String cov2=date=format.formatCellValue(sh8.getRow(1).getCell(15));	  
		  String lpct2=date=format.formatCellValue(sh8.getRow(1).getCell(16));
		  //Comments screen
		  String comment=date=format.formatCellValue(sh9.getRow(1).getCell(1));
		  String rcomm=date=format.formatCellValue(sh9.getRow(2).getCell(1));
		  //Peer Review
		  String note=date=format.formatCellValue(sh10.getRow(1).getCell(1));
		  String peer=date=format.formatCellValue(sh10.getRow(1).getCell(2));	  
		  String datep=date=format.formatCellValue(sh10.getRow(1).getCell(3));	
		  String rpeer1=date=format.formatCellValue(sh10.getRow(2).getCell(1));
		  String rpeer2=date=format.formatCellValue(sh10.getRow(2).getCell(2));	  
		  String rpeerdate=date=format.formatCellValue(sh10.getRow(2).getCell(3));	
		  extent =new ExtentReports("C:\\Users\\kkswam\\eclipse-workspace\\Mendix\\Report\\advanceReport.html", true);
			extent.loadConfig(new File("C:\\Users\\kkswam\\eclipse-workspace\\Mendix\\extent-config.xml"));
			test=extent.startTest("New risk", "Regression");
			test.assignAuthor("Karthik");
			test.assignCategory("Regression Testing");
		  
		  
		  driver.findElement(By.xpath("//*[text()='Login']//following::div[2]//input")).sendKeys(uname);
		driver.findElement(By.xpath("//*[text()='Login']//following::div[3]//input")).sendKeys(password);
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		//Rating Model Platform
		WebElement ratingWait=(new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Powergen']")));
		WebElement powerlight=driver.findElement(By.xpath("//*[text()='Powergen']"));
		PowerNG pg=new PowerNG();
		pg.highLightElement(driver, powerlight);
		try {
			driver.findElement(By.xpath("//*[text()='Powergen']")).click();
		}catch(Exception e) {
			Thread.sleep(1000);	
			driver.findElement(By.xpath("//*[text()='Powergen']")).click();
			
		}
		WebElement gridWait=(new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Create New Risk']")));
		
		WebElement createlight=driver.findElement(By.xpath("//*[text()='Create New Risk']"));
		pg.highLightElement(driver, createlight);
		try {
			driver.findElement(By.xpath("//*[text()='Create New Risk']")).click();
		}catch(org.openqa.selenium.ElementNotVisibleException e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Create New Risk']")).click();
			
		}
		//General Screen
		WebElement insnameWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Insured Name*']//following::td[1]//input")));
		
		driver.findElement(By.xpath("//*[text()='Insured Name*']//following::td[1]//input")).sendKeys(insname);
		driver.findElement(By.xpath("//*[text()='Reassured Name']//following::td[1]//input")).sendKeys(rename);
		driver.findElement(By.xpath("//*[text()='Top Location*']//following::td[1]//input")).sendKeys(loc);
		
		Actions action = new Actions(driver);
		
		Select polCvgDrop=new Select(driver.findElement(By.xpath("//*[text()='Policy Coverage*']//following::td[1]//select")));
		polCvgDrop.selectByVisibleText(polcov);
		Select brokerDrop=new Select(driver.findElement(By.xpath("//*[text()='Broker*']//following::td[1]//select")));
		brokerDrop.selectByVisibleText(broker);
		Thread.sleep(1000);
		try {
			Select domDrop=new Select(driver.findElement(By.xpath("//*[text()='Domicile of Insured*']//following::td[1]//select")));
			domDrop.selectByVisibleText(dom);
		}catch(Throwable t) {
			Thread.sleep(1000);
		Select domDrop=new Select(driver.findElement(By.xpath("//*[text()='Domicile of Insured*']//following::td[1]//select")));
		domDrop.selectByVisibleText(dom);}
		
		Select currDrop=new Select(driver.findElement(By.xpath("//*[text()='Quoting Currency*']//following::td[1]//select")));
		currDrop.selectByVisibleText(cur);
		 
        action.sendKeys(Keys.TAB).build().perform();
        Select bTypeDrop=new Select(driver.findElement(By.xpath("//*[text()='Business Type*']//following::td[1]//select")));
		bTypeDrop.selectByVisibleText(type);
		Select branchDrop=new Select(driver.findElement(By.xpath("//*[text()='Branch*']//following::td[1]//select")));
		branchDrop.selectByVisibleText(branch);;
		action.sendKeys(Keys.TAB).build().perform();
		
		driver.findElement(By.xpath("//*[text()='Inception*']//following::td[1]//div[@class='mx-dateinput-input-wrapper']/input")).sendKeys("01/09/2017");
	
	 action.sendKeys(Keys.TAB).build().perform();
	 Thread.sleep(10000);
	 try {
	 WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	 driver.findElement(By.xpath("//*[text()='Next']")).click();}
	 catch(Exception e) {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[text()='Next']")).click(); 
	 }
	 //Program screen
	 WebElement progWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Program']//following::tr[2]//td[2]//input")));
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[2]//td[2]//input")).clear();
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[2]//td[2]//input")).sendKeys(cogpd);
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[2]//td[3]//input")).clear();
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[2]//td[3]//input")).sendKeys(cogbi);
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[3]//td[2]//input")).clear();
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[3]//td[2]//input")).sendKeys(compd);
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[3]//td[3]//input")).clear();
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[3]//td[3]//input")).sendKeys(combi);
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[9]//td[2]//input")).clear();
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[9]//td[2]//input")).sendKeys(waspd);
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[9]//td[3]//input")).clear();
	 driver.findElement(By.xpath("//*[text()='Program']//following::tr[9]//td[3]//input")).sendKeys(wasbi);
	 
	 driver.findElement(By.xpath("//*[text()='Next']")).click();
	 
	 String monthserr=driver.findElement(By.xpath("//*[text()='Please enter BI Indemnity period.']")).getText();
	 Assert.assertEquals("Please enter BI Indemnity period.", monthserr);
	 driver.findElement(By.xpath("//*[text()='BI Indemnity Period (Months)*']//following::td[1]/div//input")).sendKeys(months);
	 
	 WebElement nxtWait2=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	 driver.findElement(By.xpath("//*[text()='Next']")).click();
	 WebElement polWait=(new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[2]")));
	 try {
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[1]")).sendKeys(pdloss);
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[2]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[2]")).sendKeys(pdbiloss);
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[3]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[3]//td[2]//input)[1]")).sendKeys(comloss);
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[4]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[4]//td[2]//input)[1]")).sendKeys(sir);
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[5]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[5]//td[2]//input)[1]")).sendKeys(as);
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[6]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[6]//td[2]//input)[1]")).sendKeys(pmlpd);
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[7]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[7]//td[2]//input)[1]")).sendKeys(pmlmb);
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[8]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[8]//td[2]//input)[1]")).sendKeys(nle);
	 
		WebElement nxtWait3=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		 WebElement subLimWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Earthquake']//following::td[2]//input")));
	 }catch(Exception e) {
		 driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[6]//td[2]//input)[1]")).clear();
			driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[6]//td[2]//input)[1]")).sendKeys(pmlpd);
			driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[7]//td[2]//input)[1]")).clear();
			driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[7]//td[2]//input)[1]")).sendKeys(pmlmb);
			WebElement nxtWait3=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			 driver.findElement(By.xpath("//*[text()='Next']")).click();
			 WebElement subLimWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Earthquake']//following::td[2]//input")));
	 }
	//Sublimits screen
		 
		 	driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[2]//input")).sendKeys(earth);
			Select earSpeDrop =new Select(driver.findElement(By.xpath("//*[text()='Earthquake']//following::tr[1]//td[2]//select")));
			earSpeDrop.selectByVisibleText(spec);
			driver.findElement(By.xpath("//*[text()='Earthquake']//following::tr[1]//td[3]//input")).sendKeys(earthspec);
			driver.findElement(By.xpath("//*[text()='Flood']//following::td[2]//input")).click();
			driver.findElement(By.xpath("//*[text()='Flood']//following::td[2]//input")).sendKeys(flood);
			driver.findElement(By.xpath("//*[text()='Machinery Breakdown']//following::td[1]//input")).click();
			driver.findElement(By.xpath("//*[text()='Machinery Breakdown']//following::td[1]//input")).sendKeys(mac1);
			driver.findElement(By.xpath("//*[text()='Machinery Breakdown BI']//following::td[1]//input")).click();
			driver.findElement(By.xpath("//*[text()='Machinery Breakdown BI']//following::td[1]//input")).sendKeys(mac2);
			driver.findElement(By.xpath("//*[text()='Extra Expense']//following::td[2]//input")).click();
			driver.findElement(By.xpath("//*[text()='Extra Expense']//following::td[2]//input")).sendKeys(extra);
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[text()='Other Sublimit 1']//following::td[1]//input")).clear();
			try {
				driver.findElement(By.xpath("//*[text()='Other Sublimit 1']//following::td[1]//input")).clear();
			}catch(Exception e) {
				}
			
			driver.findElement(By.xpath("//*[text()='Other Sublimit 1']//following::td[1]//input")).sendKeys(desc);
			driver.findElement(By.xpath("//*[text()='Other Sublimit 1']//following::td[2]//input")).sendKeys(amt);
			
			WebElement nxtWait4=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			 driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement dedWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='PD*']//following::td[2]//input")));
			//Deductibles screen
			driver.findElement(By.xpath("//*[text()='PD*']//following::td[2]//input")).sendKeys(pd);
			driver.findElement(By.xpath("//*[text()='PD-BI*']//following::td[2]//input")).click();
			driver.findElement(By.xpath("//*[text()='PD-BI*']//following::td[2]//input")).sendKeys(pdbi1);
			
			Select typeDrop1=new Select(driver.findElement(By.xpath("//*[text()='PD-BI*']//following::td[6]//select")));
			typeDrop1.selectByVisibleText(typea);
			driver.findElement(By.xpath("//*[text()='Machinery Breakdown*']//following::td[1]//input")).sendKeys(macb1);
			action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.xpath("//*[text()='Machinery Breakdown - BI*']//following::td[1]//input")).sendKeys(macb2);
			Select typeDrop2=new Select(driver.findElement(By.xpath("//*[text()='Machinery Breakdown - BI*']//following::td[5]//select")));
			typeDrop2.selectByVisibleText(typeb);
			
			driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[2]//input")).sendKeys(earthq);
			action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[5]//input")).click();
			driver.findElement(By.xpath("//*[text()='Flood']//following::td[2]//input")).sendKeys(flood1);
			action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.xpath("//*[text()='Flood']//following::td[5]//input")).click();
			driver.findElement(By.xpath("//*[text()='Wind']//following::td[2]//input")).clear();
			driver.findElement(By.xpath("//*[text()='Wind']//following::td[2]//input")).sendKeys(wind);
			action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.xpath("//*[text()='Wind']//following::td[5]//input")).click();
			WebElement nxtWait5=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			 driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement loadWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Commission']//following::td[1]//input")));
			//Loadings and Discounts screen
			Properties prop=new Properties();
			FileReader file=new FileReader("C:/Users/kkswam/eclipse-workspace/Mendix/src/Powergen/Power.properties");
		 
			prop.load(file);
			
			driver.findElement(By.xpath("//*[text()='Commission']//following::td[1]//input")).sendKeys(com1);
			action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.xpath("//*[text()='Save']")).click();
			Thread.sleep(1000);
			String error1= driver.findElement(By.xpath("//*[text()='Commission']//following::td[1]//input//following-sibling::div")).getText();
			Assert.assertEquals(error1, "Please enter a value greater than or equal to 0 and less than or equal to 100.");
			
			driver.findElement(By.xpath("//*[text()='Commission']//following::td[1]//input")).clear();
			
			driver.findElement(By.xpath("//*[text()='Commission']//following::td[1]//input")).sendKeys(com2);
			driver.findElement(By.xpath(prop.getProperty("EngineeringFee"))).click();
			driver.findElement(By.xpath(prop.getProperty("EngineeringFee"))).sendKeys(eng);
			action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.xpath(prop.getProperty("SpareParts"))).sendKeys(spare);
			driver.findElement(By.xpath(prop.getProperty("Location"))).click();
			driver.findElement(By.xpath(prop.getProperty("Location"))).sendKeys(loca);
			driver.findElement(By.xpath(prop.getProperty("Maintenance"))).click();
			driver.findElement(By.xpath(prop.getProperty("Maintenance"))).sendKeys(main);
			driver.findElement(By.xpath(prop.getProperty("PromptPaymentDiscount"))).click();
			driver.findElement(By.xpath(prop.getProperty("PromptPaymentDiscount"))).sendKeys(pro);
			
			driver.findElement(By.xpath(prop.getProperty("NoClaimsDiscount"))).clear();
			try {
			driver.findElement(By.xpath(prop.getProperty("NoClaimsDiscount"))).sendKeys(noc);}
			catch(Exception e) {
				}
			driver.findElement(By.xpath(prop.getProperty("LongTermAgreement"))).click();
			driver.findElement(By.xpath(prop.getProperty("LongTermAgreement"))).sendKeys(lon);
			
			WebElement nxtWait6=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			 driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement lossWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Losses As At Date*']//following::td[1]//input")));
			//Losses screen
			driver.findElement(By.xpath("//*[text()='Paid']//following::tr//td[2]//input")).sendKeys(paid1);
			driver.findElement(By.xpath("//*[text()='Paid']//following::tr//td[3]//input")).sendKeys(out1);
			
			WebElement nxtWait7=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement premWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Loaded*']//following::td[1]//input")));
			//Premium screen
			driver.findElement(By.xpath("//*[text()='Loaded*']//following::td[1]//input")).sendKeys(load);
			driver.findElement(By.xpath("//*[text()='PD Premium - Gross*']//following::td[3]//input")).sendKeys(gross1);
			
			driver.findElement(By.xpath("//*[text()='BI Premium - Gross*']//following::td[3]//input")).sendKeys(gross2);
			
			driver.findElement(By.xpath("//*[text()='Written % Line']//following::td[1]//input")).sendKeys(writ);
			driver.findElement(By.xpath("//*[text()='Signed % Line*']//following::td[1]//input")).sendKeys(sign);
			
			Select leaddrop=new Select(driver.findElement(By.xpath("//*[text()='Lead/Follow']//following::td[1]//select")));
			leaddrop.selectByVisibleText(lead);
			
			String ctext=driver.findElement(By.xpath("//*[text()='Changed Fields']")).getText();
			Assert.assertEquals(ctext,"Changed Fields");
			driver.findElement(By.xpath("//*[text()='Calculate']")).click();
			try {
			Thread.sleep(7000);}
			catch(Throwable t) {
				Thread.sleep(2000);
			}
			Assert.assertFalse(false, "driver.getPageSource().contains(\"Changed Field\")");
	        
			Thread.sleep(1000);
	        	 WebElement nxtWait8a=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	 			driver.findElement(By.xpath("//*[text()='Next']")).click();
	 			WebElement facWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='1'])[1]//following::td[1]//input")));
	        //Facultative screen
	        try {
	    		driver.findElement(By.xpath(prop.getProperty("Line1"))).sendKeys(line1);
	    		driver.findElement(By.xpath(prop.getProperty("VQS1"))).click();
	    		
	    		driver.findElement(By.xpath(prop.getProperty("Line2"))).sendKeys(line2);
	    		driver.findElement(By.xpath(prop.getProperty("NonVQS2"))).click();
	    		driver.findElement(By.xpath(prop.getProperty("comm2"))).clear();
	    		driver.findElement(By.xpath(prop.getProperty("comm2"))).sendKeys(com2f);
	    		Select front2drop=new Select(driver.findElement(By.xpath(prop.getProperty("Front2"))));
	    		front2drop.selectByVisibleText(front2);
	    		
	    		driver.findElement(By.xpath(prop.getProperty("limit1"))).sendKeys(lim1);
	    		driver.findElement(By.xpath(prop.getProperty("attachment1"))).sendKeys(att1);
	    		driver.findElement(By.xpath(prop.getProperty("price1"))).sendKeys(pri1);
	    		
	    		Select coverageDrop1=new Select(driver.findElement(By.xpath(prop.getProperty("coverage1"))));
	    		coverageDrop1.selectByVisibleText(cov1);
	    		
	    		driver.findElement(By.xpath(prop.getProperty("LinePct1"))).sendKeys(lpct1);
	    		driver.findElement(By.xpath(prop.getProperty("inuring1"))).click();
	    		
	    		driver.findElement(By.xpath(prop.getProperty("limit2"))).sendKeys(lim2);
	    		driver.findElement(By.xpath(prop.getProperty("attachment2"))).sendKeys(att2);
	    		driver.findElement(By.xpath(prop.getProperty("price2"))).sendKeys(pri2);
	    		
	    		Select coverageDrop2=new Select(driver.findElement(By.xpath(prop.getProperty("coverage2"))));
	    		coverageDrop2.selectByVisibleText(cov2);
	    		
	    		driver.findElement(By.xpath(prop.getProperty("LinePct2"))).sendKeys(lpct2);
	    		driver.findElement(By.xpath(prop.getProperty("inuring2"))).click();
	    		WebElement nxtWait9a=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	    		driver.findElement(By.xpath("//*[text()='Next']")).click();
	    		WebElement comWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form-control mx-textarea-input']")));
	    		try {
	    			Thread.sleep(1000);
	    		String comTitle=driver.getTitle();
	    		
	    		Assert.assertEquals(comTitle,"Mendix - Comments") ;}
	    		catch(Throwable t) {
	    			Thread.sleep(2000);
	    			String comTitle=driver.getTitle();
	    			Assert.assertEquals(comTitle,"Mendix - Comments" );
	    		}}
	    		catch(Throwable t) {
	    			driver.findElement(By.xpath("(//*[text()='1'])[1]//following::td[4]//input")).sendKeys(com1f);
	    			Select front1drop=new Select(driver.findElement(By.xpath("(//*[text()='1'])[1]//following::td[6]//select")));
	    			front1drop.selectByVisibleText(front1);
	    			WebElement nxtWait9=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	    			driver.findElement(By.xpath("//*[text()='Next']")).click();
	    			WebElement comWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form-control mx-textarea-input']")));
	    		}
	        //comments
	        driver.findElement(By.xpath("//*[@class='form-control mx-textarea-input']")).sendKeys(comment);
	    	WebElement nxtWait10=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	    	driver.findElement(By.xpath("//*[text()='Next']")).click();
	    	WebElement peerWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Notes']//following::td[1]//textarea")));
	    	//Peer review
	    	driver.findElement(By.xpath("//*[text()='Notes']//following::td[1]//textarea")).sendKeys(note);
	    	driver.findElement(By.xpath("//*[text()='Peer Reviewer']//following::td[1]//input")).sendKeys(peer);
			driver.findElement(By.xpath("//*[text()='Date']//following::td[1]//input")).sendKeys(datep);
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
			Thread.sleep(6000);
			//Utility.syncWait(driver, "//*[text()='Peer Reviewer']//following::td[1]//input", 20).click();
			try {
				WebElement genWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='General']")));	
			driver.findElement(By.xpath("//*[text()='General']")).click();}
			catch(Throwable t) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[text()='General']")).click();	
			}
			
			WebElement coreWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Core ID']//following::td[1]//label")));
			
			String core=driver.findElement(By.xpath("//*[text()='Core ID']//following::td[1]//label")).getText();
			
			System.out.println("Risk id is :"+" "+core);
			driver.findElement(By.xpath("//*[text()='Exit']")).click();
			Thread.sleep(2000);
			WebElement coreWaitPg=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]//div")));
			WebElement coreLight=driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]//div"));
			
			pg.highLightElement(driver, coreLight);
			try {
				 
				pg.captureScreenshot(driver,core);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sh.getRow(1).createCell(3).setCellValue(core);
			 SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			 Date time = new Date();
			 String optime= dateFormat.format(time);
			 sh.getRow(1).createCell(3).setCellValue(core);
			 sh.getRow(1).createCell(4).setCellValue(optime);
			FileOutputStream fout=new FileOutputStream(new File(src));
			wb.write(fout);
			test.log(LogStatus.PASS, "Test case is executed successfully");
			extent.endTest(test);
			extent.flush();
			extent.close();
			/*ExtentReports extent;
			ExtentReports logger;
			extent =new ExtentReports(System.getProperty(driver.findElement(By.xpath("//*[text()='Next']")).click();));*/
			//ExtentReports ex=ExtentReports.get(PgDemo.class);
			//ex.init("C:\\Users\\kkswam\\eclipse-workspace\\Mendix\\Report\\advanceReport.html",true);
			RenPg ob=new RenPg(driver);
			ob.overview(core);
			ob.general(status, exdate);
			ob.rProgram( dieselpd, dieselbi, hydropd,hydrobi, periodren);
			ob.rPolicyLimits(rcomloss, rsir);
			ob.rSublimits(rearth, rspec, rearthspec);
			ob.rdeductibles(rpd, rpdbi1, rtypea, rdeductdesc, rdeductlim);
			ob.rloadings(reng, rspare, rloca, rmain);
			ob.rpremium(rload, rgross1, rgross2, rwrit, rsign, rlead);
			ob.rComments(rcomm);
			ob.rpeer(rpeer1, rpeer2, rpeerdate);
			
	}
	
	/*@AfterTest
	public void close() {
		driver.quit();
	}*/
}
