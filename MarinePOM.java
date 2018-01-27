package marine;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.gargoylesoftware.htmlunit.WebWindowNotFoundException;

public class MarinePOM {
	public static WebDriver driver;
	public Actions action;
	By userx=By.xpath("//*[text()='Login']//following::div[2]/input");
	By passx=By.xpath("//*[text()='Login']//following::div[3]/input");
	By insuredx=By.xpath("//*[text()='Insured Name *']//following::td[2]//input");
	By brokerx=By.xpath("//*[text()='Broker *']//following::td[2]//input");
	By regionx=By.xpath("//*[text()='Producing Region *']//following::td[2]//select");
	By countryx=By.xpath("//*[text()='Producing Country *']//following::td[2]//select");
	By countryInsx=By.xpath("//*[text()='Country of Insured *']//following::td[2]//select");
	By branchx=By.xpath("//*[text()='Branch *']//following::td[2]//select");
	By mulY=By.xpath("//*[text()='Multinational Policy *']//following::td[2]//input[@value='Yes']");
	By mulN=By.xpath("//*[text()='Multinational Policy *']//following::td[2]//input[@value='No']");
	By effectx=By.xpath("//*[text()='Policy Effective Date *']//following::td[2]//input");
	By currencyx=By.xpath("//*[text()='Currency*']//following::td[2]//select");
	By chubbriskx=By.xpath("//*[text()='Chubb Risk Management Involvement *']//following::td[2]//select");
	By directx=By.xpath("//*[text()='Direct / Inwards Policy *']//following::td[2]//select");
	By facY=By.xpath("//*[text()='FAC RI for this policy *']//following::td[2]//input[@value='Yes']");
	By facN=By.xpath("//*[text()='FAC RI for this policy *']//following::td[2]//input[@value='No']");
	By storOutx=By.xpath("//*[text()='Storage outside ordinary course of transit *']//following::td[2]//input[@value='Yes']");
	By storInfox=By.xpath("//*[text()='Can Storage information be entered into model *']//following::td[2]//input[@value='Yes']");
	By claimsx=By.xpath("//*[text()='Claims History Available *']//following::td[2]//input[@value='Yes']");
	By brox=By.xpath("//*[text()='Brokerage % *']//following::td[2]//input");
	By noClaimsx=By.xpath("//*[text()='No Claims Bonus *']//following::td[2]//select");
	By bonusPctx=By.xpath("//*[text()='Bonus Percentage *']//following::td[2]//input");
	By grossNetx=By.xpath("//*[text()='Gross Net Premium *']//following::td[2]//select");
	By profitComx=By.xpath("//*[text()='Profit Commission *']//following::td[2]//select");
	By profitComPctx=By.xpath("//*[text()='Profit Commission % *']//following::td[2]//input");
	By basedpct=By.xpath("//*[text()='Based on % of Gross Premium *']//following::td[2]//input");
	By nextx=By.xpath("//*[text()='Next']");
	By annualx=By.xpath("//*[text()='Annual/Open Cover or Single Shipment *']//following::td[2]//select");
	By accY=By.xpath("//*[text()='Accumulation Clause *']//following::td[2]//input[@value='Yes']");
	By accN=By.xpath("//*[text()='Accumulation Clause *']//following::td[2]//input[@value='No']");
	By polx=By.xpath("//*[text()='Percentage of limit (%) *']//following::td[2]//input");
	By cyberY=By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::td[2]//input[@value='Yes']");
	By cyberN=By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::td[2]//input[@value='No']");
	By radioY=By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::tr[1]//td[2]//input[@value='Yes']");
	By radioN=By.xpath("//*[text()='Institute Cyber Attack Exclusion Clause CL380 10/11/2003*']//following::tr[1]//td[2]//input[@value='No']");
	By sancY=By.xpath("//*[text()='Chubb approved Sanctions Limitation and Exclusion Clause *']//following::td[2]//input[@value='Yes']");
	By sancN=By.xpath("//*[text()='Chubb approved Sanctions Limitation and Exclusion Clause *']//following::td[2]//input[@value='No']");
	By termY=By.xpath("//*[text()='Termination of Transit Clause (Terrorism) JC 2009/ 56 01/01/2009 *']//following::td[2]//input[@value='Yes']");
	By termN=By.xpath("//*[text()='Termination of Transit Clause (Terrorism) JC 2009/ 56 01/01/2009 *']//following::td[2]//input[@value='No']");
	By codex= By.xpath("//*[text()='Code description *']//following::button[1]");
	By ccdx= By.xpath("//*[text()='Commodity Code Description']//following::div[1]//input");
	By selectionx=By.xpath("//*[text()='Selection *']//following::select[1]");
	By amtx=By.xpath("//*[text()='Amount *']//following::input[2]");
	By limitx=By.xpath("//*[text()='Limit any one shipment *']//following::input[3]");
	By dedx=By.xpath("//*[text()='Deductible *']//following::input[4]");
	By wordx=By.xpath("//*[text()='Wording source *']//following::select[2]");
	By covx=By.xpath("//*[text()='Coverage basis *']//following::button[2]");
	By stox=By.xpath("//*[text()='Coverage basis *']//following::button[3]");
	By natlx=By.xpath("//*[text()='National (less than 500mi/900km) %']//following::input[7]");
	By natgx=By.xpath("//*[text()='National (greater than 500mi/900km) %']//following::input[8]");
	By calx=By.xpath("//*[text()='Calculate/Save']");
	By noyx=By.xpath("//*[text()='Number of years of claims history *']//following::td[2]//input");
	By datex=By.xpath("//*[text()='Data as at *']//following::td[2]//input");
	By histx=By.xpath("//*[text()='Historical insured value available *']//following::td[2]//select");
	By allpx=By.xpath("//*[text()='All Risks excl CAT']//following::td[1]//select");
	By alllimx=By.xpath("//*[text()='All Risks excl CAT']//following::td[2]//input");
	By alldedx=By.xpath("//*[text()='All Risks excl CAT']//following::td[3]//input");
	By pctdedx=By.xpath("//*[text()='All Risks excl CAT']//following::td[4]//input");
	By earthx=By.xpath("//*[text()='Earthquake']//following::td[1]//select");
	By earthlimx=By.xpath("//*[text()='Earthquake']//following::td[2]//input");
	By earthdedx=By.xpath("//*[text()='Earthquake']//following::td[3]//input");
	By earthpctx=By.xpath("//*[text()='Earthquake']//following::td[4]//input");
	By windperx=By.xpath("//*[text()='Windstorm']//following::td[1]//select");
	By windlimx=By.xpath("//*[text()='Windstorm']//following::td[2]//input");
	By winddedx=By.xpath("//*[text()='Windstorm']//following::td[3]//input");
	By windpctx=By.xpath("//*[text()='Windstorm']//following::td[4]//input");
	By floodperx=By.xpath("//*[text()='Flood']//following::td[1]//select");
	By floodlimx=By.xpath("//*[text()='Flood']//following::td[2]//input");
	By flooddedx=By.xpath("//*[text()='Flood']//following::td[3]//input");
	By floodpctx=By.xpath("//*[text()='Flood']//following::td[4]//input");
	By locx=By.xpath("//*[@class='mx-name-textBox1']//input");
	By addx=By.xpath("//*[@class='mx-name-textBox2']//input");
	By cityx=By.xpath("//*[@class='mx-name-textBox3']//input");
	By postx=By.xpath("//*[@class='mx-name-textBox4']//input");
	By countyx=By.xpath("//*[@class='mx-name-textBox5']//input");
	By statex=By.xpath("//*[@class='mx-name-textBox6']//input");
	By counx=By.xpath("//*[@class='mx-name-textBox6']//following::button[1]");
	By counSrc=By.xpath("//*[text()='Country']//following::div[1]//input");
	By loclimx=By.xpath("//*[@class='mx-name-textBox7']//input");
	By com1expx=By.xpath("//*[@class='mx-name-textBox8']//input");
	By occbx=By.xpath("//*[@class='mx-name-textBox9']//following::div[1]//button");
	By consbx=By.xpath("//*[@class='mx-name-textBox9']//following::div[3]//button");
	By earthDrop=By.xpath("//*[@class='mx-name-dropDown1']//select");
	By windDrop=By.xpath("//*[@class='mx-name-dropDown6']//select");
	By floodDrop=By.xpath("//*[@class='mx-name-dropDown7']//select");
	By riskx=By.xpath("//*[text()='Risk Status *']//following::td[2]//select");
	By transx=By.xpath("//*[text()='TRANSIT  Rate (%)']//following::td[1]//input");
	By storx=By.xpath("//*[text()='STORAGE RATE (%)']//following::td[1]//input");
	By chubbsx=By.xpath("//*[text()='Chubb Share %']//following::td[2]//input");
	By polnox=By.xpath("//*[text()='Policy Number']//following::td[1]//input");
	By revx=By.xpath("//*[text()='Has this risk been Peer Reviewed? *']//following::td[1]//select");
	By whomx=By.xpath("//*[text()='By whom?']//following::td[1]//select");
	By refx=By.xpath("//*[text()='Has this risk been Referred? *']//following::td[1]//select");
	By whom2x=By.xpath("//*[text()='To whom?']//following::td[1]//select");
	By uwsx=By.xpath("//*[text()='Underwriting Rationale *']//following::textarea");
	By exitx=By.xpath("//*[text()='Exit']");
	public MarinePOM(WebDriver driver) {
		this.driver=driver;
	}
	
