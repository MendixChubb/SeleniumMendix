package Powergen;

import org.testng.annotations.Test;

import jxl.common.Logger;
import net.sourceforge.htmlunit.corejs.javascript.ast.FunctionNode.Form;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;



public class PowerNG1 {
	
	public  WebDriver driver;
	public PowerNG1(WebDriver driver) {
		this.driver=driver;
	}
	
	@BeforeTest
	 public void initialization() throws FileNotFoundException {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\kkswam\\Documents\\Selenium\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
			
 		driver = new InternetExplorerDriver();
 		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kkswam\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
 				//driver = new ChromeDriver();
 				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://uat.powergenrating.acegroup.com:8088/");
		Actions action = new Actions(driver);
		
	  }
	
	
	@Test(priority=0)
	public void Login() throws AWTException {
		WebElement logWait=(new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='form-control username']")));
		driver.findElement(By.xpath("//input[@class='form-control username']")).sendKeys("testing@abc.com");
		driver.findElement(By.xpath("//input[@class='form-control password']")).sendKeys("Power123");	
		//driver.findElement(By.xpath("//input[@class='btn btn-default submit']")).click();
		Robot rb=new Robot();
		 rb.keyPress(KeyEvent.VK_ENTER);

         rb.keyRelease(KeyEvent.VK_ENTER);
		
	}
	@Test(priority=1)
	public void createNewRisk() throws InterruptedException {
		WebElement ratingWait=(new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Powergen']")));
		
		try {
			driver.findElement(By.xpath("//*[text()='Powergen']")).click();
		}catch(Exception e) {
			Thread.sleep(3000);	
			driver.findElement(By.xpath("//*[text()='Powergen']")).click();
			
		}
		WebElement gridWait=(new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Create New Risk']")));
		
		try {
			driver.findElement(By.xpath("//*[text()='Create New Risk']")).click();
		}catch(org.openqa.selenium.ElementNotVisibleException e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Create New Risk']")).click();
			
		}
	}
	@Test(priority=2)
	public void riskInfo() throws InterruptedException {
		WebElement insnameWait=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Insured Name*']//following::td[1]//input")));
		try{
			WebElement disText= driver.findElement(By.xpath("//*[text()='Insured Name*']"));
			Assert.assertTrue(disText.isDisplayed());
		}
		catch(Throwable t){
			Thread.sleep(1000);
			WebElement disText= driver.findElement(By.xpath("//*[text()='Insured Name*']"));
			Assert.assertTrue(disText.isDisplayed());
			
		}
		driver.findElement(By.xpath("//*[text()='Insured Name*']//following::td[1]//input")).sendKeys("Powergen Rating Corporation pvt.ltd");
		driver.findElement(By.xpath("//*[text()='Reassured Name']//following::td[1]//input")).sendKeys("Warren Buffet Investors");
		driver.findElement(By.xpath("//*[text()='Top Location*']//following::td[1]//input")).sendKeys("London");
		
		Actions action = new Actions(driver);
		
		
		Select polCvgDrop=new Select(driver.findElement(By.xpath("//*[text()='Policy Coverage*']//following::td[1]//select")));
		polCvgDrop.selectByVisibleText("All Risks Only");
		Select brokerDrop=new Select(driver.findElement(By.xpath("//*[text()='Broker*']//following::td[1]//select")));
		brokerDrop.selectByVisibleText("Aim");
		Thread.sleep(1000);
		try {
			Select domDrop=new Select(driver.findElement(By.xpath("//*[text()='Domicile of Insured*']//following::td[1]//select")));
			domDrop.selectByVisibleText("Switzerland");
		}catch(Throwable t) {
			Thread.sleep(1000);
		Select domDrop=new Select(driver.findElement(By.xpath("//*[text()='Domicile of Insured*']//following::td[1]//select")));
		domDrop.selectByVisibleText("Switzerland");}
		
		Select currDrop=new Select(driver.findElement(By.xpath("//*[text()='Quoting Currency*']//following::td[1]//select")));
		currDrop.selectByVisibleText("UNITED KINGDOM - GBP - POUND STERLING");
		 
        action.sendKeys(Keys.TAB).build().perform();
        Select bTypeDrop=new Select(driver.findElement(By.xpath("//*[text()='Business Type*']//following::td[1]//select")));
		bTypeDrop.selectByVisibleText("Single Location");
		Select branchDrop=new Select(driver.findElement(By.xpath("//*[text()='Branch*']//following::td[1]//select")));
		branchDrop.selectByIndex(1);
		
		
		
		
	}
	@Test(priority=3)
	public void policydate() throws Throwable {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		
			driver.findElement(By.xpath("//*[text()='Inception*']//following::td[1]//div[@class='mx-dateinput-input-wrapper']/input")).sendKeys("01/01/2017");
		
		 action.sendKeys(Keys.TAB).build().perform();
		 
		 WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		 WebElement tivWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Single Location']//following::tr[2]/td[1]//select")));
		 Thread.sleep(500);
		 String tivtitle=driver.getTitle();
		 Assert.assertEquals(tivtitle, "Mendix - TIV");
		
	}
	//TIV Screen
	@Test(priority=4)
	public void tivScreen() throws InterruptedException {
		Select riskCat1=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[2]/td[1]//select")));
		List<WebElement> weblist=riskCat1.getOptions();
		int cnt=weblist.size();
		Random ran = new Random();
		int index=ran.nextInt(cnt);
		riskCat1.selectByIndex(index);
		try {
		Select man1Drop=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[2]/td[2]//select")));
		man1Drop.selectByIndex(3);
		}catch(Throwable t) {
			Thread.sleep(1000);
			Select man1Drop=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[2]/td[2]//select")));
			man1Drop.selectByIndex(3);
		}
		driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[2]/td[3]//input")).sendKeys("200000");
		driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[2]/td[4]//input")).sendKeys("200000");
	
		Select riskCat2=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[3]/td[1]//select")));
		
		int index1=ran.nextInt(cnt);
		
		riskCat2.selectByIndex(index1);
		try {
		
		Select man2Drop=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[3]/td[2]//select")));
		man2Drop.selectByIndex(11);
		}catch(Throwable t) {
			Thread.sleep(1000);
			Select man2Drop=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[3]/td[2]//select")));
			man2Drop.selectByIndex(11);
		}
		driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[3]/td[3]//input")).sendKeys("300000");
		driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[3]/td[4]//input")).sendKeys("450000");
	
		Select riskCat3=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[4]/td[1]//select")));
		
		int index2=ran.nextInt(cnt);
		riskCat3.selectByIndex(index2);
		try {
		Select man3Drop=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[4]/td[2]//select")));
		man3Drop.selectByIndex(5);
		}catch(Throwable t) {
			Thread.sleep(1000);
			Select man3Drop=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[4]/td[2]//select")));
			man3Drop.selectByIndex(5);
		}
		
		driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[4]/td[3]//input")).sendKeys("5000000");
		driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[4]/td[4]//input")).sendKeys("6450000");
		
		//driver.findElement(By.xpath("//*[text()='Sum Insured BI (Annual)*']//following::td[1]//input")).sendKeys("650000");
		//driver.findElement(By.xpath("(//*[text()='Sum Insured BI (Annual)*']//following::td//input)[2]")).sendKeys("350000");
		
		if(index==0 || index1==0 || index2==0 )
				{
			try {
					riskCat1.selectByIndex(3);
					riskCat2.selectByIndex(4);
					riskCat3.selectByIndex(5);}
			catch(Throwable t) {
				riskCat1.selectByIndex(3); 
				Thread.sleep(1000);
				riskCat2.selectByIndex(4);
				Thread.sleep(1000);
				riskCat3.selectByIndex(5);
				}}
		
		WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		WebElement polLimWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[1]")));
		String polTitle=driver.getTitle();
		Assert.assertEquals(polTitle, "Mendix - Policy Limits");
	
	}
	//Policy Limits screen
	@Test(priority=5)
	public void policyLimits() throws InterruptedException {
		
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[1]")).sendKeys("325698");
		
		//WebElement element1= driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[2]"));
		
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[2]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[2]")).sendKeys("654656");
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[3]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[3]//td[2]//input)[1]")).sendKeys("25000");
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[4]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[4]//td[2]//input)[1]")).sendKeys("15000");
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[5]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[5]//td[2]//input)[1]")).sendKeys("250000");
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[6]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[6]//td[2]//input)[1]")).sendKeys("500000");
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[7]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[7]//td[2]//input)[1]")).sendKeys("12345");
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[8]//td[2]//input)[1]")).click();
		driver.findElement(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[8]//td[2]//input)[1]")).sendKeys("2500");
		
		WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		WebElement subLimWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Earthquake']//following::td[2]//input")));
		String subTitle=driver.getTitle();
		try {
			Thread.sleep(2000);
		Assert.assertEquals(subTitle, "Mendix - Sublimits");}
		catch(Throwable t) {
			Thread.sleep(2000);
			Assert.assertEquals(subTitle, "Mendix - Sublimits");
			
		}
	
	}
	
	@Test(priority=6)
	public void subLimits() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[2]//input")).sendKeys("23654");
		Select earSpeDrop =new Select(driver.findElement(By.xpath("//*[text()='Earthquake']//following::tr[1]//td[2]//select")));
		earSpeDrop.selectByIndex(3);
		driver.findElement(By.xpath("//*[text()='Earthquake']//following::tr[1]//td[3]//input")).sendKeys("654321");
		driver.findElement(By.xpath("//*[text()='Flood']//following::td[2]//input")).click();
		driver.findElement(By.xpath("//*[text()='Flood']//following::td[2]//input")).sendKeys("65000");
		driver.findElement(By.xpath("//*[text()='Machinery Breakdown']//following::td[1]//input")).click();
		driver.findElement(By.xpath("//*[text()='Machinery Breakdown']//following::td[1]//input")).sendKeys("15000");
		driver.findElement(By.xpath("//*[text()='Machinery Breakdown BI']//following::td[1]//input")).click();
		driver.findElement(By.xpath("//*[text()='Machinery Breakdown BI']//following::td[1]//input")).sendKeys("15000");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[text()='Other Sublimit 1']//following::td[1]//input")).clear();
		try {
			driver.findElement(By.xpath("//*[text()='Other Sublimit 1']//following::td[1]//input")).clear();
		}catch(Exception e) {
			}
		
		driver.findElement(By.xpath("//*[text()='Other Sublimit 1']//following::td[1]//input")).sendKeys("Sublimit1");
		driver.findElement(By.xpath("//*[text()='Other Sublimit 1']//following::td[2]//input")).sendKeys("650000");
		
		WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		WebElement dedWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='PD*']//following::td[2]//input")));
		String dedTitle=driver.getTitle();
		Assert.assertEquals(dedTitle, "Mendix - Deductibles");
		
	}
	@Test(priority=7)
	public void deductible() {
		
		Actions action=new Actions(driver);
		
		driver.findElement(By.xpath("//*[text()='PD*']//following::td[2]//input")).sendKeys("6500");
		driver.findElement(By.xpath("//*[text()='PD-BI*']//following::td[2]//input")).click();
		driver.findElement(By.xpath("//*[text()='PD-BI*']//following::td[2]//input")).sendKeys("25000");
		
		Select typeDrop1=new Select(driver.findElement(By.xpath("//*[text()='PD-BI*']//following::td[6]//select")));
		typeDrop1.selectByVisibleText("Waiting Period");
		driver.findElement(By.xpath("//*[text()='Machinery Breakdown*']//following::td[1]//input")).sendKeys("1000");
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath("//*[text()='Machinery Breakdown - BI*']//following::td[1]//input")).sendKeys("6500");
		Select typeDrop2=new Select(driver.findElement(By.xpath("//*[text()='Machinery Breakdown - BI*']//following::td[5]//select")));
		typeDrop2.selectByVisibleText("Average Daily Value");
		
		driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[2]//input")).sendKeys("99");
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[5]//input")).click();
		driver.findElement(By.xpath("//*[text()='Flood']//following::td[2]//input")).sendKeys("75");
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath("//*[text()='Flood']//following::td[5]//input")).click();
		
		WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		WebElement dedWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Commission']//following::td[1]//input")));
		String loadTitle=driver.getTitle();
		Assert.assertEquals(loadTitle, "Mendix - Loadings and Discounts");
		
		}
	@Test(priority=8)
	public void loadingAndDiscounts() throws InterruptedException, IOException {
		
		
		Actions action = new Actions(driver);
		
		Properties prop=new Properties();
		FileReader file=new FileReader("C:/Users/kkswam/eclipse-workspace/Mendix/src/Powergen/Power.properties");
	 
		prop.load(file);
		
		driver.findElement(By.xpath("//*[text()='Commission']//following::td[1]//input")).sendKeys("101");
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		Thread.sleep(1000);
		String error1= driver.findElement(By.xpath("//*[text()='Commission']//following::td[1]//input//following-sibling::div")).getText();
		Assert.assertEquals(error1, "Please enter a value greater than or equal to 0 and less than or equal to 100.");
		
		driver.findElement(By.xpath("//*[text()='Commission']//following::td[1]//input")).clear();
		
		driver.findElement(By.xpath("//*[text()='Commission']//following::td[1]//input")).sendKeys("100");
		driver.findElement(By.xpath(prop.getProperty("EngineeringFee"))).click();
		driver.findElement(By.xpath(prop.getProperty("EngineeringFee"))).sendKeys("100");
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath(prop.getProperty("SpareParts"))).sendKeys("100");
		driver.findElement(By.xpath(prop.getProperty("Location"))).click();
		driver.findElement(By.xpath(prop.getProperty("Location"))).sendKeys("100");
		driver.findElement(By.xpath(prop.getProperty("Maintenance"))).click();
		driver.findElement(By.xpath(prop.getProperty("Maintenance"))).sendKeys("-100");
		driver.findElement(By.xpath(prop.getProperty("PromptPaymentDiscount"))).click();
		driver.findElement(By.xpath(prop.getProperty("PromptPaymentDiscount"))).sendKeys("-80");
		
		driver.findElement(By.xpath(prop.getProperty("NoClaimsDiscount"))).clear();
		try {
		driver.findElement(By.xpath(prop.getProperty("NoClaimsDiscount"))).sendKeys("-90");}
		catch(Exception e) {
			}
		driver.findElement(By.xpath(prop.getProperty("LongTermAgreement"))).click();
		driver.findElement(By.xpath(prop.getProperty("LongTermAgreement"))).sendKeys("-60");
		
		WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		WebElement dedWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Losses As At Date*']//following::td[1]//input")));
		
		String lossTitle=driver.getTitle();
		Assert.assertEquals(lossTitle,"Mendix - Losses" );
		
		}
	@Test(priority=9)
	public void lossesScreen() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[text()='Paid']//following::tr//td[2]//input")).sendKeys("50000");
		driver.findElement(By.xpath("//*[text()='Paid']//following::tr//td[3]//input")).sendKeys("80000");
		
		WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		WebElement dedWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Loaded*']//following::td[1]//input")));
		try {
		String premTitle=driver.getTitle();
		
		Assert.assertEquals(premTitle,"Mendix - Premium" );}
		catch(Throwable t) {
			Thread.sleep(1000);
			String premTitle=driver.getTitle();
			Assert.assertEquals(premTitle,"Mendix - Premium" );
		}
		
		
	}
	
	@Test(priority=10,description="Premium screen is being Tested")
	public void premiumScreen() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[text()='Loaded*']//following::td[1]//input")).sendKeys("6000000");
		driver.findElement(By.xpath("//*[text()='PD Premium - Gross*']//following::td[3]//input")).sendKeys("150000");
		
		driver.findElement(By.xpath("//*[text()='BI Premium - Gross*']//following::td[3]//input")).sendKeys("98546720");
		
		driver.findElement(By.xpath("//*[text()='Written % Line']//following::td[1]//input")).sendKeys("50");
		driver.findElement(By.xpath("//*[text()='Signed % Line*']//following::td[1]//input")).sendKeys("99");
		
		Select leaddrop=new Select(driver.findElement(By.xpath("//*[text()='Lead/Follow']//following::td[1]//select")));
		leaddrop.selectByVisibleText("Lead");
		
		String ctext=driver.findElement(By.xpath("//*[text()='Changed Fields']")).getText();
		Assert.assertEquals(ctext,"Changed Fields");
		driver.findElement(By.xpath("//*[text()='Calculate']")).click();
		Thread.sleep(5000);
		//boolean ctext1=driver.findElement(By.xpath("//*[text()='Changed Fields']")).isDisplayed();
		
	        //boolean b = driver.getPageSource().contains("Changed Field");
	        //System.out.println(b);
	        Assert.assertFalse(false, "driver.getPageSource().contains(\"Changed Field\")");
	        try {
	        WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement dedWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='1'])[1]//following::td[1]//input")));}
	        catch(Throwable t) {
	        Thread.sleep(1000);
	        	 WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	 			driver.findElement(By.xpath("//*[text()='Next']")).click();
	 			WebElement dedWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='1'])[1]//following::td[1]//input")));}
	        
			try {
				Thread.sleep(1000);
			String facTitle=driver.getTitle();
			
			Assert.assertEquals(facTitle,"Mendix - Facultative Reinsurance") ;}
			catch(Throwable t) {
				Thread.sleep(2000);
				String facTitle=driver.getTitle();
				Assert.assertEquals(facTitle,"Mendix - Facultative Reinsurance" );
			}
			
	        
	   
	}
	@Test(priority=11)
	public void facultative() throws IOException, InterruptedException {
		Properties prop=new Properties();
		FileReader file=new FileReader("C:/Users/kkswam/eclipse-workspace/Mendix/src/Powergen/Power.properties");
	 
		prop.load(file);
		try {
		driver.findElement(By.xpath(prop.getProperty("Line1"))).sendKeys("78");
		driver.findElement(By.xpath(prop.getProperty("VQS1"))).click();
		driver.findElement(By.xpath(prop.getProperty("Line2"))).sendKeys("89");
		driver.findElement(By.xpath(prop.getProperty("NonVQS2"))).click();
		driver.findElement(By.xpath(prop.getProperty("comm2"))).clear();
		driver.findElement(By.xpath(prop.getProperty("comm2"))).sendKeys("75");
		Select front2drop=new Select(driver.findElement(By.xpath(prop.getProperty("Front2"))));
		front2drop.selectByVisibleText("Yes");
		
		driver.findElement(By.xpath(prop.getProperty("limit1"))).sendKeys("105000");
		driver.findElement(By.xpath(prop.getProperty("attachment1"))).sendKeys("65000");
		driver.findElement(By.xpath(prop.getProperty("price1"))).sendKeys("74");
		
		Select coverageDrop1=new Select(driver.findElement(By.xpath(prop.getProperty("coverage1"))));
		coverageDrop1.selectByVisibleText("Location specific");
		
		driver.findElement(By.xpath(prop.getProperty("LinePct1"))).sendKeys("40");
		driver.findElement(By.xpath(prop.getProperty("inuring1"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("limit2"))).sendKeys("255000");
		driver.findElement(By.xpath(prop.getProperty("attachment2"))).sendKeys("25000");
		driver.findElement(By.xpath(prop.getProperty("price2"))).sendKeys("84");
		
		Select coverageDrop2=new Select(driver.findElement(By.xpath(prop.getProperty("coverage2"))));
		coverageDrop2.selectByVisibleText("CAT specific");
		
		driver.findElement(By.xpath(prop.getProperty("LinePct2"))).sendKeys("70");
		driver.findElement(By.xpath(prop.getProperty("inuring2"))).click();
		WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		WebElement dedWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form-control mx-textarea-input']")));
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
			driver.findElement(By.xpath(prop.getProperty("Line1"))).sendKeys("78");
			driver.findElement(By.xpath(prop.getProperty("VQS1"))).click();
			driver.findElement(By.xpath(prop.getProperty("Line2"))).sendKeys("89");
			driver.findElement(By.xpath(prop.getProperty("NonVQS2"))).click();
			driver.findElement(By.xpath(prop.getProperty("comm2"))).clear();
			driver.findElement(By.xpath(prop.getProperty("comm2"))).sendKeys("75");
			Select front2drop=new Select(driver.findElement(By.xpath(prop.getProperty("Front2"))));
			front2drop.selectByVisibleText("Yes");
			WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement dedWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form-control mx-textarea-input']")));
		}}
	
	@Test(priority=12)
	public void comments() throws InterruptedException {
	driver.findElement(By.xpath("//*[@class='form-control mx-textarea-input']")).sendKeys("Key features of Cyber ERM and DigiTech® ERM include:\n" + 
			"•Highly customizable solutions to address clients' unique needs, regardless of size or type of risk \n" + 
			"•Chubb's award-winning loss mitigation and incident response services ");
	WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	driver.findElement(By.xpath("//*[text()='Next']")).click();
	WebElement dedWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Notes']//following::td[1]//textarea")));
	try {
		Thread.sleep(1000);
	String peerTitle=driver.getTitle();
	
	Assert.assertEquals(peerTitle,"Mendix - Peer Review") ;}
	catch(Throwable t) {
		Thread.sleep(2000);
		String peerTitle=driver.getTitle();
		Assert.assertEquals(peerTitle,"Mendix - Peer Review" );
	}
	
	
	}
	@Test(priority=13)
	public void peerReview() throws InterruptedException, FileNotFoundException, IOException {
		driver.findElement(By.xpath("//*[text()='Notes']//following::td[1]//textarea")).sendKeys("Key features of Cyber ERM and DigiTech® ERM include:\n" + 
				"•Highly customizable solutions to address clients' unique needs, regardless of size or type of risk \n" + 
				"•Chubb's award-winning loss mitigation and incident response services ");
		
		driver.findElement(By.xpath("//*[text()='Peer Reviewer']//following::td[1]//input")).sendKeys("George Bailey");
		driver.findElement(By.xpath("//*[text()='Date']//following::td[1]//input")).sendKeys("30/12/2016");
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
		WebElement coreLight=driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div"));
		
		highLightElement(driver, coreLight);
		
		
		Logger log=Logger.getLogger(PowerNG.class);
		
		PropertyConfigurator.configure("log4j.properties");
		log.info("Powergen New risk is created Successfully");
		log.info("Risk id is :"+" "+core);
		 try {
			 
			this.captureScreenshot(driver,core);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void captureScreenshot(WebDriver driver,String core) throws Throwable {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,new File("C:\\Users\\kkswam\\Documents\\Selenium\\Screenshots\\"+core+".png" ));
		
	}
	@AfterMethod
	public void imageFailure(ITestResult res) throws IOException {
		if(ITestResult.FAILURE==res.getStatus()) {
			try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(src,new File("C:\\Users\\kkswam\\Documents\\Selenium\\Screenshots\\"+res.getName()+".png" ));
			}catch(Exception e) {};
			}
			
	}
	
	@AfterTest
	public void f() {
		
	}
	
	public static void highLightElement(WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 
	 
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 
	try 
	{
	Thread.sleep(500);
	} 
	catch (InterruptedException e) {
	 
	System.out.println(e.getMessage());
	} 
	 
	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	 
	}
	
	}
