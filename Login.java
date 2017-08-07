package marine;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Login 
{
 
	//static String driverPath = "C:\\Users\\kkswam\\Documents\\Selenium\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe";
	public static WebDriver driver;
	
	public static void main(String[] args) throws AWTException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\kkswam\\Documents\\Selenium\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
		//WebDriver obj = new InternetExplorerDriver();
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://uat.marinecargorating.acegroup.com/");
		Robot rb = new Robot(); 

        Thread.sleep(2000);

        

        //Enter user name by ctrl-v
        
        rb.keyPress(KeyEvent.VK_TAB);

        rb.keyRelease(KeyEvent.VK_TAB);

        Thread.sleep(1000);
        
        StringSelection username = new StringSelection("karthik.swamy@chubb.com");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username,username);

         rb.keyPress(KeyEvent.VK_CONTROL);

         rb.keyPress(KeyEvent.VK_V);

         rb.keyRelease(KeyEvent.VK_V);

         rb.keyRelease(KeyEvent.VK_CONTROL);

         

        //tab to password entry field

         rb.keyPress(KeyEvent.VK_TAB);

         rb.keyRelease(KeyEvent.VK_TAB);

         Thread.sleep(2000);

         

        //Enter password by ctrl-v

         StringSelection pwd = new StringSelection("Marine123");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);

         rb.keyPress(KeyEvent.VK_CONTROL);

         rb.keyPress(KeyEvent.VK_V);

         rb.keyRelease(KeyEvent.VK_V);

         rb.keyRelease(KeyEvent.VK_CONTROL);

         

        //press enter

         rb.keyPress(KeyEvent.VK_ENTER);

         rb.keyRelease(KeyEvent.VK_ENTER);

        //wait

         Thread.sleep(5000);
         
        // assertEquals("Marine Risk Overview" , driver.getTitle());
         //driver.getTitle();
         
         driver.findElement(By.xpath("//div[@class='mx-grid-toolbar']//*[@id='uniqName_11_1']")).click();
         //Thread.sleep(5000);
         
         WebElement myDynamic = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Insured Name *']//following::td[2]//input")));
         driver.findElement(By.xpath("//*[text()='Insured Name *']//following::td[2]//input")).sendKeys("Chubb Insurers");
         driver.findElement(By.xpath("//*[text()='Broker *']//following::td[2]//input")).sendKeys("Chris");
       
		
         Select dropdown = new Select(driver.findElement(By.xpath("//div[@class='mx-referenceselector-input-wrapper']/following::tr[5]//div/select")));
        
         dropdown.selectByVisibleText("Continental Europe");
         Actions action = new Actions(driver); 
         
         action.sendKeys(Keys.TAB).build().perform();
         Thread.sleep(1000);
         Select dropdown1 = new Select(driver.findElement(By.xpath("//*[text()='Producing Country *']//following::div[2]/select")));
         
         dropdown1.selectByVisibleText("Finland");
         
         
         
         action.sendKeys(Keys.TAB).build().perform();
         Select dropdown3 = new Select(driver.findElement(By.xpath("//*[text()='Branch *']//following::div[2]/select")));
         
         dropdown3.selectByVisibleText("Helsinki");
         
         Select dropdown2 = new Select(driver.findElement(By.xpath("//*[text()='Country of Insured *']//following::div[2]/select")));
         
         dropdown2.selectByVisibleText("Australia");
         
         Robot rb1 = new Robot();
         
         
         
         Thread.sleep(2000);
         
         rb.keyPress(KeyEvent.VK_ENTER);

         rb.keyRelease(KeyEvent.VK_ENTER);
         
       
         
         
         
         driver.findElement(By.xpath("//input[@id='Multinational_np_RadioButtonList_widget_AttrRadioButtonList_0_undefined']")).click();
	
         driver.findElement(By.xpath("//*[text()='Policy Effective Date *']//following::td[2]//div/div/input")).sendKeys("01/06/2017");	
	
          

          action.sendKeys(Keys.TAB).build().perform();
          
          //Thread.sleep(1000);
          
          action.sendKeys(Keys.TAB).build().perform();
          Thread.sleep(1000);
          Select dropdown4 = new Select(driver.findElement(By.xpath("//*[text()='Currency*']//following::td[2]//select")));
          
          dropdown4.selectByVisibleText("USD - UNITED STATES - U.S. DOLLAR");
          action.sendKeys(Keys.TAB).build().perform();
          Thread.sleep(1000);
          Select dropdown5 = new Select(driver.findElement(By.xpath("//*[text()='Chubb Risk Management Involvement *']//following::td[2]//select")));
          
          dropdown5.selectByVisibleText("Ongoing TRM involvement during the policy period");
	
          Select dropdown6 = new Select(driver.findElement(By.xpath("//*[text()='Direct / Inwards Policy *']//following::td[2]//select")));
          
          dropdown6.selectByVisibleText("Direct");
           

          action.sendKeys(Keys.TAB).build().perform();
        
          driver.findElement(By.xpath("//input[@id='FacRI_np_RadioButtonList_widget_AttrRadioButtonList_1_undefined' and @value='Yes']")).click();

          driver.findElement(By.xpath("//*[text()='Storage outside ordinary course of transit *']//following::td[2]//input[@value='Yes']")).click();
          
          Thread.sleep(2000);
          
          driver.findElement(By.xpath("//*[text()='Can Storage information be entered into model *']//following::td[2]//input[@value='Yes']")).click();
          Thread.sleep(1000);
          
          driver.findElement(By.xpath("//input[@id='ClaimsHistoryAvailable_np_RadioButtonList_widget_AttrRadioButtonList_3_undefined' and @value='Yes']")).click();

          
          
          Select dropdown7 = new Select(driver.findElement(By.xpath("//*[text()='No Claims Bonus *']//following::td[2]//select")));
          
          dropdown7.selectByVisibleText("Included");
          action.sendKeys(Keys.TAB).build().perform();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//*[text()='Bonus Percentage *']//following::td[2]//input")).sendKeys("85");
          
          Select dropdown8 = new Select(driver.findElement(By.xpath("//*[text()='Gross Net Premium *']//following::td[2]//select")));
          
          dropdown8.selectByVisibleText("Net Premium");
          action.sendKeys(Keys.TAB).build().perform();
          
          Select dropdown9 = new Select(driver.findElement(By.xpath("//*[text()='Profit Commission *']//following::td[2]//select")));
          
          dropdown9.selectByVisibleText("Included");
          action.sendKeys(Keys.TAB).build().perform();
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[text()='Profit Commission % *']//following::td[2]//input")).sendKeys("75");
          driver.findElement(By.xpath("//*[text()='Based on % of Gross Premium *']//following::td[2]//input")).sendKeys("85");
          driver.findElement(By.xpath("//*[text()='Brokerage % *']//following::td[2]//input")).sendKeys("100");
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[text()='Next']")).click();
        
          //Thread.sleep(5000);
          
          //Transit Exposure screen
          
        
          
          WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Annual/Open Cover or Single Shipment *']//following::td[2]//select")));
          
          String actualTitle = driver.getTitle();
          System.out.println(actualTitle);
         
          String expectedTitle = "Mendix - Transit Exposure";
		assertEquals(expectedTitle,actualTitle);
		
		Select dropdown21 = new Select(driver.findElement(By.xpath("//*[text()='Annual/Open Cover or Single Shipment *']//following::td[2]//select")));
        
        dropdown21.selectByVisibleText("Annual");
		
        driver.findElement(By.xpath("//*[text()='Accumulation Clause *']//following::td[2]//input[@value='Yes']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Percentage of limit (%) *']//following::td[2]//input")).sendKeys("125");
		driver.findElement(By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::td[2]//input[@value='No']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Information']//following::button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::span[3]//following::div[2]/label/input[@value='Yes']")).click();
		driver.findElement(By.xpath("//*[text()='Chubb approved Sanctions Limitation and Exclusion Clause *']//following::div[2]//input[@value='Yes']")).click();
		driver.findElement(By.xpath("//*[text()='Termination of Transit Clause (Terrorism) JC 2009/ 56 01/01/2009 *']//following::div[2]//input[@value='Yes']")).click();
		driver.findElement(By.xpath("//label[text()='Code description *']//following::button[1]")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[text()='Aggregates/rock/stone (92516)']"));
		
		action.doubleClick(element).perform();
		Select dropdown22 = new Select(driver.findElement(By.xpath("//*[text()='Selection *']//following::select[1]")));
        
        dropdown22.selectByVisibleText("Insured Value");
        
        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[2]")).sendKeys("1500000");//Amount
        action.sendKeys(Keys.TAB).build().perform();
        
        Thread.sleep(1000);
        
        
        
        Select dropdown23 = new Select(driver.findElement(By.xpath("//*[text()='Selection *']//following::select[2]")));
        
        dropdown23.selectByVisibleText("Chubb");
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()='Stowage type *']//following::div[@class='mx-name-textBox9 Factor']//following::button")).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//*[text()='Bulk']"));
		
		action.doubleClick(element1).perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[text()='Amount *']//following::input[3]")).sendKeys("30000");//Limit
		Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Amount *']//following::input[4]")).sendKeys("4000");//Deductible
		Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Next']")).click();
		
        //Claims History	
        
        WebElement myDynamicElement1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Number of years of claims history *']//following::div")));
        
        String actualTitle1 = driver.getTitle();
        System.out.println(actualTitle1);
       
        String expectedTitle1 = "Mendix - Claims History";
		assertEquals(expectedTitle1,actualTitle1);
		
		driver.findElement(By.xpath("//*[text()='Number of years of claims history *']//following::div[@class='mx-name-textBox1']/input")).sendKeys("3");
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[text()='Data as at *']//following::div[@class='mx-name-datePicker1']//input[1]")).sendKeys("15/05/2017");
        
        Thread.sleep(1000);
        Select dropdown31 = new Select(driver.findElement(By.xpath("//*[text()='Historical insured value available *']//following::div[@class='mx-name-dropDown1 Format']/select")));
        
        dropdown31.selectByVisibleText("No");
        Thread.sleep(5000);
        //WebElement myDynamicElement1A = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
        
       
        driver.findElement(By.xpath("//*[text()='Next']")).click();
	
		
		//Storage screen
        Thread.sleep(3000);
		String risk= driver.findElement(By.xpath("//td[@class='header']//preceding::td[2]//label")).getText();
		System.out.println("Printing risk id: "+risk);
		
		Select dropdown41 = new Select(driver.findElement(By.xpath("//*[text()='All Risks excl CAT']//following::td[1]/div/select")));
		dropdown41.selectByIndex(1);
		
		driver.findElement(By.xpath("//*[text()='All Risks excl CAT']//following::td[2]/div/input")).sendKeys("100000");
		
		driver.findElement(By.xpath("//*[text()='All Risks excl CAT']//following::td[3]/div/input")).sendKeys("1000");
		
		driver.findElement(By.xpath("//*[text()='All Risks excl CAT']//following::td[4]/div/input")).sendKeys("100");
		Thread.sleep(1000);
		Select dropdown42 = new Select(driver.findElement(By.xpath("//*[text()='Earthquake']//following::td[1]/div/select")));
        
        dropdown42.selectByVisibleText("Excluded");
        Select dropdown43 = new Select(driver.findElement(By.xpath("//*[text()='Windstorm']//following::td[1]/div/select")));
        
        dropdown43.selectByVisibleText("Excluded");
        Select dropdown44 = new Select(driver.findElement(By.xpath("//*[text()='Flood']//following::td[1]/div/select")));
        
        dropdown44.selectByVisibleText("Excluded");
        action.sendKeys(Keys.TAB).build().perform();
        //Locations
        Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox1']/input")).sendKeys("The Wall Street");
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox2']/input")).sendKeys("#10/A-Winston Block");
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox3']/input")).sendKeys("London");
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox4']/input")).sendKeys("05816");
		
		driver.findElement(By.xpath("//div[@class='mx-name-textBox6']//following::div[1]/button")).click();
		Thread.sleep(2000);
		WebElement element11 = driver.findElement(By.xpath("//*[text()='Austria']"));
		
		action.doubleClick(element11).perform();
		
		
		
		driver.findElement(By.xpath("//div[@class='mx-name-textBox7']//following::div[1]/button")).click();
		Thread.sleep(2000);
		WebElement element12 = driver.findElement(By.xpath("//*[text()='Animal feed (2300)']"));//Commodity Code1
		
		action.doubleClick(element12).perform();
		
		
		driver.findElement(By.xpath("//div[@class='mx-name-textBox9']//following::div[1]/button")).click();
		Thread.sleep(2000);
		WebElement element13 = driver.findElement(By.xpath("//*[text()='Air']"));//Occupancy type
		
		action.doubleClick(element13).perform();
		driver.findElement(By.xpath("//div[@class='mx-name-textBox9']//following::div[3]/button")).click();
		Thread.sleep(2000);
		WebElement element14 = driver.findElement(By.xpath("//*[text()='Masonry']"));//Construction type
		
		action.doubleClick(element14).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox7']/input")).sendKeys("200000");
		driver.findElement(By.xpath("//*[text()='Location Name']//following::div[@class='mx-name-textBox8']/input")).sendKeys("50");
	
		Select dropdown45 = new Select(driver.findElement(By.xpath("//*[text()='Earthquake *']//following::div[@class='mx-name-dropDown1']/select")));
        
        dropdown45.selectByVisibleText("Excluded");
	
        Select dropdown46 = new Select(driver.findElement(By.xpath("//*[text()='Earthquake *']//following::div[@class='mx-name-dropDown6']/select")));
        
        dropdown46.selectByVisibleText("Included");
        
        Select dropdown47 = new Select(driver.findElement(By.xpath("//*[text()='Earthquake *']//following::div[@class='mx-name-dropDown7']/select")));
        
        dropdown47.selectByVisibleText("Included");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[text()='Next']")).click();
        
        //Summary screen
        
        WebElement myDynamicElement2 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='TRANSIT  Rate (%)']//following::div[3]/input")));
        
        driver.findElement(By.xpath("//*[text()='TRANSIT  Rate (%)']//following::div[3]/input")).sendKeys("85");
        
        driver.findElement(By.xpath("//*[text()='STORAGE RATE (%)']//following::div[3]/input")).sendKeys("99");
        
        driver.findElement(By.xpath("//*[text()='Chubb Share %']//following::td[2]//input")).sendKeys("45");
        driver.findElement(By.xpath("//*[text()='FAC RI Premium *']//following::td[2]//input")).sendKeys("6000");
        
        driver.findElement(By.xpath("//*[text()='Policy Number']//following::td[2]//input")).sendKeys("9874A");//Policy Number
        
        Select dropdown51 = new Select(driver.findElement(By.xpath("//*[text()='Has this risk been Peer Reviewed? *']//following::td[1]/div/select")));
        
        dropdown51.selectByVisibleText("No");
        
        Select dropdown52 = new Select(driver.findElement(By.xpath("//*[text()='Has this risk been Referred? *']//following::td[1]/div/select")));
        
        dropdown52.selectByVisibleText("No");
        
        driver.findElement(By.xpath("//*[text()='Underwriting Rationale *']//following::div/textarea")).sendKeys("Risk has been approved");
        
        

        
	} 






	

	 

	private static void assertEquals(String string, String title) {
		// TODO Auto-generated method stub
		
	}
}



