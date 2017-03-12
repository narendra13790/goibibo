package goibibo.commonFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.log4testng.Logger;

public class WebDriverInit {
	
	private WebDriver driver;
	private Config config;
	
	Logger log= Logger.getLogger(WebDriverInit.class);
	
	//DesiredCapabilities - for all browser
	//FirefoxProfile - firefox
	// windo
	
	
	public WebDriverInit()
	{
		config = Config.getInstance();
		// initializing the web driver
		initWebdriver(config.getBrowserName());
	}
	
	public WebDriver getWebDriver()
	{
		if(driver==null){
			initWebdriver(config.getBrowserName());
			return driver;
		}
		else
			return driver;
	}

	private void initWebdriver(String browserName)
	{
		log.info("initailizing the web driver for browser :"+config.getBrowserName());
		try
		{
			if(driver==null)
			{
				if (browserName.equalsIgnoreCase(Constant.firefoxbrowser)) 
				{
					   driver = new FirefoxDriver();
							
				} 
				else if (browserName.equalsIgnoreCase(Constant.chromebrowser))
				{
					   System.setProperty("webdriver.chrome.driver",config.getChromeDriverPath());
					   driver = new ChromeDriver();	
			    }
				else if (browserName.equalsIgnoreCase(Constant.IEbrowser))
				{
					  // change according to IE
					   System.setProperty("webdriver.chrome.driver",config.getChromeDriverPath());
					   driver = new ChromeDriver();	
			    }
				else
				{
					log.error("Unknown browser name :"+config.getBrowserName());
				}
				
				if(driver!=null)
				{
					// maximize the window
				}
			}
		} 
		catch (Exception e)
		{
			log.error("Failed to initialize the web driver !!.",e);
		}
			
	}
	
	public void initSeleniumGrid()
	{
		
		if(config.isGrid())
		{
			
			log.info("Initializing the sremote web driver for node :");
			
		}
		
	}
}