	public void init(String username,String password) throws AWTException {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\kkswam\\Documents\\Selenium\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kkswam\\Downloads\\chromedriver_win32\\chromedriver.exe");
				//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sit.marinecargorating.acegroup.com/");
		Robot rb = new Robot();
		try {
    		driver.findElement(By.xpath("//*[text()='Continue to this website (not recommended).']")).click();}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
		
        WebDriverWait waitLog =new WebDriverWait(driver,100);
        WebElement dynamicLog = waitLog.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Login']//following::div[2]/input")));
		
        driver.findElement(userx).sendKeys(username);
        driver.findElement(passx).sendKeys(password);
        
        try {
        rb.keyPress(KeyEvent.VK_ENTER);

        rb.keyRelease(KeyEvent.VK_ENTER);
        WebDriverWait wait =new WebDriverWait(driver,20);
        WebElement dynamic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Create New Risk']")));}
        catch(Exception e) {
        	rb.keyPress(KeyEvent.VK_ENTER);

            rb.keyRelease(KeyEvent.VK_ENTER);
            WebDriverWait wait =new WebDriverWait(driver,100);
            WebElement dynamic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Create New Risk']")));
        }
       		
        driver.findElement(By.xpath("//*[text()='Create New Risk']")).click();
        //Thread.sleep(5000);
        
        WebDriverWait waitRisk =new WebDriverWait(driver,100);
        WebElement dynamicRisk = waitRisk.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Insured Name *']//following::td[2]//input")));
	
        }
	public void riskDet(String insured,String broker,String region,String country,String branch,String countryIns,String mul,String effect) throws InterruptedException, AWTException {
	
		driver.findElement(insuredx).sendKeys(insured);
		driver.findElement(brokerx).sendKeys(broker);
		Select drop1=new Select(driver.findElement(regionx));
		drop1.selectByVisibleText(region);
		 action=new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		try {
		WebElement prodCountry=new WebDriverWait(driver, 45).until(ExpectedConditions.presenceOfElementLocated(countryx));
		Select drop2=new Select(driver.findElement(countryx));
		drop2.selectByVisibleText(country);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);}
		catch(Exception e) {
			Select drop2=new Select(driver.findElement(countryx));
			drop2.selectByVisibleText(country);
			action.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(1000);}
		
		WebElement branchWait=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated((branchx)));
		Select drop3=new Select(driver.findElement(branchx));
		drop3.selectByVisibleText(branch);
		
