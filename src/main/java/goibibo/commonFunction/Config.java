package goibibo.commonFunction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Config {

	Logger log = Logger.getLogger(Config.class);
	private Properties prop;
	private FileInputStream fis;
	
	private String baseUrl;
	private String browserName;
	private String chromeDriverPath;
	private String initGrid;
	private static Config config;
	
	private Config()
	{
		readConfig();
	}
	
	public static Config getInstance()
	{
		if(config==null)
		{
			config = new Config();
			return(config);
		}
		else 
			return(config);
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getChromeDriverPath() {
		return chromeDriverPath;
	}
	public boolean isGrid() {
		return Boolean.parseBoolean(initGrid);
	}

	
	public void readConfig()
	{
		log.info("Reading properties...");
		try{
		fis = new FileInputStream("./src/test/resources/Config.properties");
		
		
		prop = new Properties();
		prop.load(fis);
		
		baseUrl = prop.getProperty("baseUrl");
		browserName = prop.getProperty("browserName");
		chromeDriverPath = prop.getProperty("chromeDriverPath");
		initGrid = prop.getProperty("isGrid");
		
		}
		catch(Exception e){
			log.error("Fail to read config file", e);
		}
		
		finally{
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error("Failed to close the file..");
				}
			if(prop!=null)
				prop.clear();
		}
		
	}
}
