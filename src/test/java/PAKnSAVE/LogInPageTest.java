package PAKnSAVE;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.PaknSaveHomePage;
import Resources.Base;

public class LogInPageTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test(dataProvider = "getData")
	public void loginPageNavigation(String email, String password) throws IOException {
		// initialize driver
		driver = initializeDriver();
		log.info("driver is initialized");

		// navigate to the PAKnSAVE WebSite URL

		driver.get(prop.getProperty("url"));
		log.info("navigate to home page");
		// maximize the window
		driver.manage().window().maximize();
		log.info("maximixe window");

		// Create an instance of PaknSaveHomePage
		PaknSaveHomePage homePage = new PaknSaveHomePage(driver);

		// click on Login or register
		homePage.getLogInOrRegister().click();

		// enter email id
		homePage.getEmail().sendKeys(email);

		// enter password
		homePage.getPassword().sendKeys(password);

		// click on LogIn button
		homePage.getLogInBtn().click();

		driver.close();
	}

	

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data ype test should run
		// coloumn stands for how many values per each test
		Object[][] data = new Object[1][2];
		data[0][0] = "test1@gma.com";
		data[0][1] = "123abc";
		return data;
	}
}
