package Powergen;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class RenewalPower {
	public   WebDriver driver ;
	@Test(priority=1)
	public void dashboard(WebDriver driver,String core) throws InterruptedException {
		
		
		
		String core1=driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div")).getText();
		
		String core2=driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[2]//td[1]/div")).getText();
		System.out.println("Core 1 is :"+core1+"Core 2 is :"+core2);
		if(core1.equalsIgnoreCase(core)) {
			driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div")).click();
		}
		else if(core2.equalsIgnoreCase(core))  {
			driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[2]//td[1]/div")).click();
		}
		driver.findElement(By.xpath("//*[text()='Renew']")).click();
		
		WebElement infoWait=new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Information']")));
		String warnMsg=driver.findElement(By.xpath("//*[text()='Information']//following::div[1]/p")).getText();
		Assert.assertTrue(warnMsg.contains("Status of this Risk is not Bound. Please revisit the risk and mark it as Bound in the Risk Information page."));
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		
		if(core1.equalsIgnoreCase(core)) {
			driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div")).click();
		}
		else if(core2.equalsIgnoreCase(core))  {
			driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[2]//td[1]/div")).click();
		}
		
		driver.findElement(By.xpath("//*[text()='Edit']")).click();
		WebElement polWait=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Policy Number*']//following::td[1]//input")));
		driver.findElement(By.xpath("//*[text()='Policy Number*']//following::td[1]//input")).sendKeys("QW098/456");
		Select statusWait=new Select(driver.findElement(By.xpath("//*[text()='Policy Status*']//following::td[1]//select")));
		statusWait.selectByVisibleText("Bound");
		
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		
		WebElement infoWaitS=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Information']")));
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Calculate']")).click();
		Thread.sleep(4000);
		try {
		driver.findElement(By.xpath("//*[text()='Exit']")).click();}
		catch(Throwable t) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Exit']")).click();	}
			
			WebElement dashWait=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div")));

			/*if(core1.equalsIgnoreCase(core)) {
				driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div")).click();
			}
			else if(core2.equalsIgnoreCase(core))  {
				driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[2]//td[1]/div")).click();
			}*/
			
			driver.findElement(By.xpath("//*[text()='Renew']")).click();
			WebElement Insr1Wait=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Insured Name*']//following::td[1]//input")));
			
			
		}
		@Test(priority=2)
		public void GeneralR(WebDriver driver) throws Throwable {
			
			
			driver.findElement(By.xpath("//*[text()='Insured Name*']//following::td[1]//input")).clear();
			driver.findElement(By.xpath("//*[text()='Insured Name*']//following::td[1]//input")).sendKeys("Village Chemicals & Pesticides Ltd.");
		
			Actions action = new Actions(driver);
			
			Select polCvgDrop=new Select(driver.findElement(By.xpath("//*[text()='Policy Coverage*']//following::td[1]//select")));
			polCvgDrop.selectByVisibleText("All Risks with BI");
			Select domDrop=new Select(driver.findElement(By.xpath("//*[text()='Domicile of Insured*']//following::td[1]//select")));
			domDrop.selectByVisibleText("Denmark");
			WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement tivWait=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Single Location']//following::tr[6]/td[1]//select")));
		
			Select risk4Drop=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[6]/td[1]//select")));
			risk4Drop.selectByIndex(7);
			Select man4Drop=new Select(driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[6]/td[2]//select")));
			man4Drop.selectByIndex(15);
			
			driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[6]/td[3]//input")).sendKeys("75000");
			driver.findElement(By.xpath("//*[text()='Single Location']//following::tr[6]/td[4]//input")).sendKeys("1500");
			driver.findElement(By.xpath("//*[text()='Sum Insured BI (Annual)*']//following::td[1]//input")).sendKeys("650000");
			driver.findElement(By.xpath("(//*[text()='Sum Insured BI (Annual)*']//following::td//input)[2]")).sendKeys("350000");
			
			WebElement nxtWait2=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement Wait3=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[1]")));
			
			WebElement nxtWait3=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement Wait4=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Earthquake']//following::td[2]//input")));
			
			
			driver.findElement(By.xpath("//*[text()='Other Sublimit 2']//following::td[1]//input")).clear();
			driver.findElement(By.xpath("//*[text()='Other Sublimit 2']//following::td[1]//input")).sendKeys("Sublimit2");
			driver.findElement(By.xpath("//*[text()='Other Sublimit 2']//following::td[2]//input")).sendKeys("152000");
			
			WebElement nxtWait5=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			 driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement Wait5=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='PD*']//following::td[2]//input")));
			
			driver.findElement(By.xpath("//*[text()='Wind']//following::td[2]//input")).sendKeys("55");
			action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.xpath("//*[text()='Wind']//following::td[5]//input")).click();
			driver.findElement(By.xpath("//*[text()='Other Deductible 1']//following::td[1]//input")).clear();
			driver.findElement(By.xpath("//*[text()='Other Deductible 1']//following::td[1]//input")).sendKeys("Deductible1");
			driver.findElement(By.xpath("//*[text()='Other Deductible 1']//following::td[2]//input")).sendKeys("45000");
			
			WebElement nxtWait6=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			 driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement Wait6=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Commission']//following::td[1]//input")));
		
			driver.findElement(By.xpath("//*[text()='Location']//following::td[1]//input")).clear();
			driver.findElement(By.xpath("//*[text()='Location']//following::td[1]//input")).sendKeys("-98");
			driver.findElement(By.xpath("//*[text()='No Claims Discount']//following::td[1]//input")).click();
			driver.findElement(By.xpath("//*[text()='No Claims Discount']//following::td[1]//input")).clear();
			driver.findElement(By.xpath("//*[text()='No Claims Discount']//following::td[1]//input")).sendKeys("-74");
			
			WebElement nxtWait7=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			 driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement Wait7=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Losses As At Date*']//following::td[1]//input")));
		
			driver.findElement(By.xpath("(//*[text()='Year']//following::tr[2])[1]//td[3]//input")).sendKeys("100000");
			driver.findElement(By.xpath("(//*[text()='Year']//following::tr[2])[1]//td[4]//input")).sendKeys("50000");
			JavascriptExecutor je=(JavascriptExecutor)driver;
			WebElement element=driver.findElement(By.xpath("(//*[text()='Year']//following::tr[1])[2]//td[3]//input"));
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			driver.findElement(By.xpath("(//*[text()='Year']//following::tr[1])[2]//td[3]//input")).click();
			driver.findElement(By.xpath("(//*[text()='Year']//following::tr[1])[2]//td[3]//input")).sendKeys("100000");
			driver.findElement(By.xpath("(//*[text()='Year']//following::tr[1])[2]//td[4]//input")).sendKeys("50000");
		
			WebElement nxtWait8=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			WebElement Wait8=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Loaded*']//following::td[1]//input")));
		
			WebElement nxtWait9=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	 		driver.findElement(By.xpath("//*[text()='Next']")).click();
	 		WebElement Wait9=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Net Validated Rate Change*']//following::td[1]//input")));
		
	 		driver.findElement(By.xpath("//*[text()='Net Validated Rate Change*']//following::td[1]//input")).sendKeys("47");
	 		driver.findElement(By.xpath("//*[text()='Comment on Validated Rate Change*']//following::td[1]//textarea")).click();
	 		driver.findElement(By.xpath("//*[text()='Comment on Validated Rate Change*']//following::td[1]//textarea")).sendKeys("Rate change was Validated successfully and has been notified to the client");
		
			WebElement nxtWait10=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
	 		driver.findElement(By.xpath("//*[text()='Next']")).click();
	 		WebElement Wait10=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='1'])[1]//following::td[1]//input")));
		
	 		driver.findElement(By.xpath("//*[text()='Next']")).click();
	 		WebElement Wait11=(new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form-control mx-textarea-input']")));
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
			
			String core1=driver.findElement(By.xpath("//*[text()='Core ID']//following::td[1]//label")).getText();
			
			System.out.println("Risk id of Renewal is :"+" "+core1);
			driver.findElement(By.xpath("//*[text()='Exit']")).click();
			Thread.sleep(2000);
			WebElement coreLight=driver.findElement(By.xpath("(//*[text()='Core ID'])[2]//following::tr[1]//td[1]/div"));
			PowerNG r=new PowerNG();
			r.highLightElement(driver, coreLight);
			r.captureScreenshot(driver, core1);
		
		
		}
		
		
	
	
	
	}


