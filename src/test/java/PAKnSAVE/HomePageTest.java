package PAKnSAVE;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.PaknSaveHomePage;
import PageObjects.SignUpPage;
import PageObjects.UserPage;
import Resources.Base;

public class HomePageTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test(dataProvider = "getData")
	public void homePageNavigation(String email, String firstName, String lastName, String phone, String password)
			throws IOException, InterruptedException {
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

		// click on Sign up
		homePage.getSignUp().click();

		// Create an instance of SignUpPage
		SignUpPage signUpPage = new SignUpPage(driver);

		// close the box
		signUpPage.getClose().click();

		// enter email in text box
		signUpPage.getEmail().sendKeys(email);

		// Explicit Wait
		WebDriverWait w = new WebDriverWait(driver, 5);

		// Wait until the continue button Enable
		w.until(ExpectedConditions.elementToBeClickable(signUpPage.getContinueBtn()));

		// click on Continue Button
		signUpPage.getContinueBtn().click();

		// enter first name in text box
		signUpPage.getFirstName().sendKeys(firstName);

		// enter last name in text box
		signUpPage.getLastName().sendKeys(lastName);

		// enter phone Number in text box
		signUpPage.getPhone().sendKeys(phone);

		// enter password in text box
		signUpPage.getPassword().sendKeys(password);

		// accept terms and condition
		signUpPage.getTerms().click();

		w.until(ExpectedConditions.elementToBeClickable(signUpPage.getSubmitBtn()));
		Thread.sleep(2000);
		// click on create account
		signUpPage.getSubmitBtn().click();
		UserPage userPage = new UserPage(driver);

		// explicite wait
		w.until(ExpectedConditions.elementToBeClickable(userPage.getUserName()));

		Assert.assertTrue(userPage.getUserName().isDisplayed());
		log.info("Successsfully validated user page");

		driver.close();
	}

	

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data ype test should run
		// coloumn stands for how many values per each test
		Object[][] data = new Object[1][5];
		data[0][0] = "test1@gma.com";
		data[0][1] = "tom";
		data[0][2] = "dad";
		data[0][3] = "02096554376";
		data[0][4] = "123abc";
		return data;
	}

}
