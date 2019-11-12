package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	//Declare WebDriver as global variable
	public static WebDriver driver;
	
	//Declare Properties as global variable
	public Properties prop;
	
	//Declare FileInputStream as global variable
	public FileInputStream propFile;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		
		//get data.properties file
		propFile = new FileInputStream(
				"H:\\Selenium\\SeleniumWorkSpace\\PAKnSAVEWebSite\\src\\main\\java\\Resources\\data.properties");
		//load data.properties file
		prop.load(propFile);
		
		//get value of browser key from data.properties file
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			//chrome driver information
			System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\SeleniumWorkSpace\\chromedriver.exe");
			
			//initialize Chrome driver
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			
			//initialize Firefox driver
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			
			//initialize Internet explorer driver
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenshot(String result) throws IOException {
		// driver=initializeDriver();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("H://Selenium/SeleniumWorkSpace/PAKnSAVEWebSite/ScreenShot/" + result + "screenshot.png"));

	}
}
