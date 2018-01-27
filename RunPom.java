package Powergen;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class RunPom {
	

  @Test(priority=15,description="Executing for Login")
  public void LoginPG () throws Throwable {
	  System.setProperty("webdriver.ie.driver", "C:\\Users\\kkswam\\Documents\\Selenium\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
	  WebDriver driver=new InternetExplorerDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("http://uat.powergenrating.acegroup.com:8088/");
	  
	Pom p=new Pom(driver);
	try {
	p.Login("testing@abc.com", "Power123");}
	catch(Throwable t) {
		Thread.sleep(2000);
		p.Login("testing@abc.com", "Power123");
	}	
	p.Risk("Michael Martin","John Smith","Australia","MB Only","Aca","Algeria","EUROPE - EUR - EURO","Program",1,"01/07/2017");
	p.program("6500", "7500", "15000");  
	p.polLim("56000", "54780", "60000","50000","12354");
	PowerNG1 ob=new PowerNG1(driver);
	ob.subLimits();
	ob.deductible();
	ob.loadingAndDiscounts();
	ob.lossesScreen();
	ob.premiumScreen();
	ob.facultative();
	ob.comments();
	ob.peerReview();
	
  }
  @AfterTest
  public void afterTest() {
  }

}