		Select drop4=new Select(driver.findElement(countryInsx));
		drop4.selectByVisibleText(countryIns);
		Thread.sleep(2000);
        Robot rb=new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        
        if(mul.equalsIgnoreCase("Yes")) 
        	driver.findElement(mulY).click();
        else if(mul.equalsIgnoreCase("No"))
        	driver.findElement(mulN).click();
        
        driver.findElement(effectx).sendKeys(effect);
        action.sendKeys(Keys.TAB).build().perform();
        
       WebElement drop5Wait=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(currencyx));
		
		}
	
	
	public void riskDet2(String crisk,String direct,String fac,String storOut,String storInfo,String claim,String bropct,String noClaims,String bonuspct,String gross,String profit,String profitpct,String grosspct ) throws InterruptedException {
		Select drop5=new Select(driver.findElement(currencyx));
		List<WebElement>weblist=drop5.getOptions();
		int cnt=weblist.size();
		Random run=new Random();
		int index=run.nextInt(cnt);
		drop5.selectByIndex(index);
		
		if(index==0) {
			Select drop5a=new Select(driver.findElement(currencyx));
			drop5a.selectByIndex(2);
		}
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		Select drop6=new Select(driver.findElement(chubbriskx));
		drop6.selectByVisibleText(crisk);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		Select drop7=new Select(driver.findElement(directx));
		drop7.selectByVisibleText(direct);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		if(fac.equalsIgnoreCase("Yes")) 
			driver.findElement(facY).click();
		else if(fac.equalsIgnoreCase("No"))
		driver.findElement(facN).click();
		Thread.sleep(1000);
		driver.findElement(storOutx).click();
		WebElement storWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(storInfox));
		driver.findElement(storInfox).click();
		Thread.sleep(1000);
		driver.findElement(claimsx).click();
		Select drop8=new Select(driver.findElement(noClaimsx));
		drop8.selectByVisibleText(noClaims);
		WebElement bonusWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(bonusPctx));
		driver.findElement(bonusPctx).sendKeys(bonuspct);
		Select drop9=new Select(driver.findElement(grossNetx));
		drop9.selectByVisibleText(gross);
		WebElement proWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(profitComx));
		Select drop10=new Select(driver.findElement(profitComx));
		drop10.selectByVisibleText(profit);
		WebElement proWait1=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(profitComPctx));
		driver.findElement(profitComPctx).sendKeys(profitpct);
		driver.findElement(basedpct).sendKeys(grosspct);
		Thread.sleep(1000);
		driver.findElement(brox).sendKeys(grosspct);
		WebElement nxtWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(nextx));
		driver.findElement(nextx).click();
		
		}
	
	
	public void transit(String annual,String accumulation,String pol,String cyber,String radio,String sanc,String term) throws InterruptedException {
		
		WebElement annualWait=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(annualx));
		
		Select drop21=new Select(driver.findElement(annualx));
		drop21.selectByVisibleText(annual);
		
		if(accumulation.equalsIgnoreCase("Yes")) 
		{
		driver.findElement(accY).click();
		WebElement polWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(polx));
		driver.findElement(polx).sendKeys(pol);
		}
		else if(accumulation.equalsIgnoreCase("No")) 
		driver.findElement(accN).click();
		 
		if(cyber.equalsIgnoreCase("Yes"))
			driver.findElement(cyberY).click();
		else if(cyber.equalsIgnoreCase("No")) {
			driver.findElement(cyberN).click();
		popUp();}
		
		if(radio.equalsIgnoreCase("Yes"))
			driver.findElement(radioY).click();
		else if(radio.equalsIgnoreCase("No")) {
			driver.findElement(radioN).click();
		popUp();}
		
		if(sanc.equalsIgnoreCase("Yes"))
			driver.findElement(sancY).click();
		else if(sanc.equalsIgnoreCase("No")) {
			driver.findElement(sancN).click();
		popUp();}
		
		if(term.equalsIgnoreCase("Yes"))
			driver.findElement(termY).click();
		else if(term.equalsIgnoreCase("No")) 
			driver.findElement(termN).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Information']//following::div[2]//button")).click();
		}
	
	
	public void transitInt(String ccd,String sel,String amt,String word,String limit,String deduct,String natl,String natg) throws InterruptedException {
		WebElement codeWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(codex));
		driver.findElement(codex).click();
		WebElement ccdWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(ccdx));
		driver.findElement(ccdx).sendKeys(ccd);
		driver.findElement(By.xpath("//*[text()='Search']")).click();
		WebElement ccd1=driver.findElement(By.xpath("//*[text()='CommodityCode Description']//following::tr[1]//div"));
		action.doubleClick(ccd1).build().perform();
		popUp();
		
		Select drop22=new Select(driver.findElement(selectionx));
		drop22.selectByVisibleText(sel);
		driver.findElement(amtx).sendKeys(amt);
		Select drop23=new Select(driver.findElement(wordx));
		drop23.selectByVisibleText(word);
		
		driver.findElement(covx).click();
		WebElement covbasWait=new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='CoverageBasis']")));
		WebElement covval=driver.findElement(By.xpath("//*[text()='Bulk Oil Cls incl contamination']"));
		action.doubleClick(covval).build().perform();
		
		driver.findElement(stox).click();
		WebElement stoWait=new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Stowage Type']")));
		WebElement stoval=driver.findElement(By.xpath("//*[text()='On deck']"));
		action.doubleClick(stoval).build().perform();
		
		driver.findElement(limitx).sendKeys(limit);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		driver.findElement(dedx).sendKeys(deduct);
		driver.findElement(natlx).click();
		driver.findElement(natlx).sendKeys(natl);
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(natgx).clear();
		Thread.sleep(1000);
		driver.findElement(natgx).sendKeys(natg);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		driver.findElement(calx).click();
		Thread.sleep(4000);
		try {
		popError();
		String error1=driver.findElement(By.xpath("(//*[text()='The sum of the above fields cannot be greater than 100'])[2]")).getText();
		Assert.assertEquals(error1, "The sum of the above fields cannot be greater than 100");
		driver.findElement(natlx).clear();
		driver.findElement(natlx).sendKeys("30");
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(natgx).clear();
		driver.findElement(natgx).sendKeys("40");
		Thread.sleep(1000);
		driver.findElement(calx).click();
		Thread.sleep(6000);
		driver.findElement(nextx).click();
		}
		catch(Exception e) {
		e.printStackTrace();}
		driver.findElement(nextx).click();
		
		}
	
	
	public void claims(String noy,String date,String hist) throws InterruptedException {
		//WebElement claimsWait=new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(noyx));
		Thread.sleep(6000);
		driver.findElement(noyx).sendKeys(noy);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
		driver.findElement(datex).sendKeys(date);
		action=new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		Select drop31=new Select(driver.findElement(histx));
		drop31.selectByVisibleText(hist);
		
		 try {
	        	Thread.sleep(6000);
	        	 driver.findElement(By.xpath("//*[text()='Next']")).click();
	        	 WebElement dynamicStore = (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All Risks excl CAT']//following::td[1]/div/select")));
	        	 
	        }catch(Exception e) {
	        	Thread.sleep(4000);
	        	 driver.findElement(By.xpath("//*[text()='Next']")).click();
	        	 WebElement dynamicStore = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All Risks excl CAT']//following::td[1]/div/select")));
	        
	        }
		}
	
	
	public void storage(String allp,String alllim,String allded,String pctded,String earth,String earthlim,String earthded,String earthpct,String wind,String windlim,String windded,String windpct,String flood,String floodlim,String floodded,String floodpct) throws InterruptedException {
		WebElement storWait=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(allpx));
		//All Risks excluding CAT
		if(allp.equalsIgnoreCase("Included")) {
			
		Select drop41=new Select(driver.findElement(allpx));
		drop41.selectByVisibleText(allp);
		Thread.sleep(1000);
		driver.findElement(pctdedx).clear();
		driver.findElement(pctdedx).sendKeys(pctded);
		driver.findElement(alllimx).sendKeys(alllim);
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(alldedx).sendKeys(allded);
		driver.findElement(pctdedx).clear();
		driver.findElement(pctdedx).sendKeys(pctded);
		Thread.sleep(1000);
		
			}
	else if(allp.equalsIgnoreCase("Excluded"))
	{
		Select drop41=new Select(driver.findElement(allpx));
		drop41.selectByVisibleText(allp);}
		//Earthquake
		if(earth.equalsIgnoreCase("Included")) {
			
			Select drop41=new Select(driver.findElement(earthx));
			drop41.selectByVisibleText(earth);
			Thread.sleep(1000);
			driver.findElement(earthpctx).clear();
			driver.findElement(earthpctx).sendKeys(earthpct);
			driver.findElement(earthlimx).sendKeys(earthlim);
			action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(earthdedx).sendKeys(earthded);
			driver.findElement(earthpctx).clear();
			driver.findElement(earthpctx).sendKeys(earthpct);
			Thread.sleep(1000);
			
				}
		else if(earth.equalsIgnoreCase("Excluded"))
		{
			Select drop41=new Select(driver.findElement(earthx));
			drop41.selectByVisibleText(earth);}
		//Windstorm
		if(wind.equalsIgnoreCase("Included")) {
			
			Select drop41=new Select(driver.findElement(windperx));
			drop41.selectByVisibleText(earth);
			Thread.sleep(1000);
			driver.findElement(windpctx).clear();
			driver.findElement(windpctx).sendKeys(windpct);
			driver.findElement(windlimx).sendKeys(windlim);
			action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(winddedx).sendKeys(windded);
			driver.findElement(windpctx).clear();
			driver.findElement(windpctx).sendKeys(windpct);
			Thread.sleep(1000);
				}
		else if(wind.equalsIgnoreCase("Excluded"))
		{
			Select drop41=new Select(driver.findElement(windperx));
			drop41.selectByVisibleText(wind);}
		//Flood
		if(flood.equalsIgnoreCase("Included")) {
			
			Select drop41=new Select(driver.findElement(floodperx));
			drop41.selectByVisibleText(flood);
			Thread.sleep(1000);
			driver.findElement(floodpctx).clear();
			driver.findElement(floodpctx).sendKeys(floodpct);
			driver.findElement(floodlimx).sendKeys(floodlim);
			action.sendKeys(Keys.TAB).build().perform();
			driver.findElement(flooddedx).sendKeys(floodded);
			driver.findElement(floodpctx).clear();
			driver.findElement(floodpctx).sendKeys(floodpct);
			action.sendKeys(Keys.TAB).build().perform();
				}
		else if(flood.equalsIgnoreCase("Excluded"))
		{
			Select drop41=new Select(driver.findElement(floodperx));
			drop41.selectByVisibleText(flood);}
		
	}
	
	public void storage2(String loc,String add,String city,String post,String county,String state,String coun,String loclim,String com1exp,String Earth,String Wind,String Flood) throws InterruptedException {
		driver.findElement(locx).sendKeys(loc);
		driver.findElement(addx).sendKeys(add);
		driver.findElement(cityx).sendKeys(city);
		driver.findElement(postx).sendKeys(post);
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(countyx).clear();
		driver.findElement(countyx).sendKeys(county);
		driver.findElement(statex).clear();
		driver.findElement(statex).sendKeys(state);
		Thread.sleep(1000);
		driver.findElement(counx).click();
		WebElement counWait=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(counSrc));
		driver.findElement(counSrc).sendKeys(coun);
		driver.findElement(By.xpath("//*[text()='Search']")).click();
		Thread.sleep(1000);
		WebElement country=driver.findElement(By.xpath("(//*[text()='Country'])[2]//following::td[1]/div"));
		action.doubleClick(country).build().perform();
		driver.findElement(loclimx).sendKeys(loclim);
		driver.findElement(com1expx).sendKeys(com1exp);
		driver.findElement(occbx).click();
		WebElement occWait=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Description']//following::td[1]//div")));
		WebElement occtype=driver.findElement(By.xpath("//*[text()='Description']//following::td[1]//div"));
		action.doubleClick(occtype).build().perform();
		Thread.sleep(500);
		driver.findElement(consbx).click();
		WebElement consWait=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Light Metal Frame']")));
		WebElement constype=driver.findElement(By.xpath("//*[text()='Light Metal Frame']"));
		action.doubleClick(constype).build().perform();
		
	Select earthd=new Select(driver.findElement(earthDrop));
	earthd.selectByVisibleText(Earth);
	Select windd=new Select(driver.findElement(windDrop));
	windd.selectByVisibleText(Wind);
	Select floodd=new Select(driver.findElement(floodDrop));
	floodd.selectByVisibleText(Flood);
	driver.findElement(nextx).click();
	
	}
	public void sum(String stat,String trans,String stor,String chubbs,String polno,String rev,String byWhom,String ref,String toWhom,String uws) throws InterruptedException {
		WebElement riskStatus=new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(riskx));
		Select riskSel=new Select(driver.findElement(riskx));
		riskSel.selectByVisibleText(stat);
		WebElement infoWait=new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='modal-body mx-dialog-body']")));
		WebElement infoPop=driver.findElement(By.xpath("//*[@class='modal-body mx-dialog-body']"));
		popUp();
		driver.findElement(transx).sendKeys(trans);
		driver.findElement(storx).sendKeys(stor);
		driver.findElement(chubbsx).sendKeys(chubbs);
		driver.findElement(polnox).sendKeys(polno);
		
		if(rev.equalsIgnoreCase("Yes")) {
			Select revSel=new Select(driver.findElement(revx));
			revSel.selectByVisibleText(rev);
			WebElement byWait=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(whomx));
			Select whomSel=new Select(driver.findElement(whomx));
			whomSel.selectByVisibleText(byWhom);
			}else if(rev.equalsIgnoreCase("No")) {
				Select revSel=new Select(driver.findElement(revx));
				revSel.selectByVisibleText(rev);
			}
		
		if(ref.equalsIgnoreCase("Yes")) {
			Select refSel=new Select(driver.findElement(refx));
			refSel.selectByVisibleText(ref);
			WebElement toWait=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(whom2x));
			Select whomSel=new Select(driver.findElement(whom2x));
			whomSel.selectByVisibleText(toWhom);
			}else if(ref.equalsIgnoreCase("No")) {
				Select refSel=new Select(driver.findElement(refx));
				refSel.selectByVisibleText(ref);
			}
		driver.findElement(uwsx).sendKeys(uws);
		Select riskSel2=new Select(driver.findElement(riskx));
		riskSel.selectByVisibleText(stat);
		driver.findElement(calx).click();
		Thread.sleep(6000);
		driver.findElement(exitx).click();
		WebElement exitWait=new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mx-text mx-name-text1']")));
		driver.findElement(By.xpath("(//*[text()='Yes'])[3]")).click();
		
	}
	public void popUp() {
		
		WebElement popWait=new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Information']")));
		//driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[text()='Information']//following::div[2]//button")).click();
		
	}
	public void popError() {
		WebElement popWait=new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Error']")));
		driver.findElement(By.xpath("//*[text()='Error']//following::div[2]//button")).click();
	}
}
