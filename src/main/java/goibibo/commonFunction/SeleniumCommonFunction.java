package goibibo.commonFunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommonFunction  extends WebDriverInit
{
	
	WebDriverWait waitDriver;
	WebDriver driver;
	Config config=Config.getInstance();
	
	public SeleniumCommonFunction()
	{
	   super(); //calling base class
	   driver=getWebDriver();
	}
	/**
	 * 
	 */
	public void setDefaultImplicitWait()
	{
		// log 
		// read param 1 from config file and convert it in int in same config file  
		// parm2 , 
		//driver.manage().timeouts().implicitlyWait(pram1, TimeUnit.SECONDS);
		
		
	}
	/**
	 * 
	 * @param iWaitSecond
	 */
	public void setImplicitWait(int iWaitSecond)
	{
		
	}
	
	
	
	

}
