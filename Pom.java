package Powergen;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pom {
	
	WebDriver driver;
	By userx=By.xpath("//*[text()='Login']//following::div[2]//input");
	By passx=By.xpath("//*[text()='Login']//following::div[3]//input");
	By powerx=By.xpath("//*[text()='Powergen']");
	By createx=By.xpath("//*[text()='Create New Risk']");
	By insuredx=By.xpath("//*[text()='Insured Name*']//following::td[1]//input");
	By reassuredx=By.xpath("//*[text()='Reassured Name']//following::td[1]//input");
	By locationx=By.xpath("//*[text()='Top Location*']//following::td[1]//input");
	By polcvgx=By.xpath("//*[text()='Policy Coverage*']//following::td[1]//select");
	By brokerx=By.xpath("//*[text()='Broker*']//following::td[1]//select");
	By domx=By.xpath("//*[text()='Domicile of Insured*']//following::td[1]//select");
	By currencyx=By.xpath("//*[text()='Quoting Currency*']//following::td[1]//select");
	By businesstypex=By.xpath("//*[text()='Business Type*']//following::td[1]//select");
	By branchx=By.xpath("//*[text()='Branch*']//following::td[1]//select");
	By inceptionx=By.xpath("//*[text()='Inception*']//following::td[1]//div[@class='mx-dateinput-input-wrapper']/input");
	By cogx=By.xpath("//*[text()='PD Value']//following::tr[1]//td[2]//input");
	By combx=By.xpath("//*[text()='PD Value']//following::tr[2]//td[2]//input");
	By windx=By.xpath("//*[text()='PD Value']//following::tr[9]//td[2]//input");
	By PdLossx=By.xpath("((//*[text()='Policy Limits'])[3]//following::tr//td[2]//input)[1]");
	By combLx=By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[3]//td[2]//input)[1]");
	By asx=By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[5]//td[2]//input)[1]");
	By pml1x=By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[6]//td[2]//input)[1]");
	By pml2x=By.xpath("((//*[text()='Policy Limits'])[3]//following::tr[7]//td[2]//input)[1]");
	
	public Pom(WebDriver driver) {
		this.driver=driver;
		
	}
	public void Login(String email,String pass) throws Throwable {
		
		driver.findElement(userx).sendKeys(email);
		driver.findElement(passx).sendKeys(pass);
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);

        rb.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
	public void Risk(String ins,String reas,String top,String pol,String bro,String dom,String quo,String bus,int bran,String inc) throws Throwable {
		WebElement powerWait=(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(powerx));
		WebElement powerLight=driver.findElement(powerx);
		highLightElement(driver, powerLight);
		try {
			
			driver.findElement(powerx).click();
			}catch(Exception e) {
				Thread.sleep(2000);
				
				driver.findElement(powerx).click();
			}
		WebElement createWait=(new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(createx));
				WebElement createLight=driver.findElement(createx);
				highLightElement(driver, createLight);
				driver.findElement(createx).click();
				WebElement insWait=(new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(insuredx));	
				driver.findElement(insuredx).sendKeys(ins);
				driver.findElement(reassuredx).sendKeys(reas);
				driver.findElement(locationx).sendKeys(top);
				
				Actions action = new Actions(driver);
				
				
				Select polCvgDrop=new Select(driver.findElement(polcvgx));
				polCvgDrop.selectByVisibleText(pol);
				Select brokerDrop=new Select(driver.findElement(brokerx));
				brokerDrop.selectByVisibleText(bro);
				Thread.sleep(1000);
				try {
					Select domDrop=new Select(driver.findElement(domx));
					domDrop.selectByVisibleText(dom);
				}catch(Throwable t) {
					Thread.sleep(1000);
				Select domDrop=new Select(driver.findElement(domx));
				domDrop.selectByVisibleText(dom);}
				
				Select currDrop=new Select(driver.findElement(currencyx));
				currDrop.selectByVisibleText(quo);
				 
		        action.sendKeys(Keys.TAB).build().perform();
		        Select bTypeDrop=new Select(driver.findElement(businesstypex));
				bTypeDrop.selectByVisibleText(bus);
				Select branchDrop=new Select(driver.findElement(branchx));
				branchDrop.selectByIndex(bran);
				driver.findElement(inceptionx).sendKeys(inc);
				
				 action.sendKeys(Keys.TAB).build().perform();
				 WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
				 driver.findElement(By.xpath("//*[text()='Next']")).click();
	
	}
	public void program(String cog,String comb,String wind) {
		
		WebElement progWait=(new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(cogx));
		driver.findElement(cogx).clear();
		driver.findElement(cogx).sendKeys(cog);
		driver.findElement(combx).clear();
		driver.findElement(combx).sendKeys(comb);
		driver.findElement(windx).clear();
		driver.findElement(windx).sendKeys(wind);
		WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		
	}
	
	public void polLim(String pdLoss,String combLoss,String as,String pml1,String pml2) {
		WebElement PolWait=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(PdLossx));
		
		driver.findElement(PdLossx).sendKeys(pdLoss);
		driver.findElement(combLx).clear();
		driver.findElement(combLx).sendKeys(combLoss);
		driver.findElement(asx).clear();
		driver.findElement(asx).sendKeys(as);
		driver.findElement(pml1x).clear();
		driver.findElement(pml1x).sendKeys(pml1);
		driver.findElement(pml2x).clear();
		driver.findElement(pml2x).sendKeys(pml2);
		
		WebElement nxtWait1=(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		
		
		
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
